package io.cucumber.core.options;

import cucumber.api.SnippetType;
import cucumber.runtime.CucumberException;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import gherkin.GherkinLanguageConstants;
import io.cucumber.core.model.FeaturePath;
import io.cucumber.core.model.FeatureWithLines;
import io.cucumber.core.model.GluePath;
import io.cucumber.core.model.RerunLoader;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class CucumberOptionsAnnotationParser {
    private CoreCucumberOptionsProvider coreCucumberOptionsProvider;
    private boolean featuresSpecified;
    private OptionsProvider optionsProvider;
    private boolean overridingGlueSpecified;
    private final RerunLoader rerunLoader;

    public interface CucumberOptions {
        boolean dryRun();

        String[] extraGlue();

        String[] features();

        String[] glue();

        String[] junit();

        boolean monochrome();

        String[] name();

        String[] plugin();

        SnippetType snippets();

        boolean strict();

        String[] tags();
    }

    public interface OptionsProvider {
        CucumberOptions getOptions(Class<?> cls);
    }

    public CucumberOptionsAnnotationParser() {
        this(new MultiLoader(CucumberOptionsAnnotationParser.class.getClassLoader()));
    }

    public CucumberOptionsAnnotationParser(ResourceLoader resourceLoader) {
        this.featuresSpecified = false;
        this.overridingGlueSpecified = false;
        this.coreCucumberOptionsProvider = new CoreCucumberOptionsProvider();
        this.rerunLoader = new RerunLoader(resourceLoader);
    }

    public CucumberOptionsAnnotationParser withOptionsProvider(OptionsProvider optionsProvider) {
        this.optionsProvider = optionsProvider;
        return this;
    }

    public RuntimeOptionsBuilder parse(Class<?> cls) {
        RuntimeOptionsBuilder runtimeOptionsBuilder = new RuntimeOptionsBuilder();
        for (Class<?> superclass = cls; hasSuperClass(superclass); superclass = superclass.getSuperclass()) {
            OptionsProvider optionsProvider = this.optionsProvider;
            CucumberOptions options = optionsProvider != null ? optionsProvider.getOptions(superclass) : null;
            if (options == null) {
                options = this.coreCucumberOptionsProvider.getOptions(superclass);
            }
            if (options != null) {
                addDryRun(options, runtimeOptionsBuilder);
                addMonochrome(options, runtimeOptionsBuilder);
                addTags(options, runtimeOptionsBuilder);
                addPlugins(options, runtimeOptionsBuilder);
                addStrict(options, runtimeOptionsBuilder);
                addName(options, runtimeOptionsBuilder);
                addSnippets(options, runtimeOptionsBuilder);
                addGlue(options, runtimeOptionsBuilder);
                addFeatures(options, runtimeOptionsBuilder);
                addJunitOptions(options, runtimeOptionsBuilder);
            }
        }
        addDefaultFeaturePathIfNoFeaturePathIsSpecified(runtimeOptionsBuilder, cls);
        addDefaultGlueIfNoOverridingGlueIsSpecified(runtimeOptionsBuilder, cls);
        return runtimeOptionsBuilder;
    }

    private void addName(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        for (String str : cucumberOptions.name()) {
            runtimeOptionsBuilder.addNameFilter(Pattern.compile(str));
        }
    }

    private void addSnippets(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        runtimeOptionsBuilder.setSnippetType(cucumberOptions.snippets());
    }

    private void addDryRun(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        if (cucumberOptions.dryRun()) {
            runtimeOptionsBuilder.setDryRun(true);
        }
    }

    private void addMonochrome(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        if (cucumberOptions.monochrome() || runningInEnvironmentWithoutAnsiSupport()) {
            runtimeOptionsBuilder.setMonochrome(true);
        }
    }

    private void addTags(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        for (String str : cucumberOptions.tags()) {
            runtimeOptionsBuilder.addTagFilter(str);
        }
    }

    private void addPlugins(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        for (String str : cucumberOptions.plugin()) {
            runtimeOptionsBuilder.addPluginName(str, false);
        }
    }

    private void addFeatures(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        if (cucumberOptions == null || cucumberOptions.features().length == 0) {
            return;
        }
        for (String str : cucumberOptions.features()) {
            if (str.startsWith(GherkinLanguageConstants.TAG_PREFIX)) {
                runtimeOptionsBuilder.addRerun(this.rerunLoader.load(FeaturePath.parse(str.substring(1))));
            } else {
                runtimeOptionsBuilder.addFeature(FeatureWithLines.parse(str));
            }
        }
        this.featuresSpecified = true;
    }

    private void addDefaultFeaturePathIfNoFeaturePathIsSpecified(RuntimeOptionsBuilder runtimeOptionsBuilder, Class cls) {
        if (this.featuresSpecified) {
            return;
        }
        runtimeOptionsBuilder.addFeature(FeatureWithLines.parse(packagePath(cls)));
    }

    private void addGlue(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        boolean z = cucumberOptions.extraGlue().length > 0;
        boolean z2 = cucumberOptions.glue().length > 0;
        if (z && z2) {
            throw new CucumberException("glue and extraGlue cannot be specified at the same time");
        }
        String[] strArrGlue = new String[0];
        if (z) {
            strArrGlue = cucumberOptions.extraGlue();
        }
        if (z2) {
            strArrGlue = cucumberOptions.glue();
            this.overridingGlueSpecified = true;
        }
        for (String str : strArrGlue) {
            runtimeOptionsBuilder.addGlue(GluePath.parse(str));
        }
    }

    private void addDefaultGlueIfNoOverridingGlueIsSpecified(RuntimeOptionsBuilder runtimeOptionsBuilder, Class cls) {
        if (this.overridingGlueSpecified) {
            return;
        }
        runtimeOptionsBuilder.addGlue(GluePath.parse(packageName(cls)));
    }

    private void addStrict(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        if (cucumberOptions.strict()) {
            runtimeOptionsBuilder.setStrict(true);
        }
    }

    private void addJunitOptions(CucumberOptions cucumberOptions, RuntimeOptionsBuilder runtimeOptionsBuilder) {
        for (String str : cucumberOptions.junit()) {
            runtimeOptionsBuilder.addJunitOption(str);
        }
    }

    private static String packagePath(Class cls) {
        String strPackageName = packageName(cls);
        if (strPackageName.isEmpty()) {
            return "classpath:/";
        }
        return "classpath:" + strPackageName.replace('.', '/');
    }

    static String packageName(Class cls) {
        String name = cls.getName();
        return name.substring(0, Math.max(0, name.lastIndexOf(46)));
    }

    private boolean runningInEnvironmentWithoutAnsiSupport() {
        return System.getProperty("idea.launcher.bin.path") != null;
    }

    private boolean hasSuperClass(Class cls) {
        return cls != Object.class;
    }

    private static class CoreCucumberOptions implements CucumberOptions {
        private final cucumber.api.CucumberOptions annotation;

        CoreCucumberOptions(cucumber.api.CucumberOptions cucumberOptions) {
            this.annotation = cucumberOptions;
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public boolean dryRun() {
            return this.annotation.dryRun();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public boolean strict() {
            return this.annotation.strict();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] features() {
            return this.annotation.features();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] glue() {
            return this.annotation.glue();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] extraGlue() {
            return this.annotation.extraGlue();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] tags() {
            return this.annotation.tags();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] plugin() {
            return this.annotation.plugin();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public boolean monochrome() {
            return this.annotation.monochrome();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] name() {
            return this.annotation.name();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public SnippetType snippets() {
            return this.annotation.snippets();
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] junit() {
            return this.annotation.junit();
        }
    }

    private static class CoreCucumberOptionsProvider implements OptionsProvider {
        private CoreCucumberOptionsProvider() {
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.OptionsProvider
        public CucumberOptions getOptions(Class cls) {
            cucumber.api.CucumberOptions cucumberOptions = (cucumber.api.CucumberOptions) cls.getAnnotation(cucumber.api.CucumberOptions.class);
            if (cucumberOptions == null) {
                return null;
            }
            return new CoreCucumberOptions(cucumberOptions);
        }
    }
}
