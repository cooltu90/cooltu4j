package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayInt implements EachGetter<Integer> {

    private int[] ts;

    public EachGetter4ArrayInt(int[] ts) {
        this.ts = ts;
    }

    @Override
    public Integer get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
