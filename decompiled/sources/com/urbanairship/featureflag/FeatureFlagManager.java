package com.urbanairship.featureflag;

import android.content.Context;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.featureflag.FeatureFlagEvaluationException;
import com.urbanairship.featureflag.FeatureFlagException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@OpenForTesting
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SBW\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J,\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J:\u0010+\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J.\u0010,\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u00102\u001a\u000203H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J \u00106\u001a\b\u0012\u0004\u0012\u00020$072\u0006\u0010%\u001a\u00020&2\b\b\u0002\u00102\u001a\u000203H\u0007J\b\u00108\u001a\u000209H\u0017J\b\u0010:\u001a\u00020;H\u0017J\u001a\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020&2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J$\u0010A\u001a\b\u0012\u0004\u0012\u00020(0#2\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010CJ<\u0010D\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020H2\u0006\u0010/\u001a\u00020\fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010JJ$\u0010K\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010CJ<\u0010M\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u0002032\u0006\u0010N\u001a\u00020O2\u0006\u0010/\u001a\u00020\fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bP\u0010QJ\u000e\u0010R\u001a\u00020;2\u0006\u0010,\u001a\u00020$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006T"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagManager;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "remoteData", "Lcom/urbanairship/featureflag/FeatureFlagRemoteDataAccess;", "infoProviderFactory", "Lkotlin/Function0;", "Lcom/urbanairship/audience/DeviceInfoProvider;", "deferredResolver", "Lcom/urbanairship/featureflag/FlagDeferredResolver;", "featureFlagAnalytics", "Lcom/urbanairship/featureflag/FeatureFlagAnalytics;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "resultCache", "Lcom/urbanairship/featureflag/FeatureFlagResultCache;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/audience/AudienceEvaluator;Lcom/urbanairship/featureflag/FeatureFlagRemoteDataAccess;Lkotlin/jvm/functions/Function0;Lcom/urbanairship/featureflag/FlagDeferredResolver;Lcom/urbanairship/featureflag/FeatureFlagAnalytics;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/featureflag/FeatureFlagResultCache;)V", "pendingResultScope", "Lkotlinx/coroutines/CoroutineScope;", "getResultCache", "()Lcom/urbanairship/featureflag/FeatureFlagResultCache;", "status", "Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "evaluate", "Lkotlin/Result;", "Lcom/urbanairship/featureflag/FeatureFlag;", "name", "", "remoteDataInfo", "Lcom/urbanairship/featureflag/RemoteDataFeatureFlagInfo;", "evaluate-0E7RQCE", "(Ljava/lang/String;Lcom/urbanairship/featureflag/RemoteDataFeatureFlagInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluatedControl", "flag", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/featureflag/FeatureFlagInfo;", "deviceInfoProvider", "evaluatedControl-3t6e044", "(Ljava/lang/Object;Lcom/urbanairship/featureflag/FeatureFlagInfo;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useResultCache", "", "flag-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flagAsPendingResult", "Lcom/urbanairship/PendingResult;", "getComponentGroup", "", "init", "", "mapError", "Lcom/urbanairship/featureflag/FeatureFlagException;", "flagName", "e", "", "remoteDataFeatureFlagInfo", "remoteDataFeatureFlagInfo-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDeferred", "flagInfo", "isLocallyEligible", "deferredPayload", "Lcom/urbanairship/featureflag/FeatureFlagPayload$DeferredPayload;", "resolveDeferred-yxL6bBk", "(Lcom/urbanairship/featureflag/FeatureFlagInfo;ZLcom/urbanairship/featureflag/FeatureFlagPayload$DeferredPayload;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFlag", "resolveFlag-gIAlu-s", "resolveStatic", "staticPayload", "Lcom/urbanairship/featureflag/FeatureFlagPayload$StaticPayload;", "resolveStatic-yxL6bBk", "(Lcom/urbanairship/featureflag/FeatureFlagInfo;ZLcom/urbanairship/featureflag/FeatureFlagPayload$StaticPayload;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackInteraction", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFeatureFlagManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagManager.kt\ncom/urbanairship/featureflag/FeatureFlagManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,453:1\n288#2,2:454\n1#3:456\n*S KotlinDebug\n*F\n+ 1 FeatureFlagManager.kt\ncom/urbanairship/featureflag/FeatureFlagManager\n*L\n181#1:454,2\n*E\n"})
/* loaded from: classes5.dex */
public final class FeatureFlagManager extends AirshipComponent {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AudienceEvaluator audienceEvaluator;
    private final FlagDeferredResolver deferredResolver;
    private final FeatureFlagAnalytics featureFlagAnalytics;
    private final Function0 infoProviderFactory;
    private final CoroutineScope pendingResultScope;
    private final PrivacyManager privacyManager;
    private final FeatureFlagRemoteDataAccess remoteData;
    private final FeatureFlagResultCache resultCache;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeatureFlagRemoteDataStatus.values().length];
            try {
                iArr[FeatureFlagRemoteDataStatus.UP_TO_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeatureFlagRemoteDataStatus.STALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeatureFlagRemoteDataStatus.OUT_OF_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    @NotNull
    public static final FeatureFlagManager shared() {
        return INSTANCE.shared();
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<FeatureFlag> flagAsPendingResult(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return flagAsPendingResult$default(this, name, false, 2, null);
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 13;
    }

    public /* synthetic */ FeatureFlagManager(Context context, PreferenceDataStore preferenceDataStore, AudienceEvaluator audienceEvaluator, FeatureFlagRemoteDataAccess featureFlagRemoteDataAccess, Function0 function0, FlagDeferredResolver flagDeferredResolver, FeatureFlagAnalytics featureFlagAnalytics, PrivacyManager privacyManager, FeatureFlagResultCache featureFlagResultCache, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, preferenceDataStore, audienceEvaluator, featureFlagRemoteDataAccess, (i & 16) != 0 ? new Function0() { // from class: com.urbanairship.featureflag.FeatureFlagManager.1
            @Override // kotlin.jvm.functions.Function0
            public final DeviceInfoProvider invoke() {
                return DeviceInfoProvider.Companion.newCachingProvider$default(DeviceInfoProvider.INSTANCE, null, 1, null);
            }
        } : function0, flagDeferredResolver, featureFlagAnalytics, privacyManager, featureFlagResultCache);
    }

    @NotNull
    public final FeatureFlagResultCache getResultCache() {
        return this.resultCache;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureFlagManager(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AudienceEvaluator audienceEvaluator, @NotNull FeatureFlagRemoteDataAccess remoteData, @NotNull Function0<? extends DeviceInfoProvider> infoProviderFactory, @NotNull FlagDeferredResolver deferredResolver, @NotNull FeatureFlagAnalytics featureFlagAnalytics, @NotNull PrivacyManager privacyManager, @NotNull FeatureFlagResultCache resultCache) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(audienceEvaluator, "audienceEvaluator");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(infoProviderFactory, "infoProviderFactory");
        Intrinsics.checkNotNullParameter(deferredResolver, "deferredResolver");
        Intrinsics.checkNotNullParameter(featureFlagAnalytics, "featureFlagAnalytics");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(resultCache, "resultCache");
        this.audienceEvaluator = audienceEvaluator;
        this.remoteData = remoteData;
        this.infoProviderFactory = infoProviderFactory;
        this.deferredResolver = deferredResolver;
        this.featureFlagAnalytics = featureFlagAnalytics;
        this.privacyManager = privacyManager;
        this.resultCache = resultCache;
        this.pendingResultScope = CoroutineScopeKt.CoroutineScope(AirshipDispatchers.INSTANCE.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagManager$Companion;", "", "()V", "shared", "Lcom/urbanairship/featureflag/FeatureFlagManager;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final FeatureFlagManager shared() {
            AirshipComponent airshipComponentRequireComponent = UAirship.shared().requireComponent(FeatureFlagManager.class);
            Intrinsics.checkNotNullExpressionValue(airshipComponentRequireComponent, "requireComponent(...)");
            return (FeatureFlagManager) airshipComponentRequireComponent;
        }
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void init() {
        super.init();
    }

    public static /* synthetic */ PendingResult flagAsPendingResult$default(FeatureFlagManager featureFlagManager, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return featureFlagManager.flagAsPendingResult(str, z);
    }

    /* renamed from: com.urbanairship.featureflag.FeatureFlagManager$flagAsPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C11251 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $name;
        final /* synthetic */ PendingResult $result;
        final /* synthetic */ boolean $useResultCache;
        Object L$0;
        int label;
        final /* synthetic */ FeatureFlagManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11251(PendingResult pendingResult, FeatureFlagManager featureFlagManager, String str, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = featureFlagManager;
            this.$name = str;
            this.$useResultCache = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11251(this.$result, this.this$0, this.$name, this.$useResultCache, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$result;
                FeatureFlagManager featureFlagManager = this.this$0;
                String str = this.$name;
                boolean z = this.$useResultCache;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object objM2862flag0E7RQCE = featureFlagManager.m2862flag0E7RQCE(str, z, this);
                if (objM2862flag0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM2862flag0E7RQCE;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            if (Result.m2973isFailureimpl(value)) {
                value = null;
            }
            pendingResult.setResult(value);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    @NotNull
    public final PendingResult<FeatureFlag> flagAsPendingResult(@NotNull String name, boolean useResultCache) {
        Intrinsics.checkNotNullParameter(name, "name");
        PendingResult<FeatureFlag> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new C11251(pendingResult, this, name, useResultCache, null), 3, null);
        return pendingResult;
    }

    /* renamed from: flag-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m2857flag0E7RQCE$default(FeatureFlagManager featureFlagManager, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return featureFlagManager.m2862flag0E7RQCE(str, z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: flag-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2862flag0E7RQCE(@org.jetbrains.annotations.NotNull java.lang.String r7, boolean r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<com.urbanairship.featureflag.FeatureFlag>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.urbanairship.featureflag.FeatureFlagManager$flag$1
            if (r0 == 0) goto L13
            r0 = r9
            com.urbanairship.featureflag.FeatureFlagManager$flag$1 r0 = (com.urbanairship.featureflag.FeatureFlagManager$flag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.featureflag.FeatureFlagManager$flag$1 r0 = new com.urbanairship.featureflag.FeatureFlagManager$flag$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lc2
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            com.urbanairship.featureflag.FeatureFlagManager r6 = (com.urbanairship.featureflag.FeatureFlagManager) r6
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r9 = r9.getValue()
        L4b:
            r5 = r7
            r7 = r6
            r6 = r9
            r9 = r8
            r8 = r5
            goto L97
        L51:
            kotlin.ResultKt.throwOnFailure(r9)
            com.urbanairship.PrivacyManager r9 = r6.privacyManager
            com.urbanairship.PrivacyManager$Feature r2 = com.urbanairship.PrivacyManager.Feature.FEATURE_FLAGS
            com.urbanairship.PrivacyManager$Feature[] r2 = new com.urbanairship.PrivacyManager.Feature[]{r2}
            boolean r9 = r9.isEnabled(r2)
            if (r9 != 0) goto L88
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Failed to fetch feature flag: '"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = "'! Feature flags are disabled."
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m2968constructorimpl(r6)
            return r6
        L88:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.Z$0 = r8
            r0.label = r4
            java.lang.Object r9 = r6.m2860resolveFlaggIAlus(r7, r0)
            if (r9 != r1) goto L4b
            return r1
        L97:
            if (r9 == 0) goto Lca
            boolean r9 = kotlin.Result.m2973isFailureimpl(r6)
            r2 = 0
            if (r9 != 0) goto Lb3
            boolean r9 = kotlin.Result.m2973isFailureimpl(r6)
            if (r9 == 0) goto La8
            r9 = r2
            goto La9
        La8:
            r9 = r6
        La9:
            com.urbanairship.featureflag.FeatureFlag r9 = (com.urbanairship.featureflag.FeatureFlag) r9
            if (r9 == 0) goto Lca
            boolean r9 = r9.getExists()
            if (r9 != 0) goto Lca
        Lb3:
            com.urbanairship.featureflag.FeatureFlagResultCache r7 = r7.resultCache
            r0.L$0 = r6
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = r7.flag(r8, r0)
            if (r9 != r1) goto Lc2
            return r1
        Lc2:
            com.urbanairship.featureflag.FeatureFlag r9 = (com.urbanairship.featureflag.FeatureFlag) r9
            if (r9 == 0) goto Lca
            java.lang.Object r6 = kotlin.Result.m2968constructorimpl(r9)
        Lca:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m2862flag0E7RQCE(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final Flow<FeatureFlagRemoteDataStatus> getStatusUpdates() {
        Flow<FeatureFlagRemoteDataStatus> statusUpdates = this.remoteData.getStatusUpdates();
        return statusUpdates == null ? FlowKt.flowOf(FeatureFlagRemoteDataStatus.OUT_OF_DATE) : statusUpdates;
    }

    @NotNull
    public final FeatureFlagRemoteDataStatus getStatus() {
        return this.remoteData.getStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: resolveFlag-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2860resolveFlaggIAlus(java.lang.String r11, kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m2860resolveFlaggIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: remoteDataFeatureFlagInfo-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2858remoteDataFeatureFlagInfogIAlus(java.lang.String r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m2858remoteDataFeatureFlagInfogIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final FeatureFlagException mapError(String flagName, Throwable e) {
        String str;
        if (e instanceof FeatureFlagEvaluationException.OutOfDate) {
            FeatureFlagException.FailedToFetch failedToFetch = new FeatureFlagException.FailedToFetch("Failed to fetch feature flag: '" + flagName + "'! Remote data is outdated.");
            failedToFetch.initCause(e);
            return failedToFetch;
        }
        if (e instanceof FeatureFlagEvaluationException.StaleNotAllowed) {
            FeatureFlagException.FailedToFetch failedToFetch2 = new FeatureFlagException.FailedToFetch("Failed to fetch feature flag: '" + flagName + "'! Stale data is not allowed.");
            failedToFetch2.initCause(e);
            return failedToFetch2;
        }
        if (e instanceof FeatureFlagEvaluationException.ConnectionError) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to fetch feature flag: '");
            sb.append(flagName);
            sb.append("'! Network error");
            FeatureFlagEvaluationException.ConnectionError connectionError = (FeatureFlagEvaluationException.ConnectionError) e;
            Integer statusCode = connectionError.getStatusCode();
            String str2 = null;
            if (statusCode != null) {
                str = " (" + statusCode.intValue() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            } else {
                str = null;
            }
            sb.append(str);
            sb.append('.');
            String errorDescription = connectionError.getErrorDescription();
            if (errorDescription != null) {
                str2 = ' ' + errorDescription;
            }
            sb.append(str2);
            FeatureFlagException.FailedToFetch failedToFetch3 = new FeatureFlagException.FailedToFetch(sb.toString());
            failedToFetch3.initCause(e);
            return failedToFetch3;
        }
        FeatureFlagException.FailedToFetch failedToFetch4 = new FeatureFlagException.FailedToFetch("Failed to fetch feature flag: '" + flagName + "'!");
        if (e == null) {
            return failedToFetch4;
        }
        failedToFetch4.initCause(e);
        return failedToFetch4;
    }

    public final void trackInteraction(@NotNull FeatureFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (!this.privacyManager.isEnabled(PrivacyManager.Feature.FEATURE_FLAGS)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.featureflag.FeatureFlagManager.trackInteraction.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Feature flags are disabled, unable to track interaction";
                }
            }, 1, null);
        } else {
            this.featureFlagAnalytics.trackInteraction(flag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x014a -> B:21:0x00db). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01c8 -> B:52:0x01d1). Please report as a decompilation issue!!! */
    /* renamed from: evaluate-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2855evaluate0E7RQCE(java.lang.String r23, com.urbanairship.featureflag.RemoteDataFeatureFlagInfo r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m2855evaluate0E7RQCE(java.lang.String, com.urbanairship.featureflag.RemoteDataFeatureFlagInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* renamed from: evaluatedControl-3t6e044, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2856evaluatedControl3t6e044(java.lang.Object r11, com.urbanairship.featureflag.FeatureFlagInfo r12, com.urbanairship.audience.DeviceInfoProvider r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.urbanairship.featureflag.FeatureFlagManager$evaluatedControl$1
            if (r0 == 0) goto L14
            r0 = r14
            com.urbanairship.featureflag.FeatureFlagManager$evaluatedControl$1 r0 = (com.urbanairship.featureflag.FeatureFlagManager$evaluatedControl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.urbanairship.featureflag.FeatureFlagManager$evaluatedControl$1 r0 = new com.urbanairship.featureflag.FeatureFlagManager$evaluatedControl$1
            r0.<init>(r10, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r7 = 1
            r8 = 0
            if (r1 == 0) goto L3e
            if (r1 != r7) goto L36
            java.lang.Object r10 = r6.L$2
            com.urbanairship.featureflag.FeatureFlag r10 = (com.urbanairship.featureflag.FeatureFlag) r10
            java.lang.Object r11 = r6.L$1
            com.urbanairship.featureflag.ControlOptions r11 = (com.urbanairship.featureflag.ControlOptions) r11
            java.lang.Object r12 = r6.L$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L85
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.urbanairship.featureflag.ControlOptions r14 = r12.getControlOptions()
            if (r14 != 0) goto L48
            return r11
        L48:
            boolean r1 = kotlin.Result.m2973isFailureimpl(r11)
            if (r1 == 0) goto L50
            r1 = r8
            goto L51
        L50:
            r1 = r11
        L51:
            r9 = r1
            com.urbanairship.featureflag.FeatureFlag r9 = (com.urbanairship.featureflag.FeatureFlag) r9
            if (r9 != 0) goto L57
            return r11
        L57:
            boolean r1 = r9.getIsEligible()
            if (r1 != 0) goto L5e
            return r11
        L5e:
            com.urbanairship.audience.AudienceEvaluator r1 = r10.audienceEvaluator
            com.urbanairship.featureflag.FeatureFlagCompoundAudience r10 = r14.getCompoundAudience()
            if (r10 == 0) goto L6c
            com.urbanairship.audience.CompoundAudienceSelector r10 = r10.getSelector()
            r2 = r10
            goto L6d
        L6c:
            r2 = r8
        L6d:
            long r3 = r12.getCreated()
            r6.L$0 = r11
            r6.L$1 = r14
            r6.L$2 = r9
            r6.label = r7
            r5 = r13
            java.lang.Object r10 = r1.evaluate(r2, r3, r5, r6)
            if (r10 != r0) goto L81
            return r0
        L81:
            r12 = r11
            r11 = r14
            r14 = r10
            r10 = r9
        L85:
            com.urbanairship.audience.AirshipDeviceAudienceResult r14 = (com.urbanairship.audience.AirshipDeviceAudienceResult) r14
            boolean r13 = r14.isMatch()
            if (r13 != 0) goto L8e
            return r12
        L8e:
            com.urbanairship.featureflag.ControlOptions$Type r12 = r11.getControlType()
            com.urbanairship.featureflag.ControlOptions$Type$Flag r13 = com.urbanairship.featureflag.ControlOptions.Type.Flag.INSTANCE
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r13)
            if (r13 == 0) goto La5
            r12 = 0
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            r13 = 2
            com.urbanairship.featureflag.FeatureFlag r10 = com.urbanairship.featureflag.FeatureFlag.copyWith$urbanairship_feature_flag_release$default(r10, r12, r8, r13, r8)
            goto Lb3
        La5:
            boolean r13 = r12 instanceof com.urbanairship.featureflag.ControlOptions.Type.Variables
            if (r13 == 0) goto Lcc
            com.urbanairship.featureflag.ControlOptions$Type$Variables r12 = (com.urbanairship.featureflag.ControlOptions.Type.Variables) r12
            com.urbanairship.json.JsonMap r12 = r12.getData()
            com.urbanairship.featureflag.FeatureFlag r10 = com.urbanairship.featureflag.FeatureFlag.copyWith$urbanairship_feature_flag_release$default(r10, r8, r12, r7, r8)
        Lb3:
            com.urbanairship.featureflag.FeatureFlag$ReportingInfo r12 = r10.getReportingInfo()
            if (r12 == 0) goto Lc7
            com.urbanairship.json.JsonMap r13 = r12.getReportingMetadata()
            r12.addSuperseded(r13)
            com.urbanairship.json.JsonMap r11 = r11.getReportingMetadata()
            r12.setReportingMetadata(r11)
        Lc7:
            java.lang.Object r10 = kotlin.Result.m2968constructorimpl(r10)
            return r10
        Lcc:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m2856evaluatedControl3t6e044(java.lang.Object, com.urbanairship.featureflag.FeatureFlagInfo, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* renamed from: resolveStatic-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2861resolveStaticyxL6bBk(com.urbanairship.featureflag.FeatureFlagInfo r17, boolean r18, com.urbanairship.featureflag.FeatureFlagPayload.StaticPayload r19, com.urbanairship.audience.DeviceInfoProvider r20, kotlin.coroutines.Continuation r21) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m2861resolveStaticyxL6bBk(com.urbanairship.featureflag.FeatureFlagInfo, boolean, com.urbanairship.featureflag.FeatureFlagPayload$StaticPayload, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0148 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0267 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0288 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* renamed from: resolveDeferred-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2859resolveDeferredyxL6bBk(com.urbanairship.featureflag.FeatureFlagInfo r27, boolean r28, com.urbanairship.featureflag.FeatureFlagPayload.DeferredPayload r29, com.urbanairship.audience.DeviceInfoProvider r30, kotlin.coroutines.Continuation r31) {
        /*
            Method dump skipped, instructions count: 736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m2859resolveDeferredyxL6bBk(com.urbanairship.featureflag.FeatureFlagInfo, boolean, com.urbanairship.featureflag.FeatureFlagPayload$DeferredPayload, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
