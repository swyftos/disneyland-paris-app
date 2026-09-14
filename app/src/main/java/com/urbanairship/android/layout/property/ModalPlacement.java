package com.urbanairship.android.layout.property;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.model.SafeAreaAware;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\b\u0010#\u001a\u00020\u000bH\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006%"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/ModalPlacement;", "Lcom/urbanairship/android/layout/model/SafeAreaAware;", TCEventPropertiesNames.TCP_SIZE, "Lcom/urbanairship/android/layout/property/ConstrainedSize;", ViewProps.MARGIN, "Lcom/urbanairship/android/layout/property/Margin;", ViewProps.POSITION, "Lcom/urbanairship/android/layout/property/Position;", "shadeColor", "Lcom/urbanairship/android/layout/property/Color;", "ignoreSafeArea", "", "orientationLock", "Lcom/urbanairship/android/layout/property/Orientation;", "border", "Lcom/urbanairship/android/layout/property/Border;", ViewProps.BACKGROUND_COLOR, "shadow", "Lcom/urbanairship/android/layout/property/Shadow;", "(Lcom/urbanairship/android/layout/property/ConstrainedSize;Lcom/urbanairship/android/layout/property/Margin;Lcom/urbanairship/android/layout/property/Position;Lcom/urbanairship/android/layout/property/Color;ZLcom/urbanairship/android/layout/property/Orientation;Lcom/urbanairship/android/layout/property/Border;Lcom/urbanairship/android/layout/property/Color;Lcom/urbanairship/android/layout/property/Shadow;)V", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "getMargin", "()Lcom/urbanairship/android/layout/property/Margin;", "getOrientationLock", "()Lcom/urbanairship/android/layout/property/Orientation;", "getPosition", "()Lcom/urbanairship/android/layout/property/Position;", "getShadeColor", "getShadow", "()Lcom/urbanairship/android/layout/property/Shadow;", "getSize", "()Lcom/urbanairship/android/layout/property/ConstrainedSize;", "shouldIgnoreSafeArea", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ModalPlacement implements SafeAreaAware {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Color backgroundColor;
    private final Border border;
    private final boolean ignoreSafeArea;
    private final Margin margin;
    private final Orientation orientationLock;
    private final Position position;
    private final Color shadeColor;
    private final Shadow shadow;
    private final ConstrainedSize size;

    @JvmStatic
    @NotNull
    public static final ModalPlacement fromJson(@NotNull JsonMap jsonMap) throws JsonException {
        return INSTANCE.fromJson(jsonMap);
    }

    public ModalPlacement(@NotNull ConstrainedSize size, @Nullable Margin margin, @Nullable Position position, @Nullable Color color, boolean z, @Nullable Orientation orientation, @Nullable Border border, @Nullable Color color2, @Nullable Shadow shadow) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.size = size;
        this.margin = margin;
        this.position = position;
        this.shadeColor = color;
        this.ignoreSafeArea = z;
        this.orientationLock = orientation;
        this.border = border;
        this.backgroundColor = color2;
        this.shadow = shadow;
    }

    @NotNull
    public final ConstrainedSize getSize() {
        return this.size;
    }

    @Nullable
    public final Margin getMargin() {
        return this.margin;
    }

    @Nullable
    public final Position getPosition() {
        return this.position;
    }

    @Nullable
    public final Color getShadeColor() {
        return this.shadeColor;
    }

    @Nullable
    public final Orientation getOrientationLock() {
        return this.orientationLock;
    }

    @Nullable
    public final Border getBorder() {
        return this.border;
    }

    @Nullable
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.shadow;
    }

    @Override // com.urbanairship.android.layout.model.SafeAreaAware
    /* JADX INFO: renamed from: shouldIgnoreSafeArea, reason: from getter */
    public boolean getIgnoreSafeArea() {
        return this.ignoreSafeArea;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/ModalPlacement$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ModalPlacement;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nModalPlacement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModalPlacement.kt\ncom/urbanairship/android/layout/property/ModalPlacement$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n44#2,15:70\n79#2,16:86\n1#3:85\n1549#4:102\n1620#4,3:103\n223#4,2:106\n*S KotlinDebug\n*F\n+ 1 ModalPlacement.kt\ncom/urbanairship/android/layout/property/ModalPlacement$Companion\n*L\n37#1:70,15\n44#1:86,16\n48#1:102\n48#1:103,3\n50#1:106,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:146:0x0339  */
        /* JADX WARN: Code duplicated, block: B:163:0x0399  */
        /* JADX WARN: Code duplicated, block: B:166:0x03a6  */
        @JvmStatic
        @NotNull
        public final ModalPlacement fromJson(@NotNull JsonMap json) throws JsonException {
            JsonMap jsonMapOptMap;
            Orientation orientationFrom;
            Shadow shadow;
            Shadow shadow2;
            ShadowSelector shadowSelector;
            String strOptString;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get(TCEventPropertiesNames.TCP_SIZE);
            if (jsonValue == null) {
                throw new JsonException("Missing required field: '" + TCEventPropertiesNames.TCP_SIZE + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue.optList();
                if (jsonSerializableOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap = jsonValue.optMap();
                if (jsonMapOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + TCEventPropertiesNames.TCP_SIZE + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                JsonSerializable jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonValue2;
            }
            ConstrainedSize constrainedSizeFromJson = ConstrainedSize.fromJson(jsonMapOptMap);
            Intrinsics.checkNotNullExpressionValue(constrainedSizeFromJson, "fromJson(...)");
            JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(json, ViewProps.POSITION);
            Position positionFromJson = jsonMapOptionalMap != null ? Position.fromJson(jsonMapOptionalMap) : null;
            JsonMap jsonMapOptionalMap2 = JsonExtensionsKt.optionalMap(json, ViewProps.MARGIN);
            Margin marginFromJson = jsonMapOptionalMap2 != null ? Margin.fromJson(jsonMapOptionalMap2) : null;
            JsonMap jsonMapOptionalMap3 = JsonExtensionsKt.optionalMap(json, "border");
            Border borderFromJson = jsonMapOptionalMap3 != null ? Border.INSTANCE.fromJson(jsonMapOptionalMap3) : null;
            JsonMap jsonMapOptionalMap4 = JsonExtensionsKt.optionalMap(json, "background_color");
            Color colorFromJson = jsonMapOptionalMap4 != null ? Color.fromJson(jsonMapOptionalMap4) : null;
            JsonMap jsonMapOptionalMap5 = JsonExtensionsKt.optionalMap(json, "shade_color");
            Color colorFromJson2 = jsonMapOptionalMap5 != null ? Color.fromJson(jsonMapOptionalMap5) : null;
            JsonMap jsonMapOptionalMap6 = JsonExtensionsKt.optionalMap(json, "device");
            if (jsonMapOptionalMap6 == null) {
                orientationFrom = null;
            } else {
                JsonValue jsonValue3 = jsonMapOptionalMap6.get("lock_orientation");
                if (jsonValue3 == null) {
                    strOptString = null;
                } else {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
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
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue3.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue3.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'lock_orientation" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue4 = jsonValue3.getJsonValue();
                        if (jsonValue4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue4;
                    }
                }
                if (strOptString != null) {
                    orientationFrom = Orientation.from(strOptString);
                } else {
                    orientationFrom = null;
                }
            }
            boolean zIgnoreSafeAreaFromJson = SafeAreaAware.INSTANCE.ignoreSafeAreaFromJson(json);
            JsonMap jsonMapOptionalMap7 = JsonExtensionsKt.optionalMap(json, "shadow");
            if (jsonMapOptionalMap7 != null) {
                JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(jsonMapOptionalMap7, "selectors");
                if (jsonListOptionalList != null) {
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
                    for (JsonValue jsonValue5 : jsonListOptionalList) {
                        ShadowSelector.Companion companion = ShadowSelector.INSTANCE;
                        Intrinsics.checkNotNull(jsonValue5);
                        arrayList.add(companion.fromJson(jsonValue5));
                    }
                    Iterator it = arrayList.iterator();
                    do {
                        if (!it.hasNext()) {
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        shadowSelector = (ShadowSelector) it.next();
                        if (shadowSelector.getPlatform() != null) {
                        }
                        if (shadowSelector != null) {
                            shadow2 = shadowSelector.getShadow();
                        } else {
                            shadow2 = null;
                        }
                    } while (shadowSelector.getPlatform() != Platform.ANDROID);
                    if (shadowSelector != null) {
                        shadow2 = shadowSelector.getShadow();
                    } else {
                        shadow2 = null;
                    }
                } else {
                    shadow2 = null;
                }
                shadow = shadow2;
            } else {
                shadow = null;
            }
            return new ModalPlacement(constrainedSizeFromJson, marginFromJson, positionFromJson, colorFromJson2, zIgnoreSafeAreaFromJson, orientationFrom, borderFromJson, colorFromJson, shadow);
        }
    }
}
