package expo.modules.adapters.react.apploader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;
import expo.modules.core.interfaces.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1836d2 = {"Lexpo/modules/adapters/react/apploader/RNHeadlessAppLoader;", "Lexpo/modules/apploader/HeadlessAppLoader;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "loadApp", "", "params", "Lexpo/modules/apploader/HeadlessAppLoader$Params;", "alreadyRunning", "Ljava/lang/Runnable;", "callback", "Lexpo/modules/core/interfaces/Consumer;", "", "invalidateApp", "appScopeKey", "", "isRunning", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RNHeadlessAppLoader implements HeadlessAppLoader {
    private final Context context;

    @DoNotStrip
    public RNHeadlessAppLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    public void loadApp(@NotNull Context context, @Nullable final HeadlessAppLoader.Params params, @Nullable Runnable alreadyRunning, @Nullable final Consumer<Boolean> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (params == null || params.getAppScopeKey() == null) {
            throw new IllegalArgumentException("Params must be set with appScopeKey!");
        }
        if (context.getApplicationContext() instanceof ReactApplication) {
            if (RNHeadlessAppLoaderKt.appRecords.containsKey(params.getAppScopeKey())) {
                if (alreadyRunning != null) {
                    alreadyRunning.run();
                    return;
                }
                return;
            }
            Object applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            final ReactHost reactHost = ((ReactApplication) applicationContext).getReactHost();
            if (reactHost == null) {
                throw new IllegalStateException("Your application does not have a valid reactHost");
            }
            reactHost.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader.loadApp.1
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext context2) {
                    Intrinsics.checkNotNullParameter(context2, "context");
                    reactHost.removeReactInstanceEventListener(this);
                    HeadlessAppLoaderNotifier.INSTANCE.notifyAppLoaded(params.getAppScopeKey());
                    RNHeadlessAppLoaderKt.appRecords.put(params.getAppScopeKey(), context2);
                    Consumer consumer = callback;
                    if (consumer != null) {
                        consumer.apply(Boolean.TRUE);
                    }
                }
            });
            new Handler(context.getMainLooper()).post(new Runnable() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    reactHost.start();
                }
            });
            return;
        }
        throw new IllegalStateException("Your application must implement ReactApplication");
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    @SuppressLint({"VisibleForTests"})
    public boolean invalidateApp(@Nullable final String appScopeKey) {
        ReactContext reactContext;
        if (!RNHeadlessAppLoaderKt.appRecords.containsKey(appScopeKey) || RNHeadlessAppLoaderKt.appRecords.get(appScopeKey) == null || (reactContext = (ReactContext) RNHeadlessAppLoaderKt.appRecords.get(appScopeKey)) == null) {
            return false;
        }
        Object applicationContext = reactContext.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        final ReactHost reactHost = ((ReactApplication) applicationContext).getReactHost();
        if (reactHost == null) {
            throw new IllegalStateException("Your application does not have a valid reactHost");
        }
        new Handler(reactContext.getMainLooper()).post(new Runnable() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RNHeadlessAppLoader.invalidateApp$lambda$2(reactHost, appScopeKey);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidateApp$lambda$2(ReactHost reactHost, String str) {
        if (reactHost.getLifecycleState() == LifecycleState.BEFORE_CREATE) {
            reactHost.destroy("Closing headless task app", null);
        }
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppDestroyed(str);
        TypeIntrinsics.asMutableMap(RNHeadlessAppLoaderKt.appRecords).remove(str);
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    public boolean isRunning(@Nullable String appScopeKey) {
        return ((ReactContext) RNHeadlessAppLoaderKt.appRecords.get(appScopeKey)) != null;
    }
}
