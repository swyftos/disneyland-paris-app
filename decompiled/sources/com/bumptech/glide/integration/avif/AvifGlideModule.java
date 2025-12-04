package com.bumptech.glide.integration.avif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.LibraryGlideModule;
import java.io.InputStream;
import java.nio.ByteBuffer;

@GlideModule
/* loaded from: classes2.dex */
public final class AvifGlideModule extends LibraryGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        AvifByteBufferBitmapDecoder avifByteBufferBitmapDecoder = new AvifByteBufferBitmapDecoder(glide.getBitmapPool());
        registry.prepend(ByteBuffer.class, Bitmap.class, avifByteBufferBitmapDecoder);
        registry.prepend(InputStream.class, Bitmap.class, new AvifStreamBitmapDecoder(registry.getImageHeaderParsers(), avifByteBufferBitmapDecoder, glide.getArrayPool()));
    }
}
