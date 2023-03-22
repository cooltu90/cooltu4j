package com.codingtu.cooltu4j;

import cooltu.lib4j.config.LibConfigs;

public class Configs extends LibConfigs {

    @Override
    public boolean isLog() {
        return true;
    }

    @Override
    public String getDefaultLogTag() {
        return "defaultLogTag";
    }

    @Override
    public void baseLog(int level, String tag, String msg) {
        System.out.println(tag + ":" + msg);
    }
}
