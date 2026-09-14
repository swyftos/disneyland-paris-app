package com.google.android.gms.maps;

import android.location.Location;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface LocationSource {

    public interface OnLocationChangedListener {
        void onLocationChanged(@NonNull Location location);
    }

    void activate(@NonNull OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
