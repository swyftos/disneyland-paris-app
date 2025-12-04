package com.urbanairship.push;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.Autopilot;
import com.urbanairship.ResultCallback;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class NotificationProxyActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onCreate(@Nullable Bundle bundle) {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        super.onCreate(bundle);
        Autopilot.automaticTakeOff(this);
        if (!UAirship.isTakingOff() && !UAirship.isFlying()) {
            UALog.e("NotificationProxyActivity - unable to receive intent, takeOff not called.", new Object[0]);
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent == null || intent.getAction() == null) {
            finish();
            return;
        }
        UALog.v("Received intent: %s", intent.getAction());
        new NotificationIntentProcessor(this, intent).process().addResultCallback(new ResultCallback() { // from class: com.urbanairship.push.NotificationProxyActivity.1
            @Override // com.urbanairship.ResultCallback
            public void onResult(Boolean bool) {
                UALog.v("Finished processing notification intent with result %s.", bool);
            }
        });
        finish();
    }
}
