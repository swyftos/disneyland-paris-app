package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.ActionConst;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.info.LabelInfo;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.property.MarkdownOptions;
import com.urbanairship.android.layout.property.TextAppearance;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004LMNOB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010%R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u0004\u0018\u00010.X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 R\u001a\u00107\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010%R\u0011\u0010:\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010 R\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0012\u0010@\u001a\u00020AX\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0013\u0010D\u001a\u0004\u0018\u00010E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u0004\u0018\u00010IX\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006P"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo;", "Lcom/urbanairship/android/layout/info/ViewInfo;", "Lcom/urbanairship/android/layout/info/View;", "Lcom/urbanairship/android/layout/info/Accessible;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "accessibilityHidden", "", "getAccessibilityHidden", "()Ljava/lang/Boolean;", ViewProps.ACCESSIBILITY_ROLE, "Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole;", "getAccessibilityRole", "()Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole;", "setAccessibilityRole", "(Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole;)V", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "enableBehaviors", "", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "()Ljava/util/List;", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "iconStart", "Lcom/urbanairship/android/layout/info/LabelInfo$IconStart;", "getIconStart", "()Lcom/urbanairship/android/layout/info/LabelInfo$IconStart;", "localizedContentDescription", "Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "getLocalizedContentDescription", "()Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "markdownOptions", "Lcom/urbanairship/android/layout/property/MarkdownOptions;", "getMarkdownOptions", "()Lcom/urbanairship/android/layout/property/MarkdownOptions;", ActionConst.REF_ATTRIBUTE, "getRef", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "text", "getText", "textAppearance", "Lcom/urbanairship/android/layout/property/TextAppearance;", "getTextAppearance", "()Lcom/urbanairship/android/layout/property/TextAppearance;", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "viewOverrides", "Lcom/urbanairship/android/layout/info/LabelInfo$ViewOverrides;", "getViewOverrides", "()Lcom/urbanairship/android/layout/info/LabelInfo$ViewOverrides;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "AccessibilityRole", "AccessibilityRoleType", "IconStart", "ViewOverrides", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n44#2,15:945\n79#2,16:960\n44#2,15:977\n1#3:976\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo\n*L\n509#1:945,15\n510#1:960,16\n513#1:977,15\n*E\n"})
/* loaded from: classes5.dex */
public final class LabelInfo extends ViewInfo implements View, Accessible {
    private final /* synthetic */ View $$delegate_0;
    private final /* synthetic */ Accessible $$delegate_1;
    private AccessibilityRole accessibilityRole;
    private final IconStart iconStart;
    private final MarkdownOptions markdownOptions;
    private final String ref;
    private final String text;
    private final TextAppearance textAppearance;
    private final ViewOverrides viewOverrides;

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public Boolean getAccessibilityHidden() {
        return this.$$delegate_1.getAccessibilityHidden();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Color getBackgroundColor() {
        return this.$$delegate_0.getBackgroundColor();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Border getBorder() {
        return this.$$delegate_0.getBorder();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public CommonViewOverrides getCommonViewOverrides() {
        return this.$$delegate_0.getCommonViewOverrides();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public String getContentDescription() {
        return this.$$delegate_1.getContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EnableBehaviorType> getEnableBehaviors() {
        return this.$$delegate_0.getEnableBehaviors();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EventHandler> getEventHandlers() {
        return this.$$delegate_0.getEventHandlers();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public LocalizedContentDescription getLocalizedContentDescription() {
        return this.$$delegate_1.getLocalizedContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<ThomasStateTrigger> getStateTriggers() {
        return this.$$delegate_0.getStateTriggers();
    }

    @Override // com.urbanairship.android.layout.info.View
    @NotNull
    public ViewType getType() {
        return this.$$delegate_0.getType();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public VisibilityInfo getVisibility() {
        return this.$$delegate_0.getVisibility();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0001\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$IconStart;", "", "type", "Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Type;", "(Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Type;)V", "space", "", "getSpace", "()I", "getType", "()Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Type;", "Companion", "Floating", "Type", "Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Floating;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class IconStart {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Type type;

        public /* synthetic */ IconStart(Type type, DefaultConstructorMarker defaultConstructorMarker) {
            this(type);
        }

        public abstract int getSpace();

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/info/LabelInfo$IconStart;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$IconStart$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:961\n44#2,15:976\n1#3:960\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$IconStart$Companion\n*L\n540#1:945,15\n541#1:961,15\n545#1:976,15\n*E\n"})
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Type.values().length];
                    try {
                        iArr[Type.FLOATING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Removed duplicated region for block: B:117:0x029b  */
            /* JADX WARN: Removed duplicated region for block: B:181:0x0424  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.android.layout.info.LabelInfo.IconStart fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r21) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 1205
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.LabelInfo.IconStart.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.info.LabelInfo$IconStart");
            }

            private Companion() {
            }
        }

        private IconStart(Type type) {
            this.type = type;
        }

        @NotNull
        public final Type getType() {
            return this.type;
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Floating;", "Lcom/urbanairship/android/layout/info/LabelInfo$IconStart;", "icon", "Lcom/urbanairship/android/layout/property/Image$Icon;", "space", "", "(Lcom/urbanairship/android/layout/property/Image$Icon;I)V", "getIcon", "()Lcom/urbanairship/android/layout/property/Image$Icon;", "getSpace", "()I", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Floating extends IconStart {
            private final Image.Icon icon;
            private final int space;

            public static /* synthetic */ Floating copy$default(Floating floating, Image.Icon icon, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    icon = floating.icon;
                }
                if ((i2 & 2) != 0) {
                    i = floating.space;
                }
                return floating.copy(icon, i);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Image.Icon getIcon() {
                return this.icon;
            }

            /* renamed from: component2, reason: from getter */
            public final int getSpace() {
                return this.space;
            }

            @NotNull
            public final Floating copy(@NotNull Image.Icon icon, int space) {
                Intrinsics.checkNotNullParameter(icon, "icon");
                return new Floating(icon, space);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Floating)) {
                    return false;
                }
                Floating floating = (Floating) other;
                return Intrinsics.areEqual(this.icon, floating.icon) && this.space == floating.space;
            }

            public int hashCode() {
                return (this.icon.hashCode() * 31) + Integer.hashCode(this.space);
            }

            @NotNull
            public String toString() {
                return "Floating(icon=" + this.icon + ", space=" + this.space + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Floating(@NotNull Image.Icon icon, int i) {
                super(Type.FLOATING, null);
                Intrinsics.checkNotNullParameter(icon, "icon");
                this.icon = icon;
                this.space = i;
            }

            @NotNull
            public final Image.Icon getIcon() {
                return this.icon;
            }

            @Override // com.urbanairship.android.layout.info.LabelInfo.IconStart
            public int getSpace() {
                return this.space;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FLOATING", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Type {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Type[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final Type FLOATING = new Type("FLOATING", 0, "floating");
            private final String value;

            private static final /* synthetic */ Type[] $values() {
                return new Type[]{FLOATING};
            }

            @NotNull
            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            private Type(String str, int i, String str2) {
                this.value = str2;
            }

            @NotNull
            public final String getValue() {
                return this.value;
            }

            static {
                Type[] typeArr$values = $values();
                $VALUES = typeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
                INSTANCE = new Companion(null);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Type$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/info/LabelInfo$IconStart$Type;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$IconStart$Type$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n288#2,2:945\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$IconStart$Type$Companion\n*L\n531#1:945,2\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final Type fromJson(@NotNull String value) throws JsonException {
                    Type next;
                    Intrinsics.checkNotNullParameter(value, "value");
                    Iterator<Type> it = Type.getEntries().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (StringsKt.equals(next.getValue(), value, true)) {
                            break;
                        }
                    }
                    Type type = next;
                    if (type != null) {
                        return type;
                    }
                    throw new JsonException("Invalid IconStart type: " + value);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole;", "", "()V", "type", "Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRoleType;", "getType", "()Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRoleType;", "Companion", "Heading", "Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole$Heading;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class AccessibilityRole {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ AccessibilityRole(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public abstract AccessibilityRoleType getType();

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n79#2,16:945\n79#2,16:961\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole$Companion\n*L\n575#1:945,16\n578#1:961,16\n*E\n"})
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[AccessibilityRoleType.values().length];
                    try {
                        iArr[AccessibilityRoleType.HEADING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Nullable
            public final AccessibilityRole fromJson(@NotNull JsonMap json) throws JsonException {
                String strOptString;
                Integer numValueOf;
                Intrinsics.checkNotNullParameter(json, "json");
                JsonValue jsonValue = json.get("type");
                Integer num = null;
                if (jsonValue == null) {
                    strOptString = null;
                } else {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                }
                if (strOptString == null) {
                    return null;
                }
                AccessibilityRoleType accessibilityRoleTypeFromString = AccessibilityRoleType.INSTANCE.fromString(strOptString);
                int i = accessibilityRoleTypeFromString == null ? -1 : WhenMappings.$EnumSwitchMapping$0[accessibilityRoleTypeFromString.ordinal()];
                if (i == -1) {
                    return null;
                }
                if (i == 1) {
                    JsonValue jsonValue3 = json.get("level");
                    if (jsonValue3 != null) {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            numValueOf = (Integer) jsonValue3.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            numValueOf = (Integer) Boolean.valueOf(jsonValue3.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            numValueOf = (Integer) Long.valueOf(jsonValue3.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            numValueOf = (Integer) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            numValueOf = (Integer) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            numValueOf = Integer.valueOf(jsonValue3.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            numValueOf = (Integer) jsonValue3.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            numValueOf = (Integer) jsonValue3.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'level" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            numValueOf = (Integer) jsonValue3.getJsonValue();
                        }
                        num = numValueOf;
                    }
                    return new Heading(num != null ? num.intValue() : 1);
                }
                throw new NoWhenBranchMatchedException();
            }

            private Companion() {
            }
        }

        private AccessibilityRole() {
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole$Heading;", "Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRole;", "level", "", "(I)V", "getLevel", "()I", "type", "Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRoleType;", "getType", "()Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRoleType;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Heading extends AccessibilityRole {
            private final int level;
            private final AccessibilityRoleType type;

            public static /* synthetic */ Heading copy$default(Heading heading, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = heading.level;
                }
                return heading.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getLevel() {
                return this.level;
            }

            @NotNull
            public final Heading copy(int level) {
                return new Heading(level);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Heading) && this.level == ((Heading) other).level;
            }

            public int hashCode() {
                return Integer.hashCode(this.level);
            }

            @NotNull
            public String toString() {
                return "Heading(level=" + this.level + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public final int getLevel() {
                return this.level;
            }

            public Heading(int i) {
                super(null);
                this.level = i;
                this.type = AccessibilityRoleType.HEADING;
            }

            @Override // com.urbanairship.android.layout.info.LabelInfo.AccessibilityRole
            @NotNull
            public AccessibilityRoleType getType() {
                return this.type;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelInfo(@NotNull JsonMap json) throws JsonException {
        String strOptString;
        String strOptString2;
        JsonMap jsonMapOptMap;
        super(null);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.view(json);
        this.$$delegate_1 = ViewInfoKt.accessible(json);
        JsonValue jsonValue = json.get("text");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'text" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue.optList();
            if (objOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue.optMap();
            if (objOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'text" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue2;
        }
        this.text = strOptString;
        JsonValue jsonValue3 = json.get(ActionConst.REF_ATTRIBUTE);
        if (jsonValue3 == null) {
            strOptString2 = null;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString2 = jsonValue3.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString2 = (String) jsonValue3.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString2 = (String) jsonValue3.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + ActionConst.REF_ATTRIBUTE + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString2 = (String) jsonValue3.getJsonValue();
            }
        }
        this.ref = strOptString2;
        JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(json, "icon_start");
        this.iconStart = jsonMapOptionalMap != null ? IconStart.INSTANCE.fromJson(jsonMapOptionalMap) : null;
        JsonValue jsonValue4 = json.get("text_appearance");
        if (jsonValue4 == null) {
            throw new JsonException("Missing required field: 'text_appearance" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue4.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue4.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue4.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            jsonMapOptMap = jsonValue4.optMap();
            if (jsonMapOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'text_appearance" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue5 = jsonValue4.getJsonValue();
            if (jsonValue5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonValue5;
        }
        TextAppearance textAppearanceFromJson = TextAppearance.fromJson(jsonMapOptMap);
        Intrinsics.checkNotNullExpressionValue(textAppearanceFromJson, "fromJson(...)");
        this.textAppearance = textAppearanceFromJson;
        JsonMap jsonMapOptionalMap2 = JsonExtensionsKt.optionalMap(json, "markdown");
        this.markdownOptions = jsonMapOptionalMap2 != null ? new MarkdownOptions(jsonMapOptionalMap2) : null;
        JsonMap jsonMapOptionalMap3 = JsonExtensionsKt.optionalMap(json, "accessibility_role");
        this.accessibilityRole = jsonMapOptionalMap3 != null ? AccessibilityRole.INSTANCE.fromJson(jsonMapOptionalMap3) : null;
        JsonMap jsonMapOptionalMap4 = JsonExtensionsKt.optionalMap(json, "view_overrides");
        this.viewOverrides = jsonMapOptionalMap4 != null ? new ViewOverrides(jsonMapOptionalMap4) : null;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getRef() {
        return this.ref;
    }

    @Nullable
    public final IconStart getIconStart() {
        return this.iconStart;
    }

    @NotNull
    public final TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    @Nullable
    public final MarkdownOptions getMarkdownOptions() {
        return this.markdownOptions;
    }

    @Nullable
    public final AccessibilityRole getAccessibilityRole() {
        return this.accessibilityRole;
    }

    public final void setAccessibilityRole(@Nullable AccessibilityRole accessibilityRole) {
        this.accessibilityRole = accessibilityRole;
    }

    @Nullable
    public final ViewOverrides getViewOverrides() {
        return this.viewOverrides;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRoleType;", "", "(Ljava/lang/String;I)V", "HEADING", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AccessibilityRoleType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AccessibilityRoleType[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final AccessibilityRoleType HEADING = new AccessibilityRoleType("HEADING", 0);

        private static final /* synthetic */ AccessibilityRoleType[] $values() {
            return new AccessibilityRoleType[]{HEADING};
        }

        @NotNull
        public static EnumEntries<AccessibilityRoleType> getEntries() {
            return $ENTRIES;
        }

        public static AccessibilityRoleType valueOf(String str) {
            return (AccessibilityRoleType) Enum.valueOf(AccessibilityRoleType.class, str);
        }

        public static AccessibilityRoleType[] values() {
            return (AccessibilityRoleType[]) $VALUES.clone();
        }

        private AccessibilityRoleType(String str, int i) {
        }

        static {
            AccessibilityRoleType[] accessibilityRoleTypeArr$values = $values();
            $VALUES = accessibilityRoleTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(accessibilityRoleTypeArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRoleType$Companion;", "", "()V", "fromString", "Lcom/urbanairship/android/layout/info/LabelInfo$AccessibilityRoleType;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @Nullable
            public final AccessibilityRoleType fromString(@NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "heading")) {
                    return AccessibilityRoleType.HEADING;
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001f\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelInfo$ViewOverrides;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "iconStart", "", "Lcom/urbanairship/android/layout/info/ViewPropertyOverride;", "Lcom/urbanairship/android/layout/info/LabelInfo$IconStart;", "getIconStart", "()Ljava/util/List;", ActionConst.REF_ATTRIBUTE, "", "getRef", "text", "getText", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$ViewOverrides\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n1549#2:945\n1620#2,3:946\n1549#2:949\n1620#2,3:950\n1549#2:953\n1620#2,3:954\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelInfo$ViewOverrides\n*L\n587#1:945\n587#1:946,3\n590#1:949\n590#1:950,3\n593#1:953\n593#1:954,3\n*E\n"})
    public static final class ViewOverrides {
        private final List iconStart;
        private final List ref;
        private final List text;

        public ViewOverrides(@NotNull JsonMap json) throws JsonException {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "text");
            ArrayList arrayList3 = null;
            if (jsonListOptionalList != null) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
                for (JsonValue jsonValue : jsonListOptionalList) {
                    Intrinsics.checkNotNull(jsonValue);
                    arrayList.add(new ViewPropertyOverride(jsonValue, new Function1() { // from class: com.urbanairship.android.layout.info.LabelInfo$ViewOverrides$text$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(JsonValue value) {
                            Intrinsics.checkNotNullParameter(value, "value");
                            return value.optString();
                        }
                    }));
                }
            } else {
                arrayList = null;
            }
            this.text = arrayList;
            JsonList jsonListOptionalList2 = JsonExtensionsKt.optionalList(json, "icon_start");
            if (jsonListOptionalList2 != null) {
                arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList2, 10));
                for (JsonValue jsonValue2 : jsonListOptionalList2) {
                    Intrinsics.checkNotNull(jsonValue2);
                    arrayList2.add(new ViewPropertyOverride(jsonValue2, new Function1() { // from class: com.urbanairship.android.layout.info.LabelInfo$ViewOverrides$iconStart$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final LabelInfo.IconStart invoke(JsonValue value) {
                            Intrinsics.checkNotNullParameter(value, "value");
                            LabelInfo.IconStart.Companion companion = LabelInfo.IconStart.INSTANCE;
                            JsonMap jsonMapOptMap = value.optMap();
                            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                            return companion.fromJson(jsonMapOptMap);
                        }
                    }));
                }
            } else {
                arrayList2 = null;
            }
            this.iconStart = arrayList2;
            JsonList jsonListOptionalList3 = JsonExtensionsKt.optionalList(json, ActionConst.REF_ATTRIBUTE);
            if (jsonListOptionalList3 != null) {
                arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList3, 10));
                for (JsonValue jsonValue3 : jsonListOptionalList3) {
                    Intrinsics.checkNotNull(jsonValue3);
                    arrayList3.add(new ViewPropertyOverride(jsonValue3, new Function1() { // from class: com.urbanairship.android.layout.info.LabelInfo$ViewOverrides$ref$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(JsonValue value) {
                            Intrinsics.checkNotNullParameter(value, "value");
                            return value.optString();
                        }
                    }));
                }
            }
            this.ref = arrayList3;
        }

        @Nullable
        public final List<ViewPropertyOverride<String>> getText() {
            return this.text;
        }

        @Nullable
        public final List<ViewPropertyOverride<IconStart>> getIconStart() {
            return this.iconStart;
        }

        @Nullable
        public final List<ViewPropertyOverride<String>> getRef() {
            return this.ref;
        }
    }
}
