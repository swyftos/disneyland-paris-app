package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* loaded from: classes2.dex */
public abstract class JavaScriptReplyProxy {
    public abstract void postMessage(@NonNull String str);

    public abstract void postMessage(@NonNull byte[] bArr);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public JavaScriptReplyProxy() {
    }
}
