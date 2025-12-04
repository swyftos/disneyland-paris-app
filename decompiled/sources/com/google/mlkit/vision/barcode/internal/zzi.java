package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxa;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;

/* loaded from: classes4.dex */
public final class zzi extends LazyInstanceMap {
    private final MlKitContext zza;

    public zzi(MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        BarcodeScannerOptions barcodeScannerOptions = (BarcodeScannerOptions) obj;
        Context applicationContext = this.zza.getApplicationContext();
        zzwp zzwpVarZzb = zzxa.zzb(zzb.zzd());
        return new zzl(this.zza, barcodeScannerOptions, (zzo.zzd(applicationContext) || GoogleApiAvailabilityLight.getInstance().getApkVersion(applicationContext) >= 204500000) ? new zzo(applicationContext, barcodeScannerOptions, zzwpVarZzb) : new zzq(applicationContext, barcodeScannerOptions, zzwpVarZzb), zzwpVarZzb);
    }
}
