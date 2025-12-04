package com.facebook.react.bridge;

import com.facebook.jni.HybridClassBase;
import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@DoNotStrip
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0003¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0082 ¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/bridge/CxxCallbackImpl;", "Lcom/facebook/jni/HybridClassBase;", "Lcom/facebook/react/bridge/Callback;", "<init>", "()V", "invoke", "", "args", "", "", "([Ljava/lang/Object;)V", "nativeInvoke", "arguments", "Lcom/facebook/react/bridge/NativeArray;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CxxCallbackImpl extends HybridClassBase implements Callback {
    private final native void nativeInvoke(NativeArray arguments);

    @DoNotStrip
    private CxxCallbackImpl() {
    }

    @Override // com.facebook.react.bridge.Callback
    public void invoke(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        WritableNativeArray writableNativeArrayFromJavaArgs = Arguments.fromJavaArgs(args);
        Intrinsics.checkNotNullExpressionValue(writableNativeArrayFromJavaArgs, "fromJavaArgs(...)");
        nativeInvoke(writableNativeArrayFromJavaArgs);
    }
}
