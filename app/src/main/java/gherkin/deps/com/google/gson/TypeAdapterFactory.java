package gherkin.deps.com.google.gson;

import gherkin.deps.com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes5.dex */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
