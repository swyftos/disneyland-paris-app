package expo.modules.kotlin.jni;

import com.amazonaws.services.p017s3.model.InstructionFileId;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PromiseAlreadySettledException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\t\u0010\u0012J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\t\u0010\u0014J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\t\u0010\u0016J\u001f\u0010\t\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0017H\u0016¢\u0006\u0004\b\t\u0010\u0018J%\u0010\t\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0019H\u0016¢\u0006\u0004\b\t\u0010\u001aJ+\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J+\u0010&\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R$\u0010+\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, m1836d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "Lexpo/modules/kotlin/jni/JavaCallback;", "callback", "<init>", "(Lexpo/modules/kotlin/jni/JavaCallback;)V", "", "value", "", "resolve", "(Ljava/lang/Object;)V", "()V", "", "result", "(I)V", "", "(Z)V", "", "(D)V", "", "(F)V", "", "(Ljava/lang/String;)V", "", "(Ljava/util/Collection;)V", "", "(Ljava/util/Map;)V", "code", "message", "", "cause", "reject", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "appContextHolder", "moduleName", "functionName", "decorateWithDebugInformation", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Ljava/lang/String;)V", "Lexpo/modules/kotlin/jni/JavaCallback;", "getCallback$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "wasSettled", "Z", "getWasSettled$expo_modules_core_release", "()Z", "Ljava/lang/ref/WeakReference;", "fullFunctionName", "Ljava/lang/String;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
@SourceDebugExtension({"SMAP\nPromiseImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PromiseImpl.kt\nexpo/modules/kotlin/jni/PromiseImpl\n*L\n1#1,90:1\n63#1,17:91\n63#1,17:108\n63#1,17:125\n63#1,17:142\n63#1,17:159\n63#1,17:176\n63#1,17:193\n63#1,17:210\n*S KotlinDebug\n*F\n+ 1 PromiseImpl.kt\nexpo/modules/kotlin/jni/PromiseImpl\n*L\n20#1:91,17\n24#1:108,17\n28#1:125,17\n32#1:142,17\n36#1:159,17\n40#1:176,17\n44#1:193,17\n57#1:210,17\n*E\n"})
public final class PromiseImpl implements Promise {
    private WeakReference appContextHolder;

    @DoNotStrip
    @NotNull
    private final JavaCallback callback;
    private String fullFunctionName;
    private boolean wasSettled;

    @Override // expo.modules.kotlin.Promise
    public void reject(@NotNull CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    @DoNotStrip
    public PromiseImpl(@NotNull JavaCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @NotNull
    /* JADX INFO: renamed from: getCallback$expo_modules_core_release, reason: from getter */
    public final JavaCallback getCallback() {
        return this.callback;
    }

    /* JADX INFO: renamed from: getWasSettled$expo_modules_core_release, reason: from getter */
    public final boolean getWasSettled() {
        return this.wasSettled;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@NotNull Collection<? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.callback.invoke(result);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@NotNull Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.callback.invoke(result);
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(@NotNull String code, @Nullable String message, @Nullable Throwable cause) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(code, "code");
        if (!this.wasSettled) {
            JavaCallback javaCallback = this.callback;
            if (message == null) {
                message = cause != null ? cause.getMessage() : null;
                if (message == null) {
                    message = "unknown";
                }
            }
            javaCallback.invoke(code, message);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str != null ? str : "unknown");
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke();
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@Nullable Object value) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(value);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(@NotNull String result) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = "unknown";
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = (AppContext) weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    public final void decorateWithDebugInformation(@NotNull WeakReference<AppContext> appContextHolder, @NotNull String moduleName, @NotNull String functionName) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.appContextHolder = appContextHolder;
        this.fullFunctionName = moduleName + InstructionFileId.DOT + functionName;
    }
}
