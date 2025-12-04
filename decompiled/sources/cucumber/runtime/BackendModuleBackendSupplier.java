package cucumber.runtime;

import cucumber.runtime.io.ResourceLoader;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.core.options.RunnerOptions;
import io.cucumber.stepexpression.TypeRegistry;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class BackendModuleBackendSupplier implements BackendSupplier {
    private static final List backendPackages = Collections.singletonList(URI.create("classpath:cucumber/runtime"));
    private final ClassFinder classFinder;
    private final List packages;
    private final ResourceLoader resourceLoader;
    private final RunnerOptions runnerOptions;

    public BackendModuleBackendSupplier(ResourceLoader resourceLoader, ClassFinder classFinder, RunnerOptions runnerOptions) {
        this(resourceLoader, classFinder, runnerOptions, backendPackages);
    }

    BackendModuleBackendSupplier(ResourceLoader resourceLoader, ClassFinder classFinder, RunnerOptions runnerOptions, List list) {
        this.resourceLoader = resourceLoader;
        this.classFinder = classFinder;
        this.runnerOptions = runnerOptions;
        this.packages = list;
    }

    @Override // cucumber.runtime.BackendSupplier
    public Collection<? extends Backend> get() {
        Collection<? extends Backend> collectionLoadBackends = loadBackends();
        if (collectionLoadBackends.isEmpty()) {
            throw new CucumberException("No backends were found. Please make sure you have a backend module on your CLASSPATH.");
        }
        return collectionLoadBackends;
    }

    private Collection loadBackends() {
        TypeRegistry typeRegistry;
        Reflections reflections = new Reflections(this.classFinder);
        TypeRegistryConfigurer typeRegistryConfigurer = (TypeRegistryConfigurer) reflections.instantiateExactlyOneSubclass(TypeRegistryConfigurer.class, this.runnerOptions.getGlue(), new Class[0], new Object[0], new DefaultTypeRegistryConfiguration());
        if (typeRegistryConfigurer.getClass() != DefaultTypeRegistryConfiguration.class) {
            typeRegistry = new TypeRegistry(typeRegistryConfigurer.locale());
            typeRegistryConfigurer.configureTypeRegistry(typeRegistry);
        } else {
            cucumber.api.TypeRegistryConfigurer typeRegistryConfigurer2 = (cucumber.api.TypeRegistryConfigurer) reflections.instantiateExactlyOneSubclass(cucumber.api.TypeRegistryConfigurer.class, this.runnerOptions.getGlue(), new Class[0], new Object[0], new DefaultTypeRegistryConfiguration());
            typeRegistry = new TypeRegistry(typeRegistryConfigurer2.locale());
            typeRegistryConfigurer2.configureTypeRegistry(typeRegistry);
        }
        return reflections.instantiateSubclasses(Backend.class, this.packages, new Class[]{ResourceLoader.class, TypeRegistry.class}, new Object[]{this.resourceLoader, typeRegistry});
    }
}
