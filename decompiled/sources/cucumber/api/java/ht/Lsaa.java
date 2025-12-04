package cucumber.api.java.ht;

import cucumber.runtime.java.StepDefAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
@StepDefAnnotation
/* renamed from: cucumber.api.java.ht.Lèsaa, reason: invalid class name */
/* loaded from: classes5.dex */
public @interface Lsaa {
    long timeout() default 0;

    String value();
}
