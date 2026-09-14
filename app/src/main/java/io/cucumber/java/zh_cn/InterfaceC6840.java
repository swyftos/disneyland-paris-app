package io.cucumber.java.zh_cn;

import cucumber.runtime.java.StepDefAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

/* JADX INFO: renamed from: io.cucumber.java.zh_cn.并且 */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@API(status = API.Status.STABLE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@StepDefAnnotation
public @interface InterfaceC6840 {
    @Deprecated
    long timeout() default 0;

    String value();
}
