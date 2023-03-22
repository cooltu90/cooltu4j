package com.codingtu.cooltu4j;

import cooltu.lib4j.config.LibApp;
import cooltu.lib4j.config.LibConfigs;

public class App extends LibApp {

    public static void init() {
        APP = new App();
    }

    @Override
    public LibConfigs createConfigs() {
        return new Configs();
    }

}
