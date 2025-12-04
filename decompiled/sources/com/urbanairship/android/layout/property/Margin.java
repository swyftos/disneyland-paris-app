package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public class Margin {
    public static Margin NONE = new Margin(0, 0, 0, 0);
    private final int bottom;
    private final int end;
    private final int start;
    private final int top;

    public Margin(int i, int i2, int i3, int i4) {
        this.top = i;
        this.bottom = i2;
        this.start = i3;
        this.end = i4;
    }

    @NonNull
    public static Margin fromJson(@NonNull JsonMap jsonMap) {
        return new Margin(jsonMap.opt(ViewProps.TOP).getInt(0), jsonMap.opt(ViewProps.BOTTOM).getInt(0), jsonMap.opt(ViewProps.START).getInt(0), jsonMap.opt(ViewProps.END).getInt(0));
    }

    public int getTop() {
        return this.top;
    }

    public int getBottom() {
        return this.bottom;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
