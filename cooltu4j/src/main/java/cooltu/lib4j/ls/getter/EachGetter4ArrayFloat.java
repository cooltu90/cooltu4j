package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayFloat implements EachGetter<Float> {

    private float[] ts;

    public EachGetter4ArrayFloat(float[] ts) {
        this.ts = ts;
    }

    @Override
    public Float get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
