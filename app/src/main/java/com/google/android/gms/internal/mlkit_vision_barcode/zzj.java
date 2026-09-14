package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "CalendarDateTimeCreator")
@SafeParcelable.Reserved({1})
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzw();

    @SafeParcelable.Field(m1451id = 2)
    public int zza;

    @SafeParcelable.Field(m1451id = 3)
    public int zzb;

    @SafeParcelable.Field(m1451id = 4)
    public int zzc;

    @SafeParcelable.Field(m1451id = 5)
    public int zzd;

    @SafeParcelable.Field(m1451id = 6)
    public int zze;

    @SafeParcelable.Field(m1451id = 7)
    public int zzf;

    @SafeParcelable.Field(m1451id = 8)
    public boolean zzg;

    @SafeParcelable.Field(m1451id = 9)
    public String zzh;

    public zzj() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeInt(parcel, 5, this.zzd);
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(m1452id = 2) int i, @SafeParcelable.Param(m1452id = 3) int i2, @SafeParcelable.Param(m1452id = 4) int i3, @SafeParcelable.Param(m1452id = 5) int i4, @SafeParcelable.Param(m1452id = 6) int i5, @SafeParcelable.Param(m1452id = 7) int i6, @SafeParcelable.Param(m1452id = 8) boolean z, @SafeParcelable.Param(m1452id = 9) String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = z;
        this.zzh = str;
    }
}
