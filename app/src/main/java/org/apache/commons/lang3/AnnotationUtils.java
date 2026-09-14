package org.apache.commons.lang3;

import gherkin.GherkinLanguageConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.exception.UncheckedException;

/* JADX INFO: loaded from: classes6.dex */
public class AnnotationUtils {
    private static final ToStringStyle TO_STRING_STYLE = new C75381();

    /* JADX INFO: renamed from: org.apache.commons.lang3.AnnotationUtils$1 */
    class C75381 extends ToStringStyle {
        private static final long serialVersionUID = 1;

        C75381() {
            setDefaultFullDetail(true);
            setArrayContentDetail(true);
            setUseClassName(true);
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
            setContentStart("(");
            setContentEnd(")");
            setFieldSeparator(", ");
            setArrayStart("[");
            setArrayEnd("]");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        protected void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            if (obj instanceof Annotation) {
                obj = AnnotationUtils.toString((Annotation) obj);
            }
            super.appendDetail(stringBuffer, str, obj);
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        protected String getShortClassName(Class cls) {
            final Class<Annotation> cls2 = Annotation.class;
            return (String) ClassUtils.getAllInterfaces(cls).stream().filter(new Predicate() { // from class: org.apache.commons.lang3.AnnotationUtils$1$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return cls2.isAssignableFrom((Class) obj);
                }
            }).findFirst().map(new Function() { // from class: org.apache.commons.lang3.AnnotationUtils$1$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return AnnotationUtils.C75381.lambda$getShortClassName$0((Class) obj);
                }
            }).orElse("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getShortClassName$0(Class cls) {
            return GherkinLanguageConstants.TAG_PREFIX + cls.getName();
        }
    }

    private static boolean annotationArrayMemberEquals(Annotation[] annotationArr, Annotation[] annotationArr2) {
        if (annotationArr.length != annotationArr2.length) {
            return false;
        }
        for (int i = 0; i < annotationArr.length; i++) {
            if (!equals(annotationArr[i], annotationArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean arrayMemberEquals(Class cls, Object obj, Object obj2) {
        if (cls.isAnnotation()) {
            return annotationArrayMemberEquals((Annotation[]) obj, (Annotation[]) obj2);
        }
        if (cls.equals(Byte.TYPE)) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        if (cls.equals(Short.TYPE)) {
            return Arrays.equals((short[]) obj, (short[]) obj2);
        }
        if (cls.equals(Integer.TYPE)) {
            return Arrays.equals((int[]) obj, (int[]) obj2);
        }
        if (cls.equals(Character.TYPE)) {
            return Arrays.equals((char[]) obj, (char[]) obj2);
        }
        if (cls.equals(Long.TYPE)) {
            return Arrays.equals((long[]) obj, (long[]) obj2);
        }
        if (cls.equals(Float.TYPE)) {
            return Arrays.equals((float[]) obj, (float[]) obj2);
        }
        if (cls.equals(Double.TYPE)) {
            return Arrays.equals((double[]) obj, (double[]) obj2);
        }
        if (cls.equals(Boolean.TYPE)) {
            return Arrays.equals((boolean[]) obj, (boolean[]) obj2);
        }
        return Arrays.equals((Object[]) obj, (Object[]) obj2);
    }

    private static int arrayMemberHash(Class cls, Object obj) {
        if (cls.equals(Byte.TYPE)) {
            return Arrays.hashCode((byte[]) obj);
        }
        if (cls.equals(Short.TYPE)) {
            return Arrays.hashCode((short[]) obj);
        }
        if (cls.equals(Integer.TYPE)) {
            return Arrays.hashCode((int[]) obj);
        }
        if (cls.equals(Character.TYPE)) {
            return Arrays.hashCode((char[]) obj);
        }
        if (cls.equals(Long.TYPE)) {
            return Arrays.hashCode((long[]) obj);
        }
        if (cls.equals(Float.TYPE)) {
            return Arrays.hashCode((float[]) obj);
        }
        if (cls.equals(Double.TYPE)) {
            return Arrays.hashCode((double[]) obj);
        }
        if (cls.equals(Boolean.TYPE)) {
            return Arrays.hashCode((boolean[]) obj);
        }
        return Arrays.hashCode((Object[]) obj);
    }

    public static boolean equals(Annotation annotation, Annotation annotation2) {
        if (annotation == annotation2) {
            return true;
        }
        if (annotation != null && annotation2 != null) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<? extends Annotation> clsAnnotationType2 = annotation2.annotationType();
            Validate.notNull(clsAnnotationType, "Annotation %s with null annotationType()", annotation);
            Validate.notNull(clsAnnotationType2, "Annotation %s with null annotationType()", annotation2);
            if (!clsAnnotationType.equals(clsAnnotationType2)) {
                return false;
            }
            try {
                for (Method method : clsAnnotationType.getDeclaredMethods()) {
                    if (method.getParameterTypes().length == 0 && isValidAnnotationMemberType(method.getReturnType())) {
                        if (!memberEquals(method.getReturnType(), method.invoke(annotation, new Object[0]), method.invoke(annotation2, new Object[0]))) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (ReflectiveOperationException unused) {
            }
        }
        return false;
    }

    public static int hashCode(Annotation annotation) {
        int iHashMember = 0;
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            try {
                Object objInvoke = method.invoke(annotation, new Object[0]);
                if (objInvoke == null) {
                    throw new IllegalStateException(String.format("Annotation method %s returned null", method));
                }
                iHashMember += hashMember(method.getName(), objInvoke);
            } catch (ReflectiveOperationException e) {
                throw new UncheckedException(e);
            }
        }
        return iHashMember;
    }

    private static int hashMember(String str, Object obj) {
        int iHashCode;
        int iHashCode2 = str.hashCode() * 127;
        if (ObjectUtils.isArray(obj)) {
            iHashCode = arrayMemberHash(obj.getClass().getComponentType(), obj);
        } else if (obj instanceof Annotation) {
            iHashCode = hashCode((Annotation) obj);
        } else {
            iHashCode = obj.hashCode();
        }
        return iHashCode2 ^ iHashCode;
    }

    public static boolean isValidAnnotationMemberType(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls.isPrimitive() || cls.isEnum() || cls.isAnnotation() || String.class.equals(cls) || Class.class.equals(cls);
    }

    private static boolean memberEquals(Class cls, Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (cls.isArray()) {
            return arrayMemberEquals(cls.getComponentType(), obj, obj2);
        }
        if (cls.isAnnotation()) {
            return equals((Annotation) obj, (Annotation) obj2);
        }
        return obj.equals(obj2);
    }

    public static String toString(Annotation annotation) {
        ToStringBuilder toStringBuilder = new ToStringBuilder(annotation, TO_STRING_STYLE);
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            if (method.getParameterTypes().length <= 0) {
                try {
                    toStringBuilder.append(method.getName(), method.invoke(annotation, new Object[0]));
                } catch (ReflectiveOperationException e) {
                    throw new UncheckedException(e);
                }
            }
        }
        return toStringBuilder.build();
    }

    @Deprecated
    public AnnotationUtils() {
    }
}
