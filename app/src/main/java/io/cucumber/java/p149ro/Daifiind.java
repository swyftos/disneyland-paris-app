package io.cucumber.java.p149ro;

import cucumber.runtime.java.StepDefAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

/* JADX INFO: renamed from: io.cucumber.java.ro.Daţifiind, reason: invalid class name */
/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@API(status = API.Status.STABLE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@StepDefAnnotation
public @interface Daifiind {
    @Deprecated
    long timeout() default 0;

    String value();
}
