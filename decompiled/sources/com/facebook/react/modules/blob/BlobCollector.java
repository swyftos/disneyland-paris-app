package com.facebook.react.modules.blob;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0082 ¨\u0006\r"}, d2 = {"Lcom/facebook/react/modules/blob/BlobCollector;", "", "<init>", "()V", "install", "", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "blobModule", "Lcom/facebook/react/modules/blob/BlobModule;", "nativeInstall", "jsContext", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlobCollector {

    @NotNull
    public static final BlobCollector INSTANCE = new BlobCollector();

    private final native void nativeInstall(Object blobModule, long jsContext);

    private BlobCollector() {
    }

    static {
        SoLoader.loadLibrary("reactnativeblob");
    }

    @JvmStatic
    public static final void install(@NotNull final ReactContext reactContext, @NotNull final BlobModule blobModule) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(blobModule, "blobModule");
        reactContext.runOnJSQueueThread(new Runnable() { // from class: com.facebook.react.modules.blob.BlobCollector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BlobCollector.install$lambda$0(reactContext, blobModule);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void install$lambda$0(ReactContext reactContext, BlobModule blobModule) {
        JavaScriptContextHolder javaScriptContextHolder = reactContext.getJavaScriptContextHolder();
        if (javaScriptContextHolder == null || javaScriptContextHolder.get() == 0) {
            return;
        }
        INSTANCE.nativeInstall(blobModule, javaScriptContextHolder.get());
    }
}
