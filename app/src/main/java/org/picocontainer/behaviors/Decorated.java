package org.picocontainer.behaviors;

import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* JADX INFO: loaded from: classes5.dex */
public class Decorated<T> extends AbstractBehavior<T> {
    private final Decorator decorator;

    interface Decorator {
        void decorate(Object obj);
    }

    public Decorated(ComponentAdapter<T> componentAdapter, Decorator decorator) {
        super(componentAdapter);
        this.decorator = decorator;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        T t = (T) super.getComponentInstance(picoContainer, type);
        this.decorator.decorate(t);
        return t;
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "FieldDecorated";
    }
}
