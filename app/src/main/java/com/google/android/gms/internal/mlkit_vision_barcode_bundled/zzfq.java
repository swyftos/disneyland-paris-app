package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzfq implements zzge {
    private final zzfm zza;
    private final zzgs zzb;
    private final boolean zzc;
    private final zzdt zzd;

    private zzfq(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        this.zzb = zzgsVar;
        this.zzc = zzfmVar instanceof zzed;
        this.zzd = zzdtVar;
        this.zza = zzfmVar;
    }

    static zzfq zzc(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        return new zzfq(zzgsVar, zzdtVar, zzfmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int iZzb = ((zzeh) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzed) obj).zzb.zzb() : iZzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int iHashCode = ((zzeh) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzed) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        zzfm zzfmVar = this.zza;
        return zzfmVar instanceof zzeh ? ((zzeh) zzfmVar).zzK() : zzfmVar.zzZ().zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzgg.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgg.zzo(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b5 A[EDGE_INSN: B:57:0x00b5->B:33:0x00b5 BREAK  A[LOOP:1: B:18:0x0062->B:60:0x0062], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcuVar) throws zzer {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVarZzf = zzehVar.zzc;
        if (zzgtVarZzf == zzgt.zzc()) {
            zzgtVarZzf = zzgt.zzf();
            zzehVar.zzc = zzgtVarZzf;
        }
        zzdx zzdxVarZzc = ((zzed) obj).zzc();
        zzef zzefVarZzb = null;
        while (i < i2) {
            int iZzj = zzcv.zzj(bArr, i, zzcuVar);
            int i3 = zzcuVar.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzdf zzdfVar = null;
                while (iZzj < i2) {
                    iZzj = zzcv.zzj(bArr, iZzj, zzcuVar);
                    int i5 = zzcuVar.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 == 2) {
                        if (i7 != 0) {
                            if (i5 != 12) {
                                break;
                                break;
                            }
                            iZzj = zzcv.zzp(i5, bArr, iZzj, i2, zzcuVar);
                        } else {
                            iZzj = zzcv.zzj(bArr, iZzj, zzcuVar);
                            i4 = zzcuVar.zza;
                            zzefVarZzb = zzcuVar.zzd.zzb(this.zza, i4);
                        }
                    } else {
                        if (i6 == 3) {
                            if (zzefVarZzb != null) {
                                iZzj = zzcv.zze(zzfu.zza().zzb(zzefVarZzb.zza.getClass()), bArr, iZzj, i2, zzcuVar);
                                zzdxVarZzc.zzi(zzefVarZzb.zzb, zzcuVar.zzc);
                            } else if (i7 == 2) {
                                iZzj = zzcv.zza(bArr, iZzj, zzcuVar);
                                zzdfVar = (zzdf) zzcuVar.zzc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        } else {
                            iZzj = zzcv.zzp(i5, bArr, iZzj, i2, zzcuVar);
                        }
                    }
                }
                if (zzdfVar != null) {
                    zzgtVarZzf.zzj((i4 << 3) | 2, zzdfVar);
                }
                i = iZzj;
            } else if ((i3 & 7) == 2) {
                zzef zzefVarZzb2 = zzcuVar.zzd.zzb(this.zza, i3 >>> 3);
                if (zzefVarZzb2 != null) {
                    i = zzcv.zze(zzfu.zza().zzb(zzefVarZzb2.zza.getClass()), bArr, iZzj, i2, zzcuVar);
                    zzdxVarZzc.zzi(zzefVarZzb2.zzb, zzcuVar.zzc);
                } else {
                    i = zzcv.zzi(i3, bArr, iZzj, i2, zzgtVarZzf, zzcuVar);
                }
                zzefVarZzb = zzefVarZzb2;
            } else {
                i = zzcv.zzp(i3, bArr, iZzj, i2, zzcuVar);
            }
        }
        if (i != i2) {
            throw new zzer("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzhh zzhhVar) {
        Iterator itZzf = ((zzed) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzdw zzdwVar = (zzdw) entry.getKey();
            if (zzdwVar.zze() != zzhg.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdwVar.zzg();
            zzdwVar.zzf();
            if (entry instanceof zzeu) {
                zzhhVar.zzw(zzdwVar.zza(), ((zzeu) entry).zza().zzb());
            } else {
                zzhhVar.zzw(zzdwVar.zza(), entry.getValue());
            }
        }
        ((zzeh) obj).zzc.zzk(zzhhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        return ((zzed) obj).zzb.zzk();
    }
}
