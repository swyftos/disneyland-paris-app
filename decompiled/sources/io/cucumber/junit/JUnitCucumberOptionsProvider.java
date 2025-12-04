package io.cucumber.junit;

import cucumber.api.SnippetType;
import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.junit.CucumberOptions;

/* loaded from: classes5.dex */
final class JUnitCucumberOptionsProvider implements CucumberOptionsAnnotationParser.OptionsProvider {
    JUnitCucumberOptionsProvider() {
    }

    @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.OptionsProvider
    public CucumberOptionsAnnotationParser.CucumberOptions getOptions(Class cls) {
        CucumberOptions cucumberOptions = (CucumberOptions) cls.getAnnotation(CucumberOptions.class);
        if (cucumberOptions == null) {
            return null;
        }
        return new JunitCucumberOptions(cucumberOptions);
    }

    private static class JunitCucumberOptions implements CucumberOptionsAnnotationParser.CucumberOptions {
        private final CucumberOptions annotation;

        JunitCucumberOptions(CucumberOptions cucumberOptions) {
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
            int i = AnonymousClass1.$SwitchMap$io$cucumber$junit$CucumberOptions$SnippetType[this.annotation.snippets().ordinal()];
            if (i == 1) {
                return SnippetType.UNDERSCORE;
            }
            if (i == 2) {
                return SnippetType.CAMELCASE;
            }
            throw new IllegalArgumentException("" + this.annotation.snippets());
        }

        @Override // io.cucumber.core.options.CucumberOptionsAnnotationParser.CucumberOptions
        public String[] junit() {
            return this.annotation.junit();
        }
    }

    /* renamed from: io.cucumber.junit.JUnitCucumberOptionsProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$cucumber$junit$CucumberOptions$SnippetType;

        static {
            int[] iArr = new int[CucumberOptions.SnippetType.values().length];
            $SwitchMap$io$cucumber$junit$CucumberOptions$SnippetType = iArr;
            try {
                iArr[CucumberOptions.SnippetType.UNDERSCORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$cucumber$junit$CucumberOptions$SnippetType[CucumberOptions.SnippetType.CAMELCASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
