package com.urbanairship.iam.analytics.events;

import ch.qos.logback.core.CoreConstants;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.analytics.EventType;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.experiment.ExperimentResult;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent;", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "reportData", "Lcom/urbanairship/json/JsonSerializable;", "(Lcom/urbanairship/json/JsonSerializable;)V", "data", "getData", "()Lcom/urbanairship/json/JsonSerializable;", "eventType", "Lcom/urbanairship/analytics/EventType;", "getEventType", "()Lcom/urbanairship/analytics/EventType;", "Companion", NativeDeviceInfoSpec.NAME, "ResolutionData", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppResolutionEvent implements InAppEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonSerializable data;
    private final EventType eventType = EventType.IN_APP_RESOLUTION;

    public InAppResolutionEvent(@Nullable JsonSerializable jsonSerializable) {
        this.data = jsonSerializable;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @NotNull
    public EventType getEventType() {
        return this.eventType;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    @Nullable
    public JsonSerializable getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J(\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$Companion;", "", "()V", "audienceExcluded", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent;", "buttonTap", "identifier", "", "description", "displayTime", "Lkotlin/time/Duration;", "buttonTap-SxA4cEA", "(Ljava/lang/String;Ljava/lang/String;J)Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent;", "control", "experimentResult", "Lcom/urbanairship/experiment/ExperimentResult;", "interrupted", "messageTap", "messageTap-LRDsOJo", "(J)Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent;", "timedOut", "timedOut-LRDsOJo", "userDismissed", "userDismissed-LRDsOJo", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        /* renamed from: buttonTap-SxA4cEA, reason: not valid java name */
        public final InAppResolutionEvent m2887buttonTapSxA4cEA(@NotNull String identifier, @NotNull String description, long displayTime) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(description, "description");
            return new InAppResolutionEvent(new ResolutionData(new ResolutionData.ResolutionType.ButtonTap(identifier, description), displayTime, null, 4, null));
        }

        @NotNull
        /* renamed from: messageTap-LRDsOJo, reason: not valid java name */
        public final InAppResolutionEvent m2888messageTapLRDsOJo(long displayTime) {
            return new InAppResolutionEvent(new ResolutionData(ResolutionData.ResolutionType.MessageTap.INSTANCE, displayTime, null, 4, null));
        }

        @NotNull
        /* renamed from: userDismissed-LRDsOJo, reason: not valid java name */
        public final InAppResolutionEvent m2890userDismissedLRDsOJo(long displayTime) {
            return new InAppResolutionEvent(new ResolutionData(ResolutionData.ResolutionType.UserDismissed.INSTANCE, displayTime, null, 4, null));
        }

        @NotNull
        /* renamed from: timedOut-LRDsOJo, reason: not valid java name */
        public final InAppResolutionEvent m2889timedOutLRDsOJo(long displayTime) {
            return new InAppResolutionEvent(new ResolutionData(ResolutionData.ResolutionType.TimedOut.INSTANCE, displayTime, null, 4, null));
        }

        @NotNull
        public final InAppResolutionEvent interrupted() {
            ResolutionData.ResolutionType.Interrupted interrupted = ResolutionData.ResolutionType.Interrupted.INSTANCE;
            Duration.Companion companion = Duration.INSTANCE;
            return new InAppResolutionEvent(new ResolutionData(interrupted, DurationKt.toDuration(0, DurationUnit.SECONDS), null, 4, null));
        }

        @NotNull
        public final InAppResolutionEvent control(@NotNull ExperimentResult experimentResult) {
            Intrinsics.checkNotNullParameter(experimentResult, "experimentResult");
            ResolutionData.ResolutionType.Control control = ResolutionData.ResolutionType.Control.INSTANCE;
            Duration.Companion companion = Duration.INSTANCE;
            return new InAppResolutionEvent(new ResolutionData(control, DurationKt.toDuration(0, DurationUnit.SECONDS), new DeviceInfo(experimentResult.getChannelId(), experimentResult.getContactId()), null));
        }

        @NotNull
        public final InAppResolutionEvent audienceExcluded() {
            ResolutionData.ResolutionType.AudienceExcluded audienceExcluded = ResolutionData.ResolutionType.AudienceExcluded.INSTANCE;
            Duration.Companion companion = Duration.INSTANCE;
            return new InAppResolutionEvent(new ResolutionData(audienceExcluded, DurationKt.toDuration(0, DurationUnit.SECONDS), null, 4, null));
        }
    }

    private static final class DeviceInfo implements JsonSerializable {
        public static final Companion Companion = new Companion(null);
        private final String channel;
        private final String contact;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeviceInfo)) {
                return false;
            }
            DeviceInfo deviceInfo = (DeviceInfo) obj;
            return Intrinsics.areEqual(this.channel, deviceInfo.channel) && Intrinsics.areEqual(this.contact, deviceInfo.contact);
        }

        public int hashCode() {
            String str = this.channel;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.contact;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DeviceInfo(channel=" + this.channel + ", contact=" + this.contact + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public DeviceInfo(String str, String str2) {
            this.channel = str;
            this.contact = str2;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$DeviceInfo$Companion;", "", "()V", "CHANNEL", "", "CONTACT", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("channel_id", this.channel), TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, this.contact)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    private static final class ResolutionData implements JsonSerializable {
        public static final Companion Companion = new Companion(null);
        private final DeviceInfo deviceInfo;
        private final long displayTime;
        private final ResolutionType resolutionType;

        public /* synthetic */ ResolutionData(ResolutionType resolutionType, long j, DeviceInfo deviceInfo, DefaultConstructorMarker defaultConstructorMarker) {
            this(resolutionType, j, deviceInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolutionData)) {
                return false;
            }
            ResolutionData resolutionData = (ResolutionData) obj;
            return Intrinsics.areEqual(this.resolutionType, resolutionData.resolutionType) && Duration.m3472equalsimpl0(this.displayTime, resolutionData.displayTime) && Intrinsics.areEqual(this.deviceInfo, resolutionData.deviceInfo);
        }

        public int hashCode() {
            int iHashCode = ((this.resolutionType.hashCode() * 31) + Duration.m3494hashCodeimpl(this.displayTime)) * 31;
            DeviceInfo deviceInfo = this.deviceInfo;
            return iHashCode + (deviceInfo == null ? 0 : deviceInfo.hashCode());
        }

        public String toString() {
            return "ResolutionData(resolutionType=" + this.resolutionType + ", displayTime=" + ((Object) Duration.m3515toStringimpl(this.displayTime)) + ", deviceInfo=" + this.deviceInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        private ResolutionData(ResolutionType resolutionType, long j, DeviceInfo deviceInfo) {
            Intrinsics.checkNotNullParameter(resolutionType, "resolutionType");
            this.resolutionType = resolutionType;
            this.displayTime = j;
            this.deviceInfo = deviceInfo;
        }

        public /* synthetic */ ResolutionData(ResolutionType resolutionType, long j, DeviceInfo deviceInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(resolutionType, j, (i & 4) != 0 ? null : deviceInfo, null);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$Companion;", "", "()V", "DEVICE", "", "DISPLAY_TIME", "RESOLUTION", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonMap.Builder builderPutAll = JsonMap.newBuilder().putAll(this.resolutionType.getJsonValue().optMap());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(Duration.m3509toDoubleimpl(this.displayTime, DurationUnit.SECONDS))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("resolution", builderPutAll.put("display_time", str).build()), TuplesKt.to("device", this.deviceInfo)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "AudienceExcluded", "ButtonTap", "Companion", "Control", "Interrupted", "MessageTap", "TimedOut", "UserDismissed", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$AudienceExcluded;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$ButtonTap;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$Control;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$Interrupted;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$MessageTap;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$TimedOut;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$UserDismissed;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class ResolutionType implements JsonSerializable {
            public /* synthetic */ ResolutionType(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private ResolutionType() {
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$ButtonTap;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "identifier", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIdentifier", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class ButtonTap extends ResolutionType {
                private final String description;
                private final String identifier;

                public static /* synthetic */ ButtonTap copy$default(ButtonTap buttonTap, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = buttonTap.identifier;
                    }
                    if ((i & 2) != 0) {
                        str2 = buttonTap.description;
                    }
                    return buttonTap.copy(str, str2);
                }

                @NotNull
                /* renamed from: component1, reason: from getter */
                public final String getIdentifier() {
                    return this.identifier;
                }

                @NotNull
                /* renamed from: component2, reason: from getter */
                public final String getDescription() {
                    return this.description;
                }

                @NotNull
                public final ButtonTap copy(@NotNull String identifier, @NotNull String description) {
                    Intrinsics.checkNotNullParameter(identifier, "identifier");
                    Intrinsics.checkNotNullParameter(description, "description");
                    return new ButtonTap(identifier, description);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof ButtonTap)) {
                        return false;
                    }
                    ButtonTap buttonTap = (ButtonTap) other;
                    return Intrinsics.areEqual(this.identifier, buttonTap.identifier) && Intrinsics.areEqual(this.description, buttonTap.description);
                }

                public int hashCode() {
                    return (this.identifier.hashCode() * 31) + this.description.hashCode();
                }

                @NotNull
                public String toString() {
                    return "ButtonTap(identifier=" + this.identifier + ", description=" + this.description + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ButtonTap(@NotNull String identifier, @NotNull String description) {
                    super(null);
                    Intrinsics.checkNotNullParameter(identifier, "identifier");
                    Intrinsics.checkNotNullParameter(description, "description");
                    this.identifier = identifier;
                    this.description = description;
                }

                @NotNull
                public final String getDescription() {
                    return this.description;
                }

                @NotNull
                public final String getIdentifier() {
                    return this.identifier;
                }

                @Override // com.urbanairship.json.JsonSerializable
                @NotNull
                /* renamed from: toJsonValue */
                public JsonValue getJsonValue() {
                    JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "button_click"), TuplesKt.to("button_id", this.identifier), TuplesKt.to("button_description", this.description)).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    return jsonValue;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$MessageTap;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class MessageTap extends ResolutionType {

                @NotNull
                public static final MessageTap INSTANCE = new MessageTap();

                public boolean equals(@Nullable Object other) {
                    return this == other || (other instanceof MessageTap);
                }

                public int hashCode() {
                    return 72133345;
                }

                @NotNull
                public String toString() {
                    return "MessageTap";
                }

                private MessageTap() {
                    super(null);
                }

                @Override // com.urbanairship.json.JsonSerializable
                @NotNull
                /* renamed from: toJsonValue */
                public JsonValue getJsonValue() {
                    JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "message_click")).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    return jsonValue;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$UserDismissed;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class UserDismissed extends ResolutionType {

                @NotNull
                public static final UserDismissed INSTANCE = new UserDismissed();

                public boolean equals(@Nullable Object other) {
                    return this == other || (other instanceof UserDismissed);
                }

                public int hashCode() {
                    return 815490617;
                }

                @NotNull
                public String toString() {
                    return "UserDismissed";
                }

                private UserDismissed() {
                    super(null);
                }

                @Override // com.urbanairship.json.JsonSerializable
                @NotNull
                /* renamed from: toJsonValue */
                public JsonValue getJsonValue() {
                    JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "user_dismissed")).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    return jsonValue;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$TimedOut;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class TimedOut extends ResolutionType {

                @NotNull
                public static final TimedOut INSTANCE = new TimedOut();

                public boolean equals(@Nullable Object other) {
                    return this == other || (other instanceof TimedOut);
                }

                public int hashCode() {
                    return -72846692;
                }

                @NotNull
                public String toString() {
                    return "TimedOut";
                }

                private TimedOut() {
                    super(null);
                }

                @Override // com.urbanairship.json.JsonSerializable
                @NotNull
                /* renamed from: toJsonValue */
                public JsonValue getJsonValue() {
                    JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "timed_out")).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    return jsonValue;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$Interrupted;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Interrupted extends ResolutionType {

                @NotNull
                public static final Interrupted INSTANCE = new Interrupted();

                public boolean equals(@Nullable Object other) {
                    return this == other || (other instanceof Interrupted);
                }

                public int hashCode() {
                    return 1161597469;
                }

                @NotNull
                public String toString() {
                    return "Interrupted";
                }

                private Interrupted() {
                    super(null);
                }

                @Override // com.urbanairship.json.JsonSerializable
                @NotNull
                /* renamed from: toJsonValue */
                public JsonValue getJsonValue() {
                    JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "interrupted")).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    return jsonValue;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$Control;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Control extends ResolutionType {

                @NotNull
                public static final Control INSTANCE = new Control();

                public boolean equals(@Nullable Object other) {
                    return this == other || (other instanceof Control);
                }

                public int hashCode() {
                    return -923472200;
                }

                @NotNull
                public String toString() {
                    return "Control";
                }

                private Control() {
                    super(null);
                }

                @Override // com.urbanairship.json.JsonSerializable
                @NotNull
                /* renamed from: toJsonValue */
                public JsonValue getJsonValue() {
                    JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "control")).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    return jsonValue;
                }
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType$AudienceExcluded;", "Lcom/urbanairship/iam/analytics/events/InAppResolutionEvent$ResolutionData$ResolutionType;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class AudienceExcluded extends ResolutionType {

                @NotNull
                public static final AudienceExcluded INSTANCE = new AudienceExcluded();

                public boolean equals(@Nullable Object other) {
                    return this == other || (other instanceof AudienceExcluded);
                }

                public int hashCode() {
                    return -1788103437;
                }

                @NotNull
                public String toString() {
                    return "AudienceExcluded";
                }

                private AudienceExcluded() {
                    super(null);
                }

                @Override // com.urbanairship.json.JsonSerializable
                @NotNull
                /* renamed from: toJsonValue */
                public JsonValue getJsonValue() {
                    JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "audience_check_excluded")).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    return jsonValue;
                }
            }
        }
    }
}
