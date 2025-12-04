package org.picocontainer.monitors;

import org.picocontainer.ComponentMonitor;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class ComposingMonitor extends AbstractComponentMonitor {
    private Composer[] composers;

    public interface Composer {
        Object compose(PicoContainer picoContainer, Object obj);
    }

    public ComposingMonitor(ComponentMonitor componentMonitor, Composer... composerArr) {
        super(componentMonitor);
        this.composers = composerArr;
    }

    public ComposingMonitor(Composer... composerArr) {
        this.composers = composerArr;
    }

    @Override // org.picocontainer.monitors.AbstractComponentMonitor, org.picocontainer.ComponentMonitor
    public Object noComponentFound(MutablePicoContainer mutablePicoContainer, Object obj) {
        for (Composer composer : this.composers) {
            Object objCompose = composer.compose(mutablePicoContainer, obj);
            if (objCompose != null) {
                return objCompose;
            }
        }
        return super.noComponentFound(mutablePicoContainer, obj);
    }
}
