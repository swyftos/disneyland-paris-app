package io.cucumber.core.options;

import cucumber.runtime.Env;
import cucumber.runtime.Shellwords;
import cucumber.runtime.p101io.MultiLoader;
import cucumber.runtime.p101io.ResourceLoader;
import io.cucumber.core.model.RerunLoader;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class EnvironmentOptionsParser {
    private final ResourceLoader resourceLoader;

    public EnvironmentOptionsParser(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public EnvironmentOptionsParser() {
        this(new MultiLoader(EnvironmentOptionsParser.class.getClassLoader()));
    }

    public RuntimeOptionsBuilder parse(Env env) {
        RuntimeOptionsParser runtimeOptionsParser = new RuntimeOptionsParser(new RerunLoader(this.resourceLoader));
        String str = env.get("cucumber.options");
        List<String> listEmptyList = Collections.emptyList();
        if (str != null) {
            listEmptyList = Shellwords.parse(str);
        }
        return runtimeOptionsParser.parse(listEmptyList);
    }
}
