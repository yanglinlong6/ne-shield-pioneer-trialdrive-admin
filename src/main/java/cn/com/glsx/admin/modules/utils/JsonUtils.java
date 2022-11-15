/**
 *
 */
package cn.com.glsx.admin.modules.utils;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @data 2012-7-10 下午04:52:21
 * @
 */
public class JsonUtils extends JSONUtil {

    /**
     * 获取JSON返加的数据值
     * @param jsonString JSON字符窜
     * @param property 属性名称
     * @return
     */
    public static Object getProperty(String jsonString, String property) {
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.get(property);
    }
}
