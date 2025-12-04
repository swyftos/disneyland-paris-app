package com.reactcommunity.rndatetimepicker;

import android.os.Bundle;
import java.util.Calendar;

/* loaded from: classes4.dex */
public class RNDate {
    private Calendar now = Calendar.getInstance();

    public RNDate(Bundle bundle) {
        if (bundle != null && bundle.containsKey("value")) {
            this.now.setTimeInMillis(bundle.getLong("value"));
        }
        this.now.setTimeZone(Common.getTimeZone(bundle));
    }

    public int year() {
        return this.now.get(1);
    }

    public int month() {
        return this.now.get(2);
    }

    public int day() {
        return this.now.get(5);
    }

    public int hour() {
        return this.now.get(11);
    }

    public int minute() {
        return this.now.get(12);
    }

    public Long timestamp() {
        return Long.valueOf(this.now.getTimeInMillis());
    }
}
