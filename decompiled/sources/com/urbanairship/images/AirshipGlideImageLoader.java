package com.urbanairship.images;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.core.view.ViewKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.urbanairship.images.AirshipGlideImageLoader;
import com.urbanairship.images.ImageLoader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/urbanairship/images/AirshipGlideImageLoader;", "Lcom/urbanairship/images/ImageLoader;", "()V", "load", "", "context", "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "imageRequestOptions", "Lcom/urbanairship/images/ImageRequestOptions;", "AirshipImageViewTarget", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipGlideImageLoader implements ImageLoader {

    @NotNull
    public static final AirshipGlideImageLoader INSTANCE = new AirshipGlideImageLoader();

    private AirshipGlideImageLoader() {
    }

    @Override // com.urbanairship.images.ImageLoader
    public void load(@NotNull Context context, @NotNull ImageView imageView, @NotNull final ImageRequestOptions imageRequestOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(imageRequestOptions, "imageRequestOptions");
        RequestBuilder<Drawable> requestBuilderAddListener = Glide.with(imageView).mo724load(imageRequestOptions.getUrl()).addListener(new RequestListener<Drawable>() { // from class: com.urbanairship.images.AirshipGlideImageLoader$load$listener$1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object model, @NotNull Target<Drawable> target, boolean isFirstResource) {
                Intrinsics.checkNotNullParameter(target, "target");
                ImageLoader.ImageLoadedCallback callback = imageRequestOptions.getCallback();
                if (callback != null) {
                    callback.onImageLoaded(false);
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(@NotNull Drawable resource, @NotNull Object model, @Nullable Target<Drawable> target, @NotNull DataSource dataSource, boolean isFirstResource) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(model, "model");
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                ImageLoader.ImageLoadedCallback callback = imageRequestOptions.getCallback();
                if (callback != null) {
                    callback.onImageLoaded(true);
                }
                if (resource instanceof GifDrawable) {
                    ((GifDrawable) resource).setLoopCount(0);
                }
                return false;
            }
        });
        if (imageRequestOptions.getPlaceHolder() != 0) {
            requestBuilderAddListener.placeholder(imageRequestOptions.getPlaceHolder());
        }
        requestBuilderAddListener.transition(DrawableTransitionOptions.withCrossFade(100)).into((RequestBuilder<Drawable>) new AirshipImageViewTarget(imageView, imageRequestOptions, false, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class AirshipImageViewTarget extends DrawableImageViewTarget {
        private final ImageRequestOptions imageRequestOptions;
        private final boolean subtractPadding;

        public /* synthetic */ AirshipImageViewTarget(ImageView imageView, ImageRequestOptions imageRequestOptions, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageView, imageRequestOptions, (i & 4) != 0 ? true : z);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AirshipImageViewTarget(ImageView view, ImageRequestOptions imageRequestOptions, boolean z) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(imageRequestOptions, "imageRequestOptions");
            this.imageRequestOptions = imageRequestOptions;
            this.subtractPadding = z;
        }

        @Override // com.bumptech.glide.request.target.ImageViewTarget, com.bumptech.glide.request.target.Target
        public void onResourceReady(Drawable resource, Transition transition) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            super.onResourceReady((AirshipImageViewTarget) resource, (Transition<? super AirshipImageViewTarget>) transition);
            T view = this.view;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            Iterator<ViewParent> it = ViewKt.getAncestors(view).iterator();
            while (it.hasNext()) {
                it.next().requestLayout();
            }
        }

        @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.Target
        public void getSize(final SizeReadyCallback cb) {
            Intrinsics.checkNotNullParameter(cb, "cb");
            Context context = ((ImageView) this.view).getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Size measuredSize = getMeasuredSize(context);
            if (measuredSize != null) {
                cb.onSizeReady(measuredSize.getWidth(), measuredSize.getHeight());
            } else {
                final ViewTreeObserver viewTreeObserver = ((ImageView) this.view).getViewTreeObserver();
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.urbanairship.images.AirshipGlideImageLoader$AirshipImageViewTarget$getSize$preDrawListener$1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        AirshipGlideImageLoader.AirshipImageViewTarget airshipImageViewTarget = this.this$0;
                        ViewTreeObserver viewTreeObserver2 = viewTreeObserver;
                        Intrinsics.checkNotNullExpressionValue(viewTreeObserver2, "$viewTreeObserver");
                        airshipImageViewTarget.removePreDrawListenerSafe(viewTreeObserver2, this);
                        AirshipGlideImageLoader.AirshipImageViewTarget airshipImageViewTarget2 = this.this$0;
                        Context context2 = ((ImageView) ((ViewTarget) airshipImageViewTarget2).view).getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        Size sizeResolveSize = airshipImageViewTarget2.resolveSize(context2);
                        cb.onSizeReady(sizeResolveSize.getWidth(), sizeResolveSize.getHeight());
                        return true;
                    }
                });
            }
        }

        public final Size resolveSize(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Integer measuredHeight = getMeasuredHeight();
            Integer measuredWith = getMeasuredWith();
            int iIntValue = context.getResources().getDisplayMetrics().widthPixels;
            int iIntValue2 = context.getResources().getDisplayMetrics().heightPixels;
            if (measuredWith != null) {
                iIntValue = measuredWith.intValue();
            } else {
                ImageSizeResolver imageSizeResolver = this.imageRequestOptions.getImageSizeResolver();
                Integer numResolveWidth = imageSizeResolver != null ? imageSizeResolver.resolveWidth(context, measuredHeight) : null;
                if (numResolveWidth != null) {
                    iIntValue = numResolveWidth.intValue();
                }
            }
            if (measuredHeight != null) {
                iIntValue2 = measuredHeight.intValue();
            } else {
                ImageSizeResolver imageSizeResolver2 = this.imageRequestOptions.getImageSizeResolver();
                Integer numResolveHeight = imageSizeResolver2 != null ? imageSizeResolver2.resolveHeight(context, measuredWith) : null;
                if (numResolveHeight != null) {
                    iIntValue2 = numResolveHeight.intValue();
                }
            }
            return new Size(iIntValue, iIntValue2);
        }

        public final Size getMeasuredSize(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Integer measuredHeight = getMeasuredHeight();
            Integer measuredWith = getMeasuredWith();
            if (measuredHeight == null && measuredWith != null) {
                ImageSizeResolver imageSizeResolver = this.imageRequestOptions.getImageSizeResolver();
                measuredHeight = imageSizeResolver != null ? imageSizeResolver.resolveHeight(context, measuredWith) : null;
            }
            if (measuredWith == null && measuredHeight != null) {
                ImageSizeResolver imageSizeResolver2 = this.imageRequestOptions.getImageSizeResolver();
                measuredWith = imageSizeResolver2 != null ? imageSizeResolver2.resolveWidth(context, measuredHeight) : null;
            }
            if (measuredHeight == null || measuredWith == null) {
                return null;
            }
            return new Size(measuredWith.intValue(), measuredHeight.intValue());
        }

        public final Integer getMeasuredWith() {
            ViewGroup.LayoutParams layoutParams = ((ImageView) this.view).getLayoutParams();
            return getMeasuredDimension(layoutParams != null ? layoutParams.width : -1, ((ImageView) this.view).getWidth(), this.subtractPadding ? ((ImageView) this.view).getPaddingLeft() + ((ImageView) this.view).getPaddingRight() : 0);
        }

        public final Integer getMeasuredHeight() {
            ViewGroup.LayoutParams layoutParams = ((ImageView) this.view).getLayoutParams();
            return getMeasuredDimension(layoutParams != null ? layoutParams.height : -1, ((ImageView) this.view).getHeight(), this.subtractPadding ? ((ImageView) this.view).getPaddingTop() + ((ImageView) this.view).getPaddingBottom() : 0);
        }

        public final Integer getMeasuredDimension(int i, int i2, int i3) {
            int i4 = i - i3;
            if (i4 > 0) {
                return Integer.valueOf(i4);
            }
            int i5 = i2 - i3;
            if (i5 > 0) {
                return Integer.valueOf(i5);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removePreDrawListenerSafe(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            } else {
                ((ImageView) this.view).getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
        }
    }
}
