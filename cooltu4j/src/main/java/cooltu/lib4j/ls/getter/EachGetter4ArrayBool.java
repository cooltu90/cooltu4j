package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayBool implements EachGetter<Boolean> {

    private boolean[] ts;

    public EachGetter4ArrayBool(boolean[] ts) {
        this.ts = ts;
    }

    @Override
    public Boolean get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
