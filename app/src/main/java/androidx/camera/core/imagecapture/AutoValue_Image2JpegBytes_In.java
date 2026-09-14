package androidx.camera.core.imagecapture;

import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Image2JpegBytes_In extends Image2JpegBytes.AbstractC0236In {
    private final int jpegQuality;
    private final Packet packet;

    AutoValue_Image2JpegBytes_In(Packet packet, int i) {
        if (packet == null) {
            throw new NullPointerException("Null packet");
        }
        this.packet = packet;
        this.jpegQuality = i;
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.AbstractC0236In
    Packet getPacket() {
        return this.packet;
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.AbstractC0236In
    int getJpegQuality() {
        return this.jpegQuality;
    }

    public String toString() {
        return "In{packet=" + this.packet + ", jpegQuality=" + this.jpegQuality + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Image2JpegBytes.AbstractC0236In)) {
            return false;
        }
        Image2JpegBytes.AbstractC0236In abstractC0236In = (Image2JpegBytes.AbstractC0236In) obj;
        return this.packet.equals(abstractC0236In.getPacket()) && this.jpegQuality == abstractC0236In.getJpegQuality();
    }

    public int hashCode() {
        return this.jpegQuality ^ ((this.packet.hashCode() ^ 1000003) * 1000003);
    }
}
