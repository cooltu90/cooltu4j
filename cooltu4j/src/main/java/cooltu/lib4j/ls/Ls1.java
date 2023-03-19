package cooltu.lib4j.ls;

import cooltu.lib4j.data.bean.Symbol;
import cooltu.lib4j.ls.each.Each;
import cooltu.lib4j.ls.each.MapEach;
import cooltu.lib4j.ls.getter.*;
import cooltu.lib4j.ls.same.Same;
import cooltu.lib4j.tools.CountTool;

import java.util.*;

public class Ls1 {

    // each的返回值为false则继续遍历。如果返回值为true，则停止遍历
    public static <T> void ls(EachGetter<T> eachGetter, int step, Each<T> each) {
        int count = eachGetter.count();
        for (int i = 0; i < count; i += step) {
            if (each.each(i, eachGetter.get(i))) {
                return;
            }
        }
    }

    public static <T> void ls(EachGetter<T> eachGetter, Each<T> each) {
        ls(eachGetter, 1, each);
    }

    public static <T> void rls(EachGetter<T> getter, int step, Each<T> each) {
        int count = getter.count();
        for (int i = count - 1; i >= 0; i -= step) {
            if (each.each(i, getter.get(i))) {
                return;
            }
        }
    }

    public static <T> void rls(EachGetter<T> getter, Each<T> each) {
        rls(getter, 1, each);
    }

    // List遍历
    public static <T> void ls(List<T> ts, int step, Each<T> each) {
        ls(new EachGetter4List(ts), step, each);
    }

    public static <T> void ls(List<T> ts, Each<T> each) {
        ls(ts, 1, each);
    }

    public static <T> void rls(List<T> ts, int step, Each<T> each) {
        rls(new EachGetter4List(ts), step, each);
    }

    public static <T> void rls(List<T> ts, Each<T> each) {
        rls(ts, 1, each);
    }

    // Set遍历
    public static <T> void ls(Set<T> ts, Each<T> each) {
        if (CountTool.count(ts) > 0) {
            int index = 0;
            Iterator<? extends T> iterator = ts.iterator();
            while (iterator.hasNext()) {
                if (each.each(index, iterator.next())) {
                    return;
                }
                index++;
            }
        }
    }

    // Map遍历
    public static <K, V> void ls(Map<K, V> map, MapEach<K, V> each) {
        if (map != null && each != null) {
            ls(map.keySet(), new Each<K>() {
                public boolean each(int position, K k) {
                    return each.each(position, k, map.get(k));
                }
            });
        }
    }

    // 数组遍历
    public static <T> void ls(T[] ts, int step, Each<T> each) {
        ls(new EachGetter4Array(ts), step, each);
    }

    public static <T> void ls(T[] ts, Each<T> each) {
        ls(ts, 1, each);
    }

    public static <T> void rls(T[] ts, int step, Each<T> each) {
        rls(new EachGetter4Array<>(ts), step, each);
    }

    public static <T> void rls(T[] ts, Each<T> each) {
        rls(ts, 1, each);
    }

    // int数组遍历
    public static void ls(int[] ts, Each<Integer> each) {
        ls(ts, 1, each);
    }

    public static void ls(int[] ts, int step, Each<Integer> each) {
        ls(new EachGetter4ArrayInt(ts), step, each);
    }

    public static void rls(int[] ts, Each<Integer> each) {
        rls(ts, 1, each);
    }

    public static void rls(int[] ts, int step, Each<Integer> each) {
        rls(new EachGetter4ArrayInt(ts), step, each);
    }

    // boolean数组遍历
    public static void ls(boolean[] ts, Each<Boolean> each) {
        ls(ts, 1, each);
    }

    public static void ls(boolean[] ts, int step, Each<Boolean> each) {
        ls(new EachGetter4ArrayBool(ts), step, each);
    }

    public static void rls(boolean[] ts, Each<Boolean> each) {
        rls(ts, 1, each);
    }

    public static void rls(boolean[] ts, int step, Each<Boolean> each) {
        rls(new EachGetter4ArrayBool(ts), step, each);
    }

    // double数组遍历
    public static void ls(double[] ts, Each<Double> each) {
        ls(ts, 1, each);
    }

    public static void ls(double[] ts, int step, Each<Double> each) {
        ls(new EachGetter4ArrayDouble(ts), step, each);
    }

    public static void rls(double[] ts, Each<Double> each) {
        rls(ts, 1, each);
    }

    public static void rls(double[] ts, int step, Each<Double> each) {
        rls(new EachGetter4ArrayDouble(ts), step, each);
    }


    // float数组遍历
    public static void ls(float[] ts, Each<Float> each) {
        ls(ts, 1, each);
    }

    public static void ls(float[] ts, int step, Each<Float> each) {
        ls(new EachGetter4ArrayFloat(ts), step, each);
    }

    public static void rls(float[] ts, Each<Float> each) {
        rls(ts, 1, each);
    }

    public static void rls(float[] ts, int step, Each<Float> each) {
        rls(new EachGetter4ArrayFloat(ts), step, each);
    }

    // char数组遍历
    public static void ls(char[] ts, Each<Character> each) {
        ls(ts, 1, each);
    }

    public static void ls(char[] ts, int step, Each<Character> each) {
        ls(new EachGetter4ArrayChar(ts), step, each);
    }

    public static void rls(char[] ts, Each<Character> each) {
        rls(ts, 1, each);
    }

    public static void rls(char[] ts, int step, Each<Character> each) {
        rls(new EachGetter4ArrayChar(ts), step, each);
    }

    // long数组遍历
    public static void ls(long[] ts, Each<Long> each) {
        ls(ts, 1, each);
    }

    public static void ls(long[] ts, int step, Each<Long> each) {
        ls(new EachGetter4ArrayLong(ts), step, each);
    }

    public static void rls(long[] ts, Each<Long> each) {
        rls(ts, 1, each);
    }

    public static void rls(long[] ts, int step, Each<Long> each) {
        rls(new EachGetter4ArrayLong(ts), step, each);
    }

    // byte数组遍历
    public static void ls(byte[] ts, Each<Byte> each) {
        ls(ts, 1, each);
    }

    public static void ls(byte[] ts, int step, Each<Byte> each) {
        ls(new EachGetter4ArrayByte(ts), step, each);
    }

    public static void rls(byte[] ts, Each<Byte> each) {
        rls(ts, 1, each);
    }

    public static void rls(byte[] ts, int step, Each<Byte> each) {
        rls(new EachGetter4ArrayByte(ts), step, each);
    }

    // short数组遍历
    public static void ls(short[] ts, Each<Short> each) {
        ls(ts, 1, each);
    }

    public static void ls(short[] ts, int step, Each<Short> each) {
        ls(new EachGetter4ArrayShort(ts), step, each);
    }

    public static void rls(short[] ts, Each<Short> each) {
        rls(ts, 1, each);
    }

    public static void rls(short[] ts, int step, Each<Short> each) {
        rls(new EachGetter4ArrayShort(ts), step, each);
    }

    /***********************************
     *
     * 获取符合条件的元素
     *
     ***********************************/

    public static <T> T get(EachGetter<T> eachGetter, Getter<Integer, T> getter) {
        int count = eachGetter.count();
        for (int i = 0; i < count; i++) {
            T t = eachGetter.get(i);
            if (getter.get(i, t)) {
                return t;
            }
        }
        return null;
    }


    public static <T> T get(Collection<T> ts, Getter<Integer, T> getter) {
        if (ts == null) {
            return null;
        }
        Iterator<T> iterator = ts.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (getter.get(index, next)) {
                return next;
            }
            index++;
        }
        return null;
    }

    public static <T> T get(List<T> ts, Getter<Integer, T> getter) {
        return get(new EachGetter4List<>(ts), getter);
    }

    public static <T> T get(T[] ts, Getter<Integer, T> getter) {
        return get(new EachGetter4Array<>(ts), getter);
    }

    /**************************************************
     *
     * 分割线
     *
     **************************************************/

    public static <E> boolean has(List<E> list, Getter<Integer, E> getter) {
        return get(list, getter) != null;
    }

    public static <E> boolean has(E[] list, Getter<Integer, E> getter) {
        return get(list, getter) != null;
    }


    public static <E> int index(List<E> list, Getter<Integer, E> getter) {
        for (int i = 0; i < CountTool.count(list); i++) {
            E e = list.get(i);
            if (getter.get(i, e)) {
                return i;
            }
        }
        return -1;
    }

    public static <E> int index(E[] es, Getter<Integer, E> getter) {
        for (int i = 0; i < CountTool.count(es); i++) {
            E e = es[i];
            if (getter.get(i, e)) {
                return i;
            }
        }
        return -1;
    }

    public static <K, E> E get(Map<K, E> map, Getter<K, E> getter) {
        Set<K> ks = map.keySet();
        for (K k : ks) {
            E e = map.get(k);
            if (getter.get(k, e)) {
                return e;
            }
        }
        return null;
    }

    public static <K, E> boolean has(Map<K, E> map, Getter<K, E> getter) {
        return get(map, getter) != null;
    }

    /***************************************
     *
     *
     *
     ***************************************/


    private static Same<Symbol> getIDSame() {
        return (id1, id2) -> id1.obtainSymbol().equals(id2.obtainSymbol());
    }

    public static <E> E get(List<E> list, E ee, Same<E> same) {
        return get(list, new Getter<Integer, E>() {
            @Override
            public boolean get(Integer key, E e) {
                return same.same(e, ee);
            }
        });
    }

    public static <E> E get(E[] list, E ee, Same<E> same) {
        return get(list, new Getter<Integer, E>() {
            @Override
            public boolean get(Integer key, E e) {
                return same.same(e, ee);
            }
        });
    }

    public static <E> boolean has(List<E> list, E ee, Same<E> same) {
        return get(list, ee, same) != null;
    }

    public static <E> boolean has(E[] list, E ee, Same<E> same) {
        return get(list, ee, same) != null;
    }


    public static <E> int index(List<E> list, E ee, Same<E> same) {
        for (int i = 0; i < CountTool.count(list); i++) {
            E e = list.get(i);
            if (same.same(ee, e)) {
                return i;
            }
        }
        return -1;
    }

    public static int index(List list, String str) {
        return index(list, str, new Same<String>() {
            @Override
            public boolean same(String t1, String t2) {
                return t1.equals(t2);
            }
        });
    }

    public static int index(List list, Symbol id) {
        return index(list, id, getIDSame());
    }

    /***************************************
     *
     * 替换相同的元素
     *
     ***************************************/
    public static <E> void replace(List<E> list, E ee, Same<E> same) {
        int index = -1;
        for (int i = 0; i < CountTool.count(list); i++) {
            E e = list.get(i);
            if (same.same(ee, e)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            list.set(index, ee);
        }
    }

    public static void replace(List list, Symbol id) {
        replace(list, id, getIDSame());
    }

    /***************************************
     *
     * 替换相同的元素，如果没有的话直接添加
     *
     ***************************************/
    public static <E> void replaceOrAdd(List<E> list, E ee, Same<E> same) {
        int index = -1;
        for (int i = 0; i < CountTool.count(list); i++) {
            E e = list.get(i);
            if (same.same(ee, e)) {
                index = i;
                break;
            }
        }
        if (index < 0) {
            list.add(ee);
        } else {
            list.set(index, ee);
        }

    }

    public static void replaceOrAdd(List list, Symbol ee) {
        replaceOrAdd(list, ee, getIDSame());
    }

    /***************************************
     *
     * 删除某个元素
     *
     ***************************************/
    public static <E> void delete(List<E> list, E ee, Same<E> same) {
        int index = -1;
        for (int i = 0; i < CountTool.count(list); i++) {
            E e = list.get(i);
            if (same.same(ee, e)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            list.remove(index);
        }
    }

    public static void delete(List list, Symbol id) {
        delete(list, id, getIDSame());
    }

}