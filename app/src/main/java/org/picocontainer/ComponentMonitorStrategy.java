package org.picocontainer;

/* JADX INFO: loaded from: classes5.dex */
public interface ComponentMonitorStrategy {
    void changeMonitor(ComponentMonitor componentMonitor);

    ComponentMonitor currentMonitor();
}
