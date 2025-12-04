package com.google.mlkit.vision.barcode.common.internal;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.vision.barcode.common.Barcode;

@KeepForSdk
/* loaded from: classes4.dex */
public interface BarcodeSource {
    @Nullable
    @KeepForSdk
    Rect getBoundingBox();

    @Nullable
    @KeepForSdk
    Barcode.CalendarEvent getCalendarEvent();

    @Nullable
    @KeepForSdk
    Barcode.ContactInfo getContactInfo();

    @Nullable
    @KeepForSdk
    Point[] getCornerPoints();

    @Nullable
    @KeepForSdk
    String getDisplayValue();

    @Nullable
    @KeepForSdk
    Barcode.DriverLicense getDriverLicense();

    @Nullable
    @KeepForSdk
    Barcode.Email getEmail();

    @KeepForSdk
    int getFormat();

    @Nullable
    @KeepForSdk
    Barcode.GeoPoint getGeoPoint();

    @Nullable
    @KeepForSdk
    Barcode.Phone getPhone();

    @Nullable
    @KeepForSdk
    byte[] getRawBytes();

    @Nullable
    @KeepForSdk
    String getRawValue();

    @Nullable
    @KeepForSdk
    Barcode.Sms getSms();

    @Nullable
    @KeepForSdk
    Barcode.UrlBookmark getUrl();

    @KeepForSdk
    int getValueType();

    @Nullable
    @KeepForSdk
    Barcode.WiFi getWifi();
}
