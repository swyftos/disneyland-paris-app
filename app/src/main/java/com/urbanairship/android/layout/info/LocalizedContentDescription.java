package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.ActionConst;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "fallback", "", "getFallback", "()Ljava/lang/String;", ActionConst.REF_ATTRIBUTE, "getRef", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LocalizedContentDescription\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n79#2,16:945\n44#2,15:961\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LocalizedContentDescription\n*L\n742#1:945,16\n743#1:961,15\n*E\n"})
public final class LocalizedContentDescription {
    private final String fallback;
    private final String ref;

    /* JADX WARN: Code duplicated, block: B:100:0x027e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0283  */
    /* JADX WARN: Code duplicated, block: B:105:0x0289  */
    /* JADX WARN: Code duplicated, block: B:107:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x0154  */
    /* JADX WARN: Code duplicated, block: B:49:0x0164  */
    /* JADX WARN: Code duplicated, block: B:52:0x016c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0172  */
    /* JADX WARN: Code duplicated, block: B:56:0x017c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0184  */
    /* JADX WARN: Code duplicated, block: B:61:0x018a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0196  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01af  */
    /* JADX WARN: Code duplicated, block: B:67:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:73:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:76:0x020c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0216  */
    /* JADX WARN: Code duplicated, block: B:79:0x0222  */
    /* JADX WARN: Code duplicated, block: B:81:0x022d  */
    /* JADX WARN: Code duplicated, block: B:82:0x023c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0246  */
    /* JADX WARN: Code duplicated, block: B:86:0x024c  */
    /* JADX WARN: Code duplicated, block: B:87:0x024f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0255  */
    /* JADX WARN: Code duplicated, block: B:91:0x025f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0265  */
    /* JADX WARN: Code duplicated, block: B:94:0x0268  */
    /* JADX WARN: Code duplicated, block: B:96:0x026e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0278  */
    /* JADX WARN: Instruction removed from duplicated block: B:105:0x0289, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:107:0x02ad, please report this as an issue */
    public LocalizedContentDescription(@NotNull JsonMap json) throws JsonException {
        Class cls;
        String strOptString;
        JsonValue jsonValue;
        KClass orCreateKotlinClass;
        Object jsonValue2;
        String strOptString2;
        Object objOptMap;
        Object objOptList;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue3 = json.get(ActionConst.REF_ATTRIBUTE);
        if (jsonValue3 == null) {
            strOptString = null;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) && !Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    cls = ULong.class;
                    strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
                } else {
                    cls = ULong.class;
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                        strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        strOptString = (String) jsonValue3.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        strOptString = (String) jsonValue3.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + ActionConst.REF_ATTRIBUTE + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        strOptString = (String) jsonValue3.toJsonValue();
                    }
                }
                this.ref = strOptString;
                jsonValue = json.get("fallback");
                if (jsonValue != null) {
                    throw new JsonException("Missing required field: 'fallback" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString2 = jsonValue.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                    strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList = jsonValue.optList();
                    if (objOptList != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap = jsonValue.optMap();
                    if (objOptMap != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptMap;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'fallback" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue2 = jsonValue.toJsonValue();
                    if (jsonValue2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) jsonValue2;
                }
                this.fallback = strOptString2;
            }
            strOptString = jsonValue3.optString();
        }
        cls = ULong.class;
        this.ref = strOptString;
        jsonValue = json.get("fallback");
        if (jsonValue != null) {
            throw new JsonException("Missing required field: 'fallback" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString2 = jsonValue.optString();
            if (strOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString2 = jsonValue.optString();
            if (strOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
            strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            objOptList = jsonValue.optList();
            if (objOptList != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString2 = (String) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            objOptMap = jsonValue.optMap();
            if (objOptMap != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString2 = (String) objOptMap;
        } else {
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'fallback" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue2 = jsonValue.toJsonValue();
            if (jsonValue2 != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString2 = (String) jsonValue2;
        }
        this.fallback = strOptString2;
    }

    @Nullable
    public final String getRef() {
        return this.ref;
    }

    @NotNull
    public final String getFallback() {
        return this.fallback;
    }
}
