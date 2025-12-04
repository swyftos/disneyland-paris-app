package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.annotations.Bind;

/* loaded from: classes6.dex */
public class AnnotatedFieldInjector<T> extends AbstractFieldInjector<T> {
    private final Class injectionAnnotation;

    @Override // org.picocontainer.injectors.IterativeInjector
    protected Object memberInvocationReturn(Object obj, AccessibleObject accessibleObject, Object obj2) {
        return obj2;
    }

    public AnnotatedFieldInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, Class<? extends Annotation> cls2, boolean z) {
        super(obj, cls, parameterArr, componentMonitor, z);
        this.injectionAnnotation = cls2;
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected void initializeInjectionMembersAndTypeLists() {
        this.injectionMembers = new ArrayList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Class<? extends T> componentImplementation = getComponentImplementation();
        while (true) {
            if (componentImplementation != Object.class) {
                for (Field field : getFields(componentImplementation)) {
                    if (isAnnotatedForInjection(field)) {
                        this.injectionMembers.add(field);
                        arrayList2.add(box(field.getType()));
                        arrayList.add(getBinding(field));
                    }
                }
                componentImplementation = componentImplementation.getSuperclass();
            } else {
                this.injectionTypes = (Type[]) arrayList2.toArray(new Type[0]);
                this.bindings = (Annotation[]) arrayList.toArray(new Annotation[0]);
                return;
            }
        }
    }

    private Annotation getBinding(Field field) {
        for (Annotation annotation : field.getAnnotations()) {
            if (annotation.annotationType().isAnnotationPresent(Bind.class)) {
                return annotation;
            }
        }
        return null;
    }

    protected boolean isAnnotatedForInjection(Field field) {
        return field.getAnnotation(this.injectionAnnotation) != null;
    }

    private Field[] getFields(final Class cls) {
        return (Field[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.picocontainer.injectors.AnnotatedFieldInjector.1
            @Override // java.security.PrivilegedAction
            public Field[] run() {
                return cls.getDeclaredFields();
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
        return "AnnotatedFieldInjector-";
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected NameBinding makeParameterNameImpl(final AccessibleObject accessibleObject) {
        return new NameBinding() { // from class: org.picocontainer.injectors.AnnotatedFieldInjector.2
            @Override // org.picocontainer.NameBinding
            public String getName() {
                return ((Field) accessibleObject).getName();
            }
        };
    }
}
