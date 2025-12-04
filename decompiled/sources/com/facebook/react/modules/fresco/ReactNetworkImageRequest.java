package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;", "Lcom/facebook/imagepipeline/request/ImageRequest;", "builder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "headers", "Lcom/facebook/react/bridge/ReadableMap;", "cacheControl", "Lcom/facebook/react/modules/fresco/ImageCacheControl;", "<init>", "(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/modules/fresco/ImageCacheControl;)V", "getHeaders$ReactAndroid_release", "()Lcom/facebook/react/bridge/ReadableMap;", "getCacheControl$ReactAndroid_release", "()Lcom/facebook/react/modules/fresco/ImageCacheControl;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactNetworkImageRequest extends ImageRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final ImageCacheControl cacheControl;

    @Nullable
    private final ReadableMap headers;

    public /* synthetic */ ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageRequestBuilder, readableMap, imageCacheControl);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder imageRequestBuilder, @Nullable ReadableMap readableMap) {
        return INSTANCE.fromBuilderWithHeaders(imageRequestBuilder, readableMap);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder imageRequestBuilder, @Nullable ReadableMap readableMap, @NotNull ImageCacheControl imageCacheControl) {
        return INSTANCE.fromBuilderWithHeaders(imageRequestBuilder, readableMap, imageCacheControl);
    }

    @Nullable
    /* renamed from: getHeaders$ReactAndroid_release, reason: from getter */
    public final ReadableMap getHeaders() {
        return this.headers;
    }

    @NotNull
    /* renamed from: getCacheControl$ReactAndroid_release, reason: from getter */
    public final ImageCacheControl getCacheControl() {
        return this.cacheControl;
    }

    private ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl) {
        super(imageRequestBuilder);
        this.headers = readableMap;
        this.cacheControl = imageCacheControl;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest$Companion;", "", "<init>", "()V", "fromBuilderWithHeaders", "Lcom/facebook/react/modules/fresco/ReactNetworkImageRequest;", "builder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "headers", "Lcom/facebook/react/bridge/ReadableMap;", "cacheControl", "Lcom/facebook/react/modules/fresco/ImageCacheControl;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder builder, @Nullable ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return fromBuilderWithHeaders$default(this, builder, readableMap, null, 4, null);
        }

        private Companion() {
        }

        public static /* synthetic */ ReactNetworkImageRequest fromBuilderWithHeaders$default(Companion companion, ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl, int i, Object obj) {
            if ((i & 4) != 0) {
                imageCacheControl = ImageCacheControl.DEFAULT;
            }
            return companion.fromBuilderWithHeaders(imageRequestBuilder, readableMap, imageCacheControl);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ReactNetworkImageRequest fromBuilderWithHeaders(@NotNull ImageRequestBuilder builder, @Nullable ReadableMap headers, @NotNull ImageCacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            return new ReactNetworkImageRequest(builder, headers, cacheControl, null);
        }
    }
}
