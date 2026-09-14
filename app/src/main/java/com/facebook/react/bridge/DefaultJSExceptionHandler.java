package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016¨\u0006\t"}, m1836d2 = {"Lcom/facebook/react/bridge/DefaultJSExceptionHandler;", "Lcom/facebook/react/bridge/JSExceptionHandler;", "<init>", "()V", "handleException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DefaultJSExceptionHandler implements JSExceptionHandler {
    @Override // com.facebook.react.bridge.JSExceptionHandler
    public void handleException(@NotNull Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!(e instanceof RuntimeException)) {
            throw new RuntimeException(e);
        }
    }
}
