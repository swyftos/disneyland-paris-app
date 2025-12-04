package cucumber.runtime.java;

import cucumber.api.Transpose;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class ParameterInfo {
    private final boolean transposed;
    private final Type type;

    static List fromMethod(Method method) {
        ArrayList arrayList = new ArrayList();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < genericParameterTypes.length; i++) {
            boolean zValue = false;
            for (Annotation annotation : parameterAnnotations[i]) {
                if (annotation instanceof Transpose) {
                    zValue = ((Transpose) annotation).value();
                } else if (annotation instanceof io.cucumber.java.Transpose) {
                    zValue = ((io.cucumber.java.Transpose) annotation).value();
                }
            }
            arrayList.add(new ParameterInfo(genericParameterTypes[i], zValue));
        }
        return arrayList;
    }

    private ParameterInfo(Type type, boolean z) {
        this.type = type;
        this.transposed = z;
    }

    Type getType() {
        return this.type;
    }

    boolean isTransposed() {
        return this.transposed;
    }

    public String toString() {
        return this.type.toString();
    }
}
