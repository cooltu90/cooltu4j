package cooltu.lib4j.ls.getter;

public interface Getter<K, V> {
    public boolean get(K k, V v);
}
