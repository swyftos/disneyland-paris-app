package com.masteratul.exceptionhandler;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;

/* loaded from: classes4.dex */
public class DefaultErrorScreen extends Activity {
    private static String TAG = "RN_ERROR_HANDLER";
    private Button quitButton;
    private Button relaunchButton;
    private Button showDetailsButton;
    private TextView stackTraceView;

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
    protected void onCreate(Bundle bundle) {
        String string;
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        super.onCreate(bundle);
        try {
            string = getIntent().getExtras().getString("stack_trace_string");
        } catch (Exception e) {
            Log.e(TAG, String.format("Was not able to get StackTrace: %s", e.getMessage()));
            string = "StackTrace unavailable";
        }
        setContentView(R.layout.default_error_screen);
        this.quitButton = (Button) findViewById(R.id.eh_quit_button);
        this.relaunchButton = (Button) findViewById(R.id.eh_restart_button);
        this.showDetailsButton = (Button) findViewById(R.id.eh_show_details_button);
        TextView textView = (TextView) findViewById(R.id.eh_stack_trace_text_view);
        this.stackTraceView = textView;
        textView.setText(string);
        InstrumentationCallbacks.setOnClickListenerCalled(this.showDetailsButton, new View.OnClickListener() { // from class: com.masteratul.exceptionhandler.DefaultErrorScreen.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DefaultErrorScreen.this.stackTraceView.getVisibility() == 0) {
                    DefaultErrorScreen.this.stackTraceView.setVisibility(8);
                    DefaultErrorScreen.this.showDetailsButton.setText("SHOW DETAILS");
                } else {
                    DefaultErrorScreen.this.stackTraceView.setVisibility(0);
                    DefaultErrorScreen.this.showDetailsButton.setText("HIDE DETAILS");
                }
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled(this.relaunchButton, new View.OnClickListener() { // from class: com.masteratul.exceptionhandler.DefaultErrorScreen.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws Exception {
                DefaultErrorScreen.doRestart(DefaultErrorScreen.this.getApplicationContext());
            }
        });
        InstrumentationCallbacks.setOnClickListenerCalled(this.quitButton, new View.OnClickListener() { // from class: com.masteratul.exceptionhandler.DefaultErrorScreen.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    public static void doRestart(Context context) throws Exception {
        try {
            if (context != null) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName());
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 654311, launchIntentForPackage, 268435456));
                        System.exit(0);
                        return;
                    }
                    throw new Exception("Was not able to restart application, mStartActivity null");
                }
                throw new Exception("Was not able to restart application, PM null");
            }
            throw new Exception("Was not able to restart application, Context null");
        } catch (Exception unused) {
            Log.e(TAG, "Was not able to restart application");
        }
    }
}
