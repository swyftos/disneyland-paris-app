package com.reactnativecommunity.netinfo.types;

import android.net.NetworkInfo;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public enum CellularGeneration {
    CG_2G("2g"),
    CG_3G("3g"),
    CG_4G("4g"),
    CG_5G("5g");

    public final String label;

    CellularGeneration(String str) {
        this.label = str;
    }

    @Nullable
    public static CellularGeneration fromNetworkInfo(@Nullable NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return null;
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == 20) {
            return CG_5G;
        }
        switch (subtype) {
        }
        return null;
    }
}
