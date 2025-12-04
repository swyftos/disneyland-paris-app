package com.bumptech.glide.integration.avif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.aomedia.avif.android.AvifDecoder;

/* loaded from: classes2.dex */
public final class AvifByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final BitmapPool bitmapPool;

    public AvifByteBufferBitmapDecoder(BitmapPool bitmapPool) {
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
    }

    private ByteBuffer maybeCopyBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            return byteBuffer;
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
        byteBufferAllocateDirect.put(byteBuffer);
        byteBufferAllocateDirect.flip();
        return byteBufferAllocateDirect;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public Resource<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        ByteBuffer byteBufferMaybeCopyBuffer = maybeCopyBuffer(byteBuffer);
        AvifDecoder.Info info = new AvifDecoder.Info();
        if (!AvifDecoder.getInfo(byteBufferMaybeCopyBuffer, byteBufferMaybeCopyBuffer.remaining(), info)) {
            if (Log.isLoggable("AvifBitmapDecoder", 6)) {
                Log.e("AvifBitmapDecoder", "Requested to decode byte buffer which cannot be handled by AvifDecoder");
            }
            return null;
        }
        Bitmap bitmap = this.bitmapPool.get(info.width, info.height, info.depth == 8 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16);
        if (!AvifDecoder.decode(byteBufferMaybeCopyBuffer, byteBufferMaybeCopyBuffer.remaining(), bitmap)) {
            if (Log.isLoggable("AvifBitmapDecoder", 6)) {
                Log.e("AvifBitmapDecoder", "Failed to decode ByteBuffer as Avif.");
            }
            this.bitmapPool.put(bitmap);
            return null;
        }
        return BitmapResource.obtain(bitmap, this.bitmapPool);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return AvifDecoder.isAvifImage(maybeCopyBuffer(byteBuffer));
    }
}
