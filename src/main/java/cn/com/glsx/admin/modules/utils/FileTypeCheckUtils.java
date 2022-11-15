package cn.com.glsx.admin.modules.utils;

import cn.com.glsx.admin.common.util.fileupload.FileConstants;
import com.glsx.plat.common.utils.StringUtils;

/**
 * @author Yanglinlong
 * @date 2022/3/28 11:24
 */
public class FileTypeCheckUtils {

    /**
     * 根据文件名 校验文件类型
     *
     * @param originalFilename 文件名
     * @return 是否是表格文件
     */
    public static Boolean verifyFileType(String originalFilename) {
        if (StringUtils.isNotEmpty(originalFilename)) {
            String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            return !(substring.equals(FileConstants.EXCEL_TYPE_XLSX) || substring.equals(FileConstants.EXCEL_TYPE_XLS));
        }
        return false;
    }
}
