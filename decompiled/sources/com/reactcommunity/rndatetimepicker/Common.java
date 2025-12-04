package com.reactcommunity.rndatetimepicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.disney.id.android.tracker.OneIDTracker;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.util.RNLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* loaded from: classes4.dex */
public class Common {
    public static final String LABEL = "label";
    public static final String NEGATIVE = "negative";
    public static final String NEUTRAL = "neutral";
    public static final String POSITIVE = "positive";
    public static final String TEXT_COLOR = "textColor";

    public static void dismissDialog(FragmentActivity fragmentActivity, String str, Promise promise) {
        if (fragmentActivity == null) {
            promise.reject(RNConstants.ERROR_NO_ACTIVITY, "Tried to close a " + str + " dialog while not attached to an Activity");
            return;
        }
        try {
            DialogFragment dialogFragment = (DialogFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
            boolean z = dialogFragment != null;
            if (z) {
                dialogFragment.dismiss();
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public static int getDefaultDialogButtonTextColor(@NonNull Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.textColorPrimary, typedValue, true);
        int i = typedValue.resourceId;
        if (i != 0) {
            return ContextCompat.getColor(context, i);
        }
        return typedValue.data;
    }

    @NonNull
    public static DialogInterface.OnShowListener setButtonTextColor(@NonNull final Context context, final AlertDialog alertDialog, final Bundle bundle, final boolean z) {
        return new DialogInterface.OnShowListener() { // from class: com.reactcommunity.rndatetimepicker.Common$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Common.lambda$setButtonTextColor$0(alertDialog, context, bundle, z, dialogInterface);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setButtonTextColor$0(AlertDialog alertDialog, Context context, Bundle bundle, boolean z, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-1);
        Button button2 = alertDialog.getButton(-2);
        Button button3 = alertDialog.getButton(-3);
        int defaultDialogButtonTextColor = getDefaultDialogButtonTextColor(context);
        setTextColor(button, POSITIVE, bundle, z, defaultDialogButtonTextColor);
        setTextColor(button2, NEGATIVE, bundle, z, defaultDialogButtonTextColor);
        setTextColor(button3, NEUTRAL, bundle, z, defaultDialogButtonTextColor);
    }

    private static void setTextColor(Button button, String str, Bundle bundle, boolean z, int i) {
        if (button == null) {
            return;
        }
        Integer buttonColor = getButtonColor(bundle, str);
        if (z || buttonColor != null) {
            if (buttonColor != null) {
                i = buttonColor.intValue();
            }
            button.setTextColor(i);
        }
    }

    private static Integer getButtonColor(Bundle bundle, String str) {
        Bundle bundle2;
        int i;
        Bundle bundle3 = bundle.getBundle(RNConstants.ARG_DIALOG_BUTTONS);
        if (bundle3 == null || (bundle2 = bundle3.getBundle(str)) == null || (i = (int) bundle2.getDouble(TEXT_COLOR, AudioStats.AUDIO_AMPLITUDE_NONE)) == 0) {
            return null;
        }
        return Integer.valueOf(i);
    }

    public static RNTimePickerDisplay getDisplayTime(Bundle bundle) {
        RNTimePickerDisplay rNTimePickerDisplay = RNTimePickerDisplay.DEFAULT;
        return (bundle == null || bundle.getString("display", null) == null) ? rNTimePickerDisplay : RNTimePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
    }

    public static RNDatePickerDisplay getDisplayDate(Bundle bundle) {
        RNDatePickerDisplay rNDatePickerDisplay = RNDatePickerDisplay.DEFAULT;
        return (bundle == null || bundle.getString("display", null) == null) ? rNDatePickerDisplay : RNDatePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setButtonTitles(@NonNull Bundle bundle, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener) {
        Bundle bundle2 = bundle.getBundle(RNConstants.ARG_DIALOG_BUTTONS);
        if (bundle2 == null) {
            return;
        }
        setButtonLabel(bundle2.getBundle(NEUTRAL), alertDialog, -3, onClickListener);
        DialogInterface.OnClickListener onClickListener2 = (DialogInterface.OnClickListener) alertDialog;
        setButtonLabel(bundle2.getBundle(POSITIVE), alertDialog, -1, onClickListener2);
        setButtonLabel(bundle2.getBundle(NEGATIVE), alertDialog, -2, onClickListener2);
    }

    private static void setButtonLabel(Bundle bundle, AlertDialog alertDialog, int i, DialogInterface.OnClickListener onClickListener) {
        if (bundle == null || bundle.getString("label") == null) {
            return;
        }
        alertDialog.setButton(i, bundle.getString("label"), onClickListener);
    }

    public static TimeZone getTimeZone(Bundle bundle) {
        if (bundle != null && bundle.containsKey(RNConstants.ARG_TZOFFSET_MINS)) {
            return new SimpleTimeZone(((int) bundle.getLong(RNConstants.ARG_TZOFFSET_MINS)) * OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC, TimeZones.GMT_ID);
        }
        if (bundle != null && bundle.containsKey(RNConstants.ARG_TZ_NAME)) {
            String string = bundle.getString(RNConstants.ARG_TZ_NAME);
            if (!TimeZones.GMT_ID.equals(string)) {
                if (!TimeZones.GMT_ID.equals(TimeZone.getTimeZone(string).getID())) {
                    return TimeZone.getTimeZone(string);
                }
                RNLog.w(null, "'" + string + "' does not exist in TimeZone.getAvailableIDs(). Falling back to TimeZone.getDefault()=" + TimeZone.getDefault().getID());
            } else {
                return TimeZone.getTimeZone(TimeZones.GMT_ID);
            }
        }
        return TimeZone.getDefault();
    }

    public static long maxDateWithTimeZone(Bundle bundle) {
        if (!bundle.containsKey(RNConstants.ARG_MAXDATE)) {
            return Long.MAX_VALUE;
        }
        Calendar calendar = Calendar.getInstance(getTimeZone(bundle));
        calendar.setTimeInMillis(bundle.getLong(RNConstants.ARG_MAXDATE));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    public static long minDateWithTimeZone(Bundle bundle) {
        if (!bundle.containsKey(RNConstants.ARG_MINDATE)) {
            return 0L;
        }
        Calendar calendar = Calendar.getInstance(getTimeZone(bundle));
        calendar.setTimeInMillis(bundle.getLong(RNConstants.ARG_MINDATE));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey(RNConstants.ARG_TZ_NAME) && !readableMap.isNull(RNConstants.ARG_TZ_NAME)) {
            bundle.putString(RNConstants.ARG_TZ_NAME, readableMap.getString(RNConstants.ARG_TZ_NAME));
        }
        if (readableMap.hasKey("title") && !readableMap.isNull("title")) {
            bundle.putString("title", readableMap.getString("title"));
        }
        if (readableMap.hasKey(RNConstants.ARG_INITIAL_INPUT_MODE) && !readableMap.isNull(RNConstants.ARG_INITIAL_INPUT_MODE)) {
            bundle.putString(RNConstants.ARG_INITIAL_INPUT_MODE, readableMap.getString(RNConstants.ARG_INITIAL_INPUT_MODE));
        }
        return bundle;
    }

    public static Bundle createDatePickerArguments(ReadableMap readableMap) {
        Bundle bundleCreateFragmentArguments = createFragmentArguments(readableMap);
        if (readableMap.hasKey(RNConstants.ARG_MINDATE) && !readableMap.isNull(RNConstants.ARG_MINDATE)) {
            bundleCreateFragmentArguments.putLong(RNConstants.ARG_MINDATE, (long) readableMap.getDouble(RNConstants.ARG_MINDATE));
        }
        if (readableMap.hasKey(RNConstants.ARG_MAXDATE) && !readableMap.isNull(RNConstants.ARG_MAXDATE)) {
            bundleCreateFragmentArguments.putLong(RNConstants.ARG_MAXDATE, (long) readableMap.getDouble(RNConstants.ARG_MAXDATE));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundleCreateFragmentArguments.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey(RNConstants.ARG_DIALOG_BUTTONS) && !readableMap.isNull(RNConstants.ARG_DIALOG_BUTTONS)) {
            bundleCreateFragmentArguments.putBundle(RNConstants.ARG_DIALOG_BUTTONS, Arguments.toBundle(readableMap.getMap(RNConstants.ARG_DIALOG_BUTTONS)));
        }
        if (readableMap.hasKey(RNConstants.ARG_TZOFFSET_MINS) && !readableMap.isNull(RNConstants.ARG_TZOFFSET_MINS)) {
            bundleCreateFragmentArguments.putLong(RNConstants.ARG_TZOFFSET_MINS, (long) readableMap.getDouble(RNConstants.ARG_TZOFFSET_MINS));
        }
        if (readableMap.hasKey("testID") && !readableMap.isNull("testID")) {
            bundleCreateFragmentArguments.putString("testID", readableMap.getString("testID"));
        }
        if (readableMap.hasKey(RNConstants.ARG_FULLSCREEN) && !readableMap.isNull(RNConstants.ARG_FULLSCREEN)) {
            bundleCreateFragmentArguments.putBoolean(RNConstants.ARG_FULLSCREEN, readableMap.getBoolean(RNConstants.ARG_FULLSCREEN));
        }
        if (readableMap.hasKey(RNConstants.FIRST_DAY_OF_WEEK) && !readableMap.isNull(RNConstants.FIRST_DAY_OF_WEEK)) {
            bundleCreateFragmentArguments.putInt(RNConstants.FIRST_DAY_OF_WEEK, readableMap.getInt(RNConstants.FIRST_DAY_OF_WEEK) + 1);
        }
        return bundleCreateFragmentArguments;
    }

    public static Bundle createTimePickerArguments(ReadableMap readableMap) {
        Bundle bundleCreateFragmentArguments = createFragmentArguments(readableMap);
        if (readableMap.hasKey(RNConstants.ARG_IS24HOUR) && !readableMap.isNull(RNConstants.ARG_IS24HOUR)) {
            bundleCreateFragmentArguments.putBoolean(RNConstants.ARG_IS24HOUR, readableMap.getBoolean(RNConstants.ARG_IS24HOUR));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundleCreateFragmentArguments.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey(RNConstants.ARG_DIALOG_BUTTONS) && !readableMap.isNull(RNConstants.ARG_DIALOG_BUTTONS)) {
            bundleCreateFragmentArguments.putBundle(RNConstants.ARG_DIALOG_BUTTONS, Arguments.toBundle(readableMap.getMap(RNConstants.ARG_DIALOG_BUTTONS)));
        }
        if (readableMap.hasKey(RNConstants.ARG_INTERVAL) && !readableMap.isNull(RNConstants.ARG_INTERVAL)) {
            bundleCreateFragmentArguments.putInt(RNConstants.ARG_INTERVAL, readableMap.getInt(RNConstants.ARG_INTERVAL));
        }
        if (readableMap.hasKey(RNConstants.ARG_TZOFFSET_MINS) && !readableMap.isNull(RNConstants.ARG_TZOFFSET_MINS)) {
            bundleCreateFragmentArguments.putLong(RNConstants.ARG_TZOFFSET_MINS, (long) readableMap.getDouble(RNConstants.ARG_TZOFFSET_MINS));
        }
        return bundleCreateFragmentArguments;
    }
}
