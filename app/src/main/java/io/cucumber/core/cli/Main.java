package io.cucumber.core.cli;

import cucumber.runtime.Env;
import cucumber.runtime.Runtime;
import cucumber.runtime.p101io.MultiLoader;
import io.cucumber.core.options.CommandlineOptionsParser;
import io.cucumber.core.options.EnvironmentOptionsParser;
import io.cucumber.core.options.RuntimeOptions;

/* JADX INFO: loaded from: classes5.dex */
public class Main {
    public static void main(String[] strArr) {
        System.exit(run(strArr, Thread.currentThread().getContextClassLoader()));
    }

    public static byte run(String[] strArr, ClassLoader classLoader) {
        MultiLoader multiLoader = new MultiLoader(classLoader);
        RuntimeOptions runtimeOptionsBuild = new CommandlineOptionsParser(multiLoader).parse(strArr).addDefaultFormatterIfNotPresent().addDefaultSummaryPrinterIfNotPresent().build();
        new EnvironmentOptionsParser(multiLoader).parse(Env.INSTANCE).build(runtimeOptionsBuild);
        Runtime runtimeBuild = Runtime.builder().withRuntimeOptions(runtimeOptionsBuild).withClassLoader(classLoader).build();
        runtimeBuild.run();
        return runtimeBuild.exitStatus();
    }
}
