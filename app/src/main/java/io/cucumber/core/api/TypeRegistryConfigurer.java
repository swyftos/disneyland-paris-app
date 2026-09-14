package io.cucumber.core.api;

import java.util.Locale;
import org.apiguardian.api.API;

/* JADX INFO: loaded from: classes5.dex */
@API(status = API.Status.STABLE)
public interface TypeRegistryConfigurer {
    void configureTypeRegistry(TypeRegistry typeRegistry);

    Locale locale();
}
