package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
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

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/layout/property/Video;", "", ViewProps.ASPECT_RATIO, "", "showControls", "", "autoplay", "muted", "loop", "(Ljava/lang/Double;ZZZZ)V", "getAspectRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAutoplay", "()Z", "getLoop", "getMuted", "getShowControls", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Video {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Double aspectRatio;
    private final boolean autoplay;
    private final boolean loop;
    private final boolean muted;
    private final boolean showControls;

    public Video(@Nullable Double d, boolean z, boolean z2, boolean z3, boolean z4) {
        this.aspectRatio = d;
        this.showControls = z;
        this.autoplay = z2;
        this.muted = z3;
        this.loop = z4;
    }

    @Nullable
    public final Double getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getShowControls() {
        return this.showControls;
    }

    public final boolean getAutoplay() {
        return this.autoplay;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final boolean getLoop() {
        return this.loop;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/property/Video$Companion;", "", "()V", "defaultVideo", "Lcom/urbanairship/android/layout/property/Video;", "fromJson", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nVideo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Video.kt\ncom/urbanairship/android/layout/property/Video$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,35:1\n79#2,16:36\n79#2,16:52\n79#2,16:68\n79#2,16:84\n79#2,16:100\n*S KotlinDebug\n*F\n+ 1 Video.kt\ncom/urbanairship/android/layout/property/Video$Companion\n*L\n16#1:36,16\n17#1:52,16\n18#1:68,16\n19#1:84,16\n20#1:100,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Video defaultVideo() {
            return new Video(null, true, false, false, false);
        }

        @NotNull
        public final Video fromJson(@NotNull JsonMap json) throws JsonException {
            Double dValueOf;
            Double d;
            String str;
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            boolean z;
            Boolean bool;
            Boolean boolValueOf4;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("aspect_ratio");
            Boolean bool2 = null;
            if (jsonValue == null) {
                d = null;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Double.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }
                    dValueOf = (Double) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }
                    dValueOf = (Double) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    dValueOf = (Double) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    dValueOf = (Double) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    dValueOf = (Double) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    dValueOf = Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    dValueOf = (Double) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    dValueOf = (Double) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    dValueOf = (Double) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }
                    dValueOf = (Double) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }
                    dValueOf = (Double) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Double.class.getSimpleName() + "' for field 'aspect_ratio" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }
                    dValueOf = (Double) jsonValue2;
                }
                d = dValueOf;
            }
            JsonValue jsonValue3 = json.get("show_controls");
            if (jsonValue3 == null) {
                str = "Invalid type '";
                boolValueOf = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString3 = jsonValue3.optString();
                    if (objOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf = (Boolean) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString4 = jsonValue3.optString();
                    if (objOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf = (Boolean) objOptString4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf = Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "Invalid type '";
                    boolValueOf = (Boolean) Long.valueOf(jsonValue3.getLong(0L));
                } else {
                    str = "Invalid type '";
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        boolValueOf = (Boolean) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        boolValueOf = (Boolean) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf = (Boolean) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList2 = jsonValue3.optList();
                        if (objOptList2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap2 = jsonValue3.optMap();
                        if (objOptMap2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptMap2;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException(str + Boolean.class.getSimpleName() + "' for field 'show_controls" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue4 = jsonValue3.getJsonValue();
                        if (jsonValue4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) jsonValue4;
                    }
                }
                str = "Invalid type '";
            }
            boolean zBooleanValue = boolValueOf != null ? boolValueOf.booleanValue() : true;
            JsonValue jsonValue5 = json.get("autoplay");
            if (jsonValue5 == null) {
                boolValueOf2 = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString5 = jsonValue5.optString();
                    if (objOptString5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf2 = (Boolean) objOptString5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString6 = jsonValue5.optString();
                    if (objOptString6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf2 = (Boolean) objOptString6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf2 = Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf2 = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf2 = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf2 = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf2 = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    boolValueOf2 = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf2 = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList3 = jsonValue5.optList();
                    if (objOptList3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf2 = (Boolean) objOptList3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap3 = jsonValue5.optMap();
                    if (objOptMap3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf2 = (Boolean) objOptMap3;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException(str + Boolean.class.getSimpleName() + "' for field 'autoplay" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue6 = jsonValue5.getJsonValue();
                    if (jsonValue6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf2 = (Boolean) jsonValue6;
                }
            }
            boolean zBooleanValue2 = boolValueOf2 != null ? boolValueOf2.booleanValue() : false;
            JsonValue jsonValue7 = json.get("muted");
            if (jsonValue7 == null) {
                boolValueOf3 = null;
            } else {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString7 = jsonValue7.optString();
                    if (objOptString7 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf3 = (Boolean) objOptString7;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString8 = jsonValue7.optString();
                    if (objOptString8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf3 = (Boolean) objOptString8;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf3 = Boolean.valueOf(jsonValue7.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf3 = (Boolean) Long.valueOf(jsonValue7.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf3 = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf3 = (Boolean) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf3 = (Boolean) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    boolValueOf3 = (Boolean) Integer.valueOf(jsonValue7.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf3 = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList4 = jsonValue7.optList();
                    if (objOptList4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf3 = (Boolean) objOptList4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap4 = jsonValue7.optMap();
                    if (objOptMap4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf3 = (Boolean) objOptMap4;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException(str + Boolean.class.getSimpleName() + "' for field 'muted" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue8 = jsonValue7.getJsonValue();
                    if (jsonValue8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf3 = (Boolean) jsonValue8;
                }
            }
            boolean zBooleanValue3 = boolValueOf3 != null ? boolValueOf3.booleanValue() : false;
            JsonValue jsonValue9 = json.get("loop");
            if (jsonValue9 == null) {
                z = false;
            } else {
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString9 = jsonValue9.optString();
                    if (objOptString9 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf4 = (Boolean) objOptString9;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString10 = jsonValue9.optString();
                    if (objOptString10 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf4 = (Boolean) objOptString10;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf4 = Boolean.valueOf(jsonValue9.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf4 = (Boolean) Long.valueOf(jsonValue9.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf4 = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf4 = (Boolean) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf4 = (Boolean) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        z = false;
                        bool = (Boolean) Integer.valueOf(jsonValue9.getInt(0));
                    } else {
                        z = false;
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            bool = (Boolean) Integer.valueOf(jsonValue9.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            bool = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList5 = jsonValue9.optList();
                            if (objOptList5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            bool = (Boolean) objOptList5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap5 = jsonValue9.optMap();
                            if (objOptMap5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            bool = (Boolean) objOptMap5;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str + Boolean.class.getSimpleName() + "' for field 'loop" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue10 = jsonValue9.getJsonValue();
                            if (jsonValue10 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            bool = (Boolean) jsonValue10;
                        }
                    }
                    bool2 = bool;
                }
                bool2 = boolValueOf4;
                z = false;
            }
            return new Video(d, zBooleanValue, zBooleanValue2, zBooleanValue3, bool2 != null ? bool2.booleanValue() : z);
        }
    }
}
