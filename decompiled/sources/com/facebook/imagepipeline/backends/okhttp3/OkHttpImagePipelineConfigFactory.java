package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpImagePipelineConfigFactory;", "", "<init>", "()V", "newBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "context", "Landroid/content/Context;", "okHttpClient", "Lokhttp3/OkHttpClient;", "imagepipeline-okhttp3_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OkHttpImagePipelineConfigFactory {

    @NotNull
    public static final OkHttpImagePipelineConfigFactory INSTANCE = new OkHttpImagePipelineConfigFactory();

    private OkHttpImagePipelineConfigFactory() {
    }

    @JvmStatic
    @NotNull
    public static final ImagePipelineConfig.Builder newBuilder(@NotNull Context context, @NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        return ImagePipelineConfig.INSTANCE.newBuilder(context).setNetworkFetcher(new OkHttpNetworkFetcher(okHttpClient));
    }
}
