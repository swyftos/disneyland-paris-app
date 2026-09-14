package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.processing.Edge;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_CaptureNode_In extends CaptureNode.AbstractC0234In {
    private final Edge errorEdge;
    private final ImageReaderProxyProvider imageReaderProxyProvider;
    private final int inputFormat;
    private final List outputFormats;
    private final int postviewImageFormat;
    private final Size postviewSize;
    private final Edge requestEdge;
    private final Size size;
    private final boolean virtualCamera;

    AutoValue_CaptureNode_In(Size size, int i, List list, boolean z, ImageReaderProxyProvider imageReaderProxyProvider, Size size2, int i2, Edge edge, Edge edge2) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        this.inputFormat = i;
        if (list == null) {
            throw new NullPointerException("Null outputFormats");
        }
        this.outputFormats = list;
        this.virtualCamera = z;
        this.imageReaderProxyProvider = imageReaderProxyProvider;
        this.postviewSize = size2;
        this.postviewImageFormat = i2;
        if (edge == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.requestEdge = edge;
        if (edge2 == null) {
            throw new NullPointerException("Null errorEdge");
        }
        this.errorEdge = edge2;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    List getOutputFormats() {
        return this.outputFormats;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    boolean isVirtualCamera() {
        return this.virtualCamera;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.imageReaderProxyProvider;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    Size getPostviewSize() {
        return this.postviewSize;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    int getPostviewImageFormat() {
        return this.postviewImageFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    Edge getRequestEdge() {
        return this.requestEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.AbstractC0234In
    Edge getErrorEdge() {
        return this.errorEdge;
    }

    public String toString() {
        return "In{size=" + this.size + ", inputFormat=" + this.inputFormat + ", outputFormats=" + this.outputFormats + ", virtualCamera=" + this.virtualCamera + ", imageReaderProxyProvider=" + this.imageReaderProxyProvider + ", postviewSize=" + this.postviewSize + ", postviewImageFormat=" + this.postviewImageFormat + ", requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + "}";
    }

    public boolean equals(Object obj) {
        ImageReaderProxyProvider imageReaderProxyProvider;
        Size size;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.AbstractC0234In)) {
            return false;
        }
        CaptureNode.AbstractC0234In abstractC0234In = (CaptureNode.AbstractC0234In) obj;
        return this.size.equals(abstractC0234In.getSize()) && this.inputFormat == abstractC0234In.getInputFormat() && this.outputFormats.equals(abstractC0234In.getOutputFormats()) && this.virtualCamera == abstractC0234In.isVirtualCamera() && ((imageReaderProxyProvider = this.imageReaderProxyProvider) != null ? imageReaderProxyProvider.equals(abstractC0234In.getImageReaderProxyProvider()) : abstractC0234In.getImageReaderProxyProvider() == null) && ((size = this.postviewSize) != null ? size.equals(abstractC0234In.getPostviewSize()) : abstractC0234In.getPostviewSize() == null) && this.postviewImageFormat == abstractC0234In.getPostviewImageFormat() && this.requestEdge.equals(abstractC0234In.getRequestEdge()) && this.errorEdge.equals(abstractC0234In.getErrorEdge());
    }

    public int hashCode() {
        int iHashCode = (((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormats.hashCode()) * 1000003) ^ (this.virtualCamera ? 1231 : 1237)) * 1000003;
        ImageReaderProxyProvider imageReaderProxyProvider = this.imageReaderProxyProvider;
        int iHashCode2 = (iHashCode ^ (imageReaderProxyProvider == null ? 0 : imageReaderProxyProvider.hashCode())) * 1000003;
        Size size = this.postviewSize;
        return this.errorEdge.hashCode() ^ ((((((iHashCode2 ^ (size != null ? size.hashCode() : 0)) * 1000003) ^ this.postviewImageFormat) * 1000003) ^ this.requestEdge.hashCode()) * 1000003);
    }
}
