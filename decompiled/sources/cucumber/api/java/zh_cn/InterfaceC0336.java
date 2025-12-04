package cucumber.api.java.zh_cn;

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
/* renamed from: cucumber.api.java.zh_cn.但是, reason: contains not printable characters */
/* loaded from: classes5.dex */
public @interface InterfaceC0336 {
    long timeout() default 0;

    String value();
}
