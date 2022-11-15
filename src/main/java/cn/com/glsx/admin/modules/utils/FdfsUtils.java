package cn.com.glsx.admin.modules.utils;

import cn.com.glsx.admin.config.FdfsPropertyConfig;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;


/**
 * FastDFS 文件操作工具类
 *
 * @author yll
 */
@Component
public class FdfsUtils {
    private static final String FDFS_DOMAIN_PROP = "tracker-nginx-domain";
    private static final String DOMAIN_SEPARATOR = "/";

    private static final Logger logger = LoggerFactory.getLogger(FdfsUtils.class);
    private static FdfsPropertyConfig fdfsPropertyConfig;
    private static FastFileStorageClient storageClient;

    public static String uploadFile(MultipartFile multipartFile) throws IOException {
        String fileUrl;
        InputStream inputStream = multipartFile.getInputStream();
        long fileSize = multipartFile.getSize();
        String fileExtension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        StorePath storePath = storageClient.uploadFile(inputStream, fileSize, fileExtension,
                null);
        fileUrl = getFileUrl(storePath);
        return fileUrl;
    }

    public static String uploadFile(byte[] bytes, String fileExtension) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        StorePath storePath = storageClient.uploadFile(inputStream, bytes.length, fileExtension,
                null);
        return getFileUrl(storePath);
    }

    public static String uploadFile(InputStream inputStream, String fileExtension)
            throws IOException {
        StorePath storePath = storageClient.uploadFile(inputStream, inputStream.available(),
                fileExtension, null);
        return getFileUrl(storePath);
    }

    public static void deleteFile(String fileUrl) {
        if (StringUtils.isNoneBlank(fileUrl)) {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        }
    }

    private static String getFileUrl(StorePath storePath) {
        String domain = fdfsPropertyConfig.getTrackerNginxDomain();
        logger.info("domain == " + domain);
        return domain + DOMAIN_SEPARATOR + storePath.getFullPath();
    }

    @Autowired
    public void setFdfsProperty(FdfsPropertyConfig fdfsPropertyConfig) {
        FdfsUtils.fdfsPropertyConfig = fdfsPropertyConfig;
    }

    @Autowired
    public void setStorageClient(FastFileStorageClient storageClient) {
        FdfsUtils.storageClient = storageClient;
    }

    public static String getFileName(String desName) {
        return desName + DateUtil.formatSerial(new Date());
    }
}
