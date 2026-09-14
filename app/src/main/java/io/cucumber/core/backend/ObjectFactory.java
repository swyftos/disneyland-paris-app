package io.cucumber.core.backend;

import org.apiguardian.api.API;

/* JADX INFO: loaded from: classes5.dex */
@API(status = API.Status.STABLE)
public interface ObjectFactory {
    boolean addClass(Class<?> cls);

    <T> T getInstance(Class<T> cls);

    void start();

    void stop();
}
