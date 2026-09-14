package expo.modules.kotlin;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J*\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1836d2 = {"Lexpo/modules/kotlin/ReactLifecycleDelegate;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "Lcom/facebook/react/bridge/ActivityEventListener;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Lexpo/modules/kotlin/AppContext;)V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onHostResume", "", "onHostPause", "onUserLeaveHint", "activity", "Landroid/app/Activity;", "onHostDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onNewIntent", "intent", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ReactLifecycleDelegate implements LifecycleEventListener, ActivityEventListener {
    private final WeakReference appContextHolder;

    public ReactLifecycleDelegate(@NotNull AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContextHolder = new WeakReference(appContext);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostResume$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostPause$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onUserLeaveHint(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onUserLeaveHint$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onHostDestroy$expo_modules_core_release();
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(@NotNull Activity activity, int requestCode, int resultCode, @Nullable Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onActivityResult$expo_modules_core_release(activity, requestCode, resultCode, data);
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(@Nullable Intent intent) {
        AppContext appContext = (AppContext) this.appContextHolder.get();
        if (appContext != null) {
            appContext.onNewIntent$expo_modules_core_release(intent);
        }
    }
}
