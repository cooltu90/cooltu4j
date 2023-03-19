package cooltu.lib4j.ls.eachgetter;

public interface EachGetter<T> {
    public T get(int position);

    public int count();
}
