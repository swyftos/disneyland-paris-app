package com.contentsquare.android.analytics.internal.features.clientmode.ui.tutorial;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayService;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C0682g1;
import com.contentsquare.android.sdk.C0724k3;
import com.contentsquare.android.sdk.C0781q0;
import com.contentsquare.android.sdk.K0;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/tutorial/ClientModeTutorialActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ClientModeTutorialActivity extends AppCompatActivity {
    public static final /* synthetic */ int d = 0;
    public C0724k3 a;
    public C0781q0 b;

    @NotNull
    public final C0682g1 c = new C0682g1();

    public static final void a(ClientModeTutorialActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public final void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0682g1 c0682g1 = this.c;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        if (c0682g1.a(applicationContext)) {
            a();
            return;
        }
        int i3 = R.string.contentsquare_draw_over_app_permission_msg;
        Intrinsics.checkNotNullParameter(this, "context");
        Toast.makeText(this, i3, 0).show();
        C0724k3 c0724k3 = this.a;
        if (c0724k3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            c0724k3 = null;
        }
        CsApplicationModule.getInstance(c0724k3.a).getSdkManager().a();
        c0724k3.a.stopService(new Intent(c0724k3.a, (Class<?>) OverlayService.class));
        c0724k3.f = 2;
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public final void onBackPressed() {
        super.onBackPressed();
        a();
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
        Logger logger = K0.e;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        C0724k3 c0724k3 = K0.a.a(application).b;
        Intrinsics.checkNotNullParameter(c0724k3, "<set-?>");
        this.a = c0724k3;
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "application");
        C0781q0 c0781q0 = new C0781q0(application2);
        Intrinsics.checkNotNullParameter(c0781q0, "<set-?>");
        this.b = c0781q0;
        setContentView(R.layout.contentsquare_activity_client_mode_tutorial);
        InstrumentationCallbacks.setOnClickListenerCalled(findViewById(R.id.ok_button), new View.OnClickListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.tutorial.ClientModeTutorialActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClientModeTutorialActivity.a(this.f$0, view);
            }
        });
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

    public final void a() {
        C0781q0 c0781q0 = this.b;
        C0781q0 c0781q02 = null;
        if (c0781q0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientModeTutorialViewModel");
            c0781q0 = null;
        }
        c0781q0.a.putBoolean(PreferencesKey.CLIENT_MODE_TUTORIAL, false);
        C0724k3 c0724k3 = this.a;
        if (c0724k3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            c0724k3 = null;
        }
        if (!c0724k3.a()) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2084);
            return;
        }
        C0781q0 c0781q03 = this.b;
        if (c0781q03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clientModeTutorialViewModel");
            c0781q03 = null;
        }
        c0781q03.a.putBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, true);
        C0781q0 c0781q04 = this.b;
        if (c0781q04 != null) {
            c0781q02 = c0781q04;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("clientModeTutorialViewModel");
        }
        c0781q02.a.putBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, true);
        finish();
    }
}
