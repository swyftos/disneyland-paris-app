package com.google.android.gms.internal.mlkit_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: loaded from: classes3.dex */
public final class zzst {
    private static final GmsLogger zza = new GmsLogger("RemoteModelUtils", "");

    @WorkerThread
    public static zznc zza(RemoteModel remoteModel, SharedPrefManager sharedPrefManager, zzsj zzsjVar) {
        zzne zzneVar;
        ModelType modelTypeZzb = zzsjVar.zzb();
        String modelHash = remoteModel.getModelHash();
        zzni zzniVar = new zzni();
        zznd zzndVar = new zznd();
        zzndVar.zzc(remoteModel.getModelNameForBackend());
        zzndVar.zzd(zznf.CLOUD);
        zzndVar.zza(zzu.zzb(modelHash));
        int iOrdinal = modelTypeZzb.ordinal();
        if (iOrdinal == 2) {
            zzneVar = zzne.BASE_TRANSLATE;
        } else if (iOrdinal != 4) {
            zzneVar = iOrdinal != 5 ? zzne.TYPE_UNKNOWN : zzne.BASE_DIGITAL_INK;
        } else {
            zzneVar = zzne.CUSTOM;
        }
        zzndVar.zzb(zzneVar);
        zzniVar.zzb(zzndVar.zzg());
        zznl zznlVarZzc = zzniVar.zzc();
        zzmz zzmzVar = new zzmz();
        zzmzVar.zzd(zzsjVar.zzc());
        zzmzVar.zzc(zzsjVar.zzd());
        zzmzVar.zzb(Long.valueOf(zzsjVar.zza()));
        zzmzVar.zzf(zznlVarZzc);
        if (zzsjVar.zzg()) {
            long modelDownloadBeginTimeMs = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs == 0) {
                zza.m1449w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = sharedPrefManager.getModelFirstUseTimeMs(remoteModel);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    sharedPrefManager.setModelFirstUseTimeMs(remoteModel, modelFirstUseTimeMs);
                }
                zzmzVar.zzg(Long.valueOf(modelFirstUseTimeMs - modelDownloadBeginTimeMs));
            }
        }
        if (zzsjVar.zzf()) {
            long modelDownloadBeginTimeMs2 = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs2 == 0) {
                zza.m1449w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                zzmzVar.zze(Long.valueOf(SystemClock.elapsedRealtime() - modelDownloadBeginTimeMs2));
            }
        }
        return zzmzVar.zzi();
    }
}
