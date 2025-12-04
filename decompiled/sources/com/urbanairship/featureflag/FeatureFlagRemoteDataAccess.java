package com.urbanairship.featureflag;

import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.remotedata.RemoteData;
import com.urbanairship.remotedata.RemoteDataSource;
import com.urbanairship.util.Clock;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0086@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagRemoteDataAccess;", "", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/remotedata/RemoteData;Lcom/urbanairship/util/Clock;)V", "status", "Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/featureflag/FeatureFlagRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "bestEffortRefresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFlagRemoteInfo", "Lcom/urbanairship/featureflag/RemoteDataFeatureFlagInfo;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyOutOfDate", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "(Lcom/urbanairship/remotedata/RemoteDataInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFeatureFlagRemoteDataAccess.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagRemoteDataAccess.kt\ncom/urbanairship/featureflag/FeatureFlagRemoteDataAccess\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n49#2:77\n51#2:81\n46#3:78\n51#3:80\n105#4:79\n766#5:82\n857#5,2:83\n*S KotlinDebug\n*F\n+ 1 FeatureFlagRemoteDataAccess.kt\ncom/urbanairship/featureflag/FeatureFlagRemoteDataAccess\n*L\n30#1:77\n30#1:81\n30#1:78\n30#1:80\n30#1:79\n45#1:82\n45#1:83,2\n*E\n"})
/* loaded from: classes5.dex */
public final class FeatureFlagRemoteDataAccess {
    private static final long MAX_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(15);
    private final Clock clock;
    private final RemoteData remoteData;

    /* renamed from: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$1, reason: invalid class name */
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
            return FeatureFlagRemoteDataAccess.this.fetchFlagRemoteInfo(null, this);
        }
    }

    /* renamed from: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$notifyOutOfDate$1, reason: invalid class name and case insensitive filesystem */
    static final class C11271 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11271(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeatureFlagRemoteDataAccess.this.notifyOutOfDate(null, this);
        }
    }

    public FeatureFlagRemoteDataAccess(@NotNull RemoteData remoteData, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.remoteData = remoteData;
        this.clock = clock;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FeatureFlagRemoteDataAccess(RemoteData remoteData, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(remoteData, DEFAULT_CLOCK);
    }

    @NotNull
    public final FeatureFlagRemoteDataStatus getStatus() {
        return FeatureFlagRemoteDataAccessKt.toFeatureFlagStatus(this.remoteData.status(RemoteDataSource.APP));
    }

    @Nullable
    public final Flow<FeatureFlagRemoteDataStatus> getStatusUpdates() {
        final StateFlow<RemoteData.Status> stateFlowStatusFlow = this.remoteData.statusFlow(RemoteDataSource.APP);
        if (stateFlowStatusFlow != null) {
            return new Flow<FeatureFlagRemoteDataStatus>() { // from class: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 FeatureFlagRemoteDataAccess.kt\ncom/urbanairship/featureflag/FeatureFlagRemoteDataAccess\n*L\n1#1,218:1\n50#2:219\n30#3:220\n*E\n"})
                /* renamed from: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1$2", f = "FeatureFlagRemoteDataAccess.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                    /* renamed from: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1$2$1, reason: invalid class name */
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
                            boolean r0 = r6 instanceof com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1$2$1 r0 = (com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1$2$1 r0 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1$2$1
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
                            com.urbanairship.featureflag.FeatureFlagRemoteDataStatus r5 = com.urbanairship.featureflag.FeatureFlagRemoteDataAccessKt.access$toFeatureFlagStatus(r5)
                            r0.label = r3
                            java.lang.Object r4 = r4.emit(r5, r0)
                            if (r4 != r1) goto L45
                            return r1
                        L45:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super FeatureFlagRemoteDataStatus> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = stateFlowStatusFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
        }
        return null;
    }

    @Nullable
    public final Object bestEffortRefresh(@NotNull Continuation<? super Unit> continuation) {
        Object objWaitForRefresh = this.remoteData.waitForRefresh(RemoteDataSource.APP, Boxing.boxLong(MAX_TIMEOUT_MILLIS), continuation);
        return objWaitForRefresh == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWaitForRefresh : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object notifyOutOfDate(@org.jetbrains.annotations.Nullable com.urbanairship.remotedata.RemoteDataInfo r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.featureflag.FeatureFlagRemoteDataAccess.C11271
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$notifyOutOfDate$1 r0 = (com.urbanairship.featureflag.FeatureFlagRemoteDataAccess.C11271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$notifyOutOfDate$1 r0 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$notifyOutOfDate$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.urbanairship.remotedata.RemoteDataInfo r4 = (com.urbanairship.remotedata.RemoteDataInfo) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 == 0) goto L47
            com.urbanairship.remotedata.RemoteData r4 = r4.remoteData
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.notifyOutdated(r5, r0)
            if (r4 != r1) goto L47
            return r1
        L47:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess.notifyOutOfDate(com.urbanairship.remotedata.RemoteDataInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchFlagRemoteInfo(@org.jetbrains.annotations.NotNull final java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.featureflag.RemoteDataFeatureFlagInfo> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.featureflag.FeatureFlagRemoteDataAccess.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$1 r0 = (com.urbanairship.featureflag.FeatureFlagRemoteDataAccess.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$1 r0 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess r4 = (com.urbanairship.featureflag.FeatureFlagRemoteDataAccess) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.remotedata.RemoteData r6 = r4.remoteData
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.String r2 = "feature_flags"
            java.lang.Object r6 = r6.payloads(r2, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L59:
            boolean r1 = r6.hasNext()
            r2 = 0
            if (r1 == 0) goto L79
            java.lang.Object r1 = r6.next()
            r3 = r1
            com.urbanairship.remotedata.RemoteDataPayload r3 = (com.urbanairship.remotedata.RemoteDataPayload) r3
            com.urbanairship.remotedata.RemoteDataInfo r3 = r3.getRemoteDataInfo()
            if (r3 == 0) goto L71
            com.urbanairship.remotedata.RemoteDataSource r2 = r3.getSource()
        L71:
            com.urbanairship.remotedata.RemoteDataSource r3 = com.urbanairship.remotedata.RemoteDataSource.APP
            if (r2 != r3) goto L59
            r0.add(r1)
            goto L59
        L79:
            kotlin.sequences.Sequence r6 = kotlin.collections.CollectionsKt.asSequence(r0)
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1 r1 = new kotlin.jvm.functions.Function1() { // from class: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1
                static {
                    /*
                        com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1 r0 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1) com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1.INSTANCE com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        com.urbanairship.remotedata.RemoteDataPayload r1 = (com.urbanairship.remotedata.RemoteDataPayload) r1
                        java.util.List r0 = r0.invoke(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1.invoke(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.util.List invoke(com.urbanairship.remotedata.RemoteDataPayload r1) {
                    /*
                        r0 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                        com.urbanairship.json.JsonMap r0 = r1.getData()
                        java.lang.String r1 = "feature_flags"
                        com.urbanairship.json.JsonValue r0 = r0.opt(r1)
                        com.urbanairship.json.JsonList r0 = r0.getList()
                        if (r0 == 0) goto L1a
                        java.util.List r0 = r0.getList()
                        goto L1b
                    L1a:
                        r0 = 0
                    L1b:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$1.invoke(com.urbanairship.remotedata.RemoteDataPayload):java.util.List");
                }
            }
            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.mapNotNull(r6, r1)
            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.flattenSequenceOfIterable(r6)
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2 r1 = new kotlin.jvm.functions.Function1() { // from class: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2
                static {
                    /*
                        com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2 r0 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2) com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2.INSTANCE com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final com.urbanairship.json.JsonMap invoke(com.urbanairship.json.JsonValue r1) {
                    /*
                        r0 = this;
                        com.urbanairship.json.JsonMap r0 = r1.optMap()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2.invoke(com.urbanairship.json.JsonValue):com.urbanairship.json.JsonMap");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        com.urbanairship.json.JsonValue r1 = (com.urbanairship.json.JsonValue) r1
                        com.urbanairship.json.JsonMap r0 = r0.invoke(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$2.invoke(java.lang.Object):java.lang.Object");
                }
            }
            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.map(r6, r1)
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$3 r1 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$3
            com.urbanairship.featureflag.FeatureFlagInfo$Companion r3 = com.urbanairship.featureflag.FeatureFlagInfo.INSTANCE
            r1.<init>(r3)
            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.mapNotNull(r6, r1)
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$4 r1 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$4
            r1.<init>()
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt.filter(r6, r1)
            com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$5 r6 = new com.urbanairship.featureflag.FeatureFlagRemoteDataAccess$fetchFlagRemoteInfo$flags$5
            r6.<init>()
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.filter(r5, r6)
            java.util.List r4 = kotlin.sequences.SequencesKt.toList(r4)
            com.urbanairship.featureflag.RemoteDataFeatureFlagInfo r5 = new com.urbanairship.featureflag.RemoteDataFeatureFlagInfo
            java.lang.Object r6 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.urbanairship.remotedata.RemoteDataPayload r6 = (com.urbanairship.remotedata.RemoteDataPayload) r6
            if (r6 == 0) goto Lbc
            com.urbanairship.remotedata.RemoteDataInfo r2 = r6.getRemoteDataInfo()
        Lbc:
            r5.<init>(r4, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagRemoteDataAccess.fetchFlagRemoteInfo(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
