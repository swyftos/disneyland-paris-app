package com.reactcommunity.rndatetimepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class RNDatePickerDialogFragment extends DialogFragment {
    private DatePickerDialog instance;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnClickListener mOnNeutralButtonActionListener;

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
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog datePickerDialogCreateDialog = createDialog(getArguments());
        this.instance = datePickerDialogCreateDialog;
        return datePickerDialogCreateDialog;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateDate(rNDate.year(), rNDate.month(), rNDate.day());
    }

    static DatePickerDialog getDialog(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        RNDate rNDate = new RNDate(bundle);
        int iYear = rNDate.year();
        int iMonth = rNDate.month();
        int iDay = rNDate.day();
        RNDatePickerDisplay displayDate = (bundle == null || bundle.getString("display", null) == null) ? Common.getDisplayDate(bundle) : RNDatePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        if (displayDate == RNDatePickerDisplay.SPINNER) {
            return new RNDismissableDatePickerDialog(context, R.style.SpinnerDatePickerDialog, onDateSetListener, iYear, iMonth, iDay, displayDate);
        }
        return new RNDismissableDatePickerDialog(context, onDateSetListener, iYear, iMonth, iDay, displayDate);
    }

    private DatePickerDialog createDialog(final Bundle bundle) {
        FragmentActivity activity = getActivity();
        DatePickerDialog dialog = getDialog(bundle, activity, this.mOnDateSetListener);
        if (bundle != null) {
            Common.setButtonTitles(bundle, dialog, this.mOnNeutralButtonActionListener);
            if (activity != null) {
                dialog.setOnShowListener(Common.setButtonTextColor(activity, dialog, bundle, Common.getDisplayDate(bundle) == RNDatePickerDisplay.SPINNER));
            }
        }
        final DatePicker datePicker = dialog.getDatePicker();
        final long jMinDateWithTimeZone = Common.minDateWithTimeZone(bundle);
        final long jMaxDateWithTimeZone = Common.maxDateWithTimeZone(bundle);
        if (bundle.containsKey(RNConstants.ARG_MINDATE)) {
            datePicker.setMinDate(jMinDateWithTimeZone);
        } else {
            datePicker.setMinDate(RNConstants.DEFAULT_MIN_DATE);
        }
        if (bundle.containsKey(RNConstants.ARG_MAXDATE)) {
            datePicker.setMaxDate(jMaxDateWithTimeZone);
        }
        if (bundle.containsKey(RNConstants.FIRST_DAY_OF_WEEK)) {
            datePicker.setFirstDayOfWeek(bundle.getInt(RNConstants.FIRST_DAY_OF_WEEK));
        }
        if (bundle.containsKey(RNConstants.ARG_MAXDATE) || bundle.containsKey(RNConstants.ARG_MINDATE)) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() { // from class: com.reactcommunity.rndatetimepicker.RNDatePickerDialogFragment$$ExternalSyntheticLambda0
                @Override // android.widget.DatePicker.OnDateChangedListener
                public final void onDateChanged(DatePicker datePicker2, int i, int i2, int i3) {
                    RNDatePickerDialogFragment.lambda$createDialog$0(bundle, jMinDateWithTimeZone, jMaxDateWithTimeZone, datePicker, datePicker2, i, i2, i3);
                }
            });
        }
        if (bundle.containsKey("testID")) {
            datePicker.setTag(bundle.getString("testID"));
        }
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDialog$0(Bundle bundle, long j, long j2, DatePicker datePicker, DatePicker datePicker2, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance(Common.getTimeZone(bundle));
        calendar.set(i, i2, i3, 0, 0, 0);
        calendar.setTimeInMillis(Math.min(Math.max(calendar.getTimeInMillis(), j), j2));
        if (datePicker.getYear() == calendar.get(1) && datePicker.getMonth() == calendar.get(2) && datePicker.getDayOfMonth() == calendar.get(5)) {
            return;
        }
        datePicker.updateDate(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    void setOnNeutralButtonActionListener(DialogInterface.OnClickListener onClickListener) {
        this.mOnNeutralButtonActionListener = onClickListener;
    }
}
