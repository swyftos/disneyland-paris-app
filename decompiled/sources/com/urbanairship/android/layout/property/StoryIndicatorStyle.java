package com.urbanairship.android.layout.property;

import androidx.annotation.Dimension;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.property.StoryIndicatorStyleType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyle;", "", "type", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType;", "(Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType;)V", "getType", "()Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType;", "Companion", "LinearProgress", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class StoryIndicatorStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final StoryIndicatorStyleType type;

    public /* synthetic */ StoryIndicatorStyle(StoryIndicatorStyleType storyIndicatorStyleType, DefaultConstructorMarker defaultConstructorMarker) {
        this(storyIndicatorStyleType);
    }

    private StoryIndicatorStyle(StoryIndicatorStyleType storyIndicatorStyleType) {
        this.type = storyIndicatorStyleType;
    }

    @NotNull
    public final StoryIndicatorStyleType getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u00020\u00128G¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress;", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyle;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "direction", "Lcom/urbanairship/android/layout/property/Direction;", "getDirection", "()Lcom/urbanairship/android/layout/property/Direction;", "progressColor", "Lcom/urbanairship/android/layout/property/Color;", "getProgressColor", "()Lcom/urbanairship/android/layout/property/Color;", "sizing", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress$SizingType;", "getSizing", "()Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress$SizingType;", "spacing", "", "getSpacing", "()I", "trackColor", "getTrackColor", "SizingType", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStoryIndicatorStyle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StoryIndicatorStyle.kt\ncom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,48:1\n44#2,15:49\n79#2,16:64\n79#2,16:80\n44#2,15:96\n44#2,15:111\n*S KotlinDebug\n*F\n+ 1 StoryIndicatorStyle.kt\ncom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress\n*L\n13#1:49,15\n14#1:64,16\n18#1:80,16\n19#1:96,15\n20#1:111,15\n*E\n"})
    public static final class LinearProgress extends StoryIndicatorStyle {
        private final Direction direction;
        private final Color progressColor;
        private final SizingType sizing;
        private final int spacing;
        private final Color trackColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LinearProgress(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            String strOptString2;
            Integer numValueOf;
            Integer num;
            JsonMap jsonMapOptMap;
            JsonMap jsonMapOptMap2;
            super(StoryIndicatorStyleType.LINEAR_PROGRESS, null);
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("direction");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'direction" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'direction" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            Direction directionFrom = Direction.from(strOptString);
            Intrinsics.checkNotNullExpressionValue(directionFrom, "from(...)");
            this.direction = directionFrom;
            JsonValue jsonValue3 = json.get("sizing");
            if (jsonValue3 == null) {
                strOptString2 = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString2 = jsonValue3.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue3.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList2 = jsonValue3.optList();
                    if (objOptList2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap2 = jsonValue3.optMap();
                    if (objOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptMap2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'sizing" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue4 = jsonValue3.getJsonValue();
                    if (jsonValue4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) jsonValue4;
                }
            }
            this.sizing = strOptString2 != null ? SizingType.INSTANCE.from(strOptString2) : null;
            JsonValue jsonValue5 = json.get("spacing");
            if (jsonValue5 == null) {
                num = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue5.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue5.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    numValueOf = (Integer) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    numValueOf = (Integer) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    numValueOf = (Integer) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    numValueOf = (Integer) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    numValueOf = Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList3 = jsonValue5.optList();
                    if (objOptList3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptList3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap3 = jsonValue5.optMap();
                    if (objOptMap3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptMap3;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'spacing" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue6 = jsonValue5.getJsonValue();
                    if (jsonValue6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) jsonValue6;
                }
                num = numValueOf;
            }
            this.spacing = num != null ? num.intValue() : 4;
            JsonValue jsonValue7 = json.get("track_color");
            if (jsonValue7 == null) {
                throw new JsonException("Missing required field: 'track_color" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString3 = jsonValue7.optString();
                if (objOptString3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString3;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString4 = jsonValue7.optString();
                if (objOptString4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString4;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue7.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue7.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue7.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue7.optList();
                if (jsonSerializableOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap = jsonValue7.optMap();
                if (jsonMapOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'track_color" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                JsonSerializable jsonValue8 = jsonValue7.getJsonValue();
                if (jsonValue8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonValue8;
            }
            Color colorFromJson = Color.fromJson(jsonMapOptMap);
            Intrinsics.checkNotNullExpressionValue(colorFromJson, "fromJson(...)");
            this.trackColor = colorFromJson;
            JsonValue jsonValue9 = json.get("progress_color");
            if (jsonValue9 == null) {
                throw new JsonException("Missing required field: 'progress_color" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString5 = jsonValue9.optString();
                if (objOptString5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) objOptString5;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString6 = jsonValue9.optString();
                if (objOptString6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) objOptString6;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue9.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue9.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap2 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue9.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap2 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList2 = jsonValue9.optList();
                if (jsonSerializableOptList2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) jsonSerializableOptList2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap2 = jsonValue9.optMap();
                if (jsonMapOptMap2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'progress_color" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                JsonSerializable jsonValue10 = jsonValue9.getJsonValue();
                if (jsonValue10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap2 = (JsonMap) jsonValue10;
            }
            Color colorFromJson2 = Color.fromJson(jsonMapOptMap2);
            Intrinsics.checkNotNullExpressionValue(colorFromJson2, "fromJson(...)");
            this.progressColor = colorFromJson2;
        }

        @NotNull
        public final Direction getDirection() {
            return this.direction;
        }

        @Nullable
        public final SizingType getSizing() {
            return this.sizing;
        }

        @Dimension(unit = 0)
        public final int getSpacing() {
            return this.spacing;
        }

        @NotNull
        public final Color getTrackColor() {
            return this.trackColor;
        }

        @NotNull
        public final Color getProgressColor() {
            return this.progressColor;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress$SizingType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "EQUAL", "PAGE_DURATION", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class SizingType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ SizingType[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final SizingType EQUAL = new SizingType("EQUAL", 0, "equal");
            public static final SizingType PAGE_DURATION = new SizingType("PAGE_DURATION", 1, "page_duration");
            private final String value;

            private static final /* synthetic */ SizingType[] $values() {
                return new SizingType[]{EQUAL, PAGE_DURATION};
            }

            @NotNull
            public static EnumEntries<SizingType> getEntries() {
                return $ENTRIES;
            }

            public static SizingType valueOf(String str) {
                return (SizingType) Enum.valueOf(SizingType.class, str);
            }

            public static SizingType[] values() {
                return (SizingType[]) $VALUES.clone();
            }

            private SizingType(String str, int i, String str2) {
                this.value = str2;
            }

            static {
                SizingType[] sizingTypeArr$values = $values();
                $VALUES = sizingTypeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(sizingTypeArr$values);
                INSTANCE = new Companion(null);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress$SizingType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$LinearProgress$SizingType;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final SizingType from(@NotNull String value) throws IllegalArgumentException {
                    Intrinsics.checkNotNullParameter(value, "value");
                    for (SizingType sizingType : SizingType.values()) {
                        String str = sizingType.value;
                        String lowerCase = value.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (Intrinsics.areEqual(str, lowerCase)) {
                            return sizingType;
                        }
                    }
                    throw new IllegalArgumentException("Unknown StoryIndicator sizing value: " + value);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyle$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyle;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStoryIndicatorStyle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StoryIndicatorStyle.kt\ncom/urbanairship/android/layout/property/StoryIndicatorStyle$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,48:1\n44#2,15:49\n*S KotlinDebug\n*F\n+ 1 StoryIndicatorStyle.kt\ncom/urbanairship/android/layout/property/StoryIndicatorStyle$Companion\n*L\n42#1:49,15\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[StoryIndicatorStyleType.values().length];
                try {
                    iArr[StoryIndicatorStyleType.LINEAR_PROGRESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final StoryIndicatorStyle from(@NotNull JsonMap json) throws IllegalArgumentException, JsonException {
            String strOptString;
            Intrinsics.checkNotNullParameter(json, "json");
            StoryIndicatorStyleType.Companion companion = StoryIndicatorStyleType.INSTANCE;
            JsonValue jsonValue = json.get("type");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            if (WhenMappings.$EnumSwitchMapping$0[companion.from(strOptString).ordinal()] == 1) {
                return new LinearProgress(json);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
