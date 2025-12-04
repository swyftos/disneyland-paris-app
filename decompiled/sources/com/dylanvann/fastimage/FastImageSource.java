package com.dylanvann.fastimage;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.facebook.react.views.imagehelper.ImageSource;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class FastImageSource {
    private static final String ANDROID_CONTENT_SCHEME = "content";
    private static final String ANDROID_RESOURCE_SCHEME = "android.resource";
    private static final String DATA_SCHEME = "data";
    private static final String LOCAL_FILE_SCHEME = "file";
    private static final String LOCAL_RESOURCE_SCHEME = "res";
    private final Headers mHeaders;
    private String mSource;
    private Uri mUri;

    public static boolean isBase64Uri(Uri uri) {
        return "data".equals(uri.getScheme());
    }

    public static boolean isLocalResourceUri(Uri uri) {
        return "res".equals(uri.getScheme());
    }

    public static boolean isResourceUri(Uri uri) {
        return "android.resource".equals(uri.getScheme());
    }

    public static boolean isContentUri(Uri uri) {
        return "content".equals(uri.getScheme());
    }

    public static boolean isLocalFileUri(Uri uri) {
        return "file".equals(uri.getScheme());
    }

    public FastImageSource(Context context, String str) {
        this(context, str, null);
    }

    public FastImageSource(Context context, String str, @Nullable Headers headers) {
        this(context, str, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, headers);
    }

    public FastImageSource(Context context, String str, double d, double d2, @Nullable Headers headers) {
        ImageSource imageSource = new ImageSource(context, str, d, d2);
        this.mSource = imageSource.getSource();
        this.mHeaders = headers == null ? Headers.DEFAULT : headers;
        this.mUri = imageSource.getUri();
        if (isResource() && TextUtils.isEmpty(this.mUri.toString())) {
            throw new Resources.NotFoundException("Local Resource Not Found. Resource: '" + getSource() + "'.");
        }
        if (isLocalResourceUri(this.mUri)) {
            this.mUri = Uri.parse(this.mUri.toString().replace("res:/", "android.resource://" + context.getPackageName() + "/"));
        }
    }

    public boolean isBase64Resource() {
        Uri uri = this.mUri;
        return uri != null && isBase64Uri(uri);
    }

    public boolean isResource() {
        Uri uri = this.mUri;
        return uri != null && isResourceUri(uri);
    }

    public boolean isLocalFile() {
        Uri uri = this.mUri;
        return uri != null && isLocalFileUri(uri);
    }

    public boolean isContentUri() {
        Uri uri = this.mUri;
        return uri != null && isContentUri(uri);
    }

    public Object getSourceForLoad() {
        if (isContentUri() || isBase64Resource()) {
            return getSource();
        }
        if (isResource() || isLocalFile()) {
            return getUri();
        }
        return getGlideUrl();
    }

    public Uri getUri() {
        return this.mUri;
    }

    public Headers getHeaders() {
        return this.mHeaders;
    }

    public GlideUrl getGlideUrl() {
        return new GlideUrl(getUri().toString(), getHeaders());
    }

    public String getSource() {
        return this.mSource;
    }
}
