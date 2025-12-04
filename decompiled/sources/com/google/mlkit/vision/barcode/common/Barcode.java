package com.google.mlkit.vision.barcode.common;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class Barcode {
    public static final int FORMAT_ALL_FORMATS = 0;
    public static final int FORMAT_AZTEC = 4096;
    public static final int FORMAT_CODABAR = 8;
    public static final int FORMAT_CODE_128 = 1;
    public static final int FORMAT_CODE_39 = 2;
    public static final int FORMAT_CODE_93 = 4;
    public static final int FORMAT_DATA_MATRIX = 16;
    public static final int FORMAT_EAN_13 = 32;
    public static final int FORMAT_EAN_8 = 64;
    public static final int FORMAT_ITF = 128;
    public static final int FORMAT_PDF417 = 2048;
    public static final int FORMAT_QR_CODE = 256;
    public static final int FORMAT_UNKNOWN = -1;
    public static final int FORMAT_UPC_A = 512;
    public static final int FORMAT_UPC_E = 1024;
    public static final int TYPE_CALENDAR_EVENT = 11;
    public static final int TYPE_CONTACT_INFO = 1;
    public static final int TYPE_DRIVER_LICENSE = 12;
    public static final int TYPE_EMAIL = 2;
    public static final int TYPE_GEO = 10;
    public static final int TYPE_ISBN = 3;
    public static final int TYPE_PHONE = 4;
    public static final int TYPE_PRODUCT = 5;
    public static final int TYPE_SMS = 6;
    public static final int TYPE_TEXT = 7;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 8;
    public static final int TYPE_WIFI = 9;
    private final BarcodeSource zza;
    private final Rect zzb;
    private final Point[] zzc;

    public static class Address {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final int zza;
        private final String[] zzb;

        @Retention(RetentionPolicy.CLASS)
        public @interface AddressType {
        }

        @KeepForSdk
        public Address(int i, @NonNull String[] strArr) {
            this.zza = i;
            this.zzb = strArr;
        }

        @NonNull
        public String[] getAddressLines() {
            return this.zzb;
        }

        @AddressType
        public int getType() {
            return this.zza;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BarcodeFormat {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface BarcodeValueType {
    }

    public static class CalendarDateTime {
        private final int zza;
        private final int zzb;
        private final int zzc;
        private final int zzd;
        private final int zze;
        private final int zzf;
        private final boolean zzg;
        private final String zzh;

        @KeepForSdk
        public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, boolean z, @Nullable String str) {
            this.zza = i;
            this.zzb = i2;
            this.zzc = i3;
            this.zzd = i4;
            this.zze = i5;
            this.zzf = i6;
            this.zzg = z;
            this.zzh = str;
        }

        public int getDay() {
            return this.zzc;
        }

        public int getHours() {
            return this.zzd;
        }

        public int getMinutes() {
            return this.zze;
        }

        public int getMonth() {
            return this.zzb;
        }

        @Nullable
        public String getRawValue() {
            return this.zzh;
        }

        public int getSeconds() {
            return this.zzf;
        }

        public int getYear() {
            return this.zza;
        }

        public boolean isUtc() {
            return this.zzg;
        }
    }

    public static class CalendarEvent {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final CalendarDateTime zzf;
        private final CalendarDateTime zzg;

        @KeepForSdk
        public CalendarEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable CalendarDateTime calendarDateTime, @Nullable CalendarDateTime calendarDateTime2) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = calendarDateTime;
            this.zzg = calendarDateTime2;
        }

        @Nullable
        public String getDescription() {
            return this.zzb;
        }

        @Nullable
        public CalendarDateTime getEnd() {
            return this.zzg;
        }

        @Nullable
        public String getLocation() {
            return this.zzc;
        }

        @Nullable
        public String getOrganizer() {
            return this.zzd;
        }

        @Nullable
        public CalendarDateTime getStart() {
            return this.zzf;
        }

        @Nullable
        public String getStatus() {
            return this.zze;
        }

        @Nullable
        public String getSummary() {
            return this.zza;
        }
    }

    public static class ContactInfo {
        private final PersonName zza;
        private final String zzb;
        private final String zzc;
        private final List zzd;
        private final List zze;
        private final List zzf;
        private final List zzg;

        @KeepForSdk
        public ContactInfo(@Nullable PersonName personName, @Nullable String str, @Nullable String str2, @NonNull List<Phone> list, @NonNull List<Email> list2, @NonNull List<String> list3, @NonNull List<Address> list4) {
            this.zza = personName;
            this.zzb = str;
            this.zzc = str2;
            this.zzd = list;
            this.zze = list2;
            this.zzf = list3;
            this.zzg = list4;
        }

        @NonNull
        public List<Address> getAddresses() {
            return this.zzg;
        }

        @NonNull
        public List<Email> getEmails() {
            return this.zze;
        }

        @Nullable
        public PersonName getName() {
            return this.zza;
        }

        @Nullable
        public String getOrganization() {
            return this.zzb;
        }

        @NonNull
        public List<Phone> getPhones() {
            return this.zzd;
        }

        @Nullable
        public String getTitle() {
            return this.zzc;
        }

        @NonNull
        public List<String> getUrls() {
            return this.zzf;
        }
    }

    public static class DriverLicense {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final String zzf;
        private final String zzg;
        private final String zzh;
        private final String zzi;
        private final String zzj;
        private final String zzk;
        private final String zzl;
        private final String zzm;
        private final String zzn;

        @KeepForSdk
        public DriverLicense(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = str6;
            this.zzg = str7;
            this.zzh = str8;
            this.zzi = str9;
            this.zzj = str10;
            this.zzk = str11;
            this.zzl = str12;
            this.zzm = str13;
            this.zzn = str14;
        }

        @Nullable
        public String getAddressCity() {
            return this.zzg;
        }

        @Nullable
        public String getAddressState() {
            return this.zzh;
        }

        @Nullable
        public String getAddressStreet() {
            return this.zzf;
        }

        @Nullable
        public String getAddressZip() {
            return this.zzi;
        }

        @Nullable
        public String getBirthDate() {
            return this.zzm;
        }

        @Nullable
        public String getDocumentType() {
            return this.zza;
        }

        @Nullable
        public String getExpiryDate() {
            return this.zzl;
        }

        @Nullable
        public String getFirstName() {
            return this.zzb;
        }

        @Nullable
        public String getGender() {
            return this.zze;
        }

        @Nullable
        public String getIssueDate() {
            return this.zzk;
        }

        @Nullable
        public String getIssuingCountry() {
            return this.zzn;
        }

        @Nullable
        public String getLastName() {
            return this.zzd;
        }

        @Nullable
        public String getLicenseNumber() {
            return this.zzj;
        }

        @Nullable
        public String getMiddleName() {
            return this.zzc;
        }
    }

    public static class Email {
        public static final int TYPE_HOME = 2;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final int zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;

        @Retention(RetentionPolicy.CLASS)
        public @interface FormatType {
        }

        @KeepForSdk
        public Email(int i, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.zza = i;
            this.zzb = str;
            this.zzc = str2;
            this.zzd = str3;
        }

        @Nullable
        public String getAddress() {
            return this.zzb;
        }

        @Nullable
        public String getBody() {
            return this.zzd;
        }

        @Nullable
        public String getSubject() {
            return this.zzc;
        }

        @FormatType
        public int getType() {
            return this.zza;
        }
    }

    public static class GeoPoint {
        private final double zza;
        private final double zzb;

        @KeepForSdk
        public GeoPoint(double d, double d2) {
            this.zza = d;
            this.zzb = d2;
        }

        public double getLat() {
            return this.zza;
        }

        public double getLng() {
            return this.zzb;
        }
    }

    public static class PersonName {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final String zzf;
        private final String zzg;

        @KeepForSdk
        public PersonName(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = str5;
            this.zzf = str6;
            this.zzg = str7;
        }

        @Nullable
        public String getFirst() {
            return this.zzd;
        }

        @Nullable
        public String getFormattedName() {
            return this.zza;
        }

        @Nullable
        public String getLast() {
            return this.zzf;
        }

        @Nullable
        public String getMiddle() {
            return this.zze;
        }

        @Nullable
        public String getPrefix() {
            return this.zzc;
        }

        @Nullable
        public String getPronunciation() {
            return this.zzb;
        }

        @Nullable
        public String getSuffix() {
            return this.zzg;
        }
    }

    public static class Phone {
        public static final int TYPE_FAX = 3;
        public static final int TYPE_HOME = 2;
        public static final int TYPE_MOBILE = 4;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WORK = 1;
        private final String zza;
        private final int zzb;

        @Retention(RetentionPolicy.CLASS)
        public @interface FormatType {
        }

        @KeepForSdk
        public Phone(@Nullable String str, int i) {
            this.zza = str;
            this.zzb = i;
        }

        @Nullable
        public String getNumber() {
            return this.zza;
        }

        @FormatType
        public int getType() {
            return this.zzb;
        }
    }

    public static class Sms {
        private final String zza;
        private final String zzb;

        @KeepForSdk
        public Sms(@Nullable String str, @Nullable String str2) {
            this.zza = str;
            this.zzb = str2;
        }

        @Nullable
        public String getMessage() {
            return this.zza;
        }

        @Nullable
        public String getPhoneNumber() {
            return this.zzb;
        }
    }

    public static class UrlBookmark {
        private final String zza;
        private final String zzb;

        @KeepForSdk
        public UrlBookmark(@Nullable String str, @Nullable String str2) {
            this.zza = str;
            this.zzb = str2;
        }

        @Nullable
        public String getTitle() {
            return this.zza;
        }

        @Nullable
        public String getUrl() {
            return this.zzb;
        }
    }

    public static class WiFi {
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_WEP = 3;
        public static final int TYPE_WPA = 2;
        private final String zza;
        private final String zzb;
        private final int zzc;

        @Retention(RetentionPolicy.CLASS)
        public @interface EncryptionType {
        }

        @KeepForSdk
        public WiFi(@Nullable String str, @Nullable String str2, int i) {
            this.zza = str;
            this.zzb = str2;
            this.zzc = i;
        }

        @EncryptionType
        public int getEncryptionType() {
            return this.zzc;
        }

        @Nullable
        public String getPassword() {
            return this.zzb;
        }

        @Nullable
        public String getSsid() {
            return this.zza;
        }
    }

    @KeepForSdk
    public Barcode(@NonNull BarcodeSource barcodeSource) {
        this(barcodeSource, null);
    }

    @Nullable
    public Rect getBoundingBox() {
        return this.zzb;
    }

    @Nullable
    public CalendarEvent getCalendarEvent() {
        return this.zza.getCalendarEvent();
    }

    @Nullable
    public ContactInfo getContactInfo() {
        return this.zza.getContactInfo();
    }

    @Nullable
    public Point[] getCornerPoints() {
        return this.zzc;
    }

    @Nullable
    public String getDisplayValue() {
        return this.zza.getDisplayValue();
    }

    @Nullable
    public DriverLicense getDriverLicense() {
        return this.zza.getDriverLicense();
    }

    @Nullable
    public Email getEmail() {
        return this.zza.getEmail();
    }

    @BarcodeFormat
    public int getFormat() {
        int format = this.zza.getFormat();
        if (format > 4096 || format == 0) {
            return -1;
        }
        return format;
    }

    @Nullable
    public GeoPoint getGeoPoint() {
        return this.zza.getGeoPoint();
    }

    @Nullable
    public Phone getPhone() {
        return this.zza.getPhone();
    }

    @Nullable
    public byte[] getRawBytes() {
        byte[] rawBytes = this.zza.getRawBytes();
        if (rawBytes != null) {
            return Arrays.copyOf(rawBytes, rawBytes.length);
        }
        return null;
    }

    @Nullable
    public String getRawValue() {
        return this.zza.getRawValue();
    }

    @Nullable
    public Sms getSms() {
        return this.zza.getSms();
    }

    @Nullable
    public UrlBookmark getUrl() {
        return this.zza.getUrl();
    }

    @BarcodeValueType
    public int getValueType() {
        return this.zza.getValueType();
    }

    @Nullable
    public WiFi getWifi() {
        return this.zza.getWifi();
    }

    @KeepForSdk
    public Barcode(@NonNull BarcodeSource barcodeSource, @Nullable Matrix matrix) {
        this.zza = (BarcodeSource) Preconditions.checkNotNull(barcodeSource);
        Rect boundingBox = barcodeSource.getBoundingBox();
        if (boundingBox != null && matrix != null) {
            CommonConvertUtils.transformRect(boundingBox, matrix);
        }
        this.zzb = boundingBox;
        Point[] cornerPoints = barcodeSource.getCornerPoints();
        if (cornerPoints != null && matrix != null) {
            CommonConvertUtils.transformPointArray(cornerPoints, matrix);
        }
        this.zzc = cornerPoints;
    }
}
