package cooltu.lib4j.ls.getter;

public interface EachGetter<T> {
    public T get(int position);

    public int count();
}
