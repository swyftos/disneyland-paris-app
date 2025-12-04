package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Shader;
import androidx.camera.video.AudioStats;
import com.BV.LinearGradient.LinearGradientManager;
import com.contentsquare.android.api.Currencies;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0016H\u0002J,\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J3\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010!J!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002¢\u0006\u0002\u0010%J!\u0010&\u001a\u0004\u0018\u00010\u00132\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient;", "", "directionMap", "Lcom/facebook/react/bridge/ReadableMap;", "colorStopsArray", "Lcom/facebook/react/bridge/ReadableArray;", "context", "Landroid/content/Context;", "<init>", "(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/bridge/ReadableArray;Landroid/content/Context;)V", "direction", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "colorStops", "Ljava/util/ArrayList;", "Lcom/facebook/react/uimanager/style/ColorStop;", "Lkotlin/collections/ArrayList;", "getShader", "Landroid/graphics/Shader;", "width", "", "height", "getAngleForKeyword", "", "keyword", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keywords;", "endPointsFromAngle", "Lkotlin/Pair;", "", LinearGradientManager.PROP_ANGLE, "getFixedColorStops", "", "Lcom/facebook/react/uimanager/style/ProcessedColorStop;", "gradientLineLength", "(Ljava/util/ArrayList;F)[Lcom/facebook/react/uimanager/style/ProcessedColorStop;", "processColorTransitionHints", "", "originalStops", "([Lcom/facebook/react/uimanager/style/ProcessedColorStop;)Ljava/util/List;", "resolveColorStopPosition", ViewProps.POSITION, "Lcom/facebook/react/uimanager/LengthPercentage;", "(Lcom/facebook/react/uimanager/LengthPercentage;F)Ljava/lang/Float;", "Direction", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLinearGradient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinearGradient.kt\ncom/facebook/react/uimanager/style/LinearGradient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n1872#2,3:365\n1#3:368\n*S KotlinDebug\n*F\n+ 1 LinearGradient.kt\ncom/facebook/react/uimanager/style/LinearGradient\n*L\n111#1:365,3\n*E\n"})
/* loaded from: classes3.dex */
public final class LinearGradient {

    @NotNull
    private final ArrayList<ColorStop> colorStops;

    @NotNull
    private final ReadableArray colorStopsArray;

    @NotNull
    private final Context context;

    @NotNull
    private final Direction direction;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Direction.Keywords.values().length];
            try {
                iArr[Direction.Keywords.TO_TOP_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.Keywords.TO_BOTTOM_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.Keywords.TO_TOP_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.Keywords.TO_BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LengthPercentageType.values().length];
            try {
                iArr2[LengthPercentageType.POINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[LengthPercentageType.PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public LinearGradient(@NotNull ReadableMap directionMap, @NotNull ReadableArray colorStopsArray, @NotNull Context context) {
        Direction.Keywords keywords;
        Direction keyword;
        Intrinsics.checkNotNullParameter(directionMap, "directionMap");
        Intrinsics.checkNotNullParameter(colorStopsArray, "colorStopsArray");
        Intrinsics.checkNotNullParameter(context, "context");
        this.colorStopsArray = colorStopsArray;
        this.context = context;
        String string = directionMap.getString("type");
        if (!Intrinsics.areEqual(string, LinearGradientManager.PROP_ANGLE)) {
            if (!Intrinsics.areEqual(string, "keyword")) {
                throw new IllegalArgumentException("Invalid direction type: " + string);
            }
            String string2 = directionMap.getString("value");
            if (string2 != null) {
                switch (string2.hashCode()) {
                    case -1849920841:
                        if (string2.equals("to bottom left")) {
                            keywords = Direction.Keywords.TO_BOTTOM_LEFT;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                    case -1507310228:
                        if (string2.equals("to bottom right")) {
                            keywords = Direction.Keywords.TO_BOTTOM_RIGHT;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                    case -1359525897:
                        if (string2.equals("to top left")) {
                            keywords = Direction.Keywords.TO_TOP_LEFT;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                    case 810031148:
                        if (string2.equals("to top right")) {
                            keywords = Direction.Keywords.TO_TOP_RIGHT;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                }
            }
            throw new IllegalArgumentException("Invalid linear gradient direction keyword: " + directionMap.getString("value"));
        }
        keyword = new Direction.Angle(directionMap.getDouble("value"));
        this.direction = keyword;
        ArrayList<ColorStop> arrayList = new ArrayList<>(colorStopsArray.size());
        int size = colorStopsArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = this.colorStopsArray.getMap(i);
            if (map != null) {
                arrayList.add(new ColorStop((!map.hasKey("color") || map.isNull("color")) ? null : map.getType("color") == ReadableType.Map ? ColorPropConverter.getColor(map.getMap("color"), this.context) : Integer.valueOf(map.getInt("color")), LengthPercentage.INSTANCE.setFromDynamic(map.getDynamic(ViewProps.POSITION))));
            }
        }
        this.colorStops = arrayList;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "", "<init>", "()V", "Angle", "Keywords", "Keyword", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Angle;", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keyword;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static abstract class Direction {
        public /* synthetic */ Direction(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Angle;", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "value", "", "<init>", "(D)V", "getValue", "()D", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Angle extends Direction {
            private final double value;

            public static /* synthetic */ Angle copy$default(Angle angle, double d, int i, Object obj) {
                if ((i & 1) != 0) {
                    d = angle.value;
                }
                return angle.copy(d);
            }

            /* renamed from: component1, reason: from getter */
            public final double getValue() {
                return this.value;
            }

            @NotNull
            public final Angle copy(double value) {
                return new Angle(value);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Angle) && Double.compare(this.value, ((Angle) other).value) == 0;
            }

            public int hashCode() {
                return Double.hashCode(this.value);
            }

            @NotNull
            public String toString() {
                return "Angle(value=" + this.value + ")";
            }

            public Angle(double d) {
                super(null);
                this.value = d;
            }

            public final double getValue() {
                return this.value;
            }
        }

        private Direction() {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keywords;", "", "<init>", "(Ljava/lang/String;I)V", "TO_TOP_RIGHT", "TO_BOTTOM_RIGHT", "TO_TOP_LEFT", "TO_BOTTOM_LEFT", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Keywords {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Keywords[] $VALUES;
            public static final Keywords TO_TOP_RIGHT = new Keywords("TO_TOP_RIGHT", 0);
            public static final Keywords TO_BOTTOM_RIGHT = new Keywords("TO_BOTTOM_RIGHT", 1);
            public static final Keywords TO_TOP_LEFT = new Keywords("TO_TOP_LEFT", 2);
            public static final Keywords TO_BOTTOM_LEFT = new Keywords("TO_BOTTOM_LEFT", 3);

            private static final /* synthetic */ Keywords[] $values() {
                return new Keywords[]{TO_TOP_RIGHT, TO_BOTTOM_RIGHT, TO_TOP_LEFT, TO_BOTTOM_LEFT};
            }

            @NotNull
            public static EnumEntries<Keywords> getEntries() {
                return $ENTRIES;
            }

            private Keywords(String str, int i) {
            }

            static {
                Keywords[] keywordsArr$values = $values();
                $VALUES = keywordsArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(keywordsArr$values);
            }

            public static Keywords valueOf(String str) {
                return (Keywords) Enum.valueOf(Keywords.class, str);
            }

            public static Keywords[] values() {
                return (Keywords[]) $VALUES.clone();
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keyword;", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "value", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keywords;", "<init>", "(Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keywords;)V", "getValue", "()Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keywords;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Keyword extends Direction {

            @NotNull
            private final Keywords value;

            public static /* synthetic */ Keyword copy$default(Keyword keyword, Keywords keywords, int i, Object obj) {
                if ((i & 1) != 0) {
                    keywords = keyword.value;
                }
                return keyword.copy(keywords);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Keywords getValue() {
                return this.value;
            }

            @NotNull
            public final Keyword copy(@NotNull Keywords value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Keyword(value);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Keyword) && this.value == ((Keyword) other).value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            @NotNull
            public String toString() {
                return "Keyword(value=" + this.value + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Keyword(@NotNull Keywords value) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            @NotNull
            public final Keywords getValue() {
                return this.value;
            }
        }
    }

    @NotNull
    public final Shader getShader(float width, float height) {
        double angleForKeyword;
        Direction direction = this.direction;
        if (direction instanceof Direction.Angle) {
            angleForKeyword = ((Direction.Angle) direction).getValue();
        } else {
            if (!(direction instanceof Direction.Keyword)) {
                throw new NoWhenBranchMatchedException();
            }
            angleForKeyword = getAngleForKeyword(((Direction.Keyword) direction).getValue(), width, height);
        }
        Pair<float[], float[]> pairEndPointsFromAngle = endPointsFromAngle(angleForKeyword, height, width);
        float[] fArrComponent1 = pairEndPointsFromAngle.component1();
        float[] fArrComponent2 = pairEndPointsFromAngle.component2();
        float f = fArrComponent2[0] - fArrComponent1[0];
        float f2 = fArrComponent2[1] - fArrComponent1[1];
        List<ProcessedColorStop> listProcessColorTransitionHints = processColorTransitionHints(getFixedColorStops(this.colorStops, (float) Math.sqrt((f * f) + (f2 * f2))));
        int[] iArr = new int[listProcessColorTransitionHints.size()];
        float[] fArr = new float[listProcessColorTransitionHints.size()];
        int i = 0;
        for (Object obj : listProcessColorTransitionHints) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProcessedColorStop processedColorStop = (ProcessedColorStop) obj;
            Integer color = processedColorStop.getColor();
            if (color != null && processedColorStop.getPosition() != null) {
                iArr[i] = color.intValue();
                fArr[i] = processedColorStop.getPosition().floatValue();
            }
            i = i2;
        }
        return new android.graphics.LinearGradient(fArrComponent1[0], fArrComponent1[1], fArrComponent2[0], fArrComponent2[1], iArr, fArr, Shader.TileMode.CLAMP);
    }

    private final double getAngleForKeyword(Direction.Keywords keyword, double width, double height) {
        double degrees;
        double d;
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[keyword.ordinal()];
        if (i2 == 1) {
            return 90 - Math.toDegrees(Math.atan(width / height));
        }
        if (i2 != 2) {
            if (i2 == 3) {
                degrees = Math.toDegrees(Math.atan(width / height));
                i = 270;
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                degrees = Math.toDegrees(Math.atan(height / width));
                i = RotationOptions.ROTATE_180;
            }
            d = i;
        } else {
            degrees = Math.toDegrees(Math.atan(width / height));
            d = 90;
        }
        return degrees + d;
    }

    private final Pair<float[], float[]> endPointsFromAngle(double angle, float height, float width) {
        float[] fArr;
        double d = Currencies.IDR;
        double d2 = angle % d;
        if (d2 < AudioStats.AUDIO_AMPLITUDE_NONE) {
            d2 += d;
        }
        if (d2 == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return new Pair<>(new float[]{BitmapDescriptorFactory.HUE_RED, height}, new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED});
        }
        if (d2 == 90.0d) {
            return new Pair<>(new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, new float[]{width, BitmapDescriptorFactory.HUE_RED});
        }
        if (d2 == 180.0d) {
            return new Pair<>(new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED}, new float[]{BitmapDescriptorFactory.HUE_RED, height});
        }
        if (d2 == 270.0d) {
            return new Pair<>(new float[]{width, BitmapDescriptorFactory.HUE_RED}, new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED});
        }
        float fTan = (float) Math.tan(Math.toRadians(90 - d2));
        float f = (-1) / fTan;
        float f2 = 2;
        float f3 = height / f2;
        float f4 = width / f2;
        if (d2 < 90.0d) {
            fArr = new float[]{f4, f3};
        } else if (d2 < 180.0d) {
            fArr = new float[]{f4, -f3};
        } else if (d2 < 270.0d) {
            fArr = new float[]{-f4, -f3};
        } else {
            fArr = new float[]{-f4, f3};
        }
        float f5 = fArr[1] - (fArr[0] * f);
        float f6 = f5 / (fTan - f);
        float f7 = (f * f6) + f5;
        return new Pair<>(new float[]{f4 - f6, f3 + f7}, new float[]{f4 + f6, f3 - f7});
    }

    private final ProcessedColorStop[] getFixedColorStops(ArrayList<ColorStop> colorStops, float gradientLineLength) {
        Float position;
        int size = colorStops.size();
        ProcessedColorStop[] processedColorStopArr = new ProcessedColorStop[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            processedColorStopArr[i2] = new ProcessedColorStop(null, null, 3, null);
        }
        Float fResolveColorStopPosition = resolveColorStopPosition(colorStops.get(0).getPosition(), gradientLineLength);
        float fFloatValue = fResolveColorStopPosition != null ? fResolveColorStopPosition.floatValue() : 0.0f;
        int size2 = colorStops.size();
        int i3 = 0;
        boolean z = false;
        while (i3 < size2) {
            ColorStop colorStop = colorStops.get(i3);
            Intrinsics.checkNotNullExpressionValue(colorStop, "get(...)");
            ColorStop colorStop2 = colorStop;
            Float fResolveColorStopPosition2 = resolveColorStopPosition(colorStop2.getPosition(), gradientLineLength);
            if (fResolveColorStopPosition2 == null) {
                if (i3 == 0) {
                    fResolveColorStopPosition2 = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
                } else {
                    fResolveColorStopPosition2 = i3 == colorStops.size() - 1 ? Float.valueOf(1.0f) : null;
                }
            }
            if (fResolveColorStopPosition2 != null) {
                fFloatValue = Math.max(fResolveColorStopPosition2.floatValue(), fFloatValue);
                processedColorStopArr[i3] = new ProcessedColorStop(colorStop2.getColor(), Float.valueOf(fFloatValue));
            } else {
                z = true;
            }
            i3++;
        }
        if (z) {
            for (int i4 = 1; i4 < size; i4++) {
                Float position2 = processedColorStopArr[i4].getPosition();
                if (position2 != null) {
                    int i5 = i4 - i;
                    int i6 = i5 - 1;
                    if (i6 > 0 && (position = processedColorStopArr[i].getPosition()) != null) {
                        float fFloatValue2 = (position2.floatValue() - position.floatValue()) / i5;
                        if (1 <= i6) {
                            int i7 = 1;
                            while (true) {
                                int i8 = i + i7;
                                processedColorStopArr[i8] = new ProcessedColorStop(colorStops.get(i8).getColor(), Float.valueOf(position.floatValue() + (i7 * fFloatValue2)));
                                if (i7 == i6) {
                                    break;
                                }
                                i7++;
                            }
                        }
                    }
                    i = i4;
                }
            }
        }
        return processedColorStopArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[PHI: r6
  0x007e: PHI (r6v2 int) = (r6v1 int), (r6v1 int), (r6v1 int), (r6v1 int), (r6v1 int), (r6v1 int), (r6v1 int), (r6v5 int) binds: [B:5:0x0013, B:8:0x0018, B:11:0x003d, B:12:0x003f, B:13:0x0041, B:24:0x0099, B:21:0x0089, B:17:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<com.facebook.react.uimanager.style.ProcessedColorStop> processColorTransitionHints(com.facebook.react.uimanager.style.ProcessedColorStop[] r22) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.style.LinearGradient.processColorTransitionHints(com.facebook.react.uimanager.style.ProcessedColorStop[]):java.util.List");
    }

    private final Float resolveColorStopPosition(LengthPercentage position, float gradientLineLength) {
        if (position == null) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[position.getType().ordinal()];
        if (i == 1) {
            return Float.valueOf(PixelUtil.toPixelFromDIP(position.resolve(BitmapDescriptorFactory.HUE_RED)) / gradientLineLength);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return Float.valueOf(position.resolve(1.0f));
    }
}
