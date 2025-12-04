package cucumber.runtime.java;

import cucumber.api.java.ObjectFactory;
import cucumber.api.java8.GlueBase;
import cucumber.runtime.Backend;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.DuplicateStepDefinitionException;
import cucumber.runtime.Env;
import cucumber.runtime.Glue;
import cucumber.runtime.HookDefinition;
import cucumber.runtime.StepDefinition;
import cucumber.runtime.Utils;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.snippets.FunctionNameGenerator;
import cucumber.runtime.snippets.Snippet;
import cucumber.runtime.snippets.SnippetGenerator;
import gherkin.pickles.PickleStep;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.stepexpression.TypeRegistry;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class JavaBackend implements Backend, LambdaGlueRegistry {
    private final ClassFinder classFinder;
    private Glue glue;
    private List glueBaseClasses;
    private final MethodScanner methodScanner;
    private final ObjectFactory objectFactory;
    private final SnippetGenerator snippetGenerator;
    private final TypeRegistry typeRegistry;

    static String getObjectFactoryClassName(Env env) {
        return env.get("cucumber.object-factory");
    }

    static String getDeprecatedObjectFactoryClassName(Env env) {
        return env.get(ObjectFactory.class.getName());
    }

    private Snippet createSnippet() throws ClassNotFoundException {
        try {
            Thread.currentThread().getContextClassLoader().loadClass("cucumber.runtime.java8.LambdaGlueBase");
            return new Java8Snippet();
        } catch (ClassNotFoundException unused) {
            return new JavaSnippet();
        }
    }

    public JavaBackend(ResourceLoader resourceLoader, TypeRegistry typeRegistry) {
        this(new ResourceLoaderClassFinder(resourceLoader, Thread.currentThread().getContextClassLoader()), typeRegistry);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    JavaBackend(ClassFinder classFinder, TypeRegistry typeRegistry) {
        Env env = Env.INSTANCE;
        this(ObjectFactoryLoader.loadObjectFactory(classFinder, getObjectFactoryClassName(env), getDeprecatedObjectFactoryClassName(env)), classFinder, typeRegistry);
    }

    JavaBackend(ObjectFactory objectFactory, ClassFinder classFinder, TypeRegistry typeRegistry) {
        this.glueBaseClasses = new ArrayList();
        this.classFinder = classFinder;
        this.objectFactory = objectFactory;
        this.methodScanner = new MethodScanner(classFinder);
        this.snippetGenerator = new SnippetGenerator(createSnippet(), typeRegistry.parameterTypeRegistry());
        this.typeRegistry = typeRegistry;
    }

    @Override // cucumber.runtime.Backend
    public void loadGlue(Glue glue, List<URI> list) throws SecurityException {
        this.glue = glue;
        this.methodScanner.scan(this, list);
        Iterator<URI> it = list.iterator();
        while (it.hasNext()) {
            for (Class<?> cls : this.classFinder.getDescendants(GlueBase.class, it.next())) {
                if (!cls.isInterface() && this.objectFactory.addClass(cls)) {
                    this.glueBaseClasses.add(cls);
                }
            }
        }
    }

    public void loadGlue(Glue glue, Method method, Class<?> cls) {
        this.glue = glue;
        this.methodScanner.scan(this, method, cls);
    }

    @Override // cucumber.runtime.Backend
    public void buildWorld() {
        this.objectFactory.start();
        try {
            LambdaGlueRegistry.INSTANCE.set(this);
            Iterator it = this.glueBaseClasses.iterator();
            while (it.hasNext()) {
                this.objectFactory.getInstance((Class) it.next());
            }
        } finally {
            LambdaGlueRegistry.INSTANCE.remove();
        }
    }

    @Override // cucumber.runtime.Backend
    public void disposeWorld() {
        this.objectFactory.stop();
    }

    @Override // cucumber.runtime.Backend
    public List<String> getSnippet(PickleStep pickleStep, String str, FunctionNameGenerator functionNameGenerator) {
        return this.snippetGenerator.getSnippet(pickleStep, str, functionNameGenerator);
    }

    void addStepDefinition(Annotation annotation, Method method) {
        try {
            if (this.objectFactory.addClass(method.getDeclaringClass())) {
                this.glue.addStepDefinition(new JavaStepDefinition(method, expression(annotation), timeoutMillis(annotation), this.objectFactory, this.typeRegistry));
            }
        } catch (CucumberException e) {
            throw e;
        } catch (Throwable th) {
            throw new CucumberException(th);
        }
    }

    @Override // cucumber.runtime.java.LambdaGlueRegistry
    public void addStepDefinition(Function<TypeRegistry, StepDefinition> function) throws DuplicateStepDefinitionException {
        this.glue.addStepDefinition(function.apply(this.typeRegistry));
    }

    void addHook(Annotation annotation, Method method) {
        if (this.objectFactory.addClass(method.getDeclaringClass())) {
            if (annotation.annotationType().equals(Before.class)) {
                Before before = (Before) annotation;
                addBeforeHookDefinition(new JavaHookDefinition(method, new String[]{before.value()}, before.order(), before.timeout(), this.objectFactory));
                return;
            }
            if (annotation.annotationType().equals(After.class)) {
                After after = (After) annotation;
                addAfterHookDefinition(new JavaHookDefinition(method, new String[]{after.value()}, after.order(), after.timeout(), this.objectFactory));
                return;
            }
            if (annotation.annotationType().equals(BeforeStep.class)) {
                BeforeStep beforeStep = (BeforeStep) annotation;
                addBeforeStepHookDefinition(new JavaHookDefinition(method, new String[]{beforeStep.value()}, beforeStep.order(), beforeStep.timeout(), this.objectFactory));
                return;
            }
            if (annotation.annotationType().equals(AfterStep.class)) {
                AfterStep afterStep = (AfterStep) annotation;
                addAfterStepHookDefinition(new JavaHookDefinition(method, new String[]{afterStep.value()}, afterStep.order(), afterStep.timeout(), this.objectFactory));
                return;
            }
            if (annotation.annotationType().equals(cucumber.api.java.Before.class)) {
                cucumber.api.java.Before before2 = (cucumber.api.java.Before) annotation;
                addBeforeHookDefinition(new JavaHookDefinition(method, before2.value(), before2.order(), before2.timeout(), this.objectFactory));
                return;
            }
            if (annotation.annotationType().equals(cucumber.api.java.After.class)) {
                cucumber.api.java.After after2 = (cucumber.api.java.After) annotation;
                addAfterHookDefinition(new JavaHookDefinition(method, after2.value(), after2.order(), after2.timeout(), this.objectFactory));
                return;
            }
            if (annotation.annotationType().equals(cucumber.api.java.BeforeStep.class)) {
                cucumber.api.java.BeforeStep beforeStep2 = (cucumber.api.java.BeforeStep) annotation;
                addBeforeStepHookDefinition(new JavaHookDefinition(method, beforeStep2.value(), beforeStep2.order(), beforeStep2.timeout(), this.objectFactory));
                return;
            }
            if (annotation.annotationType().equals(cucumber.api.java.AfterStep.class)) {
                cucumber.api.java.AfterStep afterStep2 = (cucumber.api.java.AfterStep) annotation;
                addAfterStepHookDefinition(new JavaHookDefinition(method, afterStep2.value(), afterStep2.order(), afterStep2.timeout(), this.objectFactory));
            }
        }
    }

    @Override // cucumber.runtime.java.LambdaGlueRegistry
    public void addBeforeHookDefinition(HookDefinition hookDefinition) {
        this.glue.addBeforeHook(hookDefinition);
    }

    @Override // cucumber.runtime.java.LambdaGlueRegistry
    public void addAfterHookDefinition(HookDefinition hookDefinition) {
        this.glue.addAfterHook(hookDefinition);
    }

    @Override // cucumber.runtime.java.LambdaGlueRegistry
    public void addAfterStepHookDefinition(HookDefinition hookDefinition) {
        this.glue.addAfterStepHook(hookDefinition);
    }

    @Override // cucumber.runtime.java.LambdaGlueRegistry
    public void addBeforeStepHookDefinition(HookDefinition hookDefinition) {
        this.glue.addBeforeStepHook(hookDefinition);
    }

    private String expression(Annotation annotation) {
        return (String) Utils.invoke(annotation, annotation.getClass().getMethod("value", new Class[0]), 0L, new Object[0]);
    }

    private long timeoutMillis(Annotation annotation) {
        return ((Long) Utils.invoke(annotation, annotation.getClass().getMethod("timeout", new Class[0]), 0L, new Object[0])).longValue();
    }
}
