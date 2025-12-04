package com.contentsquare.android.reactnative.workaround;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/reactnative/workaround/ReactNativeProcessLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroidx/lifecycle/DefaultLifecycleObserver;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ReactNativeProcessLifecycle implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

    @NotNull
    public static final Logger d = new Logger("ReactNativeProcessLifecycle");

    @NotNull
    public final c a;

    @NotNull
    public final b b;

    @NotNull
    public final ArrayList c;

    public static final class a {

        @NotNull
        public final Application a;

        public a(@NotNull Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            this.a = application;
        }
    }

    public static final class b {
    }

    public interface c {
        void a();
    }

    public ReactNativeProcessLifecycle(@NotNull Application application, @NotNull LifecycleOwner lifecycleOwner, @NotNull c listener, @NotNull b reactNativeActivity) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(reactNativeActivity, "reactNativeActivity");
        this.a = listener;
        this.b = reactNativeActivity;
        this.c = new ArrayList();
        application.registerActivityLifecycleCallbacks(this);
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityResumed(@org.jetbrains.annotations.NotNull android.app.Activity r7) {
        /*
            r6 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.ArrayList r1 = r6.c
            int r1 = r1.size()
            r2 = 2
            if (r1 >= r2) goto L7b
            java.util.ArrayList r1 = r6.c
            com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle$b r3 = r6.b
            r3.getClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1
            r3 = 0
            java.lang.Class r7 = r7.getClass()     // Catch: java.lang.Exception -> L3d
            java.lang.reflect.Type r7 = r7.getGenericSuperclass()     // Catch: java.lang.Exception -> L3d
            if (r7 == 0) goto L41
            java.lang.String r4 = "class com.facebook.react.ReactActivity"
            java.lang.String r5 = r7.toString()     // Catch: java.lang.Exception -> L3d
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch: java.lang.Exception -> L3d
            if (r4 != 0) goto L3f
            java.lang.String r4 = "class io.flutter.embedding.android.FlutterActivity"
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L3d
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)     // Catch: java.lang.Exception -> L3d
            if (r7 == 0) goto L41
            goto L3f
        L3d:
            r7 = move-exception
            goto L43
        L3f:
            r7 = r0
            goto L4b
        L41:
            r7 = r3
            goto L4b
        L43:
            com.contentsquare.android.core.features.logging.Logger r4 = com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle.d
            java.lang.String r5 = "Cannot get generic super class"
            com.contentsquare.android.sdk.Q2.a(r4, r5, r7)
            goto L41
        L4b:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r1.add(r7)
            java.util.ArrayList r7 = r6.c
            int r7 = r7.size()
            if (r7 != r2) goto L7b
            java.util.ArrayList r7 = r6.c
            java.lang.Object r7 = r7.get(r3)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L7b
            java.util.ArrayList r7 = r6.c
            java.lang.Object r7 = r7.get(r0)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L7b
            com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle$c r6 = r6.a
            r6.a()
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle.onActivityResumed(android.app.Activity):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.c.clear();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.c.size() < 2) {
            this.c.add(Boolean.TRUE);
            if (this.c.size() == 2 && ((Boolean) this.c.get(0)).booleanValue() && ((Boolean) this.c.get(1)).booleanValue()) {
                this.a.a();
            }
        }
    }
}
