package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/Shadow;", "", "androidShadow", "Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "(Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;)V", "getAndroidShadow", "()Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "ElevationShadow", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final /* data */ class Shadow {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final ElevationShadow androidShadow;

    public static /* synthetic */ Shadow copy$default(Shadow shadow, ElevationShadow elevationShadow, int i, Object obj) {
        if ((i & 1) != 0) {
            elevationShadow = shadow.androidShadow;
        }
        return shadow.copy(elevationShadow);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ElevationShadow getAndroidShadow() {
        return this.androidShadow;
    }

    @NotNull
    public final Shadow copy(@Nullable ElevationShadow androidShadow) {
        return new Shadow(androidShadow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Shadow) && Intrinsics.areEqual(this.androidShadow, ((Shadow) other).androidShadow);
    }

    public int hashCode() {
        ElevationShadow elevationShadow = this.androidShadow;
        if (elevationShadow == null) {
            return 0;
        }
        return elevationShadow.hashCode();
    }

    @NotNull
    public String toString() {
        return "Shadow(androidShadow=" + this.androidShadow + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Shadow(@Nullable ElevationShadow elevationShadow) {
        this.androidShadow = elevationShadow;
    }

    @Nullable
    public final ElevationShadow getAndroidShadow() {
        return this.androidShadow;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/Shadow$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/Shadow;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nShadow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Shadow.kt\ncom/urbanairship/android/layout/property/Shadow$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,37:1\n1#2:38\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Shadow fromJson(@NotNull JsonValue json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.requireMap().get("android_shadow");
            return new Shadow(jsonValue != null ? ElevationShadow.INSTANCE.fromJson(jsonValue) : null);
        }
    }

    @Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "", "color", "Lcom/urbanairship/android/layout/property/Color;", "elevation", "", "(Lcom/urbanairship/android/layout/property/Color;F)V", "getColor", "()Lcom/urbanairship/android/layout/property/Color;", "getElevation", "()F", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class ElevationShadow {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Color color;
        private final float elevation;

        public static /* synthetic */ ElevationShadow copy$default(ElevationShadow elevationShadow, Color color, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                color = elevationShadow.color;
            }
            if ((i & 2) != 0) {
                f = elevationShadow.elevation;
            }
            return elevationShadow.copy(color, f);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Color getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getElevation() {
            return this.elevation;
        }

        @NotNull
        public final ElevationShadow copy(@NotNull Color color, float elevation) {
            Intrinsics.checkNotNullParameter(color, "color");
            return new ElevationShadow(color, elevation);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ElevationShadow)) {
                return false;
            }
            ElevationShadow elevationShadow = (ElevationShadow) other;
            return Intrinsics.areEqual(this.color, elevationShadow.color) && Float.compare(this.elevation, elevationShadow.elevation) == 0;
        }

        public int hashCode() {
            return (this.color.hashCode() * 31) + Float.hashCode(this.elevation);
        }

        @NotNull
        public String toString() {
            return "ElevationShadow(color=" + this.color + ", elevation=" + this.elevation + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ElevationShadow(@NotNull Color color, float f) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.color = color;
            this.elevation = f;
        }

        @NotNull
        public final Color getColor() {
            return this.color;
        }

        public final float getElevation() {
            return this.elevation;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/Shadow$ElevationShadow;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nShadow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Shadow.kt\ncom/urbanairship/android/layout/property/Shadow$ElevationShadow$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,37:1\n44#2,15:38\n44#2,15:53\n*S KotlinDebug\n*F\n+ 1 Shadow.kt\ncom/urbanairship/android/layout/property/Shadow$ElevationShadow$Companion\n*L\n30#1:38,15\n31#1:53,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:100:0x0273  */
            /* JADX WARN: Code duplicated, block: B:101:0x0276  */
            /* JADX WARN: Code duplicated, block: B:103:0x027c  */
            /* JADX WARN: Code duplicated, block: B:105:0x0286  */
            /* JADX WARN: Code duplicated, block: B:107:0x028c  */
            /* JADX WARN: Code duplicated, block: B:108:0x028f  */
            /* JADX WARN: Code duplicated, block: B:110:0x0295  */
            /* JADX WARN: Code duplicated, block: B:112:0x029f  */
            /* JADX WARN: Code duplicated, block: B:114:0x02a5  */
            /* JADX WARN: Code duplicated, block: B:117:0x02af  */
            /* JADX WARN: Code duplicated, block: B:119:0x02b5  */
            /* JADX WARN: Code duplicated, block: B:121:0x02d9  */
            /* JADX WARN: Code duplicated, block: B:61:0x0177  */
            /* JADX WARN: Code duplicated, block: B:63:0x0189  */
            /* JADX WARN: Code duplicated, block: B:65:0x018f  */
            /* JADX WARN: Code duplicated, block: B:66:0x0193  */
            /* JADX WARN: Code duplicated, block: B:68:0x0199  */
            /* JADX WARN: Code duplicated, block: B:70:0x01a3  */
            /* JADX WARN: Code duplicated, block: B:72:0x01a9  */
            /* JADX WARN: Code duplicated, block: B:73:0x01ad  */
            /* JADX WARN: Code duplicated, block: B:75:0x01b3  */
            /* JADX WARN: Code duplicated, block: B:77:0x01bf  */
            /* JADX WARN: Code duplicated, block: B:78:0x01cc  */
            /* JADX WARN: Code duplicated, block: B:80:0x01d8  */
            /* JADX WARN: Code duplicated, block: B:81:0x01e6  */
            /* JADX WARN: Code duplicated, block: B:83:0x01f2  */
            /* JADX WARN: Code duplicated, block: B:84:0x0202  */
            /* JADX WARN: Code duplicated, block: B:86:0x020e  */
            /* JADX WARN: Code duplicated, block: B:87:0x021c  */
            /* JADX WARN: Code duplicated, block: B:89:0x0228  */
            /* JADX WARN: Code duplicated, block: B:90:0x0233  */
            /* JADX WARN: Code duplicated, block: B:92:0x023d  */
            /* JADX WARN: Code duplicated, block: B:93:0x0249  */
            /* JADX WARN: Code duplicated, block: B:95:0x0254  */
            /* JADX WARN: Code duplicated, block: B:96:0x0263  */
            /* JADX WARN: Code duplicated, block: B:98:0x026d  */
            /* JADX WARN: Instruction removed from duplicated block: B:119:0x02b5, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:121:0x02d9, please report this as an issue */
            @NotNull
            public final ElevationShadow fromJson(@NotNull JsonValue json) throws JsonException {
                String str;
                JsonMap jsonMapOptMap;
                Color colorFromJson;
                JsonValue jsonValue;
                KClass orCreateKotlinClass;
                Object jsonValue2;
                Float fValueOf;
                Object objOptMap;
                Object objOptList;
                Object objOptString;
                Object objOptString2;
                Intrinsics.checkNotNullParameter(json, "json");
                JsonMap jsonMapRequireMap = json.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue3 = jsonMapRequireMap.get("color");
                if (jsonValue3 == null) {
                    throw new JsonException("Missing required field: 'color" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString3 = jsonValue3.optString();
                    if (objOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString4 = jsonValue3.optString();
                    if (objOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString4;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            str = "' for field '";
                            jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                        } else {
                            str = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                JsonSerializable jsonSerializableOptList = jsonValue3.optList();
                                if (jsonSerializableOptList == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                                jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                jsonMapOptMap = jsonValue3.optMap();
                                if (jsonMapOptMap == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "color" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                JsonSerializable jsonValue4 = jsonValue3.getJsonValue();
                                if (jsonValue4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                                jsonMapOptMap = (JsonMap) jsonValue4;
                            }
                        }
                        colorFromJson = Color.fromJson(jsonMapOptMap);
                        Intrinsics.checkNotNullExpressionValue(colorFromJson, "fromJson(...)");
                        jsonValue = jsonMapRequireMap.get("elevation");
                        if (jsonValue != null) {
                            throw new JsonException("Missing required field: 'elevation" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Float.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            objOptString2 = jsonValue.optString();
                            if (objOptString2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                            }
                            fValueOf = (Float) objOptString2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            objOptString = jsonValue.optString();
                            if (objOptString != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                            }
                            fValueOf = (Float) objOptString;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            fValueOf = (Float) Boolean.valueOf(jsonValue.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            fValueOf = (Float) Long.valueOf(jsonValue.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            fValueOf = (Float) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            fValueOf = (Float) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            fValueOf = Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            fValueOf = (Float) Integer.valueOf(jsonValue.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            fValueOf = (Float) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList = jsonValue.optList();
                            if (objOptList != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                            }
                            fValueOf = (Float) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap = jsonValue.optMap();
                            if (objOptMap != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                            }
                            fValueOf = (Float) objOptMap;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Float.class.getSimpleName() + str + "elevation" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue2 = jsonValue.getJsonValue();
                            if (jsonValue2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                            }
                            fValueOf = (Float) jsonValue2;
                        }
                        return new ElevationShadow(colorFromJson, fValueOf.floatValue());
                    }
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
                }
                str = "' for field '";
                colorFromJson = Color.fromJson(jsonMapOptMap);
                Intrinsics.checkNotNullExpressionValue(colorFromJson, "fromJson(...)");
                jsonValue = jsonMapRequireMap.get("elevation");
                if (jsonValue != null) {
                    throw new JsonException("Missing required field: 'elevation" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Float.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString2 = jsonValue.optString();
                    if (objOptString2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    fValueOf = (Float) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString = jsonValue.optString();
                    if (objOptString != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    fValueOf = (Float) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    fValueOf = (Float) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    fValueOf = (Float) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    fValueOf = (Float) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    fValueOf = (Float) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    fValueOf = Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    fValueOf = (Float) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    fValueOf = (Float) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList = jsonValue.optList();
                    if (objOptList != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    fValueOf = (Float) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap = jsonValue.optMap();
                    if (objOptMap != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    fValueOf = (Float) objOptMap;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Float.class.getSimpleName() + str + "elevation" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }
                    fValueOf = (Float) jsonValue2;
                }
                return new ElevationShadow(colorFromJson, fValueOf.floatValue());
            }
        }
    }
}
