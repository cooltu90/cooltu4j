package cooltu.lib4j.data.bean;

import cooltu.lib4j.tools.CountTool;
import cooltu.lib4j.tools.MathTool;

import java.util.List;

public class MaxMin<T extends Number> {

    public T max;
    public T min;

    public static <T extends Number> MaxMin<T> obtian(List<T> list) {
        MaxMin<T> maxMin = new MaxMin<T>();
        int count = CountTool.count(list);
        if (count > 0) {
            T num = list.get(0);
            maxMin.max = num;
            maxMin.min = num;
            for (int i = 1; i < count; i++) {
                num = list.get(i);
                maxMin.max = MathTool.max(maxMin.max, num);
                maxMin.min = MathTool.min(maxMin.min, num);
            }
        }
        return maxMin;
    }

}
