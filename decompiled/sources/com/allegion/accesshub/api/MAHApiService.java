package com.allegion.accesshub.api;

import androidx.core.app.NotificationCompat;
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
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b6\u00107J+\u0010\b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0012J+\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010+\u001a\u00020(2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020#H\u0000¢\u0006\u0004\b)\u0010*J!\u0010.\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b,\u0010-J\u0017\u00101\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b/\u00100J\u0019\u00105\u001a\u0004\u0018\u0001022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/allegion/accesshub/api/MAHApiService;", "", "Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;", "environment", "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "Lcom/allegion/accesshub/interfaces/IAlConfig;", "config", "getServiceInstance", "(Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;Ljava/lang/Class;Lcom/allegion/accesshub/interfaces/IAlConfig;)Ljava/lang/Object;", "", "baseUrl", "Lretrofit2/Retrofit;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;Lcom/allegion/accesshub/interfaces/IAlConfig;)Lretrofit2/Retrofit;", "Lokhttp3/Response;", "response", "", "(Lokhttp3/Response;Lcom/allegion/accesshub/interfaces/IAlConfig;)V", "getServiceInstance$AccessHub_prodRelease", "(Ljava/lang/String;Ljava/lang/Class;Lcom/allegion/accesshub/interfaces/IAlConfig;)Ljava/lang/Object;", "Lokhttp3/Request;", "request", "", "Lcom/allegion/accesshub/enums/Header;", "determineHeaders$AccessHub_prodRelease", "(Lokhttp3/Request;)[Lcom/allegion/accesshub/enums/Header;", "determineHeaders", "getOriginKeys$AccessHub_prodRelease", "(Lcom/allegion/accesshub/interfaces/IAlMAHEnvironment;Lcom/allegion/accesshub/interfaces/IAlConfig;)V", "getOriginKeys", "Lcom/allegion/alsecurity/AlEcc;", "eccTool", "Ljava/security/interfaces/ECPublicKey;", "pub0", "", "responseBody", "sig0", "pub1", "sig1", "", "verifySignatures$AccessHub_prodRelease", "(Lcom/allegion/alsecurity/AlEcc;Ljava/security/interfaces/ECPublicKey;[B[BLjava/security/interfaces/ECPublicKey;[B)Z", "verifySignatures", "getPublicKeysFromRawResponse$AccessHub_prodRelease", "([BLcom/allegion/accesshub/interfaces/IAlConfig;)Z", "getPublicKeysFromRawResponse", "clearOriginKeys$AccessHub_prodRelease", "(Lcom/allegion/accesshub/interfaces/IAlConfig;)V", "clearOriginKeys", "Lokhttp3/CertificatePinner;", "buildCertificatePinner$AccessHub_prodRelease", "(Lcom/allegion/accesshub/interfaces/IAlConfig;)Lokhttp3/CertificatePinner;", "buildCertificatePinner", "<init>", "()V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class MAHApiService {
    public static final MAHApiService INSTANCE = new MAHApiService();

    private MAHApiService() {
    }

    private final Retrofit a(String baseUrl, IAlConfig config) {
        Retrofit.Builder builderBaseUrl = new Retrofit.Builder().baseUrl(baseUrl);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j = 30;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(j, timeUnit);
        builder.readTimeout(j, timeUnit);
        builder.writeTimeout(j, timeUnit);
        CertificatePinner certificatePinnerBuildCertificatePinner$AccessHub_prodRelease = buildCertificatePinner$AccessHub_prodRelease(config);
        if (certificatePinnerBuildCertificatePinner$AccessHub_prodRelease != null) {
            builder.certificatePinner(certificatePinnerBuildCertificatePinner$AccessHub_prodRelease);
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor).addInterceptor(new b(config));
        OkHttpClient okHttpClientBuild = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(okHttpClientBuild, "httpClientBuilder.build()");
        Retrofit retrofitBuild = builderBaseUrl.client(okHttpClientBuild).addConverterFactory(GsonConverterFactory.create(new Gson())).build();
        Intrinsics.checkExpressionValueIsNotNull(retrofitBuild, "Retrofit.Builder()\n     …()))\n            .build()");
        return retrofitBuild;
    }

    @JvmStatic
    @NotNull
    public static final Object getServiceInstance(@NotNull IAlMAHEnvironment environment, @NotNull Class<?> service, @NotNull IAlConfig config) throws IOException, SecurityException {
        Intrinsics.checkParameterIsNotNull(environment, "environment");
        Intrinsics.checkParameterIsNotNull(service, "service");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (!config.getStorage().contains("originKey0") && !config.getStorage().contains("originKey1")) {
            INSTANCE.getOriginKeys$AccessHub_prodRelease(environment, config);
        }
        Object objCreate = INSTANCE.a(environment.getBaseAccessHubUrl(), config).create(service);
        Intrinsics.checkExpressionValueIsNotNull(objCreate, "getRetrofitInstance(envi…, config).create(service)");
        return objCreate;
    }

    @Nullable
    public final CertificatePinner buildCertificatePinner$AccessHub_prodRelease(@NotNull IAlConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (config.getPinSet().isEmpty()) {
            return null;
        }
        CertificatePinner.Builder builder = new CertificatePinner.Builder();
        for (Map.Entry<String, String> entry : config.getPinSet().entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }

    public final void clearOriginKeys$AccessHub_prodRelease(@NotNull IAlConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        config.getStorage().remove("originKey0");
        config.getStorage().remove("originKey1");
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

    public final boolean getPublicKeysFromRawResponse$AccessHub_prodRelease(@Nullable byte[] responseBody, @NotNull IAlConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
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

    @NotNull
    public final Object getServiceInstance$AccessHub_prodRelease(@NotNull String baseUrl, @NotNull Class<?> service, @NotNull IAlConfig config) throws SecurityException {
        Intrinsics.checkParameterIsNotNull(baseUrl, "baseUrl");
        Intrinsics.checkParameterIsNotNull(service, "service");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Object objCreate = a(baseUrl, config).create(service);
        Intrinsics.checkExpressionValueIsNotNull(objCreate, "getRetrofitInstance(base…, config).create(service)");
        return objCreate;
    }

    public final boolean verifySignatures$AccessHub_prodRelease(@NotNull AlEcc eccTool, @NotNull ECPublicKey pub0, @NotNull byte[] responseBody, @NotNull byte[] sig0, @NotNull ECPublicKey pub1, @NotNull byte[] sig1) {
        Intrinsics.checkParameterIsNotNull(eccTool, "eccTool");
        Intrinsics.checkParameterIsNotNull(pub0, "pub0");
        Intrinsics.checkParameterIsNotNull(responseBody, "responseBody");
        Intrinsics.checkParameterIsNotNull(sig0, "sig0");
        Intrinsics.checkParameterIsNotNull(pub1, "pub1");
        Intrinsics.checkParameterIsNotNull(sig1, "sig1");
        return eccTool.verify(pub0, responseBody, sig0) || eccTool.verify(pub1, responseBody, sig1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Response response, IAlConfig config) throws AlMAHException, IOException {
        Response responseNetworkResponse = response.networkResponse();
        String strHeader = responseNetworkResponse != null ? responseNetworkResponse.header("alle-signatures") : null;
        byte[] bArrBytes = response.peekBody(Long.MAX_VALUE).bytes();
        getPublicKeysFromRawResponse$AccessHub_prodRelease(bArrBytes, config);
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
                if (verifySignatures$AccessHub_prodRelease(alEcc, eCPublicKeyEncodeEccPublicKey, bArrBytes, bArrDecode, alEcc.encodeEccPublicKey(bArrDecode4), bArrDecode2)) {
                    return;
                }
                clearOriginKeys$AccessHub_prodRelease(config);
                throw new AlMAHException("Response header signature validation failed");
            } catch (Exception e) {
                clearOriginKeys$AccessHub_prodRelease(config);
                throw new AlMAHException("Setup for header signature validation failing", e);
            }
        }
        throw new AlMAHException("Response body or header null");
    }
}
