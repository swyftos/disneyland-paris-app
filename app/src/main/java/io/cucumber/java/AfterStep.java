package io.cucumber.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@API(status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AfterStep {
    int order() default 10000;

    @Deprecated
    long timeout() default 0;

    String value() default "";
}
