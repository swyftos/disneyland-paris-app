package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes4.dex */
public interface zzem extends IInterface {
    List<zzkq> zza(zzn zznVar, boolean z) throws RemoteException;

    List<zzw> zza(String str, String str2, zzn zznVar) throws RemoteException;

    List<zzw> zza(String str, String str2, String str3) throws RemoteException;

    List<zzkq> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzkq> zza(String str, String str2, boolean z, zzn zznVar) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzn zznVar) throws RemoteException;

    void zza(zzao zzaoVar, zzn zznVar) throws RemoteException;

    void zza(zzao zzaoVar, String str, String str2) throws RemoteException;

    void zza(zzkq zzkqVar, zzn zznVar) throws RemoteException;

    void zza(zzn zznVar) throws RemoteException;

    void zza(zzw zzwVar) throws RemoteException;

    void zza(zzw zzwVar, zzn zznVar) throws RemoteException;

    byte[] zza(zzao zzaoVar, String str) throws RemoteException;

    void zzb(zzn zznVar) throws RemoteException;

    String zzc(zzn zznVar) throws RemoteException;

    void zzd(zzn zznVar) throws RemoteException;
}
