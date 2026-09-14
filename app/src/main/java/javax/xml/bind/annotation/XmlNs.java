package javax.xml.bind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlNs {
    String namespaceURI();

    String prefix();
}
