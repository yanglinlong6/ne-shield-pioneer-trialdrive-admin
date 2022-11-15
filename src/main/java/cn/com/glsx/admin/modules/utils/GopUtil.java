/**
 * 版权声明：深圳市广联赛讯有限公司 版权所有 违者必究 2012
 * 日    期：12-6-2
 */
package cn.com.glsx.admin.modules.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 徐少敏
 * @version 1.0
 */
public class GopUtil {

    /**
     * 使用<code>secret</code>对paramValues按以下算法进行签名： <br/>
     * uppercase(hex(sha1(secretkey1value1key2value2...secret))
     *
     * @param paramValues 参数列表
     * @param secret
     * @return
     */
    public static String sign(Map<String, Object> paramValues, String secret) {
        return sign(paramValues, null, secret);
    }

    /**
     * 对paramValues进行签名，其中ignoreParamNames这些参数不参与签名
     *
     * @param paramValues
     * @param ignoreParamNames
     * @param secret
     * @return
     */
    public static String sign(Map<String, Object> paramValues, List<String> ignoreParamNames, String secret) {
        StringBuilder sb = new StringBuilder();
        List<String> paramNames = new ArrayList<>(paramValues.size());
        paramNames.addAll(paramValues.keySet());
        if (ignoreParamNames != null && ignoreParamNames.size() > 0) {
            for (String ignoreParamName : ignoreParamNames) {
                paramNames.remove(ignoreParamName);
            }
        }
        Collections.sort(paramNames);

        sb.append(secret);
        for (String paramName : paramNames) {
            sb.append(paramName).append(paramValues.get(paramName));
        }
        sb.append(secret);

        return MD5Util.convert32(sb.toString());
    }

    /**
     * 参数md5加密
     *
     * @param params
     * @return
     */
    public static String getParamsMD5Sign(Map<String, Object> params) {
        StringBuffer paramsStr = new StringBuffer();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            paramsStr.append(param.getKey()).append(param.getValue());
        }
        return MD5Util.encrypt(paramsStr.toString()).toUpperCase();
    }

    public static String utf8Encoding(String value, String sourceCharsetName) {
        try {
            return new String(value.getBytes(sourceCharsetName), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String uuid = getUUID();
        System.out.println(uuid.replaceAll("-", ""));
    }

}
