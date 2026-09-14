package com.google.ads.interactivemedia.p034v3.api;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImaSdkFactory {
    private static ImaSdkFactory instance;

    public abstract ImaSdkSettings createImaSdkSettings();

    public static ImaSdkFactory getInstance() {
        if (instance == null) {
            instance = new ConcreteImaSdkFactory();
        }
        return instance;
    }
}
