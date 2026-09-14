package com.dylanvann.fastimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class GlideRequests extends RequestManager {
    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public /* bridge */ /* synthetic */ RequestManager addDefaultRequestListener(RequestListener requestListener) {
        return addDefaultRequestListener((RequestListener<Object>) requestListener);
    }

    public GlideRequests(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: as */
    public <ResourceType> GlideRequest<ResourceType> mo738as(@NonNull Class<ResourceType> cls) {
        return new GlideRequest<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public synchronized GlideRequests applyDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (GlideRequests) super.applyDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public synchronized GlideRequests setDefaultRequestOptions(@NonNull RequestOptions requestOptions) {
        return (GlideRequests) super.setDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public synchronized GlideRequests clearOnStop() {
        return (GlideRequests) super.clearOnStop();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    public GlideRequests addDefaultRequestListener(RequestListener<Object> requestListener) {
        return (GlideRequests) super.addDefaultRequestListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<GifDrawable> asGif() {
        return (GlideRequest) super.asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest) super.asDrawable();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2956load(@Nullable Bitmap bitmap) {
        return (GlideRequest) super.mo2956load(bitmap);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2957load(@Nullable Drawable drawable) {
        return (GlideRequest) super.mo2957load(drawable);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2962load(@Nullable String str) {
        return (GlideRequest) super.mo2962load(str);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2958load(@Nullable Uri uri) {
        return (GlideRequest) super.mo2958load(uri);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2959load(@Nullable File file) {
        return (GlideRequest) super.mo2959load(file);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2960load(@Nullable @DrawableRes @RawRes Integer num) {
        return (GlideRequest) super.mo2960load(num);
    }

    @Override // com.bumptech.glide.RequestManager
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2963load(@Nullable URL url) {
        return (GlideRequest) super.mo2963load(url);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2964load(@Nullable byte[] bArr) {
        return (GlideRequest) super.mo2964load(bArr);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo2961load(@Nullable Object obj) {
        return (GlideRequest) super.mo2961load(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<File> downloadOnly() {
        return (GlideRequest) super.downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<File> download(@Nullable Object obj) {
        return (GlideRequest) super.download(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    @NonNull
    @CheckResult
    public GlideRequest<File> asFile() {
        return (GlideRequest) super.asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    protected void setRequestOptions(@NonNull RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new GlideOptions().apply((BaseRequestOptions<?>) requestOptions));
        }
    }
}
