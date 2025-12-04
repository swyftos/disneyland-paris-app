package com.urbanairship.actions;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.Autopilot;
import com.urbanairship.R;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.activity.ThemedActivity;
import com.urbanairship.util.AppStoreUtils;

/* loaded from: classes4.dex */
public class RateAppActivity extends ThemedActivity {
    private AlertDialog dialog;

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Autopilot.automaticTakeOff(getApplication());
        if (UAirship.isTakingOff() || UAirship.isFlying()) {
            return;
        }
        UALog.e("RateAppActivity - unable to create activity, takeOff not called.", new Object[0]);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        UALog.d("New intent received for rate app activity", new Object[0]);
        restartActivity(intent.getData(), intent.getExtras());
    }

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onResume() {
        super.onResume();
        displayDialog();
    }

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onPause() {
        super.onPause();
    }

    public void onCloseButtonClick(@NonNull View view) {
        finish();
    }

    private void displayDialog() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            Intent intent = getIntent();
            if (intent == null) {
                UALog.e("RateAppActivity - Started activity with null intent.", new Object[0]);
                finish();
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if (intent.getStringExtra("title") != null) {
                builder.setTitle(intent.getStringExtra("title"));
            } else {
                builder.setTitle(getString(R.string.ua_rate_app_action_default_title, getAppName()));
            }
            if (intent.getStringExtra(RateAppAction.BODY_KEY) != null) {
                builder.setMessage(intent.getStringExtra(RateAppAction.BODY_KEY));
            } else {
                builder.setMessage(getString(R.string.ua_rate_app_action_default_body, getString(R.string.ua_rate_app_action_default_rate_positive_button)));
            }
            builder.setPositiveButton(getString(R.string.ua_rate_app_action_default_rate_positive_button), new DialogInterface.OnClickListener() { // from class: com.urbanairship.actions.RateAppActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        UAirship uAirshipShared = UAirship.shared();
                        RateAppActivity.this.startActivity(AppStoreUtils.getAppStoreIntent(this, uAirshipShared.getPlatformType(), uAirshipShared.getAirshipConfigOptions()));
                    } catch (ActivityNotFoundException e) {
                        UALog.e(e, "No web browser available to handle request to open the store link.", new Object[0]);
                    }
                    dialogInterface.cancel();
                    RateAppActivity.this.finish();
                }
            });
            builder.setNegativeButton(getString(R.string.ua_rate_app_action_default_rate_negative_button), new DialogInterface.OnClickListener() { // from class: com.urbanairship.actions.RateAppActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    RateAppActivity.this.finish();
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.urbanairship.actions.RateAppActivity.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.cancel();
                    RateAppActivity.this.finish();
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.dialog = alertDialogCreate;
            alertDialogCreate.setCancelable(true);
            this.dialog.show();
        }
    }

    private void restartActivity(Uri uri, Bundle bundle) {
        UALog.d("Relaunching activity", new Object[0]);
        finish();
        Intent flags = new Intent().setClass(this, getClass()).setData(uri).setFlags(268435456);
        if (bundle != null) {
            flags.putExtras(bundle);
        }
        startActivity(flags);
    }

    private String getAppName() {
        String packageName = UAirship.getApplicationContext().getPackageName();
        PackageManager packageManager = UAirship.getApplicationContext().getPackageManager();
        try {
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }
}
