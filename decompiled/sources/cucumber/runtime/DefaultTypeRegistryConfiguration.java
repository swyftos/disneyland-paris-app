package cucumber.runtime;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import java.util.Locale;

/* loaded from: classes5.dex */
public class DefaultTypeRegistryConfiguration implements TypeRegistryConfigurer, io.cucumber.core.api.TypeRegistryConfigurer {
    @Override // cucumber.api.TypeRegistryConfigurer
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
    }

    @Override // io.cucumber.core.api.TypeRegistryConfigurer
    public void configureTypeRegistry(io.cucumber.core.api.TypeRegistry typeRegistry) {
    }

    @Override // cucumber.api.TypeRegistryConfigurer, io.cucumber.core.api.TypeRegistryConfigurer
    public Locale locale() {
        return Locale.ENGLISH;
    }
}
