package androidx.test.filters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface SdkSuppress {
    String codeName() default "unset";

    int maxSdkVersion() default Integer.MAX_VALUE;

    int minSdkVersion() default 1;
}
