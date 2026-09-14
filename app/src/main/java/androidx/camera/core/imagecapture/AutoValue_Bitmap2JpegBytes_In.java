package androidx.camera.core.imagecapture;

import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Bitmap2JpegBytes_In extends Bitmap2JpegBytes.AbstractC0231In {
    private final int jpegQuality;
    private final Packet packet;

    AutoValue_Bitmap2JpegBytes_In(Packet packet, int i) {
        if (packet == null) {
            throw new NullPointerException("Null packet");
        }
        this.packet = packet;
        this.jpegQuality = i;
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.AbstractC0231In
    Packet getPacket() {
        return this.packet;
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.AbstractC0231In
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
        if (!(obj instanceof Bitmap2JpegBytes.AbstractC0231In)) {
            return false;
        }
        Bitmap2JpegBytes.AbstractC0231In abstractC0231In = (Bitmap2JpegBytes.AbstractC0231In) obj;
        return this.packet.equals(abstractC0231In.getPacket()) && this.jpegQuality == abstractC0231In.getJpegQuality();
    }

    public int hashCode() {
        return this.jpegQuality ^ ((this.packet.hashCode() ^ 1000003) * 1000003);
    }
}
