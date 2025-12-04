package androidx.test.espresso;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import androidx.test.internal.runner.tracker.UsageTrackerRegistry;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class GraphHolder {
    private static final AtomicReference instance = new AtomicReference(null);
    private final BaseLayerComponent component;

    private GraphHolder(BaseLayerComponent baseLayerComponent) {
        this.component = (BaseLayerComponent) Preconditions.checkNotNull(baseLayerComponent);
    }

    static BaseLayerComponent baseLayer() {
        AtomicReference atomicReference = instance;
        GraphHolder graphHolder = (GraphHolder) atomicReference.get();
        if (graphHolder != null) {
            return graphHolder.component;
        }
        GraphHolder graphHolder2 = new GraphHolder(DaggerBaseLayerComponent.create());
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, graphHolder2)) {
            return ((GraphHolder) atomicReference.get()).component;
        }
        UsageTrackerRegistry.getInstance().trackUsage("Espresso", UsageTrackerRegistry.AxtVersions.ESPRESSO_VERSION);
        HashMap map = new HashMap();
        map.put("Espresso", UsageTrackerRegistry.AxtVersions.ESPRESSO_VERSION);
        TestOutputEmitter.addOutputProperties(map);
        return graphHolder2.component;
    }
}
