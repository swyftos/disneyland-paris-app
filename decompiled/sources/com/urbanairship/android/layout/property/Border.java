package com.urbanairship.android.layout.property;

import android.os.Build;
import androidx.annotation.Dimension;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.urbanairship.android.layout.widget.Clippable;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013H\u0007J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013H\u0007J\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013H\u0007J\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013H\u0007R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/property/Border;", "", "radius", "", "strokeWidth", "strokeColor", "Lcom/urbanairship/android/layout/property/Color;", "cornerRadius", "Lcom/urbanairship/android/layout/property/Border$CornerRadius;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/urbanairship/android/layout/property/Color;Lcom/urbanairship/android/layout/property/Border$CornerRadius;)V", "innerRadius", "getInnerRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "applyToClippable", "", "view", "Lcom/urbanairship/android/layout/widget/Clippable;", "toPxConverter", "Lkotlin/Function1;", "", "applyToShape", "", "shape", "Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;", "innerRadii", "", "radii", "Companion", "CornerRadius", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Border {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @Nullable
    public final CornerRadius cornerRadius;

    @JvmField
    @Nullable
    public final Integer radius;

    @JvmField
    @Nullable
    public final Color strokeColor;

    @JvmField
    @Nullable
    public final Integer strokeWidth;

    @JvmStatic
    @NotNull
    public static final Border fromJson(@NotNull JsonMap jsonMap) throws JsonException {
        return INSTANCE.fromJson(jsonMap);
    }

    public Border(@Nullable Integer num, @Nullable Integer num2, @Nullable Color color, @Nullable CornerRadius cornerRadius) {
        this.radius = num;
        this.strokeWidth = num2;
        this.strokeColor = color;
        this.cornerRadius = cornerRadius;
    }

    public /* synthetic */ Border(Integer num, Integer num2, Color color, CornerRadius cornerRadius, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, color, (i & 8) != 0 ? null : cornerRadius);
    }

    @Dimension(unit = 0)
    @Nullable
    public final Integer getInnerRadius() {
        Integer num;
        Integer num2 = this.strokeWidth;
        if (num2 == null || num2.intValue() <= 0 || (num = this.radius) == null || num.intValue() <= this.strokeWidth.intValue()) {
            return null;
        }
        return Integer.valueOf(this.radius.intValue() - this.strokeWidth.intValue());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final float[] innerRadii(@NotNull Function1<? super Integer, Float> toPxConverter) {
        Integer num;
        Intrinsics.checkNotNullParameter(toPxConverter, "toPxConverter");
        float[] fArrRadii = radii(toPxConverter);
        if (fArrRadii == null || (num = this.strokeWidth) == null || num.intValue() <= 0) {
            return null;
        }
        float fFloatValue = toPxConverter.invoke(this.strokeWidth).floatValue();
        int length = fArrRadii.length;
        for (int i = 0; i < length; i++) {
            fArrRadii[i] = Math.max(BitmapDescriptorFactory.HUE_RED, fArrRadii[i] - fFloatValue);
        }
        return fArrRadii;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final float[] radii(@NotNull Function1<? super Integer, Float> toPxConverter) {
        float[] radii$urbanairship_layout_release;
        Intrinsics.checkNotNullParameter(toPxConverter, "toPxConverter");
        CornerRadius cornerRadius = this.cornerRadius;
        if (cornerRadius != null && (radii$urbanairship_layout_release = cornerRadius.getRadii$urbanairship_layout_release(toPxConverter)) != null) {
            return radii$urbanairship_layout_release;
        }
        Integer num = this.radius;
        if (num == null) {
            return null;
        }
        int iIntValue = num.intValue();
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = toPxConverter.invoke(Integer.valueOf(iIntValue)).floatValue();
        }
        return fArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean applyToShape(@NotNull ShapeAppearanceModel.Builder shape, @NotNull Function1<? super Integer, Integer> toPxConverter) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(toPxConverter, "toPxConverter");
        CornerRadius cornerRadius = this.cornerRadius;
        if (cornerRadius != null) {
            cornerRadius.applyToShape$urbanairship_layout_release(shape, toPxConverter);
        } else {
            if (this.radius != null) {
                shape.setAllCorners(0, toPxConverter.invoke(r0).intValue());
            }
        }
        return (this.radius == null && this.cornerRadius == null) ? false : true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void applyToClippable(@NotNull Clippable view, @NotNull Function1<? super Integer, Float> toPxConverter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(toPxConverter, "toPxConverter");
        CornerRadius cornerRadius = this.cornerRadius;
        if (cornerRadius != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                view.setClipPathBorderRadius(cornerRadius.getRadii$urbanairship_layout_release(toPxConverter));
                return;
            } else {
                view.setClipPathBorderRadius(cornerRadius.getMaxCornerRadius$urbanairship_layout_release() != null ? r2.intValue() : 0);
                return;
            }
        }
        Integer num = this.radius;
        if (num != null) {
            view.setClipPathBorderRadius(toPxConverter.invoke(num).floatValue());
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015H\u0000¢\u0006\u0002\b\u0016J!\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0015H\u0000¢\u0006\u0002\b\u001aR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/property/Border$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottomLeft", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBottomRight", "maxCornerRadius", "getMaxCornerRadius$urbanairship_layout_release", "getTopLeft", "getTopRight", "applyToShape", "", "shape", "Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;", "toPxConverter", "Lkotlin/Function1;", "applyToShape$urbanairship_layout_release", "getRadii", "", "", "getRadii$urbanairship_layout_release", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Border.kt\ncom/urbanairship/android/layout/property/Border$CornerRadius\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,159:1\n1#2:160\n1#2:171\n1603#3,9:161\n1855#3:170\n1856#3:172\n1612#3:173\n*S KotlinDebug\n*F\n+ 1 Border.kt\ncom/urbanairship/android/layout/property/Border$CornerRadius\n*L\n142#1:171\n142#1:161,9\n142#1:170\n142#1:172\n142#1:173\n*E\n"})
    public static final class CornerRadius {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Integer bottomLeft;
        private final Integer bottomRight;
        private final Integer topLeft;
        private final Integer topRight;

        public CornerRadius(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
            this.topLeft = num;
            this.topRight = num2;
            this.bottomLeft = num3;
            this.bottomRight = num4;
        }

        @Nullable
        public final Integer getTopLeft() {
            return this.topLeft;
        }

        @Nullable
        public final Integer getTopRight() {
            return this.topRight;
        }

        @Nullable
        public final Integer getBottomLeft() {
            return this.bottomLeft;
        }

        @Nullable
        public final Integer getBottomRight() {
            return this.bottomRight;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/layout/property/Border$CornerRadius$Companion;", "", "()V", "BOTTOM_LEFT", "", "BOTTOM_RIGHT", "TOP_LEFT", "TOP_RIGHT", "fromJson", "Lcom/urbanairship/android/layout/property/Border$CornerRadius;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nBorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Border.kt\ncom/urbanairship/android/layout/property/Border$CornerRadius$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,159:1\n79#2,16:160\n79#2,16:176\n79#2,16:192\n79#2,16:208\n*S KotlinDebug\n*F\n+ 1 Border.kt\ncom/urbanairship/android/layout/property/Border$CornerRadius$Companion\n*L\n105#1:160,16\n106#1:176,16\n107#1:192,16\n108#1:208,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final CornerRadius fromJson(@NotNull JsonValue value) throws JsonException {
                Integer numValueOf;
                Integer numValueOf2;
                Integer numValueOf3;
                Integer numValueOf4;
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("top_left");
                Integer num = null;
                if (jsonValue == null) {
                    numValueOf = null;
                } else {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        numValueOf = (Integer) jsonValue.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf = (Integer) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        numValueOf = (Integer) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        numValueOf = (Integer) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        numValueOf = (Integer) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf = Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        numValueOf = (Integer) jsonValue.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        numValueOf = (Integer) jsonValue.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'top_left" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        numValueOf = (Integer) jsonValue.toJsonValue();
                    }
                }
                JsonValue jsonValue2 = jsonMapRequireMap.get("top_right");
                if (jsonValue2 == null) {
                    numValueOf2 = null;
                } else {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        numValueOf2 = (Integer) jsonValue2.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf2 = (Integer) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        numValueOf2 = (Integer) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        numValueOf2 = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        numValueOf2 = (Integer) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        numValueOf2 = (Integer) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf2 = Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        numValueOf2 = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        numValueOf2 = (Integer) jsonValue2.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        numValueOf2 = (Integer) jsonValue2.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'top_right" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        numValueOf2 = (Integer) jsonValue2.toJsonValue();
                    }
                }
                JsonValue jsonValue3 = jsonMapRequireMap.get("bottom_left");
                if (jsonValue3 == null) {
                    numValueOf3 = null;
                } else {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        numValueOf3 = (Integer) jsonValue3.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf3 = (Integer) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        numValueOf3 = (Integer) Long.valueOf(jsonValue3.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        numValueOf3 = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        numValueOf3 = (Integer) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        numValueOf3 = (Integer) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf3 = Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        numValueOf3 = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        numValueOf3 = (Integer) jsonValue3.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        numValueOf3 = (Integer) jsonValue3.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'bottom_left" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        numValueOf3 = (Integer) jsonValue3.toJsonValue();
                    }
                }
                JsonValue jsonValue4 = jsonMapRequireMap.get("bottom_right");
                if (jsonValue4 != null) {
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        numValueOf4 = (Integer) jsonValue4.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf4 = (Integer) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        numValueOf4 = (Integer) Long.valueOf(jsonValue4.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        numValueOf4 = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        numValueOf4 = (Integer) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        numValueOf4 = (Integer) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf4 = Integer.valueOf(jsonValue4.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        numValueOf4 = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        numValueOf4 = (Integer) jsonValue4.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        numValueOf4 = (Integer) jsonValue4.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'bottom_right" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        numValueOf4 = (Integer) jsonValue4.toJsonValue();
                    }
                    num = numValueOf4;
                }
                return new CornerRadius(numValueOf, numValueOf2, numValueOf3, num);
            }
        }

        public final void applyToShape$urbanairship_layout_release(@NotNull ShapeAppearanceModel.Builder shape, @NotNull Function1<? super Integer, Integer> toPxConverter) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            Intrinsics.checkNotNullParameter(toPxConverter, "toPxConverter");
            if (this.topLeft != null) {
                shape.setTopLeftCornerSize(toPxConverter.invoke(Integer.valueOf(r0.intValue())).intValue());
            }
            if (this.topRight != null) {
                shape.setTopRightCornerSize(toPxConverter.invoke(Integer.valueOf(r0.intValue())).intValue());
            }
            if (this.bottomLeft != null) {
                shape.setBottomLeftCornerSize(toPxConverter.invoke(Integer.valueOf(r0.intValue())).intValue());
            }
            if (this.bottomRight != null) {
                shape.setBottomRightCornerSize(toPxConverter.invoke(Integer.valueOf(r1.intValue())).intValue());
            }
        }

        @NotNull
        public final float[] getRadii$urbanairship_layout_release(@NotNull final Function1<? super Integer, Float> toPxConverter) {
            Intrinsics.checkNotNullParameter(toPxConverter, "toPxConverter");
            final float[] fArr = new float[8];
            Function2 function2 = new Function2() { // from class: com.urbanairship.android.layout.property.Border$CornerRadius$getRadii$1$setCorner$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Integer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Integer num, int i) {
                    if (num == null) {
                        return;
                    }
                    float fFloatValue = ((Number) toPxConverter.invoke(num)).floatValue();
                    float[] fArr2 = fArr;
                    fArr2[i] = fFloatValue;
                    fArr2[i + 1] = fFloatValue;
                }
            };
            function2.invoke(this.topLeft, 0);
            function2.invoke(this.topRight, 2);
            function2.invoke(this.bottomRight, 4);
            function2.invoke(this.bottomLeft, 6);
            return fArr;
        }

        @Nullable
        public final Integer getMaxCornerRadius$urbanairship_layout_release() {
            List<Integer> listListOf = CollectionsKt.listOf((Object[]) new Integer[]{this.topLeft, this.topRight, this.bottomLeft, this.bottomRight});
            ArrayList arrayList = new ArrayList();
            for (Integer num : listListOf) {
                if (num != null) {
                    arrayList.add(num);
                }
            }
            return (Integer) CollectionsKt.maxOrNull((Iterable) arrayList);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/Border$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/Border;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBorder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Border.kt\ncom/urbanairship/android/layout/property/Border$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Border fromJson(@NotNull JsonMap json) throws JsonException {
            JsonMap jsonMapRequireMap;
            Intrinsics.checkNotNullParameter(json, "json");
            Integer integer = json.opt("radius").getInteger();
            Integer integer2 = json.opt("stroke_width").getInteger();
            JsonValue jsonValue = json.get("stroke_color");
            Color colorFromJson = (jsonValue == null || (jsonMapRequireMap = jsonValue.requireMap()) == null) ? null : Color.fromJson(jsonMapRequireMap);
            JsonValue jsonValue2 = json.get("corner_radius");
            return new Border(integer, integer2, colorFromJson, jsonValue2 != null ? CornerRadius.INSTANCE.fromJson(jsonValue2) : null);
        }
    }
}
