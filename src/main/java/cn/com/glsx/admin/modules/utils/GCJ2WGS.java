package cn.com.glsx.admin.modules.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 高德点转原始经纬度
 *
 * @author zc
 * @version 1.0
 * @history 2017/4/10 create by zc
 */
@Slf4j
public class GCJ2WGS {

    public static void main(String[] args) {

        GCJ2WGS wg = new GCJ2WGS();

        HashMap<String, Double> hm = wg.delta(30.815040, 104.082125);
        System.out.println(hm);
    }

    //圆周率 GCJ_02_To_WGS_84
    double PI = 3.14159265358979324;

    /**
     * @param lat ,lon 需要转换的经纬度
     * @return 转换为真实GPS坐标后的经纬度
     * @throws <异常类型> {@inheritDoc} 异常描述
     * @author 作者:
     * 方法描述:方法可以将高德地图SDK获取到的GPS经纬度转换为真实的经纬度
     */
    public HashMap<String, Double> delta(double lat, double lon) {
        log.info("delta before:" + "lat=" + lat + " lon=" + lon);
        double a = 6378245.0;
        double ee = 0.00669342162296594323;
        double dLat = this.transformLat(lon - 105.0, lat - 35.0);
        double dLon = this.transformLon(lon - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * this.PI;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * this.PI);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * this.PI);

        HashMap<String, Double> hm = new HashMap<String, Double>();

        hm.put("lat", formatDouble((lat - dLat), 6));
        hm.put("lon", formatDouble((lon - dLon), 6));
        log.info("delta after:" + "lat=" + hm.get("lat") + " lon=" + hm.get("lon"));
        return hm;
    }

    //转换经度
    public double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * this.PI) + 20.0 * Math.sin(2.0 * x * this.PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * this.PI) + 40.0 * Math.sin(x / 3.0 * this.PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * this.PI) + 300.0 * Math.sin(x / 30.0 * this.PI)) * 2.0 / 3.0;
        return ret;
    }

    //转换纬度
    public double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * this.PI) + 20.0 * Math.sin(2.0 * x * this.PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * this.PI) + 40.0 * Math.sin(y / 3.0 * this.PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * this.PI) + 320 * Math.sin(y * this.PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    /**
     * 格式化数字
     *
     * @param x   待格式数字
     * @param num 小数点位数
     */
    public static Double formatDouble(double x, int num) {
        BigDecimal b = new BigDecimal(x);
        return b.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
