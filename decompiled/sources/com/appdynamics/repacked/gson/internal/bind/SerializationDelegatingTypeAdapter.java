package com.appdynamics.repacked.gson.internal.bind;

import com.appdynamics.repacked.gson.TypeAdapter;

/* loaded from: classes2.dex */
public abstract class SerializationDelegatingTypeAdapter<T> extends TypeAdapter<T> {
    public abstract TypeAdapter<T> getSerializationDelegate();
}
