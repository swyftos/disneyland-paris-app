package com.urbanairship.automation.limits;

import android.content.Context;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.automation.limits.storage.FrequencyLimitDao;
import com.urbanairship.automation.limits.storage.FrequencyLimitDatabase;
import com.urbanairship.automation.limits.storage.OccurrenceEntity;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.util.Clock;
import com.urbanairship.util.SerialQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001b\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eH\u0001¢\u0006\u0002\b\u001fJ.\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001eH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100'H\u0001¢\u0006\u0002\b(J\u0016\u0010)\u001a\u00020*2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eH\u0002J*\u0010+\u001a\b\u0012\u0004\u0012\u00020*0!2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001eH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010%J\u000e\u0010/\u001a\u00020*H\u0082@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020*H\u0087@¢\u0006\u0002\u00100R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Lcom/urbanairship/automation/limits/FrequencyLimitManager;", "", "context", "Landroid/content/Context;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "(Landroid/content/Context;Lcom/urbanairship/config/AirshipRuntimeConfig;)V", "dao", "Lcom/urbanairship/automation/limits/storage/FrequencyLimitDao;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/automation/limits/storage/FrequencyLimitDao;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "constraintMap", "", "", "Lcom/urbanairship/automation/limits/ConstraintInfo;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "pendingOccurrences", "", "Lcom/urbanairship/automation/limits/storage/OccurrenceEntity;", "queue", "Lcom/urbanairship/util/SerialQueue;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "checkAndIncrement", "", "constraintIDs", "", "checkAndIncrement$urbanairship_automation_release", "getFrequencyChecker", "Lkotlin/Result;", "Lcom/urbanairship/automation/limits/FrequencyChecker;", "constraintIds", "getFrequencyChecker-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOverLimit", "", "isOverLimit$urbanairship_automation_release", "recordOccurrence", "", "setConstraints", "constraints", "Lcom/urbanairship/automation/limits/FrequencyConstraint;", "setConstraints-gIAlu-s", "writePending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePendingInQueue", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFrequencyLimitManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrequencyLimitManager.kt\ncom/urbanairship/automation/limits/FrequencyLimitManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,235:1\n1747#2,3:236\n1855#2,2:239\n1549#2:241\n1620#2,3:242\n1855#2,2:245\n*S KotlinDebug\n*F\n+ 1 FrequencyLimitManager.kt\ncom/urbanairship/automation/limits/FrequencyLimitManager\n*L\n49#1:236,3\n87#1:239,2\n114#1:241\n114#1:242,3\n119#1:245,2\n*E\n"})
/* loaded from: classes5.dex */
public final class FrequencyLimitManager {
    private final Clock clock;
    private final Map constraintMap;
    private final FrequencyLimitDao dao;
    private final ReentrantLock lock;
    private final List pendingOccurrences;
    private final SerialQueue queue;
    private final CoroutineScope scope;

    /* renamed from: com.urbanairship.automation.limits.FrequencyLimitManager$writePending$1, reason: invalid class name */
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
            return FrequencyLimitManager.this.writePending(this);
        }
    }

    public FrequencyLimitManager(@NotNull FrequencyLimitDao dao, @NotNull Clock clock, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dao = dao;
        this.clock = clock;
        this.lock = new ReentrantLock();
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.constraintMap = new LinkedHashMap();
        this.pendingOccurrences = new ArrayList();
        this.queue = new SerialQueue();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FrequencyLimitManager(FrequencyLimitDao frequencyLimitDao, Clock DEFAULT_CLOCK, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(frequencyLimitDao, DEFAULT_CLOCK, (i & 4) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrequencyLimitManager(@NotNull Context context, @NotNull AirshipRuntimeConfig config) {
        this(FrequencyLimitDatabase.INSTANCE.createDatabase(context, config).getDao(), null, null, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @VisibleForTesting
    public final boolean isOverLimit$urbanairship_automation_release(@NotNull Collection<String> constraintIDs) {
        Intrinsics.checkNotNullParameter(constraintIDs, "constraintIDs");
        boolean z = false;
        if (constraintIDs.isEmpty()) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!constraintIDs.isEmpty()) {
                Iterator<T> it = constraintIDs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ConstraintInfo constraintInfo = (ConstraintInfo) this.constraintMap.get((String) it.next());
                    if (constraintInfo != null && constraintInfo.getOccurrences().size() >= constraintInfo.getConstraint().getCount()) {
                        CollectionsKt.sortWith(constraintInfo.getOccurrences(), new OccurrenceEntity.Comparator());
                        long timeStamp = ((OccurrenceEntity) constraintInfo.getOccurrences().get(constraintInfo.getOccurrences().size() - constraintInfo.getConstraint().getCount())).getTimeStamp();
                        Duration.Companion companion = Duration.INSTANCE;
                        if (Duration.m3466compareToLRDsOJo(DurationKt.toDuration(this.clock.currentTimeMillis() - timeStamp, DurationUnit.MILLISECONDS), constraintInfo.getConstraint().m2817getRangeUwyO8pc()) <= 0) {
                            z = true;
                            break;
                        }
                    }
                }
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    @VisibleForTesting
    public final boolean checkAndIncrement$urbanairship_automation_release(@NotNull List<String> constraintIDs) {
        Intrinsics.checkNotNullParameter(constraintIDs, "constraintIDs");
        if (constraintIDs.isEmpty()) {
            return true;
        }
        if (isOverLimit$urbanairship_automation_release(constraintIDs)) {
            return false;
        }
        recordOccurrence(constraintIDs);
        return true;
    }

    private final void recordOccurrence(List constraintIDs) {
        if (constraintIDs.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator it = constraintIDs.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                ConstraintInfo constraintInfo = (ConstraintInfo) this.constraintMap.get(str);
                if (constraintInfo != null) {
                    OccurrenceEntity occurrenceEntity = new OccurrenceEntity();
                    occurrenceEntity.setParentConstraintId(str);
                    occurrenceEntity.setTimeStamp(jCurrentTimeMillis);
                    this.pendingOccurrences.add(occurrenceEntity);
                    constraintInfo.getOccurrences().add(occurrenceEntity);
                }
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* renamed from: com.urbanairship.automation.limits.FrequencyLimitManager$recordOccurrence$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FrequencyLimitManager.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FrequencyLimitManager frequencyLimitManager = FrequencyLimitManager.this;
                this.label = 1;
                if (frequencyLimitManager.writePendingInQueue(this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.automation.limits.FrequencyLimitManager$writePendingInQueue$2, reason: invalid class name and case insensitive filesystem */
    static final class C10552 extends SuspendLambda implements Function1 {
        int label;

        C10552(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return FrequencyLimitManager.this.new C10552(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10552) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FrequencyLimitManager frequencyLimitManager = FrequencyLimitManager.this;
                this.label = 1;
                if (frequencyLimitManager.writePending(this) == coroutine_suspended) {
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

    @VisibleForTesting
    @Nullable
    public final Object writePendingInQueue(@NotNull Continuation<? super Unit> continuation) {
        Object objRun = this.queue.run(new C10552(null), continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0091 -> B:34:0x0092). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writePending(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.urbanairship.automation.limits.FrequencyLimitManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.automation.limits.FrequencyLimitManager$writePending$1 r0 = (com.urbanairship.automation.limits.FrequencyLimitManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.limits.FrequencyLimitManager$writePending$1 r0 = new com.urbanairship.automation.limits.FrequencyLimitManager$writePending$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$0
            com.urbanairship.automation.limits.FrequencyLimitManager r2 = (com.urbanairship.automation.limits.FrequencyLimitManager) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: android.database.sqlite.SQLiteException -> L31
            goto L92
        L31:
            r8 = move-exception
            goto L98
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r7.lock
            r8.lock()
            java.util.List r2 = r7.pendingOccurrences     // Catch: java.lang.Throwable -> L65
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L65
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)     // Catch: java.lang.Throwable -> L65
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L65
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L65
        L55:
            boolean r5 = r2.hasNext()     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L67
            java.lang.Object r5 = r2.next()     // Catch: java.lang.Throwable -> L65
            com.urbanairship.automation.limits.storage.OccurrenceEntity r5 = (com.urbanairship.automation.limits.storage.OccurrenceEntity) r5     // Catch: java.lang.Throwable -> L65
            r4.add(r5)     // Catch: java.lang.Throwable -> L65
            goto L55
        L65:
            r7 = move-exception
            goto L9f
        L67:
            java.util.List r2 = r7.pendingOccurrences     // Catch: java.lang.Throwable -> L65
            r2.clear()     // Catch: java.lang.Throwable -> L65
            r8.unlock()
            java.util.Iterator r8 = r4.iterator()
            r6 = r8
            r8 = r7
            r7 = r6
        L76:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L9c
            java.lang.Object r2 = r7.next()
            com.urbanairship.automation.limits.storage.OccurrenceEntity r2 = (com.urbanairship.automation.limits.storage.OccurrenceEntity) r2
            com.urbanairship.automation.limits.storage.FrequencyLimitDao r4 = r8.dao     // Catch: android.database.sqlite.SQLiteException -> L94
            r0.L$0 = r8     // Catch: android.database.sqlite.SQLiteException -> L94
            r0.L$1 = r7     // Catch: android.database.sqlite.SQLiteException -> L94
            r0.label = r3     // Catch: android.database.sqlite.SQLiteException -> L94
            java.lang.Object r2 = r4.insert(r2, r0)     // Catch: android.database.sqlite.SQLiteException -> L94
            if (r2 != r1) goto L91
            return r1
        L91:
            r2 = r8
        L92:
            r8 = r2
            goto L76
        L94:
            r2 = move-exception
            r6 = r2
            r2 = r8
            r8 = r6
        L98:
            com.urbanairship.UALog.v(r8)
            goto L92
        L9c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L9f:
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.limits.FrequencyLimitManager.writePending(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getFrequencyChecker-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2815getFrequencyCheckergIAlus(@org.jetbrains.annotations.Nullable java.util.List<java.lang.String> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.urbanairship.automation.limits.FrequencyChecker>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$1 r0 = (com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$1 r0 = new com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            if (r6 == 0) goto L55
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L3e
            goto L55
        L3e:
            com.urbanairship.util.SerialQueue r2 = r5.queue
            com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$2 r4 = new com.urbanairship.automation.limits.FrequencyLimitManager$getFrequencyChecker$2
            r4.<init>(r5, r6, r7)
            r0.label = r3
            java.lang.Object r7 = r2.run(r4, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            return r5
        L55:
            java.lang.Object r5 = kotlin.Result.m2968constructorimpl(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.limits.FrequencyLimitManager.m2815getFrequencyCheckergIAlus(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: setConstraints-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2816setConstraintsgIAlus(@org.jetbrains.annotations.NotNull java.util.List<com.urbanairship.automation.limits.FrequencyConstraint> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.automation.limits.FrequencyLimitManager$setConstraints$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.automation.limits.FrequencyLimitManager$setConstraints$1 r0 = (com.urbanairship.automation.limits.FrequencyLimitManager$setConstraints$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.limits.FrequencyLimitManager$setConstraints$1 r0 = new com.urbanairship.automation.limits.FrequencyLimitManager$setConstraints$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.util.SerialQueue r7 = r5.queue
            com.urbanairship.automation.limits.FrequencyLimitManager$setConstraints$2 r2 = new com.urbanairship.automation.limits.FrequencyLimitManager$setConstraints$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = r7.run(r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.limits.FrequencyLimitManager.m2816setConstraintsgIAlus(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
