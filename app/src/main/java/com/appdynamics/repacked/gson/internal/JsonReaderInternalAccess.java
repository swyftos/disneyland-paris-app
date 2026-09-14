package com.appdynamics.repacked.gson.internal;

import com.appdynamics.repacked.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonReaderInternalAccess {
    public static JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader) throws IOException;
}
