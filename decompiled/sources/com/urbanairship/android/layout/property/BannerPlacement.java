package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.model.SafeAreaAware;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;

/* loaded from: classes5.dex */
public class BannerPlacement implements SafeAreaAware {
    private final Color backgroundColor;
    private final Border border;
    private final boolean ignoreSafeArea;
    private final Margin margin;
    private final Position position;
    private final ConstrainedSize size;

    public BannerPlacement(@NonNull ConstrainedSize constrainedSize, @Nullable Margin margin, @Nullable Position position, boolean z, @Nullable Border border, @Nullable Color color) {
        this.size = constrainedSize;
        this.margin = margin;
        this.position = position;
        this.ignoreSafeArea = z;
        this.border = border;
        this.backgroundColor = color;
    }

    @NonNull
    public static BannerPlacement fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        JsonMap jsonMapOptMap = jsonMap.opt(TCEventPropertiesNames.TCP_SIZE).optMap();
        if (jsonMapOptMap.isEmpty()) {
            throw new JsonException("Failed to parse Modal Placement! Field 'size' is required.");
        }
        String strOptString = jsonMap.opt(ViewProps.POSITION).optString();
        JsonMap jsonMapOptMap2 = jsonMap.opt(ViewProps.MARGIN).optMap();
        JsonMap jsonMapOptMap3 = jsonMap.opt("border").optMap();
        JsonMap jsonMapOptMap4 = jsonMap.opt("background_color").optMap();
        return new BannerPlacement(ConstrainedSize.fromJson(jsonMapOptMap), jsonMapOptMap2.isEmpty() ? null : Margin.fromJson(jsonMapOptMap2), new Position(HorizontalPosition.CENTER, VerticalPosition.from(strOptString)), SafeAreaAware.ignoreSafeAreaFromJson(jsonMap), jsonMapOptMap3.isEmpty() ? null : Border.fromJson(jsonMapOptMap3), jsonMapOptMap4.isEmpty() ? null : Color.fromJson(jsonMapOptMap4));
    }

    @Nullable
    public Margin getMargin() {
        return this.margin;
    }

    @NonNull
    public ConstrainedSize getSize() {
        return this.size;
    }

    @Nullable
    public Position getPosition() {
        return this.position;
    }

    @Override // com.urbanairship.android.layout.model.SafeAreaAware
    public boolean shouldIgnoreSafeArea() {
        return this.ignoreSafeArea;
    }

    @Nullable
    public Border getBorder() {
        return this.border;
    }

    @Nullable
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }
}
