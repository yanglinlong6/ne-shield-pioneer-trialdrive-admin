package cn.com.glsx.admin.modules.utils;

import cn.com.glsx.admin.common.enums.ResultEnum;
import cn.com.glsx.admin.common.exception.AdminException;
import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 项目名:ne-shield-trialdrive-admin
 * 包名: cn.com.glsx.admin.modules.utils
 * 作者: Yanglinlong
 * 日期: 2021/5/18 14:23
 */
@Slf4j
public class FileIOUtil {

    public enum MimeType {
        STREAM("application/octet-stream", "jpg"),

        PDF("application/pdf", "pdf"),
        ZIP("application/zip", "zip"),
        RAR("application/zip", "rar"),
        EXCEL2003("application/vnd.ms-excel", "xls"),
        EXCEL2007("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx"),
        EXE("application/octet-stream", "exe"),

        TXT("text/plain", "txt"),
        JAVA("text/plain", "java"),
        PYTHON("text/plain", "py"),
        JAVASCRIPT("text/plain", "js"),
        CSS("text/plain", "css"),

        JPG("application/x-jpg", "jpg"),
        JPEG("image/jpeg", "jpg"),
        GIF("image/gif", "gif"),
        PNG("application/x-png", "png");
        private String contentType;
        public final static String CHARSET = "UTF-8";
        private String suffix;

        public String getContentType() {
            return contentType + ";charset=" + CHARSET;
        }

        private MimeType(String contentType, String suffix) {
            this.contentType = contentType;
            this.suffix = suffix;
        }

        public static String getMimeSuffix(String contentType) {
            for (MimeType mimeType : MimeType.values()) {
                if (mimeType.getContentType().equals(contentType)) {
                    return mimeType.getSuffix();
                }
            }
            return null;
        }

        public String getSuffix() {
            return suffix;
        }
    }

    public static void download(InputStream input, MimeType mime, String fileName, HttpServletResponse response) throws IOException {
        if (input == null) {
            return;
        }
        response.setContentType(mime.getContentType());
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        String encodeFileName = fileName + "." + mime.getSuffix();
        response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(encodeFileName, "UTF-8"));
        long length = input.available();

        if (length != -1) {
            response.setContentLength((int) length);
        }
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(input, output);
        output.flush();
    }

    /**
     * 从服务器上下载失败的excel文件
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static InputStream downloadFailFile(String filePath, String fileName) throws FileNotFoundException {

        File file = new File(filePath, fileName);
        if (!file.exists()) {
            throw new AdminException(ResultEnum.IMPORT_FAIL_NOT_FOUND);
        }
        InputStream inputStream = new FileInputStream(file);
        return inputStream;
    }

    /**
     * 获取文件的类型
     *
     * @param multipartFile
     * @return
     */
    public static String getMultipartFileType(MultipartFile multipartFile) {
        if (multipartFile == null) {
            return null;
        }
        String contentType = multipartFile.getContentType();
        return MimeType.getMimeSuffix(contentType);
    }

    /**
     * 导出文件到直指定路径
     *
     * @param path
     * @param tList
     * @param <T>
     * @return
     */
    public static <T> String exportFailRecord(String path, List<T> tList) {
        if (CollectionUtils.isEmpty(tList)) {
            return null;
        }
        String seqNo = System.currentTimeMillis() + "";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //清除30天之前的缓存文件
        cleanExpiredFiles(file, 60);
        // OutputStream outputStream = null;
        try {
            String filePath = path + "/" + seqNo + ".xlsx";
            log.info("生成失败文件，path:" + filePath);
            // outputStream = new FileOutputStream(filePath);
            // WriteWorkbook writeWorkbook = new WriteWorkbook();
            // writeWorkbook.setOutputStream(outputStream);
            // writeWorkbook.setExcelType(ExcelTypeEnum.XLSX);
            // ExcelWriter excelWriter = new ExcelWriter(writeWorkbook);
            // WriteSheet writeSheet = new WriteSheet();
            // writeSheet.setSheetName("sheet");
            // excelWriter.write(tList, writeSheet);
            // excelWriter.finish();
            // outputStream.flush();
            Class<?> aClass = tList.get(0).getClass();
            //方式一：
            // Class<T> clzz = (Class<T>)((ParameterizedType)).getActualTypeArguments()[0];
            EasyExcel.write(filePath, aClass).sheet("sheet2").doWrite(tList);
            // 方式二：
            // ExcelWriter excelWriter2 = EasyExcel.write(filePath, clzz).build();
            // WriteSheet writeSheet2 = EasyExcel.writerSheet("写入方法二").build();
            // excelWriter2.write(tList, new WriteSheet());
            // excelWriter2.finish();

            log.info("生成文件成功。");
        } catch (Exception e) {
            log.info("写入失败文件异常。message：" + e.getMessage());
            e.printStackTrace();
        }
        return seqNo;
    }

    /**
     * 清除过期文件
     *
     * @param dir
     * @param expiredDays
     */
    public static void cleanExpiredFiles(File dir, int expiredDays) {
        if (!dir.exists()) {
            return;
        }
        //清除 expiredDays 天之前的垃圾文件
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                long lastModified = pathname.lastModified();
                long interval = DateUtil.interval(lastModified, System.currentTimeMillis(), TimeUnit.DAYS);
                if (interval >= expiredDays) {
                    return true;
                }
                return false;
            }
        });
        if (!ArrayUtils.isEmpty(files)) {
            for (File file : files) {
                file.delete();
            }
        }
    }
}
