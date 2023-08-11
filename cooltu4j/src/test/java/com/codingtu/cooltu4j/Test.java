package com.codingtu.cooltu4j;

import cooltu.lib4j.data.bean.ByteValue;
import cooltu.lib4j.ts.Ts;

public class Test {

    public static void main(String[] args) {
        App.init();

        byte a = -120;

        int b = a;

        int i = ByteValue.obtain(a).toInt();

        Logs.i(i);

        Logs.i(b);

    }

}
