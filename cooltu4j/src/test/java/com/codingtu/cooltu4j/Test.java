package com.codingtu.cooltu4j;

import cooltu.lib4j.data.bean.maxmin.MaxMin;
import cooltu.lib4j.data.bean.maxmin.FloatMaxMin;
import cooltu.lib4j.fake.Fake;
import cooltu.lib4j.ts.Ts;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        App.init();

        List<User> ts = Ts.getTs(20, new Ts.Inject<User>() {
            @Override
            public void inject(User t) {
                t.xxx = Fake.nexFloat(0, 100, 2);
            }
        });

        Logs.i(ts);

        MaxMin<Float, User> maxMin = FloatMaxMin.obtain(ts);
        Logs.i("maxMin:" + maxMin.max + " " + maxMin.min);

    }

}
