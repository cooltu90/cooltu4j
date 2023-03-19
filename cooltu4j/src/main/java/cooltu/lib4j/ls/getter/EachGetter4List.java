package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

import java.util.List;

public class EachGetter4List<T> implements EachGetter<T> {

    private List<T> ts;

    public EachGetter4List(List<T> ts) {
        this.ts = ts;
    }

    @Override
    public T get(int position) {
        return ts.get(position);
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
