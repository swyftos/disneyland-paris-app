package androidx.camera.core.imagecapture;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/core/imagecapture/CameraCapturePipeline;", "", "invokePostCapture", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "invokePreCapture", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface CameraCapturePipeline {
    @NotNull
    ListenableFuture<Void> invokePostCapture();

    @NotNull
    ListenableFuture<Void> invokePreCapture();
}
