package com.urbanairship.google;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.gms.common.GoogleApiAvailability;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;

/* loaded from: classes5.dex */
public class PlayServicesErrorActivity extends FragmentActivity {
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        super.onCreate(bundle);
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            if (i2 == -1) {
                UALog.d("Google Play services resolution received result ok.", new Object[0]);
                checkPlayServices();
            } else {
                UALog.d("Google Play services resolution canceled.", new Object[0]);
                finish();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
        if (getSupportFragmentManager().findFragmentByTag("error_dialog") == null) {
            checkPlayServices();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
        if (isFinishing() && GooglePlayServicesUtilWrapper.isGooglePlayServicesAvailable(this) == 0 && UAirship.shared().getPushManager().isPushEnabled()) {
            UAirship.shared().getChannel().updateRegistration();
        }
    }

    private void checkPlayServices() {
        UALog.i("Checking Google Play services.", new Object[0]);
        int iIsGooglePlayServicesAvailable = GooglePlayServicesUtilWrapper.isGooglePlayServicesAvailable(this);
        if (iIsGooglePlayServicesAvailable == 0) {
            UALog.d("Google Play services available!", new Object[0]);
            finish();
        } else if (GooglePlayServicesUtilWrapper.isUserRecoverableError(iIsGooglePlayServicesAvailable)) {
            UALog.d("Google Play services recoverable error: %s", Integer.valueOf(iIsGooglePlayServicesAvailable));
            ErrorDialogFragment.createInstance(iIsGooglePlayServicesAvailable).show(getSupportFragmentManager(), "error_dialog");
        } else {
            UALog.e("Unrecoverable Google Play services error: %s", Integer.valueOf(iIsGooglePlayServicesAvailable));
            finish();
        }
    }

    public static class ErrorDialogFragment extends DialogFragment {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            InstrumentationCallbacks.onPauseCalled(this);
            super.onPause();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            InstrumentationCallbacks.onResumeCalled(this);
            super.onResume();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            InstrumentationCallbacks.onStartCalled(this);
            super.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStop() {
            InstrumentationCallbacks.onStopCalled(this);
            super.onStop();
        }

        @NonNull
        public static ErrorDialogFragment createInstance(int i) {
            ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("dialog_error", i);
            errorDialogFragment.setArguments(bundle);
            return errorDialogFragment;
        }

        @Override // androidx.fragment.app.DialogFragment
        @NonNull
        public Dialog onCreateDialog(@Nullable Bundle bundle) {
            return GoogleApiAvailability.getInstance().getErrorDialog(getActivity(), getArguments() != null ? getArguments().getInt("dialog_error") : 0, 1000);
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(@NonNull DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            if (getActivity() != null) {
                getActivity().finish();
            }
        }
    }
}
