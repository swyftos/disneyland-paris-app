package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
public final class zzgd extends zzep {
    private final zzkj zza;
    private Boolean zzb;
    private String zzc;

    public zzgd(zzkj zzkjVar) {
        this(zzkjVar, null);
    }

    private zzgd(zzkj zzkjVar, String str) {
        Preconditions.checkNotNull(zzkjVar);
        this.zza = zzkjVar;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zzb(zzn zznVar) throws IllegalStateException {
        zzb(zznVar, false);
        zza(new zzgf(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(zzao zzaoVar, zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzaoVar);
        zzb(zznVar, false);
        zza(new zzgk(this, zzaoVar, zznVar));
    }

    final zzao zzb(zzao zzaoVar, zzn zznVar) {
        zzan zzanVar;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaoVar.zza) && (zzanVar = zzaoVar.zzb) != null && zzanVar.zza() != 0) {
            String strZzd = zzaoVar.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(strZzd) && (("referrer broadcast".equals(strZzd) || "referrer API".equals(strZzd)) && this.zza.zzb().zze(zznVar.zza, zzaq.zzar))) {
                this.zza.zzr().zzv().zza("Event has been filtered ", zzaoVar.toString());
                return new zzao("_cmpx", zzaoVar.zzb, zzaoVar.zzc, zzaoVar.zzd);
            }
        }
        return zzaoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(zzao zzaoVar, String str, String str2) throws IllegalStateException {
        Preconditions.checkNotNull(zzaoVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzgn(this, zzaoVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final byte[] zza(zzao zzaoVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaoVar);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzaoVar.zza));
        long jNanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzgm(this, zzaoVar, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzeu.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzaoVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzeu.zza(str), this.zza.zzi().zza(zzaoVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(zzkq zzkqVar, zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzkqVar);
        zzb(zznVar, false);
        zza(new zzgp(this, zzkqVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final List<zzkq> zza(zzn zznVar, boolean z) {
        zzb(zznVar, false);
        try {
            List<zzks> list = (List) this.zza.zzq().zza(new zzgo(this, zznVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzks zzksVar : list) {
                if (z || !zzkr.zze(zzksVar.zzc)) {
                    arrayList.add(new zzkq(zzksVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user properties. appId", zzeu.zza(zznVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(zzn zznVar) throws IllegalStateException {
        zzb(zznVar, false);
        zza(new zzgr(this, zznVar));
    }

    private final void zzb(zzn zznVar, boolean z) {
        Preconditions.checkNotNull(zznVar);
        zza(zznVar.zza, false);
        this.zza.zzj().zza(zznVar.zzb, zznVar.zzr, zznVar.zzv);
    }

    private final void zza(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzr().zzf().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    this.zzb = Boolean.valueOf("com.google.android.gms".equals(this.zzc) || UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid()));
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzeu.zza(str));
                throw e;
            }
        }
        if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
            this.zzc = str;
        }
        if (str.equals(this.zzc)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(long j, String str, String str2, String str3) throws IllegalStateException {
        zza(new zzgq(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(final Bundle bundle, final zzn zznVar) throws IllegalStateException {
        if (zzlr.zzb() && this.zza.zzb().zza(zzaq.zzcn)) {
            zzb(zznVar, false);
            zza(new Runnable(this, zznVar, bundle) { // from class: com.google.android.gms.measurement.internal.zzgc
                private final zzgd zza;
                private final zzn zzb;
                private final Bundle zzc;

                {
                    this.zza = this;
                    this.zzb = zznVar;
                    this.zzc = bundle;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc);
                }
            });
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final String zzc(zzn zznVar) {
        zzb(zznVar, false);
        return this.zza.zzd(zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(zzw zzwVar, zzn zznVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzwVar);
        Preconditions.checkNotNull(zzwVar.zzc);
        zzb(zznVar, false);
        zzw zzwVar2 = new zzw(zzwVar);
        zzwVar2.zza = zznVar.zza;
        zza(new zzgt(this, zzwVar2, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zza(zzw zzwVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzwVar);
        Preconditions.checkNotNull(zzwVar.zzc);
        zza(zzwVar.zza, true);
        zza(new zzge(this, new zzw(zzwVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final List<zzkq> zza(String str, String str2, boolean z, zzn zznVar) {
        zzb(zznVar, false);
        try {
            List<zzks> list = (List) this.zza.zzq().zza(new zzgh(this, zznVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzks zzksVar : list) {
                if (z || !zzkr.zze(zzksVar.zzc)) {
                    arrayList.add(new zzkq(zzksVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to query user properties. appId", zzeu.zza(zznVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final List<zzkq> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzks> list = (List) this.zza.zzq().zza(new zzgg(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzks zzksVar : list) {
                if (z || !zzkr.zze(zzksVar.zzc)) {
                    arrayList.add(new zzkq(zzksVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user properties as. appId", zzeu.zza(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final List<zzw> zza(String str, String str2, zzn zznVar) {
        zzb(zznVar, false);
        try {
            return (List) this.zza.zzq().zza(new zzgj(this, zznVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final List<zzw> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzgi(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzem
    @BinderThread
    public final void zzd(zzn zznVar) throws IllegalStateException {
        zza(zznVar.zza, false);
        zza(new zzgl(this, zznVar));
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }

    final /* synthetic */ void zza(zzn zznVar, Bundle bundle) {
        this.zza.zze().zza(zznVar.zza, bundle);
    }
}
