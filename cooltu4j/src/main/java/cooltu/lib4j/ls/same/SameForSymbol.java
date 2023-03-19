package cooltu.lib4j.ls.same;

import cooltu.lib4j.data.bean.Symbol;

public class SameForSymbol implements Same<Symbol> {
    @Override
    public boolean same(Symbol t1, Symbol t2) {
        return t1.obtainSymbol().equals(t2.obtainSymbol());
    }
}
