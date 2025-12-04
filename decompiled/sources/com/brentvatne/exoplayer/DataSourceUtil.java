package com.brentvatne.exoplayer;

import android.net.Uri;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.AssetDataSource;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CookieJar;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0007J0\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0007J0\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0002J0\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0002J\u001c\u0010\u0015\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/brentvatne/exoplayer/DataSourceUtil;", "", "<init>", "()V", "defaultDataSourceFactory", "Landroidx/media3/datasource/DataSource$Factory;", "defaultHttpDataSourceFactory", "Landroidx/media3/datasource/HttpDataSource$Factory;", "userAgent", "", "getUserAgent", "context", "Lcom/facebook/react/bridge/ReactContext;", "getDefaultDataSourceFactory", "bandwidthMeter", "Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "requestHeaders", "", "getDefaultHttpDataSourceFactory", "buildDataSourceFactory", "buildHttpDataSourceFactory", "buildAssetDataSourceFactory", "srcUri", "Landroid/net/Uri;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataSourceUtil {

    @NotNull
    public static final DataSourceUtil INSTANCE = new DataSourceUtil();
    private static DataSource.Factory defaultDataSourceFactory;
    private static HttpDataSource.Factory defaultHttpDataSourceFactory;
    private static String userAgent;

    /* JADX INFO: Access modifiers changed from: private */
    public static final DataSource buildAssetDataSourceFactory$lambda$0(AssetDataSource assetDataSource) {
        return assetDataSource;
    }

    private DataSourceUtil() {
    }

    private final String getUserAgent(ReactContext context) {
        if (userAgent == null) {
            userAgent = Util.getUserAgent(context, context.getPackageName());
        }
        String str = userAgent;
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
        return str;
    }

    @JvmStatic
    @NotNull
    public static final DataSource.Factory getDefaultDataSourceFactory(@NotNull ReactContext context, @Nullable DefaultBandwidthMeter bandwidthMeter, @Nullable Map<String, String> requestHeaders) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (defaultDataSourceFactory == null || (requestHeaders != null && !requestHeaders.isEmpty())) {
            defaultDataSourceFactory = INSTANCE.buildDataSourceFactory(context, bandwidthMeter, requestHeaders);
        }
        DataSource.Factory factory = defaultDataSourceFactory;
        Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type androidx.media3.datasource.DataSource.Factory");
        return factory;
    }

    @JvmStatic
    @NotNull
    public static final HttpDataSource.Factory getDefaultHttpDataSourceFactory(@NotNull ReactContext context, @Nullable DefaultBandwidthMeter bandwidthMeter, @Nullable Map<String, String> requestHeaders) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (defaultHttpDataSourceFactory == null || (requestHeaders != null && !requestHeaders.isEmpty())) {
            defaultHttpDataSourceFactory = INSTANCE.buildHttpDataSourceFactory(context, bandwidthMeter, requestHeaders);
        }
        HttpDataSource.Factory factory = defaultHttpDataSourceFactory;
        Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type androidx.media3.datasource.HttpDataSource.Factory");
        return factory;
    }

    private final DataSource.Factory buildDataSourceFactory(ReactContext context, DefaultBandwidthMeter bandwidthMeter, Map requestHeaders) {
        return new DefaultDataSource.Factory(context, buildHttpDataSourceFactory(context, bandwidthMeter, requestHeaders));
    }

    private final HttpDataSource.Factory buildHttpDataSourceFactory(ReactContext context, DefaultBandwidthMeter bandwidthMeter, Map requestHeaders) {
        OkHttpClient okHttpClient = OkHttpClientProvider.getOkHttpClient();
        CookieJar cookieJar = okHttpClient.cookieJar();
        Intrinsics.checkNotNull(cookieJar, "null cannot be cast to non-null type com.facebook.react.modules.network.CookieJarContainer");
        ((CookieJarContainer) cookieJar).setCookieJar(new JavaNetCookieJar(new ForwardingCookieHandler(context)));
        Intrinsics.checkNotNull(okHttpClient, "null cannot be cast to non-null type okhttp3.Call.Factory");
        OkHttpDataSource.Factory transferListener = new OkHttpDataSource.Factory(okHttpClient).setTransferListener(bandwidthMeter);
        Intrinsics.checkNotNullExpressionValue(transferListener, "setTransferListener(...)");
        if (requestHeaders != null) {
            transferListener.setDefaultRequestProperties((Map<String, String>) requestHeaders);
            if (!requestHeaders.containsKey("User-Agent")) {
                transferListener.setUserAgent(getUserAgent(context));
            }
        } else {
            Intrinsics.checkNotNull(transferListener.setUserAgent(getUserAgent(context)));
        }
        return transferListener;
    }

    @JvmStatic
    @NotNull
    public static final DataSource.Factory buildAssetDataSourceFactory(@Nullable ReactContext context, @Nullable Uri srcUri) throws IOException {
        Intrinsics.checkNotNull(srcUri);
        DataSpec dataSpec = new DataSpec(srcUri);
        Intrinsics.checkNotNull(context);
        final AssetDataSource assetDataSource = new AssetDataSource(context);
        assetDataSource.open(dataSpec);
        return new DataSource.Factory() { // from class: com.brentvatne.exoplayer.DataSourceUtil$$ExternalSyntheticLambda0
            @Override // androidx.media3.datasource.DataSource.Factory
            public final DataSource createDataSource() {
                return DataSourceUtil.buildAssetDataSourceFactory$lambda$0(assetDataSource);
            }
        };
    }
}
