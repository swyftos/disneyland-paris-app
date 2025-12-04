package io.cucumber.core.backend;

import org.apiguardian.api.API;

@API(status = API.Status.STABLE)
/* loaded from: classes5.dex */
public interface ObjectFactory {
    boolean addClass(Class<?> cls);

    <T> T getInstance(Class<T> cls);

    void start();

    void stop();
}
