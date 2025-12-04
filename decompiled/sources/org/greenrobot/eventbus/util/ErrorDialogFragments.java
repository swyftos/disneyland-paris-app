package org.greenrobot.eventbus.util;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;

/* loaded from: classes6.dex */
public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON;
    public static Class<?> EVENT_TYPE_ON_CLICK;

    public static Dialog createDialog(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.KEY_TITLE));
        builder.setMessage(bundle.getString(ErrorDialogManager.KEY_MESSAGE));
        int i = ERROR_DIALOG_ICON;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(R.string.ok, onClickListener);
        return builder.create();
    }

    public static void handleOnClick(DialogInterface dialogInterface, int i, Activity activity, Bundle bundle) throws IllegalAccessException, InstantiationException {
        Class<?> cls = EVENT_TYPE_ON_CLICK;
        if (cls != null) {
            try {
                ErrorDialogManager.factory.config.getEventBus().post(cls.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (!bundle.getBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) || activity == null) {
            return;
        }
        activity.finish();
    }

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.app.DialogFragment, android.app.Fragment
        public void onStart() {
            InstrumentationCallbacks.onStartCalled(this);
            super.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.app.DialogFragment, android.app.Fragment
        public void onStop() {
            InstrumentationCallbacks.onStopCalled(this);
            super.onStop();
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) throws IllegalAccessException, InstantiationException {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
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

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) throws IllegalAccessException, InstantiationException {
            ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
        }
    }
}
