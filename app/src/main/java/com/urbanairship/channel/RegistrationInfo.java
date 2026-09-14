package com.urbanairship.channel;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.actions.EnableFeatureAction;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
final class RegistrationInfo implements JsonSerializable {
    private static final Companion Companion = new Companion(null);
    private final long dateMillis;
    private final Long lastFullUploadMillis;
    private final String location;
    private final ChannelRegistrationPayload payload;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegistrationInfo)) {
            return false;
        }
        RegistrationInfo registrationInfo = (RegistrationInfo) obj;
        return this.dateMillis == registrationInfo.dateMillis && Intrinsics.areEqual(this.lastFullUploadMillis, registrationInfo.lastFullUploadMillis) && Intrinsics.areEqual(this.payload, registrationInfo.payload) && Intrinsics.areEqual(this.location, registrationInfo.location);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.dateMillis) * 31;
        Long l = this.lastFullUploadMillis;
        return ((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.payload.hashCode()) * 31) + this.location.hashCode();
    }

    public String toString() {
        return "RegistrationInfo(dateMillis=" + this.dateMillis + ", lastFullUploadMillis=" + this.lastFullUploadMillis + ", payload=" + this.payload + ", location=" + this.location + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x025d  */
    /* JADX WARN: Code duplicated, block: B:101:0x026d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0277  */
    /* JADX WARN: Code duplicated, block: B:105:0x027d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0281  */
    /* JADX WARN: Code duplicated, block: B:108:0x0287  */
    /* JADX WARN: Code duplicated, block: B:110:0x0291  */
    /* JADX WARN: Code duplicated, block: B:112:0x0297  */
    /* JADX WARN: Code duplicated, block: B:113:0x029b  */
    /* JADX WARN: Code duplicated, block: B:115:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:122:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:124:0x02df  */
    /* JADX WARN: Code duplicated, block: B:127:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:129:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:131:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:134:0x0300  */
    /* JADX WARN: Code duplicated, block: B:136:0x0306  */
    /* JADX WARN: Code duplicated, block: B:138:0x0312  */
    /* JADX WARN: Code duplicated, block: B:139:0x031e  */
    /* JADX WARN: Code duplicated, block: B:141:0x032a  */
    /* JADX WARN: Code duplicated, block: B:142:0x0337  */
    /* JADX WARN: Code duplicated, block: B:144:0x0344  */
    /* JADX WARN: Code duplicated, block: B:145:0x0353  */
    /* JADX WARN: Code duplicated, block: B:147:0x035f  */
    /* JADX WARN: Code duplicated, block: B:148:0x036d  */
    /* JADX WARN: Code duplicated, block: B:150:0x0379  */
    /* JADX WARN: Code duplicated, block: B:151:0x0386  */
    /* JADX WARN: Code duplicated, block: B:153:0x0390  */
    /* JADX WARN: Code duplicated, block: B:154:0x039d  */
    /* JADX WARN: Code duplicated, block: B:156:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:157:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:159:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:161:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:162:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:164:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:166:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:168:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:169:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:171:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:173:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:175:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:178:0x0408  */
    /* JADX WARN: Code duplicated, block: B:180:0x040e  */
    /* JADX WARN: Code duplicated, block: B:182:0x0432  */
    /* JADX WARN: Code duplicated, block: B:184:0x044c  */
    /* JADX WARN: Code duplicated, block: B:186:0x0452  */
    /* JADX WARN: Code duplicated, block: B:61:0x0167  */
    /* JADX WARN: Code duplicated, block: B:63:0x016c  */
    /* JADX WARN: Code duplicated, block: B:65:0x017d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0183  */
    /* JADX WARN: Code duplicated, block: B:68:0x0186  */
    /* JADX WARN: Code duplicated, block: B:70:0x018c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0196  */
    /* JADX WARN: Code duplicated, block: B:74:0x019c  */
    /* JADX WARN: Code duplicated, block: B:75:0x019f  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:80:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01de  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x020a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0216  */
    /* JADX WARN: Code duplicated, block: B:92:0x0223  */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Instruction removed from duplicated block: B:180:0x040e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:182:0x0432, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:186:0x0452, please report this as an issue */
    public RegistrationInfo(JsonMap json) throws JsonException {
        String str;
        Long lValueOf;
        long jLongValue;
        JsonValue jsonValue;
        KClass orCreateKotlinClass;
        Object jsonValue2;
        Long lValueOf2;
        Object objOptMap;
        Object objOptList;
        Object objOptString;
        Object objOptString2;
        Long l;
        ChannelRegistrationPayload channelRegistrationPayloadFromJson;
        JsonValue jsonValue3;
        KClass orCreateKotlinClass2;
        Object jsonValue4;
        String strOptString;
        Object objOptMap2;
        Object objOptList2;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue5 = json.get("date");
        if (jsonValue5 == null) {
            throw new JsonException("Missing required field: 'date" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue5);
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString3 = jsonValue5.optString();
            if (objOptString3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            lValueOf = (Long) objOptString3;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "null cannot be cast to non-null type kotlin.Long";
                    lValueOf = Long.valueOf(jsonValue5.getLong(0L));
                } else {
                    str = "null cannot be cast to non-null type kotlin.Long";
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf = (Long) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf = (Long) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        lValueOf = (Long) Integer.valueOf(jsonValue5.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList3 = jsonValue5.optList();
                        if (objOptList3 == null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf = (Long) objOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap3 = jsonValue5.optMap();
                        if (objOptMap3 == null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf = (Long) objOptMap3;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'date" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue6 = jsonValue5.getJsonValue();
                        if (jsonValue6 == null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf = (Long) jsonValue6;
                    }
                }
                jLongValue = lValueOf.longValue();
                jsonValue = json.get("last_full_upload_date");
                if (jsonValue == null) {
                    lValueOf2 = null;
                } else {
                    Intrinsics.checkNotNull(jsonValue);
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf2 = (Long) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        objOptString = jsonValue.optString();
                        if (objOptString != null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf2 = (Long) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf2 = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf2 = Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf2 = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf2 = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf2 = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        lValueOf2 = (Long) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf2 = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue.optList();
                        if (objOptList != null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf2 = (Long) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf2 = (Long) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'last_full_upload_date" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 != null) {
                            throw new NullPointerException(str);
                        }
                        lValueOf2 = (Long) jsonValue2;
                    }
                }
                l = lValueOf2;
                channelRegistrationPayloadFromJson = ChannelRegistrationPayload.fromJson(json.require("payload"));
                Intrinsics.checkNotNullExpressionValue(channelRegistrationPayloadFromJson, "fromJson(...)");
                jsonValue3 = json.get(EnableFeatureAction.FEATURE_LOCATION);
                if (jsonValue3 != null) {
                    throw new JsonException("Missing required field: '" + EnableFeatureAction.FEATURE_LOCATION + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Intrinsics.checkNotNull(jsonValue3);
                orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue3.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue3.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList2 = jsonValue3.optList();
                    if (objOptList2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap2 = jsonValue3.optMap();
                    if (objOptMap2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap2;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + EnableFeatureAction.FEATURE_LOCATION + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue4 = jsonValue3.getJsonValue();
                    if (jsonValue4 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue4;
                }
                this(jLongValue, l, channelRegistrationPayloadFromJson, strOptString);
            }
            Object objOptString4 = jsonValue5.optString();
            if (objOptString4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            lValueOf = (Long) objOptString4;
        }
        str = "null cannot be cast to non-null type kotlin.Long";
        jLongValue = lValueOf.longValue();
        jsonValue = json.get("last_full_upload_date");
        if (jsonValue == null) {
            lValueOf2 = null;
        } else {
            Intrinsics.checkNotNull(jsonValue);
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString2 = jsonValue.optString();
                if (objOptString2 != null) {
                    throw new NullPointerException(str);
                }
                lValueOf2 = (Long) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                objOptString = jsonValue.optString();
                if (objOptString != null) {
                    throw new NullPointerException(str);
                }
                lValueOf2 = (Long) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                lValueOf2 = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                lValueOf2 = Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                lValueOf2 = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                lValueOf2 = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                lValueOf2 = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                lValueOf2 = (Long) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                lValueOf2 = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                objOptList = jsonValue.optList();
                if (objOptList != null) {
                    throw new NullPointerException(str);
                }
                lValueOf2 = (Long) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                objOptMap = jsonValue.optMap();
                if (objOptMap != null) {
                    throw new NullPointerException(str);
                }
                lValueOf2 = (Long) objOptMap;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'last_full_upload_date" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 != null) {
                    throw new NullPointerException(str);
                }
                lValueOf2 = (Long) jsonValue2;
            }
        }
        l = lValueOf2;
        channelRegistrationPayloadFromJson = ChannelRegistrationPayload.fromJson(json.require("payload"));
        Intrinsics.checkNotNullExpressionValue(channelRegistrationPayloadFromJson, "fromJson(...)");
        jsonValue3 = json.get(EnableFeatureAction.FEATURE_LOCATION);
        if (jsonValue3 != null) {
            throw new JsonException("Missing required field: '" + EnableFeatureAction.FEATURE_LOCATION + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue3);
        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString = jsonValue3.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString = jsonValue3.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            objOptList2 = jsonValue3.optList();
            if (objOptList2 != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptList2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            objOptMap2 = jsonValue3.optMap();
            if (objOptMap2 != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptMap2;
        } else {
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + EnableFeatureAction.FEATURE_LOCATION + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue4 = jsonValue3.getJsonValue();
            if (jsonValue4 != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue4;
        }
        this(jLongValue, l, channelRegistrationPayloadFromJson, strOptString);
    }

    public RegistrationInfo(long j, Long l, ChannelRegistrationPayload payload, String location) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(location, "location");
        this.dateMillis = j;
        this.lastFullUploadMillis = l;
        this.payload = payload;
        this.location = location;
    }

    public final long getDateMillis() {
        return this.dateMillis;
    }

    public final Long getLastFullUploadMillis() {
        return this.lastFullUploadMillis;
    }

    public final ChannelRegistrationPayload getPayload() {
        return this.payload;
    }

    public final String getLocation() {
        return this.location;
    }

    @Override // com.urbanairship.json.JsonSerializable
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("date", Long.valueOf(this.dateMillis)), TuplesKt.m1842to("last_full_upload_date", this.lastFullUploadMillis), TuplesKt.m1842to("payload", this.payload), TuplesKt.m1842to(EnableFeatureAction.FEATURE_LOCATION, this.location)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
