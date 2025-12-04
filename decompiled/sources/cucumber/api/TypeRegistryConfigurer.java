package cucumber.api;

import java.util.Locale;

@Deprecated
/* loaded from: classes5.dex */
public interface TypeRegistryConfigurer {
    void configureTypeRegistry(TypeRegistry typeRegistry);

    Locale locale();
}
