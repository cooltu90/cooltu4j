package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayShort implements EachGetter<Short> {

    private short[] ts;

    public EachGetter4ArrayShort(short[] ts) {
        this.ts = ts;
    }

    @Override
    public Short get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
