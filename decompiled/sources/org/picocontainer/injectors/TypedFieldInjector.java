package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.annotations.Bind;

/* loaded from: classes6.dex */
public class TypedFieldInjector<T> extends AbstractFieldInjector<T> {
    private final List classes;

    @Override // org.picocontainer.injectors.IterativeInjector
    protected Object memberInvocationReturn(Object obj, AccessibleObject accessibleObject, Object obj2) {
        return obj2;
    }

    public TypedFieldInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str) {
        super(obj, cls, parameterArr, componentMonitor, true);
        this.classes = Arrays.asList(str.trim().split(" "));
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected void initializeInjectionMembersAndTypeLists() {
        this.injectionMembers = new ArrayList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Field field : getFields()) {
            if (isTypedForInjection(field)) {
                this.injectionMembers.add(field);
                arrayList2.add(box(field.getType()));
                arrayList.add(getBinding(field));
            }
        }
        this.injectionTypes = (Type[]) arrayList2.toArray(new Type[0]);
        this.bindings = (Annotation[]) arrayList.toArray(new Annotation[0]);
    }

    private Annotation getBinding(Field field) {
        for (Annotation annotation : field.getAnnotations()) {
            if (annotation.annotationType().isAnnotationPresent(Bind.class)) {
                return annotation;
            }
        }
        return null;
    }

    protected boolean isTypedForInjection(Field field) {
        return this.classes.contains(field.getType().getName());
    }

    private Field[] getFields() {
        return (Field[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.injectors.TypedFieldInjector.1
            @Override // java.security.PrivilegedAction
            public Field[] run() {
                return TypedFieldInjector.this.getComponentImplementation().getDeclaredFields();
            }
        });
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected Object injectIntoMember(AccessibleObject accessibleObject, Object obj, Object obj2) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Field field = (Field) accessibleObject;
        field.setAccessible(true);
        field.set(obj, obj2);
        return null;
    }

    @Override // org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "TypedFieldInjector-";
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected NameBinding makeParameterNameImpl(final AccessibleObject accessibleObject) {
        return new NameBinding() { // from class: org.picocontainer.injectors.TypedFieldInjector.2
            @Override // org.picocontainer.NameBinding
            public String getName() {
                return ((Field) accessibleObject).getName();
            }
        };
    }
}
