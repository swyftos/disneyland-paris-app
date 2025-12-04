package com.facebook.react.modules.network;

import android.content.Context;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\u0012\u001a\u00020\u0005H\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0007J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/facebook/react/modules/network/OkHttpClientProvider;", "", "<init>", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient$ReactAndroid_release", "()Lokhttp3/OkHttpClient;", "setClient$ReactAndroid_release", "(Lokhttp3/OkHttpClient;)V", "factory", "Lcom/facebook/react/modules/network/OkHttpClientFactory;", "getFactory$ReactAndroid_release", "()Lcom/facebook/react/modules/network/OkHttpClientFactory;", "setFactory$ReactAndroid_release", "(Lcom/facebook/react/modules/network/OkHttpClientFactory;)V", "setOkHttpClientFactory", "", "getOkHttpClient", "createClient", "context", "Landroid/content/Context;", "createClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "cacheSize", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOkHttpClientProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHttpClientProvider.kt\ncom/facebook/react/modules/network/OkHttpClientProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n1#2:81\n*E\n"})
/* loaded from: classes3.dex */
public final class OkHttpClientProvider {

    @NotNull
    public static final OkHttpClientProvider INSTANCE = new OkHttpClientProvider();

    @Nullable
    private static OkHttpClient client;

    @Nullable
    private static OkHttpClientFactory factory;

    private OkHttpClientProvider() {
    }

    @Nullable
    public final OkHttpClient getClient$ReactAndroid_release() {
        return client;
    }

    public final void setClient$ReactAndroid_release(@Nullable OkHttpClient okHttpClient) {
        client = okHttpClient;
    }

    @Nullable
    public final OkHttpClientFactory getFactory$ReactAndroid_release() {
        return factory;
    }

    public final void setFactory$ReactAndroid_release(@Nullable OkHttpClientFactory okHttpClientFactory) {
        factory = okHttpClientFactory;
    }

    @JvmStatic
    public static final void setOkHttpClientFactory(@Nullable OkHttpClientFactory factory2) {
        factory = factory2;
    }

    @JvmStatic
    @NotNull
    public static final OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = client;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient okHttpClientCreateClient = createClient();
        client = okHttpClientCreateClient;
        return okHttpClientCreateClient;
    }

    @JvmStatic
    @NotNull
    public static final OkHttpClient createClient() {
        OkHttpClient okHttpClientCreateNewNetworkModuleClient;
        OkHttpClientFactory okHttpClientFactory = factory;
        return (okHttpClientFactory == null || (okHttpClientCreateNewNetworkModuleClient = okHttpClientFactory.createNewNetworkModuleClient()) == null) ? createClientBuilder().build() : okHttpClientCreateNewNetworkModuleClient;
    }

    @JvmStatic
    @NotNull
    public static final OkHttpClient createClient(@NotNull Context context) {
        OkHttpClient okHttpClientCreateNewNetworkModuleClient;
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClientFactory okHttpClientFactory = factory;
        return (okHttpClientFactory == null || (okHttpClientCreateNewNetworkModuleClient = okHttpClientFactory.createNewNetworkModuleClient()) == null) ? createClientBuilder(context).build() : okHttpClientCreateNewNetworkModuleClient;
    }

    @JvmStatic
    @NotNull
    public static final OkHttpClient.Builder createClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(0L, timeUnit).readTimeout(0L, timeUnit).writeTimeout(0L, timeUnit).cookieJar(new ReactCookieJarContainer());
    }

    @JvmStatic
    @NotNull
    public static final OkHttpClient.Builder createClientBuilder(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return createClientBuilder(context, 10485760);
    }

    @JvmStatic
    @NotNull
    public static final OkHttpClient.Builder createClientBuilder(@NotNull Context context, int cacheSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClient.Builder builderCreateClientBuilder = createClientBuilder();
        return cacheSize == 0 ? builderCreateClientBuilder : builderCreateClientBuilder.cache(new Cache(new File(context.getCacheDir(), "http-cache"), cacheSize));
    }
}
