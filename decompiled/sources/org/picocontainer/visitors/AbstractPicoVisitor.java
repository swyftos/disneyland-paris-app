package org.picocontainer.visitors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.picocontainer.PicoException;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public abstract class AbstractPicoVisitor implements PicoVisitor {
    private boolean traversal;

    @Override // org.picocontainer.PicoVisitor
    public Object traverse(final Object obj) {
        this.traversal = true;
        Object objDoPrivileged = AccessController.doPrivileged((PrivilegedAction<Object>) new PrivilegedAction() { // from class: org.picocontainer.visitors.AbstractPicoVisitor.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return obj.getClass().getMethod("accept", PicoVisitor.class);
                } catch (NoSuchMethodException e) {
                    return e;
                }
            }
        });
        try {
            try {
                try {
                    if (objDoPrivileged instanceof NoSuchMethodException) {
                        throw ((NoSuchMethodException) objDoPrivileged);
                    }
                    ((Method) objDoPrivileged).invoke(obj, this);
                    return Void.TYPE;
                } catch (IllegalAccessException | NoSuchMethodException unused) {
                    throw new IllegalArgumentException(obj.getClass().getName() + " is not a valid type for traversal");
                }
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
                if (targetException instanceof Error) {
                    throw ((Error) targetException);
                }
                throw new IllegalArgumentException(obj.getClass().getName() + " is not a valid type for traversal");
            }
        } finally {
            this.traversal = false;
        }
    }

    protected void checkTraversal() {
        if (!this.traversal) {
            throw new PicoVisitorTraversalException(this);
        }
    }

    public static class PicoVisitorTraversalException extends PicoException {
        public PicoVisitorTraversalException(PicoVisitor picoVisitor) {
            super("Traversal for PicoVisitor of type " + picoVisitor.getClass().getName() + " must start with the visitor's traverse method");
        }
    }
}
