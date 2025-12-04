package io.cucumber.java.en_old;

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
/* renamed from: io.cucumber.java.en_old.Þurh, reason: invalid class name and case insensitive filesystem */
/* loaded from: classes5.dex */
public @interface InterfaceC1399urh {
    @Deprecated
    long timeout() default 0;

    String value();
}
