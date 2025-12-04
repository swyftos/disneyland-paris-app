package com.urbanairship.android.layout.property;

import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/property/EmbeddedPlacementSelector;", "", "placement", "Lcom/urbanairship/android/layout/property/EmbeddedPlacement;", "windowSize", "Lcom/urbanairship/android/layout/property/WindowSize;", "orientation", "Lcom/urbanairship/android/layout/property/Orientation;", "(Lcom/urbanairship/android/layout/property/EmbeddedPlacement;Lcom/urbanairship/android/layout/property/WindowSize;Lcom/urbanairship/android/layout/property/Orientation;)V", "getOrientation", "()Lcom/urbanairship/android/layout/property/Orientation;", "getPlacement", "()Lcom/urbanairship/android/layout/property/EmbeddedPlacement;", "getWindowSize", "()Lcom/urbanairship/android/layout/property/WindowSize;", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmbeddedPlacementSelector {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Orientation orientation;
    private final EmbeddedPlacement placement;
    private final WindowSize windowSize;

    public EmbeddedPlacementSelector(@NotNull EmbeddedPlacement placement, @Nullable WindowSize windowSize, @Nullable Orientation orientation) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.placement = placement;
        this.windowSize = windowSize;
        this.orientation = orientation;
    }

    @NotNull
    public final EmbeddedPlacement getPlacement() {
        return this.placement;
    }

    @Nullable
    public final WindowSize getWindowSize() {
        return this.windowSize;
    }

    @Nullable
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/EmbeddedPlacementSelector$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/EmbeddedPlacementSelector;", "json", "Lcom/urbanairship/json/JsonMap;", "fromJsonList", "", "Lcom/urbanairship/json/JsonList;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nEmbeddedPlacementSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmbeddedPlacementSelector.kt\ncom/urbanairship/android/layout/property/EmbeddedPlacementSelector$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,32:1\n1603#2,9:33\n1855#2:42\n1856#2:44\n1612#2:45\n1#3:43\n*S KotlinDebug\n*F\n+ 1 EmbeddedPlacementSelector.kt\ncom/urbanairship/android/layout/property/EmbeddedPlacementSelector$Companion\n*L\n29#1:33,9\n29#1:42\n29#1:44\n29#1:45\n29#1:43\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final EmbeddedPlacementSelector fromJson(@NotNull JsonMap json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapOptMap = json.opt("placement").optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            String strOptString = json.opt("window_size").optString();
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strOptString2 = json.opt("orientation").optString();
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            return new EmbeddedPlacementSelector(EmbeddedPlacement.INSTANCE.fromJson(jsonMapOptMap), strOptString.length() == 0 ? null : WindowSize.from(strOptString), strOptString2.length() != 0 ? Orientation.from(strOptString2) : null);
        }

        @NotNull
        public final List<EmbeddedPlacementSelector> fromJsonList(@NotNull JsonList json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            ArrayList arrayList = new ArrayList();
            for (JsonValue jsonValue : json) {
                Companion companion = EmbeddedPlacementSelector.INSTANCE;
                JsonMap jsonMapOptMap = jsonValue.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                EmbeddedPlacementSelector embeddedPlacementSelectorFromJson = companion.fromJson(jsonMapOptMap);
                if (embeddedPlacementSelectorFromJson != null) {
                    arrayList.add(embeddedPlacementSelectorFromJson);
                }
            }
            return arrayList;
        }
    }
}
