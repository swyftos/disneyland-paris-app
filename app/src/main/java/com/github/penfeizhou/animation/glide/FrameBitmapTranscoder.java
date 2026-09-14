package com.github.penfeizhou.animation.glide;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class FrameBitmapTranscoder implements ResourceTranscoder {
    private final BitmapPool bitmapPool;

    FrameBitmapTranscoder(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource resource, Options options) {
        try {
            return BitmapResource.obtain(((FrameSeqDecoder) resource.get()).getFrameBitmap(0), this.bitmapPool);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
