package cooltu.lib4j.ts;

import cooltu.lib4j.data.bean.Symbol;
import cooltu.lib4j.ts.each.Each;
import cooltu.lib4j.ts.each.MapEach;
import cooltu.lib4j.ts.eachgetter.EachGetter;
import cooltu.lib4j.ts.getter.*;
import cooltu.lib4j.tools.CountTool;
import cooltu.lib4j.tools.OtherTool;

import java.util.*;

public class Ts {

    /**************************************************
     *
     * tsGetter
     *
     **************************************************/
    public static EachGetter tsGetter(Object obj) {
        Class aClass = obj.getClass();
        if (aClass.isArray()) {
            if (aClass == int[].class) {
                return tsGetter((int[]) obj);
            } else if (aClass == byte[].class) {
                return tsGetter((byte[]) obj);
            } else if (aClass == long[].class) {
                return tsGetter((long[]) obj);
            } else if (aClass == char[].class) {
                return tsGetter((char[]) obj);
            } else if (aClass == float[].class) {
                return tsGetter((float[]) obj);
            } else if (aClass == double[].class) {
                return tsGetter((double[]) obj);
            } else if (aClass == boolean[].class) {
                return tsGetter((boolean[]) obj);
            } else if (aClass == short[].class) {
                return tsGetter((short[]) obj);
            } else {
                return tsGetter((Object[]) obj);
            }
        }
        return null;
    }

    public static <T> EachGetter<T> tsGetter(List<? extends T> ls) {
        return new EachGetter<T>() {
            @Override
            public T get(int position) {
                return ls.get(position);
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static <T> EachGetter<T> tsGetter(T... ls) {
        return new EachGetter<T>() {
            @Override
            public T get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Integer> tsGetter(int... ls) {
        return new EachGetter<Integer>() {
            @Override
            public Integer get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Boolean> tsGetter(boolean... ls) {
        return new EachGetter<Boolean>() {
            @Override
            public Boolean get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Long> tsGetter(long... ls) {
        return new EachGetter<Long>() {
            @Override
            public Long get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Byte> tsGetter(byte... ls) {
        return new EachGetter<Byte>() {
            @Override
            public Byte get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Double> tsGetter(double... ls) {
        return new EachGetter<Double>() {
            @Override
            public Double get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Float> tsGetter(float... ls) {
        return new EachGetter<Float>() {
            @Override
            public Float get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Character> tsGetter(char... ls) {
        return new EachGetter<Character>() {
            @Override
            public Character get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    public static EachGetter<Short> tsGetter(short... ls) {
        return new EachGetter<Short>() {
            @Override
            public Short get(int position) {
                return ls[position];
            }

            @Override
            public int count() {
                return CountTool.count(ls);
            }
        };
    }

    /**************************************************
     *
     *
     *
     **************************************************/

    /**************************************************
     *
     * 遍历
     *
     **************************************************/
    // each的返回值为false则继续遍历。如果返回值为true，则停止遍历
    private static <T> void ls(EachGetter<T> eachGetter, int step, Each<T> each) {
        int count = eachGetter.count();
        for (int i = 0; i < count; i += step) {
            if (each.each(i, eachGetter.get(i))) {
                return;
            }
        }
    }

    private static <T> void ls(EachGetter<T> eachGetter, Each<T> each) {
        ls(eachGetter, 1, each);
    }

    private static <T> void rls(EachGetter<T> getter, int step, Each<T> each) {
        int count = getter.count();
        for (int i = count - 1; i >= 0; i -= step) {
            if (each.each(i, getter.get(i))) {
                return;
            }
        }
    }

    private static <T> void rls(EachGetter<T> getter, Each<T> each) {
        rls(getter, 1, each);
    }

    // List遍历
    public static <T> void ls(List<? extends T> ts, int step, Each<T> each) {
        ls(tsGetter(ts), step, each);
    }

    public static <T> void ls(List<? extends T> ts, Each<T> each) {
        ls(ts, 1, each);
    }

    public static <T> void rls(List<? extends T> ts, int step, Each<T> each) {
        rls(tsGetter(ts), step, each);
    }

    public static <T> void rls(List<? extends T> ts, Each<T> each) {
        rls(ts, 1, each);
    }

    // Set遍历
    public static <T> void ls(Set<? extends T> ts, Each<T> each) {
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
        ls(tsGetter(ts), step, each);
    }

    public static <T> void ls(T[] ts, Each<T> each) {
        ls(ts, 1, each);
    }

    public static <T> void rls(T[] ts, int step, Each<T> each) {
        rls(tsGetter(ts), step, each);
    }

    public static <T> void rls(T[] ts, Each<T> each) {
        rls(ts, 1, each);
    }

    // int数组遍历
    public static void ls(int[] ts, Each<Integer> each) {
        ls(ts, 1, each);
    }

    public static void ls(int[] ts, int step, Each<Integer> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(int[] ts, Each<Integer> each) {
        rls(ts, 1, each);
    }

    public static void rls(int[] ts, int step, Each<Integer> each) {
        rls(tsGetter(ts), step, each);
    }

    // boolean数组遍历
    public static void ls(boolean[] ts, Each<Boolean> each) {
        ls(ts, 1, each);
    }

    public static void ls(boolean[] ts, int step, Each<Boolean> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(boolean[] ts, Each<Boolean> each) {
        rls(ts, 1, each);
    }

    public static void rls(boolean[] ts, int step, Each<Boolean> each) {
        rls(tsGetter(ts), step, each);
    }

    // double数组遍历
    public static void ls(double[] ts, Each<Double> each) {
        ls(ts, 1, each);
    }

    public static void ls(double[] ts, int step, Each<Double> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(double[] ts, Each<Double> each) {
        rls(ts, 1, each);
    }

    public static void rls(double[] ts, int step, Each<Double> each) {
        rls(tsGetter(ts), step, each);
    }


    // float数组遍历
    public static void ls(float[] ts, Each<Float> each) {
        ls(ts, 1, each);
    }

    public static void ls(float[] ts, int step, Each<Float> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(float[] ts, Each<Float> each) {
        rls(ts, 1, each);
    }

    public static void rls(float[] ts, int step, Each<Float> each) {
        rls(tsGetter(ts), step, each);
    }

    // char数组遍历
    public static void ls(char[] ts, Each<Character> each) {
        ls(ts, 1, each);
    }

    public static void ls(char[] ts, int step, Each<Character> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(char[] ts, Each<Character> each) {
        rls(ts, 1, each);
    }

    public static void rls(char[] ts, int step, Each<Character> each) {
        rls(tsGetter(ts), step, each);
    }

    // long数组遍历
    public static void ls(long[] ts, Each<Long> each) {
        ls(ts, 1, each);
    }

    public static void ls(long[] ts, int step, Each<Long> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(long[] ts, Each<Long> each) {
        rls(ts, 1, each);
    }

    public static void rls(long[] ts, int step, Each<Long> each) {
        rls(tsGetter(ts), step, each);
    }

    // byte数组遍历
    public static void ls(byte[] ts, Each<Byte> each) {
        ls(ts, 1, each);
    }

    public static void ls(byte[] ts, int step, Each<Byte> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(byte[] ts, Each<Byte> each) {
        rls(ts, 1, each);
    }

    public static void rls(byte[] ts, int step, Each<Byte> each) {
        rls(tsGetter(ts), step, each);
    }

    // short数组遍历
    public static void ls(short[] ts, Each<Short> each) {
        ls(ts, 1, each);
    }

    public static void ls(short[] ts, int step, Each<Short> each) {
        ls(tsGetter(ts), step, each);
    }

    public static void rls(short[] ts, Each<Short> each) {
        rls(ts, 1, each);
    }

    public static void rls(short[] ts, int step, Each<Short> each) {
        rls(tsGetter(ts), step, each);
    }

    /**************************************************
     *
     *
     *
     **************************************************/

    public static <T extends Symbol> SameGetter<? extends T> symbolSameGetter(T target) {
        return new SameGetter<T>(target) {
            @Override
            public boolean same(Integer index, T t, T target) {
                return t.obtainSymbol().equals(target.obtainSymbol());
            }
        };
    }

    public static <T extends Symbol> Getter<Integer, T> stringSymbolSameGetter(String symbol) {
        return new Getter<Integer, T>() {
            @Override
            public boolean get(Integer integer, T t) {
                return t.obtainSymbol().equals(symbol);
            }
        };
    }

    public static Getter<Integer, String> stringSameGetter(String str) {
        return new Getter<Integer, String>() {
            @Override
            public boolean get(Integer integer, String s) {
                return s.equals(str);
            }
        };
    }

    /***********************************
     *
     * 获取符合条件的元素
     *
     ***********************************/

    private static <T> T get(EachGetter<T> eachGetter, Getter<Integer, T> getter) {
        int count = eachGetter.count();
        for (int i = 0; i < count; i++) {
            T t = eachGetter.get(i);
            if (getter.get(i, t)) {
                return t;
            }
        }
        return null;
    }


    public static <T> T get(Set<? extends T> ts, Getter<Integer, T> getter) {
        if (ts == null) {
            return null;
        }
        Iterator<? extends T> iterator = ts.iterator();
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

    public static <T> T get(List<? extends T> ts, Getter<Integer, T> getter) {
        return get(tsGetter(ts), getter);
    }

    public static <T> T get(T[] ts, Getter<Integer, T> getter) {
        return get(tsGetter(ts), getter);
    }


    public static <K, V> V get(Map<K, V> map, Getter<K, V> getter) {
        Set<K> ks = map.keySet();
        for (K k : ks) {
            V v = map.get(k);
            if (getter.get(k, v)) {
                return v;
            }
        }
        return null;
    }

    private static <T extends Symbol> T get(EachGetter<T> eachGetter, T target) {
        return get(eachGetter, symbolSameGetter(target));
    }

    private static <T extends Symbol> T get(EachGetter<T> eachGetter, String symbol) {
        return get(eachGetter, stringSymbolSameGetter(symbol));
    }

    public static <T extends Symbol> T get(List<? extends T> ts, T target) {
        return get(tsGetter(ts), target);
    }

    public static <T extends Symbol> T get(T[] ts, T target) {
        return get(tsGetter(ts), target);
    }

    public static <T extends Symbol> T get(List<? extends T> ts, String symbol) {
        return get(tsGetter(ts), symbol);
    }

    public static <T extends Symbol> T get(T[] ts, String symbol) {
        return get(tsGetter(ts), symbol);
    }

    /**************************************************
     *
     * has
     *
     **************************************************/

    public static <T> boolean has(Set<? extends T> ts, Getter<Integer, T> getter) {
        return get(ts, getter) != null;
    }

    public static <T> boolean has(List<? extends T> list, Getter<Integer, T> getter) {
        return get(list, getter) != null;
    }

    public static <T> boolean has(T[] list, Getter<Integer, T> getter) {
        return get(list, getter) != null;
    }

    public static <K, V> boolean has(Map<K, V> map, Getter<K, V> getter) {
        return get(map, getter) != null;
    }

    public static <T extends Symbol> boolean has(List<? extends T> ts, T t) {
        return get(ts, t) != null;
    }

    public static <T extends Symbol> boolean has(T[] ts, T t) {
        return get(ts, t) != null;
    }

    public static <T extends Symbol> boolean has(List<? extends T> ts, String symbol) {
        return get(ts, symbol) != null;
    }

    public static <T extends Symbol> boolean has(T[] ts, String symbol) {
        return get(ts, symbol) != null;
    }

    /**************************************************
     *
     * index
     *
     **************************************************/
    private static <T> int index(EachGetter<T> eachGetter, Getter<Integer, T> getter) {
        int count = eachGetter.count();
        for (int i = 0; i < count; i++) {
            T t = eachGetter.get(i);
            if (getter.get(i, t)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int index(List<? extends T> ts, Getter<Integer, T> getter) {
        return index(tsGetter(ts), getter);
    }

    public static <T> int index(T[] ts, Getter<Integer, T> getter) {
        return index(tsGetter(ts), getter);
    }

    public static <T extends Symbol> int index(List<? extends T> ts, T target) {
        return index(ts, symbolSameGetter(target));
    }

    public static <T extends Symbol> int index(T[] ts, T target) {
        return index(ts, symbolSameGetter(target));
    }

    public static <T extends Symbol> int index(List<? extends T> ts, String symbol) {
        return index(ts, stringSymbolSameGetter(symbol));
    }

    public static <T extends Symbol> int index(T[] ts, String symbol) {
        return index(ts, stringSymbolSameGetter(symbol));
    }

    public static int index(String target, List<String> ss) {
        return index(ss, stringSameGetter(target));
    }

    /**************************************************
     *
     * replace
     *
     **************************************************/
    public static <T> void replace(List<T> ts, SameGetter<T> getter) {
        int index = index(ts, getter);
        if (index >= 0) {
            ts.set(index, getter.target);
        }
    }

    public static <T> void replace(T[] ts, SameGetter<T> getter) {
        int index = index(ts, getter);
        if (index >= 0) {
            ts[index] = getter.target;
        }
    }

    public static <T extends Symbol> void replace(List<? extends T> ts, T target) {
        replace(ts, symbolSameGetter(target));
    }

    public static <T extends Symbol> void replace(T[] ts, T target) {
        replace(ts, symbolSameGetter(target));
    }

    public static <T> void replaceOrAdd(List<T> ts, SameGetter<T> getter) {
        int index = index(ts, getter);
        if (index >= 0) {
            ts.set(index, getter.target);
        } else {
            ts.add(getter.target);
        }
    }

    public static <T extends Symbol> void replaceOrAdd(List<? extends T> ts, T target) {
        replaceOrAdd(ts, symbolSameGetter(target));
    }

    /**************************************************
     *
     * delete
     *
     **************************************************/
    public static <T> void delete(List<? extends T> ts, SameGetter<T> getter) {
        int index = index(ts, getter);
        if (index >= 0) {
            ts.remove(index);
        }
    }

    public static <T extends Symbol> void delete(List<? extends T> ts, T target) {
        delete(ts, symbolSameGetter(target));
    }

    /**************************************************
     *
     *
     *
     **************************************************/

    public static <T> List<T> toList(T... ts) {
        ArrayList<T> ls = new ArrayList<>();
        for (int i = 0; i < CountTool.count(ts); i++) {
            ls.add(ts[i]);
        }
        return ls;
    }

    public static <T> T[] toArray(List<T> lines) {
        int count = CountTool.count(lines);
        if (count <= 0) {
            return null;
        }
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance
                (lines.get(0).getClass(), count);
        return lines.toArray(newArray);
    }

    public static <T> List<T> getList(EachGetter<T> getter) {
        ArrayList<T> ts = new ArrayList<T>();
        int count = getter.count();
        for (int i = 0; i < count; i++) {
            ts.add(getter.get(i));
        }
        return ts;
    }

    public static <T> T[] getArray(EachGetter<T> getter) {
        int count = getter.count();
        T t = getter.get(0);
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance
                (t.getClass(), count);
        newArray[0] = t;
        if (count > 1) {
            for (int i = 1; i < count; i++) {
                newArray[i] = getter.get(i);
            }
        }
        return newArray;
    }

    public static <T> T[] objsToArrays(Object[] objs) {
        int count = CountTool.count(objs);
        if (count > 0) {
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance
                    (objs[0].getClass(), count);

            Ts.ls(objs, new Each<Object>() {
                @Override
                public boolean each(int position, Object o) {
                    newArray[position] = (T) o;
                    return false;
                }
            });
            return newArray;
        }
        return null;
    }

    public static <T> void clear(T[] ets) {
        if (ets != null) {
            for (int i = 0; i < CountTool.count(ets); i++) {
                ets[i] = null;
            }
        }
    }

    /**************************************************
     *
     *
     *
     **************************************************/

    public static <E> E getT(Inject<E> tt) {
        E t = tt.newT();
        tt.inject(t);
        return t;
    }

    public static <E> List<E> getTs(int size, Inject<E> tt) {
        ArrayList<E> ts = new ArrayList<E>();
        for (int i = 0; i < size; i++) {
            ts.add(getT(tt));
        }
        return ts;
    }

    public static abstract class Inject<E> {
        E newT() {
            try {
                return ((Class<E>) OtherTool.getParameterizedType(this, 0)).newInstance();
            } catch (Exception e) {
                return null;
            }
        }

        public abstract void inject(E t);
    }
}