package org.junit.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.manipulation.Ordering;
import org.junit.validator.ValidateWith;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE})
@ValidateWith(OrderWithValidator.class)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderWith {
    Class<? extends Ordering.Factory> value();
}
