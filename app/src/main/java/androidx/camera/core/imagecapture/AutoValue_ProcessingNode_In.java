package androidx.camera.core.imagecapture;

import androidx.camera.core.processing.Edge;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_ProcessingNode_In extends ProcessingNode.AbstractC0238In {
    private final Edge edge;
    private final int inputFormat;
    private final List outputFormats;
    private final Edge postviewEdge;

    AutoValue_ProcessingNode_In(Edge edge, Edge edge2, int i, List list) {
        if (edge == null) {
            throw new NullPointerException("Null edge");
        }
        this.edge = edge;
        if (edge2 == null) {
            throw new NullPointerException("Null postviewEdge");
        }
        this.postviewEdge = edge2;
        this.inputFormat = i;
        if (list == null) {
            throw new NullPointerException("Null outputFormats");
        }
        this.outputFormats = list;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.AbstractC0238In
    Edge getEdge() {
        return this.edge;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.AbstractC0238In
    Edge getPostviewEdge() {
        return this.postviewEdge;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.AbstractC0238In
    int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.AbstractC0238In
    List getOutputFormats() {
        return this.outputFormats;
    }

    public String toString() {
        return "In{edge=" + this.edge + ", postviewEdge=" + this.postviewEdge + ", inputFormat=" + this.inputFormat + ", outputFormats=" + this.outputFormats + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProcessingNode.AbstractC0238In)) {
            return false;
        }
        ProcessingNode.AbstractC0238In abstractC0238In = (ProcessingNode.AbstractC0238In) obj;
        return this.edge.equals(abstractC0238In.getEdge()) && this.postviewEdge.equals(abstractC0238In.getPostviewEdge()) && this.inputFormat == abstractC0238In.getInputFormat() && this.outputFormats.equals(abstractC0238In.getOutputFormats());
    }

    public int hashCode() {
        return this.outputFormats.hashCode() ^ ((((((this.edge.hashCode() ^ 1000003) * 1000003) ^ this.postviewEdge.hashCode()) * 1000003) ^ this.inputFormat) * 1000003);
    }
}
