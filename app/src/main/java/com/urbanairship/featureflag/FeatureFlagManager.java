package com.urbanairship.featureflag;

import android.content.Context;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.audience.AirshipDeviceAudienceResult;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.audience.CompoundAudienceSelector;
import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.contacts.StableContactInfo;
import com.urbanairship.deferred.DeferredRequest;
import com.urbanairship.json.JsonMap;
import com.urbanairship.remotedata.RemoteDataInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@OpenForTesting
@Metadata(m1835d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SBW\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J,\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J:\u0010+\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J.\u0010,\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u00102\u001a\u000203H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J \u00106\u001a\b\u0012\u0004\u0012\u00020$072\u0006\u0010%\u001a\u00020&2\b\b\u0002\u00102\u001a\u000203H\u0007J\b\u00108\u001a\u000209H\u0017J\b\u0010:\u001a\u00020;H\u0017J\u001a\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020&2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J$\u0010A\u001a\b\u0012\u0004\u0012\u00020(0#2\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010CJ<\u0010D\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020H2\u0006\u0010/\u001a\u00020\fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010JJ$\u0010K\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010CJ<\u0010M\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u0002032\u0006\u0010N\u001a\u00020O2\u0006\u0010/\u001a\u00020\fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bP\u0010QJ\u000e\u0010R\u001a\u00020;2\u0006\u0010,\u001a\u00020$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006T"}, m1836d2 = {"Lcom/urbanairship/featureflag/FeatureFlagManager;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "remoteData", "Lcom/urbanairship/featureflag/FeatureFlagRemoteDataAccess;", "infoProviderFactory", "Lkotlin/Function0;", "Lcom/urbanairship/audience/DeviceInfoProvider;", "deferredResolver", "Lcom/urbanairship/featureflag/FlagDeferredResolver;", "featureFlagAnalytics", "Lcom/urbanairship/featureflag/FeatureFlagAnalytics;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "resultCache", "Lcom/urbanairship/featureflag/FeatureFlagResultCache;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/audience/AudienceEvaluator;Lcom/urbanairship/featureflag/FeatureFlagRemoteDataAccess;Lkotlin/jvm/functions/Function0;Lcom/urbanairship/featureflag/FlagDeferredResolver;Lcom/urbanairship/featureflag/FeatureFlagAnalytics;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/featureflag/FeatureFlagResultCache;)V", "pendingResultScope", "Lkotlinx/coroutines/CoroutineScope;", "getResultCache", "()Lcom/urbanairship/featureflag/FeatureFlagResultCache;", "status", "Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "evaluate", "Lkotlin/Result;", "Lcom/urbanairship/featureflag/FeatureFlag;", "name", "", "remoteDataInfo", "Lcom/urbanairship/featureflag/RemoteDataFeatureFlagInfo;", "evaluate-0E7RQCE", "(Ljava/lang/String;Lcom/urbanairship/featureflag/RemoteDataFeatureFlagInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluatedControl", "flag", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/featureflag/FeatureFlagInfo;", "deviceInfoProvider", "evaluatedControl-3t6e044", "(Ljava/lang/Object;Lcom/urbanairship/featureflag/FeatureFlagInfo;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useResultCache", "", "flag-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flagAsPendingResult", "Lcom/urbanairship/PendingResult;", "getComponentGroup", "", "init", "", "mapError", "Lcom/urbanairship/featureflag/FeatureFlagException;", "flagName", "e", "", "remoteDataFeatureFlagInfo", "remoteDataFeatureFlagInfo-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDeferred", "flagInfo", "isLocallyEligible", "deferredPayload", "Lcom/urbanairship/featureflag/FeatureFlagPayload$DeferredPayload;", "resolveDeferred-yxL6bBk", "(Lcom/urbanairship/featureflag/FeatureFlagInfo;ZLcom/urbanairship/featureflag/FeatureFlagPayload$DeferredPayload;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFlag", "resolveFlag-gIAlu-s", "resolveStatic", "staticPayload", "Lcom/urbanairship/featureflag/FeatureFlagPayload$StaticPayload;", "resolveStatic-yxL6bBk", "(Lcom/urbanairship/featureflag/FeatureFlagInfo;ZLcom/urbanairship/featureflag/FeatureFlagPayload$StaticPayload;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackInteraction", "Companion", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nFeatureFlagManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagManager.kt\ncom/urbanairship/featureflag/FeatureFlagManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,453:1\n288#2,2:454\n1#3:456\n*S KotlinDebug\n*F\n+ 1 FeatureFlagManager.kt\ncom/urbanairship/featureflag/FeatureFlagManager\n*L\n181#1:454,2\n*E\n"})
public final class FeatureFlagManager extends AirshipComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, m1836d2 = {"Lcom/urbanairship/featureflag/FeatureFlagManager$Companion;", "", "()V", "shared", "Lcom/urbanairship/featureflag/FeatureFlagManager;", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    /* JADX INFO: renamed from: com.urbanairship.featureflag.FeatureFlagManager$flagAsPendingResult$1 */
    static final class C52911 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $name;
        final /* synthetic */ PendingResult $result;
        final /* synthetic */ boolean $useResultCache;
        Object L$0;
        int label;
        final /* synthetic */ FeatureFlagManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52911(PendingResult pendingResult, FeatureFlagManager featureFlagManager, String str, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$result = pendingResult;
            this.this$0 = featureFlagManager;
            this.$name = str;
            this.$useResultCache = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C52911(this.$result, this.this$0, this.$name, this.$useResultCache, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object objM5104flag0E7RQCE = featureFlagManager.m5104flag0E7RQCE(str, z, this);
                if (objM5104flag0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM5104flag0E7RQCE;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            if (Result.m5282isFailureimpl(value)) {
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
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new C52911(pendingResult, this, name, useResultCache, null), 3, null);
        return pendingResult;
    }

    /* JADX INFO: renamed from: flag-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m5099flag0E7RQCE$default(FeatureFlagManager featureFlagManager, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return featureFlagManager.m5104flag0E7RQCE(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: flag-0E7RQCE, reason: not valid java name */
    public final Object m5104flag0E7RQCE(@NotNull String str, boolean z, @NotNull Continuation<? super Result<FeatureFlag>> continuation) {
        FeatureFlagManager$flag$1 featureFlagManager$flag$1;
        Object objM5102resolveFlaggIAlus;
        Object obj;
        FeatureFlag featureFlag;
        if (continuation instanceof FeatureFlagManager$flag$1) {
            featureFlagManager$flag$1 = (FeatureFlagManager$flag$1) continuation;
            int i = featureFlagManager$flag$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                featureFlagManager$flag$1.label = i - Integer.MIN_VALUE;
            } else {
                featureFlagManager$flag$1 = new FeatureFlagManager$flag$1(this, continuation);
            }
        } else {
            featureFlagManager$flag$1 = new FeatureFlagManager$flag$1(this, continuation);
        }
        Object objFlag = featureFlagManager$flag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = featureFlagManager$flag$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                z = featureFlagManager$flag$1.Z$0;
                str = (String) featureFlagManager$flag$1.L$1;
                this = (FeatureFlagManager) featureFlagManager$flag$1.L$0;
                ResultKt.throwOnFailure(objFlag);
                objM5102resolveFlaggIAlus = ((Result) objFlag).getValue();
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = featureFlagManager$flag$1.L$0;
                ResultKt.throwOnFailure(objFlag);
            }
            featureFlag = (FeatureFlag) objFlag;
            if (featureFlag != null) {
                return Result.m5277constructorimpl(featureFlag);
            }
            return obj;
        }
        ResultKt.throwOnFailure(objFlag);
        if (!this.privacyManager.isEnabled(PrivacyManager.Feature.FEATURE_FLAGS)) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m5277constructorimpl(ResultKt.createFailure(new IllegalStateException("Failed to fetch feature flag: '" + str + "'! Feature flags are disabled.")));
        }
        featureFlagManager$flag$1.L$0 = this;
        featureFlagManager$flag$1.L$1 = str;
        featureFlagManager$flag$1.Z$0 = z;
        featureFlagManager$flag$1.label = 1;
        objM5102resolveFlaggIAlus = m5102resolveFlaggIAlus(str, featureFlagManager$flag$1);
        if (objM5102resolveFlaggIAlus == coroutine_suspended) {
            return coroutine_suspended;
        }
        String str2 = str;
        FeatureFlagManager featureFlagManager = this;
        obj = objM5102resolveFlaggIAlus;
        if (!z) {
            return obj;
        }
        if (!Result.m5282isFailureimpl(obj)) {
            FeatureFlag featureFlag2 = (FeatureFlag) (Result.m5282isFailureimpl(obj) ? null : obj);
            if (featureFlag2 == null || featureFlag2.getExists()) {
                return obj;
            }
        }
        FeatureFlagResultCache featureFlagResultCache = featureFlagManager.resultCache;
        featureFlagManager$flag$1.L$0 = obj;
        featureFlagManager$flag$1.L$1 = null;
        featureFlagManager$flag$1.label = 2;
        objFlag = featureFlagResultCache.flag(str2, featureFlagManager$flag$1);
        if (objFlag == coroutine_suspended) {
            return coroutine_suspended;
        }
        featureFlag = (FeatureFlag) objFlag;
        if (featureFlag != null) {
            return Result.m5277constructorimpl(featureFlag);
        }
        return obj;
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
    /* JADX WARN: Code duplicated, block: B:40:0x00e4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:45:0x0103 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0104  */
    /* JADX WARN: Code duplicated, block: B:49:0x0119 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x011a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0128  */
    /* JADX WARN: Code duplicated, block: B:55:0x0137  */
    /* JADX WARN: Code duplicated, block: B:57:0x0147 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0148  */
    /* JADX WARN: Code duplicated, block: B:61:0x014f  */
    /* JADX WARN: Code duplicated, block: B:63:0x015c  */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: resolveFlag-gIAlu-s, reason: not valid java name */
    public final Object m5102resolveFlaggIAlus(String str, Continuation continuation) {
        FeatureFlagManager$resolveFlag$1 featureFlagManager$resolveFlag$1;
        Object objM5100remoteDataFeatureFlagInfogIAlus;
        Object objM5097evaluate0E7RQCE;
        FeatureFlagManager featureFlagManager;
        RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo;
        String str2;
        Throwable thM5280exceptionOrNullimpl;
        FeatureFlagRemoteDataAccess featureFlagRemoteDataAccess;
        RemoteDataInfo remoteDataInfo;
        FeatureFlagManager featureFlagManager2;
        RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo2;
        Throwable th;
        FeatureFlagRemoteDataAccess featureFlagRemoteDataAccess2;
        RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo3;
        FeatureFlagManager featureFlagManager3;
        Throwable th2;
        String str3;
        Object objM5097evaluate0E7RQCE2;
        FeatureFlagManager featureFlagManager4;
        Throwable thM5280exceptionOrNullimpl2;
        if (continuation instanceof FeatureFlagManager$resolveFlag$1) {
            featureFlagManager$resolveFlag$1 = (FeatureFlagManager$resolveFlag$1) continuation;
            int i = featureFlagManager$resolveFlag$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                featureFlagManager$resolveFlag$1.label = i - Integer.MIN_VALUE;
            } else {
                featureFlagManager$resolveFlag$1 = new FeatureFlagManager$resolveFlag$1(this, continuation);
            }
        } else {
            featureFlagManager$resolveFlag$1 = new FeatureFlagManager$resolveFlag$1(this, continuation);
        }
        Object obj = featureFlagManager$resolveFlag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = featureFlagManager$resolveFlag$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            featureFlagManager$resolveFlag$1.L$0 = this;
            featureFlagManager$resolveFlag$1.L$1 = str;
            featureFlagManager$resolveFlag$1.label = 1;
            objM5100remoteDataFeatureFlagInfogIAlus = m5100remoteDataFeatureFlagInfogIAlus(str, featureFlagManager$resolveFlag$1);
            if (objM5100remoteDataFeatureFlagInfogIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                str = (String) featureFlagManager$resolveFlag$1.L$1;
                this = (FeatureFlagManager) featureFlagManager$resolveFlag$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM5100remoteDataFeatureFlagInfogIAlus = ((Result) obj).getValue();
            } else if (i2 == 2) {
                remoteDataFeatureFlagInfo = (RemoteDataFeatureFlagInfo) featureFlagManager$resolveFlag$1.L$2;
                String str4 = (String) featureFlagManager$resolveFlag$1.L$1;
                FeatureFlagManager featureFlagManager5 = (FeatureFlagManager) featureFlagManager$resolveFlag$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM5097evaluate0E7RQCE = ((Result) obj).getValue();
                str2 = str4;
                featureFlagManager = featureFlagManager5;
                if (Result.m5283isSuccessimpl(objM5097evaluate0E7RQCE)) {
                    return objM5097evaluate0E7RQCE;
                }
                thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5097evaluate0E7RQCE);
                if (thM5280exceptionOrNullimpl instanceof FeatureFlagEvaluationException.OutOfDate) {
                    featureFlagRemoteDataAccess = featureFlagManager.remoteData;
                    remoteDataInfo = remoteDataFeatureFlagInfo.getRemoteDataInfo();
                    featureFlagManager$resolveFlag$1.L$0 = featureFlagManager;
                    featureFlagManager$resolveFlag$1.L$1 = str2;
                    featureFlagManager$resolveFlag$1.L$2 = remoteDataFeatureFlagInfo;
                    featureFlagManager$resolveFlag$1.L$3 = thM5280exceptionOrNullimpl;
                    featureFlagManager$resolveFlag$1.label = 3;
                    if (featureFlagRemoteDataAccess.notifyOutOfDate(remoteDataInfo, featureFlagManager$resolveFlag$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    featureFlagManager2 = featureFlagManager;
                    remoteDataFeatureFlagInfo2 = remoteDataFeatureFlagInfo;
                    th = thM5280exceptionOrNullimpl;
                    featureFlagRemoteDataAccess2 = featureFlagManager2.remoteData;
                    featureFlagManager$resolveFlag$1.L$0 = featureFlagManager2;
                    featureFlagManager$resolveFlag$1.L$1 = str2;
                    featureFlagManager$resolveFlag$1.L$2 = remoteDataFeatureFlagInfo2;
                    featureFlagManager$resolveFlag$1.L$3 = th;
                    featureFlagManager$resolveFlag$1.label = 4;
                    if (featureFlagRemoteDataAccess2.bestEffortRefresh(featureFlagManager$resolveFlag$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    remoteDataFeatureFlagInfo3 = remoteDataFeatureFlagInfo2;
                    featureFlagManager3 = featureFlagManager2;
                    th2 = th;
                    str3 = str2;
                    if (featureFlagManager3.remoteData.getStatus() != FeatureFlagRemoteDataStatus.UP_TO_DATE) {
                        Result.Companion companion = Result.INSTANCE;
                        return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager3.mapError(str3, th2)));
                    }
                    featureFlagManager$resolveFlag$1.L$0 = featureFlagManager3;
                    featureFlagManager$resolveFlag$1.L$1 = str3;
                    featureFlagManager$resolveFlag$1.L$2 = null;
                    featureFlagManager$resolveFlag$1.L$3 = null;
                    featureFlagManager$resolveFlag$1.label = 5;
                    objM5097evaluate0E7RQCE2 = featureFlagManager3.m5097evaluate0E7RQCE(str3, remoteDataFeatureFlagInfo3, featureFlagManager$resolveFlag$1);
                    if (objM5097evaluate0E7RQCE2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    featureFlagManager4 = featureFlagManager3;
                } else {
                    return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager.mapError(str2, thM5280exceptionOrNullimpl)));
                }
            } else if (i2 == 3) {
                th = (Throwable) featureFlagManager$resolveFlag$1.L$3;
                remoteDataFeatureFlagInfo2 = (RemoteDataFeatureFlagInfo) featureFlagManager$resolveFlag$1.L$2;
                str2 = (String) featureFlagManager$resolveFlag$1.L$1;
                featureFlagManager2 = (FeatureFlagManager) featureFlagManager$resolveFlag$1.L$0;
                ResultKt.throwOnFailure(obj);
                featureFlagRemoteDataAccess2 = featureFlagManager2.remoteData;
                featureFlagManager$resolveFlag$1.L$0 = featureFlagManager2;
                featureFlagManager$resolveFlag$1.L$1 = str2;
                featureFlagManager$resolveFlag$1.L$2 = remoteDataFeatureFlagInfo2;
                featureFlagManager$resolveFlag$1.L$3 = th;
                featureFlagManager$resolveFlag$1.label = 4;
                if (featureFlagRemoteDataAccess2.bestEffortRefresh(featureFlagManager$resolveFlag$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                remoteDataFeatureFlagInfo3 = remoteDataFeatureFlagInfo2;
                featureFlagManager3 = featureFlagManager2;
                th2 = th;
                str3 = str2;
                if (featureFlagManager3.remoteData.getStatus() != FeatureFlagRemoteDataStatus.UP_TO_DATE) {
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager3.mapError(str3, th2)));
                }
                featureFlagManager$resolveFlag$1.L$0 = featureFlagManager3;
                featureFlagManager$resolveFlag$1.L$1 = str3;
                featureFlagManager$resolveFlag$1.L$2 = null;
                featureFlagManager$resolveFlag$1.L$3 = null;
                featureFlagManager$resolveFlag$1.label = 5;
                objM5097evaluate0E7RQCE2 = featureFlagManager3.m5097evaluate0E7RQCE(str3, remoteDataFeatureFlagInfo3, featureFlagManager$resolveFlag$1);
                if (objM5097evaluate0E7RQCE2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                featureFlagManager4 = featureFlagManager3;
            } else if (i2 == 4) {
                th = (Throwable) featureFlagManager$resolveFlag$1.L$3;
                RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo4 = (RemoteDataFeatureFlagInfo) featureFlagManager$resolveFlag$1.L$2;
                str2 = (String) featureFlagManager$resolveFlag$1.L$1;
                featureFlagManager3 = (FeatureFlagManager) featureFlagManager$resolveFlag$1.L$0;
                ResultKt.throwOnFailure(obj);
                remoteDataFeatureFlagInfo3 = remoteDataFeatureFlagInfo4;
                th2 = th;
                str3 = str2;
                if (featureFlagManager3.remoteData.getStatus() != FeatureFlagRemoteDataStatus.UP_TO_DATE) {
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager3.mapError(str3, th2)));
                }
                featureFlagManager$resolveFlag$1.L$0 = featureFlagManager3;
                featureFlagManager$resolveFlag$1.L$1 = str3;
                featureFlagManager$resolveFlag$1.L$2 = null;
                featureFlagManager$resolveFlag$1.L$3 = null;
                featureFlagManager$resolveFlag$1.label = 5;
                objM5097evaluate0E7RQCE2 = featureFlagManager3.m5097evaluate0E7RQCE(str3, remoteDataFeatureFlagInfo3, featureFlagManager$resolveFlag$1);
                if (objM5097evaluate0E7RQCE2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                featureFlagManager4 = featureFlagManager3;
            } else {
                if (i2 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str3 = (String) featureFlagManager$resolveFlag$1.L$1;
                featureFlagManager4 = (FeatureFlagManager) featureFlagManager$resolveFlag$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM5097evaluate0E7RQCE2 = ((Result) obj).getValue();
            }
            thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5097evaluate0E7RQCE2);
            if (thM5280exceptionOrNullimpl2 != null) {
                return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager4.mapError(str3, thM5280exceptionOrNullimpl2)));
            }
            return objM5097evaluate0E7RQCE2;
        }
        RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo5 = (RemoteDataFeatureFlagInfo) (Result.m5282isFailureimpl(objM5100remoteDataFeatureFlagInfogIAlus) ? null : objM5100remoteDataFeatureFlagInfogIAlus);
        if (Result.m5282isFailureimpl(objM5100remoteDataFeatureFlagInfogIAlus) || remoteDataFeatureFlagInfo5 == null) {
            return Result.m5277constructorimpl(ResultKt.createFailure(this.mapError(str, Result.m5280exceptionOrNullimpl(objM5100remoteDataFeatureFlagInfogIAlus))));
        }
        featureFlagManager$resolveFlag$1.L$0 = this;
        featureFlagManager$resolveFlag$1.L$1 = str;
        featureFlagManager$resolveFlag$1.L$2 = remoteDataFeatureFlagInfo5;
        featureFlagManager$resolveFlag$1.label = 2;
        objM5097evaluate0E7RQCE = this.m5097evaluate0E7RQCE(str, remoteDataFeatureFlagInfo5, featureFlagManager$resolveFlag$1);
        if (objM5097evaluate0E7RQCE == coroutine_suspended) {
            return coroutine_suspended;
        }
        String str5 = str;
        featureFlagManager = this;
        remoteDataFeatureFlagInfo = remoteDataFeatureFlagInfo5;
        str2 = str5;
        if (Result.m5283isSuccessimpl(objM5097evaluate0E7RQCE)) {
            return objM5097evaluate0E7RQCE;
        }
        thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5097evaluate0E7RQCE);
        if (thM5280exceptionOrNullimpl instanceof FeatureFlagEvaluationException.OutOfDate) {
            featureFlagRemoteDataAccess = featureFlagManager.remoteData;
            remoteDataInfo = remoteDataFeatureFlagInfo.getRemoteDataInfo();
            featureFlagManager$resolveFlag$1.L$0 = featureFlagManager;
            featureFlagManager$resolveFlag$1.L$1 = str2;
            featureFlagManager$resolveFlag$1.L$2 = remoteDataFeatureFlagInfo;
            featureFlagManager$resolveFlag$1.L$3 = thM5280exceptionOrNullimpl;
            featureFlagManager$resolveFlag$1.label = 3;
            if (featureFlagRemoteDataAccess.notifyOutOfDate(remoteDataInfo, featureFlagManager$resolveFlag$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            featureFlagManager2 = featureFlagManager;
            remoteDataFeatureFlagInfo2 = remoteDataFeatureFlagInfo;
            th = thM5280exceptionOrNullimpl;
            featureFlagRemoteDataAccess2 = featureFlagManager2.remoteData;
            featureFlagManager$resolveFlag$1.L$0 = featureFlagManager2;
            featureFlagManager$resolveFlag$1.L$1 = str2;
            featureFlagManager$resolveFlag$1.L$2 = remoteDataFeatureFlagInfo2;
            featureFlagManager$resolveFlag$1.L$3 = th;
            featureFlagManager$resolveFlag$1.label = 4;
            if (featureFlagRemoteDataAccess2.bestEffortRefresh(featureFlagManager$resolveFlag$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            remoteDataFeatureFlagInfo3 = remoteDataFeatureFlagInfo2;
            featureFlagManager3 = featureFlagManager2;
            th2 = th;
            str3 = str2;
            if (featureFlagManager3.remoteData.getStatus() != FeatureFlagRemoteDataStatus.UP_TO_DATE) {
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager3.mapError(str3, th2)));
            }
            featureFlagManager$resolveFlag$1.L$0 = featureFlagManager3;
            featureFlagManager$resolveFlag$1.L$1 = str3;
            featureFlagManager$resolveFlag$1.L$2 = null;
            featureFlagManager$resolveFlag$1.L$3 = null;
            featureFlagManager$resolveFlag$1.label = 5;
            objM5097evaluate0E7RQCE2 = featureFlagManager3.m5097evaluate0E7RQCE(str3, remoteDataFeatureFlagInfo3, featureFlagManager$resolveFlag$1);
            if (objM5097evaluate0E7RQCE2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            featureFlagManager4 = featureFlagManager3;
            thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5097evaluate0E7RQCE2);
            if (thM5280exceptionOrNullimpl2 != null) {
                return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager4.mapError(str3, thM5280exceptionOrNullimpl2)));
            }
            return objM5097evaluate0E7RQCE2;
        }
        return Result.m5277constructorimpl(ResultKt.createFailure(featureFlagManager.mapError(str2, thM5280exceptionOrNullimpl)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x0099  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:49:0x00db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: remoteDataFeatureFlagInfo-gIAlu-s, reason: not valid java name */
    public final Object m5100remoteDataFeatureFlagInfogIAlus(String str, Continuation continuation) {
        FeatureFlagManager$remoteDataFeatureFlagInfo$1 featureFlagManager$remoteDataFeatureFlagInfo$1;
        RemoteDataFeatureFlagInfo remoteDataFeatureFlagInfo;
        Iterator<T> it;
        Object next;
        FeatureFlagRemoteDataAccess featureFlagRemoteDataAccess;
        FeatureFlagManager featureFlagManager;
        String str2;
        EvaluationOptions evaluationOptions;
        boolean zAreEqual;
        if (continuation instanceof FeatureFlagManager$remoteDataFeatureFlagInfo$1) {
            featureFlagManager$remoteDataFeatureFlagInfo$1 = (FeatureFlagManager$remoteDataFeatureFlagInfo$1) continuation;
            int i = featureFlagManager$remoteDataFeatureFlagInfo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                featureFlagManager$remoteDataFeatureFlagInfo$1.label = i - Integer.MIN_VALUE;
            } else {
                featureFlagManager$remoteDataFeatureFlagInfo$1 = new FeatureFlagManager$remoteDataFeatureFlagInfo$1(this, continuation);
            }
        } else {
            featureFlagManager$remoteDataFeatureFlagInfo$1 = new FeatureFlagManager$remoteDataFeatureFlagInfo$1(this, continuation);
        }
        Object objFetchFlagRemoteInfo = featureFlagManager$remoteDataFeatureFlagInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = featureFlagManager$remoteDataFeatureFlagInfo$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(objFetchFlagRemoteInfo);
                return Result.m5277constructorimpl(objFetchFlagRemoteInfo);
            }
            if (i2 == 2) {
                str = (String) featureFlagManager$remoteDataFeatureFlagInfo$1.L$1;
                this = (FeatureFlagManager) featureFlagManager$remoteDataFeatureFlagInfo$1.L$0;
                ResultKt.throwOnFailure(objFetchFlagRemoteInfo);
                remoteDataFeatureFlagInfo = (RemoteDataFeatureFlagInfo) objFetchFlagRemoteInfo;
                it = remoteDataFeatureFlagInfo.getFlagInfoList().iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    evaluationOptions = ((FeatureFlagInfo) next).getEvaluationOptions();
                    if (evaluationOptions != null) {
                        zAreEqual = Intrinsics.areEqual(evaluationOptions.getDisallowStaleValues(), Boxing.boxBoolean(true));
                    } else {
                        zAreEqual = false;
                    }
                } while (!zAreEqual);
                boolean z = next != null;
                if (!remoteDataFeatureFlagInfo.getFlagInfoList().isEmpty() || z) {
                    featureFlagRemoteDataAccess = this.remoteData;
                    featureFlagManager$remoteDataFeatureFlagInfo$1.L$0 = this;
                    featureFlagManager$remoteDataFeatureFlagInfo$1.L$1 = str;
                    featureFlagManager$remoteDataFeatureFlagInfo$1.label = 3;
                    if (featureFlagRemoteDataAccess.bestEffortRefresh(featureFlagManager$remoteDataFeatureFlagInfo$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str3 = str;
                    featureFlagManager = this;
                    str2 = str3;
                } else {
                    return Result.m5277constructorimpl(remoteDataFeatureFlagInfo);
                }
            } else if (i2 == 3) {
                str2 = (String) featureFlagManager$remoteDataFeatureFlagInfo$1.L$1;
                featureFlagManager = (FeatureFlagManager) featureFlagManager$remoteDataFeatureFlagInfo$1.L$0;
                ResultKt.throwOnFailure(objFetchFlagRemoteInfo);
            } else {
                if (i2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objFetchFlagRemoteInfo);
            }
            return Result.m5277constructorimpl(objFetchFlagRemoteInfo);
        }
        ResultKt.throwOnFailure(objFetchFlagRemoteInfo);
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.remoteData.getStatus().ordinal()];
        if (i3 == 1) {
            Result.Companion companion = Result.INSTANCE;
            FeatureFlagRemoteDataAccess featureFlagRemoteDataAccess2 = this.remoteData;
            featureFlagManager$remoteDataFeatureFlagInfo$1.label = 1;
            objFetchFlagRemoteInfo = featureFlagRemoteDataAccess2.fetchFlagRemoteInfo(str, featureFlagManager$remoteDataFeatureFlagInfo$1);
            if (objFetchFlagRemoteInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Result.m5277constructorimpl(objFetchFlagRemoteInfo);
        }
        if (i3 == 2 || i3 == 3) {
            FeatureFlagRemoteDataAccess featureFlagRemoteDataAccess3 = this.remoteData;
            featureFlagManager$remoteDataFeatureFlagInfo$1.L$0 = this;
            featureFlagManager$remoteDataFeatureFlagInfo$1.L$1 = str;
            featureFlagManager$remoteDataFeatureFlagInfo$1.label = 2;
            objFetchFlagRemoteInfo = featureFlagRemoteDataAccess3.fetchFlagRemoteInfo(str, featureFlagManager$remoteDataFeatureFlagInfo$1);
            if (objFetchFlagRemoteInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            remoteDataFeatureFlagInfo = (RemoteDataFeatureFlagInfo) objFetchFlagRemoteInfo;
            it = remoteDataFeatureFlagInfo.getFlagInfoList().iterator();
            do {
                if (it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                evaluationOptions = ((FeatureFlagInfo) next).getEvaluationOptions();
                if (evaluationOptions != null) {
                    zAreEqual = Intrinsics.areEqual(evaluationOptions.getDisallowStaleValues(), Boxing.boxBoolean(true));
                } else {
                    zAreEqual = false;
                }
            } while (!zAreEqual);
            if (next != null) {
            }
            if (!remoteDataFeatureFlagInfo.getFlagInfoList().isEmpty()) {
            }
            featureFlagRemoteDataAccess = this.remoteData;
            featureFlagManager$remoteDataFeatureFlagInfo$1.L$0 = this;
            featureFlagManager$remoteDataFeatureFlagInfo$1.L$1 = str;
            featureFlagManager$remoteDataFeatureFlagInfo$1.label = 3;
            if (featureFlagRemoteDataAccess.bestEffortRefresh(featureFlagManager$remoteDataFeatureFlagInfo$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            String str4 = str;
            featureFlagManager = this;
            str2 = str4;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[featureFlagManager.remoteData.getStatus().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.StaleNotAllowed()));
            }
            if (i4 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m5277constructorimpl(ResultKt.createFailure(new FeatureFlagEvaluationException.OutOfDate()));
        }
        Result.Companion companion4 = Result.INSTANCE;
        FeatureFlagRemoteDataAccess featureFlagRemoteDataAccess4 = featureFlagManager.remoteData;
        featureFlagManager$remoteDataFeatureFlagInfo$1.L$0 = null;
        featureFlagManager$remoteDataFeatureFlagInfo$1.L$1 = null;
        featureFlagManager$remoteDataFeatureFlagInfo$1.label = 4;
        objFetchFlagRemoteInfo = featureFlagRemoteDataAccess4.fetchFlagRemoteInfo(str2, featureFlagManager$remoteDataFeatureFlagInfo$1);
        if (objFetchFlagRemoteInfo == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Result.m5277constructorimpl(objFetchFlagRemoteInfo);
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
    /* JADX WARN: Code duplicated, block: B:23:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:26:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:29:0x012a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x012b  */
    /* JADX WARN: Code duplicated, block: B:33:0x013f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0141  */
    /* JADX WARN: Code duplicated, block: B:37:0x0148 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:41:0x015c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0181 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0182  */
    /* JADX WARN: Code duplicated, block: B:46:0x0196  */
    /* JADX WARN: Code duplicated, block: B:48:0x019d  */
    /* JADX WARN: Code duplicated, block: B:50:0x01c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:55:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:57:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:61:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x021c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x014a -> B:21:0x00db). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01c8 -> B:52:0x01d1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: evaluate-0E7RQCE, reason: not valid java name */
    public final java.lang.Object m5097evaluate0E7RQCE(java.lang.String r23, com.urbanairship.featureflag.RemoteDataFeatureFlagInfo r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instruction units count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManager.m5097evaluate0E7RQCE(java.lang.String, com.urbanairship.featureflag.RemoteDataFeatureFlagInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: evaluatedControl-3t6e044, reason: not valid java name */
    public final Object m5098evaluatedControl3t6e044(Object obj, FeatureFlagInfo featureFlagInfo, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        FeatureFlagManager$evaluatedControl$1 featureFlagManager$evaluatedControl$1;
        Object obj2;
        ControlOptions controlOptions;
        FeatureFlag featureFlag;
        FeatureFlag featureFlagCopyWith$urbanairship_feature_flag_release$default;
        if (continuation instanceof FeatureFlagManager$evaluatedControl$1) {
            featureFlagManager$evaluatedControl$1 = (FeatureFlagManager$evaluatedControl$1) continuation;
            int i = featureFlagManager$evaluatedControl$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                featureFlagManager$evaluatedControl$1.label = i - Integer.MIN_VALUE;
            } else {
                featureFlagManager$evaluatedControl$1 = new FeatureFlagManager$evaluatedControl$1(this, continuation);
            }
        } else {
            featureFlagManager$evaluatedControl$1 = new FeatureFlagManager$evaluatedControl$1(this, continuation);
        }
        FeatureFlagManager$evaluatedControl$1 featureFlagManager$evaluatedControl$2 = featureFlagManager$evaluatedControl$1;
        Object obj3 = featureFlagManager$evaluatedControl$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = featureFlagManager$evaluatedControl$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            ControlOptions controlOptions2 = featureFlagInfo.getControlOptions();
            if (controlOptions2 == null) {
                return obj;
            }
            FeatureFlag featureFlag2 = (FeatureFlag) (Result.m5282isFailureimpl(obj) ? null : obj);
            if (featureFlag2 == null || !featureFlag2.getIsEligible()) {
                return obj;
            }
            AudienceEvaluator audienceEvaluator = this.audienceEvaluator;
            FeatureFlagCompoundAudience compoundAudience = controlOptions2.getCompoundAudience();
            CompoundAudienceSelector selector = compoundAudience != null ? compoundAudience.getSelector() : null;
            long created = featureFlagInfo.getCreated();
            featureFlagManager$evaluatedControl$2.L$0 = obj;
            featureFlagManager$evaluatedControl$2.L$1 = controlOptions2;
            featureFlagManager$evaluatedControl$2.L$2 = featureFlag2;
            featureFlagManager$evaluatedControl$2.label = 1;
            Object objEvaluate = audienceEvaluator.evaluate(selector, created, deviceInfoProvider, featureFlagManager$evaluatedControl$2);
            if (objEvaluate == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = obj;
            controlOptions = controlOptions2;
            obj3 = objEvaluate;
            featureFlag = featureFlag2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            featureFlag = (FeatureFlag) featureFlagManager$evaluatedControl$2.L$2;
            controlOptions = (ControlOptions) featureFlagManager$evaluatedControl$2.L$1;
            obj2 = featureFlagManager$evaluatedControl$2.L$0;
            ResultKt.throwOnFailure(obj3);
        }
        if (!((AirshipDeviceAudienceResult) obj3).isMatch()) {
            return obj2;
        }
        ControlOptions.Type controlType = controlOptions.getControlType();
        if (Intrinsics.areEqual(controlType, ControlOptions.Type.Flag.INSTANCE)) {
            featureFlagCopyWith$urbanairship_feature_flag_release$default = FeatureFlag.copyWith$urbanairship_feature_flag_release$default(featureFlag, Boxing.boxBoolean(false), null, 2, null);
        } else {
            if (!(controlType instanceof ControlOptions.Type.Variables)) {
                throw new NoWhenBranchMatchedException();
            }
            featureFlagCopyWith$urbanairship_feature_flag_release$default = FeatureFlag.copyWith$urbanairship_feature_flag_release$default(featureFlag, null, ((ControlOptions.Type.Variables) controlType).getData(), 1, null);
        }
        FeatureFlag.ReportingInfo reportingInfo = featureFlagCopyWith$urbanairship_feature_flag_release$default.getReportingInfo();
        if (reportingInfo != null) {
            reportingInfo.addSuperseded(reportingInfo.getReportingMetadata());
            reportingInfo.setReportingMetadata(controlOptions.getReportingMetadata());
        }
        return Result.m5277constructorimpl(featureFlagCopyWith$urbanairship_feature_flag_release$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:38:0x0103 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0104  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: resolveStatic-yxL6bBk, reason: not valid java name */
    public final Object m5103resolveStaticyxL6bBk(FeatureFlagInfo featureFlagInfo, boolean z, FeatureFlagPayload.StaticPayload staticPayload, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        FeatureFlagManager$resolveStatic$1 featureFlagManager$resolveStatic$1;
        FeatureFlagInfo featureFlagInfo2;
        boolean z2;
        DeviceInfoProvider deviceInfoProvider2;
        VariableResult variableResult;
        Object objEvaluate;
        FeatureFlag.Companion companion;
        String name;
        JsonMap data;
        JsonMap reportingContext;
        Object channelId;
        DeviceInfoProvider deviceInfoProvider3;
        String str;
        JsonMap jsonMap;
        boolean z3;
        String str2;
        Object stableContactInfo;
        JsonMap jsonMap2;
        String str3;
        String str4;
        FeatureFlag.Companion companion2;
        JsonMap jsonMap3;
        if (continuation instanceof FeatureFlagManager$resolveStatic$1) {
            featureFlagManager$resolveStatic$1 = (FeatureFlagManager$resolveStatic$1) continuation;
            int i = featureFlagManager$resolveStatic$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                featureFlagManager$resolveStatic$1.label = i - Integer.MIN_VALUE;
            } else {
                featureFlagManager$resolveStatic$1 = new FeatureFlagManager$resolveStatic$1(this, continuation);
            }
        } else {
            featureFlagManager$resolveStatic$1 = new FeatureFlagManager$resolveStatic$1(this, continuation);
        }
        Object obj = featureFlagManager$resolveStatic$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = featureFlagManager$resolveStatic$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            FeatureFlagVariables variables = staticPayload.getVariables();
            if (variables != null) {
                AudienceEvaluator audienceEvaluator = this.audienceEvaluator;
                long created = featureFlagInfo.getCreated();
                featureFlagInfo2 = featureFlagInfo;
                featureFlagManager$resolveStatic$1.L$0 = featureFlagInfo2;
                deviceInfoProvider2 = deviceInfoProvider;
                featureFlagManager$resolveStatic$1.L$1 = deviceInfoProvider2;
                z2 = z;
                featureFlagManager$resolveStatic$1.Z$0 = z2;
                featureFlagManager$resolveStatic$1.label = 1;
                objEvaluate = FeatureFlagManagerKt.evaluate(variables, z, audienceEvaluator, created, deviceInfoProvider, featureFlagManager$resolveStatic$1);
                if (objEvaluate == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                featureFlagInfo2 = featureFlagInfo;
                z2 = z;
                deviceInfoProvider2 = deviceInfoProvider;
                variableResult = null;
            }
            companion = FeatureFlag.INSTANCE;
            name = featureFlagInfo2.getName();
            data = variableResult != null ? variableResult.getData() : null;
            if (variableResult != null || (reportingContext = variableResult.getReportingMetadata()) == null) {
                reportingContext = featureFlagInfo2.getReportingContext();
            }
            featureFlagManager$resolveStatic$1.L$0 = deviceInfoProvider2;
            featureFlagManager$resolveStatic$1.L$1 = companion;
            featureFlagManager$resolveStatic$1.L$2 = name;
            featureFlagManager$resolveStatic$1.L$3 = data;
            featureFlagManager$resolveStatic$1.L$4 = reportingContext;
            featureFlagManager$resolveStatic$1.Z$0 = z2;
            featureFlagManager$resolveStatic$1.label = 2;
            channelId = deviceInfoProvider2.getChannelId(featureFlagManager$resolveStatic$1);
            if (channelId == coroutine_suspended) {
                return coroutine_suspended;
            }
            deviceInfoProvider3 = deviceInfoProvider2;
            str = name;
            jsonMap = data;
            obj = channelId;
            z3 = z2;
            str2 = (String) obj;
            featureFlagManager$resolveStatic$1.L$0 = companion;
            featureFlagManager$resolveStatic$1.L$1 = str;
            featureFlagManager$resolveStatic$1.L$2 = jsonMap;
            featureFlagManager$resolveStatic$1.L$3 = reportingContext;
            featureFlagManager$resolveStatic$1.L$4 = str2;
            featureFlagManager$resolveStatic$1.Z$0 = z3;
            featureFlagManager$resolveStatic$1.label = 3;
            stableContactInfo = deviceInfoProvider3.getStableContactInfo(featureFlagManager$resolveStatic$1);
            if (stableContactInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            jsonMap2 = jsonMap;
            str3 = str;
            str4 = str2;
            obj = stableContactInfo;
            companion2 = companion;
            jsonMap3 = reportingContext;
            return Result.m5277constructorimpl(companion2.createFlag$urbanairship_feature_flag_release(str3, z3, new FeatureFlag.ReportingInfo(jsonMap3, null, str4, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap2));
        }
        if (i2 == 1) {
            boolean z4 = featureFlagManager$resolveStatic$1.Z$0;
            DeviceInfoProvider deviceInfoProvider4 = (DeviceInfoProvider) featureFlagManager$resolveStatic$1.L$1;
            FeatureFlagInfo featureFlagInfo3 = (FeatureFlagInfo) featureFlagManager$resolveStatic$1.L$0;
            ResultKt.throwOnFailure(obj);
            z2 = z4;
            featureFlagInfo2 = featureFlagInfo3;
            objEvaluate = obj;
            deviceInfoProvider2 = deviceInfoProvider4;
        } else if (i2 == 2) {
            z3 = featureFlagManager$resolveStatic$1.Z$0;
            reportingContext = (JsonMap) featureFlagManager$resolveStatic$1.L$4;
            JsonMap jsonMap4 = (JsonMap) featureFlagManager$resolveStatic$1.L$3;
            String str5 = (String) featureFlagManager$resolveStatic$1.L$2;
            FeatureFlag.Companion companion3 = (FeatureFlag.Companion) featureFlagManager$resolveStatic$1.L$1;
            deviceInfoProvider3 = (DeviceInfoProvider) featureFlagManager$resolveStatic$1.L$0;
            ResultKt.throwOnFailure(obj);
            jsonMap = jsonMap4;
            companion = companion3;
            str = str5;
            str2 = (String) obj;
            featureFlagManager$resolveStatic$1.L$0 = companion;
            featureFlagManager$resolveStatic$1.L$1 = str;
            featureFlagManager$resolveStatic$1.L$2 = jsonMap;
            featureFlagManager$resolveStatic$1.L$3 = reportingContext;
            featureFlagManager$resolveStatic$1.L$4 = str2;
            featureFlagManager$resolveStatic$1.Z$0 = z3;
            featureFlagManager$resolveStatic$1.label = 3;
            stableContactInfo = deviceInfoProvider3.getStableContactInfo(featureFlagManager$resolveStatic$1);
            if (stableContactInfo == coroutine_suspended) {
                return coroutine_suspended;
            }
            jsonMap2 = jsonMap;
            str3 = str;
            str4 = str2;
            obj = stableContactInfo;
            companion2 = companion;
            jsonMap3 = reportingContext;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z3 = featureFlagManager$resolveStatic$1.Z$0;
            String str6 = (String) featureFlagManager$resolveStatic$1.L$4;
            jsonMap3 = (JsonMap) featureFlagManager$resolveStatic$1.L$3;
            JsonMap jsonMap5 = (JsonMap) featureFlagManager$resolveStatic$1.L$2;
            String str7 = (String) featureFlagManager$resolveStatic$1.L$1;
            companion2 = (FeatureFlag.Companion) featureFlagManager$resolveStatic$1.L$0;
            ResultKt.throwOnFailure(obj);
            jsonMap2 = jsonMap5;
            str3 = str7;
            str4 = str6;
        }
        return Result.m5277constructorimpl(companion2.createFlag$urbanairship_feature_flag_release(str3, z3, new FeatureFlag.ReportingInfo(jsonMap3, null, str4, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap2));
        variableResult = (VariableResult) objEvaluate;
        companion = FeatureFlag.INSTANCE;
        name = featureFlagInfo2.getName();
        if (variableResult != null) {
        }
        if (variableResult != null) {
            reportingContext = featureFlagInfo2.getReportingContext();
        } else {
            reportingContext = featureFlagInfo2.getReportingContext();
        }
        featureFlagManager$resolveStatic$1.L$0 = deviceInfoProvider2;
        featureFlagManager$resolveStatic$1.L$1 = companion;
        featureFlagManager$resolveStatic$1.L$2 = name;
        featureFlagManager$resolveStatic$1.L$3 = data;
        featureFlagManager$resolveStatic$1.L$4 = reportingContext;
        featureFlagManager$resolveStatic$1.Z$0 = z2;
        featureFlagManager$resolveStatic$1.label = 2;
        channelId = deviceInfoProvider2.getChannelId(featureFlagManager$resolveStatic$1);
        if (channelId == coroutine_suspended) {
            return coroutine_suspended;
        }
        deviceInfoProvider3 = deviceInfoProvider2;
        str = name;
        jsonMap = data;
        obj = channelId;
        z3 = z2;
        str2 = (String) obj;
        featureFlagManager$resolveStatic$1.L$0 = companion;
        featureFlagManager$resolveStatic$1.L$1 = str;
        featureFlagManager$resolveStatic$1.L$2 = jsonMap;
        featureFlagManager$resolveStatic$1.L$3 = reportingContext;
        featureFlagManager$resolveStatic$1.L$4 = str2;
        featureFlagManager$resolveStatic$1.Z$0 = z3;
        featureFlagManager$resolveStatic$1.label = 3;
        stableContactInfo = deviceInfoProvider3.getStableContactInfo(featureFlagManager$resolveStatic$1);
        if (stableContactInfo == coroutine_suspended) {
            return coroutine_suspended;
        }
        jsonMap2 = jsonMap;
        str3 = str;
        str4 = str2;
        obj = stableContactInfo;
        companion2 = companion;
        jsonMap3 = reportingContext;
        return Result.m5277constructorimpl(companion2.createFlag$urbanairship_feature_flag_release(str3, z3, new FeatureFlag.ReportingInfo(jsonMap3, null, str4, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0148 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0149  */
    /* JADX WARN: Code duplicated, block: B:38:0x019e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x019f  */
    /* JADX WARN: Code duplicated, block: B:42:0x01de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x01df  */
    /* JADX WARN: Code duplicated, block: B:46:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:48:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:50:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:52:0x021c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x021d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0229  */
    /* JADX WARN: Code duplicated, block: B:58:0x023e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0244  */
    /* JADX WARN: Code duplicated, block: B:62:0x024a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0267 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x0268  */
    /* JADX WARN: Code duplicated, block: B:69:0x0288 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x0289  */
    /* JADX WARN: Code duplicated, block: B:72:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:74:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:76:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:78:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX INFO: renamed from: resolveDeferred-yxL6bBk, reason: not valid java name */
    public final Object m5101resolveDeferredyxL6bBk(FeatureFlagInfo featureFlagInfo, boolean z, FeatureFlagPayload.DeferredPayload deferredPayload, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        FeatureFlagManager$resolveDeferred$1 featureFlagManager$resolveDeferred$1;
        FeatureFlagInfo featureFlagInfo2;
        Object stableContactInfo;
        DeviceInfoProvider deviceInfoProvider2;
        FeatureFlagPayload.DeferredPayload deferredPayload2;
        FeatureFlag.Companion companion;
        JsonMap jsonMap;
        String str;
        String str2;
        Object stableContactInfo2;
        JsonMap jsonMap2;
        String str3;
        FeatureFlag.Companion companion2;
        String str4;
        String contactId;
        Object channelId;
        String str5;
        FeatureFlagInfo featureFlagInfo3;
        FeatureFlagPayload.DeferredPayload deferredPayload3;
        DeviceInfoProvider deviceInfoProvider3;
        Object objM5111resolve0E7RQCE;
        FeatureFlagManager featureFlagManager;
        FeatureFlagInfo featureFlagInfo4;
        Throwable thM5280exceptionOrNullimpl;
        DeferredFlag deferredFlag;
        FeatureFlag featureFlagCreateMissingFlag$urbanairship_feature_flag_release;
        DeferredFlag.Found found;
        FeatureFlagVariables variables;
        DeviceInfoProvider deviceInfoProvider4;
        DeferredFlag deferredFlag2;
        VariableResult variableResult;
        Object objEvaluate;
        FeatureFlagInfo featureFlagInfo5;
        DeferredFlag deferredFlag3;
        FeatureFlag.Companion companion3;
        String name;
        DeferredFlag.Found found2;
        boolean zIsEligible;
        JsonMap data;
        JsonMap reportingMetadata;
        Object channelId2;
        String str6;
        boolean z2;
        JsonMap jsonMap3;
        JsonMap jsonMap4;
        String str7;
        Object stableContactInfo3;
        FeatureFlag.Companion companion4;
        JsonMap jsonMap5;
        String str8;
        String str9;
        JsonMap jsonMap6;
        FeatureFlagManager featureFlagManager2 = this;
        DeviceInfoProvider deviceInfoProvider5 = deviceInfoProvider;
        if (continuation instanceof FeatureFlagManager$resolveDeferred$1) {
            featureFlagManager$resolveDeferred$1 = (FeatureFlagManager$resolveDeferred$1) continuation;
            int i = featureFlagManager$resolveDeferred$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                featureFlagManager$resolveDeferred$1.label = i - Integer.MIN_VALUE;
            } else {
                featureFlagManager$resolveDeferred$1 = new FeatureFlagManager$resolveDeferred$1(featureFlagManager2, continuation);
            }
        } else {
            featureFlagManager$resolveDeferred$1 = new FeatureFlagManager$resolveDeferred$1(featureFlagManager2, continuation);
        }
        Object obj = featureFlagManager$resolveDeferred$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (featureFlagManager$resolveDeferred$1.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (!z) {
                    Result.Companion companion5 = Result.INSTANCE;
                    FeatureFlag.Companion companion6 = FeatureFlag.INSTANCE;
                    String name2 = featureFlagInfo.getName();
                    JsonMap reportingContext = featureFlagInfo.getReportingContext();
                    featureFlagManager$resolveDeferred$1.L$0 = deviceInfoProvider5;
                    featureFlagManager$resolveDeferred$1.L$1 = companion6;
                    featureFlagManager$resolveDeferred$1.L$2 = name2;
                    featureFlagManager$resolveDeferred$1.L$3 = reportingContext;
                    featureFlagManager$resolveDeferred$1.label = 1;
                    Object channelId3 = deviceInfoProvider5.getChannelId(featureFlagManager$resolveDeferred$1);
                    if (channelId3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    companion = companion6;
                    jsonMap = reportingContext;
                    str = name2;
                    obj = channelId3;
                    str2 = (String) obj;
                    featureFlagManager$resolveDeferred$1.L$0 = companion;
                    featureFlagManager$resolveDeferred$1.L$1 = str;
                    featureFlagManager$resolveDeferred$1.L$2 = jsonMap;
                    featureFlagManager$resolveDeferred$1.L$3 = str2;
                    featureFlagManager$resolveDeferred$1.label = 2;
                    stableContactInfo2 = deviceInfoProvider5.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                    if (stableContactInfo2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jsonMap2 = jsonMap;
                    str3 = str2;
                    companion2 = companion;
                    str4 = str;
                    obj = stableContactInfo2;
                    return Result.m5277constructorimpl(companion2.createFlag$urbanairship_feature_flag_release(str4, false, new FeatureFlag.ReportingInfo(jsonMap2, null, str3, ((StableContactInfo) obj).getContactId(), 2, null), null));
                }
                featureFlagManager$resolveDeferred$1.L$0 = featureFlagManager2;
                featureFlagInfo2 = featureFlagInfo;
                featureFlagManager$resolveDeferred$1.L$1 = featureFlagInfo2;
                featureFlagManager$resolveDeferred$1.L$2 = deferredPayload;
                featureFlagManager$resolveDeferred$1.L$3 = deviceInfoProvider5;
                featureFlagManager$resolveDeferred$1.label = 3;
                stableContactInfo = deviceInfoProvider5.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                if (stableContactInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deviceInfoProvider2 = deviceInfoProvider5;
                deferredPayload2 = deferredPayload;
                contactId = ((StableContactInfo) stableContactInfo).getContactId();
                featureFlagManager$resolveDeferred$1.L$0 = featureFlagManager2;
                featureFlagManager$resolveDeferred$1.L$1 = featureFlagInfo2;
                featureFlagManager$resolveDeferred$1.L$2 = deferredPayload2;
                featureFlagManager$resolveDeferred$1.L$3 = deviceInfoProvider2;
                featureFlagManager$resolveDeferred$1.L$4 = contactId;
                featureFlagManager$resolveDeferred$1.label = 4;
                channelId = deviceInfoProvider2.getChannelId(featureFlagManager$resolveDeferred$1);
                if (channelId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = contactId;
                featureFlagInfo3 = featureFlagInfo2;
                obj = channelId;
                DeviceInfoProvider deviceInfoProvider6 = deviceInfoProvider2;
                deferredPayload3 = deferredPayload2;
                deviceInfoProvider3 = deviceInfoProvider6;
                DeferredRequest deferredRequest = new DeferredRequest(deferredPayload3.getUrl(), (String) obj, str5, null, deviceInfoProvider3.getLocale(), deviceInfoProvider3.isNotificationsOptedIn(), deviceInfoProvider3.getAppVersionName(), null, 136, null);
                FlagDeferredResolver flagDeferredResolver = featureFlagManager2.deferredResolver;
                featureFlagManager$resolveDeferred$1.L$0 = featureFlagManager2;
                featureFlagManager$resolveDeferred$1.L$1 = featureFlagInfo3;
                featureFlagManager$resolveDeferred$1.L$2 = deviceInfoProvider3;
                featureFlagManager$resolveDeferred$1.L$3 = null;
                featureFlagManager$resolveDeferred$1.L$4 = null;
                featureFlagManager$resolveDeferred$1.label = 5;
                objM5111resolve0E7RQCE = flagDeferredResolver.m5111resolve0E7RQCE(deferredRequest, featureFlagInfo3, featureFlagManager$resolveDeferred$1);
                if (objM5111resolve0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                featureFlagManager = featureFlagManager2;
                featureFlagInfo4 = featureFlagInfo3;
                thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5111resolve0E7RQCE);
                if (thM5280exceptionOrNullimpl == null) {
                    return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl));
                }
                deferredFlag = (DeferredFlag) objM5111resolve0E7RQCE;
                if (deferredFlag instanceof DeferredFlag.Found) {
                    found = (DeferredFlag.Found) deferredFlag;
                    variables = found.getFlagInfo().getVariables();
                    if (variables != null) {
                        boolean zIsEligible2 = found.getFlagInfo().isEligible();
                        AudienceEvaluator audienceEvaluator = featureFlagManager.audienceEvaluator;
                        long created = featureFlagInfo4.getCreated();
                        featureFlagManager$resolveDeferred$1.L$0 = featureFlagInfo4;
                        featureFlagManager$resolveDeferred$1.L$1 = deviceInfoProvider3;
                        featureFlagManager$resolveDeferred$1.L$2 = deferredFlag;
                        featureFlagManager$resolveDeferred$1.label = 6;
                        objEvaluate = FeatureFlagManagerKt.evaluate(variables, zIsEligible2, audienceEvaluator, created, deviceInfoProvider3, featureFlagManager$resolveDeferred$1);
                        if (objEvaluate == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        featureFlagInfo5 = featureFlagInfo4;
                        deferredFlag3 = deferredFlag;
                        obj = objEvaluate;
                        variableResult = (VariableResult) obj;
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag3;
                        featureFlagInfo4 = featureFlagInfo5;
                    } else {
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag;
                        variableResult = null;
                    }
                    companion3 = FeatureFlag.INSTANCE;
                    name = featureFlagInfo4.getName();
                    found2 = (DeferredFlag.Found) deferredFlag2;
                    zIsEligible = found2.getFlagInfo().isEligible();
                    data = variableResult != null ? variableResult.getData() : null;
                    if (variableResult != null || (reportingMetadata = variableResult.getReportingMetadata()) == null) {
                        reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                    }
                    featureFlagManager$resolveDeferred$1.L$0 = deviceInfoProvider4;
                    featureFlagManager$resolveDeferred$1.L$1 = companion3;
                    featureFlagManager$resolveDeferred$1.L$2 = name;
                    featureFlagManager$resolveDeferred$1.L$3 = data;
                    featureFlagManager$resolveDeferred$1.L$4 = reportingMetadata;
                    featureFlagManager$resolveDeferred$1.Z$0 = zIsEligible;
                    featureFlagManager$resolveDeferred$1.label = 7;
                    channelId2 = deviceInfoProvider4.getChannelId(featureFlagManager$resolveDeferred$1);
                    if (channelId2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = name;
                    z2 = zIsEligible;
                    jsonMap3 = data;
                    JsonMap jsonMap7 = reportingMetadata;
                    obj = channelId2;
                    jsonMap4 = jsonMap7;
                    str7 = (String) obj;
                    featureFlagManager$resolveDeferred$1.L$0 = companion3;
                    featureFlagManager$resolveDeferred$1.L$1 = str6;
                    featureFlagManager$resolveDeferred$1.L$2 = jsonMap3;
                    featureFlagManager$resolveDeferred$1.L$3 = jsonMap4;
                    featureFlagManager$resolveDeferred$1.L$4 = str7;
                    featureFlagManager$resolveDeferred$1.Z$0 = z2;
                    featureFlagManager$resolveDeferred$1.label = 8;
                    stableContactInfo3 = deviceInfoProvider4.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                    if (stableContactInfo3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    companion4 = companion3;
                    jsonMap5 = jsonMap3;
                    str8 = str6;
                    str9 = str7;
                    obj = stableContactInfo3;
                    jsonMap6 = jsonMap4;
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = companion4.createFlag$urbanairship_feature_flag_release(str8, z2, new FeatureFlag.ReportingInfo(jsonMap6, null, str9, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap5);
                } else {
                    if (deferredFlag instanceof DeferredFlag.NotFound) {
                        throw new NoWhenBranchMatchedException();
                    }
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = FeatureFlag.INSTANCE.createMissingFlag$urbanairship_feature_flag_release(featureFlagInfo4.getName());
                }
                return Result.m5277constructorimpl(featureFlagCreateMissingFlag$urbanairship_feature_flag_release);
            case 1:
                jsonMap = (JsonMap) featureFlagManager$resolveDeferred$1.L$3;
                String str10 = (String) featureFlagManager$resolveDeferred$1.L$2;
                companion = (FeatureFlag.Companion) featureFlagManager$resolveDeferred$1.L$1;
                DeviceInfoProvider deviceInfoProvider7 = (DeviceInfoProvider) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                str = str10;
                deviceInfoProvider5 = deviceInfoProvider7;
                str2 = (String) obj;
                featureFlagManager$resolveDeferred$1.L$0 = companion;
                featureFlagManager$resolveDeferred$1.L$1 = str;
                featureFlagManager$resolveDeferred$1.L$2 = jsonMap;
                featureFlagManager$resolveDeferred$1.L$3 = str2;
                featureFlagManager$resolveDeferred$1.label = 2;
                stableContactInfo2 = deviceInfoProvider5.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                if (stableContactInfo2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jsonMap2 = jsonMap;
                str3 = str2;
                companion2 = companion;
                str4 = str;
                obj = stableContactInfo2;
                return Result.m5277constructorimpl(companion2.createFlag$urbanairship_feature_flag_release(str4, false, new FeatureFlag.ReportingInfo(jsonMap2, null, str3, ((StableContactInfo) obj).getContactId(), 2, null), null));
            case 2:
                String str11 = (String) featureFlagManager$resolveDeferred$1.L$3;
                JsonMap jsonMap8 = (JsonMap) featureFlagManager$resolveDeferred$1.L$2;
                str4 = (String) featureFlagManager$resolveDeferred$1.L$1;
                companion2 = (FeatureFlag.Companion) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                str3 = str11;
                jsonMap2 = jsonMap8;
                return Result.m5277constructorimpl(companion2.createFlag$urbanairship_feature_flag_release(str4, false, new FeatureFlag.ReportingInfo(jsonMap2, null, str3, ((StableContactInfo) obj).getContactId(), 2, null), null));
            case 3:
                DeviceInfoProvider deviceInfoProvider8 = (DeviceInfoProvider) featureFlagManager$resolveDeferred$1.L$3;
                deferredPayload2 = (FeatureFlagPayload.DeferredPayload) featureFlagManager$resolveDeferred$1.L$2;
                FeatureFlagInfo featureFlagInfo6 = (FeatureFlagInfo) featureFlagManager$resolveDeferred$1.L$1;
                FeatureFlagManager featureFlagManager3 = (FeatureFlagManager) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                deviceInfoProvider2 = deviceInfoProvider8;
                featureFlagManager2 = featureFlagManager3;
                stableContactInfo = obj;
                featureFlagInfo2 = featureFlagInfo6;
                contactId = ((StableContactInfo) stableContactInfo).getContactId();
                featureFlagManager$resolveDeferred$1.L$0 = featureFlagManager2;
                featureFlagManager$resolveDeferred$1.L$1 = featureFlagInfo2;
                featureFlagManager$resolveDeferred$1.L$2 = deferredPayload2;
                featureFlagManager$resolveDeferred$1.L$3 = deviceInfoProvider2;
                featureFlagManager$resolveDeferred$1.L$4 = contactId;
                featureFlagManager$resolveDeferred$1.label = 4;
                channelId = deviceInfoProvider2.getChannelId(featureFlagManager$resolveDeferred$1);
                if (channelId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str5 = contactId;
                featureFlagInfo3 = featureFlagInfo2;
                obj = channelId;
                DeviceInfoProvider deviceInfoProvider9 = deviceInfoProvider2;
                deferredPayload3 = deferredPayload2;
                deviceInfoProvider3 = deviceInfoProvider9;
                DeferredRequest deferredRequest2 = new DeferredRequest(deferredPayload3.getUrl(), (String) obj, str5, null, deviceInfoProvider3.getLocale(), deviceInfoProvider3.isNotificationsOptedIn(), deviceInfoProvider3.getAppVersionName(), null, 136, null);
                FlagDeferredResolver flagDeferredResolver2 = featureFlagManager2.deferredResolver;
                featureFlagManager$resolveDeferred$1.L$0 = featureFlagManager2;
                featureFlagManager$resolveDeferred$1.L$1 = featureFlagInfo3;
                featureFlagManager$resolveDeferred$1.L$2 = deviceInfoProvider3;
                featureFlagManager$resolveDeferred$1.L$3 = null;
                featureFlagManager$resolveDeferred$1.L$4 = null;
                featureFlagManager$resolveDeferred$1.label = 5;
                objM5111resolve0E7RQCE = flagDeferredResolver2.m5111resolve0E7RQCE(deferredRequest2, featureFlagInfo3, featureFlagManager$resolveDeferred$1);
                if (objM5111resolve0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                featureFlagManager = featureFlagManager2;
                featureFlagInfo4 = featureFlagInfo3;
                thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5111resolve0E7RQCE);
                if (thM5280exceptionOrNullimpl == null) {
                    return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl));
                }
                deferredFlag = (DeferredFlag) objM5111resolve0E7RQCE;
                if (deferredFlag instanceof DeferredFlag.Found) {
                    found = (DeferredFlag.Found) deferredFlag;
                    variables = found.getFlagInfo().getVariables();
                    if (variables != null) {
                        boolean zIsEligible3 = found.getFlagInfo().isEligible();
                        AudienceEvaluator audienceEvaluator2 = featureFlagManager.audienceEvaluator;
                        long created2 = featureFlagInfo4.getCreated();
                        featureFlagManager$resolveDeferred$1.L$0 = featureFlagInfo4;
                        featureFlagManager$resolveDeferred$1.L$1 = deviceInfoProvider3;
                        featureFlagManager$resolveDeferred$1.L$2 = deferredFlag;
                        featureFlagManager$resolveDeferred$1.label = 6;
                        objEvaluate = FeatureFlagManagerKt.evaluate(variables, zIsEligible3, audienceEvaluator2, created2, deviceInfoProvider3, featureFlagManager$resolveDeferred$1);
                        if (objEvaluate == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        featureFlagInfo5 = featureFlagInfo4;
                        deferredFlag3 = deferredFlag;
                        obj = objEvaluate;
                        variableResult = (VariableResult) obj;
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag3;
                        featureFlagInfo4 = featureFlagInfo5;
                    } else {
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag;
                        variableResult = null;
                    }
                    companion3 = FeatureFlag.INSTANCE;
                    name = featureFlagInfo4.getName();
                    found2 = (DeferredFlag.Found) deferredFlag2;
                    zIsEligible = found2.getFlagInfo().isEligible();
                    if (variableResult != null) {
                    }
                    if (variableResult != null) {
                        reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                    } else {
                        reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                    }
                    featureFlagManager$resolveDeferred$1.L$0 = deviceInfoProvider4;
                    featureFlagManager$resolveDeferred$1.L$1 = companion3;
                    featureFlagManager$resolveDeferred$1.L$2 = name;
                    featureFlagManager$resolveDeferred$1.L$3 = data;
                    featureFlagManager$resolveDeferred$1.L$4 = reportingMetadata;
                    featureFlagManager$resolveDeferred$1.Z$0 = zIsEligible;
                    featureFlagManager$resolveDeferred$1.label = 7;
                    channelId2 = deviceInfoProvider4.getChannelId(featureFlagManager$resolveDeferred$1);
                    if (channelId2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = name;
                    z2 = zIsEligible;
                    jsonMap3 = data;
                    JsonMap jsonMap9 = reportingMetadata;
                    obj = channelId2;
                    jsonMap4 = jsonMap9;
                    str7 = (String) obj;
                    featureFlagManager$resolveDeferred$1.L$0 = companion3;
                    featureFlagManager$resolveDeferred$1.L$1 = str6;
                    featureFlagManager$resolveDeferred$1.L$2 = jsonMap3;
                    featureFlagManager$resolveDeferred$1.L$3 = jsonMap4;
                    featureFlagManager$resolveDeferred$1.L$4 = str7;
                    featureFlagManager$resolveDeferred$1.Z$0 = z2;
                    featureFlagManager$resolveDeferred$1.label = 8;
                    stableContactInfo3 = deviceInfoProvider4.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                    if (stableContactInfo3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    companion4 = companion3;
                    jsonMap5 = jsonMap3;
                    str8 = str6;
                    str9 = str7;
                    obj = stableContactInfo3;
                    jsonMap6 = jsonMap4;
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = companion4.createFlag$urbanairship_feature_flag_release(str8, z2, new FeatureFlag.ReportingInfo(jsonMap6, null, str9, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap5);
                } else {
                    if (deferredFlag instanceof DeferredFlag.NotFound) {
                        throw new NoWhenBranchMatchedException();
                    }
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = FeatureFlag.INSTANCE.createMissingFlag$urbanairship_feature_flag_release(featureFlagInfo4.getName());
                }
                return Result.m5277constructorimpl(featureFlagCreateMissingFlag$urbanairship_feature_flag_release);
            case 4:
                String str12 = (String) featureFlagManager$resolveDeferred$1.L$4;
                deviceInfoProvider3 = (DeviceInfoProvider) featureFlagManager$resolveDeferred$1.L$3;
                deferredPayload3 = (FeatureFlagPayload.DeferredPayload) featureFlagManager$resolveDeferred$1.L$2;
                featureFlagInfo3 = (FeatureFlagInfo) featureFlagManager$resolveDeferred$1.L$1;
                FeatureFlagManager featureFlagManager4 = (FeatureFlagManager) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                str5 = str12;
                featureFlagManager2 = featureFlagManager4;
                DeferredRequest deferredRequest3 = new DeferredRequest(deferredPayload3.getUrl(), (String) obj, str5, null, deviceInfoProvider3.getLocale(), deviceInfoProvider3.isNotificationsOptedIn(), deviceInfoProvider3.getAppVersionName(), null, 136, null);
                FlagDeferredResolver flagDeferredResolver3 = featureFlagManager2.deferredResolver;
                featureFlagManager$resolveDeferred$1.L$0 = featureFlagManager2;
                featureFlagManager$resolveDeferred$1.L$1 = featureFlagInfo3;
                featureFlagManager$resolveDeferred$1.L$2 = deviceInfoProvider3;
                featureFlagManager$resolveDeferred$1.L$3 = null;
                featureFlagManager$resolveDeferred$1.L$4 = null;
                featureFlagManager$resolveDeferred$1.label = 5;
                objM5111resolve0E7RQCE = flagDeferredResolver3.m5111resolve0E7RQCE(deferredRequest3, featureFlagInfo3, featureFlagManager$resolveDeferred$1);
                if (objM5111resolve0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                featureFlagManager = featureFlagManager2;
                featureFlagInfo4 = featureFlagInfo3;
                thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5111resolve0E7RQCE);
                if (thM5280exceptionOrNullimpl == null) {
                    return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl));
                }
                deferredFlag = (DeferredFlag) objM5111resolve0E7RQCE;
                if (deferredFlag instanceof DeferredFlag.Found) {
                    found = (DeferredFlag.Found) deferredFlag;
                    variables = found.getFlagInfo().getVariables();
                    if (variables != null) {
                        boolean zIsEligible4 = found.getFlagInfo().isEligible();
                        AudienceEvaluator audienceEvaluator3 = featureFlagManager.audienceEvaluator;
                        long created3 = featureFlagInfo4.getCreated();
                        featureFlagManager$resolveDeferred$1.L$0 = featureFlagInfo4;
                        featureFlagManager$resolveDeferred$1.L$1 = deviceInfoProvider3;
                        featureFlagManager$resolveDeferred$1.L$2 = deferredFlag;
                        featureFlagManager$resolveDeferred$1.label = 6;
                        objEvaluate = FeatureFlagManagerKt.evaluate(variables, zIsEligible4, audienceEvaluator3, created3, deviceInfoProvider3, featureFlagManager$resolveDeferred$1);
                        if (objEvaluate == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        featureFlagInfo5 = featureFlagInfo4;
                        deferredFlag3 = deferredFlag;
                        obj = objEvaluate;
                        variableResult = (VariableResult) obj;
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag3;
                        featureFlagInfo4 = featureFlagInfo5;
                    } else {
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag;
                        variableResult = null;
                    }
                    companion3 = FeatureFlag.INSTANCE;
                    name = featureFlagInfo4.getName();
                    found2 = (DeferredFlag.Found) deferredFlag2;
                    zIsEligible = found2.getFlagInfo().isEligible();
                    if (variableResult != null) {
                    }
                    if (variableResult != null) {
                        reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                    } else {
                        reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                    }
                    featureFlagManager$resolveDeferred$1.L$0 = deviceInfoProvider4;
                    featureFlagManager$resolveDeferred$1.L$1 = companion3;
                    featureFlagManager$resolveDeferred$1.L$2 = name;
                    featureFlagManager$resolveDeferred$1.L$3 = data;
                    featureFlagManager$resolveDeferred$1.L$4 = reportingMetadata;
                    featureFlagManager$resolveDeferred$1.Z$0 = zIsEligible;
                    featureFlagManager$resolveDeferred$1.label = 7;
                    channelId2 = deviceInfoProvider4.getChannelId(featureFlagManager$resolveDeferred$1);
                    if (channelId2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = name;
                    z2 = zIsEligible;
                    jsonMap3 = data;
                    JsonMap jsonMap10 = reportingMetadata;
                    obj = channelId2;
                    jsonMap4 = jsonMap10;
                    str7 = (String) obj;
                    featureFlagManager$resolveDeferred$1.L$0 = companion3;
                    featureFlagManager$resolveDeferred$1.L$1 = str6;
                    featureFlagManager$resolveDeferred$1.L$2 = jsonMap3;
                    featureFlagManager$resolveDeferred$1.L$3 = jsonMap4;
                    featureFlagManager$resolveDeferred$1.L$4 = str7;
                    featureFlagManager$resolveDeferred$1.Z$0 = z2;
                    featureFlagManager$resolveDeferred$1.label = 8;
                    stableContactInfo3 = deviceInfoProvider4.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                    if (stableContactInfo3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    companion4 = companion3;
                    jsonMap5 = jsonMap3;
                    str8 = str6;
                    str9 = str7;
                    obj = stableContactInfo3;
                    jsonMap6 = jsonMap4;
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = companion4.createFlag$urbanairship_feature_flag_release(str8, z2, new FeatureFlag.ReportingInfo(jsonMap6, null, str9, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap5);
                } else {
                    if (deferredFlag instanceof DeferredFlag.NotFound) {
                        throw new NoWhenBranchMatchedException();
                    }
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = FeatureFlag.INSTANCE.createMissingFlag$urbanairship_feature_flag_release(featureFlagInfo4.getName());
                }
                return Result.m5277constructorimpl(featureFlagCreateMissingFlag$urbanairship_feature_flag_release);
            case 5:
                DeviceInfoProvider deviceInfoProvider10 = (DeviceInfoProvider) featureFlagManager$resolveDeferred$1.L$2;
                FeatureFlagInfo featureFlagInfo7 = (FeatureFlagInfo) featureFlagManager$resolveDeferred$1.L$1;
                featureFlagManager = (FeatureFlagManager) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM5111resolve0E7RQCE = ((Result) obj).getValue();
                deviceInfoProvider3 = deviceInfoProvider10;
                featureFlagInfo4 = featureFlagInfo7;
                thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5111resolve0E7RQCE);
                if (thM5280exceptionOrNullimpl == null) {
                    return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl));
                }
                deferredFlag = (DeferredFlag) objM5111resolve0E7RQCE;
                if (deferredFlag instanceof DeferredFlag.Found) {
                    found = (DeferredFlag.Found) deferredFlag;
                    variables = found.getFlagInfo().getVariables();
                    if (variables != null) {
                        boolean zIsEligible5 = found.getFlagInfo().isEligible();
                        AudienceEvaluator audienceEvaluator4 = featureFlagManager.audienceEvaluator;
                        long created4 = featureFlagInfo4.getCreated();
                        featureFlagManager$resolveDeferred$1.L$0 = featureFlagInfo4;
                        featureFlagManager$resolveDeferred$1.L$1 = deviceInfoProvider3;
                        featureFlagManager$resolveDeferred$1.L$2 = deferredFlag;
                        featureFlagManager$resolveDeferred$1.label = 6;
                        objEvaluate = FeatureFlagManagerKt.evaluate(variables, zIsEligible5, audienceEvaluator4, created4, deviceInfoProvider3, featureFlagManager$resolveDeferred$1);
                        if (objEvaluate == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        featureFlagInfo5 = featureFlagInfo4;
                        deferredFlag3 = deferredFlag;
                        obj = objEvaluate;
                        variableResult = (VariableResult) obj;
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag3;
                        featureFlagInfo4 = featureFlagInfo5;
                    } else {
                        deviceInfoProvider4 = deviceInfoProvider3;
                        deferredFlag2 = deferredFlag;
                        variableResult = null;
                    }
                    companion3 = FeatureFlag.INSTANCE;
                    name = featureFlagInfo4.getName();
                    found2 = (DeferredFlag.Found) deferredFlag2;
                    zIsEligible = found2.getFlagInfo().isEligible();
                    if (variableResult != null) {
                    }
                    if (variableResult != null) {
                        reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                    } else {
                        reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                    }
                    featureFlagManager$resolveDeferred$1.L$0 = deviceInfoProvider4;
                    featureFlagManager$resolveDeferred$1.L$1 = companion3;
                    featureFlagManager$resolveDeferred$1.L$2 = name;
                    featureFlagManager$resolveDeferred$1.L$3 = data;
                    featureFlagManager$resolveDeferred$1.L$4 = reportingMetadata;
                    featureFlagManager$resolveDeferred$1.Z$0 = zIsEligible;
                    featureFlagManager$resolveDeferred$1.label = 7;
                    channelId2 = deviceInfoProvider4.getChannelId(featureFlagManager$resolveDeferred$1);
                    if (channelId2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = name;
                    z2 = zIsEligible;
                    jsonMap3 = data;
                    JsonMap jsonMap11 = reportingMetadata;
                    obj = channelId2;
                    jsonMap4 = jsonMap11;
                    str7 = (String) obj;
                    featureFlagManager$resolveDeferred$1.L$0 = companion3;
                    featureFlagManager$resolveDeferred$1.L$1 = str6;
                    featureFlagManager$resolveDeferred$1.L$2 = jsonMap3;
                    featureFlagManager$resolveDeferred$1.L$3 = jsonMap4;
                    featureFlagManager$resolveDeferred$1.L$4 = str7;
                    featureFlagManager$resolveDeferred$1.Z$0 = z2;
                    featureFlagManager$resolveDeferred$1.label = 8;
                    stableContactInfo3 = deviceInfoProvider4.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                    if (stableContactInfo3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    companion4 = companion3;
                    jsonMap5 = jsonMap3;
                    str8 = str6;
                    str9 = str7;
                    obj = stableContactInfo3;
                    jsonMap6 = jsonMap4;
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = companion4.createFlag$urbanairship_feature_flag_release(str8, z2, new FeatureFlag.ReportingInfo(jsonMap6, null, str9, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap5);
                } else {
                    if (deferredFlag instanceof DeferredFlag.NotFound) {
                        throw new NoWhenBranchMatchedException();
                    }
                    featureFlagCreateMissingFlag$urbanairship_feature_flag_release = FeatureFlag.INSTANCE.createMissingFlag$urbanairship_feature_flag_release(featureFlagInfo4.getName());
                }
                return Result.m5277constructorimpl(featureFlagCreateMissingFlag$urbanairship_feature_flag_release);
            case 6:
                deferredFlag3 = (DeferredFlag) featureFlagManager$resolveDeferred$1.L$2;
                deviceInfoProvider3 = (DeviceInfoProvider) featureFlagManager$resolveDeferred$1.L$1;
                featureFlagInfo5 = (FeatureFlagInfo) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                variableResult = (VariableResult) obj;
                deviceInfoProvider4 = deviceInfoProvider3;
                deferredFlag2 = deferredFlag3;
                featureFlagInfo4 = featureFlagInfo5;
                companion3 = FeatureFlag.INSTANCE;
                name = featureFlagInfo4.getName();
                found2 = (DeferredFlag.Found) deferredFlag2;
                zIsEligible = found2.getFlagInfo().isEligible();
                if (variableResult != null) {
                }
                if (variableResult != null) {
                    reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                } else {
                    reportingMetadata = found2.getFlagInfo().getReportingMetadata();
                }
                featureFlagManager$resolveDeferred$1.L$0 = deviceInfoProvider4;
                featureFlagManager$resolveDeferred$1.L$1 = companion3;
                featureFlagManager$resolveDeferred$1.L$2 = name;
                featureFlagManager$resolveDeferred$1.L$3 = data;
                featureFlagManager$resolveDeferred$1.L$4 = reportingMetadata;
                featureFlagManager$resolveDeferred$1.Z$0 = zIsEligible;
                featureFlagManager$resolveDeferred$1.label = 7;
                channelId2 = deviceInfoProvider4.getChannelId(featureFlagManager$resolveDeferred$1);
                if (channelId2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str6 = name;
                z2 = zIsEligible;
                jsonMap3 = data;
                JsonMap jsonMap12 = reportingMetadata;
                obj = channelId2;
                jsonMap4 = jsonMap12;
                str7 = (String) obj;
                featureFlagManager$resolveDeferred$1.L$0 = companion3;
                featureFlagManager$resolveDeferred$1.L$1 = str6;
                featureFlagManager$resolveDeferred$1.L$2 = jsonMap3;
                featureFlagManager$resolveDeferred$1.L$3 = jsonMap4;
                featureFlagManager$resolveDeferred$1.L$4 = str7;
                featureFlagManager$resolveDeferred$1.Z$0 = z2;
                featureFlagManager$resolveDeferred$1.label = 8;
                stableContactInfo3 = deviceInfoProvider4.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                if (stableContactInfo3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                companion4 = companion3;
                jsonMap5 = jsonMap3;
                str8 = str6;
                str9 = str7;
                obj = stableContactInfo3;
                jsonMap6 = jsonMap4;
                featureFlagCreateMissingFlag$urbanairship_feature_flag_release = companion4.createFlag$urbanairship_feature_flag_release(str8, z2, new FeatureFlag.ReportingInfo(jsonMap6, null, str9, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap5);
                return Result.m5277constructorimpl(featureFlagCreateMissingFlag$urbanairship_feature_flag_release);
            case 7:
                z2 = featureFlagManager$resolveDeferred$1.Z$0;
                jsonMap4 = (JsonMap) featureFlagManager$resolveDeferred$1.L$4;
                JsonMap jsonMap13 = (JsonMap) featureFlagManager$resolveDeferred$1.L$3;
                String str13 = (String) featureFlagManager$resolveDeferred$1.L$2;
                FeatureFlag.Companion companion7 = (FeatureFlag.Companion) featureFlagManager$resolveDeferred$1.L$1;
                deviceInfoProvider4 = (DeviceInfoProvider) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                jsonMap3 = jsonMap13;
                companion3 = companion7;
                str6 = str13;
                str7 = (String) obj;
                featureFlagManager$resolveDeferred$1.L$0 = companion3;
                featureFlagManager$resolveDeferred$1.L$1 = str6;
                featureFlagManager$resolveDeferred$1.L$2 = jsonMap3;
                featureFlagManager$resolveDeferred$1.L$3 = jsonMap4;
                featureFlagManager$resolveDeferred$1.L$4 = str7;
                featureFlagManager$resolveDeferred$1.Z$0 = z2;
                featureFlagManager$resolveDeferred$1.label = 8;
                stableContactInfo3 = deviceInfoProvider4.getStableContactInfo(featureFlagManager$resolveDeferred$1);
                if (stableContactInfo3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                companion4 = companion3;
                jsonMap5 = jsonMap3;
                str8 = str6;
                str9 = str7;
                obj = stableContactInfo3;
                jsonMap6 = jsonMap4;
                featureFlagCreateMissingFlag$urbanairship_feature_flag_release = companion4.createFlag$urbanairship_feature_flag_release(str8, z2, new FeatureFlag.ReportingInfo(jsonMap6, null, str9, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap5);
                return Result.m5277constructorimpl(featureFlagCreateMissingFlag$urbanairship_feature_flag_release);
            case 8:
                z2 = featureFlagManager$resolveDeferred$1.Z$0;
                String str14 = (String) featureFlagManager$resolveDeferred$1.L$4;
                JsonMap jsonMap14 = (JsonMap) featureFlagManager$resolveDeferred$1.L$3;
                JsonMap jsonMap15 = (JsonMap) featureFlagManager$resolveDeferred$1.L$2;
                String str15 = (String) featureFlagManager$resolveDeferred$1.L$1;
                FeatureFlag.Companion companion8 = (FeatureFlag.Companion) featureFlagManager$resolveDeferred$1.L$0;
                ResultKt.throwOnFailure(obj);
                companion4 = companion8;
                jsonMap6 = jsonMap14;
                jsonMap5 = jsonMap15;
                str8 = str15;
                str9 = str14;
                featureFlagCreateMissingFlag$urbanairship_feature_flag_release = companion4.createFlag$urbanairship_feature_flag_release(str8, z2, new FeatureFlag.ReportingInfo(jsonMap6, null, str9, ((StableContactInfo) obj).getContactId(), 2, null), jsonMap5);
                return Result.m5277constructorimpl(featureFlagCreateMissingFlag$urbanairship_feature_flag_release);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
