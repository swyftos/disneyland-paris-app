package com.allegion.accesssdk.actions;

import java.io.Serializable;

/* loaded from: classes2.dex */
interface IAlStorageService {
    boolean contains(String str);

    void remove(String str);

    <T extends Serializable> T retrieve(String str, Class<T> cls);

    <T extends Serializable> void store(String str, T t);
}
