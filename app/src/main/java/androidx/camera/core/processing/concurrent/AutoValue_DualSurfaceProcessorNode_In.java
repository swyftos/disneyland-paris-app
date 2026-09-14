package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.SurfaceEdge;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_DualSurfaceProcessorNode_In extends DualSurfaceProcessorNode.AbstractC0280In {
    private final List outConfigs;
    private final SurfaceEdge primarySurfaceEdge;
    private final SurfaceEdge secondarySurfaceEdge;

    AutoValue_DualSurfaceProcessorNode_In(SurfaceEdge surfaceEdge, SurfaceEdge surfaceEdge2, List list) {
        if (surfaceEdge == null) {
            throw new NullPointerException("Null primarySurfaceEdge");
        }
        this.primarySurfaceEdge = surfaceEdge;
        if (surfaceEdge2 == null) {
            throw new NullPointerException("Null secondarySurfaceEdge");
        }
        this.secondarySurfaceEdge = surfaceEdge2;
        if (list == null) {
            throw new NullPointerException("Null outConfigs");
        }
        this.outConfigs = list;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.AbstractC0280In
    public SurfaceEdge getPrimarySurfaceEdge() {
        return this.primarySurfaceEdge;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.AbstractC0280In
    public SurfaceEdge getSecondarySurfaceEdge() {
        return this.secondarySurfaceEdge;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.AbstractC0280In
    public List getOutConfigs() {
        return this.outConfigs;
    }

    public String toString() {
        return "In{primarySurfaceEdge=" + this.primarySurfaceEdge + ", secondarySurfaceEdge=" + this.secondarySurfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DualSurfaceProcessorNode.AbstractC0280In)) {
            return false;
        }
        DualSurfaceProcessorNode.AbstractC0280In abstractC0280In = (DualSurfaceProcessorNode.AbstractC0280In) obj;
        return this.primarySurfaceEdge.equals(abstractC0280In.getPrimarySurfaceEdge()) && this.secondarySurfaceEdge.equals(abstractC0280In.getSecondarySurfaceEdge()) && this.outConfigs.equals(abstractC0280In.getOutConfigs());
    }

    public int hashCode() {
        return this.outConfigs.hashCode() ^ ((((this.primarySurfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.secondarySurfaceEdge.hashCode()) * 1000003);
    }
}
