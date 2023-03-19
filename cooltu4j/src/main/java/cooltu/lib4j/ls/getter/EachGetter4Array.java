package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4Array<T> implements EachGetter<T> {

    private T[] ts;

    public EachGetter4Array(T[] ts) {
        this.ts = ts;
    }

    @Override
    public T get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
