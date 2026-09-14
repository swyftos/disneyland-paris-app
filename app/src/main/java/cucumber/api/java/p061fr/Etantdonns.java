package cucumber.api.java.p061fr;

import cucumber.runtime.java.StepDefAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: cucumber.api.java.fr.Etantdonnés, reason: invalid class name */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
@StepDefAnnotation
public @interface Etantdonns {
    long timeout() default 0;

    String value();
}
