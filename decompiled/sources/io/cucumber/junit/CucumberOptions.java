package io.cucumber.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Target({ElementType.TYPE})
@API(status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface CucumberOptions {

    public enum SnippetType {
        UNDERSCORE,
        CAMELCASE
    }

    boolean dryRun() default false;

    String[] extraGlue() default {};

    String[] features() default {};

    String[] glue() default {};

    @Deprecated
    String[] junit() default {};

    boolean monochrome() default false;

    String[] name() default {};

    String[] plugin() default {};

    SnippetType snippets() default SnippetType.UNDERSCORE;

    boolean stepNotifications() default false;

    boolean strict() default false;

    String[] tags() default {};

    boolean useFileNameCompatibleName() default false;
}
