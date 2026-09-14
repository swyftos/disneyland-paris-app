package com.urbanairship.iam.assets;

import android.content.Context;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ2\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m1836d2 = {"Lcom/urbanairship/iam/assets/AssetCacheManager;", "", "context", "Landroid/content/Context;", "downloader", "Lcom/urbanairship/iam/assets/AssetDownloader;", "fileManager", "Lcom/urbanairship/iam/assets/AssetFileManager;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/iam/assets/AssetDownloader;Lcom/urbanairship/iam/assets/AssetFileManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "downloadSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "getDownloadSemaphore", "()Lkotlinx/coroutines/sync/Semaphore;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tasks", "", "", "Lkotlinx/coroutines/Deferred;", "Lkotlin/Result;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "cacheAsset", "identifier", "assets", "", "cacheAsset-0E7RQCE", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAssetCacheManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssetCacheManager.kt\ncom/urbanairship/iam/assets/AssetCacheManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,123:1\n1#2:124\n*E\n"})
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

    /* JADX WARN: Code duplicated, block: B:28:0x0099 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    /* JADX INFO: renamed from: cacheAsset-0E7RQCE, reason: not valid java name */
    public final Object m5133cacheAsset0E7RQCE(@NotNull String str, @NotNull List<String> list, @NotNull Continuation<? super Result<? extends AirshipCachedAssets>> continuation) {
        AssetCacheManager$cacheAsset$1 assetCacheManager$cacheAsset$1;
        ReentrantLock reentrantLock;
        if (continuation instanceof AssetCacheManager$cacheAsset$1) {
            assetCacheManager$cacheAsset$1 = (AssetCacheManager$cacheAsset$1) continuation;
            int i = assetCacheManager$cacheAsset$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                assetCacheManager$cacheAsset$1.label = i - Integer.MIN_VALUE;
            } else {
                assetCacheManager$cacheAsset$1 = new AssetCacheManager$cacheAsset$1(this, continuation);
            }
        } else {
            assetCacheManager$cacheAsset$1 = new AssetCacheManager$cacheAsset$1(this, continuation);
        }
        Object objAwait = assetCacheManager$cacheAsset$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = assetCacheManager$cacheAsset$1.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    list = (List) assetCacheManager$cacheAsset$1.L$2;
                    str = (String) assetCacheManager$cacheAsset$1.L$1;
                    this = (AssetCacheManager) assetCacheManager$cacheAsset$1.L$0;
                    ResultKt.throwOnFailure(objAwait);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objAwait);
                }
                return ((Result) objAwait).getValue();
            }
            ResultKt.throwOnFailure(objAwait);
            ReentrantLock reentrantLock2 = this.lock;
            reentrantLock2.lock();
            try {
                Deferred deferred = (Deferred) this.tasks.get(str);
                reentrantLock2.unlock();
                if (deferred != null) {
                    assetCacheManager$cacheAsset$1.L$0 = this;
                    assetCacheManager$cacheAsset$1.L$1 = str;
                    assetCacheManager$cacheAsset$1.L$2 = list;
                    assetCacheManager$cacheAsset$1.label = 1;
                    objAwait = deferred.await(assetCacheManager$cacheAsset$1);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new AssetCacheManager$cacheAsset$task$1(this, str, list, null), 3, null);
                reentrantLock = this.lock;
                reentrantLock.lock();
                this.tasks.put(str, deferredAsync$default);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                assetCacheManager$cacheAsset$1.L$0 = null;
                assetCacheManager$cacheAsset$1.L$1 = null;
                assetCacheManager$cacheAsset$1.L$2 = null;
                assetCacheManager$cacheAsset$1.label = 2;
                objAwait = deferredAsync$default.await(assetCacheManager$cacheAsset$1);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return ((Result) objAwait).getValue();
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
            this.tasks.put(str, deferredAsync$default);
            Unit unit2 = Unit.INSTANCE;
            reentrantLock.unlock();
            assetCacheManager$cacheAsset$1.L$0 = null;
            assetCacheManager$cacheAsset$1.L$1 = null;
            assetCacheManager$cacheAsset$1.L$2 = null;
            assetCacheManager$cacheAsset$1.label = 2;
            objAwait = deferredAsync$default.await(assetCacheManager$cacheAsset$1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            return ((Result) objAwait).getValue();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
        Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new AssetCacheManager$cacheAsset$task$1(this, str, list, null), 3, null);
        reentrantLock = this.lock;
        reentrantLock.lock();
    }

    /* JADX INFO: renamed from: com.urbanairship.iam.assets.AssetCacheManager$clearCache$2 */
    static final class C53552 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $identifier;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C53552(String str, Continuation continuation) {
            super(2, continuation);
            this.$identifier = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AssetCacheManager.this.new C53552(this.$identifier, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C53552) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    reentrantLock.unlock();
                    if (deferred != null) {
                        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                    }
                    try {
                        AssetCacheManager.this.fileManager.clearAssets(this.$identifier);
                    } catch (Exception e) {
                        UALog.m1747e(e, new Function0() { // from class: com.urbanairship.iam.assets.AssetCacheManager.clearCache.2.2
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to clear cache";
                            }
                        });
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object clearCache(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C53552(str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
