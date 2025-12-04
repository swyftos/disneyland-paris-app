package com.contentsquare.android.analytics.internal.features.clientmode.ui.settings;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.R;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.DeveloperActivationActivity;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.sdk.C0724k3;
import com.contentsquare.android.sdk.K0;
import com.contentsquare.android.sdk.Q5;
import com.contentsquare.android.sdk.V5;
import com.contentsquare.android.sdk.Y5;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class SettingsActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    public static final /* synthetic */ int g = 0;
    public int a;

    @NotNull
    public final Q5 b = new Q5();
    public C0724k3 c;
    public Y5 d;
    public ScrollView e;

    @NotNull
    public final ActivityResultLauncher<Intent> f;

    public SettingsActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SettingsActivity.a(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f = activityResultLauncherRegisterForActivityResult;
    }

    public static final void a(SettingsActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            this$0.recreate();
        }
    }

    public static final void b(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a++;
        Y5 y5 = this$0.d;
        if (y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            y5 = null;
        }
        if (y5.a.getBoolean(PreferencesKey.DEVELOPER_MODE_ACTIVATION_STATE, false) || this$0.a != 10) {
            return;
        }
        this$0.f.launch(new Intent(this$0, (Class<?>) DeveloperActivationActivity.class));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public final void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
            return;
        }
        super.onBackPressed();
        C0724k3 c0724k3 = this.c;
        if (c0724k3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            c0724k3 = null;
        }
        View viewA = c0724k3.b.a();
        if (viewA != null) {
            viewA.setVisibility(0);
        }
        c0724k3.f = 1;
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public final void onBackStackChanged() {
        ScrollView scrollView = this.e;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            scrollView = null;
        }
        scrollView.scrollTo(0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) throws Resources.NotFoundException {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        Q5 q5 = this.b;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        q5.getClass();
        Intrinsics.checkNotNullParameter(application, "application");
        Y5 y5 = new Y5(application);
        Intrinsics.checkNotNullParameter(y5, "<set-?>");
        this.d = y5;
        Logger logger = K0.e;
        Application application2 = getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "application");
        C0724k3 c0724k3 = K0.a.a(application2).b;
        Intrinsics.checkNotNullParameter(c0724k3, "<set-?>");
        this.c = c0724k3;
        super.onCreate(bundle);
        setContentView(R.layout.contentsquare_settings_activity);
        View viewFindViewById = findViewById(R.id.settings_scrollview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.settings_scrollview)");
        this.e = (ScrollView) viewFindViewById;
        Toolbar settingsToolbar = (Toolbar) findViewById(R.id.settings_toolbar);
        setSupportActionBar(settingsToolbar);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new V5()).commitNow();
        }
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        Intrinsics.checkNotNullExpressionValue(settingsToolbar, "settingsToolbar");
        a(settingsToolbar);
        a();
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
    public final void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        this.a = 0;
        C0724k3 c0724k3 = this.c;
        Y5 y5 = null;
        if (c0724k3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            c0724k3 = null;
        }
        View viewA = c0724k3.b.a();
        if (viewA != null) {
            viewA.setVisibility(8);
        }
        c0724k3.f = 2;
        Y5 y52 = this.d;
        if (y52 != null) {
            y5 = y52;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
        }
        if (y5.a.getBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, false)) {
            return;
        }
        finish();
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

    public final void a(Toolbar toolbar) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayShowHomeEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.a(this.f$0, view);
            }
        });
    }

    public static final void a(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    public final void a() throws Resources.NotFoundException {
        String string = getResources().getString(R.string.contentsquare_settings_sdk_version_title, "4.36.0");
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…BuildConfig.VERSION_NAME)");
        ((TextView) findViewById(R.id.contentsquare_footer_version_number)).setText(string);
        InstrumentationCallbacks.setOnClickListenerCalled((RelativeLayout) findViewById(R.id.settings_footer), new View.OnClickListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.b(this.f$0, view);
            }
        });
    }
}
