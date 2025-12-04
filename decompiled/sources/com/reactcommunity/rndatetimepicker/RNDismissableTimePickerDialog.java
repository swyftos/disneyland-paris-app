package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TimePicker;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class RNDismissableTimePickerDialog extends MinuteIntervalSnappableTimePickerDialog {
    private void fixSpinner(Context context, int i, int i2, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
    }

    @Override // com.reactcommunity.rndatetimepicker.MinuteIntervalSnappableTimePickerDialog, android.app.Dialog, android.view.Window.Callback
    public /* bridge */ /* synthetic */ void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.reactcommunity.rndatetimepicker.MinuteIntervalSnappableTimePickerDialog, android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
    }

    @Override // com.reactcommunity.rndatetimepicker.MinuteIntervalSnappableTimePickerDialog, android.app.Dialog, android.view.Window.Callback
    public /* bridge */ /* synthetic */ void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.reactcommunity.rndatetimepicker.MinuteIntervalSnappableTimePickerDialog, android.app.TimePickerDialog, android.widget.TimePicker.OnTimeChangedListener
    public /* bridge */ /* synthetic */ void onTimeChanged(TimePicker timePicker, int i, int i2) {
        super.onTimeChanged(timePicker, i, i2);
    }

    @Override // com.reactcommunity.rndatetimepicker.MinuteIntervalSnappableTimePickerDialog, android.app.TimePickerDialog
    public /* bridge */ /* synthetic */ void updateTime(int i, int i2) {
        super.updateTime(i, i2);
    }

    public RNDismissableTimePickerDialog(Context context, @Nullable TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, onTimeSetListener, i, i2, i3, z, rNTimePickerDisplay);
        fixSpinner(context, i, i2, z, rNTimePickerDisplay);
    }

    public RNDismissableTimePickerDialog(Context context, int i, @Nullable TimePickerDialog.OnTimeSetListener onTimeSetListener, int i2, int i3, int i4, boolean z, RNTimePickerDisplay rNTimePickerDisplay) {
        super(context, i, onTimeSetListener, i2, i3, i4, z, rNTimePickerDisplay);
        fixSpinner(context, i2, i3, z, rNTimePickerDisplay);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }
}
