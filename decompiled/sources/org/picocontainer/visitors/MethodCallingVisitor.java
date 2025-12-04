package org.picocontainer.visitors;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class MethodCallingVisitor extends TraversalCheckingVisitor implements Serializable {
    private final Object[] arguments;
    private final List componentInstances;
    private transient Method method;
    private final Class type;
    private final boolean visitInInstantiationOrder;

    public MethodCallingVisitor(Method method, Class<?> cls, Object[] objArr, boolean z) {
        method.getClass();
        this.method = method;
        this.arguments = objArr;
        this.type = cls;
        this.visitInInstantiationOrder = z;
        this.componentInstances = new ArrayList();
    }

    public MethodCallingVisitor(Method method, Class cls, Object[] objArr) {
        this(method, cls, objArr, true);
    }

    @Override // org.picocontainer.visitors.AbstractPicoVisitor, org.picocontainer.PicoVisitor
    public Object traverse(Object obj) {
        this.componentInstances.clear();
        try {
            super.traverse(obj);
            if (!this.visitInInstantiationOrder) {
                Collections.reverse(this.componentInstances);
            }
            Iterator it = this.componentInstances.iterator();
            while (it.hasNext()) {
                invoke(it.next());
            }
            this.componentInstances.clear();
            return Void.TYPE;
        } catch (Throwable th) {
            this.componentInstances.clear();
            throw th;
        }
    }

    @Override // org.picocontainer.visitors.TraversalCheckingVisitor, org.picocontainer.PicoVisitor
    public boolean visitContainer(PicoContainer picoContainer) {
        super.visitContainer(picoContainer);
        this.componentInstances.addAll(picoContainer.getComponents(this.type));
        return true;
    }

    protected Method getMethod() {
        return this.method;
    }

    protected Object[] getArguments() {
        return this.arguments;
    }

    protected void invoke(Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (Object obj : objArr) {
            invoke(obj);
        }
    }

    protected Class<Void> invoke(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = getMethod();
        try {
            method.invoke(obj, getArguments());
            return Void.TYPE;
        } catch (IllegalAccessException e) {
            throw new PicoCompositionException("Can't call " + method.getName() + " on " + obj, e);
        } catch (IllegalArgumentException e2) {
            throw new PicoCompositionException("Can't call " + method.getName() + " on " + obj, e2);
        } catch (InvocationTargetException e3) {
            throw new PicoCompositionException("Failed when calling " + method.getName() + " on " + obj, e3.getTargetException());
        }
    }
}
