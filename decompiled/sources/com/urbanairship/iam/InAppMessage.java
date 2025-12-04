package com.urbanairship.iam;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.Message;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u0004/012BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB]\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\r\u0010)\u001a\u00020\nH\u0000¢\u0006\u0002\b*J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\t\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/json/JsonSerializable;", "name", "", "displayContent", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "extras", "Lcom/urbanairship/json/JsonMap;", "actions", "isReportingEnabled", "", "displayBehavior", "Lcom/urbanairship/iam/InAppMessage$DisplayBehavior;", "(Ljava/lang/String;Lcom/urbanairship/iam/content/InAppMessageDisplayContent;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/json/JsonMap;Ljava/lang/Boolean;Lcom/urbanairship/iam/InAppMessage$DisplayBehavior;)V", "source", "Lcom/urbanairship/iam/InAppMessage$Source;", "renderedLocale", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Lcom/urbanairship/iam/content/InAppMessageDisplayContent;Lcom/urbanairship/iam/InAppMessage$Source;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/json/JsonMap;Ljava/lang/Boolean;Lcom/urbanairship/iam/InAppMessage$DisplayBehavior;Lcom/urbanairship/json/JsonValue;)V", "getActions", "()Lcom/urbanairship/json/JsonMap;", "getDisplayBehavior", "()Lcom/urbanairship/iam/InAppMessage$DisplayBehavior;", "getDisplayContent", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "getExtras", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "()Ljava/lang/String;", "getRenderedLocale", "()Lcom/urbanairship/json/JsonValue;", "getSource$urbanairship_automation_release", "()Lcom/urbanairship/iam/InAppMessage$Source;", "setSource$urbanairship_automation_release", "(Lcom/urbanairship/iam/InAppMessage$Source;)V", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "isEmbedded", "isEmbedded$urbanairship_automation_release", "newBuilder", "Lcom/urbanairship/iam/InAppMessage$Builder;", "toJsonValue", "toString", "Builder", "Companion", "DisplayBehavior", "Source", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessage implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonMap actions;
    private final DisplayBehavior displayBehavior;
    private final InAppMessageDisplayContent displayContent;
    private final JsonMap extras;
    private final Boolean isReportingEnabled;
    private final String name;
    private final JsonValue renderedLocale;
    private Source source;

    public InAppMessage(@NotNull String name, @NotNull InAppMessageDisplayContent displayContent, @Nullable Source source, @Nullable JsonMap jsonMap, @Nullable JsonMap jsonMap2, @Nullable Boolean bool, @Nullable DisplayBehavior displayBehavior, @Nullable JsonValue jsonValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
        this.name = name;
        this.displayContent = displayContent;
        this.source = source;
        this.extras = jsonMap;
        this.actions = jsonMap2;
        this.isReportingEnabled = bool;
        this.displayBehavior = displayBehavior;
        this.renderedLocale = jsonValue;
    }

    public /* synthetic */ InAppMessage(String str, InAppMessageDisplayContent inAppMessageDisplayContent, Source source, JsonMap jsonMap, JsonMap jsonMap2, Boolean bool, DisplayBehavior displayBehavior, JsonValue jsonValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, inAppMessageDisplayContent, source, (i & 8) != 0 ? null : jsonMap, (i & 16) != 0 ? null : jsonMap2, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : displayBehavior, (i & 128) != 0 ? null : jsonValue);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final InAppMessageDisplayContent getDisplayContent() {
        return this.displayContent;
    }

    @Nullable
    /* renamed from: getSource$urbanairship_automation_release, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    public final void setSource$urbanairship_automation_release(@Nullable Source source) {
        this.source = source;
    }

    @Nullable
    public final JsonMap getExtras() {
        return this.extras;
    }

    @Nullable
    public final JsonMap getActions() {
        return this.actions;
    }

    @Nullable
    /* renamed from: isReportingEnabled, reason: from getter */
    public final Boolean getIsReportingEnabled() {
        return this.isReportingEnabled;
    }

    @Nullable
    public final DisplayBehavior getDisplayBehavior() {
        return this.displayBehavior;
    }

    @Nullable
    public final JsonValue getRenderedLocale() {
        return this.renderedLocale;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/InAppMessage$DisplayBehavior;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "IMMEDIATE", "STANDARD", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DisplayBehavior implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DisplayBehavior[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final DisplayBehavior IMMEDIATE = new DisplayBehavior("IMMEDIATE", 0, "immediate");
        public static final DisplayBehavior STANDARD = new DisplayBehavior("STANDARD", 1, "default");
        private final String json;

        private static final /* synthetic */ DisplayBehavior[] $values() {
            return new DisplayBehavior[]{IMMEDIATE, STANDARD};
        }

        @NotNull
        public static EnumEntries<DisplayBehavior> getEntries() {
            return $ENTRIES;
        }

        public static DisplayBehavior valueOf(String str) {
            return (DisplayBehavior) Enum.valueOf(DisplayBehavior.class, str);
        }

        public static DisplayBehavior[] values() {
            return (DisplayBehavior[]) $VALUES.clone();
        }

        private DisplayBehavior(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            DisplayBehavior[] displayBehaviorArr$values = $values();
            $VALUES = displayBehaviorArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(displayBehaviorArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/InAppMessage$DisplayBehavior$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/InAppMessage$DisplayBehavior;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nInAppMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessage.kt\ncom/urbanairship/iam/InAppMessage$DisplayBehavior$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,310:1\n288#2,2:311\n*S KotlinDebug\n*F\n+ 1 InAppMessage.kt\ncom/urbanairship/iam/InAppMessage$DisplayBehavior$Companion\n*L\n47#1:311,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final DisplayBehavior fromJson(@NotNull JsonValue value) throws JsonException {
                DisplayBehavior next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<DisplayBehavior> it = DisplayBehavior.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), strRequireString)) {
                        break;
                    }
                }
                DisplayBehavior displayBehavior = next;
                if (displayBehavior != null) {
                    return displayBehavior;
                }
                throw new JsonException("Invalid behavior value " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/InAppMessage$Source;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "REMOTE_DATA", "APP_DEFINED", "LEGACY_PUSH", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Source implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Source[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final Source REMOTE_DATA = new Source("REMOTE_DATA", 0, "remote-data");
        public static final Source APP_DEFINED = new Source("APP_DEFINED", 1, "app-defined");
        public static final Source LEGACY_PUSH = new Source("LEGACY_PUSH", 2, "legacy-push");

        private static final /* synthetic */ Source[] $values() {
            return new Source[]{REMOTE_DATA, APP_DEFINED, LEGACY_PUSH};
        }

        @NotNull
        public static EnumEntries<Source> getEntries() {
            return $ENTRIES;
        }

        public static Source valueOf(String str) {
            return (Source) Enum.valueOf(Source.class, str);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        private Source(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        public final String getJson() {
            return this.json;
        }

        static {
            Source[] sourceArr$values = $values();
            $VALUES = sourceArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(sourceArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/InAppMessage$Source$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/InAppMessage$Source;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nInAppMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessage.kt\ncom/urbanairship/iam/InAppMessage$Source$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,310:1\n288#2,2:311\n*S KotlinDebug\n*F\n+ 1 InAppMessage.kt\ncom/urbanairship/iam/InAppMessage$Source$Companion\n*L\n76#1:311,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Source fromJson(@NotNull JsonValue value) throws JsonException {
                Source next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<Source> it = Source.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), strRequireString)) {
                        break;
                    }
                }
                Source source = next;
                if (source != null) {
                    return source;
                }
                throw new JsonException("Invalid message source value " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    public /* synthetic */ InAppMessage(String str, InAppMessageDisplayContent inAppMessageDisplayContent, JsonMap jsonMap, JsonMap jsonMap2, Boolean bool, DisplayBehavior displayBehavior, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, inAppMessageDisplayContent, (i & 4) != 0 ? null : jsonMap, (i & 8) != 0 ? null : jsonMap2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : displayBehavior);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppMessage(@NotNull String name, @NotNull InAppMessageDisplayContent displayContent, @Nullable JsonMap jsonMap, @Nullable JsonMap jsonMap2, @Nullable Boolean bool, @Nullable DisplayBehavior displayBehavior) {
        this(name, displayContent, Source.APP_DEFINED, jsonMap, jsonMap2, bool, displayBehavior, (JsonValue) null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0003J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/iam/InAppMessage$Builder;", "", "message", "Lcom/urbanairship/iam/InAppMessage;", "(Lcom/urbanairship/iam/InAppMessage;)V", "actions", "Lcom/urbanairship/json/JsonMap;", "displayBehavior", "Lcom/urbanairship/iam/InAppMessage$DisplayBehavior;", "displayContent", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "extras", "isReportingEnabled", "", "Ljava/lang/Boolean;", "name", "", "renderedLocale", "Lcom/urbanairship/json/JsonValue;", "source", "Lcom/urbanairship/iam/InAppMessage$Source;", "build", "setActions", "setDisplayBehavior", "setDisplayContent", "setExtras", "setName", "setReportingEnabled", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private JsonMap actions;
        private DisplayBehavior displayBehavior;
        private InAppMessageDisplayContent displayContent;
        private JsonMap extras;
        private Boolean isReportingEnabled;
        private String name;
        private JsonValue renderedLocale;
        private Source source;

        public Builder(@NotNull InAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.name = message.getName();
            this.displayContent = message.getDisplayContent();
            this.source = message.getSource();
            this.extras = message.getExtras();
            this.actions = message.getActions();
            this.isReportingEnabled = message.getIsReportingEnabled();
            this.displayBehavior = message.getDisplayBehavior();
            this.renderedLocale = message.getRenderedLocale();
        }

        @NotNull
        public final Builder setName(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            return this;
        }

        @NotNull
        public final Builder setDisplayContent(@NotNull InAppMessageDisplayContent displayContent) {
            Intrinsics.checkNotNullParameter(displayContent, "displayContent");
            this.displayContent = displayContent;
            return this;
        }

        @NotNull
        public final Builder setExtras(@Nullable JsonMap extras) {
            this.extras = extras;
            return this;
        }

        @NotNull
        public final Builder setActions(@Nullable JsonMap actions) {
            this.actions = actions;
            return this;
        }

        @NotNull
        public final Builder setReportingEnabled(boolean isReportingEnabled) {
            this.isReportingEnabled = Boolean.valueOf(isReportingEnabled);
            return this;
        }

        @NotNull
        public final Builder setDisplayBehavior(@Nullable DisplayBehavior displayBehavior) {
            this.displayBehavior = displayBehavior;
            return this;
        }

        @NotNull
        public final InAppMessage build() {
            return new InAppMessage(this.name, this.displayContent, this.source, this.extras, this.actions, this.isReportingEnabled, this.displayBehavior, this.renderedLocale);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/iam/InAppMessage$Companion;", "", "()V", "ACTIONS_KEY", "", "DISPLAY_BEHAVIOR_KEY", "DISPLAY_CONTENT_KEY", "DISPLAY_TYPE_KEY", "EXTRA_KEY", "MAX_NAME_LENGTH", "", "NAME_KEY", "RENDERED_LOCALE_KEY", "REPORTING_ENABLED_KEY", "SOURCE_KEY", "parseJson", "Lcom/urbanairship/iam/InAppMessage;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nInAppMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessage.kt\ncom/urbanairship/iam/InAppMessage$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n79#2,16:311\n79#2,16:328\n79#2,16:344\n79#2,16:360\n1#3:327\n*S KotlinDebug\n*F\n+ 1 InAppMessage.kt\ncom/urbanairship/iam/InAppMessage$Companion\n*L\n230#1:311,16\n240#1:328,16\n241#1:344,16\n243#1:360,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final InAppMessage parseJson(@NotNull JsonValue value) throws JsonException {
            String strOptString;
            JsonMap jsonMapOptMap;
            JsonMap jsonMap;
            JsonMap jsonMapOptMap2;
            JsonMap jsonMap2;
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            InAppMessageDisplayContent.DisplayType.Companion companion = InAppMessageDisplayContent.DisplayType.INSTANCE;
            JsonValue jsonValueRequire = jsonMapRequireMap.require("display_type");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            InAppMessageDisplayContent.DisplayType displayTypeFromJson = companion.fromJson(jsonValueRequire);
            JsonValue jsonValue = jsonMapRequireMap.get("name");
            Boolean bool = null;
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
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.toJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
            }
            if (strOptString == null) {
                strOptString = "";
            }
            String str = strOptString;
            JsonValue jsonValue3 = jsonMapRequireMap.get("rendered_locale");
            InAppMessageDisplayContent.Companion companion2 = InAppMessageDisplayContent.INSTANCE;
            JsonValue jsonValueRequire2 = jsonMapRequireMap.require("display");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
            InAppMessageDisplayContent inAppMessageDisplayContentFromJson = companion2.fromJson(jsonValueRequire2, displayTypeFromJson);
            JsonValue jsonValue4 = jsonMapRequireMap.get("source");
            Source sourceFromJson = jsonValue4 != null ? Source.INSTANCE.fromJson(jsonValue4) : null;
            JsonValue jsonValue5 = jsonMapRequireMap.get(Message.KEY_EXTRAS);
            if (jsonValue5 == null) {
                jsonMap = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    jsonMapOptMap = (JsonMap) jsonValue5.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonMapOptMap = (JsonMap) jsonValue5.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap = jsonValue5.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + Message.KEY_EXTRAS + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonMapOptMap = (JsonMap) jsonValue5.toJsonValue();
                }
                jsonMap = jsonMapOptMap;
            }
            JsonValue jsonValue6 = jsonMapRequireMap.get("actions");
            if (jsonValue6 == null) {
                jsonMap2 = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    jsonMapOptMap2 = (JsonMap) jsonValue6.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue6.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue6.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap2 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue6.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap2 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonMapOptMap2 = (JsonMap) jsonValue6.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap2 = jsonValue6.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'actions" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonMapOptMap2 = (JsonMap) jsonValue6.toJsonValue();
                }
                jsonMap2 = jsonMapOptMap2;
            }
            JsonValue jsonValue7 = jsonMapRequireMap.get("display_behavior");
            DisplayBehavior displayBehaviorFromJson = jsonValue7 != null ? DisplayBehavior.INSTANCE.fromJson(jsonValue7) : null;
            JsonValue jsonValue8 = jsonMapRequireMap.get("reporting_enabled");
            if (jsonValue8 != null) {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    boolValueOf = (Boolean) jsonValue8.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf = Boolean.valueOf(jsonValue8.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf = (Boolean) Long.valueOf(jsonValue8.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue8.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf = (Boolean) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf = (Boolean) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    boolValueOf = (Boolean) Integer.valueOf(jsonValue8.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue8.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    boolValueOf = (Boolean) jsonValue8.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    boolValueOf = (Boolean) jsonValue8.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'reporting_enabled" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    boolValueOf = (Boolean) jsonValue8.toJsonValue();
                }
                bool = boolValueOf;
            }
            return new InAppMessage(str, inAppMessageDisplayContentFromJson, sourceFromJson, jsonMap, jsonMap2, bool, displayBehaviorFromJson, jsonValue3);
        }
    }

    public final boolean isEmbedded$urbanairship_automation_release() {
        return this.displayContent.isEmbedded();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("name", this.name), TuplesKt.to(Message.KEY_EXTRAS, this.extras), TuplesKt.to("display", this.displayContent), TuplesKt.to("display_type", this.displayContent.getDisplayType()), TuplesKt.to("actions", this.actions), TuplesKt.to("source", this.source), TuplesKt.to("display_behavior", this.displayBehavior), TuplesKt.to("reporting_enabled", this.isReportingEnabled), TuplesKt.to("rendered_locale", this.renderedLocale)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @NotNull
    public String toString() {
        String string = toJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(InAppMessage.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.InAppMessage");
        InAppMessage inAppMessage = (InAppMessage) other;
        if (Intrinsics.areEqual(this.name, inAppMessage.name) && Intrinsics.areEqual(this.displayContent, inAppMessage.displayContent) && this.source == inAppMessage.source && Intrinsics.areEqual(this.extras, inAppMessage.extras) && Intrinsics.areEqual(this.actions, inAppMessage.actions) && Intrinsics.areEqual(this.isReportingEnabled, inAppMessage.isReportingEnabled) && this.displayBehavior == inAppMessage.displayBehavior) {
            return Intrinsics.areEqual(this.renderedLocale, inAppMessage.renderedLocale);
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        InAppMessageDisplayContent inAppMessageDisplayContent = this.displayContent;
        return Objects.hash(str, inAppMessageDisplayContent, this.source, this.extras, this.actions, this.isReportingEnabled, inAppMessageDisplayContent, this.renderedLocale);
    }
}
