package cucumber.api.java.sr_cyrl;

import cucumber.runtime.java.StepDefAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: cucumber.api.java.sr_cyrl.Онда, reason: contains not printable characters */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
@StepDefAnnotation
public @interface InterfaceC8259 {
    long timeout() default 0;

    String value();
}
