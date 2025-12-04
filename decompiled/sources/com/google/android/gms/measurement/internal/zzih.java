package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzlm;
import com.google.android.gms.internal.measurement.zzlr;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class zzih extends zzkg {
    public zzih(zzkj zzkjVar) {
        super(zzkjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkg
    protected final boolean zze() {
        return false;
    }

    public final byte[] zza(zzao zzaoVar, String str) {
        zzks zzksVar;
        Bundle bundleZzb;
        zzcb.zzg.zza zzaVar;
        zzf zzfVar;
        zzcb.zzf.zza zzaVar2;
        Bundle bundle;
        byte[] bArr;
        long j;
        zzak zzakVarZza;
        zzd();
        this.zzy.zzae();
        Preconditions.checkNotNull(zzaoVar);
        Preconditions.checkNotEmpty(str);
        if (!zzt().zze(str, zzaq.zzax)) {
            zzr().zzw().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzaoVar.zza) && !"_iapx".equals(zzaoVar.zza)) {
            zzr().zzw().zza("Generating a payload for this event is not available. package_name, event_name", str, zzaoVar.zza);
            return null;
        }
        zzcb.zzf.zza zzaVarZzb = zzcb.zzf.zzb();
        zzi().zzf();
        try {
            zzf zzfVarZzb = zzi().zzb(str);
            if (zzfVarZzb == null) {
                zzr().zzw().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzfVarZzb.zzr()) {
                zzr().zzw().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzcb.zzg.zza zzaVarZza = zzcb.zzg.zzbf().zza(1).zza("android");
            if (!TextUtils.isEmpty(zzfVarZzb.zzc())) {
                zzaVarZza.zzf(zzfVarZzb.zzc());
            }
            if (!TextUtils.isEmpty(zzfVarZzb.zzn())) {
                zzaVarZza.zze(zzfVarZzb.zzn());
            }
            if (!TextUtils.isEmpty(zzfVarZzb.zzl())) {
                zzaVarZza.zzg(zzfVarZzb.zzl());
            }
            if (zzfVarZzb.zzm() != -2147483648L) {
                zzaVarZza.zzh((int) zzfVarZzb.zzm());
            }
            zzaVarZza.zzf(zzfVarZzb.zzo()).zzk(zzfVarZzb.zzq());
            if (zzlm.zzb() && zzt().zze(zzfVarZzb.zzc(), zzaq.zzbn)) {
                if (!TextUtils.isEmpty(zzfVarZzb.zze())) {
                    zzaVarZza.zzk(zzfVarZzb.zze());
                } else if (!TextUtils.isEmpty(zzfVarZzb.zzg())) {
                    zzaVarZza.zzp(zzfVarZzb.zzg());
                } else if (!TextUtils.isEmpty(zzfVarZzb.zzf())) {
                    zzaVarZza.zzo(zzfVarZzb.zzf());
                }
            } else if (!TextUtils.isEmpty(zzfVarZzb.zze())) {
                zzaVarZza.zzk(zzfVarZzb.zze());
            } else if (!TextUtils.isEmpty(zzfVarZzb.zzf())) {
                zzaVarZza.zzo(zzfVarZzb.zzf());
            }
            zzaVarZza.zzh(zzfVarZzb.zzp());
            if (this.zzy.zzab() && zzt().zzg(zzaVarZza.zzj())) {
                zzaVarZza.zzj();
                if (!TextUtils.isEmpty(null)) {
                    zzaVarZza.zzn(null);
                }
            }
            Pair pairZza = zzs().zza(zzfVarZzb.zzc());
            if (zzfVarZzb.zzaf() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                zzaVarZza.zzh(zza((String) pairZza.first, Long.toString(zzaoVar.zzd)));
                Object obj = pairZza.second;
                if (obj != null) {
                    zzaVarZza.zza(((Boolean) obj).booleanValue());
                }
            }
            zzl().zzaa();
            zzcb.zzg.zza zzaVarZzc = zzaVarZza.zzc(Build.MODEL);
            zzl().zzaa();
            zzaVarZzc.zzb(Build.VERSION.RELEASE).zzf((int) zzl().zzf()).zzd(zzl().zzg());
            zzaVarZza.zzi(zza(zzfVarZzb.zzd(), Long.toString(zzaoVar.zzd)));
            if (!TextUtils.isEmpty(zzfVarZzb.zzi())) {
                zzaVarZza.zzl(zzfVarZzb.zzi());
            }
            String strZzc = zzfVarZzb.zzc();
            List listZza = zzi().zza(strZzc);
            Iterator it = listZza.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzksVar = null;
                    break;
                }
                zzksVar = (zzks) it.next();
                if ("_lte".equals(zzksVar.zzc)) {
                    break;
                }
            }
            if (zzksVar == null || zzksVar.zze == null) {
                zzks zzksVar2 = new zzks(strZzc, "auto", "_lte", zzm().currentTimeMillis(), 0L);
                listZza.add(zzksVar2);
                zzi().zza(zzksVar2);
            }
            zzkn zzknVarZzg = zzg();
            zzknVarZzg.zzr().zzx().zza("Checking account type status for ad personalization signals");
            if (zzknVarZzg.zzl().zzj()) {
                String strZzc2 = zzfVarZzb.zzc();
                if (zzfVarZzb.zzaf() && zzknVarZzg.zzj().zze(strZzc2)) {
                    zzknVarZzg.zzr().zzw().zza("Turning off ad personalization due to account type");
                    Iterator it2 = listZza.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if ("_npa".equals(((zzks) it2.next()).zzc)) {
                            it2.remove();
                            break;
                        }
                    }
                    listZza.add(new zzks(strZzc2, "auto", "_npa", zzknVarZzg.zzm().currentTimeMillis(), 1L));
                }
            }
            zzcb.zzk[] zzkVarArr = new zzcb.zzk[listZza.size()];
            for (int i = 0; i < listZza.size(); i++) {
                zzcb.zzk.zza zzaVarZza2 = zzcb.zzk.zzj().zza(((zzks) listZza.get(i)).zzc).zza(((zzks) listZza.get(i)).zzd);
                zzg().zza(zzaVarZza2, ((zzks) listZza.get(i)).zze);
                zzkVarArr[i] = (zzcb.zzk) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZza2.zzv());
            }
            zzaVarZza.zzb(Arrays.asList(zzkVarArr));
            if (zzlr.zzb() && zzt().zza(zzaq.zzcn) && zzt().zza(zzaq.zzco)) {
                zzey zzeyVarZza = zzey.zza(zzaoVar);
                zzp().zza(zzeyVarZza.zzb, zzi().zzi(str));
                zzp().zza(zzeyVarZza, zzt().zza(str));
                bundleZzb = zzeyVarZza.zzb;
            } else {
                bundleZzb = zzaoVar.zzb.zzb();
            }
            Bundle bundle2 = bundleZzb;
            bundle2.putLong("_c", 1L);
            zzr().zzw().zza("Marking in-app purchase as real-time");
            bundle2.putLong("_r", 1L);
            bundle2.putString("_o", zzaoVar.zzc);
            if (zzp().zzf(zzaVarZza.zzj())) {
                zzp().zza(bundle2, "_dbg", (Object) 1L);
                zzp().zza(bundle2, "_r", (Object) 1L);
            }
            zzak zzakVarZza2 = zzi().zza(str, zzaoVar.zza);
            if (zzakVarZza2 == null) {
                zzfVar = zzfVarZzb;
                zzaVar = zzaVarZza;
                zzaVar2 = zzaVarZzb;
                bundle = bundle2;
                bArr = null;
                zzakVarZza = new zzak(str, zzaoVar.zza, 0L, 0L, zzaoVar.zzd, 0L, null, null, null, null);
                j = 0;
            } else {
                zzaVar = zzaVarZza;
                zzfVar = zzfVarZzb;
                zzaVar2 = zzaVarZzb;
                bundle = bundle2;
                bArr = null;
                j = zzakVarZza2.zzf;
                zzakVarZza = zzakVarZza2.zza(zzaoVar.zzd);
            }
            zzi().zza(zzakVarZza);
            zzal zzalVar = new zzal(this.zzy, zzaoVar.zzc, str, zzaoVar.zza, zzaoVar.zzd, j, bundle);
            zzcb.zzc.zza zzaVarZzb2 = zzcb.zzc.zzj().zza(zzalVar.zzc).zza(zzalVar.zzb).zzb(zzalVar.zzd);
            Iterator<String> it3 = zzalVar.zze.iterator();
            while (it3.hasNext()) {
                String next = it3.next();
                zzcb.zze.zza zzaVarZza3 = zzcb.zze.zzm().zza(next);
                zzg().zza(zzaVarZza3, zzalVar.zze.zza(next));
                zzaVarZzb2.zza(zzaVarZza3);
            }
            zzcb.zzg.zza zzaVar3 = zzaVar;
            zzaVar3.zza(zzaVarZzb2).zza(zzcb.zzh.zza().zza(zzcb.zzd.zza().zza(zzakVarZza.zzc).zza(zzaoVar.zza)));
            zzaVar3.zzc(e_().zza(zzfVar.zzc(), Collections.emptyList(), zzaVar3.zzd(), Long.valueOf(zzaVarZzb2.zzf()), Long.valueOf(zzaVarZzb2.zzf())));
            if (zzaVarZzb2.zze()) {
                zzaVar3.zzb(zzaVarZzb2.zzf()).zzc(zzaVarZzb2.zzf());
            }
            long jZzk = zzfVar.zzk();
            if (jZzk != 0) {
                zzaVar3.zze(jZzk);
            }
            long jZzj = zzfVar.zzj();
            if (jZzj != 0) {
                zzaVar3.zzd(jZzj);
            } else if (jZzk != 0) {
                zzaVar3.zzd(jZzk);
            }
            zzfVar.zzv();
            zzaVar3.zzg((int) zzfVar.zzs()).zzg(zzt().zzf()).zza(zzm().currentTimeMillis()).zzb(true);
            zzcb.zzf.zza zzaVar4 = zzaVar2;
            zzaVar4.zza(zzaVar3);
            zzf zzfVar2 = zzfVar;
            zzfVar2.zza(zzaVar3.zzf());
            zzfVar2.zzb(zzaVar3.zzg());
            zzi().zza(zzfVar2);
            zzi().b_();
            try {
                return zzg().zzc(((zzcb.zzf) ((com.google.android.gms.internal.measurement.zzfo) zzaVar4.zzv())).zzbi());
            } catch (IOException e) {
                zzr().zzf().zza("Data loss. Failed to bundle and serialize. appId", zzeu.zza(str), e);
                return bArr;
            }
        } catch (SecurityException e2) {
            zzr().zzw().zza("app instance id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzr().zzw().zza("Resettable device id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzi().zzh();
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
