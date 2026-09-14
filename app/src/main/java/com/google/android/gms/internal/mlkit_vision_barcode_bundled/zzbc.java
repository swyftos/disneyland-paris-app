package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "BarhopperAdvancedConfigParcelCreator")
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();
    private final zzbt zza;
    private final zzbv zzb;
    private final boolean zzc = true;
    private final boolean zzd;

    @SafeParcelable.Constructor
    public zzbc(@SafeParcelable.Param(m1452id = 1) zzbt zzbtVar, @SafeParcelable.Param(m1452id = 2) zzbv zzbvVar, @SafeParcelable.Param(m1452id = 3) boolean z, @SafeParcelable.Param(m1452id = 4) boolean z2) {
        this.zza = zzbtVar;
        this.zzb = zzbvVar;
        this.zzd = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzbt zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzd;
    }
}
