package com.reactlibrary.sqlcipher;

import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import org.picocontainer.Characteristics;

/* loaded from: classes4.dex */
public abstract class SqlcipherPluginConverter {

    /* renamed from: com.reactlibrary.sqlcipher.SqlcipherPluginConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Null.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static String getString(ReadableMap readableMap, String str, String str2) {
        if (readableMap == null) {
            return str2;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()];
            if (i == 1) {
                double d = readableMap.getDouble(str);
                long j = (long) d;
                if (d == j) {
                    return String.valueOf(j);
                }
                return String.valueOf(d);
            }
            if (i == 2) {
                return String.valueOf(readableMap.getBoolean(str));
            }
            if (i == 3) {
                return readableMap.getString(str);
            }
            if (i != 4) {
                return str2;
            }
            return null;
        } catch (NoSuchKeyException unused) {
            return str2;
        }
    }

    static boolean getBoolean(ReadableMap readableMap, String str, boolean z) {
        if (readableMap == null) {
            return z;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()];
            if (i == 1) {
                return readableMap.getDouble(str) != AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            if (i == 2) {
                return readableMap.getBoolean(str);
            }
            if (i != 3) {
                if (i != 4) {
                    return z;
                }
                return false;
            }
            String string = readableMap.getString(str);
            if (Characteristics.TRUE.equalsIgnoreCase(string)) {
                return true;
            }
            "false".equalsIgnoreCase(string);
            return false;
        } catch (NoSuchKeyException unused) {
            return z;
        }
    }

    static String getString(ReadableArray readableArray, int i, String str) {
        if (readableArray == null) {
            return str;
        }
        try {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                double d = readableArray.getDouble(i);
                long j = (long) d;
                if (d == j) {
                    return String.valueOf(j);
                }
                return String.valueOf(d);
            }
            if (i2 == 2) {
                return String.valueOf(readableArray.getBoolean(i));
            }
            if (i2 == 3) {
                return readableArray.getString(i);
            }
            if (i2 != 4) {
                return str;
            }
            return null;
        } catch (NoSuchKeyException unused) {
            return str;
        }
    }

    static Object get(ReadableMap readableMap, String str, Object obj) {
        if (readableMap == null) {
            return obj;
        }
        try {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()]) {
                case 1:
                    return Double.valueOf(readableMap.getDouble(str));
                case 2:
                    return Boolean.valueOf(readableMap.getBoolean(str));
                case 3:
                    return readableMap.getString(str);
                case 4:
                    return null;
                case 5:
                    return readableMap.getMap(str);
                case 6:
                    return readableMap.getArray(str);
                default:
                    return null;
            }
        } catch (NoSuchKeyException unused) {
            return obj;
        }
    }

    static Object get(ReadableArray readableArray, int i, Object obj) {
        if (readableArray == null) {
            return obj;
        }
        try {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                return Double.valueOf(readableArray.getDouble(i));
            }
            if (i2 == 2) {
                return Boolean.valueOf(readableArray.getBoolean(i));
            }
            if (i2 == 3) {
                return readableArray.getString(i);
            }
            if (i2 == 5) {
                return readableArray.getMap(i);
            }
            if (i2 != 6) {
                return null;
            }
            return readableArray.getArray(i);
        } catch (NoSuchKeyException unused) {
            return obj;
        }
    }
}
