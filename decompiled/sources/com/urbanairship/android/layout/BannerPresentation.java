package com.urbanairship.android.layout;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.property.BannerPlacement;
import com.urbanairship.android.layout.property.BannerPlacementSelector;
import com.urbanairship.android.layout.property.Orientation;
import com.urbanairship.android.layout.property.PresentationType;
import com.urbanairship.android.layout.property.WindowSize;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import java.util.List;

/* loaded from: classes5.dex */
public class BannerPresentation extends BasePresentation {
    private final BannerPlacement defaultPlacement;
    private final int durationMs;
    private final List placementSelectors;

    public BannerPresentation(@NonNull BannerPlacement bannerPlacement, int i, @Nullable List<BannerPlacementSelector> list) {
        super(PresentationType.BANNER);
        this.defaultPlacement = bannerPlacement;
        this.durationMs = i;
        this.placementSelectors = list;
    }

    @NonNull
    public static BannerPresentation fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        JsonMap jsonMapOptMap = jsonMap.opt("default_placement").optMap();
        if (jsonMapOptMap.isEmpty()) {
            throw new JsonException("Failed to parse BannerPresentation! Field 'default_placement' is required.");
        }
        int i = jsonMap.opt("duration_milliseconds").getInt(7000);
        JsonList jsonListOptList = jsonMap.opt("placement_selectors").optList();
        return new BannerPresentation(BannerPlacement.fromJson(jsonMapOptMap), i, jsonListOptList.isEmpty() ? null : BannerPlacementSelector.fromJsonList(jsonListOptList));
    }

    @NonNull
    public BannerPlacement getDefaultPlacement() {
        return this.defaultPlacement;
    }

    public int getDurationMs() {
        return this.durationMs;
    }

    @Nullable
    public List<BannerPlacementSelector> getPlacementSelectors() {
        return this.placementSelectors;
    }

    @NonNull
    public BannerPlacement getResolvedPlacement(@NonNull Context context) {
        List list = this.placementSelectors;
        if (list == null || list.isEmpty()) {
            return this.defaultPlacement;
        }
        Orientation orientation = ResourceUtils.getOrientation(context);
        WindowSize windowSize = ResourceUtils.getWindowSize(context);
        for (BannerPlacementSelector bannerPlacementSelector : this.placementSelectors) {
            if (bannerPlacementSelector.getWindowSize() == null || bannerPlacementSelector.getWindowSize() == windowSize) {
                if (bannerPlacementSelector.getOrientation() == null || bannerPlacementSelector.getOrientation() == orientation) {
                    return bannerPlacementSelector.getPlacement();
                }
            }
        }
        return this.defaultPlacement;
    }
}
