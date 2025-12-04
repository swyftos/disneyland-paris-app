package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class zzyc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        byte[] bArrCreateByteArray = null;
        Point[] pointArr = null;
        zzxu zzxuVar = null;
        zzxx zzxxVar = null;
        zzxy zzxyVar = null;
        zzya zzyaVar = null;
        zzxz zzxzVar = null;
        zzxv zzxvVar = null;
        zzxr zzxrVar = null;
        zzxs zzxsVar = null;
        zzxt zzxtVar = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 5:
                    pointArr = (Point[]) SafeParcelReader.createTypedArray(parcel, header, Point.CREATOR);
                    break;
                case 6:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    zzxuVar = (zzxu) SafeParcelReader.createParcelable(parcel, header, zzxu.CREATOR);
                    break;
                case 8:
                    zzxxVar = (zzxx) SafeParcelReader.createParcelable(parcel, header, zzxx.CREATOR);
                    break;
                case 9:
                    zzxyVar = (zzxy) SafeParcelReader.createParcelable(parcel, header, zzxy.CREATOR);
                    break;
                case 10:
                    zzyaVar = (zzya) SafeParcelReader.createParcelable(parcel, header, zzya.CREATOR);
                    break;
                case 11:
                    zzxzVar = (zzxz) SafeParcelReader.createParcelable(parcel, header, zzxz.CREATOR);
                    break;
                case 12:
                    zzxvVar = (zzxv) SafeParcelReader.createParcelable(parcel, header, zzxv.CREATOR);
                    break;
                case 13:
                    zzxrVar = (zzxr) SafeParcelReader.createParcelable(parcel, header, zzxr.CREATOR);
                    break;
                case 14:
                    zzxsVar = (zzxs) SafeParcelReader.createParcelable(parcel, header, zzxs.CREATOR);
                    break;
                case 15:
                    zzxtVar = (zzxt) SafeParcelReader.createParcelable(parcel, header, zzxt.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzyb(i, strCreateString, strCreateString2, bArrCreateByteArray, pointArr, i2, zzxuVar, zzxxVar, zzxyVar, zzyaVar, zzxzVar, zzxvVar, zzxrVar, zzxsVar, zzxtVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzyb[i];
    }
}
