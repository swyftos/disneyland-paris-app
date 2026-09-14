package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: loaded from: classes3.dex */
public final class MapsInitializer {
    private static final String zza = "MapsInitializer";
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    public enum Renderer {
        LEGACY,
        LATEST
    }

    public static synchronized int initialize(@NonNull Context context) {
        return initialize(context, null, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0046  */
    public static synchronized int initialize(@NonNull Context context, @Nullable Renderer renderer, @Nullable OnMapsSdkInitializedCallback onMapsSdkInitializedCallback) {
        Preconditions.checkNotNull(context, "Context is null");
        Log.d(zza, "preferredRenderer: ".concat(String.valueOf(renderer)));
        if (!zzb) {
            try {
                com.google.android.gms.maps.internal.zzf zzfVarZza = zzcc.zza(context, renderer);
                try {
                    CameraUpdateFactory.zza(zzfVarZza.zze());
                    BitmapDescriptorFactory.zza(zzfVarZza.zzj());
                    int i = 1;
                    zzb = true;
                    if (renderer == null) {
                        i = 0;
                    } else {
                        int iOrdinal = renderer.ordinal();
                        if (iOrdinal != 0) {
                            if (iOrdinal != 1) {
                                i = 0;
                            } else {
                                i = 2;
                            }
                        }
                    }
                    try {
                        if (zzfVarZza.zzd() == 2) {
                            zzc = Renderer.LATEST;
                        }
                        zzfVarZza.zzl(ObjectWrapper.wrap(context), i);
                    } catch (RemoteException e) {
                        Log.e(zza, "Failed to retrieve renderer type or log initialization.", e);
                    }
                    Log.d(zza, "loadedRenderer: ".concat(String.valueOf(zzc)));
                    if (onMapsSdkInitializedCallback != null) {
                        onMapsSdkInitializedCallback.onMapsSdkInitialized(zzc);
                    }
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            } catch (GooglePlayServicesNotAvailableException e3) {
                return e3.errorCode;
            }
        } else if (onMapsSdkInitializedCallback != null) {
            onMapsSdkInitializedCallback.onMapsSdkInitialized(zzc);
        }
        return 0;
    }
}
