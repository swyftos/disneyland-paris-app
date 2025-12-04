package com.appdynamics.repacked.gson;

import com.appdynamics.repacked.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
