package com.allegion.accesshub.api;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.allegion.accesshub.enums.Header;
import com.allegion.accesshub.exceptions.AlMAHException;
import com.allegion.accesshub.interfaces.IAlConfig;
import com.allegion.accesshub.interfaces.IAlMAHEnvironment;
import com.allegion.accesshub.models.APIManagementPublicKeyMAHResponse;
import com.allegion.accesshub.services.ApiManagementService;
import com.allegion.alsecurity.AlEcc;
import com.allegion.logging.AlLog;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J3\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0013J!\u0010\u000e\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0017J+\u0010\t\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/allegion/accesshub/api/AlMAHApiService;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;", "environment", "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "Lcom/allegion/accesshub/interfaces/IAlConfig;", "config", "getServiceInstance", "(Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;Ljava/lang/Class;Lcom/allegion/accesshub/interfaces/IAlConfig;)Ljava/lang/Object;", "", "baseUrl", "Lretrofit2/Retrofit;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;Lcom/allegion/accesshub/interfaces/IAlConfig;)Lretrofit2/Retrofit;", "Lokhttp3/Response;", "response", "", "(Lokhttp3/Response;Lcom/allegion/accesshub/interfaces/IAlConfig;)V", "", "responseBody", "", "([BLcom/allegion/accesshub/interfaces/IAlConfig;)Z", "getServiceInstance$AccessHub_prodRelease", "(Ljava/lang/String;Ljava/lang/Class;Lcom/allegion/accesshub/interfaces/IAlConfig;)Ljava/lang/Object;", "Lokhttp3/Request;", "request", "", "Lcom/allegion/accesshub/enums/Header;", "determineHeaders$AccessHub_prodRelease", "(Lokhttp3/Request;)[Lcom/allegion/accesshub/enums/Header;", "determineHeaders", "getOriginKeys$AccessHub_prodRelease", "(Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;Lcom/allegion/accesshub/interfaces/IAlConfig;)V", "getOriginKeys", "<init>", "()V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlMAHApiService {
    public static final AlMAHApiService INSTANCE = new AlMAHApiService();

    private AlMAHApiService() {
    }

    private final Retrofit a(String baseUrl, IAlConfig config) {
        CertificatePinner certificatePinnerBuild;
        Retrofit.Builder builderBaseUrl = new Retrofit.Builder().baseUrl(baseUrl);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j = 30;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(j, timeUnit);
        builder.readTimeout(j, timeUnit);
        builder.writeTimeout(j, timeUnit);
        HashMap<String, String> pinSet = config.getPinSet();
        if (pinSet == null || pinSet.isEmpty()) {
            certificatePinnerBuild = null;
        } else {
            CertificatePinner.Builder builder2 = new CertificatePinner.Builder();
            for (Map.Entry<String, String> entry : config.getPinSet().entrySet()) {
                builder2.add(entry.getKey(), entry.getValue());
            }
            certificatePinnerBuild = builder2.build();
        }
        if (certificatePinnerBuild != null) {
            builder.certificatePinner(certificatePinnerBuild);
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor).addInterceptor(new a(config));
        OkHttpClient okHttpClientBuild = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(okHttpClientBuild, "httpClientBuilder.build()");
        Retrofit retrofitBuild = builderBaseUrl.client(okHttpClientBuild).addConverterFactory(GsonConverterFactory.create(new Gson())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        Intrinsics.checkExpressionValueIsNotNull(retrofitBuild, "retrofit2.Retrofit.Build…e())\n            .build()");
        return retrofitBuild;
    }

    @JvmStatic
    public static final <T> T getServiceInstance(@NotNull IAlMAHEnvironment environment, @NotNull Class<T> service, @NotNull IAlConfig config) {
        Intrinsics.checkParameterIsNotNull(environment, "environment");
        Intrinsics.checkParameterIsNotNull(service, "service");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (!config.getStorage().contains("originKey0") && !config.getStorage().contains("originKey1")) {
            INSTANCE.getOriginKeys$AccessHub_prodRelease(environment, config);
        }
        return (T) INSTANCE.a(environment.getBaseAccessHubUrl(), config).create(service);
    }

    @NotNull
    public final Header[] determineHeaders$AccessHub_prodRelease(@NotNull Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        List<String> listValues = request.headers().values("AlHeader");
        ArrayList arrayList = new ArrayList();
        for (String header : listValues) {
            try {
                Intrinsics.checkExpressionValueIsNotNull(header, "header");
                arrayList.add(Header.valueOf(header));
            } catch (IllegalArgumentException e) {
                AlLog.w(e, "Invalid header during API service creation: " + header, new Object[0]);
            }
        }
        Object[] array = arrayList.toArray(new Header[0]);
        if (array != null) {
            return (Header[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void getOriginKeys$AccessHub_prodRelease(@NotNull IAlMAHEnvironment environment, @NotNull IAlConfig config) throws IOException {
        Intrinsics.checkParameterIsNotNull(environment, "environment");
        Intrinsics.checkParameterIsNotNull(config, "config");
        ((ApiManagementService) a(environment.getBaseApiManagementUrl(), config).create(ApiManagementService.class)).publicKeys().execute();
    }

    @NotNull
    public final Object getServiceInstance$AccessHub_prodRelease(@NotNull String baseUrl, @NotNull Class<?> service, @NotNull IAlConfig config) throws SecurityException {
        Intrinsics.checkParameterIsNotNull(baseUrl, "baseUrl");
        Intrinsics.checkParameterIsNotNull(service, "service");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Object objCreate = a(baseUrl, config).create(service);
        Intrinsics.checkExpressionValueIsNotNull(objCreate, "getRetrofitInstance(base…, config).create(service)");
        return objCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Response response, IAlConfig config) throws AlMAHException, IOException {
        Response responseNetworkResponse = response.networkResponse();
        String strHeader = responseNetworkResponse != null ? responseNetworkResponse.header("alle-signatures") : null;
        byte[] bArrBytes = response.peekBody(Long.MAX_VALUE).bytes();
        a(bArrBytes, config);
        if (strHeader != null && bArrBytes != null) {
            AlEcc alEcc = new AlEcc();
            try {
                byte[] bArrDecode = Hex.decode(StringsKt.substringBefore$default(strHeader, ',', (String) null, 2, (Object) null));
                Intrinsics.checkExpressionValueIsNotNull(bArrDecode, "Hex.decode(signatureHeader.substringBefore(','))");
                byte[] bArrDecode2 = Hex.decode(StringsKt.substringAfter$default(strHeader, ',', (String) null, 2, (Object) null));
                Intrinsics.checkExpressionValueIsNotNull(bArrDecode2, "Hex.decode(signatureHeader.substringAfter(','))");
                byte[] bArrDecode3 = Hex.decode(config.getStorage().retrieve("originKey0"));
                Intrinsics.checkExpressionValueIsNotNull(bArrDecode3, "Hex.decode(config.storage.retrieve(ORIGIN_KEY_0))");
                ECPublicKey eCPublicKeyEncodeEccPublicKey = alEcc.encodeEccPublicKey(bArrDecode3);
                byte[] bArrDecode4 = Hex.decode(config.getStorage().retrieve("originKey1"));
                Intrinsics.checkExpressionValueIsNotNull(bArrDecode4, "Hex.decode(config.storage.retrieve(ORIGIN_KEY_1))");
                ECPublicKey eCPublicKeyEncodeEccPublicKey2 = alEcc.encodeEccPublicKey(bArrDecode4);
                if (alEcc.verify(eCPublicKeyEncodeEccPublicKey, bArrBytes, bArrDecode) || alEcc.verify(eCPublicKeyEncodeEccPublicKey2, bArrBytes, bArrDecode2)) {
                    return;
                }
                config.getStorage().remove("originKey0");
                config.getStorage().remove("originKey1");
                throw new AlMAHException("Response header signature validation failed");
            } catch (Exception e) {
                config.getStorage().remove("originKey0");
                config.getStorage().remove("originKey1");
                throw new AlMAHException("Setup for header signature validation failing", e);
            }
        }
        throw new AlMAHException("Response body or header null");
    }

    private final boolean a(byte[] responseBody, IAlConfig config) {
        if (responseBody == null) {
            return false;
        }
        Charset charset = Charsets.UTF_8;
        if (!StringsKt.contains$default((CharSequence) new String(responseBody, charset), (CharSequence) "publicKey", false, 2, (Object) null)) {
            return false;
        }
        try {
            APIManagementPublicKeyMAHResponse aPIManagementPublicKeyMAHResponse = (APIManagementPublicKeyMAHResponse) new Gson().fromJson(new String(responseBody, charset), APIManagementPublicKeyMAHResponse.class);
            if (aPIManagementPublicKeyMAHResponse != null) {
                config.getStorage().store("originKey0", aPIManagementPublicKeyMAHResponse.getPublicKey0());
                config.getStorage().store("originKey1", aPIManagementPublicKeyMAHResponse.getPublicKey1());
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
