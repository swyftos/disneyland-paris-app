package org.picocontainer.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.annotations.Bind;
import org.picocontainer.injectors.AbstractInjector;
import org.picocontainer.paranamer.AdaptiveParanamer;
import org.picocontainer.paranamer.AnnotationParanamer;
import org.picocontainer.paranamer.CachingParanamer;
import org.picocontainer.paranamer.Paranamer;

/* loaded from: classes6.dex */
public abstract class SingleMemberInjector<T> extends AbstractInjector<T> {
    private transient Paranamer paranamer;

    public SingleMemberInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z) {
        super(obj, cls, parameterArr, componentMonitor, z);
    }

    protected Paranamer getParanamer() {
        if (this.paranamer == null) {
            this.paranamer = new CachingParanamer(new AnnotationParanamer(new AdaptiveParanamer()));
        }
        return this.paranamer;
    }

    protected Object[] getMemberArguments(PicoContainer picoContainer, AccessibleObject accessibleObject, Type[] typeArr, Annotation[] annotationArr) {
        boxParameters(typeArr);
        Object[] objArr = new Object[typeArr.length];
        Parameter[] parameterArrCreateDefaultParameters = this.parameters;
        if (parameterArrCreateDefaultParameters == null) {
            parameterArrCreateDefaultParameters = createDefaultParameters(typeArr.length);
        }
        for (int i = 0; i < parameterArrCreateDefaultParameters.length; i++) {
            objArr[i] = getParameter(picoContainer, accessibleObject, i, typeArr[i], annotationArr[i], parameterArrCreateDefaultParameters[i], null);
        }
        return objArr;
    }

    protected void boxParameters(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = box(typeArr[i]);
        }
    }

    protected Object getParameter(PicoContainer picoContainer, AccessibleObject accessibleObject, int i, Type type, Annotation annotation, Parameter parameter, ComponentAdapter<?> componentAdapter) {
        ParameterNameBinding parameterNameBinding = new ParameterNameBinding(getParanamer(), accessibleObject, i);
        try {
            Object objResolveInstance = parameter.resolve(picoContainer, this, componentAdapter, type, parameterNameBinding, useNames(), annotation).resolveInstance();
            nullCheck(accessibleObject, i, parameterNameBinding, objResolveInstance);
            return objResolveInstance;
        } catch (AbstractInjector.AmbiguousComponentResolutionException e) {
            e.setMember(accessibleObject);
            throw e;
        }
    }

    protected void nullCheck(AccessibleObject accessibleObject, int i, ParameterNameBinding parameterNameBinding, Object obj) {
        if (obj == null && !isNullParamAllowed(accessibleObject, i)) {
            throw new ParameterCannotBeNullException(i, accessibleObject, parameterNameBinding.getName());
        }
    }

    protected boolean isNullParamAllowed(AccessibleObject accessibleObject, int i) {
        return !PrimitiveMemberChecker.isPrimitiveArgument(accessibleObject, i);
    }

    protected Annotation[] getBindings(Annotation[][] annotationArr) {
        Annotation[] annotationArr2 = new Annotation[annotationArr.length];
        for (int i = 0; i < annotationArr.length; i++) {
            Annotation[] annotationArr3 = annotationArr[i];
            int length = annotationArr3.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    Annotation annotation = annotationArr3[i2];
                    if (annotation.annotationType().getAnnotation(Bind.class) != null) {
                        annotationArr2[i] = annotation;
                        break;
                    }
                    i2++;
                }
            }
        }
        return annotationArr2;
    }

    public static class ParameterCannotBeNullException extends PicoCompositionException {
        private final String name;

        private ParameterCannotBeNullException(int i, AccessibleObject accessibleObject, String str) {
            super("Parameter " + i + " of '" + accessibleObject + "' named '" + str + "' cannot be null");
            this.name = str;
        }

        public String getParameterName() {
            return this.name;
        }
    }
}
