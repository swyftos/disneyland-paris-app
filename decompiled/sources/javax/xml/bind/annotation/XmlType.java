package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface XmlType {

    public static final class DEFAULT {
    }

    Class factoryClass() default DEFAULT.class;

    String factoryMethod() default "";

    String name() default "##default";

    String namespace() default "##default";

    String[] propOrder() default {""};
}
