package cucumber.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
/* loaded from: classes5.dex */
public @interface CucumberOptions {
    boolean dryRun() default false;

    String[] extraGlue() default {};

    String[] features() default {};

    String[] glue() default {};

    String[] junit() default {};

    boolean monochrome() default false;

    String[] name() default {};

    String[] plugin() default {};

    SnippetType snippets() default SnippetType.UNDERSCORE;

    boolean strict() default false;

    String[] tags() default {};
}
