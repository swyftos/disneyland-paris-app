package org.picocontainer.visitors;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentFactory;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class TraversalCheckingVisitor extends AbstractPicoVisitor {
    @Override // org.picocontainer.PicoVisitor
    public boolean visitContainer(PicoContainer picoContainer) {
        checkTraversal();
        return true;
    }

    @Override // org.picocontainer.PicoVisitor
    public void visitComponentAdapter(ComponentAdapter<?> componentAdapter) {
        checkTraversal();
    }

    @Override // org.picocontainer.PicoVisitor
    public void visitComponentFactory(ComponentFactory componentFactory) {
        checkTraversal();
    }

    @Override // org.picocontainer.PicoVisitor
    public void visitParameter(Parameter parameter) {
        checkTraversal();
    }
}
