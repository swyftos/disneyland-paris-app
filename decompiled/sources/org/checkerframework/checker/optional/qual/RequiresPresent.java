package org.checkerframework.checker.optional.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PreconditionAnnotation;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@PreconditionAnnotation(qualifier = Present.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface RequiresPresent {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @PreconditionAnnotation(qualifier = Present.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        RequiresPresent[] value();
    }

    String[] value();
}
