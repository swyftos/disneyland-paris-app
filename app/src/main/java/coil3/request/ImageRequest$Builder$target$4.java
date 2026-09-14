package coil3.request;

import ch.qos.logback.core.net.SyslogConstants;
import coil3.Image;
import coil3.target.Target;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m1836d2 = {"coil3/request/ImageRequest$Builder$target$4", "Lcoil3/target/Target;", "onStart", "", ReactTextInputShadowNode.PROP_PLACEHOLDER, "Lcoil3/Image;", "onError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "onSuccess", "result", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class ImageRequest$Builder$target$4 implements Target {
    final /* synthetic */ Function1 $onError;
    final /* synthetic */ Function1 $onStart;
    final /* synthetic */ Function1 $onSuccess;

    public ImageRequest$Builder$target$4(Function1<? super Image, Unit> function1, Function1<? super Image, Unit> function2, Function1<? super Image, Unit> function3) {
        this.$onStart = function1;
        this.$onError = function2;
        this.$onSuccess = function3;
    }

    @Override // coil3.target.Target
    public void onStart(Image placeholder) {
        this.$onStart.invoke(placeholder);
    }

    @Override // coil3.target.Target
    public void onError(Image error) {
        this.$onError.invoke(error);
    }

    @Override // coil3.target.Target
    public void onSuccess(Image result) {
        this.$onSuccess.invoke(result);
    }
}
