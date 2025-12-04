package com.urbanairship.automation.remotedata;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.InAppAutomationRemoteDataStatus;
import com.urbanairship.automation.remotedata.InAppRemoteData;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remotedata.RemoteData;
import com.urbanairship.remotedata.RemoteDataInfo;
import com.urbanairship.remotedata.RemoteDataPayload;
import com.urbanairship.remotedata.RemoteDataSource;
import com.urbanairship.util.Network;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010$\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006&"}, d2 = {"Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccess;", "Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccessInterface;", "context", "Landroid/content/Context;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", TCEventPropertiesNames.TCN_NETWORK, "Lcom/urbanairship/util/Network;", "(Landroid/content/Context;Lcom/urbanairship/remotedata/RemoteData;Lcom/urbanairship/util/Network;)V", "status", "Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "updatesFlow", "Lcom/urbanairship/automation/remotedata/InAppRemoteData;", "getUpdatesFlow", "bestEffortRefresh", "", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contactIdFor", "", "isCurrent", "isRemote", "notifyOutdated", "", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "requiredUpdate", "sourceFor", "Lcom/urbanairship/remotedata/RemoteDataSource;", "waitForFullRefresh", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationRemoteDataAccess.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataAccess\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 8 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,272:1\n49#2:273\n51#2:277\n49#2:303\n51#2:307\n49#2:314\n51#2:318\n46#3:274\n51#3:276\n46#3:304\n51#3:306\n46#3:315\n51#3:317\n105#4:275\n105#4:305\n105#4:313\n105#4:316\n1549#5:278\n1620#5,3:279\n1549#5:282\n1620#5,3:283\n1603#5,9:287\n1855#5:296\n1856#5:298\n1612#5:299\n1549#5:300\n1620#5,2:301\n1622#5:308\n1#6:286\n1#6:297\n283#7:309\n284#7:312\n37#8,2:310\n*S KotlinDebug\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataAccess\n*L\n53#1:273\n53#1:277\n67#1:303\n67#1:307\n69#1:314\n69#1:318\n53#1:274\n53#1:276\n67#1:304\n67#1:306\n69#1:315\n69#1:317\n53#1:275\n67#1:305\n68#1:313\n69#1:316\n58#1:278\n58#1:279,3\n59#1:282\n59#1:283,3\n66#1:287,9\n66#1:296\n66#1:298\n66#1:299\n67#1:300\n67#1:301,2\n67#1:308\n66#1:297\n68#1:309\n68#1:312\n68#1:310,2\n*E\n"})
/* loaded from: classes5.dex */
public final class AutomationRemoteDataAccess implements AutomationRemoteDataAccessInterface {
    private static final List REMOTE_DATA_TYPES = CollectionsKt.listOf("in_app_messages");
    private final Context context;
    private final Network network;
    private final RemoteData remoteData;
    private final Flow updatesFlow;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<RemoteDataSource> entries$0 = EnumEntriesKt.enumEntries(RemoteDataSource.values());
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RemoteData.Status.values().length];
            try {
                iArr[RemoteData.Status.UP_TO_DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemoteData.Status.STALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RemoteData.Status.OUT_OF_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$bestEffortRefresh$1, reason: invalid class name */
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
            return AutomationRemoteDataAccess.this.bestEffortRefresh(null, this);
        }
    }

    public AutomationRemoteDataAccess(@NotNull Context context, @NotNull RemoteData remoteData, @NotNull Network network) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(network, "network");
        this.context = context;
        this.remoteData = remoteData;
        this.network = network;
        final Flow<List<RemoteDataPayload>> flowPayloadFlow = remoteData.payloadFlow(REMOTE_DATA_TYPES);
        final InAppRemoteData.Companion companion = InAppRemoteData.INSTANCE;
        this.updatesFlow = new Flow<InAppRemoteData>() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataAccess\n*L\n1#1,218:1\n50#2:219\n53#3:220\n*E\n"})
            /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ InAppRemoteData.Companion receiver$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1$2", f = "AutomationRemoteDataAccess.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, InAppRemoteData.Companion companion) {
                    this.$this_unsafeFlow = flowCollector;
                    this.receiver$inlined = companion;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1$2$1 r0 = (com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1$2$1 r0 = new com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        com.urbanairship.automation.remotedata.InAppRemoteData$Companion r4 = r4.receiver$inlined
                        com.urbanairship.automation.remotedata.InAppRemoteData r4 = r4.fromPayloads(r5)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super InAppRemoteData> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flowPayloadFlow.collect(new AnonymousClass2(flowCollector, companion), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationRemoteDataAccess(Context context, RemoteData remoteData, Network network, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            network = Network.shared();
            Intrinsics.checkNotNullExpressionValue(network, "shared(...)");
        }
        this(context, remoteData, network);
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @NotNull
    public Flow<InAppRemoteData> getUpdatesFlow() {
        return this.updatesFlow;
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @NotNull
    public InAppAutomationRemoteDataStatus getStatus() {
        EnumEntries<RemoteDataSource> enumEntries = EntriesMappings.entries$0;
        RemoteData remoteData = this.remoteData;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enumEntries, 10));
        Iterator<RemoteDataSource> it = enumEntries.iterator();
        while (it.hasNext()) {
            arrayList.add(remoteData.status(it.next()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(AutomationRemoteDataAccessKt.toInAppDataSource((RemoteData.Status) it2.next()));
        }
        return InAppAutomationRemoteDataStatus.INSTANCE.reduce(arrayList2);
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @NotNull
    public Flow<InAppAutomationRemoteDataStatus> getStatusUpdates() {
        EnumEntries<RemoteDataSource> enumEntries = EntriesMappings.entries$0;
        RemoteData remoteData = this.remoteData;
        ArrayList<StateFlow> arrayList = new ArrayList();
        Iterator<RemoteDataSource> it = enumEntries.iterator();
        while (it.hasNext()) {
            StateFlow<RemoteData.Status> stateFlowStatusFlow = remoteData.statusFlow(it.next());
            if (stateFlowStatusFlow != null) {
                arrayList.add(stateFlowStatusFlow);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (final StateFlow stateFlow : arrayList) {
            arrayList2.add(new Flow<InAppAutomationRemoteDataStatus>() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataAccess\n*L\n1#1,218:1\n50#2:219\n67#3:220\n*E\n"})
                /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1$2", f = "AutomationRemoteDataAccess.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                    /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1$2$1 r0 = (com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1$2$1 r0 = new com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            r4.<init>(r5)
                            throw r4
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                            com.urbanairship.remotedata.RemoteData$Status r5 = (com.urbanairship.remotedata.RemoteData.Status) r5
                            com.urbanairship.automation.InAppAutomationRemoteDataStatus r5 = com.urbanairship.automation.remotedata.AutomationRemoteDataAccessKt.access$toInAppDataSource(r5)
                            r0.label = r3
                            java.lang.Object r4 = r4.emit(r5, r0)
                            if (r4 != r1) goto L45
                            return r1
                        L45:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$4$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super InAppAutomationRemoteDataStatus> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = stateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            });
        }
        final Flow[] flowArr = (Flow[]) CollectionsKt.toList(arrayList2).toArray(new Flow[0]);
        final Flow<List<? extends InAppAutomationRemoteDataStatus>> flow = new Flow<List<? extends InAppAutomationRemoteDataStatus>>() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$6$$inlined$combine$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends InAppAutomationRemoteDataStatus>> flowCollector, @NotNull Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<InAppAutomationRemoteDataStatus[]>() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$6$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final InAppAutomationRemoteDataStatus[] invoke() {
                        return new InAppAutomationRemoteDataStatus[flowArr2.length];
                    }
                }, new AnonymousClass3(null), continuation);
                return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$6$$inlined$combine$1$3", f = "AutomationRemoteDataAccess.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
            @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2\n+ 2 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataAccess\n*L\n1#1,328:1\n68#2:329\n*E\n"})
            /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$_get_statusUpdates_$lambda$6$$inlined$combine$1$3, reason: invalid class name */
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends InAppAutomationRemoteDataStatus>>, InAppAutomationRemoteDataStatus[], Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                @Nullable
                public final Object invoke(@NotNull FlowCollector<? super List<? extends InAppAutomationRemoteDataStatus>> flowCollector, @NotNull InAppAutomationRemoteDataStatus[] inAppAutomationRemoteDataStatusArr, @Nullable Continuation<? super Unit> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.L$0 = flowCollector;
                    anonymousClass3.L$1 = inAppAutomationRemoteDataStatusArr;
                    return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        List list = ArraysKt.toList((InAppAutomationRemoteDataStatus[]) ((Object[]) this.L$1));
                        this.label = 1;
                        if (flowCollector.emit(list, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        final InAppAutomationRemoteDataStatus.Companion companion = InAppAutomationRemoteDataStatus.INSTANCE;
        return new Flow<InAppAutomationRemoteDataStatus>() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataAccess\n*L\n1#1,218:1\n50#2:219\n69#3:220\n*E\n"})
            /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ InAppAutomationRemoteDataStatus.Companion receiver$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2$2", f = "AutomationRemoteDataAccess.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, InAppAutomationRemoteDataStatus.Companion companion) {
                    this.$this_unsafeFlow = flowCollector;
                    this.receiver$inlined = companion;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2$2$1 r0 = (com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2$2$1 r0 = new com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L47
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        com.urbanairship.automation.InAppAutomationRemoteDataStatus$Companion r4 = r4.receiver$inlined
                        com.urbanairship.automation.InAppAutomationRemoteDataStatus r4 = r4.reduce(r5)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$special$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super InAppAutomationRemoteDataStatus> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, companion), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    public boolean isCurrent(@NotNull AutomationSchedule schedule) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        if (!isRemote(schedule)) {
            return true;
        }
        RemoteDataInfo remoteDataInfo = remoteDataInfo(schedule);
        if (remoteDataInfo == null) {
            return false;
        }
        return this.remoteData.isCurrent(remoteDataInfo);
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    public boolean requiredUpdate(@NotNull AutomationSchedule schedule) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        if (!isRemote(schedule)) {
            return false;
        }
        RemoteDataInfo remoteDataInfo = remoteDataInfo(schedule);
        if (remoteDataInfo == null || !this.remoteData.isCurrent(remoteDataInfo)) {
            return true;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.remoteData.status(remoteDataInfo.getSource()).ordinal()];
        if (i == 1 || i == 2) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @Nullable
    public Object waitForFullRefresh(@NotNull AutomationSchedule automationSchedule, @NotNull Continuation<? super Unit> continuation) {
        RemoteDataSource source;
        if (!isRemote(automationSchedule)) {
            return Unit.INSTANCE;
        }
        RemoteDataInfo remoteDataInfo = remoteDataInfo(automationSchedule);
        if (remoteDataInfo == null || (source = remoteDataInfo.getSource()) == null) {
            source = RemoteDataSource.APP;
        }
        Object objWaitForRefresh$default = RemoteData.waitForRefresh$default(this.remoteData, source, null, continuation, 2, null);
        return objWaitForRefresh$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWaitForRefresh$default : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object bestEffortRefresh(@org.jetbrains.annotations.NotNull com.urbanairship.automation.AutomationSchedule r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.urbanairship.automation.remotedata.AutomationRemoteDataAccess.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$bestEffortRefresh$1 r0 = (com.urbanairship.automation.remotedata.AutomationRemoteDataAccess.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$bestEffortRefresh$1 r0 = new com.urbanairship.automation.remotedata.AutomationRemoteDataAccess$bestEffortRefresh$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r8 = r4.L$1
            com.urbanairship.remotedata.RemoteDataInfo r8 = (com.urbanairship.remotedata.RemoteDataInfo) r8
            java.lang.Object r9 = r4.L$0
            com.urbanairship.automation.remotedata.AutomationRemoteDataAccess r9 = (com.urbanairship.automation.remotedata.AutomationRemoteDataAccess) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r9
            r9 = r8
            r8 = r7
            goto L99
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r8.isRemote(r9)
            if (r10 != 0) goto L4c
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        L4c:
            com.urbanairship.remotedata.RemoteDataInfo r9 = r8.remoteDataInfo(r9)
            r10 = 0
            if (r9 != 0) goto L58
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r8
        L58:
            com.urbanairship.remotedata.RemoteData r1 = r8.remoteData
            boolean r1 = r1.isCurrent(r9)
            if (r1 != 0) goto L65
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r8
        L65:
            com.urbanairship.remotedata.RemoteData r10 = r8.remoteData
            com.urbanairship.remotedata.RemoteDataSource r1 = r9.getSource()
            com.urbanairship.remotedata.RemoteData$Status r10 = r10.status(r1)
            com.urbanairship.remotedata.RemoteData$Status r1 = com.urbanairship.remotedata.RemoteData.Status.UP_TO_DATE
            if (r10 != r1) goto L78
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        L78:
            com.urbanairship.util.Network r10 = r8.network
            android.content.Context r1 = r8.context
            boolean r10 = r10.isConnected(r1)
            if (r10 == 0) goto L99
            com.urbanairship.remotedata.RemoteData r1 = r8.remoteData
            com.urbanairship.remotedata.RemoteDataSource r10 = r9.getSource()
            r4.L$0 = r8
            r4.L$1 = r9
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r10
            java.lang.Object r10 = com.urbanairship.remotedata.RemoteData.waitForRefreshAttempt$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L99
            return r0
        L99:
            com.urbanairship.remotedata.RemoteData r8 = r8.remoteData
            boolean r8 = r8.isCurrent(r9)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess.bestEffortRefresh(com.urbanairship.automation.AutomationSchedule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @Nullable
    public Object notifyOutdated(@NotNull AutomationSchedule automationSchedule, @NotNull Continuation<? super Unit> continuation) {
        Object objNotifyOutdated;
        RemoteDataInfo remoteDataInfo = remoteDataInfo(automationSchedule);
        return (remoteDataInfo != null && (objNotifyOutdated = this.remoteData.notifyOutdated(remoteDataInfo, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objNotifyOutdated : Unit.INSTANCE;
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @Nullable
    public String contactIdFor(@NotNull AutomationSchedule schedule) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        RemoteDataInfo remoteDataInfo = remoteDataInfo(schedule);
        if (remoteDataInfo != null) {
            return remoteDataInfo.getContactId();
        }
        return null;
    }

    @Override // com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface
    @Nullable
    public RemoteDataSource sourceFor(@NotNull AutomationSchedule schedule) {
        RemoteDataSource source;
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        if (!isRemote(schedule)) {
            return null;
        }
        RemoteDataInfo remoteDataInfo = remoteDataInfo(schedule);
        return (remoteDataInfo == null || (source = remoteDataInfo.getSource()) == null) ? RemoteDataSource.APP : source;
    }

    private final boolean isRemote(AutomationSchedule schedule) throws JsonException {
        JsonMap jsonMapJsonMapOf;
        JsonValue metadata = schedule.getMetadata();
        if (metadata == null || (jsonMapJsonMapOf = metadata.optMap()) == null) {
            jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(new Pair[0]);
        }
        Intrinsics.checkNotNull(jsonMapJsonMapOf);
        if (jsonMapJsonMapOf.containsKey(InAppRemoteData.REMOTE_INFO_METADATA_KEY) || jsonMapJsonMapOf.containsKey(InAppRemoteData.LEGACY_REMOTE_INFO_METADATA_KEY)) {
            return true;
        }
        return (schedule.getData() instanceof AutomationSchedule.ScheduleData.InAppMessageData) && ((AutomationSchedule.ScheduleData.InAppMessageData) schedule.getData()).getMessage().getSource() == InAppMessage.Source.REMOTE_DATA;
    }

    private final RemoteDataInfo remoteDataInfo(final AutomationSchedule schedule) {
        JsonMap jsonMapOptMap;
        JsonValue jsonValue;
        RemoteDataInfo remoteDataInfo;
        JsonValue metadata = schedule.getMetadata();
        if (metadata == null || (jsonMapOptMap = metadata.optMap()) == null || (jsonValue = jsonMapOptMap.get(InAppRemoteData.REMOTE_INFO_METADATA_KEY)) == null) {
            return null;
        }
        try {
            if (jsonValue.isString()) {
                JsonValue string = JsonValue.parseString(jsonValue.getString());
                Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
                remoteDataInfo = new RemoteDataInfo(string);
            } else {
                remoteDataInfo = new RemoteDataInfo(jsonValue);
            }
            return remoteDataInfo;
        } catch (Exception e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataAccess.remoteDataInfo.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse remote info from schedule " + schedule;
                }
            });
            return null;
        }
    }
}
