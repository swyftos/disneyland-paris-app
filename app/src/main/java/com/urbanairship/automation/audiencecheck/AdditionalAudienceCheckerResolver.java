package com.urbanairship.automation.audiencecheck;

import com.urbanairship.UALog;
import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.automation.AdditionalAudienceCheckOverrides;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.contacts.StableContactInfo;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestResult;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remoteconfig.AdditionalAudienceCheckConfig;
import com.urbanairship.remoteconfig.IAAConfig;
import com.urbanairship.util.SerialQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J6\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, m1836d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckerResolver;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "cache", "Lcom/urbanairship/cache/AirshipCache;", "apiClient", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/cache/AirshipCache;Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient;)V", "audienceCheckConfig", "Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "getAudienceCheckConfig", "()Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "queue", "Lcom/urbanairship/util/SerialQueue;", "cacheKey", "", "url", "context", "Lcom/urbanairship/json/JsonValue;", "contactId", "channelId", "doResolve", "Lkotlin/Result;", "", "deviceInfoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "doResolve-BWLJW6A", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "overrides", "Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", "resolve-0E7RQCE", "(Lcom/urbanairship/audience/DeviceInfoProvider;Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class AdditionalAudienceCheckerResolver {
    private final AdditionalAudienceCheckApiClient apiClient;
    private final AirshipCache cache;
    private final AirshipRuntimeConfig config;
    private final SerialQueue queue;

    public AdditionalAudienceCheckerResolver(@NotNull AirshipRuntimeConfig config, @NotNull AirshipCache cache, @NotNull AdditionalAudienceCheckApiClient apiClient) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        this.config = config;
        this.cache = cache;
        this.apiClient = apiClient;
        this.queue = new SerialQueue();
    }

    public /* synthetic */ AdditionalAudienceCheckerResolver(AirshipRuntimeConfig airshipRuntimeConfig, AirshipCache airshipCache, AdditionalAudienceCheckApiClient additionalAudienceCheckApiClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, airshipCache, (i & 4) != 0 ? new AdditionalAudienceCheckApiClient(airshipRuntimeConfig, null, 2, null) : additionalAudienceCheckApiClient);
    }

    private final AdditionalAudienceCheckConfig getAudienceCheckConfig() {
        IAAConfig iaaConfig = this.config.getRemoteConfig().getIaaConfig();
        if (iaaConfig != null) {
            return iaaConfig.getAdditionalAudienceCheck();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: resolve-0E7RQCE, reason: not valid java name */
    public final Object m5040resolve0E7RQCE(@NotNull DeviceInfoProvider deviceInfoProvider, @Nullable AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides, @NotNull Continuation<? super Result<Boolean>> continuation) {
        AdditionalAudienceCheckerResolver$resolve$1 additionalAudienceCheckerResolver$resolve$1;
        String url;
        if (continuation instanceof AdditionalAudienceCheckerResolver$resolve$1) {
            additionalAudienceCheckerResolver$resolve$1 = (AdditionalAudienceCheckerResolver$resolve$1) continuation;
            int i = additionalAudienceCheckerResolver$resolve$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                additionalAudienceCheckerResolver$resolve$1.label = i - Integer.MIN_VALUE;
            } else {
                additionalAudienceCheckerResolver$resolve$1 = new AdditionalAudienceCheckerResolver$resolve$1(this, continuation);
            }
        } else {
            additionalAudienceCheckerResolver$resolve$1 = new AdditionalAudienceCheckerResolver$resolve$1(this, continuation);
        }
        Object objRun = additionalAudienceCheckerResolver$resolve$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = additionalAudienceCheckerResolver$resolve$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRun);
            AdditionalAudienceCheckConfig audienceCheckConfig = getAudienceCheckConfig();
            if (audienceCheckConfig == null) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m5277constructorimpl(Boxing.boxBoolean(true));
            }
            if (!audienceCheckConfig.isEnabled()) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m5277constructorimpl(Boxing.boxBoolean(true));
            }
            if ((additionalAudienceCheckOverrides == null || (url = additionalAudienceCheckOverrides.getUrl()) == null) && (url = audienceCheckConfig.getUrl()) == null) {
                Result.Companion companion3 = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new IllegalArgumentException("Missing additional audience check url")));
            }
            String str = url;
            if (additionalAudienceCheckOverrides != null ? Intrinsics.areEqual(additionalAudienceCheckOverrides.getBypass(), Boxing.boxBoolean(true)) : false) {
                UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Additional audience check is bypassed ";
                    }
                }, 1, null);
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m5277constructorimpl(Boxing.boxBoolean(true));
            }
            SerialQueue serialQueue = this.queue;
            AdditionalAudienceCheckerResolver$resolve$3 additionalAudienceCheckerResolver$resolve$3 = new AdditionalAudienceCheckerResolver$resolve$3(this, str, additionalAudienceCheckOverrides, audienceCheckConfig, deviceInfoProvider, null);
            additionalAudienceCheckerResolver$resolve$1.label = 1;
            objRun = serialQueue.run(additionalAudienceCheckerResolver$resolve$3, additionalAudienceCheckerResolver$resolve$1);
            if (objRun == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRun);
        }
        return ((Result) objRun).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:38:0x0117 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0118  */
    /* JADX WARN: Code duplicated, block: B:42:0x0122  */
    /* JADX WARN: Code duplicated, block: B:44:0x0131  */
    /* JADX WARN: Code duplicated, block: B:46:0x0155 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0164 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x018f  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX INFO: renamed from: doResolve-BWLJW6A, reason: not valid java name */
    public final Object m5039doResolveBWLJW6A(String str, JsonValue jsonValue, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        AdditionalAudienceCheckerResolver$doResolve$1 additionalAudienceCheckerResolver$doResolve$1;
        String str2;
        Object channelId;
        DeviceInfoProvider deviceInfoProvider2;
        JsonValue jsonValue2;
        AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver;
        String str3;
        String str4;
        StableContactInfo stableContactInfo;
        JsonValue NULL;
        String strCacheKey;
        Object cached;
        String str5;
        JsonValue jsonValue3;
        String str6;
        AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver2;
        String str7;
        AdditionalAudienceCheckApiClient.Result result;
        RequestResult requestResult;
        AdditionalAudienceCheckApiClient.Result result2;
        AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver3 = this;
        if (continuation instanceof AdditionalAudienceCheckerResolver$doResolve$1) {
            additionalAudienceCheckerResolver$doResolve$1 = (AdditionalAudienceCheckerResolver$doResolve$1) continuation;
            int i = additionalAudienceCheckerResolver$doResolve$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                additionalAudienceCheckerResolver$doResolve$1.label = i - Integer.MIN_VALUE;
            } else {
                additionalAudienceCheckerResolver$doResolve$1 = new AdditionalAudienceCheckerResolver$doResolve$1(additionalAudienceCheckerResolver3, continuation);
            }
        } else {
            additionalAudienceCheckerResolver$doResolve$1 = new AdditionalAudienceCheckerResolver$doResolve$1(additionalAudienceCheckerResolver3, continuation);
        }
        AdditionalAudienceCheckerResolver$doResolve$1 additionalAudienceCheckerResolver$doResolve$2 = additionalAudienceCheckerResolver$doResolve$1;
        Object objResolve = additionalAudienceCheckerResolver$doResolve$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = additionalAudienceCheckerResolver$doResolve$2.label;
        if (i2 != 0) {
            if (i2 == 1) {
                DeviceInfoProvider deviceInfoProvider3 = (DeviceInfoProvider) additionalAudienceCheckerResolver$doResolve$2.L$3;
                jsonValue2 = (JsonValue) additionalAudienceCheckerResolver$doResolve$2.L$2;
                String str8 = (String) additionalAudienceCheckerResolver$doResolve$2.L$1;
                AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver4 = (AdditionalAudienceCheckerResolver) additionalAudienceCheckerResolver$doResolve$2.L$0;
                ResultKt.throwOnFailure(objResolve);
                deviceInfoProvider2 = deviceInfoProvider3;
                additionalAudienceCheckerResolver3 = additionalAudienceCheckerResolver4;
                channelId = objResolve;
                str2 = str8;
            } else {
                if (i2 == 2) {
                    String str9 = (String) additionalAudienceCheckerResolver$doResolve$2.L$3;
                    jsonValue2 = (JsonValue) additionalAudienceCheckerResolver$doResolve$2.L$2;
                    String str10 = (String) additionalAudienceCheckerResolver$doResolve$2.L$1;
                    additionalAudienceCheckerResolver = (AdditionalAudienceCheckerResolver) additionalAudienceCheckerResolver$doResolve$2.L$0;
                    ResultKt.throwOnFailure(objResolve);
                    str4 = str9;
                    str3 = str10;
                    stableContactInfo = (StableContactInfo) objResolve;
                    if (jsonValue2 == null) {
                        NULL = JsonValue.NULL;
                        Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
                    } else {
                        NULL = jsonValue2;
                    }
                    strCacheKey = additionalAudienceCheckerResolver.cacheKey(str3, NULL, stableContactInfo.getContactId(), str4);
                    AirshipCache airshipCache = additionalAudienceCheckerResolver.cache;
                    AdditionalAudienceCheckerResolver$doResolve$2 additionalAudienceCheckerResolver$doResolve$3 = new AdditionalAudienceCheckerResolver$doResolve$2(AdditionalAudienceCheckApiClient.Result.INSTANCE);
                    additionalAudienceCheckerResolver$doResolve$2.L$0 = additionalAudienceCheckerResolver;
                    additionalAudienceCheckerResolver$doResolve$2.L$1 = str3;
                    additionalAudienceCheckerResolver$doResolve$2.L$2 = jsonValue2;
                    additionalAudienceCheckerResolver$doResolve$2.L$3 = str4;
                    additionalAudienceCheckerResolver$doResolve$2.L$4 = stableContactInfo;
                    additionalAudienceCheckerResolver$doResolve$2.L$5 = strCacheKey;
                    additionalAudienceCheckerResolver$doResolve$2.label = 3;
                    cached = airshipCache.getCached(strCacheKey, additionalAudienceCheckerResolver$doResolve$3, additionalAudienceCheckerResolver$doResolve$2);
                    if (cached == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str3;
                    jsonValue3 = jsonValue2;
                    str6 = str4;
                    additionalAudienceCheckerResolver2 = additionalAudienceCheckerResolver;
                    str7 = strCacheKey;
                    result = (AdditionalAudienceCheckApiClient.Result) cached;
                    if (result != null) {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m5277constructorimpl(Boxing.boxBoolean(result.isMatched()));
                    }
                    AdditionalAudienceCheckApiClient additionalAudienceCheckApiClient = additionalAudienceCheckerResolver2.apiClient;
                    AdditionalAudienceCheckApiClient.Info info = new AdditionalAudienceCheckApiClient.Info(str5, str6, stableContactInfo.getContactId(), stableContactInfo.getNamedUserId(), jsonValue3);
                    additionalAudienceCheckerResolver$doResolve$2.L$0 = additionalAudienceCheckerResolver2;
                    additionalAudienceCheckerResolver$doResolve$2.L$1 = str7;
                    additionalAudienceCheckerResolver$doResolve$2.L$2 = null;
                    additionalAudienceCheckerResolver$doResolve$2.L$3 = null;
                    additionalAudienceCheckerResolver$doResolve$2.L$4 = null;
                    additionalAudienceCheckerResolver$doResolve$2.L$5 = null;
                    additionalAudienceCheckerResolver$doResolve$2.label = 4;
                    objResolve = additionalAudienceCheckApiClient.resolve(info, additionalAudienceCheckerResolver$doResolve$2);
                    if (objResolve == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str11 = str7;
                    requestResult = (RequestResult) objResolve;
                    result2 = (AdditionalAudienceCheckApiClient.Result) requestResult.getValue();
                    if (requestResult.isSuccessful()) {
                    }
                    if (requestResult.isServerError()) {
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m5277constructorimpl(ResultKt.createFailure(new RequestException("Server error")));
                    }
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m5277constructorimpl(Boxing.boxBoolean(false));
                }
                if (i2 == 3) {
                    str7 = (String) additionalAudienceCheckerResolver$doResolve$2.L$5;
                    StableContactInfo stableContactInfo2 = (StableContactInfo) additionalAudienceCheckerResolver$doResolve$2.L$4;
                    String str12 = (String) additionalAudienceCheckerResolver$doResolve$2.L$3;
                    JsonValue jsonValue4 = (JsonValue) additionalAudienceCheckerResolver$doResolve$2.L$2;
                    String str13 = (String) additionalAudienceCheckerResolver$doResolve$2.L$1;
                    AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver5 = (AdditionalAudienceCheckerResolver) additionalAudienceCheckerResolver$doResolve$2.L$0;
                    ResultKt.throwOnFailure(objResolve);
                    str6 = str12;
                    jsonValue3 = jsonValue4;
                    str5 = str13;
                    cached = objResolve;
                    stableContactInfo = stableContactInfo2;
                    additionalAudienceCheckerResolver2 = additionalAudienceCheckerResolver5;
                    result = (AdditionalAudienceCheckApiClient.Result) cached;
                    if (result != null) {
                        Result.Companion companion4 = Result.INSTANCE;
                        return Result.m5277constructorimpl(Boxing.boxBoolean(result.isMatched()));
                    }
                    AdditionalAudienceCheckApiClient additionalAudienceCheckApiClient2 = additionalAudienceCheckerResolver2.apiClient;
                    AdditionalAudienceCheckApiClient.Info info2 = new AdditionalAudienceCheckApiClient.Info(str5, str6, stableContactInfo.getContactId(), stableContactInfo.getNamedUserId(), jsonValue3);
                    additionalAudienceCheckerResolver$doResolve$2.L$0 = additionalAudienceCheckerResolver2;
                    additionalAudienceCheckerResolver$doResolve$2.L$1 = str7;
                    additionalAudienceCheckerResolver$doResolve$2.L$2 = null;
                    additionalAudienceCheckerResolver$doResolve$2.L$3 = null;
                    additionalAudienceCheckerResolver$doResolve$2.L$4 = null;
                    additionalAudienceCheckerResolver$doResolve$2.L$5 = null;
                    additionalAudienceCheckerResolver$doResolve$2.label = 4;
                    objResolve = additionalAudienceCheckApiClient2.resolve(info2, additionalAudienceCheckerResolver$doResolve$2);
                    if (objResolve == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str14 = str7;
                    requestResult = (RequestResult) objResolve;
                    result2 = (AdditionalAudienceCheckApiClient.Result) requestResult.getValue();
                    if (requestResult.isSuccessful()) {
                    }
                    if (requestResult.isServerError()) {
                        Result.Companion companion5 = Result.INSTANCE;
                        return Result.m5277constructorimpl(ResultKt.createFailure(new RequestException("Server error")));
                    }
                    Result.Companion companion6 = Result.INSTANCE;
                    return Result.m5277constructorimpl(Boxing.boxBoolean(false));
                }
                if (i2 == 4) {
                    str7 = (String) additionalAudienceCheckerResolver$doResolve$2.L$1;
                    additionalAudienceCheckerResolver2 = (AdditionalAudienceCheckerResolver) additionalAudienceCheckerResolver$doResolve$2.L$0;
                    ResultKt.throwOnFailure(objResolve);
                    String str15 = str7;
                    requestResult = (RequestResult) objResolve;
                    result2 = (AdditionalAudienceCheckApiClient.Result) requestResult.getValue();
                    if (requestResult.isSuccessful() || result2 == null) {
                        if (requestResult.isServerError()) {
                            Result.Companion companion7 = Result.INSTANCE;
                            return Result.m5277constructorimpl(ResultKt.createFailure(new RequestException("Server error")));
                        }
                        Result.Companion companion8 = Result.INSTANCE;
                        return Result.m5277constructorimpl(Boxing.boxBoolean(false));
                    }
                    AirshipCache airshipCache2 = additionalAudienceCheckerResolver2.cache;
                    long jM5037getCacheTtlUwyO8pc = result2.m5037getCacheTtlUwyO8pc();
                    additionalAudienceCheckerResolver$doResolve$2.L$0 = result2;
                    additionalAudienceCheckerResolver$doResolve$2.L$1 = null;
                    additionalAudienceCheckerResolver$doResolve$2.label = 5;
                    if (airshipCache2.m5067storeexY8QGI(result2, str15, jM5037getCacheTtlUwyO8pc, additionalAudienceCheckerResolver$doResolve$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    result2 = (AdditionalAudienceCheckApiClient.Result) additionalAudienceCheckerResolver$doResolve$2.L$0;
                    ResultKt.throwOnFailure(objResolve);
                }
            }
            Result.Companion companion9 = Result.INSTANCE;
            return Result.m5277constructorimpl(Boxing.boxBoolean(result2.isMatched()));
        }
        ResultKt.throwOnFailure(objResolve);
        additionalAudienceCheckerResolver$doResolve$2.L$0 = additionalAudienceCheckerResolver3;
        str2 = str;
        additionalAudienceCheckerResolver$doResolve$2.L$1 = str2;
        additionalAudienceCheckerResolver$doResolve$2.L$2 = jsonValue;
        additionalAudienceCheckerResolver$doResolve$2.L$3 = deviceInfoProvider;
        additionalAudienceCheckerResolver$doResolve$2.label = 1;
        channelId = deviceInfoProvider.getChannelId(additionalAudienceCheckerResolver$doResolve$2);
        if (channelId == coroutine_suspended) {
            return coroutine_suspended;
        }
        deviceInfoProvider2 = deviceInfoProvider;
        jsonValue2 = jsonValue;
        String str16 = (String) channelId;
        additionalAudienceCheckerResolver$doResolve$2.L$0 = additionalAudienceCheckerResolver3;
        additionalAudienceCheckerResolver$doResolve$2.L$1 = str2;
        additionalAudienceCheckerResolver$doResolve$2.L$2 = jsonValue2;
        additionalAudienceCheckerResolver$doResolve$2.L$3 = str16;
        additionalAudienceCheckerResolver$doResolve$2.label = 2;
        Object stableContactInfo3 = deviceInfoProvider2.getStableContactInfo(additionalAudienceCheckerResolver$doResolve$2);
        if (stableContactInfo3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        additionalAudienceCheckerResolver = additionalAudienceCheckerResolver3;
        str3 = str2;
        objResolve = stableContactInfo3;
        str4 = str16;
        stableContactInfo = (StableContactInfo) objResolve;
        if (jsonValue2 == null) {
            NULL = JsonValue.NULL;
            Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
        } else {
            NULL = jsonValue2;
        }
        strCacheKey = additionalAudienceCheckerResolver.cacheKey(str3, NULL, stableContactInfo.getContactId(), str4);
        AirshipCache airshipCache3 = additionalAudienceCheckerResolver.cache;
        AdditionalAudienceCheckerResolver$doResolve$2 additionalAudienceCheckerResolver$doResolve$4 = new AdditionalAudienceCheckerResolver$doResolve$2(AdditionalAudienceCheckApiClient.Result.INSTANCE);
        additionalAudienceCheckerResolver$doResolve$2.L$0 = additionalAudienceCheckerResolver;
        additionalAudienceCheckerResolver$doResolve$2.L$1 = str3;
        additionalAudienceCheckerResolver$doResolve$2.L$2 = jsonValue2;
        additionalAudienceCheckerResolver$doResolve$2.L$3 = str4;
        additionalAudienceCheckerResolver$doResolve$2.L$4 = stableContactInfo;
        additionalAudienceCheckerResolver$doResolve$2.L$5 = strCacheKey;
        additionalAudienceCheckerResolver$doResolve$2.label = 3;
        cached = airshipCache3.getCached(strCacheKey, additionalAudienceCheckerResolver$doResolve$4, additionalAudienceCheckerResolver$doResolve$2);
        if (cached == coroutine_suspended) {
            return coroutine_suspended;
        }
        str5 = str3;
        jsonValue3 = jsonValue2;
        str6 = str4;
        additionalAudienceCheckerResolver2 = additionalAudienceCheckerResolver;
        str7 = strCacheKey;
        result = (AdditionalAudienceCheckApiClient.Result) cached;
        if (result != null) {
            Result.Companion companion10 = Result.INSTANCE;
            return Result.m5277constructorimpl(Boxing.boxBoolean(result.isMatched()));
        }
        AdditionalAudienceCheckApiClient additionalAudienceCheckApiClient3 = additionalAudienceCheckerResolver2.apiClient;
        AdditionalAudienceCheckApiClient.Info info3 = new AdditionalAudienceCheckApiClient.Info(str5, str6, stableContactInfo.getContactId(), stableContactInfo.getNamedUserId(), jsonValue3);
        additionalAudienceCheckerResolver$doResolve$2.L$0 = additionalAudienceCheckerResolver2;
        additionalAudienceCheckerResolver$doResolve$2.L$1 = str7;
        additionalAudienceCheckerResolver$doResolve$2.L$2 = null;
        additionalAudienceCheckerResolver$doResolve$2.L$3 = null;
        additionalAudienceCheckerResolver$doResolve$2.L$4 = null;
        additionalAudienceCheckerResolver$doResolve$2.L$5 = null;
        additionalAudienceCheckerResolver$doResolve$2.label = 4;
        objResolve = additionalAudienceCheckApiClient3.resolve(info3, additionalAudienceCheckerResolver$doResolve$2);
        if (objResolve == coroutine_suspended) {
            return coroutine_suspended;
        }
        String str17 = str7;
        requestResult = (RequestResult) objResolve;
        result2 = (AdditionalAudienceCheckApiClient.Result) requestResult.getValue();
        if (requestResult.isSuccessful()) {
        }
        if (requestResult.isServerError()) {
            Result.Companion companion11 = Result.INSTANCE;
            return Result.m5277constructorimpl(ResultKt.createFailure(new RequestException("Server error")));
        }
        Result.Companion companion12 = Result.INSTANCE;
        return Result.m5277constructorimpl(Boxing.boxBoolean(false));
    }

    private final String cacheKey(String url, JsonValue context, String contactId, String channelId) {
        String string = context.toString(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{url, string, contactId, channelId}), ":", null, null, 0, null, null, 62, null);
    }
}
