package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayLong implements EachGetter<Long> {

    private long[] ts;

    public EachGetter4ArrayLong(long[] ts) {
        this.ts = ts;
    }

    @Override
    public Long get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
