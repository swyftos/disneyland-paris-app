package androidx.test.services.events;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.services.events.internal.StackTrimmer;
import ch.qos.logback.core.joran.action.ActionConst;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

/* loaded from: classes2.dex */
public final class ParcelableConverter {
    @NonNull
    public static TestCaseInfo getTestCaseFromDescription(@NonNull Description description) throws TestEventException {
        List<AnnotationInfo> listEmptyList;
        if (!isValidJUnitDescription(description)) {
            String strValueOf = String.valueOf(description);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 33);
            sb.append("Unexpected description instance: ");
            sb.append(strValueOf);
            throw new TestEventException(sb.toString());
        }
        List<AnnotationInfo> annotationsFromCollection = getAnnotationsFromCollection(description.getAnnotations());
        if (description.getTestClass() != null) {
            listEmptyList = getAnnotationsFromArray(description.getTestClass().getAnnotations());
        } else {
            listEmptyList = Collections.emptyList();
        }
        return new TestCaseInfo(description.getClassName(), description.getMethodName() != null ? description.getMethodName() : "", annotationsFromCollection, listEmptyList);
    }

    public static boolean isValidJUnitDescription(@NonNull Description description) {
        return (description.equals(Description.EMPTY) || description.equals(Description.TEST_MECHANISM)) ? false : true;
    }

    @NonNull
    public static List<AnnotationInfo> getAnnotationsFromArray(@NonNull Annotation[] annotationArr) {
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(getAnnotation(annotation));
        }
        return arrayList;
    }

    @NonNull
    public static List<AnnotationInfo> getAnnotationsFromCollection(@NonNull Collection<Annotation> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<Annotation> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getAnnotation(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public static FailureInfo getFailure(@NonNull Failure failure) throws TestEventException {
        return new FailureInfo(failure.getMessage(), failure.getTestHeader(), StackTrimmer.getTrimmedStackTrace(failure), getTestCaseFromDescription(failure.getDescription()));
    }

    @NonNull
    public static List<FailureInfo> getFailuresFromList(@NonNull List<Failure> list) throws TestEventException {
        ArrayList arrayList = new ArrayList();
        Iterator<Failure> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getFailure(it.next()));
        }
        return arrayList;
    }

    @NonNull
    public static AnnotationInfo getAnnotation(@NonNull Annotation annotation) throws SecurityException {
        ArrayList arrayList = new ArrayList();
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            arrayList.add(getAnnotationValue(annotation, method));
        }
        return new AnnotationInfo(annotation.annotationType().getName(), arrayList);
    }

    private static AnnotationValue getAnnotationValue(Annotation annotation, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List arrayList;
        String name = method.getName();
        String fieldValuesType = ActionConst.NULL;
        try {
            Object objInvoke = method.invoke(annotation, null);
            fieldValuesType = getFieldValuesType(objInvoke);
            arrayList = getArrayElements(objInvoke);
        } catch (Exception e) {
            String strValueOf = String.valueOf(annotation);
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 48 + strValueOf.length());
            sb.append("Unable to get annotation values for field '");
            sb.append(name);
            sb.append("': [");
            sb.append(strValueOf);
            sb.append("]");
            Log.e("ParcelableConverter", sb.toString(), e);
            arrayList = new ArrayList();
        }
        return new AnnotationValue(name, arrayList, fieldValuesType);
    }

    private static String getFieldValuesType(Object obj) {
        return obj.getClass().getSimpleName().replace("[", "").replace("]", "");
    }

    static List getArrayElements(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj == null) {
            arrayList.add("<null>");
        } else if (obj.getClass().isArray()) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                arrayList.add(Array.get(obj, i).toString());
            }
        } else if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
        } else {
            arrayList.add(obj.toString());
        }
        return arrayList;
    }
}
