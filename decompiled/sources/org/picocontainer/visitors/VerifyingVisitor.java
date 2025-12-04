package org.picocontainer.visitors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentFactory;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVerificationException;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public class VerifyingVisitor extends TraversalCheckingVisitor {
    private PicoContainer currentPico;
    private final List nestedVerificationExceptions = new ArrayList();
    private final Set verifiedComponentAdapters = new HashSet();
    private final Set verifiedComponentFactories = new HashSet();
    private final PicoVisitor componentAdapterCollector = new ComponentAdapterCollector();

    @Override // org.picocontainer.visitors.AbstractPicoVisitor, org.picocontainer.PicoVisitor
    public Object traverse(Object obj) throws PicoVerificationException {
        this.nestedVerificationExceptions.clear();
        this.verifiedComponentAdapters.clear();
        try {
            super.traverse(obj);
            if (!this.nestedVerificationExceptions.isEmpty()) {
                throw new PicoVerificationException(new ArrayList(this.nestedVerificationExceptions));
            }
            this.nestedVerificationExceptions.clear();
            this.verifiedComponentAdapters.clear();
            return Void.TYPE;
        } catch (Throwable th) {
            this.nestedVerificationExceptions.clear();
            this.verifiedComponentAdapters.clear();
            throw th;
        }
    }

    @Override // org.picocontainer.visitors.TraversalCheckingVisitor, org.picocontainer.PicoVisitor
    public boolean visitContainer(PicoContainer picoContainer) {
        super.visitContainer(picoContainer);
        this.currentPico = picoContainer;
        return true;
    }

    @Override // org.picocontainer.visitors.TraversalCheckingVisitor, org.picocontainer.PicoVisitor
    public void visitComponentAdapter(ComponentAdapter<?> componentAdapter) {
        super.visitComponentAdapter(componentAdapter);
        if (this.verifiedComponentAdapters.contains(componentAdapter)) {
            return;
        }
        try {
            componentAdapter.verify(this.currentPico);
        } catch (RuntimeException e) {
            this.nestedVerificationExceptions.add(e);
        }
        componentAdapter.accept(this.componentAdapterCollector);
    }

    @Override // org.picocontainer.visitors.TraversalCheckingVisitor, org.picocontainer.PicoVisitor
    public void visitComponentFactory(ComponentFactory componentFactory) {
        super.visitComponentFactory(componentFactory);
        if (this.verifiedComponentFactories.contains(componentFactory)) {
            return;
        }
        try {
            componentFactory.verify(this.currentPico);
        } catch (RuntimeException e) {
            this.nestedVerificationExceptions.add(e);
        }
        componentFactory.accept(this.componentAdapterCollector);
    }

    private class ComponentAdapterCollector implements PicoVisitor {
        @Override // org.picocontainer.PicoVisitor
        public Object traverse(Object obj) {
            return null;
        }

        @Override // org.picocontainer.PicoVisitor
        public boolean visitContainer(PicoContainer picoContainer) {
            return true;
        }

        @Override // org.picocontainer.PicoVisitor
        public void visitParameter(Parameter parameter) {
        }

        private ComponentAdapterCollector() {
        }

        @Override // org.picocontainer.PicoVisitor
        public void visitComponentAdapter(ComponentAdapter componentAdapter) {
            VerifyingVisitor.this.verifiedComponentAdapters.add(componentAdapter);
        }

        @Override // org.picocontainer.PicoVisitor
        public void visitComponentFactory(ComponentFactory componentFactory) {
            VerifyingVisitor.this.verifiedComponentFactories.add(componentFactory);
        }
    }
}
