package com.urbanairship.iam.assets;

import android.content.Context;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ2\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Lcom/urbanairship/iam/assets/AssetCacheManager;", "", "context", "Landroid/content/Context;", "downloader", "Lcom/urbanairship/iam/assets/AssetDownloader;", "fileManager", "Lcom/urbanairship/iam/assets/AssetFileManager;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/iam/assets/AssetDownloader;Lcom/urbanairship/iam/assets/AssetFileManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "downloadSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "getDownloadSemaphore", "()Lkotlinx/coroutines/sync/Semaphore;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "tasks", "", "", "Lkotlinx/coroutines/Deferred;", "Lkotlin/Result;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "cacheAsset", "identifier", "assets", "", "cacheAsset-0E7RQCE", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAssetCacheManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssetCacheManager.kt\ncom/urbanairship/iam/assets/AssetCacheManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,123:1\n1#2:124\n*E\n"})
/* loaded from: classes5.dex */
public final class AssetCacheManager {
    private final CoroutineDispatcher dispatcher;
    private final Semaphore downloadSemaphore;
    private final AssetDownloader downloader;
    private final AssetFileManager fileManager;
    private final ReentrantLock lock;
    private final CoroutineScope scope;
    private final Map tasks;

    public AssetCacheManager(@NotNull Context context, @NotNull AssetDownloader downloader, @NotNull AssetFileManager fileManager, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(fileManager, "fileManager");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.downloader = downloader;
        this.fileManager = fileManager;
        this.dispatcher = dispatcher;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.tasks = new LinkedHashMap();
        this.lock = new ReentrantLock();
        this.downloadSemaphore = SemaphoreKt.Semaphore$default(6, 0, 2, null);
    }

    public /* synthetic */ AssetCacheManager(Context context, AssetDownloader assetDownloader, AssetFileManager assetFileManager, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new DefaultAssetDownloader(context) : assetDownloader, (i & 4) != 0 ? new DefaultAssetFileManager(context, null, 2, 0 == true ? 1 : 0) : assetFileManager, (i & 8) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    @NotNull
    public final Semaphore getDownloadSemaphore() {
        return this.downloadSemaphore;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: cacheAsset-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2891cacheAsset0E7RQCE(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends com.urbanairship.iam.assets.AirshipCachedAssets>> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$1
            if (r0 == 0) goto L13
            r0 = r13
            com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$1 r0 = (com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$1 r0 = new com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L9a
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            java.lang.Object r10 = r0.L$2
            r12 = r10
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r10 = r0.L$1
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r0.L$0
            com.urbanairship.iam.assets.AssetCacheManager r10 = (com.urbanairship.iam.assets.AssetCacheManager) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L6a
        L46:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.concurrent.locks.ReentrantLock r13 = r10.lock
            r13.lock()
            java.util.Map r2 = r10.tasks     // Catch: java.lang.Throwable -> La6
            java.lang.Object r2 = r2.get(r11)     // Catch: java.lang.Throwable -> La6
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2     // Catch: java.lang.Throwable -> La6
            r13.unlock()
            if (r2 == 0) goto L6c
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r4
            java.lang.Object r13 = r2.await(r0)
            if (r13 != r1) goto L6a
            return r1
        L6a:
            kotlin.Result r13 = (kotlin.Result) r13
        L6c:
            kotlinx.coroutines.CoroutineScope r4 = r10.scope
            com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$task$1 r7 = new com.urbanairship.iam.assets.AssetCacheManager$cacheAsset$task$1
            r13 = 0
            r7.<init>(r10, r11, r12, r13)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)
            java.util.concurrent.locks.ReentrantLock r2 = r10.lock
            r2.lock()
            java.util.Map r10 = r10.tasks     // Catch: java.lang.Throwable -> La1
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> La1
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La1
            r2.unlock()
            r0.L$0 = r13
            r0.L$1 = r13
            r0.L$2 = r13
            r0.label = r3
            java.lang.Object r13 = r12.await(r0)
            if (r13 != r1) goto L9a
            return r1
        L9a:
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r10 = r13.getValue()
            return r10
        La1:
            r10 = move-exception
            r2.unlock()
            throw r10
        La6:
            r10 = move-exception
            r13.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.assets.AssetCacheManager.m2891cacheAsset0E7RQCE(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.iam.assets.AssetCacheManager$clearCache$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $identifier;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation continuation) {
            super(2, continuation);
            this.$identifier = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AssetCacheManager.this.new AnonymousClass2(this.$identifier, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ReentrantLock reentrantLock = AssetCacheManager.this.lock;
                AssetCacheManager assetCacheManager = AssetCacheManager.this;
                String str = this.$identifier;
                reentrantLock.lock();
                try {
                    Deferred deferred = (Deferred) assetCacheManager.tasks.remove(str);
                    if (deferred != null) {
                        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                    }
                    try {
                        AssetCacheManager.this.fileManager.clearAssets(this.$identifier);
                    } catch (Exception e) {
                        UALog.e(e, new Function0() { // from class: com.urbanairship.iam.assets.AssetCacheManager.clearCache.2.2
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to clear cache";
                            }
                        });
                    }
                    return Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object clearCache(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass2(str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
