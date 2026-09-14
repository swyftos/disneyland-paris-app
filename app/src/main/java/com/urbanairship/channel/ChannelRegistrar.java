package com.urbanairship.channel;

import android.content.Context;
import android.net.Uri;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.actions.EnableFeatureAction;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 I2\u00020\u0001:\u0001IB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0013J\u0010\u00100\u001a\u0004\u0018\u00010*H\u0082@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00101J\u000e\u00104\u001a\u000205H\u0082@¢\u0006\u0002\u00101J\u001a\u00106\u001a\u0004\u0018\u00010*2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u00107\u001a\u00020*H\u0002J.\u00108\u001a\u0002032\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u00107\u001a\u00020*2\b\b\u0002\u0010<\u001a\u000205H\u0082@¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u0002032\u0006\u00107\u001a\u00020*H\u0082@¢\u0006\u0002\u0010?J\"\u0010@\u001a\u0002052\u0006\u00107\u001a\u00020*2\b\u0010A\u001a\u0004\u0018\u00010!2\u0006\u0010B\u001a\u00020\u0016H\u0002J \u0010C\u001a\u0004\u0018\u0001032\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u00107\u001a\u00020*H\u0082@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u0002032\u0006\u0010\u0018\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u000203H\u0080@¢\u0006\u0004\bH\u00101R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0017\u001a\u0004\u0018\u00010!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R4\u0010'\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, m1836d2 = {"Lcom/urbanairship/channel/ChannelRegistrar;", "", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;)V", "channelApiClient", "Lcom/urbanairship/channel/ChannelApiClient;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "channelCreateOption", "Lcom/urbanairship/channel/AirshipChannelCreateOption;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/channel/ChannelApiClient;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/channel/AirshipChannelCreateOption;Lcom/urbanairship/util/Clock;Lcom/urbanairship/PrivacyManager;)V", "_channelIdFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "value", "channelId", "getChannelId$urbanairship_core_release", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "channelIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getChannelIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Lcom/urbanairship/channel/RegistrationInfo;", "lastChannelRegistrationInfo", "getLastChannelRegistrationInfo", "()Lcom/urbanairship/channel/RegistrationInfo;", "setLastChannelRegistrationInfo", "(Lcom/urbanairship/channel/RegistrationInfo;)V", "payloadBuilder", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/urbanairship/channel/ChannelRegistrationPayload;", "getPayloadBuilder", "()Lkotlin/jvm/functions/Function1;", "setPayloadBuilder", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "buildCraPayload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createChannel", "Lcom/urbanairship/channel/RegistrationResult;", "isUpToDate", "", "minimizeUpdatePayload", "payload", "onNewChannelIdCreated", "response", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/channel/Channel;", "rememberPayload", "(Lcom/urbanairship/http/RequestResult;Lcom/urbanairship/channel/ChannelRegistrationPayload;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "regularCreateChannel", "(Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldUpdate", "lastRegistrationInfo", EnableFeatureAction.FEATURE_LOCATION, "tryRestoreChannel", "(Ljava/lang/String;Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateChannel", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRegistration", "updateRegistration$urbanairship_core_release", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nChannelRegistrar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelRegistrar.kt\ncom/urbanairship/channel/ChannelRegistrar\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,337:1\n1#2:338\n18#3,8:339\n*S KotlinDebug\n*F\n+ 1 ChannelRegistrar.kt\ncom/urbanairship/channel/ChannelRegistrar\n*L\n162#1:339,8\n*E\n"})
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

    /* JADX INFO: renamed from: com.urbanairship.channel.ChannelRegistrar$createChannel$1 */
    static final class C51871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C51871(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.createChannel(this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.ChannelRegistrar$isUpToDate$1 */
    static final class C51881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C51881(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.isUpToDate(this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.ChannelRegistrar$onNewChannelIdCreated$1 */
    static final class C51891 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C51891(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.onNewChannelIdCreated(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.ChannelRegistrar$regularCreateChannel$1 */
    static final class C51911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C51911(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.regularCreateChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.ChannelRegistrar$tryRestoreChannel$1 */
    static final class C51931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C51931(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelRegistrar.this.tryRestoreChannel(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.ChannelRegistrar$updateChannel$1 */
    static final class C51941 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C51941(Continuation continuation) {
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

    /* JADX WARN: Code duplicated, block: B:27:0x0061 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0062 A[PHI: r6
  0x0062: PHI (r6v8 java.lang.Object) = (r6v5 java.lang.Object), (r6v1 java.lang.Object) binds: [B:26:0x005f, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object updateRegistration$urbanairship_core_release(@NotNull Continuation<? super RegistrationResult> continuation) {
        ChannelRegistrar$updateRegistration$1 channelRegistrar$updateRegistration$1;
        if (continuation instanceof ChannelRegistrar$updateRegistration$1) {
            channelRegistrar$updateRegistration$1 = (ChannelRegistrar$updateRegistration$1) continuation;
            int i = channelRegistrar$updateRegistration$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelRegistrar$updateRegistration$1.label = i - Integer.MIN_VALUE;
            } else {
                channelRegistrar$updateRegistration$1 = new ChannelRegistrar$updateRegistration$1(this, continuation);
            }
        } else {
            channelRegistrar$updateRegistration$1 = new ChannelRegistrar$updateRegistration$1(this, continuation);
        }
        Object objUpdateChannel = channelRegistrar$updateRegistration$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelRegistrar$updateRegistration$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                this = (ChannelRegistrar) channelRegistrar$updateRegistration$1.L$0;
                ResultKt.throwOnFailure(objUpdateChannel);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objUpdateChannel);
            }
            return objUpdateChannel;
        }
        ResultKt.throwOnFailure(objUpdateChannel);
        String channelId$urbanairship_core_release = getChannelId$urbanairship_core_release();
        if (channelId$urbanairship_core_release != null) {
            channelRegistrar$updateRegistration$1.L$0 = this;
            channelRegistrar$updateRegistration$1.label = 1;
            objUpdateChannel = updateChannel(channelId$urbanairship_core_release, channelRegistrar$updateRegistration$1);
            if (objUpdateChannel == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        channelRegistrar$updateRegistration$1.L$0 = null;
        channelRegistrar$updateRegistration$1.label = 2;
        objUpdateChannel = this.createChannel(channelRegistrar$updateRegistration$1);
        if (objUpdateChannel == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objUpdateChannel;
        RegistrationResult registrationResult = (RegistrationResult) objUpdateChannel;
        if (registrationResult != null) {
            return registrationResult;
        }
        channelRegistrar$updateRegistration$1.L$0 = null;
        channelRegistrar$updateRegistration$1.label = 2;
        objUpdateChannel = this.createChannel(channelRegistrar$updateRegistration$1);
        if (objUpdateChannel == coroutine_suspended) {
            return coroutine_suspended;
        }
        return objUpdateChannel;
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
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object isUpToDate(Continuation continuation) {
        C51881 c51881;
        String channelId$urbanairship_core_release;
        Object objBuildCraPayload;
        if (continuation instanceof C51881) {
            c51881 = (C51881) continuation;
            int i = c51881.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51881.label = i - Integer.MIN_VALUE;
            } else {
                c51881 = new C51881(continuation);
            }
        } else {
            c51881 = new C51881(continuation);
        }
        Object obj = c51881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51881.label;
        boolean z = false;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            channelId$urbanairship_core_release = getChannelId$urbanairship_core_release();
            if (channelId$urbanairship_core_release != null) {
                c51881.L$0 = this;
                c51881.L$1 = channelId$urbanairship_core_release;
                c51881.label = 1;
                objBuildCraPayload = buildCraPayload(c51881);
                if (objBuildCraPayload == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) c51881.L$1;
        ChannelRegistrar channelRegistrar = (ChannelRegistrar) c51881.L$0;
        ResultKt.throwOnFailure(obj);
        channelId$urbanairship_core_release = str;
        this = channelRegistrar;
        objBuildCraPayload = obj;
        ChannelRegistrationPayload channelRegistrationPayload = (ChannelRegistrationPayload) objBuildCraPayload;
        if (channelRegistrationPayload == null) {
            return Boxing.boxBoolean(true);
        }
        if (!this.shouldUpdate(channelRegistrationPayload, this.getLastChannelRegistrationInfo(), String.valueOf(this.channelApiClient.createLocation$urbanairship_core_release(channelId$urbanairship_core_release)))) {
            z = true;
        }
        return Boxing.boxBoolean(z);
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
    /* JADX WARN: Code duplicated, block: B:49:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object createChannel(Continuation continuation) {
        C51871 c51871;
        ChannelGenerationMethod channelGenerationMethod;
        ChannelRegistrationPayload channelRegistrationPayload;
        RegistrationResult registrationResult;
        ChannelRegistrar channelRegistrar;
        ChannelRegistrationPayload channelRegistrationPayload2;
        if (continuation instanceof C51871) {
            c51871 = (C51871) continuation;
            int i = c51871.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51871.label = i - Integer.MIN_VALUE;
            } else {
                c51871 = new C51871(continuation);
            }
        } else {
            c51871 = new C51871(continuation);
        }
        Object objBuildCraPayload = c51871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51871.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBuildCraPayload);
            c51871.L$0 = this;
            c51871.label = 1;
            objBuildCraPayload = buildCraPayload(c51871);
            if (objBuildCraPayload == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(objBuildCraPayload);
                    return (RegistrationResult) objBuildCraPayload;
                }
                if (i2 == 3) {
                    channelRegistrationPayload2 = (ChannelRegistrationPayload) c51871.L$1;
                    channelRegistrar = (ChannelRegistrar) c51871.L$0;
                    ResultKt.throwOnFailure(objBuildCraPayload);
                    registrationResult = (RegistrationResult) objBuildCraPayload;
                    ChannelRegistrar channelRegistrar2 = channelRegistrar;
                    channelRegistrationPayload = channelRegistrationPayload2;
                    this = channelRegistrar2;
                    if (registrationResult == null) {
                        return registrationResult;
                    }
                    c51871.L$0 = null;
                    c51871.L$1 = null;
                    c51871.label = 4;
                    objBuildCraPayload = this.regularCreateChannel(channelRegistrationPayload, c51871);
                    if (objBuildCraPayload == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objBuildCraPayload);
                }
                return (RegistrationResult) objBuildCraPayload;
            }
            this = (ChannelRegistrar) c51871.L$0;
            ResultKt.throwOnFailure(objBuildCraPayload);
        }
        ChannelRegistrationPayload channelRegistrationPayload3 = (ChannelRegistrationPayload) objBuildCraPayload;
        if (channelRegistrationPayload3 == null) {
            return RegistrationResult.FAILED;
        }
        AirshipChannelCreateOption airshipChannelCreateOption = this.channelCreateOption;
        if (airshipChannelCreateOption == null || (channelGenerationMethod = airshipChannelCreateOption.get()) == null) {
            channelGenerationMethod = ChannelGenerationMethod.Automatic.INSTANCE;
        }
        if (Intrinsics.areEqual(channelGenerationMethod, ChannelGenerationMethod.Automatic.INSTANCE)) {
            c51871.L$0 = null;
            c51871.label = 2;
            objBuildCraPayload = this.regularCreateChannel(channelRegistrationPayload3, c51871);
            if (objBuildCraPayload == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (RegistrationResult) objBuildCraPayload;
        }
        if (channelGenerationMethod instanceof ChannelGenerationMethod.Restore) {
            if (channelGenerationMethod.isValid$urbanairship_core_release()) {
                String channelID = ((ChannelGenerationMethod.Restore) channelGenerationMethod).getChannelID();
                c51871.L$0 = this;
                c51871.L$1 = channelRegistrationPayload3;
                c51871.label = 3;
                Object objTryRestoreChannel = this.tryRestoreChannel(channelID, channelRegistrationPayload3, c51871);
                if (objTryRestoreChannel == coroutine_suspended) {
                    return coroutine_suspended;
                }
                channelRegistrar = this;
                channelRegistrationPayload2 = channelRegistrationPayload3;
                objBuildCraPayload = objTryRestoreChannel;
                registrationResult = (RegistrationResult) objBuildCraPayload;
                ChannelRegistrar channelRegistrar3 = channelRegistrar;
                channelRegistrationPayload = channelRegistrationPayload2;
                this = channelRegistrar3;
            } else {
                channelRegistrationPayload = channelRegistrationPayload3;
                registrationResult = null;
            }
            if (registrationResult == null) {
                return registrationResult;
            }
            c51871.L$0 = null;
            c51871.L$1 = null;
            c51871.label = 4;
            objBuildCraPayload = this.regularCreateChannel(channelRegistrationPayload, c51871);
            if (objBuildCraPayload == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (RegistrationResult) objBuildCraPayload;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object tryRestoreChannel(String str, ChannelRegistrationPayload channelRegistrationPayload, Continuation continuation) {
        C51931 c51931;
        if (continuation instanceof C51931) {
            c51931 = (C51931) continuation;
            int i = c51931.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51931.label = i - Integer.MIN_VALUE;
            } else {
                c51931 = new C51931(continuation);
            }
        } else {
            c51931 = new C51931(continuation);
        }
        Object objUpdateChannel = c51931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51931.label;
        if (i2 != 0) {
            if (i2 == 1) {
                str = (String) c51931.L$1;
                this = (ChannelRegistrar) c51931.L$0;
                ResultKt.throwOnFailure(objUpdateChannel);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objUpdateChannel);
            }
        }
        ResultKt.throwOnFailure(objUpdateChannel);
        Uri uriCreateLocation$urbanairship_core_release = this.channelApiClient.createLocation$urbanairship_core_release(str);
        if (uriCreateLocation$urbanairship_core_release == null) {
            return null;
        }
        String string = uriCreateLocation$urbanairship_core_release.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        RequestResult requestResult = new RequestResult(200, new Channel(str, string), null, null);
        c51931.L$0 = this;
        c51931.L$1 = str;
        c51931.label = 1;
        if (onNewChannelIdCreated(requestResult, channelRegistrationPayload, false, c51931) == coroutine_suspended) {
            return coroutine_suspended;
        }
        c51931.L$0 = null;
        c51931.L$1 = null;
        c51931.label = 2;
        objUpdateChannel = this.updateChannel(str, c51931);
        return objUpdateChannel == coroutine_suspended ? coroutine_suspended : objUpdateChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object regularCreateChannel(ChannelRegistrationPayload channelRegistrationPayload, Continuation continuation) {
        C51911 c51911;
        if (continuation instanceof C51911) {
            c51911 = (C51911) continuation;
            int i = c51911.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51911.label = i - Integer.MIN_VALUE;
            } else {
                c51911 = new C51911(continuation);
            }
        } else {
            c51911 = new C51911(continuation);
        }
        C51911 c51912 = c51911;
        Object objCreateChannel$urbanairship_core_release = c51912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51912.label;
        if (i2 != 0) {
            if (i2 == 1) {
                channelRegistrationPayload = (ChannelRegistrationPayload) c51912.L$1;
                this = (ChannelRegistrar) c51912.L$0;
                ResultKt.throwOnFailure(objCreateChannel$urbanairship_core_release);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objCreateChannel$urbanairship_core_release);
            }
        }
        ResultKt.throwOnFailure(objCreateChannel$urbanairship_core_release);
        ChannelApiClient channelApiClient = this.channelApiClient;
        c51912.L$0 = this;
        c51912.L$1 = channelRegistrationPayload;
        c51912.label = 1;
        objCreateChannel$urbanairship_core_release = channelApiClient.createChannel$urbanairship_core_release(channelRegistrationPayload, c51912);
        if (objCreateChannel$urbanairship_core_release == coroutine_suspended) {
            return coroutine_suspended;
        }
        ChannelRegistrar channelRegistrar = this;
        final RequestResult requestResult = (RequestResult) objCreateChannel$urbanairship_core_release;
        UALog.i$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.regularCreateChannel.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Channel registration finished with result: " + requestResult;
            }
        }, 1, null);
        c51912.L$0 = null;
        c51912.L$1 = null;
        c51912.label = 2;
        objCreateChannel$urbanairship_core_release = onNewChannelIdCreated$default(channelRegistrar, requestResult, channelRegistrationPayload, false, c51912, 4, null);
        return objCreateChannel$urbanairship_core_release == coroutine_suspended ? coroutine_suspended : objCreateChannel$urbanairship_core_release;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object onNewChannelIdCreated(final RequestResult requestResult, ChannelRegistrationPayload channelRegistrationPayload, boolean z, Continuation continuation) {
        C51891 c51891;
        if (continuation instanceof C51891) {
            c51891 = (C51891) continuation;
            int i = c51891.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51891.label = i - Integer.MIN_VALUE;
            } else {
                c51891 = new C51891(continuation);
            }
        } else {
            c51891 = new C51891(continuation);
        }
        Object objIsUpToDate = c51891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51891.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objIsUpToDate);
            if (requestResult.isSuccessful() && requestResult.getValue() != null) {
                UALog.i$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.onNewChannelIdCreated.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Airship channel created: " + ((Channel) requestResult.getValue()).getIdentifier();
                    }
                }, 1, null);
                setChannelId(((Channel) requestResult.getValue()).getIdentifier());
                if (z) {
                    setLastChannelRegistrationInfo(new RegistrationInfo(this.clock.currentTimeMillis(), Boxing.boxLong(this.clock.currentTimeMillis()), channelRegistrationPayload, ((Channel) requestResult.getValue()).getLocation()));
                }
                this._channelIdFlow.tryEmit(((Channel) requestResult.getValue()).getIdentifier());
                c51891.label = 1;
                objIsUpToDate = isUpToDate(c51891);
                if (objIsUpToDate == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (requestResult.isServerError() || requestResult.isTooManyRequestsError() || requestResult.getException() != null) {
                    return RegistrationResult.FAILED;
                }
                return RegistrationResult.SUCCESS;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsUpToDate);
        }
        if (((Boolean) objIsUpToDate).booleanValue()) {
            return RegistrationResult.SUCCESS;
        }
        return RegistrationResult.NEEDS_UPDATE;
    }

    static /* synthetic */ Object onNewChannelIdCreated$default(ChannelRegistrar channelRegistrar, RequestResult requestResult, ChannelRegistrationPayload channelRegistrationPayload, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return channelRegistrar.onNewChannelIdCreated(requestResult, channelRegistrationPayload, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:52:0x010c  */
    /* JADX WARN: Code duplicated, block: B:53:0x010f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0119  */
    /* JADX WARN: Code duplicated, block: B:61:0x013a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x013b A[PHI: r1
  0x013b: PHI (r1v13 java.lang.Object) = (r1v7 java.lang.Object), (r1v1 java.lang.Object) binds: [B:60:0x0138, B:14:0x0033] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0142  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object updateChannel(String str, Continuation continuation) {
        C51941 c51941;
        String str2;
        Object objBuildCraPayload;
        ChannelRegistrar channelRegistrar;
        ChannelRegistrationPayload channelRegistrationPayload;
        ChannelRegistrationPayload channelRegistrationPayload2;
        final RequestResult requestResult;
        RegistrationInfo lastChannelRegistrationInfo;
        Long l;
        Long lastFullUploadMillis;
        Integer status;
        ChannelRegistrar channelRegistrar2 = this;
        if (continuation instanceof C51941) {
            c51941 = (C51941) continuation;
            int i = c51941.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51941.label = i - Integer.MIN_VALUE;
            } else {
                c51941 = channelRegistrar2.new C51941(continuation);
            }
        } else {
            c51941 = channelRegistrar2.new C51941(continuation);
        }
        Object objUpdateChannel$urbanairship_core_release = c51941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51941.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objUpdateChannel$urbanairship_core_release);
            c51941.L$0 = channelRegistrar2;
            str2 = str;
            c51941.L$1 = str2;
            c51941.label = 1;
            objBuildCraPayload = channelRegistrar2.buildCraPayload(c51941);
            if (objBuildCraPayload == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(objUpdateChannel$urbanairship_core_release);
                        return objUpdateChannel$urbanairship_core_release;
                    }
                    ResultKt.throwOnFailure(objUpdateChannel$urbanairship_core_release);
                    if (((Boolean) objUpdateChannel$urbanairship_core_release).booleanValue()) {
                        return RegistrationResult.SUCCESS;
                    }
                    return RegistrationResult.NEEDS_UPDATE;
                }
                channelRegistrationPayload2 = (ChannelRegistrationPayload) c51941.L$2;
                ChannelRegistrationPayload channelRegistrationPayload3 = (ChannelRegistrationPayload) c51941.L$1;
                channelRegistrar = (ChannelRegistrar) c51941.L$0;
                ResultKt.throwOnFailure(objUpdateChannel$urbanairship_core_release);
                channelRegistrationPayload = channelRegistrationPayload3;
                requestResult = (RequestResult) objUpdateChannel$urbanairship_core_release;
                UALog.i$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Channel registration finished with result " + requestResult;
                    }
                }, 1, null);
                if (Intrinsics.areEqual(channelRegistrationPayload, channelRegistrationPayload2)) {
                    lastFullUploadMillis = Boxing.boxLong(channelRegistrar.clock.currentTimeMillis());
                } else {
                    lastChannelRegistrationInfo = channelRegistrar.getLastChannelRegistrationInfo();
                    if (lastChannelRegistrationInfo != null) {
                        lastFullUploadMillis = lastChannelRegistrationInfo.getLastFullUploadMillis();
                    } else {
                        l = null;
                    }
                    if (!requestResult.isSuccessful() && requestResult.getValue() != null) {
                        UALog.i$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.4
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Airship channel updated";
                            }
                        }, 1, null);
                        channelRegistrar.setLastChannelRegistrationInfo(new RegistrationInfo(channelRegistrar.clock.currentTimeMillis(), l, channelRegistrationPayload, ((Channel) requestResult.getValue()).getLocation()));
                        c51941.L$0 = null;
                        c51941.L$1 = null;
                        c51941.L$2 = null;
                        c51941.label = 3;
                        objUpdateChannel$urbanairship_core_release = channelRegistrar.isUpToDate(c51941);
                        if (objUpdateChannel$urbanairship_core_release == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) objUpdateChannel$urbanairship_core_release).booleanValue()) {
                            return RegistrationResult.SUCCESS;
                        }
                        return RegistrationResult.NEEDS_UPDATE;
                    }
                    status = requestResult.getStatus();
                    if (status != null && status.intValue() == 409) {
                        UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.5
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Channel registration conflict, will recreate channel.";
                            }
                        }, 1, null);
                        channelRegistrar.setLastChannelRegistrationInfo(null);
                        channelRegistrar.setChannelId(null);
                        c51941.L$0 = null;
                        c51941.L$1 = null;
                        c51941.L$2 = null;
                        c51941.label = 4;
                        objUpdateChannel$urbanairship_core_release = channelRegistrar.createChannel(c51941);
                        if (objUpdateChannel$urbanairship_core_release == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return objUpdateChannel$urbanairship_core_release;
                    }
                    if (!requestResult.isServerError() || requestResult.isTooManyRequestsError() || requestResult.getException() != null) {
                        return RegistrationResult.FAILED;
                    }
                    return RegistrationResult.SUCCESS;
                }
                l = lastFullUploadMillis;
                if (!requestResult.isSuccessful()) {
                }
                status = requestResult.getStatus();
                if (status != null) {
                    UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.5
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Channel registration conflict, will recreate channel.";
                        }
                    }, 1, null);
                    channelRegistrar.setLastChannelRegistrationInfo(null);
                    channelRegistrar.setChannelId(null);
                    c51941.L$0 = null;
                    c51941.L$1 = null;
                    c51941.L$2 = null;
                    c51941.label = 4;
                    objUpdateChannel$urbanairship_core_release = channelRegistrar.createChannel(c51941);
                    if (objUpdateChannel$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objUpdateChannel$urbanairship_core_release;
                }
                if (!requestResult.isServerError()) {
                }
                return RegistrationResult.FAILED;
            }
            String str3 = (String) c51941.L$1;
            ChannelRegistrar channelRegistrar3 = (ChannelRegistrar) c51941.L$0;
            ResultKt.throwOnFailure(objUpdateChannel$urbanairship_core_release);
            str2 = str3;
            channelRegistrar2 = channelRegistrar3;
            objBuildCraPayload = objUpdateChannel$urbanairship_core_release;
        }
        ChannelRegistrationPayload channelRegistrationPayload4 = (ChannelRegistrationPayload) objBuildCraPayload;
        if (channelRegistrationPayload4 == null) {
            return RegistrationResult.FAILED;
        }
        ChannelRegistrationPayload channelRegistrationPayloadMinimizeUpdatePayload = channelRegistrar2.minimizeUpdatePayload(str2, channelRegistrationPayload4);
        if (channelRegistrationPayloadMinimizeUpdatePayload == null) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Channel already up to date.";
                }
            }, 1, null);
            return RegistrationResult.SUCCESS;
        }
        ChannelApiClient channelApiClient = channelRegistrar2.channelApiClient;
        c51941.L$0 = channelRegistrar2;
        c51941.L$1 = channelRegistrationPayload4;
        c51941.L$2 = channelRegistrationPayloadMinimizeUpdatePayload;
        c51941.label = 2;
        objUpdateChannel$urbanairship_core_release = channelApiClient.updateChannel$urbanairship_core_release(str2, channelRegistrationPayloadMinimizeUpdatePayload, c51941);
        if (objUpdateChannel$urbanairship_core_release == coroutine_suspended) {
            return coroutine_suspended;
        }
        channelRegistrar = channelRegistrar2;
        channelRegistrationPayload = channelRegistrationPayload4;
        channelRegistrationPayload2 = channelRegistrationPayloadMinimizeUpdatePayload;
        requestResult = (RequestResult) objUpdateChannel$urbanairship_core_release;
        UALog.i$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Channel registration finished with result " + requestResult;
            }
        }, 1, null);
        if (Intrinsics.areEqual(channelRegistrationPayload, channelRegistrationPayload2)) {
            lastFullUploadMillis = Boxing.boxLong(channelRegistrar.clock.currentTimeMillis());
        } else {
            lastChannelRegistrationInfo = channelRegistrar.getLastChannelRegistrationInfo();
            if (lastChannelRegistrationInfo != null) {
                lastFullUploadMillis = lastChannelRegistrationInfo.getLastFullUploadMillis();
            } else {
                l = null;
            }
            if (!requestResult.isSuccessful()) {
            }
            status = requestResult.getStatus();
            if (status != null) {
                UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.5
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Channel registration conflict, will recreate channel.";
                    }
                }, 1, null);
                channelRegistrar.setLastChannelRegistrationInfo(null);
                channelRegistrar.setChannelId(null);
                c51941.L$0 = null;
                c51941.L$1 = null;
                c51941.L$2 = null;
                c51941.label = 4;
                objUpdateChannel$urbanairship_core_release = channelRegistrar.createChannel(c51941);
                if (objUpdateChannel$urbanairship_core_release == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objUpdateChannel$urbanairship_core_release;
            }
            if (!requestResult.isServerError()) {
            }
            return RegistrationResult.FAILED;
        }
        l = lastFullUploadMillis;
        if (!requestResult.isSuccessful()) {
        }
        status = requestResult.getStatus();
        if (status != null) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelRegistrar.updateChannel.5
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Channel registration conflict, will recreate channel.";
                }
            }, 1, null);
            channelRegistrar.setLastChannelRegistrationInfo(null);
            channelRegistrar.setChannelId(null);
            c51941.L$0 = null;
            c51941.L$1 = null;
            c51941.L$2 = null;
            c51941.label = 4;
            objUpdateChannel$urbanairship_core_release = channelRegistrar.createChannel(c51941);
            if (objUpdateChannel$urbanairship_core_release == coroutine_suspended) {
                return coroutine_suspended;
            }
            return objUpdateChannel$urbanairship_core_release;
        }
        if (!requestResult.isServerError()) {
        }
        return RegistrationResult.FAILED;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
