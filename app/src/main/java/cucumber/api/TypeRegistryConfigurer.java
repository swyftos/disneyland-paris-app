package cucumber.api;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface TypeRegistryConfigurer {
    void configureTypeRegistry(TypeRegistry typeRegistry);

    Locale locale();
}
