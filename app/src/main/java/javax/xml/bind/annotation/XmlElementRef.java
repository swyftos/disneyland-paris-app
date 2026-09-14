package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElementRef {

    public static final class DEFAULT {
    }

    String name() default "##default";

    String namespace() default "";

    boolean required() default true;

    Class type() default DEFAULT.class;
}
