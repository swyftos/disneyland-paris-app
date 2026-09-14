package com.urbanairship.experiment;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.audience.AirshipDeviceAudienceResult;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.audience.CompoundAudienceSelector;
import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remotedata.RemoteData;
import com.urbanairship.remotedata.RemoteDataPayload;
import com.urbanairship.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\b\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001.B1\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ.\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0097@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0012\u001a\u00020\u0013H\u0092@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0017J\"\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0090@¢\u0006\u0004\b!\u0010\"J7\u0010#\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0012\u0006\u0012\u0004\u0018\u00010'0$2\u0006\u0010(\u001a\u00020\u001aH\u0012¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0015H\u0092@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0015H\u0092@¢\u0006\u0002\u0010,R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006/"}, m1836d2 = {"Lcom/urbanairship/experiment/ExperimentManager;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "clock", "Lcom/urbanairship/util/Clock;", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/remotedata/RemoteData;Lcom/urbanairship/util/Clock;Lcom/urbanairship/audience/AudienceEvaluator;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "evaluateExperiments", "Lkotlin/Result;", "Lcom/urbanairship/experiment/ExperimentResult;", "messageInfo", "Lcom/urbanairship/experiment/MessageInfo;", "deviceInfoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "evaluateExperiments-0E7RQCE", "(Lcom/urbanairship/experiment/MessageInfo;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveExperiments", "", "Lcom/urbanairship/experiment/Experiment;", "(Lcom/urbanairship/experiment/MessageInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComponentGroup", "", "getExperimentWithId", "id", "", "getExperimentWithId$urbanairship_core_release", "(Lcom/urbanairship/experiment/MessageInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResolutionFunction", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "", "experiment", "(Lcom/urbanairship/experiment/Experiment;)Lkotlin/jvm/functions/Function3;", "resolveDeferred", "infoProvider", "(Lcom/urbanairship/experiment/Experiment;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveStatic", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@OpenForTesting
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nExperimentManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExperimentManager.kt\ncom/urbanairship/experiment/ExperimentManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,154:1\n1#2:155\n1#2:166\n1#2:183\n1603#3,9:156\n1855#3:165\n1856#3:167\n1612#3:168\n1549#3:169\n1620#3,3:170\n1603#3,9:173\n1855#3:182\n1856#3:184\n1612#3:185\n766#3:186\n857#3,2:187\n766#3:189\n857#3:190\n1747#3,3:191\n858#3:194\n*S KotlinDebug\n*F\n+ 1 ExperimentManager.kt\ncom/urbanairship/experiment/ExperimentManager\n*L\n136#1:166\n141#1:183\n136#1:156,9\n136#1:165\n136#1:167\n136#1:168\n140#1:169\n140#1:170,3\n141#1:173,9\n141#1:182\n141#1:184\n141#1:185\n142#1:186\n142#1:187,2\n143#1:189\n143#1:190\n144#1:191,3\n143#1:194\n*E\n"})
public class ExperimentManager extends AirshipComponent {

    @NotNull
    public static final String PAYLOAD_TYPE = "experiments";
    private final AudienceEvaluator audienceEvaluator;
    private final Clock clock;
    private final RemoteData remoteData;
    private final CoroutineScope scope;

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolutionType.values().length];
            try {
                iArr[ResolutionType.STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolutionType.DEFERRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.experiment.ExperimentManager$getActiveExperiments$1 */
    static final class C52821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52821(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExperimentManager.this.getActiveExperiments(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.experiment.ExperimentManager$resolveStatic$1 */
    static final class C52861 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C52861(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExperimentManager.this.resolveStatic(null, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExperimentManager(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull RemoteData remoteData, @NotNull AudienceEvaluator audienceEvaluator) {
        this(context, dataStore, remoteData, null, audienceEvaluator, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(audienceEvaluator, "audienceEvaluator");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    /* JADX INFO: renamed from: evaluateExperiments-0E7RQCE, reason: not valid java name */
    public Object m5086evaluateExperiments0E7RQCE(@NotNull MessageInfo messageInfo, @NotNull DeviceInfoProvider deviceInfoProvider, @NotNull Continuation<? super Result<ExperimentResult>> continuation) {
        return m5085evaluateExperiments0E7RQCE$suspendImpl(this, messageInfo, deviceInfoProvider, continuation);
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 12;
    }

    @Nullable
    public Object getExperimentWithId$urbanairship_core_release(@NotNull MessageInfo messageInfo, @NotNull String str, @NotNull Continuation<? super Experiment> continuation) {
        return getExperimentWithId$suspendImpl(this, messageInfo, str, continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ExperimentManager(Context context, PreferenceDataStore preferenceDataStore, RemoteData remoteData, Clock DEFAULT_CLOCK, AudienceEvaluator audienceEvaluator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 8) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(context, preferenceDataStore, remoteData, DEFAULT_CLOCK, audienceEvaluator);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExperimentManager(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull RemoteData remoteData, @NotNull Clock clock, @NotNull AudienceEvaluator audienceEvaluator) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(audienceEvaluator, "audienceEvaluator");
        this.remoteData = remoteData;
        this.clock = clock;
        this.audienceEvaluator = audienceEvaluator;
        this.scope = CoroutineScopeKt.CoroutineScope(AirshipDispatchers.INSTANCE.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    static /* synthetic */ Object getExperimentWithId$suspendImpl(ExperimentManager experimentManager, MessageInfo messageInfo, String str, Continuation continuation) {
        ExperimentManager$getExperimentWithId$1 experimentManager$getExperimentWithId$1;
        if (continuation instanceof ExperimentManager$getExperimentWithId$1) {
            experimentManager$getExperimentWithId$1 = (ExperimentManager$getExperimentWithId$1) continuation;
            int i = experimentManager$getExperimentWithId$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                experimentManager$getExperimentWithId$1.label = i - Integer.MIN_VALUE;
            } else {
                experimentManager$getExperimentWithId$1 = new ExperimentManager$getExperimentWithId$1(experimentManager, continuation);
            }
        } else {
            experimentManager$getExperimentWithId$1 = new ExperimentManager$getExperimentWithId$1(experimentManager, continuation);
        }
        Object activeExperiments = experimentManager$getExperimentWithId$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = experimentManager$getExperimentWithId$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(activeExperiments);
            experimentManager$getExperimentWithId$1.L$0 = str;
            experimentManager$getExperimentWithId$1.label = 1;
            activeExperiments = experimentManager.getActiveExperiments(messageInfo, experimentManager$getExperimentWithId$1);
            if (activeExperiments == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) experimentManager$getExperimentWithId$1.L$0;
            ResultKt.throwOnFailure(activeExperiments);
        }
        for (Object obj : (Iterable) activeExperiments) {
            if (Intrinsics.areEqual(((Experiment) obj).getId(), str)) {
                return obj;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e4 A[PHI: r2 r4 r5 r8 r12 r13
  0x00e4: PHI (r2v6 java.lang.String) = (r2v4 java.lang.String), (r2v7 java.lang.String) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r4v4 java.lang.String) = (r4v2 java.lang.String), (r4v5 java.lang.String) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r5v3 com.urbanairship.audience.DeviceInfoProvider) = (r5v1 com.urbanairship.audience.DeviceInfoProvider), (r5v5 com.urbanairship.audience.DeviceInfoProvider) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r8v1 com.urbanairship.experiment.ExperimentManager) = (r8v0 com.urbanairship.experiment.ExperimentManager), (r8v2 com.urbanairship.experiment.ExperimentManager) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r12v9 java.util.Iterator) = (r12v6 java.util.Iterator), (r12v10 java.util.Iterator) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r13v5 java.util.List) = (r13v4 java.util.List), (r13v6 java.util.List) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:39:0x010a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x011a  */
    /* JADX WARN: Code duplicated, block: B:43:0x011d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0126  */
    /* JADX WARN: Code duplicated, block: B:50:0x012f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0108 -> B:40:0x010b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: evaluateExperiments-0E7RQCE$suspendImpl, reason: not valid java name */
    static /* synthetic */ java.lang.Object m5085evaluateExperiments0E7RQCE$suspendImpl(com.urbanairship.experiment.ExperimentManager r11, com.urbanairship.experiment.MessageInfo r12, com.urbanairship.audience.DeviceInfoProvider r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.experiment.ExperimentManager.m5085evaluateExperiments0E7RQCE$suspendImpl(com.urbanairship.experiment.ExperimentManager, com.urbanairship.experiment.MessageInfo, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.urbanairship.experiment.ExperimentManager$getResolutionFunction$1 */
    /* synthetic */ class C52841 extends FunctionReferenceImpl implements Function3, SuspendFunction {
        C52841(Object obj) {
            super(3, obj, ExperimentManager.class, "resolveStatic", "resolveStatic(Lcom/urbanairship/experiment/Experiment;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Experiment experiment, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
            return ((ExperimentManager) this.receiver).resolveStatic(experiment, deviceInfoProvider, continuation);
        }
    }

    private Function3 getResolutionFunction(Experiment experiment) {
        int i = WhenMappings.$EnumSwitchMapping$0[experiment.getResolutionType().ordinal()];
        if (i == 1) {
            return new C52841(this);
        }
        if (i == 2) {
            return new C52852(this);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.urbanairship.experiment.ExperimentManager$getResolutionFunction$2 */
    /* synthetic */ class C52852 extends FunctionReferenceImpl implements Function3, SuspendFunction {
        C52852(Object obj) {
            super(3, obj, ExperimentManager.class, "resolveDeferred", "resolveDeferred(Lcom/urbanairship/experiment/Experiment;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Experiment experiment, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
            return ((ExperimentManager) this.receiver).resolveDeferred(experiment, deviceInfoProvider, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object resolveDeferred(Experiment experiment, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        return Boxing.boxBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public Object resolveStatic(Experiment experiment, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        C52861 c52861;
        if (continuation instanceof C52861) {
            c52861 = (C52861) continuation;
            int i = c52861.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52861.label = i - Integer.MIN_VALUE;
            } else {
                c52861 = new C52861(continuation);
            }
        } else {
            c52861 = new C52861(continuation);
        }
        C52861 c52862 = c52861;
        Object objEvaluate = c52862.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52862.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objEvaluate);
            AudienceEvaluator audienceEvaluator = this.audienceEvaluator;
            CompoundAudienceSelector.Companion companion = CompoundAudienceSelector.INSTANCE;
            ExperimentCompoundAudience compoundAudienceSelector = experiment.getCompoundAudienceSelector();
            CompoundAudienceSelector compoundAudienceSelectorCombine = companion.combine(compoundAudienceSelector != null ? compoundAudienceSelector.getSelector() : null, experiment.getAudience());
            long created = experiment.getCreated();
            c52862.label = 1;
            objEvaluate = audienceEvaluator.evaluate(compoundAudienceSelectorCombine, created, deviceInfoProvider, c52862);
            if (objEvaluate == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objEvaluate);
        }
        return Boxing.boxBoolean(((AirshipDeviceAudienceResult) objEvaluate).isMatch());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object getActiveExperiments(MessageInfo messageInfo, Continuation continuation) {
        C52821 c52821;
        if (continuation instanceof C52821) {
            c52821 = (C52821) continuation;
            int i = c52821.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52821.label = i - Integer.MIN_VALUE;
            } else {
                c52821 = new C52821(continuation);
            }
        } else {
            c52821 = new C52821(continuation);
        }
        Object objPayloads = c52821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52821.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objPayloads);
                RemoteData remoteData = this.remoteData;
                c52821.L$0 = this;
                c52821.L$1 = messageInfo;
                c52821.label = 1;
                objPayloads = remoteData.payloads(PAYLOAD_TYPE, c52821);
                if (objPayloads == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                messageInfo = (MessageInfo) c52821.L$1;
                this = (ExperimentManager) c52821.L$0;
                ResultKt.throwOnFailure(objPayloads);
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) objPayloads).iterator();
            while (it.hasNext()) {
                JsonList list = ((RemoteDataPayload) it.next()).getData().opt(PAYLOAD_TYPE).getList();
                List<JsonValue> list2 = list != null ? list.getList() : null;
                if (list2 != null) {
                    arrayList.add(list2);
                }
            }
            List listFlatten = CollectionsKt.flatten(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFlatten, 10));
            Iterator it2 = listFlatten.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((JsonValue) it2.next()).optMap());
            }
            Experiment.Companion companion = Experiment.INSTANCE;
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                Experiment experimentFromJson$urbanairship_core_release = companion.fromJson$urbanairship_core_release((JsonMap) it3.next());
                if (experimentFromJson$urbanairship_core_release != null) {
                    arrayList3.add(experimentFromJson$urbanairship_core_release);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList3) {
                if (((Experiment) obj).isActive(this.clock.currentTimeMillis())) {
                    arrayList4.add(obj);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : arrayList4) {
                List<MessageCriteria> exclusions = ((Experiment) obj2).getExclusions();
                boolean z = false;
                if (exclusions == null || !exclusions.isEmpty()) {
                    Iterator<T> it4 = exclusions.iterator();
                    while (it4.hasNext()) {
                        if (((MessageCriteria) it4.next()).evaluate(messageInfo)) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z) {
                    arrayList5.add(obj2);
                }
            }
            return arrayList5;
        } catch (JsonException e) {
            UALog.m1747e(e, new Function0() { // from class: com.urbanairship.experiment.ExperimentManager.getActiveExperiments.7
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse experiments from remoteData payload";
                }
            });
            return CollectionsKt.emptyList();
        }
    }
}
