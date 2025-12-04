package androidx.test.internal.runner;

import androidx.test.internal.runner.junit3.AndroidJUnit3Builder;
import androidx.test.internal.runner.junit3.AndroidSuiteBuilder;
import androidx.test.internal.runner.junit4.AndroidAnnotatedBuilder;
import androidx.test.internal.runner.junit4.AndroidJUnit4Builder;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.builders.AnnotatedBuilder;
import org.junit.internal.builders.IgnoredBuilder;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes2.dex */
class AndroidRunnerBuilder extends AllDefaultPossibilitiesBuilder {
    private final AndroidAnnotatedBuilder androidAnnotatedBuilder;
    private final AndroidJUnit3Builder androidJUnit3Builder;
    private final AndroidJUnit4Builder androidJUnit4Builder;
    private final AndroidSuiteBuilder androidSuiteBuilder;
    private final List customRunnerBuilders;
    private final IgnoredBuilder ignoredBuilder;

    AndroidRunnerBuilder(AndroidRunnerParams androidRunnerParams, boolean z, List list) {
        this(null, androidRunnerParams, z, list);
    }

    AndroidRunnerBuilder(RunnerBuilder runnerBuilder, AndroidRunnerParams androidRunnerParams, boolean z, List list) {
        super(true);
        this.androidJUnit3Builder = new AndroidJUnit3Builder(androidRunnerParams, z);
        this.androidJUnit4Builder = new AndroidJUnit4Builder(androidRunnerParams, z);
        this.androidSuiteBuilder = new AndroidSuiteBuilder(androidRunnerParams);
        this.androidAnnotatedBuilder = new AndroidAnnotatedBuilder(runnerBuilder == null ? this : runnerBuilder, androidRunnerParams);
        this.ignoredBuilder = new IgnoredBuilder();
        this.customRunnerBuilders = instantiateRunnerBuilders(list);
    }

    private List instantiateRunnerBuilders(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            try {
                arrayList.add((RunnerBuilder) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (IllegalAccessException e) {
                String strValueOf = String.valueOf(cls);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 113);
                sb.append("Could not create instance of ");
                sb.append(strValueOf);
                sb.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb.toString(), e);
            } catch (InstantiationException e2) {
                String strValueOf2 = String.valueOf(cls);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 113);
                sb2.append("Could not create instance of ");
                sb2.append(strValueOf2);
                sb2.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb2.toString(), e2);
            } catch (NoSuchMethodException e3) {
                String strValueOf3 = String.valueOf(cls);
                StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 113);
                sb3.append("Could not create instance of ");
                sb3.append(strValueOf3);
                sb3.append(", make sure that it is a public concrete class with a public no-argument constructor");
                throw new IllegalStateException(sb3.toString(), e3);
            } catch (InvocationTargetException e4) {
                String strValueOf4 = String.valueOf(cls);
                StringBuilder sb4 = new StringBuilder(strValueOf4.length() + 74);
                sb4.append("Could not create instance of ");
                sb4.append(strValueOf4);
                sb4.append(", the constructor must not throw an exception");
                throw new IllegalStateException(sb4.toString(), e4);
            }
        }
        return arrayList;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder, org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class cls) {
        Iterator it = this.customRunnerBuilders.iterator();
        while (it.hasNext()) {
            Runner runnerSafeRunnerForClass = ((RunnerBuilder) it.next()).safeRunnerForClass(cls);
            if (runnerSafeRunnerForClass != null) {
                return runnerSafeRunnerForClass;
            }
        }
        return super.runnerForClass(cls);
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected JUnit4Builder junit4Builder() {
        return this.androidJUnit4Builder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected JUnit3Builder junit3Builder() {
        return this.androidJUnit3Builder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected AnnotatedBuilder annotatedBuilder() {
        return this.androidAnnotatedBuilder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected IgnoredBuilder ignoredBuilder() {
        return this.ignoredBuilder;
    }

    @Override // org.junit.internal.builders.AllDefaultPossibilitiesBuilder
    protected RunnerBuilder suiteMethodBuilder() {
        return this.androidSuiteBuilder;
    }
}
