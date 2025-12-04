package org.picocontainer;

/* loaded from: classes6.dex */
public interface PicoVisitor {
    public static final boolean ABORT_TRAVERSAL = false;
    public static final boolean CONTINUE_TRAVERSAL = true;

    Object traverse(Object obj);

    void visitComponentAdapter(ComponentAdapter<?> componentAdapter);

    void visitComponentFactory(ComponentFactory componentFactory);

    boolean visitContainer(PicoContainer picoContainer);

    void visitParameter(Parameter parameter);
}
