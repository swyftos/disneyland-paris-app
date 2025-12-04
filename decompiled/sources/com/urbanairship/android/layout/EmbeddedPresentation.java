package com.urbanairship.android.layout;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.urbanairship.android.layout.property.EmbeddedPlacement;
import com.urbanairship.android.layout.property.EmbeddedPlacementSelector;
import com.urbanairship.android.layout.property.Orientation;
import com.urbanairship.android.layout.property.PresentationType;
import com.urbanairship.android.layout.property.WindowSize;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/EmbeddedPresentation;", "Lcom/urbanairship/android/layout/BasePresentation;", "defaultPlacement", "Lcom/urbanairship/android/layout/property/EmbeddedPlacement;", "placementSelectors", "", "Lcom/urbanairship/android/layout/property/EmbeddedPlacementSelector;", "embeddedId", "", "(Lcom/urbanairship/android/layout/property/EmbeddedPlacement;Ljava/util/List;Ljava/lang/String;)V", "getEmbeddedId", "()Ljava/lang/String;", "getResolvedPlacement", "context", "Landroid/content/Context;", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class EmbeddedPresentation extends BasePresentation {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final EmbeddedPlacement defaultPlacement;
    private final String embeddedId;
    private final List placementSelectors;

    @JvmStatic
    @NotNull
    public static final EmbeddedPresentation fromJson(@NotNull JsonMap jsonMap) throws JsonException {
        return INSTANCE.fromJson(jsonMap);
    }

    @NotNull
    public final String getEmbeddedId() {
        return this.embeddedId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddedPresentation(@NotNull EmbeddedPlacement defaultPlacement, @Nullable List<EmbeddedPlacementSelector> list, @NotNull String embeddedId) {
        super(PresentationType.EMBEDDED);
        Intrinsics.checkNotNullParameter(defaultPlacement, "defaultPlacement");
        Intrinsics.checkNotNullParameter(embeddedId, "embeddedId");
        this.defaultPlacement = defaultPlacement;
        this.placementSelectors = list;
        this.embeddedId = embeddedId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final EmbeddedPlacement getResolvedPlacement(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List list = this.placementSelectors;
        if (list == null || list.isEmpty()) {
            return this.defaultPlacement;
        }
        Orientation orientation = ResourceUtils.getOrientation(context);
        WindowSize windowSize = ResourceUtils.getWindowSize(context);
        for (EmbeddedPlacementSelector embeddedPlacementSelector : this.placementSelectors) {
            if (embeddedPlacementSelector.getWindowSize() == null || embeddedPlacementSelector.getWindowSize() == windowSize) {
                if (embeddedPlacementSelector.getOrientation() == null || embeddedPlacementSelector.getOrientation() == orientation) {
                    return embeddedPlacementSelector.getPlacement();
                }
            }
        }
        return this.defaultPlacement;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/EmbeddedPresentation$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/EmbeddedPresentation;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final EmbeddedPresentation fromJson(@NotNull JsonMap json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            String string = json.opt("embedded_id").getString();
            if (string == null) {
                throw new JsonException("Failed to parse EmbeddedPresentation! Field 'embedded_id' is required.");
            }
            JsonMap map = json.opt("default_placement").getMap();
            if (map == null) {
                throw new JsonException("Failed to parse EmbeddedPresentation! Field 'default_placement' is required.");
            }
            JsonList list = json.opt("placement_selectors").getList();
            return new EmbeddedPresentation(EmbeddedPlacement.INSTANCE.fromJson(map), list != null ? EmbeddedPlacementSelector.INSTANCE.fromJsonList(list) : null, string);
        }
    }
}
