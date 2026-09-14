package com.appdynamics.repacked.gson;

import com.appdynamics.repacked.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ToNumberStrategy {
    Number readNumber(JsonReader jsonReader) throws IOException;
}
