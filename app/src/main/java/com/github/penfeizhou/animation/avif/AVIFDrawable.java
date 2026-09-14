package com.github.penfeizhou.animation.avif;

import android.content.Context;
import com.github.penfeizhou.animation.FrameAnimationDrawable;
import com.github.penfeizhou.animation.avif.decode.AVIFDecoder;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.loader.AssetStreamLoader;
import com.github.penfeizhou.animation.loader.FileLoader;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.loader.ResourceStreamLoader;

/* JADX INFO: loaded from: classes3.dex */
public class AVIFDrawable extends FrameAnimationDrawable<AVIFDecoder> {
    public AVIFDrawable(Loader loader) {
        super(loader);
    }

    public AVIFDrawable(AVIFDecoder aVIFDecoder) {
        super(aVIFDecoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.FrameAnimationDrawable
    public AVIFDecoder createFrameSeqDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        return new AVIFDecoder(loader, renderListener);
    }

    public static AVIFDrawable fromAsset(Context context, String str) {
        return new AVIFDrawable(new AssetStreamLoader(context, str));
    }

    public static AVIFDrawable fromFile(String str) {
        return new AVIFDrawable(new FileLoader(str));
    }

    public static AVIFDrawable fromResource(Context context, int i) {
        return new AVIFDrawable(new ResourceStreamLoader(context, i));
    }
}
