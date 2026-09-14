package com.urbanairship.featureflag;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00032\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0007\b¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlag;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "Companion", "Found", "NotFound", "ResultType", "Lcom/urbanairship/featureflag/DeferredFlag$Found;", "Lcom/urbanairship/featureflag/DeferredFlag$NotFound;", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public abstract class DeferredFlag implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ DeferredFlag(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeferredFlag() {
    }

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$ResultType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "FOUND", "NOT_FOUND", "Companion", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public enum ResultType {
        FOUND("found"),
        NOT_FOUND("not_found");

        private final String jsonValue;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static EnumEntries<ResultType> getEntries() {
            return $ENTRIES;
        }

        ResultType(String str) {
            this.jsonValue = str;
        }

        @NotNull
        public final String getJsonValue() {
            return this.jsonValue;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$ResultType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/featureflag/DeferredFlag$ResultType;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$ResultType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n288#2,2:219\n*S KotlinDebug\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$ResultType$Companion\n*L\n154#1:219,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ResultType fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                ResultType next;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                String strRequireString = jsonValue.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<ResultType> it = ResultType.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.getJsonValue(), strRequireString));
                ResultType resultType = next;
                if (resultType != null) {
                    return resultType;
                }
                throw new JsonException("Invalid result type: " + jsonValue);
            }
        }
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$Companion;", "", "()V", "KEY_FLAG", "", "KEY_TYPE", "fromJson", "Lcom/urbanairship/featureflag/DeferredFlag;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,218:1\n44#2,15:219\n44#2,15:234\n*S KotlinDebug\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$Companion\n*L\n165#1:219,15\n167#1:234,15\n*E\n"})
    public static final class Companion {

        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ResultType.values().length];
                try {
                    iArr[ResultType.NOT_FOUND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ResultType.FOUND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0273  */
        /* JADX WARN: Code duplicated, block: B:103:0x0279  */
        /* JADX WARN: Code duplicated, block: B:104:0x027c  */
        /* JADX WARN: Code duplicated, block: B:106:0x0282  */
        /* JADX WARN: Code duplicated, block: B:108:0x028c  */
        /* JADX WARN: Code duplicated, block: B:110:0x0292  */
        /* JADX WARN: Code duplicated, block: B:111:0x0295  */
        /* JADX WARN: Code duplicated, block: B:113:0x029b  */
        /* JADX WARN: Code duplicated, block: B:115:0x02a5  */
        /* JADX WARN: Code duplicated, block: B:118:0x02b3  */
        /* JADX WARN: Code duplicated, block: B:120:0x02b9  */
        /* JADX WARN: Code duplicated, block: B:122:0x02dd  */
        /* JADX WARN: Code duplicated, block: B:124:0x02f7  */
        /* JADX WARN: Code duplicated, block: B:126:0x02fd  */
        /* JADX WARN: Code duplicated, block: B:60:0x0170  */
        /* JADX WARN: Code duplicated, block: B:62:0x0173  */
        /* JADX WARN: Code duplicated, block: B:64:0x017f  */
        /* JADX WARN: Code duplicated, block: B:66:0x018d  */
        /* JADX WARN: Code duplicated, block: B:68:0x0193  */
        /* JADX WARN: Code duplicated, block: B:69:0x0197  */
        /* JADX WARN: Code duplicated, block: B:71:0x019d  */
        /* JADX WARN: Code duplicated, block: B:73:0x01a7  */
        /* JADX WARN: Code duplicated, block: B:75:0x01ad  */
        /* JADX WARN: Code duplicated, block: B:76:0x01b1  */
        /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:80:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:81:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:83:0x01dc  */
        /* JADX WARN: Code duplicated, block: B:84:0x01ea  */
        /* JADX WARN: Code duplicated, block: B:86:0x01f6  */
        /* JADX WARN: Code duplicated, block: B:87:0x0206  */
        /* JADX WARN: Code duplicated, block: B:89:0x0212  */
        /* JADX WARN: Code duplicated, block: B:90:0x0220  */
        /* JADX WARN: Code duplicated, block: B:92:0x022c  */
        /* JADX WARN: Code duplicated, block: B:93:0x0239  */
        /* JADX WARN: Code duplicated, block: B:95:0x0243  */
        /* JADX WARN: Code duplicated, block: B:96:0x024f  */
        /* JADX WARN: Code duplicated, block: B:98:0x025a  */
        /* JADX WARN: Code duplicated, block: B:99:0x0269  */
        /* JADX WARN: Instruction removed from duplicated block: B:120:0x02b9, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:122:0x02dd, please report this as an issue */
        @NotNull
        public final DeferredFlag fromJson(@NotNull JsonValue jsonValue) throws JsonException {
            String str;
            JsonValue jsonValue2;
            int i;
            DeferredFlagInfo.Companion companion;
            JsonValue jsonValue3;
            KClass orCreateKotlinClass;
            JsonValue jsonValue4;
            JsonSerializable jsonSerializableOptMap;
            JsonSerializable jsonSerializableOptList;
            Object objOptString;
            Object objOptString2;
            Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
            JsonMap jsonMapRequireMap = jsonValue.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            ResultType.Companion companion2 = ResultType.INSTANCE;
            JsonValue jsonValue5 = jsonMapRequireMap.get("type");
            if (jsonValue5 == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString3 = jsonValue5.optString();
                if (objOptString3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue2 = (JsonValue) objOptString3;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonValue2 = (JsonValue) Boolean.valueOf(jsonValue5.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "null cannot be cast to non-null type com.urbanairship.json.JsonValue";
                        jsonValue2 = (JsonValue) Long.valueOf(jsonValue5.getLong(0L));
                    } else {
                        str = "null cannot be cast to non-null type com.urbanairship.json.JsonValue";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonValue2 = (JsonValue) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonValue2 = (JsonValue) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonValue2 = (JsonValue) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonValue2 = (JsonValue) Integer.valueOf(jsonValue5.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonValue2 = (JsonValue) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList2 = jsonValue5.optList();
                            if (jsonSerializableOptList2 == null) {
                                throw new NullPointerException(str);
                            }
                            jsonValue2 = (JsonValue) jsonSerializableOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            JsonSerializable jsonSerializableOptMap2 = jsonValue5.optMap();
                            if (jsonSerializableOptMap2 == null) {
                                throw new NullPointerException(str);
                            }
                            jsonValue2 = (JsonValue) jsonSerializableOptMap2;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue2 = jsonValue5.toJsonValue();
                            if (jsonValue2 == null) {
                                throw new NullPointerException(str);
                            }
                        }
                    }
                    i = WhenMappings.$EnumSwitchMapping$0[companion2.fromJson(jsonValue2).ordinal()];
                    if (i != 1) {
                        return NotFound.INSTANCE;
                    }
                    if (i == 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    companion = DeferredFlagInfo.INSTANCE;
                    jsonValue3 = jsonMapRequireMap.get("flag");
                    if (jsonValue3 != null) {
                        throw new JsonException("Missing required field: 'flag" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue3.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException(str);
                        }
                        jsonValue4 = (JsonValue) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        objOptString = jsonValue3.optString();
                        if (objOptString != null) {
                            throw new NullPointerException(str);
                        }
                        jsonValue4 = (JsonValue) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonValue4 = (JsonValue) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonValue4 = (JsonValue) Long.valueOf(jsonValue3.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonValue4 = (JsonValue) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonValue4 = (JsonValue) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonValue4 = (JsonValue) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        jsonValue4 = (JsonValue) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonValue4 = (JsonValue) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        jsonSerializableOptList = jsonValue3.optList();
                        if (jsonSerializableOptList != null) {
                            throw new NullPointerException(str);
                        }
                        jsonValue4 = (JsonValue) jsonSerializableOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonSerializableOptMap = jsonValue3.optMap();
                        if (jsonSerializableOptMap != null) {
                            throw new NullPointerException(str);
                        }
                        jsonValue4 = (JsonValue) jsonSerializableOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'flag" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue4 = jsonValue3.toJsonValue();
                        if (jsonValue4 == null) {
                            throw new NullPointerException(str);
                        }
                    }
                    return new Found(companion.fromJson(jsonValue4));
                }
                Object objOptString4 = jsonValue5.optString();
                if (objOptString4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue2 = (JsonValue) objOptString4;
            }
            str = "null cannot be cast to non-null type com.urbanairship.json.JsonValue";
            i = WhenMappings.$EnumSwitchMapping$0[companion2.fromJson(jsonValue2).ordinal()];
            if (i != 1) {
                return NotFound.INSTANCE;
            }
            if (i == 2) {
                throw new NoWhenBranchMatchedException();
            }
            companion = DeferredFlagInfo.INSTANCE;
            jsonValue3 = jsonMapRequireMap.get("flag");
            if (jsonValue3 != null) {
                throw new JsonException("Missing required field: 'flag" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString2 = jsonValue3.optString();
                if (objOptString2 != null) {
                    throw new NullPointerException(str);
                }
                jsonValue4 = (JsonValue) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                objOptString = jsonValue3.optString();
                if (objOptString != null) {
                    throw new NullPointerException(str);
                }
                jsonValue4 = (JsonValue) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue4 = (JsonValue) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue4 = (JsonValue) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue4 = (JsonValue) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue4 = (JsonValue) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue4 = (JsonValue) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonValue4 = (JsonValue) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue4 = (JsonValue) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonSerializableOptList = jsonValue3.optList();
                if (jsonSerializableOptList != null) {
                    throw new NullPointerException(str);
                }
                jsonValue4 = (JsonValue) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonSerializableOptMap = jsonValue3.optMap();
                if (jsonSerializableOptMap != null) {
                    throw new NullPointerException(str);
                }
                jsonValue4 = (JsonValue) jsonSerializableOptMap;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'flag" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue4 = jsonValue3.toJsonValue();
                if (jsonValue4 == null) {
                    throw new NullPointerException(str);
                }
            }
            return new Found(companion.fromJson(jsonValue4));
        }
    }

    @Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$Found;", "Lcom/urbanairship/featureflag/DeferredFlag;", "flagInfo", "Lcom/urbanairship/featureflag/DeferredFlagInfo;", "(Lcom/urbanairship/featureflag/DeferredFlagInfo;)V", "getFlagInfo", "()Lcom/urbanairship/featureflag/DeferredFlagInfo;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class Found extends DeferredFlag {
        private final DeferredFlagInfo flagInfo;

        public static /* synthetic */ Found copy$default(Found found, DeferredFlagInfo deferredFlagInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                deferredFlagInfo = found.flagInfo;
            }
            return found.copy(deferredFlagInfo);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DeferredFlagInfo getFlagInfo() {
            return this.flagInfo;
        }

        @NotNull
        public final Found copy(@NotNull DeferredFlagInfo flagInfo) {
            Intrinsics.checkNotNullParameter(flagInfo, "flagInfo");
            return new Found(flagInfo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Found) && Intrinsics.areEqual(this.flagInfo, ((Found) other).flagInfo);
        }

        public int hashCode() {
            return this.flagInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "Found(flagInfo=" + this.flagInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Found(@NotNull DeferredFlagInfo flagInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(flagInfo, "flagInfo");
            this.flagInfo = flagInfo;
        }

        @NotNull
        public final DeferredFlagInfo getFlagInfo() {
            return this.flagInfo;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() throws JsonException {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", ResultType.FOUND.getJsonValue()), TuplesKt.m1842to("flag", this.flagInfo)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, m1836d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$NotFound;", "Lcom/urbanairship/featureflag/DeferredFlag;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class NotFound extends DeferredFlag {

        @NotNull
        public static final NotFound INSTANCE = new NotFound();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof NotFound);
        }

        public int hashCode() {
            return 1957115929;
        }

        @NotNull
        public String toString() {
            return "NotFound";
        }

        private NotFound() {
            super(null);
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() throws JsonException {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", ResultType.NOT_FOUND.getJsonValue())).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
