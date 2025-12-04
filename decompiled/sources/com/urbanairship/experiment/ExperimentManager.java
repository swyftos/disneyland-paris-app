package com.urbanairship.experiment;

import android.content.Context;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.remotedata.RemoteData;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.JvmOverloads;
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

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\b\b\u0017\u0018\u0000 .2\u00020\u0001:\u0001.B1\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ.\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0097@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0012\u001a\u00020\u0013H\u0092@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0017J\"\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0090@¢\u0006\u0004\b!\u0010\"J7\u0010#\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0012\u0006\u0012\u0004\u0018\u00010'0$2\u0006\u0010(\u001a\u00020\u001aH\u0012¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0015H\u0092@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0015H\u0092@¢\u0006\u0002\u0010,R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Lcom/urbanairship/experiment/ExperimentManager;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "clock", "Lcom/urbanairship/util/Clock;", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/remotedata/RemoteData;Lcom/urbanairship/util/Clock;Lcom/urbanairship/audience/AudienceEvaluator;)V", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "evaluateExperiments", "Lkotlin/Result;", "Lcom/urbanairship/experiment/ExperimentResult;", "messageInfo", "Lcom/urbanairship/experiment/MessageInfo;", "deviceInfoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "evaluateExperiments-0E7RQCE", "(Lcom/urbanairship/experiment/MessageInfo;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveExperiments", "", "Lcom/urbanairship/experiment/Experiment;", "(Lcom/urbanairship/experiment/MessageInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComponentGroup", "", "getExperimentWithId", "id", "", "getExperimentWithId$urbanairship_core_release", "(Lcom/urbanairship/experiment/MessageInfo;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getResolutionFunction", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "", "experiment", "(Lcom/urbanairship/experiment/Experiment;)Lkotlin/jvm/functions/Function3;", "resolveDeferred", "infoProvider", "(Lcom/urbanairship/experiment/Experiment;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveStatic", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@OpenForTesting
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nExperimentManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExperimentManager.kt\ncom/urbanairship/experiment/ExperimentManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,154:1\n1#2:155\n1#2:166\n1#2:183\n1603#3,9:156\n1855#3:165\n1856#3:167\n1612#3:168\n1549#3:169\n1620#3,3:170\n1603#3,9:173\n1855#3:182\n1856#3:184\n1612#3:185\n766#3:186\n857#3,2:187\n766#3:189\n857#3:190\n1747#3,3:191\n858#3:194\n*S KotlinDebug\n*F\n+ 1 ExperimentManager.kt\ncom/urbanairship/experiment/ExperimentManager\n*L\n136#1:166\n141#1:183\n136#1:156,9\n136#1:165\n136#1:167\n136#1:168\n140#1:169\n140#1:170,3\n141#1:173,9\n141#1:182\n141#1:184\n141#1:185\n142#1:186\n142#1:187,2\n143#1:189\n143#1:190\n144#1:191,3\n143#1:194\n*E\n"})
/* loaded from: classes5.dex */
public class ExperimentManager extends AirshipComponent {

    @NotNull
    public static final String PAYLOAD_TYPE = "experiments";
    private final AudienceEvaluator audienceEvaluator;
    private final Clock clock;
    private final RemoteData remoteData;
    private final CoroutineScope scope;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
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

    /* renamed from: com.urbanairship.experiment.ExperimentManager$getActiveExperiments$1, reason: invalid class name */
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
            return ExperimentManager.this.getActiveExperiments(null, this);
        }
    }

    /* renamed from: com.urbanairship.experiment.ExperimentManager$resolveStatic$1, reason: invalid class name and case insensitive filesystem */
    static final class C11241 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11241(Continuation continuation) {
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
    /* renamed from: evaluateExperiments-0E7RQCE, reason: not valid java name */
    public Object m2844evaluateExperiments0E7RQCE(@NotNull MessageInfo messageInfo, @NotNull DeviceInfoProvider deviceInfoProvider, @NotNull Continuation<? super Result<ExperimentResult>> continuation) {
        return m2843evaluateExperiments0E7RQCE$suspendImpl(this, messageInfo, deviceInfoProvider, continuation);
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getExperimentWithId$suspendImpl(com.urbanairship.experiment.ExperimentManager r4, com.urbanairship.experiment.MessageInfo r5, java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof com.urbanairship.experiment.ExperimentManager$getExperimentWithId$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.experiment.ExperimentManager$getExperimentWithId$1 r0 = (com.urbanairship.experiment.ExperimentManager$getExperimentWithId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.experiment.ExperimentManager$getExperimentWithId$1 r0 = new com.urbanairship.experiment.ExperimentManager$getExperimentWithId$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r4.getActiveExperiments(r5, r0)
            if (r7 != r1) goto L44
            return r1
        L44:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
        L4a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L62
            java.lang.Object r5 = r4.next()
            r7 = r5
            com.urbanairship.experiment.Experiment r7 = (com.urbanairship.experiment.Experiment) r7
            java.lang.String r7 = r7.getId()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r6)
            if (r7 == 0) goto L4a
            goto L63
        L62:
            r5 = 0
        L63:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.experiment.ExperimentManager.getExperimentWithId$suspendImpl(com.urbanairship.experiment.ExperimentManager, com.urbanairship.experiment.MessageInfo, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4 A[PHI: r2 r4 r5 r8 r12 r13
  0x00e4: PHI (r2v6 java.lang.String) = (r2v4 java.lang.String), (r2v7 java.lang.String) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r4v4 java.lang.String) = (r4v2 java.lang.String), (r4v5 java.lang.String) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r5v3 com.urbanairship.audience.DeviceInfoProvider) = (r5v1 com.urbanairship.audience.DeviceInfoProvider), (r5v5 com.urbanairship.audience.DeviceInfoProvider) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r8v1 com.urbanairship.experiment.ExperimentManager) = (r8v0 com.urbanairship.experiment.ExperimentManager), (r8v2 com.urbanairship.experiment.ExperimentManager) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r12v9 java.util.Iterator) = (r12v6 java.util.Iterator), (r12v10 java.util.Iterator) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r13v5 java.util.List) = (r13v4 java.util.List), (r13v6 java.util.List) binds: [B:34:0x00d0, B:41:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0108 -> B:40:0x010b). Please report as a decompilation issue!!! */
    /* renamed from: evaluateExperiments-0E7RQCE$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m2843evaluateExperiments0E7RQCE$suspendImpl(com.urbanairship.experiment.ExperimentManager r11, com.urbanairship.experiment.MessageInfo r12, com.urbanairship.audience.DeviceInfoProvider r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.experiment.ExperimentManager.m2843evaluateExperiments0E7RQCE$suspendImpl(com.urbanairship.experiment.ExperimentManager, com.urbanairship.experiment.MessageInfo, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.experiment.ExperimentManager$getResolutionFunction$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C11231 extends FunctionReferenceImpl implements Function3, SuspendFunction {
        C11231(Object obj) {
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
            return new C11231(this);
        }
        if (i == 2) {
            return new AnonymousClass2(this);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: com.urbanairship.experiment.ExperimentManager$getResolutionFunction$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3, SuspendFunction {
        AnonymousClass2(Object obj) {
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
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object resolveStatic(com.urbanairship.experiment.Experiment r8, com.urbanairship.audience.DeviceInfoProvider r9, kotlin.coroutines.Continuation r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.urbanairship.experiment.ExperimentManager.C11241
            if (r0 == 0) goto L14
            r0 = r10
            com.urbanairship.experiment.ExperimentManager$resolveStatic$1 r0 = (com.urbanairship.experiment.ExperimentManager.C11241) r0
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
            com.urbanairship.experiment.ExperimentManager$resolveStatic$1 r0 = new com.urbanairship.experiment.ExperimentManager$resolveStatic$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5d
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            com.urbanairship.audience.AudienceEvaluator r1 = r7.audienceEvaluator
            com.urbanairship.audience.CompoundAudienceSelector$Companion r7 = com.urbanairship.audience.CompoundAudienceSelector.INSTANCE
            com.urbanairship.experiment.ExperimentCompoundAudience r10 = r8.getCompoundAudienceSelector()
            if (r10 == 0) goto L45
            com.urbanairship.audience.CompoundAudienceSelector r10 = r10.getSelector()
            goto L46
        L45:
            r10 = 0
        L46:
            com.urbanairship.audience.AudienceSelector r3 = r8.getAudience()
            com.urbanairship.audience.CompoundAudienceSelector r7 = r7.combine(r10, r3)
            long r3 = r8.getCreated()
            r6.label = r2
            r2 = r7
            r5 = r9
            java.lang.Object r10 = r1.evaluate(r2, r3, r5, r6)
            if (r10 != r0) goto L5d
            return r0
        L5d:
            com.urbanairship.audience.AirshipDeviceAudienceResult r10 = (com.urbanairship.audience.AirshipDeviceAudienceResult) r10
            boolean r7 = r10.isMatch()
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.experiment.ExperimentManager.resolveStatic(com.urbanairship.experiment.Experiment, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getActiveExperiments(com.urbanairship.experiment.MessageInfo r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.experiment.ExperimentManager.getActiveExperiments(com.urbanairship.experiment.MessageInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
