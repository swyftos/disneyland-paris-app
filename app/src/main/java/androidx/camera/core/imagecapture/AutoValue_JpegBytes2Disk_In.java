package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_JpegBytes2Disk_In extends JpegBytes2Disk.AbstractC0237In {
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final Packet packet;

    AutoValue_JpegBytes2Disk_In(Packet packet, ImageCapture.OutputFileOptions outputFileOptions) {
        if (packet == null) {
            throw new NullPointerException("Null packet");
        }
        this.packet = packet;
        if (outputFileOptions == null) {
            throw new NullPointerException("Null outputFileOptions");
        }
        this.outputFileOptions = outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.AbstractC0237In
    Packet getPacket() {
        return this.packet;
    }

    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.AbstractC0237In
    ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    public String toString() {
        return "In{packet=" + this.packet + ", outputFileOptions=" + this.outputFileOptions + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JpegBytes2Disk.AbstractC0237In)) {
            return false;
        }
        JpegBytes2Disk.AbstractC0237In abstractC0237In = (JpegBytes2Disk.AbstractC0237In) obj;
        return this.packet.equals(abstractC0237In.getPacket()) && this.outputFileOptions.equals(abstractC0237In.getOutputFileOptions());
    }

    public int hashCode() {
        return this.outputFileOptions.hashCode() ^ ((this.packet.hashCode() ^ 1000003) * 1000003);
    }
}
