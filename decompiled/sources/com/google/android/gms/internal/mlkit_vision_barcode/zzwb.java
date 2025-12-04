package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes3.dex */
final class zzwb extends zzwg {
    private String zza;
    private boolean zzb;
    private int zzc;
    private byte zzd;

    zzwb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwg
    public final zzwg zza(boolean z) {
        this.zzb = true;
        this.zzd = (byte) (1 | this.zzd);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwg
    public final zzwg zzb(int i) {
        this.zzc = 1;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzwg zzc(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzwg
    public final zzwh zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzwd(str, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" libraryName");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
