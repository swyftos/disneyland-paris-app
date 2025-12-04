package com.urbanairship.channel;

import android.content.Context;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0013J\u0010\u00100\u001a\u0004\u0018\u00010*H\u0082@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00101J\u000e\u00104\u001a\u000205H\u0082@¢\u0006\u0002\u00101J\u001a\u00106\u001a\u0004\u0018\u00010*2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u00107\u001a\u00020*H\u0002J.\u00108\u001a\u0002032\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u00107\u001a\u00020*2\b\b\u0002\u0010<\u001a\u000205H\u0082@¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u0002032\u0006\u00107\u001a\u00020*H\u0082@¢\u0006\u0002\u0010?J\"\u0010@\u001a\u0002052\u0006\u00107\u001a\u00020*2\b\u0010A\u001a\u0004\u0018\u00010!2\u0006\u0010B\u001a\u00020\u0016H\u0002J \u0010C\u001a\u0004\u0018\u0001032\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u00107\u001a\u00020*H\u0082@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u0002032\u0006\u0010\u0018\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u000203H\u0080@¢\u0006\u0004\bH\u00101R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0017\u001a\u0004\u0018\u00010!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R4\u0010'\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/urbanairship/channel/ChannelRegistrar;", "", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;)V", "channelApiClient", "Lcom/urbanairship/channel/ChannelApiClient;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "channelCreateOption", "Lcom/urbanairship/channel/AirshipChannelCreateOption;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/channel/ChannelApiClient;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/channel/AirshipChannelCreateOption;Lcom/urbanairship/util/Clock;Lcom/urbanairship/PrivacyManager;)V", "_channelIdFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "value", "channelId", "getChannelId$urbanairship_core_release", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "channelIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getChannelIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Lcom/urbanairship/channel/RegistrationInfo;", "lastChannelRegistrationInfo", "getLastChannelRegistrationInfo", "()Lcom/urbanairship/channel/RegistrationInfo;", "setLastChannelRegistrationInfo", "(Lcom/urbanairship/channel/RegistrationInfo;)V", "payloadBuilder", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/urbanairship/channel/ChannelRegistrationPayload;", "getPayloadBuilder", "()Lkotlin/jvm/functions/Function1;", "setPayloadBuilder", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "buildCraPayload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createChannel", "Lcom/urbanairship/channel/RegistrationResult;", "isUpToDate", "", "minimizeUpdatePayload", "payload", "onNewChannelIdCreated", "response", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/channel/Channel;", "rememberPayload", "(Lcom/urbanairship/http/RequestResult;Lcom/urbanairship/channel/ChannelRegistrationPayload;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "regularCreateChannel", "(Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldUpdate", "lastRegistrationInfo", "location", "tryRestoreChannel", "(Ljava/lang/String;Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChannel", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRegistration", "updateRegistration$urbanairship_core_release", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelRegistrar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelRegistrar.kt\ncom/urbanairship/channel/ChannelRegistrar\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,337:1\n1#2:338\n18#3,8:339\n*S KotlinDebug\n*F\n+ 1 ChannelRegistrar.kt\ncom/urbanairship/channel/ChannelRegistrar\n*L\n162#1:339,8\n*E\n"})
/* loaded from: classes5.dex */
public final class ChannelRegistrar {
    private static final Companion Companion = new Companion(null);
    private final MutableStateFlow _channelIdFlow;
    private final ActivityMonitor activityMonitor;
    private final ChannelApiClient channelApiClient;
    private final AirshipChannelCreateOption channelCreateOption;
    private final StateFlow channelIdFlow;
    private final Clock clock;
    private final PreferenceDataStore dataStore;
    private Function1 payloadBuilder;
    private final PrivacyManager privacyManager;

    /* renamed from: com.urbanairship.channel.ChannelRegistrar$createChannel$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.createChannel(this);
        }
    }

    /* renamed from: com.urbanairship.channel.ChannelRegistrar$isUpToDate$1, reason: invalid class name and case insensitive filesystem */
    static final class C10721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10721(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.isUpToDate(this);
        }
    }

    /* renamed from: com.urbanairship.channel.ChannelRegistrar$onNewChannelIdCreated$1, reason: invalid class name and case insensitive filesystem */
    static final class C10731 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10731(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.onNewChannelIdCreated(null, null, false, this);
        }
    }

    /* renamed from: com.urbanairship.channel.ChannelRegistrar$regularCreateChannel$1, reason: invalid class name and case insensitive filesystem */
    static final class C10741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10741(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.regularCreateChannel(null, this);
        }
    }

    /* renamed from: com.urbanairship.channel.ChannelRegistrar$tryRestoreChannel$1, reason: invalid class name and case insensitive filesystem */
    static final class C10761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10761(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.tryRestoreChannel(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.channel.ChannelRegistrar$updateChannel$1, reason: invalid class name and case insensitive filesystem */
    static final class C10771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10771(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.updateChannel(null, this);
        }
    }

    public ChannelRegistrar(@NotNull PreferenceDataStore dataStore, @NotNull ChannelApiClient channelApiClient, @NotNull ActivityMonitor activityMonitor, @Nullable AirshipChannelCreateOption airshipChannelCreateOption, @NotNull Clock clock, @NotNull PrivacyManager privacyManager) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(channelApiClient, "channelApiClient");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        this.dataStore = dataStore;
        this.channelApiClient = channelApiClient;
        this.activityMonitor = activityMonitor;
        this.channelCreateOption = airshipChannelCreateOption;
        this.clock = clock;
        this.privacyManager = privacyManager;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(getChannelId$urbanairship_core_release());
        this._channelIdFlow = MutableStateFlow;
        this.channelIdFlow = FlowKt.asStateFlow(MutableStateFlow);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChannelRegistrar(PreferenceDataStore preferenceDataStore, ChannelApiClient channelApiClient, ActivityMonitor activityMonitor, AirshipChannelCreateOption airshipChannelCreateOption, Clock DEFAULT_CLOCK, PrivacyManager privacyManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        AirshipChannelCreateOption airshipChannelCreateOption2 = (i & 8) != 0 ? null : airshipChannelCreateOption;
        if ((i & 16) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(preferenceDataStore, channelApiClient, activityMonitor, airshipChannelCreateOption2, DEFAULT_CLOCK, privacyManager);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelRegistrar(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager) {
        this(dataStore, new ChannelApiClient(runtimeConfig, null, 2, 0 == true ? 1 : 0), GlobalActivityMonitor.INSTANCE.shared(context), runtimeConfig.getConfigOptions().channelCreateOption, null, privacyManager, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
    }

    @Nullable
    public final Function1<Continuation<? super ChannelRegistrationPayload>, Object> getPayloadBuilder() {
        return this.payloadBuilder;
    }

    public final void setPayloadBuilder(@Nullable Function1<? super Continuation<? super ChannelRegistrationPayload>, ? extends Object> function1) {
        this.payloadBuilder = function1;
    }

    @NotNull
    public final StateFlow<String> getChannelIdFlow() {
        return this.channelIdFlow;
    }

    @Nullable
    public final String getChannelId$urbanairship_core_release() {
        return this.dataStore.getString("com.urbanairship.push.CHANNEL_ID", null);
    }

    private final void setChannelId(String str) {
        this.dataStore.put("com.urbanairship.push.CHANNEL_ID", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[PHI: r6
  0x0062: PHI (r6v8 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:26:0x005f, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateRegistration$urbanairship_core_release(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.channel.RegistrationResult> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.urbanairship.channel.ChannelRegistrar$updateRegistration$1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.channel.ChannelRegistrar$updateRegistration$1 r0 = (com.urbanairship.channel.ChannelRegistrar$updateRegistration$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.ChannelRegistrar$updateRegistration$1 r0 = new com.urbanairship.channel.ChannelRegistrar$updateRegistration$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L62
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$0
            com.urbanairship.channel.ChannelRegistrar r5 = (com.urbanairship.channel.ChannelRegistrar) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L50
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.String r6 = r5.getChannelId$urbanairship_core_release()
            if (r6 == 0) goto L56
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.updateChannel(r6, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            com.urbanairship.channel.RegistrationResult r6 = (com.urbanairship.channel.RegistrationResult) r6
            if (r6 != 0) goto L55
            goto L56
        L55:
            return r6
        L56:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r5.createChannel(r0)
            if (r6 != r1) goto L62
            return r1
        L62:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelRegistrar.updateRegistration$urbanairship_core_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object buildCraPayload(Continuation continuation) {
        Function1 function1 = this.payloadBuilder;
        if (function1 == null) {
            return null;
        }
        Object objInvoke = function1.invoke(continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : (ChannelRegistrationPayload) objInvoke;
    }

    private final boolean shouldUpdate(ChannelRegistrationPayload payload, RegistrationInfo lastRegistrationInfo, String location) {
        if (lastRegistrationInfo == null || !Intrinsics.areEqual(lastRegistrationInfo.getLocation(), location)) {
            return true;
        }
        if (this.privacyManager.isAnyFeatureEnabled()) {
            long jCurrentTimeMillis = this.clock.currentTimeMillis() - lastRegistrationInfo.getDateMillis();
            if (jCurrentTimeMillis < 0) {
                return true;
            }
            if (this.activityMonitor.getIsAppForegrounded() && jCurrentTimeMillis > 86400000) {
                return true;
            }
        }
        return !payload.equals(lastRegistrationInfo.getPayload(), false);
    }

    private final ChannelRegistrationPayload minimizeUpdatePayload(String channelId, ChannelRegistrationPayload payload) {
        Long lastFullUploadMillis;
        RegistrationInfo lastChannelRegistrationInfo = getLastChannelRegistrationInfo();
        if (lastChannelRegistrationInfo == null) {
            return payload;
        }
        String strValueOf = String.valueOf(this.channelApiClient.createLocation$urbanairship_core_release(channelId));
        if (!Intrinsics.areEqual(strValueOf, lastChannelRegistrationInfo.getLocation()) || (lastFullUploadMillis = lastChannelRegistrationInfo.getLastFullUploadMillis()) == null || this.clock.currentTimeMillis() - lastFullUploadMillis.longValue() > 86400000) {
            return payload;
        }
        if (shouldUpdate(payload, lastChannelRegistrationInfo, strValueOf)) {
            return payload.minimizedPayload(lastChannelRegistrationInfo.getPayload());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object isUpToDate(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.urbanairship.channel.ChannelRegistrar.C10721
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.channel.ChannelRegistrar$isUpToDate$1 r0 = (com.urbanairship.channel.ChannelRegistrar.C10721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.ChannelRegistrar$isUpToDate$1 r0 = new com.urbanairship.channel.ChannelRegistrar$isUpToDate$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.L$0
            com.urbanairship.channel.ChannelRegistrar r0 = (com.urbanairship.channel.ChannelRegistrar) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r5 = r7
            r7 = r6
            r6 = r0
            r0 = r5
            goto L55
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.getChannelId$urbanairship_core_release()
            if (r7 != 0) goto L48
            goto L73
        L48:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r0 = r6.buildCraPayload(r0)
            if (r0 != r1) goto L55
            return r1
        L55:
            com.urbanairship.channel.ChannelRegistrationPayload r0 = (com.urbanairship.channel.ChannelRegistrationPayload) r0
            if (r0 != 0) goto L5e
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L5e:
            com.urbanairship.channel.RegistrationInfo r1 = r6.getLastChannelRegistrationInfo()
            com.urbanairship.channel.ChannelApiClient r2 = r6.channelApiClient
            android.net.Uri r7 = r2.createLocation$urbanairship_core_release(r7)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            boolean r6 = r6.shouldUpdate(r0, r1, r7)
            if (r6 != 0) goto L73
            r3 = r4
        L73:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelRegistrar.isUpToDate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final RegistrationInfo getLastChannelRegistrationInfo() {
        JsonValue jsonValueOptJsonValue = this.dataStore.optJsonValue("com.urbanairship.channel.LAST_CHANNEL_REGISTRATION_INFO");
        if (jsonValueOptJsonValue == null) {
            return null;
        }
        try {
            JsonMap jsonMapRequireMap = jsonValueOptJsonValue.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            return new RegistrationInfo(jsonMapRequireMap);
        } catch (JsonException unused) {
            return null;
        }
    }

    private final void setLastChannelRegistrationInfo(RegistrationInfo registrationInfo) {
        this.dataStore.put("com.urbanairship.channel.LAST_CHANNEL_REGISTRATION_INFO", registrationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createChannel(kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelRegistrar.createChannel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object tryRestoreChannel(java.lang.String r9, com.urbanairship.channel.ChannelRegistrationPayload r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.urbanairship.channel.ChannelRegistrar.C10761
            if (r0 == 0) goto L13
            r0 = r11
            com.urbanairship.channel.ChannelRegistrar$tryRestoreChannel$1 r0 = (com.urbanairship.channel.ChannelRegistrar.C10761) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.ChannelRegistrar$tryRestoreChannel$1 r0 = new com.urbanairship.channel.ChannelRegistrar$tryRestoreChannel$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7e
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r0.L$0
            com.urbanairship.channel.ChannelRegistrar r8 = (com.urbanairship.channel.ChannelRegistrar) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L71
        L42:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.channel.ChannelApiClient r11 = r8.channelApiClient
            android.net.Uri r11 = r11.createLocation$urbanairship_core_release(r9)
            if (r11 != 0) goto L4e
            return r5
        L4e:
            com.urbanairship.http.RequestResult r2 = new com.urbanairship.http.RequestResult
            com.urbanairship.channel.Channel r6 = new com.urbanairship.channel.Channel
            java.lang.String r11 = r11.toString()
            java.lang.String r7 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r7)
            r6.<init>(r9, r11)
            r11 = 200(0xc8, float:2.8E-43)
            r2.<init>(r11, r6, r5, r5)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            r11 = 0
            java.lang.Object r10 = r8.onNewChannelIdCreated(r2, r10, r11, r0)
            if (r10 != r1) goto L71
            return r1
        L71:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r11 = r8.updateChannel(r9, r0)
            if (r11 != r1) goto L7e
            return r1
        L7e:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelRegistrar.tryRestoreChannel(java.lang.String, com.urbanairship.channel.ChannelRegistrationPayload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object regularCreateChannel(com.urbanairship.channel.ChannelRegistrationPayload r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.urbanairship.channel.ChannelRegistrar.C10741
            if (r0 == 0) goto L14
            r0 = r10
            com.urbanairship.channel.ChannelRegistrar$regularCreateChannel$1 r0 = (com.urbanairship.channel.ChannelRegistrar.C10741) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.urbanairship.channel.ChannelRegistrar$regularCreateChannel$1 r0 = new com.urbanairship.channel.ChannelRegistrar$regularCreateChannel$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L44
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L74
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            java.lang.Object r8 = r5.L$1
            r9 = r8
            com.urbanairship.channel.ChannelRegistrationPayload r9 = (com.urbanairship.channel.ChannelRegistrationPayload) r9
            java.lang.Object r8 = r5.L$0
            com.urbanairship.channel.ChannelRegistrar r8 = (com.urbanairship.channel.ChannelRegistrar) r8
            kotlin.ResultKt.throwOnFailure(r10)
        L42:
            r1 = r8
            goto L56
        L44:
            kotlin.ResultKt.throwOnFailure(r10)
            com.urbanairship.channel.ChannelApiClient r10 = r8.channelApiClient
            r5.L$0 = r8
            r5.L$1 = r9
            r5.label = r3
            java.lang.Object r10 = r10.createChannel$urbanairship_core_release(r9, r5)
            if (r10 != r0) goto L42
            return r0
        L56:
            r8 = r10
            com.urbanairship.http.RequestResult r8 = (com.urbanairship.http.RequestResult) r8
            com.urbanairship.channel.ChannelRegistrar$regularCreateChannel$2 r10 = new com.urbanairship.channel.ChannelRegistrar$regularCreateChannel$2
            r10.<init>()
            r4 = 0
            com.urbanairship.UALog.i$default(r4, r10, r3, r4)
            r5.L$0 = r4
            r5.L$1 = r4
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            r3 = r9
            java.lang.Object r10 = onNewChannelIdCreated$default(r1, r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L74
            return r0
        L74:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelRegistrar.regularCreateChannel(com.urbanairship.channel.ChannelRegistrationPayload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onNewChannelIdCreated(final com.urbanairship.http.RequestResult r11, com.urbanairship.channel.ChannelRegistrationPayload r12, boolean r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.urbanairship.channel.ChannelRegistrar.C10731
            if (r0 == 0) goto L13
            r0 = r14
            com.urbanairship.channel.ChannelRegistrar$onNewChannelIdCreated$1 r0 = (com.urbanairship.channel.ChannelRegistrar.C10731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.ChannelRegistrar$onNewChannelIdCreated$1 r0 = new com.urbanairship.channel.ChannelRegistrar$onNewChannelIdCreated$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r14)
            goto L94
        L29:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L31:
            kotlin.ResultKt.throwOnFailure(r14)
            boolean r14 = r11.isSuccessful()
            if (r14 == 0) goto La2
            java.lang.Object r14 = r11.getValue()
            if (r14 == 0) goto La2
            com.urbanairship.channel.ChannelRegistrar$onNewChannelIdCreated$2 r14 = new com.urbanairship.channel.ChannelRegistrar$onNewChannelIdCreated$2
            r14.<init>()
            r2 = 0
            com.urbanairship.UALog.i$default(r2, r14, r3, r2)
            java.lang.Object r14 = r11.getValue()
            com.urbanairship.channel.Channel r14 = (com.urbanairship.channel.Channel) r14
            java.lang.String r14 = r14.getIdentifier()
            r10.setChannelId(r14)
            if (r13 == 0) goto L7c
            com.urbanairship.channel.RegistrationInfo r13 = new com.urbanairship.channel.RegistrationInfo
            com.urbanairship.util.Clock r14 = r10.clock
            long r5 = r14.currentTimeMillis()
            com.urbanairship.util.Clock r14 = r10.clock
            long r7 = r14.currentTimeMillis()
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            java.lang.Object r14 = r11.getValue()
            com.urbanairship.channel.Channel r14 = (com.urbanairship.channel.Channel) r14
            java.lang.String r9 = r14.getLocation()
            r4 = r13
            r8 = r12
            r4.<init>(r5, r7, r8, r9)
            r10.setLastChannelRegistrationInfo(r13)
        L7c:
            kotlinx.coroutines.flow.MutableStateFlow r12 = r10._channelIdFlow
            java.lang.Object r11 = r11.getValue()
            com.urbanairship.channel.Channel r11 = (com.urbanairship.channel.Channel) r11
            java.lang.String r11 = r11.getIdentifier()
            r12.tryEmit(r11)
            r0.label = r3
            java.lang.Object r14 = r10.isUpToDate(r0)
            if (r14 != r1) goto L94
            return r1
        L94:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r10 = r14.booleanValue()
            if (r10 == 0) goto L9f
            com.urbanairship.channel.RegistrationResult r10 = com.urbanairship.channel.RegistrationResult.SUCCESS
            goto La1
        L9f:
            com.urbanairship.channel.RegistrationResult r10 = com.urbanairship.channel.RegistrationResult.NEEDS_UPDATE
        La1:
            return r10
        La2:
            boolean r10 = r11.isServerError()
            if (r10 != 0) goto Lb8
            boolean r10 = r11.isTooManyRequestsError()
            if (r10 != 0) goto Lb8
            java.lang.Throwable r10 = r11.getException()
            if (r10 == 0) goto Lb5
            goto Lb8
        Lb5:
            com.urbanairship.channel.RegistrationResult r10 = com.urbanairship.channel.RegistrationResult.SUCCESS
            return r10
        Lb8:
            com.urbanairship.channel.RegistrationResult r10 = com.urbanairship.channel.RegistrationResult.FAILED
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelRegistrar.onNewChannelIdCreated(com.urbanairship.http.RequestResult, com.urbanairship.channel.ChannelRegistrationPayload, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object onNewChannelIdCreated$default(ChannelRegistrar channelRegistrar, RequestResult requestResult, ChannelRegistrationPayload channelRegistrationPayload, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return channelRegistrar.onNewChannelIdCreated(requestResult, channelRegistrationPayload, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013b A[PHI: r1
  0x013b: PHI (r1v13 java.lang.Object) = (r1v7 java.lang.Object), (r1v1 java.lang.Object) binds: [B:60:0x0138, B:14:0x0033] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateChannel(java.lang.String r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelRegistrar.updateChannel(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
