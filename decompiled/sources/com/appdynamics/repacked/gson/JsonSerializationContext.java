package com.appdynamics.repacked.gson;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object obj);

    JsonElement serialize(Object obj, Type type);
}
