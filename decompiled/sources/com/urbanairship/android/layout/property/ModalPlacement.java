package com.urbanairship.android.layout.property;

import androidx.annotation.RestrictTo;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.model.SafeAreaAware;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\b\u0010#\u001a\u00020\u000bH\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/urbanairship/android/layout/property/ModalPlacement;", "Lcom/urbanairship/android/layout/model/SafeAreaAware;", TCEventPropertiesNames.TCP_SIZE, "Lcom/urbanairship/android/layout/property/ConstrainedSize;", ViewProps.MARGIN, "Lcom/urbanairship/android/layout/property/Margin;", ViewProps.POSITION, "Lcom/urbanairship/android/layout/property/Position;", "shadeColor", "Lcom/urbanairship/android/layout/property/Color;", "ignoreSafeArea", "", "orientationLock", "Lcom/urbanairship/android/layout/property/Orientation;", "border", "Lcom/urbanairship/android/layout/property/Border;", ViewProps.BACKGROUND_COLOR, "shadow", "Lcom/urbanairship/android/layout/property/Shadow;", "(Lcom/urbanairship/android/layout/property/ConstrainedSize;Lcom/urbanairship/android/layout/property/Margin;Lcom/urbanairship/android/layout/property/Position;Lcom/urbanairship/android/layout/property/Color;ZLcom/urbanairship/android/layout/property/Orientation;Lcom/urbanairship/android/layout/property/Border;Lcom/urbanairship/android/layout/property/Color;Lcom/urbanairship/android/layout/property/Shadow;)V", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "getMargin", "()Lcom/urbanairship/android/layout/property/Margin;", "getOrientationLock", "()Lcom/urbanairship/android/layout/property/Orientation;", "getPosition", "()Lcom/urbanairship/android/layout/property/Position;", "getShadeColor", "getShadow", "()Lcom/urbanairship/android/layout/property/Shadow;", "getSize", "()Lcom/urbanairship/android/layout/property/ConstrainedSize;", "shouldIgnoreSafeArea", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class ModalPlacement implements SafeAreaAware {

    /* renamed from: Companion, reason: from kotlin metadata */
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
    /* renamed from: shouldIgnoreSafeArea, reason: from getter */
    public boolean getIgnoreSafeArea() {
        return this.ignoreSafeArea;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ModalPlacement$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ModalPlacement;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nModalPlacement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModalPlacement.kt\ncom/urbanairship/android/layout/property/ModalPlacement$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n44#2,15:70\n79#2,16:86\n1#3:85\n1549#4:102\n1620#4,3:103\n223#4,2:106\n*S KotlinDebug\n*F\n+ 1 ModalPlacement.kt\ncom/urbanairship/android/layout/property/ModalPlacement$Companion\n*L\n37#1:70,15\n44#1:86,16\n48#1:102\n48#1:103,3\n50#1:106,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:146:0x0339  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x03a6  */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.android.layout.property.ModalPlacement fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r30) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1020
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.property.ModalPlacement.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.property.ModalPlacement");
        }
    }
}
