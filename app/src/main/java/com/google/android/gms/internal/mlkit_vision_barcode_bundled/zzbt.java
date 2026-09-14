package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "MultiScaleDecodingOptionsParcelCreator")
public final class zzbt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbt> CREATOR = new zzbu();
    private final float[] zza;
    private final int zzb;
    private final boolean zzc;

    @SafeParcelable.Constructor
    public zzbt(@SafeParcelable.Param(m1452id = 1) float[] fArr, @SafeParcelable.Param(m1452id = 2) int i, @SafeParcelable.Param(m1452id = 3) boolean z) {
        this.zza = fArr;
        this.zzb = i;
        this.zzc = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        float[] fArr = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloatArray(parcel, 1, fArr, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final float[] zzc() {
        return this.zza;
    }
}
