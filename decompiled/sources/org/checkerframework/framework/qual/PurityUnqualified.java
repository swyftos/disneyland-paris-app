package org.checkerframework.framework.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@InvisibleQualifier
@Documented
@Retention(RetentionPolicy.SOURCE)
@SubtypeOf({})
@DefaultQualifierInHierarchy
/* loaded from: classes6.dex */
public @interface PurityUnqualified {
}
