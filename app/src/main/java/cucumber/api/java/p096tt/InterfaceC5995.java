package cucumber.api.java.p096tt;

import cucumber.runtime.java.StepDefAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: cucumber.api.java.tt.Вә */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
@StepDefAnnotation
public @interface InterfaceC5995 {
    long timeout() default 0;

    String value();
}
