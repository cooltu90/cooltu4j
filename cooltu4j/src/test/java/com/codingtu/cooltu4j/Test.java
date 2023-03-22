package com.codingtu.cooltu4j;

import cooltu.lib4j.config.LibApp;
import cooltu.lib4j.config.LibConfigs;
import cooltu.lib4j.json.JsonTool;
import cooltu.lib4j.log.LibLogs;

public class Test {

    public static void main(String[] args) {
        App.init();
        User user = JsonTool.toBean(User.class, "{'name':'lisi','age':10}");
        Logs.i(user);
    }

}
