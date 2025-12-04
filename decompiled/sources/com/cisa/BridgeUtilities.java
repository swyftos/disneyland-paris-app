package com.cisa;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;

/* loaded from: classes2.dex */
abstract class BridgeUtilities {
    public static String[] toLockIdsArray(ReadableArray readableArray) {
        String[] strArr = new String[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            if (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()] == 1) {
                strArr[i] = readableArray.getString(i);
            }
        }
        return strArr;
    }

    /* renamed from: com.cisa.BridgeUtilities$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
