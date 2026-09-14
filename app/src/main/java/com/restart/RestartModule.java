package com.restart;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m1836d2 = {"Lcom/restart/RestartModule;", "Lcom/restart/NativeRestartSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "restart", "", "Companion", "dlp-mobile_react-native-restart_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RestartModule extends NativeRestartSpec {

    @NotNull
    public static final String NAME = "Restart";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestartModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.restart.NativeRestartSpec
    public void restart() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.restart.RestartModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RestartModule.restart$lambda$0(this.f$0, reactApplicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restart$lambda$0(RestartModule restartModule, ReactApplicationContext reactApplicationContext) {
        Activity currentActivity = restartModule.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        try {
            Intent launchIntentForPackage = reactApplicationContext.getPackageManager().getLaunchIntentForPackage(reactApplicationContext.getPackageName());
            if (launchIntentForPackage == null) {
                return;
            }
            launchIntentForPackage.addFlags(335544320);
            currentActivity.finish();
            reactApplicationContext.startActivity(launchIntentForPackage);
            Log.e("RestartModule", "Restarted successfully");
        } catch (Exception e) {
            Log.e("RestartModule", "Failed to restart activity", e);
        }
    }
}
