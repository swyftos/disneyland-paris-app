package io.cucumber.core.options;

import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import io.cucumber.core.model.RerunLoader;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public final class CommandlineOptionsParser {
    private final ResourceLoader resourceLoader;

    public CommandlineOptionsParser() {
        this(new MultiLoader(CommandlineOptionsParser.class.getClassLoader()));
    }

    public CommandlineOptionsParser(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public RuntimeOptionsBuilder parse(List<String> list) {
        return new RuntimeOptionsParser(new RerunLoader(this.resourceLoader)).parse(list);
    }

    public RuntimeOptionsBuilder parse(String... strArr) {
        return parse(Arrays.asList(strArr));
    }
}
