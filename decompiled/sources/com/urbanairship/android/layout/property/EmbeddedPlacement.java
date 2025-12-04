package com.urbanairship.android.layout.property;

import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/property/EmbeddedPlacement;", "", TCEventPropertiesNames.TCP_SIZE, "Lcom/urbanairship/android/layout/property/ConstrainedSize;", ViewProps.MARGIN, "Lcom/urbanairship/android/layout/property/Margin;", "border", "Lcom/urbanairship/android/layout/property/Border;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "(Lcom/urbanairship/android/layout/property/ConstrainedSize;Lcom/urbanairship/android/layout/property/Margin;Lcom/urbanairship/android/layout/property/Border;Lcom/urbanairship/android/layout/property/Color;)V", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "getMargin", "()Lcom/urbanairship/android/layout/property/Margin;", "getSize", "()Lcom/urbanairship/android/layout/property/ConstrainedSize;", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmbeddedPlacement {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Color backgroundColor;
    private final Border border;
    private final Margin margin;
    private final ConstrainedSize size;

    public EmbeddedPlacement(@NotNull ConstrainedSize size, @Nullable Margin margin, @Nullable Border border, @Nullable Color color) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.size = size;
        this.margin = margin;
        this.border = border;
        this.backgroundColor = color;
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
    public final Border getBorder() {
        return this.border;
    }

    @Nullable
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/EmbeddedPlacement$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/EmbeddedPlacement;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nEmbeddedPlacement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmbeddedPlacement.kt\ncom/urbanairship/android/layout/property/EmbeddedPlacement$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final EmbeddedPlacement fromJson(@NotNull JsonMap json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap map = json.opt(TCEventPropertiesNames.TCP_SIZE).getMap();
            if (map == null) {
                throw new JsonException("Failed to parse Modal Placement! Field 'size' is required.");
            }
            JsonMap map2 = json.opt(ViewProps.MARGIN).getMap();
            JsonMap map3 = json.opt("border").getMap();
            JsonMap map4 = json.opt("background_color").getMap();
            ConstrainedSize constrainedSizeFromJson = ConstrainedSize.fromJson(map);
            Intrinsics.checkNotNullExpressionValue(constrainedSizeFromJson, "fromJson(...)");
            return new EmbeddedPlacement(constrainedSizeFromJson, map2 != null ? Margin.fromJson(map2) : null, map3 != null ? Border.INSTANCE.fromJson(map3) : null, map4 != null ? Color.fromJson(map4) : null);
        }
    }
}
