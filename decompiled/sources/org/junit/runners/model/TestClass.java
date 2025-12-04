package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.internal.MethodSorter;

/* loaded from: classes6.dex */
public class TestClass implements Annotatable {
    private static final FieldComparator FIELD_COMPARATOR;
    private static final MethodComparator METHOD_COMPARATOR;
    private final Class clazz;
    private final Map fieldsForAnnotations;
    private final Map methodsForAnnotations;

    static {
        FIELD_COMPARATOR = new FieldComparator();
        METHOD_COMPARATOR = new MethodComparator();
    }

    public TestClass(Class<?> cls) throws SecurityException {
        this.clazz = cls;
        if (cls != null && cls.getConstructors().length > 1) {
            throw new IllegalArgumentException("Test class can only have one constructor");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        scanAnnotatedMembers(linkedHashMap, linkedHashMap2);
        this.methodsForAnnotations = makeDeeplyUnmodifiable(linkedHashMap);
        this.fieldsForAnnotations = makeDeeplyUnmodifiable(linkedHashMap2);
    }

    protected void scanAnnotatedMembers(Map<Class<? extends Annotation>, List<FrameworkMethod>> map, Map<Class<? extends Annotation>, List<FrameworkField>> map2) throws SecurityException {
        for (Class cls : getSuperClasses(this.clazz)) {
            for (Method method : MethodSorter.getDeclaredMethods(cls)) {
                addToAnnotationLists(new FrameworkMethod(method), map);
            }
            for (Field field : getSortedDeclaredFields(cls)) {
                addToAnnotationLists(new FrameworkField(field), map2);
            }
        }
    }

    private static Field[] getSortedDeclaredFields(Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.sort(declaredFields, FIELD_COMPARATOR);
        return declaredFields;
    }

    protected static <T extends FrameworkMember<T>> void addToAnnotationLists(T t, Map<Class<? extends Annotation>, List<T>> map) {
        for (Annotation annotation : t.getAnnotations()) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            List annotatedMembers = getAnnotatedMembers(map, clsAnnotationType, true);
            FrameworkMember frameworkMemberHandlePossibleBridgeMethod = t.handlePossibleBridgeMethod(annotatedMembers);
            if (frameworkMemberHandlePossibleBridgeMethod == null) {
                return;
            }
            if (runsTopToBottom(clsAnnotationType)) {
                annotatedMembers.add(0, frameworkMemberHandlePossibleBridgeMethod);
            } else {
                annotatedMembers.add(frameworkMemberHandlePossibleBridgeMethod);
            }
        }
    }

    private static Map makeDeeplyUnmodifiable(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), Collections.unmodifiableList((List) entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public List<FrameworkMethod> getAnnotatedMethods() {
        List<FrameworkMethod> listCollectValues = collectValues(this.methodsForAnnotations);
        Collections.sort(listCollectValues, METHOD_COMPARATOR);
        return listCollectValues;
    }

    public List<FrameworkMethod> getAnnotatedMethods(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(getAnnotatedMembers(this.methodsForAnnotations, cls, false));
    }

    public List<FrameworkField> getAnnotatedFields() {
        return collectValues(this.fieldsForAnnotations);
    }

    public List<FrameworkField> getAnnotatedFields(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(getAnnotatedMembers(this.fieldsForAnnotations, cls, false));
    }

    private List collectValues(Map map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll((List) it.next());
        }
        return new ArrayList(linkedHashSet);
    }

    private static List getAnnotatedMembers(Map map, Class cls, boolean z) {
        if (!map.containsKey(cls) && z) {
            map.put(cls, new ArrayList());
        }
        List list = (List) map.get(cls);
        return list == null ? Collections.emptyList() : list;
    }

    private static boolean runsTopToBottom(Class cls) {
        return cls.equals(Before.class) || cls.equals(BeforeClass.class);
    }

    private static List getSuperClasses(Class cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public Class<?> getJavaClass() {
        return this.clazz;
    }

    public String getName() {
        Class cls = this.clazz;
        if (cls == null) {
            return "null";
        }
        return cls.getName();
    }

    public Constructor<?> getOnlyConstructor() throws SecurityException {
        Constructor<?>[] constructors = this.clazz.getConstructors();
        Assert.assertEquals(1L, constructors.length);
        return constructors[0];
    }

    @Override // org.junit.runners.model.Annotatable
    public Annotation[] getAnnotations() {
        Class cls = this.clazz;
        if (cls == null) {
            return new Annotation[0];
        }
        return cls.getAnnotations();
    }

    @Override // org.junit.runners.model.Annotatable
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Class cls2 = this.clazz;
        if (cls2 == null) {
            return null;
        }
        return (T) cls2.getAnnotation(cls);
    }

    public <T> List<T> getAnnotatedFieldValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2) throws IllegalArgumentException {
        final ArrayList arrayList = new ArrayList();
        collectAnnotatedFieldValues(obj, cls, cls2, new MemberValueConsumer() { // from class: org.junit.runners.model.TestClass.1
            @Override // org.junit.runners.model.MemberValueConsumer
            public void accept(FrameworkMember frameworkMember, Object obj2) {
                arrayList.add(obj2);
            }
        });
        return arrayList;
    }

    public <T> void collectAnnotatedFieldValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2, MemberValueConsumer<T> memberValueConsumer) throws IllegalArgumentException {
        for (FrameworkField frameworkField : getAnnotatedFields(cls)) {
            try {
                Object obj2 = frameworkField.get(obj);
                if (cls2.isInstance(obj2)) {
                    memberValueConsumer.accept(frameworkField, cls2.cast(obj2));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e);
            }
        }
    }

    public <T> List<T> getAnnotatedMethodValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        final ArrayList arrayList = new ArrayList();
        collectAnnotatedMethodValues(obj, cls, cls2, new MemberValueConsumer() { // from class: org.junit.runners.model.TestClass.2
            @Override // org.junit.runners.model.MemberValueConsumer
            public void accept(FrameworkMember frameworkMember, Object obj2) {
                arrayList.add(obj2);
            }
        });
        return arrayList;
    }

    public <T> void collectAnnotatedMethodValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2, MemberValueConsumer<T> memberValueConsumer) {
        for (FrameworkMethod frameworkMethod : getAnnotatedMethods(cls)) {
            try {
                if (cls2.isAssignableFrom(frameworkMethod.getReturnType())) {
                    memberValueConsumer.accept(frameworkMethod, cls2.cast(frameworkMethod.invokeExplosively(obj, new Object[0])));
                }
            } catch (Throwable th) {
                throw new RuntimeException("Exception in " + frameworkMethod.getName(), th);
            }
        }
    }

    public boolean isPublic() {
        return Modifier.isPublic(this.clazz.getModifiers());
    }

    public boolean isANonStaticInnerClass() {
        return this.clazz.isMemberClass() && !Modifier.isStatic(this.clazz.getModifiers());
    }

    public int hashCode() {
        Class cls = this.clazz;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.clazz == ((TestClass) obj).clazz;
    }

    private static class FieldComparator implements Comparator {
        private FieldComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    private static class MethodComparator implements Comparator {
        private MethodComparator() {
        }

        @Override // java.util.Comparator
        public int compare(FrameworkMethod frameworkMethod, FrameworkMethod frameworkMethod2) {
            return MethodSorter.NAME_ASCENDING.compare(frameworkMethod.getMethod(), frameworkMethod2.getMethod());
        }
    }
}
