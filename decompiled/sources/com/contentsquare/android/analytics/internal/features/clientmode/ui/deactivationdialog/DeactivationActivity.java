package com.contentsquare.android.analytics.internal.features.clientmode.ui.deactivationdialog;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayService;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C0724k3;
import com.contentsquare.android.sdk.K0;
import com.contentsquare.android.sdk.W0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/deactivationdialog/DeactivationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DeactivationActivity extends AppCompatActivity {
    public C0724k3 a;
    public W0 b;

    public static final void a(DeactivationActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        W0 w0 = this$0.b;
        C0724k3 c0724k3 = null;
        if (w0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deactivationViewModel");
            w0 = null;
        }
        PreferencesStore preferencesStore = w0.a;
        preferencesStore.putBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, false);
        preferencesStore.putBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, false);
        preferencesStore.putBoolean(PreferencesKey.DEVELOPER_MODE_ACTIVATION_STATE, false);
        preferencesStore.putBoolean(PreferencesKey.LOCAL_SESSION_REPLAY_MODE, false);
        preferencesStore.putBoolean(PreferencesKey.VERBOSE_LOG, false);
        preferencesStore.putInt(PreferencesKey.CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, 0);
        preferencesStore.putBoolean(PreferencesKey.CLIENT_MODE_SCREENGRAPH_OPTIMIZATION_MODE, false);
        preferencesStore.putBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, false);
        C0724k3 c0724k32 = this$0.a;
        if (c0724k32 != null) {
            c0724k3 = c0724k32;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
        }
        CsApplicationModule.getInstance(c0724k3.a).getSdkManager().a();
        c0724k3.a.stopService(new Intent(c0724k3.a, (Class<?>) OverlayService.class));
        c0724k3.f = 2;
        this$0.finish();
    }

    public static final void b(DeactivationActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        super.onCreate(bundle);
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        W0 w0 = new W0(application);
        Intrinsics.checkNotNullParameter(w0, "<set-?>");
        this.b = w0;
        Logger logger = K0.e;
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "application");
        C0724k3 c0724k3 = K0.a.a(application2).b;
        Intrinsics.checkNotNullParameter(c0724k3, "<set-?>");
        this.a = c0724k3;
        setContentView(R.layout.contentsquare_client_mode_deactivation);
        InstrumentationCallbacks.setOnClickListenerCalled(findViewById(R.id.deactivation_window_disable_button), new View.OnClickListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.deactivationdialog.DeactivationActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeactivationActivity.a(this.f$0, view);
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled(findViewById(R.id.deactivation_window_cancel_button), new View.OnClickListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.deactivationdialog.DeactivationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeactivationActivity.b(this.f$0, view);
            }
        });
        setFinishOnTouchOutside(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }
}
