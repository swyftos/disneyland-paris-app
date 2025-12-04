package org.junit.internal.builders;

import java.lang.reflect.Modifier;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes6.dex */
public class AnnotatedBuilder extends RunnerBuilder {
    private final RunnerBuilder suiteBuilder;

    public AnnotatedBuilder(RunnerBuilder runnerBuilder) {
        this.suiteBuilder = runnerBuilder;
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Exception {
        Class<?> enclosingClassForNonStaticMemberClass = cls;
        while (enclosingClassForNonStaticMemberClass != null) {
            RunWith runWith = (RunWith) enclosingClassForNonStaticMemberClass.getAnnotation(RunWith.class);
            if (runWith == null) {
                enclosingClassForNonStaticMemberClass = getEnclosingClassForNonStaticMemberClass(enclosingClassForNonStaticMemberClass);
            } else {
                return buildRunner(runWith.value(), cls);
            }
        }
        return null;
    }

    private Class getEnclosingClassForNonStaticMemberClass(Class cls) {
        if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    public Runner buildRunner(Class<? extends Runner> cls, Class<?> cls2) throws Exception {
        try {
            try {
                return cls.getConstructor(Class.class).newInstance(cls2);
            } catch (NoSuchMethodException unused) {
                return cls.getConstructor(Class.class, RunnerBuilder.class).newInstance(cls2, this.suiteBuilder);
            }
        } catch (NoSuchMethodException unused2) {
            String simpleName = cls.getSimpleName();
            throw new InitializationError(String.format("Custom runner class %s should have a public constructor with signature %s(Class testClass)", simpleName, simpleName));
        }
    }
}
