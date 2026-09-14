package expo.modules.kotlin;

import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.types.JSTypeConverter;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/kotlin/KPromiseWrapper;", "Lexpo/modules/kotlin/Promise;", "bridgePromise", "Lcom/facebook/react/bridge/Promise;", "<init>", "(Lcom/facebook/react/bridge/Promise;)V", "resolve", "", "value", "", "reject", "code", "", "message", "cause", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class KPromiseWrapper implements Promise {
    private final com.facebook.react.bridge.Promise bridgePromise;

    public KPromiseWrapper(@NotNull com.facebook.react.bridge.Promise bridgePromise) {
        Intrinsics.checkNotNullParameter(bridgePromise, "bridgePromise");
        this.bridgePromise = bridgePromise;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(@NotNull CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() {
        Promise.DefaultImpls.resolve(this);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double d) {
        Promise.DefaultImpls.resolve(this, d);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float f) {
        Promise.DefaultImpls.resolve((Promise) this, f);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int i) {
        Promise.DefaultImpls.resolve((Promise) this, i);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@NotNull String str) {
        Promise.DefaultImpls.resolve(this, str);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@NotNull Collection<? extends Object> collection) {
        Promise.DefaultImpls.resolve(this, collection);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@NotNull Map<String, ? extends Object> map) {
        Promise.DefaultImpls.resolve(this, map);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean z) {
        Promise.DefaultImpls.resolve(this, z);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@Nullable Object value) {
        this.bridgePromise.resolve(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, value, null, false, 6, null));
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(@NotNull String code, @Nullable String message, @Nullable Throwable cause) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.bridgePromise.reject(code, message, cause);
    }
}
