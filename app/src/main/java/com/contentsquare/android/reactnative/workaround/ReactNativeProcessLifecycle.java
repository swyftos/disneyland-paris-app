package com.contentsquare.android.reactnative.workaround;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.C2599Q2;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, m1836d2 = {"Lcom/contentsquare/android/reactnative/workaround/ReactNativeProcessLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroidx/lifecycle/DefaultLifecycleObserver;", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0})
public final class ReactNativeProcessLifecycle implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Logger f1363d = new Logger("ReactNativeProcessLifecycle");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final InterfaceC2434c f1364a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2433b f1365b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final ArrayList f1366c;

    /* JADX INFO: renamed from: com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle$a */
    public static final class C2432a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final Application f1367a;

        public C2432a(@NotNull Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            this.f1367a = application;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle$b */
    public static final class C2433b {
    }

    /* JADX INFO: renamed from: com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle$c */
    public interface InterfaceC2434c {
        /* JADX INFO: renamed from: a */
        void mo852a();
    }

    public ReactNativeProcessLifecycle(@NotNull Application application, @NotNull LifecycleOwner lifecycleOwner, @NotNull InterfaceC2434c listener, @NotNull C2433b reactNativeActivity) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(reactNativeActivity, "reactNativeActivity");
        this.f1364a = listener;
        this.f1365b = reactNativeActivity;
        this.f1366c = new ArrayList();
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        boolean z;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f1366c.size() < 2) {
            ArrayList arrayList = this.f1366c;
            this.f1365b.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                Type genericSuperclass = activity.getClass().getGenericSuperclass();
                z = genericSuperclass != null && (Intrinsics.areEqual("class com.facebook.react.ReactActivity", genericSuperclass.toString()) || Intrinsics.areEqual("class io.flutter.embedding.android.FlutterActivity", genericSuperclass.toString()));
            } catch (Exception e) {
                C2599Q2.m1011a(f1363d, "Cannot get generic super class", e);
            }
            arrayList.add(Boolean.valueOf(z));
            if (this.f1366c.size() == 2 && ((Boolean) this.f1366c.get(0)).booleanValue() && ((Boolean) this.f1366c.get(1)).booleanValue()) {
                this.f1364a.mo852a();
            }
        }
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
        this.f1366c.clear();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.f1366c.size() < 2) {
            this.f1366c.add(Boolean.TRUE);
            if (this.f1366c.size() == 2 && ((Boolean) this.f1366c.get(0)).booleanValue() && ((Boolean) this.f1366c.get(1)).booleanValue()) {
                this.f1364a.mo852a();
            }
        }
    }
}
