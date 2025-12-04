package io.cucumber.core.api;

import java.util.Locale;
import org.apiguardian.api.API;

@API(status = API.Status.STABLE)
/* loaded from: classes5.dex */
public interface TypeRegistryConfigurer {
    void configureTypeRegistry(TypeRegistry typeRegistry);

    Locale locale();
}
