package com.github.penfeizhou.animation.glide;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.github.penfeizhou.animation.apng.APNGDrawable;
import com.github.penfeizhou.animation.apng.decode.APNGDecoder;
import com.github.penfeizhou.animation.avif.AVIFDrawable;
import com.github.penfeizhou.animation.avif.decode.AVIFDecoder;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.GifDrawable;
import com.github.penfeizhou.animation.gif.decode.GifDecoder;
import com.github.penfeizhou.animation.webp.WebPDrawable;
import com.github.penfeizhou.animation.webp.decode.WebPDecoder;

/* JADX INFO: loaded from: classes3.dex */
class FrameDrawableTranscoder implements ResourceTranscoder {
    FrameDrawableTranscoder() {
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource resource, Options options) {
        FrameSeqDecoder frameSeqDecoder = (FrameSeqDecoder) resource.get();
        boolean zBooleanValue = ((Boolean) options.get(AnimationDecoderOption.NO_ANIMATION_BOUNDS_MEASURE)).booleanValue();
        if (frameSeqDecoder instanceof APNGDecoder) {
            final APNGDrawable aPNGDrawable = new APNGDrawable((APNGDecoder) frameSeqDecoder);
            aPNGDrawable.setAutoPlay(false);
            aPNGDrawable.setNoMeasure(zBooleanValue);
            return new DrawableResource(aPNGDrawable) { // from class: com.github.penfeizhou.animation.glide.FrameDrawableTranscoder.1
                @Override // com.bumptech.glide.load.engine.Resource
                public Class getResourceClass() {
                    return Drawable.class;
                }

                @Override // com.bumptech.glide.load.engine.Resource
                public int getSize() {
                    return aPNGDrawable.getMemorySize();
                }

                @Override // com.bumptech.glide.load.engine.Resource
                public void recycle() {
                    aPNGDrawable.stop();
                }

                @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
                public void initialize() {
                    super.initialize();
                }
            };
        }
        if (frameSeqDecoder instanceof WebPDecoder) {
            final WebPDrawable webPDrawable = new WebPDrawable((WebPDecoder) frameSeqDecoder);
            webPDrawable.setAutoPlay(false);
            webPDrawable.setNoMeasure(zBooleanValue);
            return new DrawableResource(webPDrawable) { // from class: com.github.penfeizhou.animation.glide.FrameDrawableTranscoder.2
                @Override // com.bumptech.glide.load.engine.Resource
                public Class getResourceClass() {
                    return Drawable.class;
                }

                @Override // com.bumptech.glide.load.engine.Resource
                public int getSize() {
                    return webPDrawable.getMemorySize();
                }

                @Override // com.bumptech.glide.load.engine.Resource
                public void recycle() {
                    webPDrawable.stop();
                }

                @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
                public void initialize() {
                    super.initialize();
                }
            };
        }
        if (frameSeqDecoder instanceof GifDecoder) {
            final GifDrawable gifDrawable = new GifDrawable((GifDecoder) frameSeqDecoder);
            gifDrawable.setAutoPlay(false);
            gifDrawable.setNoMeasure(zBooleanValue);
            return new DrawableResource(gifDrawable) { // from class: com.github.penfeizhou.animation.glide.FrameDrawableTranscoder.3
                @Override // com.bumptech.glide.load.engine.Resource
                public Class getResourceClass() {
                    return Drawable.class;
                }

                @Override // com.bumptech.glide.load.engine.Resource
                public int getSize() {
                    return gifDrawable.getMemorySize();
                }

                @Override // com.bumptech.glide.load.engine.Resource
                public void recycle() {
                    gifDrawable.stop();
                }

                @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
                public void initialize() {
                    super.initialize();
                }
            };
        }
        if (!(frameSeqDecoder instanceof AVIFDecoder)) {
            return null;
        }
        final AVIFDrawable aVIFDrawable = new AVIFDrawable((AVIFDecoder) frameSeqDecoder);
        aVIFDrawable.setAutoPlay(false);
        aVIFDrawable.setNoMeasure(zBooleanValue);
        return new DrawableResource(aVIFDrawable) { // from class: com.github.penfeizhou.animation.glide.FrameDrawableTranscoder.4
            @Override // com.bumptech.glide.load.engine.Resource
            public Class getResourceClass() {
                return Drawable.class;
            }

            @Override // com.bumptech.glide.load.engine.Resource
            public int getSize() {
                return aVIFDrawable.getMemorySize();
            }

            @Override // com.bumptech.glide.load.engine.Resource
            public void recycle() {
                aVIFDrawable.stop();
            }

            @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
            public void initialize() {
                super.initialize();
            }
        };
    }
}
