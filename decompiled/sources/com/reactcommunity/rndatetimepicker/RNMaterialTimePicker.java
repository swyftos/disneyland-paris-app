package com.reactcommunity.rndatetimepicker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.material.timepicker.MaterialTimePicker;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reactcommunity/rndatetimepicker/RNMaterialTimePicker;", "", "args", "Landroid/os/Bundle;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Landroid/os/Bundle;Lcom/facebook/react/bridge/Promise;Landroidx/fragment/app/FragmentManager;Lcom/facebook/react/bridge/ReactApplicationContext;)V", "promiseResolved", "", "timePicker", "Lcom/google/android/material/timepicker/MaterialTimePicker;", "builder", "Lcom/google/android/material/timepicker/MaterialTimePicker$Builder;", AbstractCircuitBreaker.PROPERTY_NAME, "", "createTimePicker", "setInitialDate", "setTitle", "setInputMode", "setButtons", "setTimeFormat", "addListeners", "show", "Listeners", "react-native-community_datetimepicker_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RNMaterialTimePicker {
    private final Bundle args;
    private MaterialTimePicker.Builder builder;
    private final FragmentManager fragmentManager;
    private final Promise promise;
    private boolean promiseResolved;
    private final ReactApplicationContext reactContext;
    private MaterialTimePicker timePicker;

    public RNMaterialTimePicker(@NotNull Bundle args, @NotNull Promise promise, @NotNull FragmentManager fragmentManager, @NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.args = args;
        this.promise = promise;
        this.fragmentManager = fragmentManager;
        this.reactContext = reactContext;
        this.builder = new MaterialTimePicker.Builder();
    }

    public final void open() {
        createTimePicker();
        addListeners();
        show();
    }

    private final void createTimePicker() {
        setInitialDate();
        setTitle();
        setInputMode();
        setButtons();
        setTimeFormat();
        this.timePicker = this.builder.build();
    }

    private final void setInitialDate() {
        RNDate rNDate = new RNDate(this.args);
        this.builder.setHour(rNDate.hour()).setMinute(rNDate.minute());
    }

    private final void setTitle() {
        String string = this.args.getString("title");
        if (string == null || string.length() == 0) {
            return;
        }
        this.builder.setTitleText(this.args.getString("title"));
    }

    private final void setInputMode() {
        String string = this.args.getString(RNConstants.ARG_INITIAL_INPUT_MODE);
        if (string == null || string.length() == 0) {
            this.builder.setInputMode(0);
            return;
        }
        String string2 = this.args.getString(RNConstants.ARG_INITIAL_INPUT_MODE);
        Intrinsics.checkNotNull(string2);
        String upperCase = string2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (RNMaterialInputMode.valueOf(upperCase) == RNMaterialInputMode.KEYBOARD) {
            this.builder.setInputMode(1);
        } else {
            this.builder.setInputMode(0);
        }
    }

    private final void setButtons() {
        Bundle bundle = this.args.getBundle(RNConstants.ARG_DIALOG_BUTTONS);
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(Common.NEGATIVE);
        Bundle bundle3 = bundle.getBundle(Common.POSITIVE);
        if (bundle2 != null) {
            this.builder.setNegativeButtonText(bundle2.getString("label"));
        }
        if (bundle3 != null) {
            this.builder.setPositiveButtonText(bundle3.getString("label"));
        }
    }

    private final void setTimeFormat() {
        if (this.args.getBoolean(RNConstants.ARG_IS24HOUR)) {
            this.builder.setTimeFormat(1);
        } else if (DateFormat.is24HourFormat(this.reactContext)) {
            this.builder.setTimeFormat(1);
        } else {
            this.builder.setTimeFormat(0);
        }
    }

    private final void addListeners() {
        Listeners listeners = new Listeners();
        MaterialTimePicker materialTimePicker = this.timePicker;
        Intrinsics.checkNotNull(materialTimePicker);
        materialTimePicker.addOnPositiveButtonClickListener(listeners);
        MaterialTimePicker materialTimePicker2 = this.timePicker;
        Intrinsics.checkNotNull(materialTimePicker2);
        materialTimePicker2.addOnDismissListener(listeners);
    }

    private final void show() {
        MaterialTimePicker materialTimePicker = this.timePicker;
        Intrinsics.checkNotNull(materialTimePicker);
        materialTimePicker.show(this.fragmentManager, "RNCMaterialTimePicker");
    }

    private final class Listeners implements View.OnClickListener, DialogInterface.OnDismissListener {
        public Listeners() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            if (RNMaterialTimePicker.this.promiseResolved || !RNMaterialTimePicker.this.reactContext.hasActiveReactInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", RNConstants.ACTION_DISMISSED);
            RNMaterialTimePicker.this.promise.resolve(writableNativeMap);
            RNMaterialTimePicker.this.promiseResolved = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (RNMaterialTimePicker.this.promiseResolved || !RNMaterialTimePicker.this.reactContext.hasActiveReactInstance()) {
                return;
            }
            Calendar calendarCreateNewCalendar = createNewCalendar();
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", RNConstants.ACTION_DATE_SET);
            writableNativeMap.putDouble("timestamp", calendarCreateNewCalendar.getTimeInMillis());
            writableNativeMap.putDouble("utcOffset", (calendarCreateNewCalendar.getTimeZone().getOffset(calendarCreateNewCalendar.getTimeInMillis()) / 1000) / 60);
            RNMaterialTimePicker.this.promise.resolve(writableNativeMap);
            RNMaterialTimePicker.this.promiseResolved = true;
        }

        private final Calendar createNewCalendar() {
            RNDate rNDate = new RNDate(RNMaterialTimePicker.this.args);
            Calendar calendar = Calendar.getInstance(Common.getTimeZone(RNMaterialTimePicker.this.args));
            int iYear = rNDate.year();
            int iMonth = rNDate.month();
            int iDay = rNDate.day();
            MaterialTimePicker materialTimePicker = RNMaterialTimePicker.this.timePicker;
            Intrinsics.checkNotNull(materialTimePicker);
            int hour = materialTimePicker.getHour();
            MaterialTimePicker materialTimePicker2 = RNMaterialTimePicker.this.timePicker;
            Intrinsics.checkNotNull(materialTimePicker2);
            calendar.set(iYear, iMonth, iDay, hour, materialTimePicker2.getMinute(), 0);
            calendar.set(14, 0);
            Intrinsics.checkNotNull(calendar);
            return calendar;
        }
    }
}
