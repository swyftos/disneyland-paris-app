package com.urbanairship.automation.audiencecheck;

import com.urbanairship.cache.AirshipCache;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remoteconfig.AdditionalAudienceCheckConfig;
import com.urbanairship.remoteconfig.IAAConfig;
import com.urbanairship.util.SerialQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J6\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckerResolver;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "cache", "Lcom/urbanairship/cache/AirshipCache;", "apiClient", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/cache/AirshipCache;Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient;)V", "audienceCheckConfig", "Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "getAudienceCheckConfig", "()Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "queue", "Lcom/urbanairship/util/SerialQueue;", "cacheKey", "", "url", "context", "Lcom/urbanairship/json/JsonValue;", "contactId", "channelId", "doResolve", "Lkotlin/Result;", "", "deviceInfoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "doResolve-BWLJW6A", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "overrides", "Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", "resolve-0E7RQCE", "(Lcom/urbanairship/audience/DeviceInfoProvider;Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: resolve-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2798resolve0E7RQCE(@org.jetbrains.annotations.NotNull com.urbanairship.audience.DeviceInfoProvider r12, @org.jetbrains.annotations.Nullable com.urbanairship.automation.AdditionalAudienceCheckOverrides r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.Boolean>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$1
            if (r0 == 0) goto L13
            r0 = r14
            com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$1 r0 = (com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$1 r0 = new com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lb2
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r14)
            com.urbanairship.remoteconfig.AdditionalAudienceCheckConfig r8 = r11.getAudienceCheckConfig()
            if (r8 != 0) goto L46
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.Object r11 = kotlin.Result.m2968constructorimpl(r11)
            return r11
        L46:
            boolean r14 = r8.isEnabled()
            if (r14 != 0) goto L57
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.Object r11 = kotlin.Result.m2968constructorimpl(r11)
            return r11
        L57:
            if (r13 == 0) goto L62
            java.lang.String r14 = r13.getUrl()
            if (r14 != 0) goto L60
            goto L62
        L60:
            r6 = r14
            goto L7a
        L62:
            java.lang.String r14 = r8.getUrl()
            if (r14 != 0) goto L60
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Missing additional audience check url"
            r11.<init>(r12)
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m2968constructorimpl(r11)
            return r11
        L7a:
            if (r13 == 0) goto L89
            java.lang.Boolean r14 = r13.getBypass()
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r2)
            goto L8a
        L89:
            r14 = 0
        L8a:
            if (r14 == 0) goto L9d
            com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2 r11 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2
                static {
                    /*
                        com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2 r0 = new com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2) com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2.INSTANCE com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Additional audience check is bypassed "
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$2.invoke():java.lang.String");
                }
            }
            r12 = 0
            com.urbanairship.UALog.v$default(r12, r11, r3, r12)
            kotlin.Result$Companion r11 = kotlin.Result.INSTANCE
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.Object r11 = kotlin.Result.m2968constructorimpl(r11)
            return r11
        L9d:
            com.urbanairship.util.SerialQueue r14 = r11.queue
            com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$3 r2 = new com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver$resolve$3
            r10 = 0
            r4 = r2
            r5 = r11
            r7 = r13
            r9 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.label = r3
            java.lang.Object r14 = r14.run(r2, r0)
            if (r14 != r1) goto Lb2
            return r1
        Lb2:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r11 = r14.getValue()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver.m2798resolve0E7RQCE(com.urbanairship.audience.DeviceInfoProvider, com.urbanairship.automation.AdditionalAudienceCheckOverrides, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0117 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* renamed from: doResolve-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2797doResolveBWLJW6A(java.lang.String r20, com.urbanairship.json.JsonValue r21, com.urbanairship.audience.DeviceInfoProvider r22, kotlin.coroutines.Continuation r23) throws java.security.InvalidParameterException {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver.m2797doResolveBWLJW6A(java.lang.String, com.urbanairship.json.JsonValue, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String cacheKey(String url, JsonValue context, String contactId, String channelId) {
        String string = context.toString(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{url, string, contactId, channelId}), ":", null, null, 0, null, null, 62, null);
    }
}
