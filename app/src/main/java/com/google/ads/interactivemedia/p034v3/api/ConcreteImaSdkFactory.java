package com.google.ads.interactivemedia.p034v3.api;

/* JADX INFO: loaded from: classes3.dex */
class ConcreteImaSdkFactory extends ImaSdkFactory {
    ConcreteImaSdkFactory() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.ImaSdkFactory
    public ImaSdkSettings createImaSdkSettings() {
        return new ConcreteImaSdkSettings();
    }
}
