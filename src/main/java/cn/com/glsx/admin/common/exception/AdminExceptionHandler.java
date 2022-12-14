package cn.com.glsx.admin.common.exception;

import cn.com.glsx.admin.common.enums.ResultEnum;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.glsx.plat.core.web.R;
import com.glsx.plat.exception.ExceptionLevel;
import com.glsx.plat.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.BindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author payu
 */
@Slf4j
@RestControllerAdvice
public class AdminExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(AdminException.class)
    public R handleAdminException(AdminException e) {
        return R.error(e.getErrorCode(), e.getMessage());
    }

    /**
     * 引入Feign服务的话
     *
     * @param e
     * @return
     */
//    @ExceptionHandler(FeignException.class)
//    public R handleFeignException(FeignException e) {
//        return R.error(e.status(), e.getMessage());
//    }

    /**
     * Mybatis BindingException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindingException.class)
    public R handleBindingException(BindingException e) {
        return R.error(e.getMessage());
    }

    @ExceptionHandler(ExcelAnalysisException.class)
    public R handleExcelAnalysisException(ExcelAnalysisException e) {
        if (e.getCause() instanceof AdminException) {
            AdminException exp = (AdminException) e.getCause();
            return R.error(exp.getErrorCode(), exp.getMessage());
        }
        return R.error(ResultEnum.PARSE_EXCEL_ERROR.getMessage());
    }

    @ExceptionHandler(ExcelDataConvertException.class)
    public R handleExcelDataConvertException(ExcelDataConvertException e) {
        return R.error(e.getMessage());
    }

    @Override
    protected void saveException(Exception e, ExceptionLevel level) {
        super.saveException(e, level);
    }

}
