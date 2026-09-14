package coil3;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.MimeTypes;
import ch.qos.logback.core.CoreConstants;
import coil3.content.Logger;
import coil3.content.SystemCallbacks;
import coil3.content.SystemCallbacksKt;
import coil3.content.UtilsKt;
import coil3.decode.DataSource;
import coil3.disk.DiskCache;
import coil3.intercept.EngineInterceptor;
import coil3.memory.MemoryCache;
import coil3.request.Disposable;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.request.NullRequestData;
import coil3.request.NullRequestDataException;
import coil3.request.RequestDelegate;
import coil3.request.RequestService;
import coil3.request.RequestService_androidKt;
import coil3.request.SuccessResult;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.target.Target;
import coil3.transition.NoneTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\b\u0010!\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J\"\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u00020.2\u0006\u00102\u001a\u0002092\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010:\u001a\u00020.2\u0006\u0010%\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017*\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c*\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\t\u0010!\u001a\u00020\"X\u0082\u0004¨\u0006<"}, m1836d2 = {"Lcoil3/RealImageLoader;", "Lcoil3/ImageLoader;", "options", "Lcoil3/RealImageLoader$Options;", "<init>", "(Lcoil3/RealImageLoader$Options;)V", "getOptions", "()Lcoil3/RealImageLoader$Options;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "systemCallbacks", "Lcoil3/util/SystemCallbacks;", "requestService", "Lcoil3/request/RequestService;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "memoryCache", "Lcoil3/memory/MemoryCache;", "getMemoryCache$delegate", "(Lcoil3/RealImageLoader;)Ljava/lang/Object;", "getMemoryCache", "()Lcoil3/memory/MemoryCache;", "diskCache", "Lcoil3/disk/DiskCache;", "getDiskCache$delegate", "getDiskCache", "()Lcoil3/disk/DiskCache;", "components", "Lcoil3/ComponentRegistry;", "getComponents", "()Lcoil3/ComponentRegistry;", "shutdown", "Lkotlinx/atomicfu/AtomicBoolean;", "enqueue", "Lcoil3/request/Disposable;", "request", "Lcoil3/request/ImageRequest;", "execute", "Lcoil3/request/ImageResult;", "(Lcoil3/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialRequest", "type", "", "(Lcoil3/request/ImageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "newBuilder", "Lcoil3/ImageLoader$Builder;", "onSuccess", "result", "Lcoil3/request/SuccessResult;", TypedValues.AttributesType.S_TARGET, "Lcoil3/target/Target;", "eventListener", "Lcoil3/EventListener;", "onError", "Lcoil3/request/ErrorResult;", "onCancel", "Options", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nRealImageLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealImageLoader.kt\ncoil3/RealImageLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 logging.kt\ncoil3/util/LoggingKt\n+ 4 RealImageLoader.android.kt\ncoil3/RealImageLoader_androidKt\n*L\n1#1,307:1\n1#2:308\n68#3,4:309\n62#3,4:328\n68#3,4:347\n57#4,15:313\n57#4,15:332\n*S KotlinDebug\n*F\n+ 1 RealImageLoader.kt\ncoil3/RealImageLoader\n*L\n181#1:309,4\n197#1:328,4\n211#1:347,4\n184#1:313,15\n200#1:332,15\n*E\n"})
public final class RealImageLoader implements ImageLoader {
    private static final /* synthetic */ AtomicIntegerFieldUpdater shutdown$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RealImageLoader.class, "shutdown$volatile");
    private final ComponentRegistry components;
    private final Options options;
    private final RequestService requestService;
    private final CoroutineScope scope;
    private volatile /* synthetic */ int shutdown$volatile;
    private final SystemCallbacks systemCallbacks;

    /* JADX INFO: renamed from: coil3.RealImageLoader$execute$3 */
    static final class C17513 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C17513(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealImageLoader.this.execute(null, 0, this);
        }
    }

    public RealImageLoader(@NotNull Options options) {
        this.options = options;
        this.scope = RealImageLoaderKt.CoroutineScope(options.getLogger());
        SystemCallbacks SystemCallbacks = SystemCallbacksKt.SystemCallbacks(this);
        this.systemCallbacks = SystemCallbacks;
        RequestService RequestService = RequestService_androidKt.RequestService(this, SystemCallbacks, options.getLogger());
        this.requestService = RequestService;
        options.getMemoryCacheLazy();
        options.getDiskCacheLazy();
        this.components = RealImageLoaderKt.addCommonComponents(RealImageLoader_nonNativeKt.addAppleComponents(RealImageLoader_jvmCommonKt.addJvmComponents(RealImageLoader_androidKt.addAndroidComponents(RealImageLoaderKt.addServiceLoaderComponents(options.getComponentRegistry().newBuilder(), options), options), options), options)).add(new EngineInterceptor(this, SystemCallbacks, RequestService, options.getLogger())).build();
        this.shutdown$volatile = 0;
    }

    @NotNull
    public final Options getOptions() {
        return this.options;
    }

    @Override // coil3.ImageLoader
    @NotNull
    public ImageRequest.Defaults getDefaults() {
        return this.options.getDefaults();
    }

    @Override // coil3.ImageLoader
    @Nullable
    public MemoryCache getMemoryCache() {
        return this.options.getMemoryCacheLazy().getValue();
    }

    @Override // coil3.ImageLoader
    @Nullable
    public DiskCache getDiskCache() {
        return this.options.getDiskCacheLazy().getValue();
    }

    @Override // coil3.ImageLoader
    @NotNull
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil3.ImageLoader
    @NotNull
    public Disposable enqueue(@NotNull ImageRequest request) {
        return RealImageLoader_androidKt.getDisposable(request, BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, request, null), 3, null));
    }

    @Override // coil3.ImageLoader
    @Nullable
    public Object execute(@NotNull ImageRequest imageRequest, @NotNull Continuation<? super ImageResult> continuation) {
        if (RealImageLoader_androidKt.needsExecuteOnMainDispatcher(imageRequest)) {
            return CoroutineScopeKt.coroutineScope(new C17502(imageRequest, this, null), continuation);
        }
        return execute(imageRequest, 1, continuation);
    }

    /* JADX INFO: renamed from: coil3.RealImageLoader$execute$2 */
    static final class C17502 extends SuspendLambda implements Function2 {
        final /* synthetic */ ImageRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RealImageLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17502(ImageRequest imageRequest, RealImageLoader realImageLoader, Continuation continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.this$0 = realImageLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C17502 c17502 = new C17502(this.$request, this.this$0, continuation);
            c17502.L$0 = obj;
            return c17502;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C17502) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred<ImageResult> job = RealImageLoader_androidKt.getDisposable(this.$request, BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, Dispatchers.getMain().getImmediate(), null, new RealImageLoader$execute$2$job$1(this.this$0, this.$request, null), 2, null)).getJob();
                this.label = 1;
                obj = job.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:69:0x0177 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x0178  */
    /* JADX WARN: Code duplicated, block: B:73:0x0180 A[Catch: all -> 0x018b, TryCatch #5 {all -> 0x018b, blocks: (B:71:0x017a, B:73:0x0180, B:76:0x018d, B:78:0x0191, B:81:0x019f, B:82:0x01a4), top: B:106:0x017a }] */
    /* JADX WARN: Code duplicated, block: B:76:0x018d A[Catch: all -> 0x018b, TryCatch #5 {all -> 0x018b, blocks: (B:71:0x017a, B:73:0x0180, B:76:0x018d, B:78:0x0191, B:81:0x019f, B:82:0x01a4), top: B:106:0x017a }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0191 A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #5 {all -> 0x018b, blocks: (B:71:0x017a, B:73:0x0180, B:76:0x018d, B:78:0x0191, B:81:0x019f, B:82:0x01a4), top: B:106:0x017a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:81:0x019f A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #5 {all -> 0x018b, blocks: (B:71:0x017a, B:73:0x0180, B:76:0x018d, B:78:0x0191, B:81:0x019f, B:82:0x01a4), top: B:106:0x017a }] */
    public final Object execute(ImageRequest imageRequest, int i, Continuation continuation) {
        C17513 c17513;
        RequestDelegate requestDelegate;
        ImageRequest imageRequestUpdateRequest;
        EventListener eventListenerCreate;
        ImageRequest imageRequest2;
        RequestDelegate requestDelegate2;
        ImageRequest imageRequest3;
        Image image;
        ImageRequest imageRequest4;
        RequestDelegate requestDelegate3;
        MemoryCache memoryCache;
        MemoryCache.Value value;
        ImageResult imageResult;
        RealImageLoader realImageLoader = this;
        if (continuation instanceof C17513) {
            c17513 = (C17513) continuation;
            int i2 = c17513.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c17513.label = i2 - Integer.MIN_VALUE;
            } else {
                c17513 = realImageLoader.new C17513(continuation);
            }
        } else {
            c17513 = realImageLoader.new C17513(continuation);
        }
        Object objWithContext = c17513.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c17513.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            requestDelegate = realImageLoader.requestService.requestDelegate(imageRequest, JobKt.getJob(c17513.getContext()), i == 0);
            requestDelegate.assertActive();
            imageRequestUpdateRequest = realImageLoader.requestService.updateRequest(imageRequest);
            eventListenerCreate = realImageLoader.options.getEventListenerFactory().create(imageRequestUpdateRequest);
            try {
                if (Intrinsics.areEqual(imageRequestUpdateRequest.getData(), NullRequestData.INSTANCE)) {
                    throw new NullRequestDataException();
                }
                requestDelegate.start();
                if (i == 0) {
                    c17513.L$0 = realImageLoader;
                    c17513.L$1 = requestDelegate;
                    c17513.L$2 = imageRequestUpdateRequest;
                    c17513.L$3 = eventListenerCreate;
                    c17513.label = 1;
                    if (requestDelegate.awaitStarted(c17513) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestDelegate2 = requestDelegate;
                    imageRequest3 = imageRequestUpdateRequest;
                    imageRequestUpdateRequest = imageRequest3;
                    requestDelegate = requestDelegate2;
                }
            } catch (Throwable th) {
                th = th;
                imageRequest2 = imageRequestUpdateRequest;
            }
        } else {
            if (i3 == 1) {
                EventListener eventListener = (EventListener) c17513.L$3;
                imageRequest3 = (ImageRequest) c17513.L$2;
                requestDelegate2 = (RequestDelegate) c17513.L$1;
                RealImageLoader realImageLoader2 = (RealImageLoader) c17513.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    eventListenerCreate = eventListener;
                    realImageLoader = realImageLoader2;
                    imageRequestUpdateRequest = imageRequest3;
                    requestDelegate = requestDelegate2;
                } catch (Throwable th2) {
                    th = th2;
                    imageRequest2 = imageRequest3;
                    requestDelegate = requestDelegate2;
                    eventListenerCreate = eventListener;
                    realImageLoader = realImageLoader2;
                }
            } else if (i3 == 2) {
                Image image2 = (Image) c17513.L$4;
                EventListener eventListener2 = (EventListener) c17513.L$3;
                imageRequest4 = (ImageRequest) c17513.L$2;
                requestDelegate3 = (RequestDelegate) c17513.L$1;
                RealImageLoader realImageLoader3 = (RealImageLoader) c17513.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    image = image2;
                    eventListenerCreate = eventListener2;
                    realImageLoader = realImageLoader3;
                    try {
                        Size size = (Size) objWithContext;
                        eventListenerCreate.resolveSizeEnd(imageRequest4, size);
                        CoroutineContext interceptorCoroutineContext = imageRequest4.getInterceptorCoroutineContext();
                        RealImageLoader$execute$result$1 realImageLoader$execute$result$1 = new RealImageLoader$execute$result$1(imageRequest4, realImageLoader, size, eventListenerCreate, image, null);
                        c17513.L$0 = realImageLoader;
                        c17513.L$1 = requestDelegate3;
                        c17513.L$2 = imageRequest4;
                        c17513.L$3 = eventListenerCreate;
                        c17513.L$4 = null;
                        c17513.label = 3;
                        objWithContext = BuildersKt.withContext(interceptorCoroutineContext, realImageLoader$execute$result$1, c17513);
                        if (objWithContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        imageRequest2 = imageRequest4;
                        requestDelegate = requestDelegate3;
                        imageResult = (ImageResult) objWithContext;
                        if (imageResult instanceof SuccessResult) {
                            realImageLoader.onSuccess((SuccessResult) imageResult, imageRequest2.getTarget(), eventListenerCreate);
                        } else {
                            if (!(imageResult instanceof ErrorResult)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            realImageLoader.onError((ErrorResult) imageResult, imageRequest2.getTarget(), eventListenerCreate);
                        }
                        requestDelegate.complete();
                        return imageResult;
                    } catch (Throwable th3) {
                        th = th3;
                        imageRequest2 = imageRequest4;
                        requestDelegate = requestDelegate3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    eventListenerCreate = eventListener2;
                    imageRequest2 = imageRequest4;
                    requestDelegate = requestDelegate3;
                    realImageLoader = realImageLoader3;
                }
            } else {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                EventListener eventListener3 = (EventListener) c17513.L$3;
                imageRequest2 = (ImageRequest) c17513.L$2;
                requestDelegate = (RequestDelegate) c17513.L$1;
                RealImageLoader realImageLoader4 = (RealImageLoader) c17513.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    eventListenerCreate = eventListener3;
                    realImageLoader = realImageLoader4;
                    try {
                        imageResult = (ImageResult) objWithContext;
                        if (imageResult instanceof SuccessResult) {
                            realImageLoader.onSuccess((SuccessResult) imageResult, imageRequest2.getTarget(), eventListenerCreate);
                        } else {
                            if (!(imageResult instanceof ErrorResult)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            realImageLoader.onError((ErrorResult) imageResult, imageRequest2.getTarget(), eventListenerCreate);
                        }
                        requestDelegate.complete();
                        return imageResult;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    eventListenerCreate = eventListener3;
                    realImageLoader = realImageLoader4;
                }
            }
            try {
                if (th instanceof CancellationException) {
                    realImageLoader.onCancel(imageRequest2, eventListenerCreate);
                    throw th;
                }
                ErrorResult ErrorResult = UtilsKt.ErrorResult(imageRequest2, th);
                realImageLoader.onError(ErrorResult, imageRequest2.getTarget(), eventListenerCreate);
                requestDelegate.complete();
                return ErrorResult;
            } catch (Throwable th7) {
                requestDelegate.complete();
                throw th7;
            }
        }
        MemoryCache.Key placeholderMemoryCacheKey = imageRequestUpdateRequest.getPlaceholderMemoryCacheKey();
        Image image3 = (placeholderMemoryCacheKey == null || (memoryCache = realImageLoader.getMemoryCache()) == null || (value = memoryCache.get(placeholderMemoryCacheKey)) == null) ? null : value.getImage();
        Target target = imageRequestUpdateRequest.getTarget();
        if (target != null) {
            target.onStart(image3 == null ? imageRequestUpdateRequest.placeholder() : image3);
        }
        eventListenerCreate.onStart(imageRequestUpdateRequest);
        ImageRequest.Listener listener = imageRequestUpdateRequest.getListener();
        if (listener != null) {
            listener.onStart(imageRequestUpdateRequest);
        }
        SizeResolver sizeResolver = imageRequestUpdateRequest.getSizeResolver();
        eventListenerCreate.resolveSizeStart(imageRequestUpdateRequest, sizeResolver);
        c17513.L$0 = realImageLoader;
        c17513.L$1 = requestDelegate;
        c17513.L$2 = imageRequestUpdateRequest;
        c17513.L$3 = eventListenerCreate;
        c17513.L$4 = image3;
        c17513.label = 2;
        Object size2 = sizeResolver.size(c17513);
        if (size2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        image = image3;
        RequestDelegate requestDelegate4 = requestDelegate;
        imageRequest4 = imageRequestUpdateRequest;
        objWithContext = size2;
        requestDelegate3 = requestDelegate4;
        Size size3 = (Size) objWithContext;
        eventListenerCreate.resolveSizeEnd(imageRequest4, size3);
        CoroutineContext interceptorCoroutineContext2 = imageRequest4.getInterceptorCoroutineContext();
        RealImageLoader$execute$result$1 realImageLoader$execute$result$2 = new RealImageLoader$execute$result$1(imageRequest4, realImageLoader, size3, eventListenerCreate, image, null);
        c17513.L$0 = realImageLoader;
        c17513.L$1 = requestDelegate3;
        c17513.L$2 = imageRequest4;
        c17513.L$3 = eventListenerCreate;
        c17513.L$4 = null;
        c17513.label = 3;
        objWithContext = BuildersKt.withContext(interceptorCoroutineContext2, realImageLoader$execute$result$2, c17513);
        if (objWithContext == coroutine_suspended) {
            return coroutine_suspended;
        }
        imageRequest2 = imageRequest4;
        requestDelegate = requestDelegate3;
        imageResult = (ImageResult) objWithContext;
        if (imageResult instanceof SuccessResult) {
            realImageLoader.onSuccess((SuccessResult) imageResult, imageRequest2.getTarget(), eventListenerCreate);
        } else {
            if (!(imageResult instanceof ErrorResult)) {
                throw new NoWhenBranchMatchedException();
            }
            realImageLoader.onError((ErrorResult) imageResult, imageRequest2.getTarget(), eventListenerCreate);
        }
        requestDelegate.complete();
        return imageResult;
    }

    @Override // coil3.ImageLoader
    public void shutdown() {
        if (shutdown$volatile$FU.getAndSet(this, 1) != 0) {
            return;
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.systemCallbacks.shutdown();
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null) {
            memoryCache.clear();
        }
    }

    @Override // coil3.ImageLoader
    @NotNull
    public ImageLoader.Builder newBuilder() {
        return new ImageLoader.Builder(this.options);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0064  */
    private final void onSuccess(SuccessResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        DataSource dataSource = result.getDataSource();
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, UtilsKt.getEmoji(dataSource) + " Successful (" + dataSource.name() + ") - " + request.getData(), null);
            }
        }
        if (target instanceof TransitionTarget) {
            Transition transitionCreate = ImageRequests_androidKt.getTransitionFactory(result.getRequest()).create((TransitionTarget) target, result);
            if (!(transitionCreate instanceof NoneTransition)) {
                eventListener.transitionStart(result.getRequest(), transitionCreate);
                transitionCreate.transition();
                eventListener.transitionEnd(result.getRequest(), transitionCreate);
            } else {
                target.onSuccess(result.getImage());
            }
        } else if (target != null) {
            target.onSuccess(result.getImage());
        }
        eventListener.onSuccess(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, result);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    private final void onError(ErrorResult result, Target target, EventListener eventListener) {
        ImageRequest request = result.getRequest();
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Throwable throwable = result.getThrowable();
            Logger.Level minLevel = logger.getMinLevel();
            Logger.Level level = Logger.Level.Error;
            if (minLevel.compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, "🚨 Failed - " + request.getData(), throwable);
            }
        }
        if (target instanceof TransitionTarget) {
            Transition transitionCreate = ImageRequests_androidKt.getTransitionFactory(result.getRequest()).create((TransitionTarget) target, result);
            if (!(transitionCreate instanceof NoneTransition)) {
                eventListener.transitionStart(result.getRequest(), transitionCreate);
                transitionCreate.transition();
                eventListener.transitionEnd(result.getRequest(), transitionCreate);
            } else {
                target.onError(result.getImage());
            }
        } else if (target != null) {
            target.onError(result.getImage());
        }
        eventListener.onError(request, result);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, result);
        }
    }

    private final void onCancel(ImageRequest request, EventListener eventListener) {
        Logger logger = this.options.getLogger();
        if (logger != null) {
            Logger.Level level = Logger.Level.Info;
            if (logger.getMinLevel().compareTo(level) <= 0) {
                logger.log("RealImageLoader", level, "🏗 Cancelled - " + request.getData(), null);
            }
        }
        eventListener.onCancel(request);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onCancel(request);
        }
    }

    @Metadata(m1835d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\"\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\u000fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jj\u0010)\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, m1836d2 = {"Lcoil3/RealImageLoader$Options;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "Lcoil3/PlatformContext;", "defaults", "Lcoil3/request/ImageRequest$Defaults;", "memoryCacheLazy", "Lkotlin/Lazy;", "Lcoil3/memory/MemoryCache;", "diskCacheLazy", "Lcoil3/disk/DiskCache;", "eventListenerFactory", "Lcoil3/EventListener$Factory;", "componentRegistry", "Lcoil3/ComponentRegistry;", "logger", "Lcoil3/util/Logger;", "<init>", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)V", "getApplication", "()Landroid/content/Context;", "Landroid/content/Context;", "getDefaults", "()Lcoil3/request/ImageRequest$Defaults;", "getMemoryCacheLazy", "()Lkotlin/Lazy;", "getDiskCacheLazy", "getEventListenerFactory", "()Lcoil3/EventListener$Factory;", "getComponentRegistry", "()Lcoil3/ComponentRegistry;", "getLogger", "()Lcoil3/util/Logger;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Landroid/content/Context;Lcoil3/request/ImageRequest$Defaults;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/EventListener$Factory;Lcoil3/ComponentRegistry;Lcoil3/util/Logger;)Lcoil3/RealImageLoader$Options;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final /* data */ class Options {
        private final Context application;
        private final ComponentRegistry componentRegistry;
        private final ImageRequest.Defaults defaults;
        private final Lazy diskCacheLazy;
        private final EventListener.Factory eventListenerFactory;
        private final Logger logger;
        private final Lazy memoryCacheLazy;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Options copy$default(Options options, Context context, ImageRequest.Defaults defaults, Lazy lazy, Lazy lazy2, EventListener.Factory factory, ComponentRegistry componentRegistry, Logger logger, int i, Object obj) {
            if ((i & 1) != 0) {
                context = options.application;
            }
            if ((i & 2) != 0) {
                defaults = options.defaults;
            }
            ImageRequest.Defaults defaults2 = defaults;
            if ((i & 4) != 0) {
                lazy = options.memoryCacheLazy;
            }
            Lazy lazy3 = lazy;
            if ((i & 8) != 0) {
                lazy2 = options.diskCacheLazy;
            }
            Lazy lazy4 = lazy2;
            if ((i & 16) != 0) {
                factory = options.eventListenerFactory;
            }
            EventListener.Factory factory2 = factory;
            if ((i & 32) != 0) {
                componentRegistry = options.componentRegistry;
            }
            ComponentRegistry componentRegistry2 = componentRegistry;
            if ((i & 64) != 0) {
                logger = options.logger;
            }
            return options.copy(context, defaults2, lazy3, lazy4, factory2, componentRegistry2, logger);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Context getApplication() {
            return this.application;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ImageRequest.Defaults getDefaults() {
            return this.defaults;
        }

        @NotNull
        public final Lazy<MemoryCache> component3() {
            return this.memoryCacheLazy;
        }

        @NotNull
        public final Lazy<DiskCache> component4() {
            return this.diskCacheLazy;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ComponentRegistry getComponentRegistry() {
            return this.componentRegistry;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Logger getLogger() {
            return this.logger;
        }

        @NotNull
        public final Options copy(@NotNull Context application, @NotNull ImageRequest.Defaults defaults, @NotNull Lazy<? extends MemoryCache> memoryCacheLazy, @NotNull Lazy<? extends DiskCache> diskCacheLazy, @NotNull EventListener.Factory eventListenerFactory, @NotNull ComponentRegistry componentRegistry, @Nullable Logger logger) {
            return new Options(application, defaults, memoryCacheLazy, diskCacheLazy, eventListenerFactory, componentRegistry, logger);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Options)) {
                return false;
            }
            Options options = (Options) other;
            return Intrinsics.areEqual(this.application, options.application) && Intrinsics.areEqual(this.defaults, options.defaults) && Intrinsics.areEqual(this.memoryCacheLazy, options.memoryCacheLazy) && Intrinsics.areEqual(this.diskCacheLazy, options.diskCacheLazy) && Intrinsics.areEqual(this.eventListenerFactory, options.eventListenerFactory) && Intrinsics.areEqual(this.componentRegistry, options.componentRegistry) && Intrinsics.areEqual(this.logger, options.logger);
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.application.hashCode() * 31) + this.defaults.hashCode()) * 31) + this.memoryCacheLazy.hashCode()) * 31) + this.diskCacheLazy.hashCode()) * 31) + this.eventListenerFactory.hashCode()) * 31) + this.componentRegistry.hashCode()) * 31;
            Logger logger = this.logger;
            return iHashCode + (logger == null ? 0 : logger.hashCode());
        }

        @NotNull
        public String toString() {
            return "Options(application=" + this.application + ", defaults=" + this.defaults + ", memoryCacheLazy=" + this.memoryCacheLazy + ", diskCacheLazy=" + this.diskCacheLazy + ", eventListenerFactory=" + this.eventListenerFactory + ", componentRegistry=" + this.componentRegistry + ", logger=" + this.logger + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Options(@NotNull Context context, @NotNull ImageRequest.Defaults defaults, @NotNull Lazy<? extends MemoryCache> lazy, @NotNull Lazy<? extends DiskCache> lazy2, @NotNull EventListener.Factory factory, @NotNull ComponentRegistry componentRegistry, @Nullable Logger logger) {
            this.application = context;
            this.defaults = defaults;
            this.memoryCacheLazy = lazy;
            this.diskCacheLazy = lazy2;
            this.eventListenerFactory = factory;
            this.componentRegistry = componentRegistry;
            this.logger = logger;
        }

        @NotNull
        public final Context getApplication() {
            return this.application;
        }

        @NotNull
        public final ImageRequest.Defaults getDefaults() {
            return this.defaults;
        }

        @NotNull
        public final Lazy<MemoryCache> getMemoryCacheLazy() {
            return this.memoryCacheLazy;
        }

        @NotNull
        public final Lazy<DiskCache> getDiskCacheLazy() {
            return this.diskCacheLazy;
        }

        @NotNull
        public final EventListener.Factory getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        @NotNull
        public final ComponentRegistry getComponentRegistry() {
            return this.componentRegistry;
        }

        @Nullable
        public final Logger getLogger() {
            return this.logger;
        }
    }
}
