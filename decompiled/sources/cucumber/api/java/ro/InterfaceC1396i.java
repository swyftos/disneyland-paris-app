package cucumber.api.java.ro;

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
/* renamed from: cucumber.api.java.ro.Și, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes5.dex */
public @interface InterfaceC1396i {
    long timeout() default 0;

    String value();
}
