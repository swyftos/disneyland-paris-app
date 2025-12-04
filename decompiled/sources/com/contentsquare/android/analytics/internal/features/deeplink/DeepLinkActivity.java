package com.contentsquare.android.analytics.internal.features.deeplink;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.tutorial.ClientModeTutorialActivity;
import com.contentsquare.android.analytics.internal.features.deeplink.a;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.sdk.C0857y0;
import com.contentsquare.android.sdk.Z5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/deeplink/DeepLinkActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/contentsquare/android/analytics/internal/features/deeplink/a$a;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DeepLinkActivity extends AppCompatActivity implements a.InterfaceC0039a {

    @NotNull
    public final Logger a = new Logger(null, 1, null);

    @Override // com.contentsquare.android.analytics.internal.features.deeplink.a.InterfaceC0039a
    public final void a() {
        startActivity(new Intent(this, (Class<?>) ClientModeTutorialActivity.class));
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
        Logger logger = Z5.a;
        if (CsRuntimeModule.getInstance() != null) {
            CoreModule.Companion companion = CoreModule.INSTANCE;
            Application application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "application");
            CoreModule coreModuleSafeInstance = companion.safeInstance(application);
            a aVar = new a(this, this, coreModuleSafeInstance.getConfiguration(), new C0857y0(coreModuleSafeInstance.getPreferencesStore()));
            Intent intent = getIntent();
            String action = intent.getAction();
            Uri data = intent.getData();
            if (action != null && data != null) {
                aVar.a(data);
            }
        } else {
            this.a.p("In-app features could not be enabled because start() was not called.");
        }
        finish();
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
