package com.facebook.hermes.intl;

/* JADX INFO: loaded from: classes3.dex */
public class LocaleObject {
    public static ILocaleObject createDefault() {
        return LocaleObjectICU.createDefault();
    }

    public static ILocaleObject createFromLocaleId(String str) throws JSRangeErrorException {
        return LocaleObjectICU.createFromLocaleId(str);
    }
}
