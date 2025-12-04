package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.dylanvann.fastimage.events.FastImageErrorEvent;
import com.dylanvann.fastimage.events.FastImageLoadStartEvent;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class FastImageViewWithUrl extends AppCompatImageView {
    public GlideUrl glideUrl;
    private Drawable mDefaultSource;
    private boolean mNeedsReload;
    private ReadableMap mSource;

    public FastImageViewWithUrl(Context context) {
        super(context);
        this.mNeedsReload = false;
        this.mSource = null;
        this.mDefaultSource = null;
    }

    public void setSource(ReadableMap readableMap) {
        this.mNeedsReload = true;
        this.mSource = readableMap;
    }

    public void setDefaultSource(Drawable drawable) {
        this.mNeedsReload = true;
        this.mDefaultSource = drawable;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public void onAfterUpdate(FastImageViewManager fastImageViewManager, RequestManager requestManager, Map map) {
        RequestBuilder<Drawable> requestBuilderApply;
        if (this.mNeedsReload) {
            ReadableMap readableMap = this.mSource;
            if ((readableMap == null || !readableMap.hasKey(ReactNativeBlobUtilConst.DATA_ENCODE_URI) || isNullOrEmpty(this.mSource.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI))) && this.mDefaultSource == null) {
                clearView(requestManager);
                GlideUrl glideUrl = this.glideUrl;
                if (glideUrl != null) {
                    FastImageOkHttpProgressGlideModule.forget(glideUrl.toStringUrl());
                }
                setImageDrawable(null);
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) getContext(), getId());
                FastImageErrorEvent fastImageErrorEvent = new FastImageErrorEvent(UIManagerHelper.getSurfaceId(this), getId(), this.mSource);
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(fastImageErrorEvent);
                    return;
                }
                return;
            }
            FastImageSource imageSource = FastImageViewConverter.getImageSource(getContext(), this.mSource);
            if (imageSource != null && imageSource.getUri().toString().length() == 0) {
                EventDispatcher eventDispatcherForReactTag2 = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) getContext(), getId());
                FastImageErrorEvent fastImageErrorEvent2 = new FastImageErrorEvent(UIManagerHelper.getSurfaceId(this), getId(), this.mSource);
                if (eventDispatcherForReactTag2 != null) {
                    eventDispatcherForReactTag2.dispatchEvent(fastImageErrorEvent2);
                }
                clearView(requestManager);
                GlideUrl glideUrl2 = this.glideUrl;
                if (glideUrl2 != null) {
                    FastImageOkHttpProgressGlideModule.forget(glideUrl2.toStringUrl());
                }
                setImageDrawable(null);
                return;
            }
            GlideUrl glideUrl3 = imageSource == null ? null : imageSource.getGlideUrl();
            this.glideUrl = glideUrl3;
            clearView(requestManager);
            String stringUrl = glideUrl3 != null ? glideUrl3.toStringUrl() : null;
            if (glideUrl3 != null) {
                FastImageOkHttpProgressGlideModule.expect(stringUrl, fastImageViewManager);
                List list = (List) map.get(stringUrl);
                if (list != null && !list.contains(this)) {
                    list.add(this);
                } else if (list == null) {
                    map.put(stringUrl, new ArrayList(Collections.singletonList(this)));
                }
            }
            ThemedReactContext themedReactContext = (ThemedReactContext) getContext();
            if (imageSource != null) {
                EventDispatcher eventDispatcherForReactTag3 = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, getId());
                FastImageLoadStartEvent fastImageLoadStartEvent = new FastImageLoadStartEvent(UIManagerHelper.getSurfaceId(this), getId());
                if (eventDispatcherForReactTag3 != null) {
                    eventDispatcherForReactTag3.dispatchEvent(fastImageLoadStartEvent);
                }
            }
            if (requestManager != null) {
                try {
                    if ("gif".equals(FastImageUrlUtils.getFileExtensionFromUrl(imageSource.getUri().toString()))) {
                        requestBuilderApply = requestManager.asGif().mo714load(imageSource.getSourceForLoad()).apply((BaseRequestOptions<?>) FastImageViewConverter.getOptions(themedReactContext, imageSource, this.mSource).placeholder(this.mDefaultSource).fallback(this.mDefaultSource)).listener(new FastImageRequestListener(stringUrl));
                    } else {
                        requestBuilderApply = requestManager.mo723load(imageSource.getSourceForLoad()).apply((BaseRequestOptions<?>) FastImageViewConverter.getOptions(themedReactContext, imageSource, this.mSource).placeholder(this.mDefaultSource).fallback(this.mDefaultSource));
                    }
                    if (stringUrl != null) {
                        requestBuilderApply.listener(new FastImageRequestListener(stringUrl));
                    }
                    requestBuilderApply.into(this);
                } catch (Exception e) {
                    Log.e("FastImageViewWithUrl", String.format("Error detecting image type for URI: %s. Exception: %s", imageSource != null ? imageSource.getUri().toString() : "null", e.getMessage()), e);
                }
            }
        }
    }

    public void clearView(RequestManager requestManager) {
        if (requestManager == null || getTag() == null || !(getTag() instanceof Request)) {
            return;
        }
        requestManager.clear(this);
    }
}
