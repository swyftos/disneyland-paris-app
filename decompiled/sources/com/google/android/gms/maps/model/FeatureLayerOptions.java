package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzbo;

@SafeParcelable.Class(creator = "FeatureLayerOptionsCreator")
/* loaded from: classes4.dex */
public final class FeatureLayerOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<FeatureLayerOptions> CREATOR = new zzg();
    private static final zzbo zza = zzbo.zzi(FeatureType.ADMINISTRATIVE_AREA_LEVEL_1, FeatureType.ADMINISTRATIVE_AREA_LEVEL_2, FeatureType.COUNTRY, FeatureType.LOCALITY, FeatureType.POSTAL_CODE, FeatureType.SCHOOL_DISTRICT, FeatureType.DATASET);
    private final String zzb;
    private final String zzc;

    public static final class Builder {
        private String zza;
        private String zzb;

        @NonNull
        public FeatureLayerOptions build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException("FeatureType must be specified.");
            }
            if (str.equals(FeatureType.DATASET) && this.zzb == null) {
                throw new IllegalArgumentException("A datasetId must be specified for DATASET feature layers.");
            }
            return new FeatureLayerOptions(this, (zzf) null);
        }

        @NonNull
        public Builder datasetId(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder featureType(@NonNull @FeatureType String str) {
            Preconditions.checkArgument(FeatureLayerOptions.zza.contains(str), "Invalid FeatureType value");
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ FeatureLayerOptions(Builder builder, zzf zzfVar) {
        this.zzb = builder.zza;
        this.zzc = builder.zzb;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public String getDatasetId() {
        return this.zzc;
    }

    @NonNull
    @FeatureType
    public String getFeatureType() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getFeatureType(), false);
        SafeParcelWriter.writeString(parcel, 2, getDatasetId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    FeatureLayerOptions(String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
    }
}
