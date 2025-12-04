package androidx.media3.common.util;

import androidx.annotation.RequiresOptIn;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@RequiresOptIn(level = RequiresOptIn.Level.ERROR)
@Documented
@Retention(RetentionPolicy.CLASS)
@UnstableApi
/* loaded from: classes.dex */
public @interface UnstableApi {
}
