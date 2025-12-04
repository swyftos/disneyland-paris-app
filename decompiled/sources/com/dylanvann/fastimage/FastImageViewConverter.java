package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import com.urbanairship.push.PushMessage;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class FastImageViewConverter {
    private static final Drawable TRANSPARENT_DRAWABLE = new ColorDrawable(0);
    private static final Map FAST_IMAGE_CACHE_CONTROL_MAP = new HashMap() { // from class: com.dylanvann.fastimage.FastImageViewConverter.1
        {
            put("immutable", FastImageCacheControl.IMMUTABLE);
            put("web", FastImageCacheControl.WEB);
            put("cacheOnly", FastImageCacheControl.CACHE_ONLY);
        }
    };
    private static final Map FAST_IMAGE_PRIORITY_MAP = new HashMap() { // from class: com.dylanvann.fastimage.FastImageViewConverter.2
        {
            put("low", Priority.LOW);
            put("normal", Priority.NORMAL);
            put(PushMessage.PRIORITY_HIGH, Priority.HIGH);
        }
    };
    private static final Map FAST_IMAGE_RESIZE_MODE_MAP = new HashMap() { // from class: com.dylanvann.fastimage.FastImageViewConverter.3
        {
            put("contain", ImageView.ScaleType.FIT_CENTER);
            put("cover", ImageView.ScaleType.CENTER_CROP);
            put("stretch", ImageView.ScaleType.FIT_XY);
            put("center", ImageView.ScaleType.CENTER_INSIDE);
        }
    };

    static FastImageSource getImageSource(Context context, ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        return new FastImageSource(context, readableMap.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI), getHeaders(readableMap));
    }

    static Headers getHeaders(ReadableMap readableMap) {
        Headers headers = Headers.DEFAULT;
        if (!readableMap.hasKey("headers")) {
            return headers;
        }
        if (readableMap.getType("headers") == ReadableType.Map) {
            ReadableMap map = readableMap.getMap("headers");
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            LazyHeaders.Builder builder = new LazyHeaders.Builder();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                String string = map.getString(strNextKey);
                if (string != null) {
                    builder.addHeader(strNextKey, string);
                }
            }
            return builder.build();
        }
        ReadableArray array = readableMap.getArray("headers");
        if (array == null || array.size() == 0) {
            return headers;
        }
        LazyHeaders.Builder builder2 = new LazyHeaders.Builder();
        for (int i = 0; i < array.size(); i++) {
            ReadableMap map2 = array.getMap(i);
            String string2 = map2.hasKey("header") ? map2.getString("header") : null;
            String string3 = map2.hasKey("value") ? map2.getString("value") : null;
            if (string2 != null && string3 != null) {
                builder2.addHeader(string2, string3);
            }
        }
        return builder2.build();
    }

    static RequestOptions getOptions(Context context, FastImageSource fastImageSource, ReadableMap readableMap) {
        Priority priority = getPriority(readableMap);
        FastImageCacheControl cacheControl = getCacheControl(readableMap);
        DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        int i = AnonymousClass4.$SwitchMap$com$dylanvann$fastimage$FastImageCacheControl[cacheControl.ordinal()];
        boolean z = true;
        boolean z2 = false;
        if (i == 1) {
            diskCacheStrategy = DiskCacheStrategy.NONE;
            z2 = true;
            z = false;
        } else if (i != 2) {
            z = false;
        }
        RequestOptions requestOptionsPlaceholder = new RequestOptions().diskCacheStrategy(diskCacheStrategy).onlyRetrieveFromCache(z).skipMemoryCache(z2).priority(priority).placeholder(TRANSPARENT_DRAWABLE);
        return fastImageSource.isResource() ? requestOptionsPlaceholder.apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(context))) : requestOptionsPlaceholder;
    }

    /* renamed from: com.dylanvann.fastimage.FastImageViewConverter$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl;

        static {
            int[] iArr = new int[FastImageCacheControl.values().length];
            $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl = iArr;
            try {
                iArr[FastImageCacheControl.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl[FastImageCacheControl.CACHE_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dylanvann$fastimage$FastImageCacheControl[FastImageCacheControl.IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static FastImageCacheControl getCacheControl(ReadableMap readableMap) {
        return (FastImageCacheControl) getValueFromSource("cache", "immutable", FAST_IMAGE_CACHE_CONTROL_MAP, readableMap);
    }

    private static Priority getPriority(ReadableMap readableMap) {
        return (Priority) getValueFromSource(Constants.FirelogAnalytics.PARAM_PRIORITY, "normal", FAST_IMAGE_PRIORITY_MAP, readableMap);
    }

    static ImageView.ScaleType getScaleType(String str) {
        return (ImageView.ScaleType) getValue(ViewProps.RESIZE_MODE, "cover", FAST_IMAGE_RESIZE_MODE_MAP, str);
    }

    private static Object getValue(String str, String str2, Map map, String str3) {
        if (str3 != null) {
            str2 = str3;
        }
        Object obj = map.get(str2);
        if (obj != null) {
            return obj;
        }
        throw new JSApplicationIllegalArgumentException("FastImage, invalid " + str + " : " + str2);
    }

    private static Object getValueFromSource(String str, String str2, Map map, ReadableMap readableMap) {
        String string = null;
        if (readableMap != null) {
            try {
                string = readableMap.getString(str);
            } catch (NoSuchKeyException unused) {
            }
        }
        return getValue(str, str2, map, string);
    }
}
