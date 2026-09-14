package com.github.penfeizhou.animation.gif;

import android.content.Context;
import com.github.penfeizhou.animation.FrameAnimationDrawable;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.decode.GifDecoder;
import com.github.penfeizhou.animation.loader.AssetStreamLoader;
import com.github.penfeizhou.animation.loader.FileLoader;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.loader.ResourceStreamLoader;

/* JADX INFO: loaded from: classes3.dex */
public class GifDrawable extends FrameAnimationDrawable<GifDecoder> {
    public GifDrawable(Loader loader) {
        super(loader);
    }

    public GifDrawable(GifDecoder gifDecoder) {
        super(gifDecoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.FrameAnimationDrawable
    public GifDecoder createFrameSeqDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        return new GifDecoder(loader, renderListener);
    }

    public static GifDrawable fromAsset(Context context, String str) {
        return new GifDrawable(new AssetStreamLoader(context, str));
    }

    public static GifDrawable fromFile(String str) {
        return new GifDrawable(new FileLoader(str));
    }

    public static GifDrawable fromResource(Context context, int i) {
        return new GifDrawable(new ResourceStreamLoader(context, i));
    }
}
