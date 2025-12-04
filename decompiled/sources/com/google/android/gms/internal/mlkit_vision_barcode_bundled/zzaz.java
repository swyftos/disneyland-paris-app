package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes3.dex */
public final class zzaz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        byte[] bArrCreateByteArray = null;
        Point[] pointArr = null;
        zzar zzarVar = null;
        zzau zzauVar = null;
        zzav zzavVar = null;
        zzax zzaxVar = null;
        zzaw zzawVar = null;
        zzas zzasVar = null;
        zzao zzaoVar = null;
        zzap zzapVar = null;
        zzaq zzaqVar = null;
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
                    zzarVar = (zzar) SafeParcelReader.createParcelable(parcel, header, zzar.CREATOR);
                    break;
                case 8:
                    zzauVar = (zzau) SafeParcelReader.createParcelable(parcel, header, zzau.CREATOR);
                    break;
                case 9:
                    zzavVar = (zzav) SafeParcelReader.createParcelable(parcel, header, zzav.CREATOR);
                    break;
                case 10:
                    zzaxVar = (zzax) SafeParcelReader.createParcelable(parcel, header, zzax.CREATOR);
                    break;
                case 11:
                    zzawVar = (zzaw) SafeParcelReader.createParcelable(parcel, header, zzaw.CREATOR);
                    break;
                case 12:
                    zzasVar = (zzas) SafeParcelReader.createParcelable(parcel, header, zzas.CREATOR);
                    break;
                case 13:
                    zzaoVar = (zzao) SafeParcelReader.createParcelable(parcel, header, zzao.CREATOR);
                    break;
                case 14:
                    zzapVar = (zzap) SafeParcelReader.createParcelable(parcel, header, zzap.CREATOR);
                    break;
                case 15:
                    zzaqVar = (zzaq) SafeParcelReader.createParcelable(parcel, header, zzaq.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzay(i, strCreateString, strCreateString2, bArrCreateByteArray, pointArr, i2, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzay[i];
    }
}
