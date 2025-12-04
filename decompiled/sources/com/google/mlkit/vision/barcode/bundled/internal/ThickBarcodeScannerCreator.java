package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbp;

@KeepForSdk
@DynamiteApi
/* loaded from: classes4.dex */
public class ThickBarcodeScannerCreator extends zzbp {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbq
    public zzbn newBarcodeScanner(IObjectWrapper iObjectWrapper, zzba zzbaVar) {
        return new zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbaVar);
    }
}
