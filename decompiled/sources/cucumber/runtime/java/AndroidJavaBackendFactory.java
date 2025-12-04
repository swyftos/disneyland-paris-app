package cucumber.runtime.java;

import cucumber.api.java.ObjectFactory;
import cucumber.runtime.BackendSupplier;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.DefaultTypeRegistryConfiguration;
import cucumber.runtime.Env;
import cucumber.runtime.Reflections;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.core.options.RuntimeOptions;
import io.cucumber.stepexpression.TypeRegistry;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes5.dex */
public class AndroidJavaBackendFactory {
    public static BackendSupplier createBackend(final RuntimeOptions runtimeOptions, final ClassFinder classFinder) {
        return new BackendSupplier() { // from class: cucumber.runtime.java.AndroidJavaBackendFactory$$ExternalSyntheticLambda0
            @Override // cucumber.runtime.BackendSupplier
            public final Collection get() {
                return AndroidJavaBackendFactory.lambda$createBackend$0(classFinder, runtimeOptions);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$createBackend$0(ClassFinder classFinder, RuntimeOptions runtimeOptions) {
        Reflections reflections = new Reflections(classFinder);
        Env env = Env.INSTANCE;
        ObjectFactory objectFactoryLoadObjectFactory = ObjectFactoryLoader.loadObjectFactory(classFinder, JavaBackend.getObjectFactoryClassName(env), JavaBackend.getDeprecatedObjectFactoryClassName(env));
        TypeRegistryConfigurer typeRegistryConfigurer = (TypeRegistryConfigurer) reflections.instantiateExactlyOneSubclass(TypeRegistryConfigurer.class, runtimeOptions.getGlue(), new Class[0], new Object[0], new DefaultTypeRegistryConfiguration());
        TypeRegistry typeRegistry = new TypeRegistry(typeRegistryConfigurer.locale());
        typeRegistryConfigurer.configureTypeRegistry(typeRegistry);
        return Collections.singletonList(new JavaBackend(objectFactoryLoadObjectFactory, classFinder, typeRegistry));
    }
}
