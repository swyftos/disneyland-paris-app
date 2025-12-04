package com.urbanairship.remotedata;

import android.content.Context;
import android.net.Uri;
import com.facebook.hermes.intl.Constants;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestResult;
import com.urbanairship.remotedata.RemoteDataApiClient;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/remotedata/AppRemoteDataProvider;", "Lcom/urbanairship/remotedata/RemoteDataProvider;", "context", "Landroid/content/Context;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "apiClient", "Lcom/urbanairship/remotedata/RemoteDataApiClient;", "urlFactory", "Lcom/urbanairship/remotedata/RemoteDataUrlFactory;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/remotedata/RemoteDataApiClient;Lcom/urbanairship/remotedata/RemoteDataUrlFactory;)V", "createUrl", "Landroid/net/Uri;", Constants.LOCALE, "Ljava/util/Locale;", "randomValue", "", "fetchRemoteData", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/remotedata/RemoteDataApiClient$Result;", "lastRemoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "(Ljava/util/Locale;ILcom/urbanairship/remotedata/RemoteDataInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRemoteDataInfoUpToDate", "", "remoteDataInfo", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppRemoteDataProvider extends RemoteDataProvider {

    @NotNull
    public static final String LAST_REFRESH_METADATA = "com.urbanairship.remotedata.LAST_REFRESH_METADATA";
    private final RemoteDataApiClient apiClient;
    private final RemoteDataUrlFactory urlFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppRemoteDataProvider(@NotNull Context context, @NotNull PreferenceDataStore preferenceDataStore, @NotNull AirshipRuntimeConfig config, @NotNull RemoteDataApiClient apiClient, @NotNull RemoteDataUrlFactory urlFactory) {
        super(RemoteDataSource.APP, new RemoteDataStore(context, config.getConfigOptions().appKey, "ua_remotedata.db"), preferenceDataStore, true, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        Intrinsics.checkNotNullParameter(urlFactory, "urlFactory");
        this.apiClient = apiClient;
        this.urlFactory = urlFactory;
        if (preferenceDataStore.isSet(LAST_REFRESH_METADATA)) {
            preferenceDataStore.remove(LAST_REFRESH_METADATA);
            clearLastRefreshState();
        }
    }

    @Override // com.urbanairship.remotedata.RemoteDataProvider
    public boolean isRemoteDataInfoUpToDate(@NotNull RemoteDataInfo remoteDataInfo, @NotNull Locale locale, int randomValue) {
        Intrinsics.checkNotNullParameter(remoteDataInfo, "remoteDataInfo");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Uri uriCreateUrl = createUrl(locale, randomValue);
        return uriCreateUrl != null && RemoteDataSource.APP == remoteDataInfo.getSource() && Intrinsics.areEqual(uriCreateUrl.toString(), remoteDataInfo.getUrl());
    }

    @Override // com.urbanairship.remotedata.RemoteDataProvider
    @Nullable
    public Object fetchRemoteData(@NotNull Locale locale, int i, @Nullable RemoteDataInfo remoteDataInfo, @NotNull Continuation<? super RequestResult<RemoteDataApiClient.Result>> continuation) {
        final Uri uriCreateUrl = createUrl(locale, i);
        return this.apiClient.fetch$urbanairship_core_release(uriCreateUrl, RequestAuth.GeneratedAppToken.INSTANCE, Intrinsics.areEqual(remoteDataInfo != null ? remoteDataInfo.getUrl() : null, String.valueOf(uriCreateUrl)) ? remoteDataInfo.getLastModified() : null, new Function1() { // from class: com.urbanairship.remotedata.AppRemoteDataProvider.fetchRemoteData.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RemoteDataInfo invoke(String str) {
                return new RemoteDataInfo(String.valueOf(uriCreateUrl), str, RemoteDataSource.APP, null, 8, null);
            }
        }, continuation);
    }

    private final Uri createUrl(Locale locale, int randomValue) {
        return this.urlFactory.createAppUrl(locale, randomValue);
    }
}
