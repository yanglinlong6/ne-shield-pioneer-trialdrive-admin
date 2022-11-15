package cn.com.glsx.admin.modules.utils;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author xiangyanlin
 * @date 2022/5/11
 */
public class CollectionSortUtil {

    public final static String naturalOrder = "ASC";

    public static <T extends Comparable<? super T>> Comparator<T> order(String order) {
        if (Objects.equals(order, naturalOrder)) {
            return Comparator.naturalOrder();
        }
        return Comparator.reverseOrder();
    }
}
