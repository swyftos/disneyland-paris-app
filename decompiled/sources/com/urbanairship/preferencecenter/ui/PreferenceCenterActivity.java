package com.urbanairship.preferencecenter.ui;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.material.appbar.MaterialToolbar;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.preferencecenter.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "fragment", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreferenceCenterActivity extends FragmentActivity {

    @NotNull
    public static final String EXTRA_ID = "com.urbanairship.preferencecenter.PREF_CENTER_ID";
    private PreferenceCenterFragment fragment;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        InstrumentationCallbacks.onCreateCalled(this, savedInstanceState);
        PreferenceCenterFragment preferenceCenterFragment = null;
        if (Build.VERSION.SDK_INT >= 35) {
            EdgeToEdge.enable$default(this, null, null, 3, null);
        }
        super.onCreate(savedInstanceState);
        Autopilot.automaticTakeOff(getApplication());
        if (!UAirship.isTakingOff() && !UAirship.isFlying()) {
            UALog.e("PreferenceCenterActivity - unable to create activity, takeOff not called.", new Object[0]);
            finish();
            return;
        }
        setContentView(LayoutInflater.from(this).inflate(R.layout.ua_activity_preference_center, (ViewGroup) null, false));
        ((MaterialToolbar) findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreferenceCenterActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        FragmentContainerView fragmentContainerView = (FragmentContainerView) findViewById(R.id.fragment_container);
        if (savedInstanceState != null) {
            Fragment fragment = fragmentContainerView.getFragment();
            Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.urbanairship.preferencecenter.ui.PreferenceCenterFragment");
            this.fragment = (PreferenceCenterFragment) fragment;
        }
        if (this.fragment == null) {
            String stringExtra = getIntent().getStringExtra(EXTRA_ID);
            if (stringExtra == null) {
                throw new IllegalArgumentException("Missing required extra: EXTRA_ID");
            }
            this.fragment = PreferenceCenterFragment.INSTANCE.create(stringExtra);
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            int i = R.id.fragment_container;
            PreferenceCenterFragment preferenceCenterFragment2 = this.fragment;
            if (preferenceCenterFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
            } else {
                preferenceCenterFragment = preferenceCenterFragment2;
            }
            fragmentTransactionBeginTransaction.add(i, preferenceCenterFragment, "PREF_CENTER_FRAGMENT").commitNow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PreferenceCenterActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
