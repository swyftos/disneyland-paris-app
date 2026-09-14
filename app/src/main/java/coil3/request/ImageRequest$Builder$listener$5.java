package coil3.request;

import ch.qos.logback.core.net.SyslogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000bH\u0016¨\u0006\f"}, m1836d2 = {"coil3/request/ImageRequest$Builder$listener$5", "Lcoil3/request/ImageRequest$Listener;", "onStart", "", "request", "Lcoil3/request/ImageRequest;", "onCancel", "onError", "result", "Lcoil3/request/ErrorResult;", "onSuccess", "Lcoil3/request/SuccessResult;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class ImageRequest$Builder$listener$5 implements ImageRequest.Listener {
    final /* synthetic */ Function1 $onCancel;
    final /* synthetic */ Function2 $onError;
    final /* synthetic */ Function1 $onStart;
    final /* synthetic */ Function2 $onSuccess;

    public ImageRequest$Builder$listener$5(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function2, Function2<? super ImageRequest, ? super ErrorResult, Unit> function3, Function2<? super ImageRequest, ? super SuccessResult, Unit> function4) {
        this.$onStart = function1;
        this.$onCancel = function2;
        this.$onError = function3;
        this.$onSuccess = function4;
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onStart(ImageRequest request) {
        this.$onStart.invoke(request);
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onCancel(ImageRequest request) {
        this.$onCancel.invoke(request);
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onError(ImageRequest request, ErrorResult result) {
        this.$onError.invoke(request, result);
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onSuccess(ImageRequest request, SuccessResult result) {
        this.$onSuccess.invoke(request, result);
    }
}
