package io.cucumber.java.ht;

import cucumber.runtime.java.StepDefAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Target({ElementType.METHOD})
@API(status = API.Status.STABLE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@StepDefAnnotation
/* renamed from: io.cucumber.java.ht.Lè, reason: invalid class name */
/* loaded from: classes5.dex */
public @interface L {
    @Deprecated
    long timeout() default 0;

    String value();
}
