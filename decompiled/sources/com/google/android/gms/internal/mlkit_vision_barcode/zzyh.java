package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class zzyh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzxw zzxwVar = null;
        String strCreateString = null;
        String strCreateString2 = null;
        zzxx[] zzxxVarArr = null;
        zzxu[] zzxuVarArr = null;
        String[] strArrCreateStringArray = null;
        zzxp[] zzxpVarArr = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    zzxwVar = (zzxw) SafeParcelReader.createParcelable(parcel, header, zzxw.CREATOR);
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    zzxxVarArr = (zzxx[]) SafeParcelReader.createTypedArray(parcel, header, zzxx.CREATOR);
                    break;
                case 5:
                    zzxuVarArr = (zzxu[]) SafeParcelReader.createTypedArray(parcel, header, zzxu.CREATOR);
                    break;
                case 6:
                    strArrCreateStringArray = SafeParcelReader.createStringArray(parcel, header);
                    break;
                case 7:
                    zzxpVarArr = (zzxp[]) SafeParcelReader.createTypedArray(parcel, header, zzxp.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzxs(zzxwVar, strCreateString, strCreateString2, zzxxVarArr, zzxuVarArr, strArrCreateStringArray, zzxpVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzxs[i];
    }
}
