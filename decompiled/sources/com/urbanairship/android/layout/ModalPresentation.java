package com.urbanairship.android.layout;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.property.ModalPlacement;
import com.urbanairship.android.layout.property.ModalPlacementSelector;
import com.urbanairship.android.layout.property.Orientation;
import com.urbanairship.android.layout.property.PresentationType;
import com.urbanairship.android.layout.property.WindowSize;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import java.util.List;

/* loaded from: classes5.dex */
public class ModalPresentation extends BasePresentation {
    private final ModalPlacement defaultPlacement;
    private final boolean disableBackButton;
    private final boolean dismissOnTouchOutside;
    private final List placementSelectors;

    public ModalPresentation(@NonNull ModalPlacement modalPlacement, @Nullable List<ModalPlacementSelector> list, boolean z, boolean z2) {
        super(PresentationType.MODAL);
        this.defaultPlacement = modalPlacement;
        this.placementSelectors = list;
        this.dismissOnTouchOutside = z;
        this.disableBackButton = z2;
    }

    @NonNull
    public static ModalPresentation fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        JsonMap jsonMapOptMap = jsonMap.opt("default_placement").optMap();
        if (jsonMapOptMap.isEmpty()) {
            throw new JsonException("Failed to parse ModalPresentation! Field 'default_placement' is required.");
        }
        JsonList jsonListOptList = jsonMap.opt("placement_selectors").optList();
        return new ModalPresentation(ModalPlacement.fromJson(jsonMapOptMap), jsonListOptList.isEmpty() ? null : ModalPlacementSelector.fromJsonList(jsonListOptList), jsonMap.opt("dismiss_on_touch_outside").getBoolean(false), jsonMap.opt("android").optMap().opt("disable_back_button").getBoolean(false));
    }

    @NonNull
    public ModalPlacement getDefaultPlacement() {
        return this.defaultPlacement;
    }

    @Nullable
    public List<ModalPlacementSelector> getPlacementSelectors() {
        return this.placementSelectors;
    }

    public boolean isDismissOnTouchOutside() {
        return this.dismissOnTouchOutside;
    }

    public boolean isDisableBackButton() {
        return this.disableBackButton;
    }

    @NonNull
    public ModalPlacement getResolvedPlacement(@NonNull Context context) {
        List list = this.placementSelectors;
        if (list == null || list.isEmpty()) {
            return this.defaultPlacement;
        }
        Orientation orientation = ResourceUtils.getOrientation(context);
        WindowSize windowSize = ResourceUtils.getWindowSize(context);
        for (ModalPlacementSelector modalPlacementSelector : this.placementSelectors) {
            if (modalPlacementSelector.getWindowSize() == null || modalPlacementSelector.getWindowSize() == windowSize) {
                if (modalPlacementSelector.getOrientation() == null || modalPlacementSelector.getOrientation() == orientation) {
                    return modalPlacementSelector.getPlacement();
                }
            }
        }
        return this.defaultPlacement;
    }
}
