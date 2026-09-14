package com.github.penfeizhou.animation.apng;

import android.content.Context;
import com.github.penfeizhou.animation.FrameAnimationDrawable;
import com.github.penfeizhou.animation.apng.decode.APNGDecoder;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.loader.AssetStreamLoader;
import com.github.penfeizhou.animation.loader.FileLoader;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.loader.ResourceStreamLoader;

/* JADX INFO: loaded from: classes3.dex */
public class APNGDrawable extends FrameAnimationDrawable<APNGDecoder> {
    public APNGDrawable(Loader loader) {
        super(loader);
    }

    public APNGDrawable(APNGDecoder aPNGDecoder) {
        super(aPNGDecoder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.FrameAnimationDrawable
    public APNGDecoder createFrameSeqDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        return new APNGDecoder(loader, renderListener);
    }

    public static APNGDrawable fromAsset(Context context, String str) {
        return new APNGDrawable(new AssetStreamLoader(context, str));
    }

    public static APNGDrawable fromFile(String str) {
        return new APNGDrawable(new FileLoader(str));
    }

    public static APNGDrawable fromResource(Context context, int i) {
        return new APNGDrawable(new ResourceStreamLoader(context, i));
    }
}
