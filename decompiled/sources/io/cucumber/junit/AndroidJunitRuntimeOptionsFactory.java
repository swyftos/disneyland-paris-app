package io.cucumber.junit;

import android.content.Context;
import android.util.Log;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.CucumberException;
import cucumber.runtime.Env;
import cucumber.runtime.io.MultiLoader;
import io.cucumber.core.model.GluePath;
import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.core.options.EnvironmentOptionsParser;
import io.cucumber.core.options.RuntimeOptions;

/* loaded from: classes5.dex */
abstract class AndroidJunitRuntimeOptionsFactory {

    static class Options {
        final JUnitOptions jUnitOptions;
        final RuntimeOptions runtimeOptions;

        Options(RuntimeOptions runtimeOptions, JUnitOptions jUnitOptions) {
            this.runtimeOptions = runtimeOptions;
            this.jUnitOptions = jUnitOptions;
        }
    }

    static Options createRuntimeOptions(Context context, ClassFinder classFinder, ClassLoader classLoader) {
        for (Class<?> cls : classFinder.getDescendants(Object.class, GluePath.parse(context.getPackageName()))) {
            if (cls.isAnnotationPresent(CucumberOptions.class)) {
                Log.d("cucumber-android", "Found CucumberOptions in class " + cls.getName());
                MultiLoader multiLoader = new MultiLoader(classLoader);
                RuntimeOptions runtimeOptionsBuild = new EnvironmentOptionsParser(multiLoader).parse(Env.INSTANCE).build(new CucumberOptionsAnnotationParser(multiLoader).withOptionsProvider(new JUnitCucumberOptionsProvider()).parse(cls).build());
                return new Options(runtimeOptionsBuild, new JUnitOptionsParser().parse(runtimeOptionsBuild.getJunitOptions()).setStrict(runtimeOptionsBuild.isStrict()).build(new JUnitOptionsParser().parse(cls).build()));
            }
        }
        throw new CucumberException("No CucumberOptions annotation");
    }
}
