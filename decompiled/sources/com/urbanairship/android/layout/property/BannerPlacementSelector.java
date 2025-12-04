package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class BannerPlacementSelector {
    private final Orientation orientation;
    private final BannerPlacement placement;
    private final WindowSize windowSize;

    public BannerPlacementSelector(@NonNull BannerPlacement bannerPlacement, @Nullable WindowSize windowSize, @Nullable Orientation orientation) {
        this.placement = bannerPlacement;
        this.windowSize = windowSize;
        this.orientation = orientation;
    }

    @NonNull
    public static BannerPlacementSelector fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        JsonMap jsonMapOptMap = jsonMap.opt("placement").optMap();
        String strOptString = jsonMap.opt("window_size").optString();
        String strOptString2 = jsonMap.opt("orientation").optString();
        return new BannerPlacementSelector(BannerPlacement.fromJson(jsonMapOptMap), strOptString.isEmpty() ? null : WindowSize.from(strOptString), strOptString2.isEmpty() ? null : Orientation.from(strOptString2));
    }

    @NonNull
    public static List<BannerPlacementSelector> fromJsonList(@NonNull JsonList jsonList) throws JsonException {
        ArrayList arrayList = new ArrayList(jsonList.size());
        for (int i = 0; i < jsonList.size(); i++) {
            arrayList.add(fromJson(jsonList.get(i).optMap()));
        }
        return arrayList;
    }

    @NonNull
    public BannerPlacement getPlacement() {
        return this.placement;
    }

    @Nullable
    public WindowSize getWindowSize() {
        return this.windowSize;
    }

    @Nullable
    public Orientation getOrientation() {
        return this.orientation;
    }
}
