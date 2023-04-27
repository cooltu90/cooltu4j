package com.codingtu.cooltu4j;

import cooltu.lib4j.data.bean.CoreBean;
import cooltu.lib4j.data.bean.num.DoubleGetter;
import cooltu.lib4j.data.bean.num.FloatGetter;

public class User extends CoreBean implements FloatGetter {

    public String name;
    public int age;

    public float xxx;

    @Override
    public float obtainFloat() {
        return xxx;
    }
}
