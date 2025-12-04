package com.dylanvann.fastimage;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.dylanvann.fastimage.events.FastImageErrorEvent;
import com.dylanvann.fastimage.events.FastImageLoadEndEvent;
import com.dylanvann.fastimage.events.FastImageLoadEvent;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;

/* loaded from: classes3.dex */
public class FastImageRequestListener<T extends Drawable> implements RequestListener<T> {
    static final String REACT_ON_ERROR_EVENT = "onFastImageError";
    static final String REACT_ON_LOAD_END_EVENT = "onFastImageLoadEnd";
    static final String REACT_ON_LOAD_EVENT = "onFastImageLoad";
    private final String key;

    @Override // com.bumptech.glide.request.RequestListener
    public /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z) {
        return onResourceReady((FastImageRequestListener<T>) obj, obj2, (Target<FastImageRequestListener<T>>) target, dataSource, z);
    }

    FastImageRequestListener(String str) {
        this.key = str;
    }

    private static WritableMap mapFromResource(Drawable drawable) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("width", drawable.getIntrinsicWidth());
        writableNativeMap.putInt("height", drawable.getIntrinsicHeight());
        return writableNativeMap;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<T> target, boolean z) {
        FastImageOkHttpProgressGlideModule.forget(this.key);
        if (!(target instanceof ImageViewTarget)) {
            return false;
        }
        FastImageViewWithUrl fastImageViewWithUrl = (FastImageViewWithUrl) ((ImageViewTarget) target).getView();
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) fastImageViewWithUrl.getContext(), fastImageViewWithUrl.getId());
        int surfaceId = UIManagerHelper.getSurfaceId(fastImageViewWithUrl);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new FastImageErrorEvent(surfaceId, fastImageViewWithUrl.getId(), null));
            eventDispatcherForReactTag.dispatchEvent(new FastImageLoadEndEvent(surfaceId, fastImageViewWithUrl.getId()));
        }
        return false;
    }

    public boolean onResourceReady(T t, Object obj, Target<T> target, DataSource dataSource, boolean z) {
        if (!(target instanceof ImageViewTarget)) {
            return false;
        }
        FastImageViewWithUrl fastImageViewWithUrl = (FastImageViewWithUrl) ((ImageViewTarget) target).getView();
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) fastImageViewWithUrl.getContext(), fastImageViewWithUrl.getId());
        int surfaceId = UIManagerHelper.getSurfaceId(fastImageViewWithUrl);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new FastImageLoadEvent(surfaceId, fastImageViewWithUrl.getId(), t.getIntrinsicWidth(), t.getIntrinsicHeight()));
            eventDispatcherForReactTag.dispatchEvent(new FastImageLoadEndEvent(surfaceId, fastImageViewWithUrl.getId()));
        }
        return false;
    }
}
