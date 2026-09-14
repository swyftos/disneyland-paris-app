package expo.modules.kotlin;

import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.jni.PromiseImpl;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lexpo/modules/kotlin/Promise;", "Lcom/facebook/react/bridge/Promise;", "toBridgePromise", "(Lexpo/modules/kotlin/Promise;)Lcom/facebook/react/bridge/Promise;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class PromiseKt {
    @NotNull
    public static final com.facebook.react.bridge.Promise toBridgePromise(@NotNull final Promise promise) {
        final Function1 promiseKt$toBridgePromise$resolveMethod$2;
        Intrinsics.checkNotNullParameter(promise, "<this>");
        if (promise instanceof PromiseImpl) {
            promiseKt$toBridgePromise$resolveMethod$2 = new PromiseKt$toBridgePromise$resolveMethod$1(((PromiseImpl) promise).getCallback());
        } else {
            promiseKt$toBridgePromise$resolveMethod$2 = new PromiseKt$toBridgePromise$resolveMethod$2(promise);
        }
        return new com.facebook.react.bridge.Promise() { // from class: expo.modules.kotlin.PromiseKt.toBridgePromise.1
            @Override // com.facebook.react.bridge.Promise
            public void resolve(Object value) {
                promiseKt$toBridgePromise$resolveMethod$2.invoke(value);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, String message) {
                Intrinsics.checkNotNullParameter(code, "code");
                promise.reject(code, message, null);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, Throwable throwable) {
                Intrinsics.checkNotNullParameter(code, "code");
                promise.reject(code, null, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, String message, Throwable throwable) {
                Intrinsics.checkNotNullParameter(code, "code");
                promise.reject(code, message, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                promise.reject("UnknownCode", null, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(Throwable throwable, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject("UnknownCode", null, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(code, "code");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject(code, null, null);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, Throwable throwable, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(code, "code");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject(code, null, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, String message, WritableMap userInfo) {
                Intrinsics.checkNotNullParameter(code, "code");
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                promise.reject(code, message, null);
            }

            @Override // com.facebook.react.bridge.Promise
            public void reject(String code, String message, Throwable throwable, WritableMap userInfo) {
                Promise promise2 = promise;
                if (code == null) {
                    code = "UnknownCode";
                }
                promise2.reject(code, message, throwable);
            }

            @Override // com.facebook.react.bridge.Promise
            @Deprecated(message = "Use reject(code, message, throwable) instead")
            public void reject(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                promise.reject("UnknownCode", message, null);
            }
        };
    }
}
