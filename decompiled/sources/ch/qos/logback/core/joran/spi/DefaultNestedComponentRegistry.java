package ch.qos.logback.core.joran.spi;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class DefaultNestedComponentRegistry {
    Map defaultComponentMap = new HashMap();

    private Class oneShotFind(Class cls, String str) {
        return (Class) this.defaultComponentMap.get(new HostClassAndPropertyDouble(cls, str));
    }

    public void add(Class<?> cls, String str, Class<?> cls2) {
        this.defaultComponentMap.put(new HostClassAndPropertyDouble(cls, str.toLowerCase(Locale.US)), cls2);
    }

    public Class<?> findDefaultComponentType(Class<?> cls, String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        while (cls != null) {
            Class<?> clsOneShotFind = oneShotFind(cls, lowerCase);
            if (clsOneShotFind != null) {
                return clsOneShotFind;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }
}
