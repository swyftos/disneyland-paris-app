package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* loaded from: classes2.dex */
public class WebpDrawableResource extends DrawableResource<WebpDrawable> implements Initializable {
    public WebpDrawableResource(WebpDrawable webpDrawable) {
        super(webpDrawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<WebpDrawable> getResourceClass() {
        return WebpDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((WebpDrawable) this.drawable).getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((WebpDrawable) this.drawable).stop();
        ((WebpDrawable) this.drawable).recycle();
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((WebpDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }
}
