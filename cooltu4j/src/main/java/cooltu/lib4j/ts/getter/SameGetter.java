package cooltu.lib4j.ts.getter;

public abstract class SameGetter<T> implements Getter<Integer, T> {

    public T target;

    public SameGetter(T target) {
        this.target = target;
    }

    @Override
    public boolean get(Integer integer, T t) {
        return same(integer, t, target);
    }

    public abstract boolean same(Integer index, T t, T target);
}
