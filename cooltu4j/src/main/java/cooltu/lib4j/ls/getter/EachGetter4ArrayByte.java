package cooltu.lib4j.ls.getter;

import cooltu.lib4j.tools.CountTool;

public class EachGetter4ArrayByte implements EachGetter<Byte> {

    private byte[] ts;

    public EachGetter4ArrayByte(byte[] ts) {
        this.ts = ts;
    }

    @Override
    public Byte get(int position) {
        return ts[position];
    }

    @Override
    public int count() {
        return CountTool.count(ts);
    }
}
