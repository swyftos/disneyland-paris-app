package com.urbanairship.permission;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class PermissionsActivity extends AppCompatActivity {
    static boolean started = false;
    private PermissionRequest currentRequest;
    private List intents = new ArrayList();
    private boolean isResumed = false;
    private final ActivityResultLauncher requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.urbanairship.permission.PermissionsActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.onPermissionResult((Boolean) obj);
        }
    });

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

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        super.onCreate(bundle);
        Autopilot.automaticTakeOff(getApplication());
        if (bundle == null) {
            addIntent(getIntent());
        }
    }

    private void addIntent(Intent intent) {
        if (intent != null) {
            this.intents.add(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.intents.add(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
        this.isResumed = true;
        processNextIntent();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
        this.isResumed = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        super.onDestroy();
        PermissionRequest permissionRequest = this.currentRequest;
        if (permissionRequest != null) {
            permissionRequest.resultReceiver.send(0, new Bundle());
            this.currentRequest = null;
        }
        for (Intent intent : this.intents) {
            UALog.v("Permission request cancelled", intent);
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("RESULT_RECEIVER_EXTRA");
            if (resultReceiver != null) {
                resultReceiver.send(0, new Bundle());
            }
        }
        this.intents.clear();
        this.requestPermissionLauncher.unregister();
    }

    private void processNextIntent() {
        if (this.intents.isEmpty() && this.currentRequest == null) {
            finish();
            return;
        }
        if (this.isResumed && this.currentRequest == null) {
            Intent intent = (Intent) this.intents.remove(0);
            String stringExtra = intent.getStringExtra("PERMISSION_EXTRA");
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("RESULT_RECEIVER_EXTRA");
            if (stringExtra == null || resultReceiver == null) {
                processNextIntent();
                return;
            }
            this.currentRequest = new PermissionRequest(stringExtra, ActivityCompat.shouldShowRequestPermissionRationale(this, stringExtra), System.currentTimeMillis(), resultReceiver);
            UALog.v("Requesting permission %s", stringExtra);
            this.requestPermissionLauncher.launch(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPermissionResult(Boolean bool) {
        PermissionRequest permissionRequest = this.currentRequest;
        if (permissionRequest == null) {
            return;
        }
        this.currentRequest = null;
        boolean zShouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permissionRequest.permission);
        long jCurrentTimeMillis = System.currentTimeMillis() - permissionRequest.startTime;
        UALog.v("Received permission result: permission %s, shouldShowRequestPermissionRationale before: %s, shouldShowRequestPermissionRationale after: %s, granted: %s, time: %s", permissionRequest.permission, Boolean.valueOf(permissionRequest.startShowRationale), Boolean.valueOf(zShouldShowRequestPermissionRationale), bool, Long.valueOf(jCurrentTimeMillis));
        Bundle bundle = new Bundle();
        if (bool.booleanValue()) {
            bundle.putString("PERMISSION_STATUS", PermissionStatus.GRANTED.name());
        } else {
            bundle.putString("PERMISSION_STATUS", PermissionStatus.DENIED.name());
            if (jCurrentTimeMillis <= 2000 && !zShouldShowRequestPermissionRationale && !permissionRequest.startShowRationale) {
                bundle.putBoolean("SILENTLY_DENIED", true);
            }
        }
        permissionRequest.resultReceiver.send(-1, bundle);
        processNextIntent();
    }

    private static class PermissionRequest {
        final String permission;
        final ResultReceiver resultReceiver;
        final boolean startShowRationale;
        final long startTime;

        public PermissionRequest(String str, boolean z, long j, ResultReceiver resultReceiver) {
            this.permission = str;
            this.startShowRationale = z;
            this.startTime = j;
            this.resultReceiver = resultReceiver;
        }
    }

    @MainThread
    public static void requestPermission(@NonNull Context context, @NonNull String str, @NonNull final Consumer<PermissionRequestResult> consumer) {
        Context applicationContext = context.getApplicationContext();
        Handler handler = new Handler(Looper.getMainLooper());
        if (ContextCompat.checkSelfPermission(applicationContext, str) == 0) {
            handler.post(new Runnable() { // from class: com.urbanairship.permission.PermissionsActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PermissionsActivity.lambda$requestPermission$0(consumer);
                }
            });
        } else {
            applicationContext.startActivity(new Intent(applicationContext, (Class<?>) PermissionsActivity.class).setFlags(805306368).setPackage(UAirship.getPackageName()).putExtra("PERMISSION_EXTRA", str).putExtra("RESULT_RECEIVER_EXTRA", new ResultReceiver(handler) { // from class: com.urbanairship.permission.PermissionsActivity.1
                @Override // android.os.ResultReceiver
                public void onReceiveResult(int i, Bundle bundle) {
                    PermissionsActivity.started = false;
                    if (i == -1) {
                        if (PermissionStatus.valueOf(bundle.getString("PERMISSION_STATUS")) == PermissionStatus.GRANTED) {
                            consumer.accept(PermissionRequestResult.granted());
                            return;
                        } else {
                            consumer.accept(PermissionRequestResult.denied(bundle.getBoolean("SILENTLY_DENIED", false)));
                            return;
                        }
                    }
                    consumer.accept(PermissionRequestResult.denied(false));
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestPermission$0(Consumer consumer) {
        consumer.accept(PermissionRequestResult.granted());
    }
}
