package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayChar implements EachGetter<Character> {

    private char[] ts;

    public EachGetter4ArrayChar(char[] ts) {
        this.ts = ts;
    }

    @Override
    public Character get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
