package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_DngImage2Disk_In extends DngImage2Disk.AbstractC0235In {
    private final ImageProxy imageProxy;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;

    AutoValue_DngImage2Disk_In(ImageProxy imageProxy, int i, ImageCapture.OutputFileOptions outputFileOptions) {
        if (imageProxy == null) {
            throw new NullPointerException("Null imageProxy");
        }
        this.imageProxy = imageProxy;
        this.rotationDegrees = i;
        if (outputFileOptions == null) {
            throw new NullPointerException("Null outputFileOptions");
        }
        this.outputFileOptions = outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.DngImage2Disk.AbstractC0235In
    ImageProxy getImageProxy() {
        return this.imageProxy;
    }

    @Override // androidx.camera.core.imagecapture.DngImage2Disk.AbstractC0235In
    int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.imagecapture.DngImage2Disk.AbstractC0235In
    ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    public String toString() {
        return "In{imageProxy=" + this.imageProxy + ", rotationDegrees=" + this.rotationDegrees + ", outputFileOptions=" + this.outputFileOptions + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DngImage2Disk.AbstractC0235In)) {
            return false;
        }
        DngImage2Disk.AbstractC0235In abstractC0235In = (DngImage2Disk.AbstractC0235In) obj;
        return this.imageProxy.equals(abstractC0235In.getImageProxy()) && this.rotationDegrees == abstractC0235In.getRotationDegrees() && this.outputFileOptions.equals(abstractC0235In.getOutputFileOptions());
    }

    public int hashCode() {
        return this.outputFileOptions.hashCode() ^ ((((this.imageProxy.hashCode() ^ 1000003) * 1000003) ^ this.rotationDegrees) * 1000003);
    }
}
