package com.proyecto26.inappbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes4.dex */
public class ChromeTabsManagerActivity extends Activity {
    private boolean mOpened = false;
    private String resultType = null;
    private boolean isError = false;

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
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    public static Intent createStartIntent(Context context, Intent intent) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.putExtra("browserIntent", intent);
        return intentCreateBaseIntent;
    }

    public static Intent createDismissIntent(Context context) {
        Intent intentCreateBaseIntent = createBaseIntent(context);
        intentCreateBaseIntent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        return intentCreateBaseIntent;
    }

    private static Intent createBaseIntent(Context context) {
        return new Intent(context, (Class<?>) ChromeTabsManagerActivity.class);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        try {
            super.onCreate(bundle);
            if (!getIntent().hasExtra("browserIntent") || (bundle != null && bundle.getString("browserResultType") != null)) {
                finish();
                return;
            }
            Intent intent = (Intent) getIntent().getParcelableExtra("browserIntent");
            intent.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            startActivity(intent);
            this.resultType = "dismiss";
        } catch (Exception e) {
            this.isError = true;
            EventBus.getDefault().post(new ChromeTabsDismissedEvent("Unable to open url.", this.resultType, Boolean.valueOf(this.isError)));
            finish();
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        if (!this.mOpened) {
            this.mOpened = true;
        } else {
            this.resultType = "cancel";
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        String str = this.resultType;
        if (str != null) {
            str.hashCode();
            if (str.equals("cancel")) {
                EventBus.getDefault().post(new ChromeTabsDismissedEvent("chrome tabs activity closed", this.resultType, Boolean.valueOf(this.isError)));
            } else {
                EventBus.getDefault().post(new ChromeTabsDismissedEvent("chrome tabs activity destroyed", "dismiss", Boolean.valueOf(this.isError)));
            }
            this.resultType = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.resultType = bundle.getString("browserResultType");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("browserResultType", "dismiss");
        super.onSaveInstanceState(bundle);
    }
}
