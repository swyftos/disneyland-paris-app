package cucumber.api.java.uz;

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
/* renamed from: cucumber.api.java.uz.Лекин, reason: contains not printable characters */
/* loaded from: classes5.dex */
public @interface InterfaceC0334 {
    long timeout() default 0;

    String value();
}
