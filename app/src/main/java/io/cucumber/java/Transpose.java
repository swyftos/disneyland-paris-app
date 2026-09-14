package io.cucumber.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.PARAMETER})
@API(status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transpose {
    boolean value() default true;
}
