package coil3.intercept;

import coil3.EventListener;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.request.NullRequestData;
import coil3.size.Size;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0006H\u0002J&\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001d¨\u0006'"}, m1836d2 = {"Lcoil3/intercept/RealInterceptorChain;", "Lcoil3/intercept/Interceptor$Chain;", "initialRequest", "Lcoil3/request/ImageRequest;", "interceptors", "", "Lcoil3/intercept/Interceptor;", ArrayContainsMatcher.INDEX_KEY, "", "request", TCEventPropertiesNames.TCP_SIZE, "Lcoil3/size/Size;", "eventListener", "Lcoil3/EventListener;", "isPlaceholderCached", "", "<init>", "(Lcoil3/request/ImageRequest;Ljava/util/List;ILcoil3/request/ImageRequest;Lcoil3/size/Size;Lcoil3/EventListener;Z)V", "getInitialRequest", "()Lcoil3/request/ImageRequest;", "getInterceptors", "()Ljava/util/List;", "getIndex", "()I", "getRequest", "getSize", "()Lcoil3/size/Size;", "getEventListener", "()Lcoil3/EventListener;", "()Z", "withRequest", "withSize", "proceed", "Lcoil3/request/ImageResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkRequest", "", "interceptor", "copy", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;

    /* JADX INFO: renamed from: coil3.intercept.RealInterceptorChain$proceed$1 */
    static final class C17681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C17681(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RealInterceptorChain.this.proceed(this);
        }
    }

    public RealInterceptorChain(@NotNull ImageRequest imageRequest, @NotNull List<? extends Interceptor> list, int i, @NotNull ImageRequest imageRequest2, @NotNull Size size, @NotNull EventListener eventListener, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i;
        this.request = imageRequest2;
        this.size = size;
        this.eventListener = eventListener;
        this.isPlaceholderCached = z;
    }

    @NotNull
    public final ImageRequest getInitialRequest() {
        return this.initialRequest;
    }

    @NotNull
    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public Size getSize() {
        return this.size;
    }

    @NotNull
    public final EventListener getEventListener() {
        return this.eventListener;
    }

    /* JADX INFO: renamed from: isPlaceholderCached, reason: from getter */
    public final boolean getIsPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withRequest(@NotNull ImageRequest request) {
        int i = this.index;
        if (i > 0) {
            checkRequest(request, (Interceptor) this.interceptors.get(i - 1));
        }
        return copy$default(this, 0, request, null, 5, null);
    }

    @Override // coil3.intercept.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withSize(@NotNull Size size) {
        return copy$default(this, 0, null, size, 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // coil3.intercept.Interceptor.Chain
    @Nullable
    public Object proceed(@NotNull Continuation<? super ImageResult> continuation) {
        C17681 c17681;
        Interceptor interceptor;
        Object objIntercept;
        if (continuation instanceof C17681) {
            c17681 = (C17681) continuation;
            int i = c17681.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17681.label = i - Integer.MIN_VALUE;
            } else {
                c17681 = new C17681(continuation);
            }
        } else {
            c17681 = new C17681(continuation);
        }
        Object obj = c17681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c17681.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            interceptor = (Interceptor) this.interceptors.get(this.index);
            RealInterceptorChain realInterceptorChainCopy$default = copy$default(this, this.index + 1, null, null, 6, null);
            c17681.L$0 = this;
            c17681.L$1 = interceptor;
            c17681.label = 1;
            objIntercept = interceptor.intercept(realInterceptorChainCopy$default, c17681);
            if (objIntercept == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Interceptor interceptor2 = (Interceptor) c17681.L$1;
            RealInterceptorChain realInterceptorChain = (RealInterceptorChain) c17681.L$0;
            ResultKt.throwOnFailure(obj);
            interceptor = interceptor2;
            this = realInterceptorChain;
            objIntercept = obj;
        }
        ImageResult imageResult = (ImageResult) objIntercept;
        this.checkRequest(imageResult.getRequest(), interceptor);
        return imageResult;
    }

    private final void checkRequest(ImageRequest request, Interceptor interceptor) {
        if (request.getContext() != this.initialRequest.getContext()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (request.getData() == NullRequestData.INSTANCE) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (request.getTarget() != this.initialRequest.getTarget()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (request.getSizeResolver() == this.initialRequest.getSizeResolver()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i, ImageRequest imageRequest, Size size, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i2 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i2 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i, imageRequest, size);
    }

    private final RealInterceptorChain copy(int index, ImageRequest request, Size size) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, index, request, size, this.eventListener, this.isPlaceholderCached);
    }
}
