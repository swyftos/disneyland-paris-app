package org.picocontainer.containers;

import java.lang.annotation.Annotation;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentFactory;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.NameBinding;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class TieringPicoContainer extends DefaultPicoContainer {
    public TieringPicoContainer(ComponentFactory componentFactory, LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer) {
        super(componentFactory, lifecycleStrategy, picoContainer);
    }

    public TieringPicoContainer(ComponentFactory componentFactory, LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer, ComponentMonitor componentMonitor) {
        super(componentFactory, lifecycleStrategy, picoContainer, componentMonitor);
    }

    public TieringPicoContainer(ComponentMonitor componentMonitor, PicoContainer picoContainer) {
        super(componentMonitor, picoContainer);
    }

    public TieringPicoContainer(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer) {
        super(componentMonitor, lifecycleStrategy, picoContainer);
    }

    public TieringPicoContainer(LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer) {
        super(lifecycleStrategy, picoContainer);
    }

    public TieringPicoContainer(ComponentFactory componentFactory) {
        super(componentFactory);
    }

    public TieringPicoContainer(ComponentMonitor componentMonitor) {
        super(componentMonitor);
    }

    public TieringPicoContainer(PicoContainer picoContainer) {
        super(picoContainer);
    }

    public TieringPicoContainer() {
    }

    @Override // org.picocontainer.DefaultPicoContainer, org.picocontainer.PicoContainer
    public PicoContainer getParent() {
        return new TieringGuard(super.getParent());
    }

    @Override // org.picocontainer.DefaultPicoContainer, org.picocontainer.MutablePicoContainer
    public MutablePicoContainer makeChildContainer() {
        return new TieringPicoContainer(this.componentFactory, this.lifecycleStrategy, this, this.componentMonitor);
    }

    private static class TieringGuard extends AbstractDelegatingPicoContainer {
        private static final AskingParentForComponent askingParentForComponent = new AskingParentForComponent();

        public TieringGuard(PicoContainer picoContainer) {
            super(picoContainer);
        }

        @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
        public ComponentAdapter getComponentAdapter(Class cls, NameBinding nameBinding) throws Throwable {
            boolean z = false;
            try {
                if (!notYetAskingParentForComponent()) {
                    return null;
                }
                nowAskingParentForComponent();
                try {
                    ComponentAdapter componentAdapter = super.getComponentAdapter(cls, nameBinding);
                    doneAskingParentForComponent();
                    return componentAdapter;
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    if (z) {
                        doneAskingParentForComponent();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private void nowAskingParentForComponent() {
            askingParentForComponent.set(Boolean.TRUE);
        }

        @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
        public ComponentAdapter getComponentAdapter(Class cls, Class cls2) throws Throwable {
            boolean z = false;
            try {
                if (!notYetAskingParentForComponent()) {
                    return null;
                }
                nowAskingParentForComponent();
                try {
                    ComponentAdapter componentAdapter = super.getComponentAdapter(cls, (Class<? extends Annotation>) cls2);
                    doneAskingParentForComponent();
                    return componentAdapter;
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    if (z) {
                        doneAskingParentForComponent();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        private void doneAskingParentForComponent() {
            askingParentForComponent.set(Boolean.FALSE);
        }

        private boolean notYetAskingParentForComponent() {
            return askingParentForComponent.get() == Boolean.FALSE;
        }

        @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
        public ComponentAdapter getComponentAdapter(Object obj) throws Throwable {
            boolean z = false;
            try {
                if (!notYetAskingParentForComponent()) {
                    return null;
                }
                nowAskingParentForComponent();
                try {
                    ComponentAdapter<?> componentAdapter = super.getComponentAdapter(obj);
                    doneAskingParentForComponent();
                    return componentAdapter;
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    if (z) {
                        doneAskingParentForComponent();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static class AskingParentForComponent extends ThreadLocal {
        private AskingParentForComponent() {
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return Boolean.FALSE;
        }
    }
}
