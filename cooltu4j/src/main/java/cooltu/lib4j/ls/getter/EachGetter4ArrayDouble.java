package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayDouble implements EachGetter<Double> {

    private double[] ts;

    public EachGetter4ArrayDouble(double[] ts) {
        this.ts = ts;
    }

    @Override
    public Double get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
