package androidx.camera.core.processing;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_SurfaceProcessorNode_In extends SurfaceProcessorNode.AbstractC0278In {
    private final List outConfigs;
    private final SurfaceEdge surfaceEdge;

    AutoValue_SurfaceProcessorNode_In(SurfaceEdge surfaceEdge, List list) {
        if (surfaceEdge == null) {
            throw new NullPointerException("Null surfaceEdge");
        }
        this.surfaceEdge = surfaceEdge;
        if (list == null) {
            throw new NullPointerException("Null outConfigs");
        }
        this.outConfigs = list;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.AbstractC0278In
    public SurfaceEdge getSurfaceEdge() {
        return this.surfaceEdge;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.AbstractC0278In
    public List getOutConfigs() {
        return this.outConfigs;
    }

    public String toString() {
        return "In{surfaceEdge=" + this.surfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceProcessorNode.AbstractC0278In)) {
            return false;
        }
        SurfaceProcessorNode.AbstractC0278In abstractC0278In = (SurfaceProcessorNode.AbstractC0278In) obj;
        return this.surfaceEdge.equals(abstractC0278In.getSurfaceEdge()) && this.outConfigs.equals(abstractC0278In.getOutConfigs());
    }

    public int hashCode() {
        return this.outConfigs.hashCode() ^ ((this.surfaceEdge.hashCode() ^ 1000003) * 1000003);
    }
}
