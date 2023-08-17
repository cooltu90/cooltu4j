package cooltu.lib4j.ts;

import cooltu.lib4j.data.bean.Symbol;
import cooltu.lib4j.data.map.ListValueMap;
import cooltu.lib4j.tools.CountTool;
import cooltu.lib4j.tools.OtherTool;
import cooltu.lib4j.tools.StringTool;
import cooltu.lib4j.ts.each.Each;
import cooltu.lib4j.ts.each.MapEach;
import cooltu.lib4j.ts.eachgetter.EachGetter;
import cooltu.lib4j.ts.getter.Getter;
import cooltu.lib4j.ts.getter.SameGetter;

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

    public static <T extends Symbol> SameGetter<T> symbolSameGetter(T target) {
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
    public static <K, V> V get(Getter<K, V> getter, Map<K, V> map) {
        if (getter == null || map == null)
            return null;

        Set<K> ks = map.keySet();
        for (K k : ks) {
            V v = map.get(k);
            if (getter.get(k, v)) {
                return v;
            }
        }
        return null;
    }

    public static <T> T get(EachGetter<T> eachGetter, Getter<Integer, T> getter) {
        if (eachGetter == null || getter == null)
            return null;

        int count = eachGetter.count();
        T t = null;
        for (int i = 0; i < count; i++) {
            t = eachGetter.get(i);
            if (getter.get(i, t)) {
                return t;
            }
        }
        return null;
    }


    public static <T> T get(Getter<Integer, T> getter, T... ts) {
        if (getter == null)
            return null;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts[i];
            if (getter.get(i, t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T get(Getter<Integer, T> getter, List<? extends T> ts) {
        if (getter == null)
            return null;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts.get(i);
            if (getter.get(i, t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T get(Getter<Integer, T> getter, Set<? extends T> ts) {
        if (CountTool.count(ts) <= 0) {
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


    public static String get(String symbol, String... strs) {
        if (StringTool.isBlank(symbol))
            return null;

        int count = CountTool.count(strs);
        String str = null;
        for (int i = 0; i < count; i++) {
            str = strs[i];
            if (symbol.equals(str)) {
                return str;
            }
        }
        return null;
    }

    public static <T extends Symbol> T get(String symbol, T... ts) {
        if (StringTool.isBlank(symbol))
            return null;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts[i];
            if (symbol.equals(t.obtainSymbol())) {
                return t;
            }
        }
        return null;
    }

    public static <T extends Symbol> T get(T target, T... ts) {
        if (target == null)
            return null;
        return get(target.obtainSymbol(), ts);
    }


    public static <T extends Symbol> T get(String symbol, List<? extends T> ts) {
        if (StringTool.isBlank(symbol))
            return null;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts.get(i);
            if (symbol.equals(t.obtainSymbol())) {
                return t;
            }
        }
        return null;
    }


    public static <T extends Symbol> T get(T target, List<? extends T> ts) {
        if (target == null)
            return null;
        return get(target.obtainSymbol(), ts);
    }


    public static <T extends Symbol> T get(String symbol, Set<? extends T> ts) {
        if (StringTool.isBlank(symbol))
            return null;

        if (CountTool.count(ts) <= 0)
            return null;

        for (T t : ts) {
            if (symbol.equals(t.obtainSymbol())) {
                return t;
            }
        }
        return null;
    }

    public static <T extends Symbol> T get(T target, Set<? extends T> ts) {
        if (target == null)
            return null;
        return get(target.obtainSymbol(), ts);
    }

    @Deprecated
    public static <K, V> V get(Map<K, V> map, Getter<K, V> getter) {
        return get(getter, map);
    }

    @Deprecated
    public static <T> T get(Set<? extends T> ts, Getter<Integer, T> getter) {
        return get(getter, ts);
    }

    @Deprecated
    public static <T> T get(List<? extends T> ts, Getter<Integer, T> getter) {
        return get(getter, ts);
    }

    @Deprecated
    public static <T> T get(T[] ts, Getter<Integer, T> getter) {
        return get(getter, ts);
    }

    @Deprecated
    private static <T extends Symbol> T get(EachGetter<T> eachGetter, T target) {
        return get(eachGetter, symbolSameGetter(target));
    }

    @Deprecated
    public static <T extends Symbol> T get(EachGetter<T> eachGetter, String symbol) {
        return get(symbol, eachGetter);
    }

    @Deprecated
    public static <T extends Symbol> T get(String symbol, EachGetter<T> eachGetter) {
        if (StringTool.isBlank(symbol))
            return null;
        return get(eachGetter, stringSymbolSameGetter(symbol));
    }

    @Deprecated
    public static <T extends Symbol> T get(T[] ts, String symbol) {
        return get(symbol, ts);
    }

    @Deprecated
    public static <T extends Symbol> T get(T[] ts, T target) {
        return get(target, ts);
    }

    @Deprecated
    public static <T extends Symbol> T get(List<? extends T> ts, String symbol) {
        return get(symbol, ts);
    }

    @Deprecated
    public static <T extends Symbol> T get(List<? extends T> ts, T target) {
        return get(target, ts);
    }

    /**************************************************
     *
     * has
     *
     **************************************************/
    public static boolean has(String symbol, String... strs) {
        return get(symbol, strs) != null;
    }

    public static <T extends Symbol> boolean has(String symbol, T... ts) {
        return get(symbol, ts) != null;
    }

    public static <T extends Symbol> boolean has(T t, T... ts) {
        return get(t, ts) != null;
    }

    public static <T extends Symbol> boolean has(String symbol, List<? extends T> ts) {
        return get(symbol, ts) != null;
    }

    public static <T extends Symbol> boolean has(T t, List<? extends T> ts) {
        return get(t, ts) != null;
    }

    public static <T extends Symbol> boolean has(String symbol, Set<? extends T> ts) {
        return get(symbol, ts) != null;
    }

    public static <T extends Symbol> boolean has(T t, Set<? extends T> ts) {
        return get(t, ts) != null;
    }


    public static <T> boolean has(Getter<Integer, T> getter, Set<? extends T> ts) {
        return get(getter, ts) != null;
    }

    public static <T> boolean has(Getter<Integer, T> getter, List<? extends T> list) {
        return get(getter, list) != null;
    }

    public static <T> boolean has(Getter<Integer, T> getter, T... list) {
        return get(getter, list) != null;
    }

    public static <K, V> boolean has(Getter<K, V> getter, Map<K, V> map) {
        return get(getter, map) != null;
    }

    public static <T> boolean has(EachGetter<T> eachGetter, Getter<Integer, T> getter) {
        return get(eachGetter, getter) != null;
    }

    @Deprecated
    public static <T extends Symbol> boolean has(T[] ts, String symbol) {
        return has(symbol, ts);
    }

    @Deprecated
    public static <T extends Symbol> boolean has(T[] ts, T t) {
        return has(t, ts);
    }

    @Deprecated
    public static <T extends Symbol> boolean has(List<? extends T> ts, String symbol) {
        return has(symbol, ts);
    }

    @Deprecated
    public static <T extends Symbol> boolean has(List<? extends T> ts, T t) {
        return has(t, ts);
    }


    @Deprecated
    public static <T> boolean has(Set<? extends T> ts, Getter<Integer, T> getter) {
        return has(getter, ts);
    }

    @Deprecated
    public static <T> boolean has(List<? extends T> ts, Getter<Integer, T> getter) {
        return has(getter, ts);
    }

    @Deprecated
    public static <T> boolean has(T[] ts, Getter<Integer, T> getter) {
        return has(getter, ts);
    }

    @Deprecated
    public static <K, V> boolean has(Map<K, V> map, Getter<K, V> getter) {
        return has(getter, map);
    }

    /**************************************************
     *
     * index
     *
     **************************************************/
    public static <T> int index(EachGetter<T> eachGetter, Getter<Integer, T> getter) {
        if (eachGetter == null || getter == null)
            return -1;
        int count = eachGetter.count();
        T t = null;
        for (int i = 0; i < count; i++) {
            t = eachGetter.get(i);
            if (getter.get(i, t)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int index(Getter<Integer, T> getter, T... ts) {
        if (getter == null)
            return -1;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts[i];
            if (getter.get(i, t)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int index(Getter<Integer, T> getter, List<? extends T> ts) {
        if (getter == null)
            return -1;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts.get(i);
            if (getter.get(i, t)) {
                return i;
            }
        }
        return -1;
    }

    public static int index(String symbol, String... strs) {
        if (StringTool.isBlank(symbol))
            return -1;

        int count = CountTool.count(strs);
        String str = null;
        for (int i = 0; i < count; i++) {
            str = strs[i];
            if (symbol.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends Symbol> int index(String symbol, T... ts) {
        if (StringTool.isBlank(symbol))
            return -1;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts[i];
            if (symbol.equals(t.obtainSymbol())) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends Symbol> int index(T target, T... ts) {
        if (target == null)
            return -1;
        return index(target.obtainSymbol(), ts);
    }


    public static <T extends Symbol> int index(String symbol, List<? extends T> ts) {
        if (StringTool.isBlank(symbol))
            return -1;

        int count = CountTool.count(ts);
        T t = null;
        for (int i = 0; i < count; i++) {
            t = ts.get(i);
            if (symbol.equals(t.obtainSymbol())) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends Symbol> int index(T target, List<? extends T> ts) {
        if (target == null)
            return -1;
        return index(target.obtainSymbol(), ts);
    }

    @Deprecated
    public static <T> int index(List<? extends T> ts, Getter<Integer, T> getter) {
        return index(getter, ts);
    }

    @Deprecated
    public static <T> int index(T[] ts, Getter<Integer, T> getter) {
        return index(getter, ts);
    }

    @Deprecated
    public static <T extends Symbol> int index(List<? extends T> ts, T target) {
        return index(target, ts);
    }

    @Deprecated
    public static <T extends Symbol> int index(T[] ts, T target) {
        return index(target, ts);
    }

    @Deprecated
    public static <T extends Symbol> int index(List<? extends T> ts, String symbol) {
        return index(symbol, ts);
    }

    @Deprecated
    public static <T extends Symbol> int index(T[] ts, String symbol) {
        return index(symbol, ts);
    }

    /**************************************************
     *
     * replace
     *
     **************************************************/

    @Deprecated
    public static <T> void replace(List<T> ts, SameGetter<T> getter) {
        replace(getter, ts);
    }

    @Deprecated
    public static <T> void replace(T[] ts, SameGetter<T> getter) {
        replace(getter, ts);
    }

    @Deprecated
    public static <T extends Symbol> void replace(List<T> ts, T target) {
        replace(target, ts);
    }

    @Deprecated
    public static <T extends Symbol> void replace(T[] ts, T target) {
        replace(target, ts);
    }

    @Deprecated
    public static <T> void replaceOrAdd(List<T> ts, SameGetter<T> getter) {
        replaceOrAdd(getter, ts);
    }

    @Deprecated
    public static <T extends Symbol> void replaceOrAdd(List<T> ts, T target) {
        replaceOrAdd(target, ts);
    }


    public static <T> void replace(SameGetter<T> getter, List<T> ts) {
        int index = index(getter, ts);
        if (index >= 0) {
            ts.set(index, getter.target);
        }
    }

    public static <T> void replace(SameGetter<T> getter, T... ts) {
        int index = index(getter, ts);
        if (index >= 0) {
            ts[index] = getter.target;
        }
    }


    public static <T extends Symbol> void replace(T target, List<T> ts) {
        int index = index(target, ts);
        if (index >= 0) {
            ts.set(index, target);
        }

    }


    public static <T extends Symbol> void replace(T target, T... ts) {
        int index = index(target, ts);
        if (index >= 0) {
            ts[index] = target;
        }
    }

    public static <T> void replaceOrAdd(SameGetter<T> getter, List<T> ts) {
        int index = index(getter, ts);
        if (index >= 0) {
            ts.set(index, getter.target);
        } else {
            ts.add(getter.target);
        }
    }

    public static <T extends Symbol> void replaceOrAdd(T target, List<T> ts) {
        int index = index(target, ts);
        if (index >= 0) {
            ts.set(index, target);
        } else {
            ts.add(target);
        }
    }

    /**************************************************
     *
     * delete
     *
     **************************************************/
    public static <T> void delete(SameGetter<T> getter, List<? extends T> ts) {
        int index = index(getter, ts);
        if (index >= 0) {
            ts.remove(index);
        }
    }

    public static <T extends Symbol> void delete(T target, List<? extends T> ts) {
        int index = index(target, ts);
        if (index >= 0) {
            ts.remove(index);
        }
    }


    @Deprecated
    public static <T> void delete(List<? extends T> ts, SameGetter<T> getter) {
        delete(getter, ts);
    }

    @Deprecated
    public static <T extends Symbol> void delete(List<? extends T> ts, T target) {
        delete(target, ts);
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
            for (int i = 0; i < count; i++) {
                newArray[i] = (T) objs[i];
            }
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

    /**************************************************
     *
     * 获取List的最后一个元素
     *
     **************************************************/
    public static <E> E last(List<E> list) {
        int count = CountTool.count(list);
        return count > 0 ? list.get(count - 1) : null;
    }

    /**************************************************
     *
     * 对List中添加元素
     *
     **************************************************/
    public static <E> List<E> add(List<E> list, E e) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(e);
        return list;
    }

    /**************************************************
     *
     * 转换
     *
     **************************************************/
    public static interface Convert<S, T> {
        T convert(S s);
    }

    public static <T, S> List<T> convert(Convert<S, T> convert, EachGetter<S> getter) {
        ArrayList<T> ts = new ArrayList<>();
        int count = getter.count();
        for (int i = 0; i < count; i++) {
            T t = convert.convert(getter.get(i));
            if (t != null) {
                ts.add(t);
            }
        }
        return ts;
    }

    public static <T, S> List<T> convert(Convert<S, T> convert, List<S> ss) {
        ArrayList<T> ts = new ArrayList<>();
        int count = CountTool.count(ss);
        for (int i = 0; i < count; i++) {
            T t = convert.convert(ss.get(i));
            if (t != null) {
                ts.add(t);
            }
        }
        return ts;
    }

    public static <T, S> List<T> convert(Convert<S, T> convert, S... ss) {
        ArrayList<T> ts = new ArrayList<>();
        int count = CountTool.count(ss);
        for (int i = 0; i < count; i++) {
            T t = convert.convert(ss[i]);
            if (t != null) {
                ts.add(t);
            }
        }
        return ts;
    }

    public static <T> List<T> convert(Convert<Integer, T> convert, int... ss) {
        ArrayList<T> ts = new ArrayList<>();
        int count = CountTool.count(ss);
        for (int i = 0; i < count; i++) {
            T t = convert.convert(ss[i]);
            if (t != null) {
                ts.add(t);
            }
        }
        return ts;
    }


    @Deprecated
    public static <T, S> List<T> convert(List<S> ss, Convert<S, T> convert) {
        return convert(convert, ss);
    }

    @Deprecated
    public static <T, S> List<T> convert(S[] ss, Convert<S, T> convert) {
        return convert(convert, ss);
    }

    @Deprecated
    public static <T> List<T> convert(int[] ss, Convert<Integer, T> convert) {
        return convert(convert, ss);
    }

    @Deprecated
    public static <T, S> List<T> convert(EachGetter<S> getter, Convert<S, T> convert) {
        return convert(convert, getter);
    }

    /**************************************************
     *
     * 分组排序
     *
     **************************************************/
    public static <T> List<T> groupSort(T[] ts, GroupSortGetter<T> getter) {
        return groupSort(toList(ts), getter);
    }

    public static <T> List<T> groupSort(List<T> ts, GroupSortGetter<T> getter) {
        ListValueMap<String, String> totalMap = new ListValueMap<>();
        Map<String, T> tMap = new HashMap<>();

        Collections.sort(ts, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return getter.compare(o1, o2);
            }
        });

        Ts.ls(ts, new Each<T>() {
            @Override
            public boolean each(int i, T t) {
                tMap.put(getter.getGroup(getter.getLevels() - 1, t), t);

                String[] gs = new String[getter.getLevels()];
                for (int j = 0; j < gs.length; j++) {
                    gs[j] = getter.getGroup(j, t);
                }

                List<String> list = totalMap.get(getRootGroupKey());

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < gs.length; j++) {
                    if (j < gs.length - 1) {
                        sb.append(gs[j]);
                        List<String> subList = totalMap.get(sb.toString());
                        if (CountTool.isNull(subList)) {
                            list.add(gs[j]);
                        }
                        list = subList;
                    } else {
                        list.add(gs[j]);
                    }

                }
                return false;
            }
        });

        List<T> as = new ArrayList<>();
        groupSort(as, getter.getLevels(), 0, totalMap, tMap, getRootGroupKey());
        return as;
    }

    private static <T> void groupSort(List<T> container, int levels, int level, ListValueMap<String, String> categorgMap, Map<String, T> tMap, String key) {
        Ts.ls(categorgMap.get(key), new Each<String>() {
            @Override
            public boolean each(int i, String s) {
                if (level < levels - 1) {
                    groupSort(container, levels, level + 1, categorgMap, tMap, (getRootGroupKey().equals(key) ? "" : key) + s);
                } else {
                    container.add(tMap.get(s));
                }
                return false;
            }
        });
    }

    private static String getRootGroupKey() {
        return "root";
    }

    public static interface GroupSortGetter<T> {
        String getGroup(int level, T t);

        int getLevels();

        int compare(T o1, T o2);

    }

}