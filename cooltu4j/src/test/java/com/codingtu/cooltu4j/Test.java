package com.codingtu.cooltu4j;

import cooltu.lib4j.fake.Fake;
import cooltu.lib4j.ts.Ts;
import cooltu.lib4j.ts.each.Each;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        App.init();

        List<User> ts = Ts.getTs(20, new Ts.Inject<User>() {
            @Override
            public void inject(User t) {
                t.name = Fake.name();
                t.age = Fake.nextInt(50);
                t.xxx = Fake.nexFloat(0, 100, 2);
            }
        });

        //Logs.i(ts);

        ts = Ts.groupSort(ts, new Ts.GroupSortGetter<User>() {
            @Override
            public String getGroup(int level, User user) {
                switch (level) {
                    case 0:
                        return user.age + "";
                    case 1:
                        return user.xxx + "";
                    case 2:
                        return user.name;
                }
                return null;
            }

            @Override
            public int getLevels() {
                return 3;
            }

            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        Ts.ls(ts, new Each<User>() {
            @Override
            public boolean each(int position, User user) {
                Logs.i(user.age+" "+user.xxx+" "+user.name);
                return false;
            }
        });


    }

}
