package cucumber.api.java.zh_tw;

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
/* renamed from: cucumber.api.java.zh_tw.假設, reason: contains not printable characters */
/* loaded from: classes5.dex */
public @interface InterfaceC0349 {
    long timeout() default 0;

    String value();
}
