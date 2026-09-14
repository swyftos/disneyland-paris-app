package coil3;

import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1836d2 = {"executeBlocking", "Lcoil3/request/ImageResult;", "Lcoil3/ImageLoader;", "request", "Lcoil3/request/ImageRequest;", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ImageLoaders_nonJsCommonKt {

    /* JADX INFO: renamed from: coil3.ImageLoaders_nonJsCommonKt$executeBlocking$1 */
    static final class C17491 extends SuspendLambda implements Function2 {
        final /* synthetic */ ImageRequest $request;
        final /* synthetic */ ImageLoader $this_executeBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17491(ImageLoader imageLoader, ImageRequest imageRequest, Continuation continuation) {
            super(2, continuation);
            this.$this_executeBlocking = imageLoader;
            this.$request = imageRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C17491(this.$this_executeBlocking, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C17491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ImageLoader imageLoader = this.$this_executeBlocking;
                ImageRequest imageRequest = this.$request;
                this.label = 1;
                obj = imageLoader.execute(imageRequest, this);
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

    @NotNull
    public static final ImageResult executeBlocking(@NotNull ImageLoader imageLoader, @NotNull ImageRequest imageRequest) {
        return (ImageResult) BuildersKt__BuildersKt.runBlocking$default(null, new C17491(imageLoader, imageRequest, null), 1, null);
    }
}
