package com.urbanairship.android.layout.event;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.info.ThomasChannelRegistration;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0014\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\n\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent;", "", "()V", "ButtonTap", "ButtonTapData", "Dismiss", "DismissData", "FormDisplay", "FormDisplayData", "FormResult", "FormResultData", "Gesture", "GestureData", "PageAction", "PageActionData", "PageSummaryData", "PageSwipe", "PageSwipeData", "PageView", "PageViewData", "PagerComplete", "PagerCompleteData", "PagerSummary", "Lcom/urbanairship/android/layout/event/ReportingEvent$ButtonTap;", "Lcom/urbanairship/android/layout/event/ReportingEvent$Dismiss;", "Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplay;", "Lcom/urbanairship/android/layout/event/ReportingEvent$FormResult;", "Lcom/urbanairship/android/layout/event/ReportingEvent$Gesture;", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageAction;", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSwipe;", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageView;", "Lcom/urbanairship/android/layout/event/ReportingEvent$PagerComplete;", "Lcom/urbanairship/android/layout/event/ReportingEvent$PagerSummary;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class ReportingEvent {
    public /* synthetic */ ReportingEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ReportingEvent() {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplay;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplayData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplayData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplayData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FormDisplay extends ReportingEvent {
        private final LayoutData context;
        private final FormDisplayData data;

        public static /* synthetic */ FormDisplay copy$default(FormDisplay formDisplay, FormDisplayData formDisplayData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                formDisplayData = formDisplay.data;
            }
            if ((i & 2) != 0) {
                layoutData = formDisplay.context;
            }
            return formDisplay.copy(formDisplayData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final FormDisplayData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final FormDisplay copy(@NotNull FormDisplayData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new FormDisplay(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormDisplay)) {
                return false;
            }
            FormDisplay formDisplay = (FormDisplay) other;
            return Intrinsics.areEqual(this.data, formDisplay.data) && Intrinsics.areEqual(this.context, formDisplay.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "FormDisplay(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FormDisplay(@NotNull FormDisplayData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final FormDisplayData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tj\u0002`\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tj\u0002`\n0\u0007HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tj\u0002`\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\tj\u0002`\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$FormResult;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$FormResultData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "attributes", "", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "channels", "", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$FormResultData;Lcom/urbanairship/android/layout/reporting/LayoutData;Ljava/util/Map;Ljava/util/List;)V", "getAttributes", "()Ljava/util/Map;", "getChannels", "()Ljava/util/List;", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$FormResultData;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FormResult extends ReportingEvent {
        private final Map attributes;
        private final List channels;
        private final LayoutData context;
        private final FormResultData data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FormResult copy$default(FormResult formResult, FormResultData formResultData, LayoutData layoutData, Map map, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                formResultData = formResult.data;
            }
            if ((i & 2) != 0) {
                layoutData = formResult.context;
            }
            if ((i & 4) != 0) {
                map = formResult.attributes;
            }
            if ((i & 8) != 0) {
                list = formResult.channels;
            }
            return formResult.copy(formResultData, layoutData, map, list);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final FormResultData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final Map<AttributeName, JsonValue> component3() {
            return this.attributes;
        }

        @NotNull
        public final List<ThomasChannelRegistration> component4() {
            return this.channels;
        }

        @NotNull
        public final FormResult copy(@NotNull FormResultData data, @NotNull LayoutData context, @NotNull Map<AttributeName, ? extends JsonValue> attributes, @NotNull List<? extends ThomasChannelRegistration> channels) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(channels, "channels");
            return new FormResult(data, context, attributes, channels);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormResult)) {
                return false;
            }
            FormResult formResult = (FormResult) other;
            return Intrinsics.areEqual(this.data, formResult.data) && Intrinsics.areEqual(this.context, formResult.context) && Intrinsics.areEqual(this.attributes, formResult.attributes) && Intrinsics.areEqual(this.channels, formResult.channels);
        }

        public int hashCode() {
            return (((((this.data.hashCode() * 31) + this.context.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.channels.hashCode();
        }

        @NotNull
        public String toString() {
            return "FormResult(data=" + this.data + ", context=" + this.context + ", attributes=" + this.attributes + ", channels=" + this.channels + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final FormResultData getData() {
            return this.data;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final Map<AttributeName, JsonValue> getAttributes() {
            return this.attributes;
        }

        @NotNull
        public final List<ThomasChannelRegistration> getChannels() {
            return this.channels;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FormResult(@NotNull FormResultData data, @NotNull LayoutData context, @NotNull Map<AttributeName, ? extends JsonValue> attributes, @NotNull List<? extends ThomasChannelRegistration> channels) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            Intrinsics.checkNotNullParameter(channels, "channels");
            this.data = data;
            this.context = context;
            this.attributes = attributes;
            this.channels = channels;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$Gesture;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$GestureData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$GestureData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$GestureData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Gesture extends ReportingEvent {
        private final LayoutData context;
        private final GestureData data;

        public static /* synthetic */ Gesture copy$default(Gesture gesture, GestureData gestureData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                gestureData = gesture.data;
            }
            if ((i & 2) != 0) {
                layoutData = gesture.context;
            }
            return gesture.copy(gestureData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final GestureData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final Gesture copy(@NotNull GestureData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new Gesture(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Gesture)) {
                return false;
            }
            Gesture gesture = (Gesture) other;
            return Intrinsics.areEqual(this.data, gesture.data) && Intrinsics.areEqual(this.context, gesture.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "Gesture(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gesture(@NotNull GestureData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final GestureData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$ButtonTap;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$ButtonTapData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$ButtonTapData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$ButtonTapData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ButtonTap extends ReportingEvent {
        private final LayoutData context;
        private final ButtonTapData data;

        public static /* synthetic */ ButtonTap copy$default(ButtonTap buttonTap, ButtonTapData buttonTapData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                buttonTapData = buttonTap.data;
            }
            if ((i & 2) != 0) {
                layoutData = buttonTap.context;
            }
            return buttonTap.copy(buttonTapData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ButtonTapData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final ButtonTap copy(@NotNull ButtonTapData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new ButtonTap(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ButtonTap)) {
                return false;
            }
            ButtonTap buttonTap = (ButtonTap) other;
            return Intrinsics.areEqual(this.data, buttonTap.data) && Intrinsics.areEqual(this.context, buttonTap.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "ButtonTap(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ButtonTap(@NotNull ButtonTapData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final ButtonTapData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageView;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageView extends ReportingEvent {
        private final LayoutData context;
        private final PageViewData data;

        public static /* synthetic */ PageView copy$default(PageView pageView, PageViewData pageViewData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                pageViewData = pageView.data;
            }
            if ((i & 2) != 0) {
                layoutData = pageView.context;
            }
            return pageView.copy(pageViewData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PageViewData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PageView copy(@NotNull PageViewData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new PageView(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageView)) {
                return false;
            }
            PageView pageView = (PageView) other;
            return Intrinsics.areEqual(this.data, pageView.data) && Intrinsics.areEqual(this.context, pageView.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "PageView(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageView(@NotNull PageViewData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PageViewData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageSwipe;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSwipeData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$PageSwipeData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$PageSwipeData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageSwipe extends ReportingEvent {
        private final LayoutData context;
        private final PageSwipeData data;

        public static /* synthetic */ PageSwipe copy$default(PageSwipe pageSwipe, PageSwipeData pageSwipeData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                pageSwipeData = pageSwipe.data;
            }
            if ((i & 2) != 0) {
                layoutData = pageSwipe.context;
            }
            return pageSwipe.copy(pageSwipeData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PageSwipeData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PageSwipe copy(@NotNull PageSwipeData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new PageSwipe(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageSwipe)) {
                return false;
            }
            PageSwipe pageSwipe = (PageSwipe) other;
            return Intrinsics.areEqual(this.data, pageSwipe.data) && Intrinsics.areEqual(this.context, pageSwipe.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "PageSwipe(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageSwipe(@NotNull PageSwipeData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PageSwipeData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageAction;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageActionData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$PageActionData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$PageActionData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageAction extends ReportingEvent {
        private final LayoutData context;
        private final PageActionData data;

        public static /* synthetic */ PageAction copy$default(PageAction pageAction, PageActionData pageActionData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                pageActionData = pageAction.data;
            }
            if ((i & 2) != 0) {
                layoutData = pageAction.context;
            }
            return pageAction.copy(pageActionData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PageActionData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PageAction copy(@NotNull PageActionData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new PageAction(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageAction)) {
                return false;
            }
            PageAction pageAction = (PageAction) other;
            return Intrinsics.areEqual(this.data, pageAction.data) && Intrinsics.areEqual(this.context, pageAction.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "PageAction(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageAction(@NotNull PageActionData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PageActionData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PagerComplete;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$PagerCompleteData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$PagerCompleteData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$PagerCompleteData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PagerComplete extends ReportingEvent {
        private final LayoutData context;
        private final PagerCompleteData data;

        public static /* synthetic */ PagerComplete copy$default(PagerComplete pagerComplete, PagerCompleteData pagerCompleteData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                pagerCompleteData = pagerComplete.data;
            }
            if ((i & 2) != 0) {
                layoutData = pagerComplete.context;
            }
            return pagerComplete.copy(pagerCompleteData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PagerCompleteData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PagerComplete copy(@NotNull PagerCompleteData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new PagerComplete(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PagerComplete)) {
                return false;
            }
            PagerComplete pagerComplete = (PagerComplete) other;
            return Intrinsics.areEqual(this.data, pagerComplete.data) && Intrinsics.areEqual(this.context, pagerComplete.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "PagerComplete(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerComplete(@NotNull PagerCompleteData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PagerCompleteData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PagerSummary;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData;Lcom/urbanairship/android/layout/reporting/LayoutData;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PagerSummary extends ReportingEvent {
        private final LayoutData context;
        private final PageSummaryData data;

        public static /* synthetic */ PagerSummary copy$default(PagerSummary pagerSummary, PageSummaryData pageSummaryData, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                pageSummaryData = pagerSummary.data;
            }
            if ((i & 2) != 0) {
                layoutData = pagerSummary.context;
            }
            return pagerSummary.copy(pageSummaryData, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PageSummaryData getData() {
            return this.data;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PagerSummary copy(@NotNull PageSummaryData data, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new PagerSummary(data, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PagerSummary)) {
                return false;
            }
            PagerSummary pagerSummary = (PagerSummary) other;
            return Intrinsics.areEqual(this.data, pagerSummary.data) && Intrinsics.areEqual(this.context, pagerSummary.context);
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "PagerSummary(data=" + this.data + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagerSummary(@NotNull PageSummaryData data, @NotNull LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final PageSummaryData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$Dismiss;", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "data", "Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;", "displayTime", "Lkotlin/time/Duration;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "(Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;JLcom/urbanairship/android/layout/reporting/LayoutData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContext", "()Lcom/urbanairship/android/layout/reporting/LayoutData;", "getData", "()Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;", "getDisplayTime-UwyO8pc", "()J", "J", "component1", "component2", "component2-UwyO8pc", "component3", "copy", "copy-8Mi8wO0", "(Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;JLcom/urbanairship/android/layout/reporting/LayoutData;)Lcom/urbanairship/android/layout/event/ReportingEvent$Dismiss;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Dismiss extends ReportingEvent {
        private final LayoutData context;
        private final DismissData data;
        private final long displayTime;

        public /* synthetic */ Dismiss(DismissData dismissData, long j, LayoutData layoutData, DefaultConstructorMarker defaultConstructorMarker) {
            this(dismissData, j, layoutData);
        }

        /* renamed from: copy-8Mi8wO0$default, reason: not valid java name */
        public static /* synthetic */ Dismiss m2722copy8Mi8wO0$default(Dismiss dismiss, DismissData dismissData, long j, LayoutData layoutData, int i, Object obj) {
            if ((i & 1) != 0) {
                dismissData = dismiss.data;
            }
            if ((i & 2) != 0) {
                j = dismiss.displayTime;
            }
            if ((i & 4) != 0) {
                layoutData = dismiss.context;
            }
            return dismiss.m2724copy8Mi8wO0(dismissData, j, layoutData);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final DismissData getData() {
            return this.data;
        }

        /* renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
        public final long getDisplayTime() {
            return this.displayTime;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        /* renamed from: copy-8Mi8wO0, reason: not valid java name */
        public final Dismiss m2724copy8Mi8wO0(@NotNull DismissData data, long displayTime, @NotNull LayoutData context) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            return new Dismiss(data, displayTime, context, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dismiss)) {
                return false;
            }
            Dismiss dismiss = (Dismiss) other;
            return Intrinsics.areEqual(this.data, dismiss.data) && Duration.m3472equalsimpl0(this.displayTime, dismiss.displayTime) && Intrinsics.areEqual(this.context, dismiss.context);
        }

        public int hashCode() {
            return (((this.data.hashCode() * 31) + Duration.m3494hashCodeimpl(this.displayTime)) * 31) + this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "Dismiss(data=" + this.data + ", displayTime=" + ((Object) Duration.m3515toStringimpl(this.displayTime)) + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Dismiss(DismissData data, long j, LayoutData context) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            this.data = data;
            this.displayTime = j;
            this.context = context;
        }

        @NotNull
        public final LayoutData getContext() {
            return this.context;
        }

        @NotNull
        public final DismissData getData() {
            return this.data;
        }

        /* renamed from: getDisplayTime-UwyO8pc, reason: not valid java name */
        public final long m2725getDisplayTimeUwyO8pc() {
            return this.displayTime;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;", "", "()V", "ButtonTapped", "TimedOut", "UserDismissed", "Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData$ButtonTapped;", "Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData$TimedOut;", "Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData$UserDismissed;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class DismissData {
        public /* synthetic */ DismissData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DismissData() {
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData$ButtonTapped;", "Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;", "identifier", "", "description", "cancel", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCancel", "()Z", "getDescription", "()Ljava/lang/String;", "getIdentifier", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ButtonTapped extends DismissData {
            private final boolean cancel;
            private final String description;
            private final String identifier;

            public static /* synthetic */ ButtonTapped copy$default(ButtonTapped buttonTapped, String str, String str2, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = buttonTapped.identifier;
                }
                if ((i & 2) != 0) {
                    str2 = buttonTapped.description;
                }
                if ((i & 4) != 0) {
                    z = buttonTapped.cancel;
                }
                return buttonTapped.copy(str, str2, z);
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

            /* renamed from: component3, reason: from getter */
            public final boolean getCancel() {
                return this.cancel;
            }

            @NotNull
            public final ButtonTapped copy(@NotNull String identifier, @NotNull String description, boolean cancel) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(description, "description");
                return new ButtonTapped(identifier, description, cancel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ButtonTapped)) {
                    return false;
                }
                ButtonTapped buttonTapped = (ButtonTapped) other;
                return Intrinsics.areEqual(this.identifier, buttonTapped.identifier) && Intrinsics.areEqual(this.description, buttonTapped.description) && this.cancel == buttonTapped.cancel;
            }

            public int hashCode() {
                return (((this.identifier.hashCode() * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.cancel);
            }

            @NotNull
            public String toString() {
                return "ButtonTapped(identifier=" + this.identifier + ", description=" + this.description + ", cancel=" + this.cancel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final String getIdentifier() {
                return this.identifier;
            }

            @NotNull
            public final String getDescription() {
                return this.description;
            }

            public final boolean getCancel() {
                return this.cancel;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ButtonTapped(@NotNull String identifier, @NotNull String description, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(description, "description");
                this.identifier = identifier;
                this.description = description;
                this.cancel = z;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData$TimedOut;", "Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class TimedOut extends DismissData {

            @NotNull
            public static final TimedOut INSTANCE = new TimedOut();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof TimedOut);
            }

            public int hashCode() {
                return -1645299129;
            }

            @NotNull
            public String toString() {
                return "TimedOut";
            }

            private TimedOut() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData$UserDismissed;", "Lcom/urbanairship/android/layout/event/ReportingEvent$DismissData;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UserDismissed extends DismissData {

            @NotNull
            public static final UserDismissed INSTANCE = new UserDismissed();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof UserDismissed);
            }

            public int hashCode() {
                return 1442197870;
            }

            @NotNull
            public String toString() {
                return "UserDismissed";
            }

            private UserDismissed() {
                super(null);
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\b\u0010 \u001a\u00020!H\u0016J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006$"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "pageIdentifier", "pageIndex", "", "pageViewCount", "pageCount", "completed", "", "(Ljava/lang/String;Ljava/lang/String;IIIZ)V", "getCompleted", "()Z", "getIdentifier", "()Ljava/lang/String;", "getPageCount", "()I", "getPageIdentifier", "getPageIndex", "getPageViewCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageViewData implements JsonSerializable {
        private final boolean completed;
        private final String identifier;
        private final int pageCount;
        private final String pageIdentifier;
        private final int pageIndex;
        private final int pageViewCount;

        public static /* synthetic */ PageViewData copy$default(PageViewData pageViewData, String str, String str2, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = pageViewData.identifier;
            }
            if ((i4 & 2) != 0) {
                str2 = pageViewData.pageIdentifier;
            }
            String str3 = str2;
            if ((i4 & 4) != 0) {
                i = pageViewData.pageIndex;
            }
            int i5 = i;
            if ((i4 & 8) != 0) {
                i2 = pageViewData.pageViewCount;
            }
            int i6 = i2;
            if ((i4 & 16) != 0) {
                i3 = pageViewData.pageCount;
            }
            int i7 = i3;
            if ((i4 & 32) != 0) {
                z = pageViewData.completed;
            }
            return pageViewData.copy(str, str3, i5, i6, i7, z);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getPageIdentifier() {
            return this.pageIdentifier;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* renamed from: component4, reason: from getter */
        public final int getPageViewCount() {
            return this.pageViewCount;
        }

        /* renamed from: component5, reason: from getter */
        public final int getPageCount() {
            return this.pageCount;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getCompleted() {
            return this.completed;
        }

        @NotNull
        public final PageViewData copy(@NotNull String identifier, @NotNull String pageIdentifier, int pageIndex, int pageViewCount, int pageCount, boolean completed) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIdentifier, "pageIdentifier");
            return new PageViewData(identifier, pageIdentifier, pageIndex, pageViewCount, pageCount, completed);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageViewData)) {
                return false;
            }
            PageViewData pageViewData = (PageViewData) other;
            return Intrinsics.areEqual(this.identifier, pageViewData.identifier) && Intrinsics.areEqual(this.pageIdentifier, pageViewData.pageIdentifier) && this.pageIndex == pageViewData.pageIndex && this.pageViewCount == pageViewData.pageViewCount && this.pageCount == pageViewData.pageCount && this.completed == pageViewData.completed;
        }

        public int hashCode() {
            return (((((((((this.identifier.hashCode() * 31) + this.pageIdentifier.hashCode()) * 31) + Integer.hashCode(this.pageIndex)) * 31) + Integer.hashCode(this.pageViewCount)) * 31) + Integer.hashCode(this.pageCount)) * 31) + Boolean.hashCode(this.completed);
        }

        @NotNull
        public String toString() {
            return "PageViewData(identifier=" + this.identifier + ", pageIdentifier=" + this.pageIdentifier + ", pageIndex=" + this.pageIndex + ", pageViewCount=" + this.pageViewCount + ", pageCount=" + this.pageCount + ", completed=" + this.completed + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PageViewData(@NotNull String identifier, @NotNull String pageIdentifier, int i, int i2, int i3, boolean z) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIdentifier, "pageIdentifier");
            this.identifier = identifier;
            this.pageIdentifier = pageIdentifier;
            this.pageIndex = i;
            this.pageViewCount = i2;
            this.pageCount = i3;
            this.completed = z;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final String getPageIdentifier() {
            return this.pageIdentifier;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final int getPageViewCount() {
            return this.pageViewCount;
        }

        public final int getPageCount() {
            return this.pageCount;
        }

        public final boolean getCompleted() {
            return this.completed;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("pager_identifier", this.identifier), TuplesKt.to("page_index", Integer.valueOf(this.pageIndex)), TuplesKt.to("page_count", Integer.valueOf(this.pageCount)), TuplesKt.to("viewed_count", Integer.valueOf(this.pageViewCount)), TuplesKt.to("page_identifier", this.pageIdentifier), TuplesKt.to("completed", Boolean.valueOf(this.completed))).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PagerCompleteData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "pageIndex", "", "pageCount", "pageIdentifier", "(Ljava/lang/String;IILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "getPageCount", "()I", "getPageIdentifier", "getPageIndex", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PagerCompleteData implements JsonSerializable {
        private final String identifier;
        private final int pageCount;
        private final String pageIdentifier;
        private final int pageIndex;

        public static /* synthetic */ PagerCompleteData copy$default(PagerCompleteData pagerCompleteData, String str, int i, int i2, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pagerCompleteData.identifier;
            }
            if ((i3 & 2) != 0) {
                i = pagerCompleteData.pageIndex;
            }
            if ((i3 & 4) != 0) {
                i2 = pagerCompleteData.pageCount;
            }
            if ((i3 & 8) != 0) {
                str2 = pagerCompleteData.pageIdentifier;
            }
            return pagerCompleteData.copy(str, i, i2, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPageCount() {
            return this.pageCount;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getPageIdentifier() {
            return this.pageIdentifier;
        }

        @NotNull
        public final PagerCompleteData copy(@NotNull String identifier, int pageIndex, int pageCount, @NotNull String pageIdentifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIdentifier, "pageIdentifier");
            return new PagerCompleteData(identifier, pageIndex, pageCount, pageIdentifier);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PagerCompleteData)) {
                return false;
            }
            PagerCompleteData pagerCompleteData = (PagerCompleteData) other;
            return Intrinsics.areEqual(this.identifier, pagerCompleteData.identifier) && this.pageIndex == pagerCompleteData.pageIndex && this.pageCount == pagerCompleteData.pageCount && Intrinsics.areEqual(this.pageIdentifier, pagerCompleteData.pageIdentifier);
        }

        public int hashCode() {
            return (((((this.identifier.hashCode() * 31) + Integer.hashCode(this.pageIndex)) * 31) + Integer.hashCode(this.pageCount)) * 31) + this.pageIdentifier.hashCode();
        }

        @NotNull
        public String toString() {
            return "PagerCompleteData(identifier=" + this.identifier + ", pageIndex=" + this.pageIndex + ", pageCount=" + this.pageCount + ", pageIdentifier=" + this.pageIdentifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PagerCompleteData(@NotNull String identifier, int i, int i2, @NotNull String pageIdentifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIdentifier, "pageIdentifier");
            this.identifier = identifier;
            this.pageIndex = i;
            this.pageCount = i2;
            this.pageIdentifier = pageIdentifier;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final int getPageCount() {
            return this.pageCount;
        }

        @NotNull
        public final String getPageIdentifier() {
            return this.pageIdentifier;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("pager_identifier", this.identifier), TuplesKt.to("page_index", Integer.valueOf(this.pageIndex)), TuplesKt.to("page_count", Integer.valueOf(this.pageCount)), TuplesKt.to("page_identifier", this.pageIdentifier)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageSwipeData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "toPageIndex", "", "toPageIdentifier", "fromPageIndex", "fromPageIdentifier", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getFromPageIdentifier", "()Ljava/lang/String;", "getFromPageIndex", "()I", "getIdentifier", "getToPageIdentifier", "getToPageIndex", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageSwipeData implements JsonSerializable {
        private final String fromPageIdentifier;
        private final int fromPageIndex;
        private final String identifier;
        private final String toPageIdentifier;
        private final int toPageIndex;

        public static /* synthetic */ PageSwipeData copy$default(PageSwipeData pageSwipeData, String str, int i, String str2, int i2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pageSwipeData.identifier;
            }
            if ((i3 & 2) != 0) {
                i = pageSwipeData.toPageIndex;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                str2 = pageSwipeData.toPageIdentifier;
            }
            String str4 = str2;
            if ((i3 & 8) != 0) {
                i2 = pageSwipeData.fromPageIndex;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                str3 = pageSwipeData.fromPageIdentifier;
            }
            return pageSwipeData.copy(str, i4, str4, i5, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* renamed from: component2, reason: from getter */
        public final int getToPageIndex() {
            return this.toPageIndex;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getToPageIdentifier() {
            return this.toPageIdentifier;
        }

        /* renamed from: component4, reason: from getter */
        public final int getFromPageIndex() {
            return this.fromPageIndex;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final String getFromPageIdentifier() {
            return this.fromPageIdentifier;
        }

        @NotNull
        public final PageSwipeData copy(@NotNull String identifier, int toPageIndex, @NotNull String toPageIdentifier, int fromPageIndex, @NotNull String fromPageIdentifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(toPageIdentifier, "toPageIdentifier");
            Intrinsics.checkNotNullParameter(fromPageIdentifier, "fromPageIdentifier");
            return new PageSwipeData(identifier, toPageIndex, toPageIdentifier, fromPageIndex, fromPageIdentifier);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageSwipeData)) {
                return false;
            }
            PageSwipeData pageSwipeData = (PageSwipeData) other;
            return Intrinsics.areEqual(this.identifier, pageSwipeData.identifier) && this.toPageIndex == pageSwipeData.toPageIndex && Intrinsics.areEqual(this.toPageIdentifier, pageSwipeData.toPageIdentifier) && this.fromPageIndex == pageSwipeData.fromPageIndex && Intrinsics.areEqual(this.fromPageIdentifier, pageSwipeData.fromPageIdentifier);
        }

        public int hashCode() {
            return (((((((this.identifier.hashCode() * 31) + Integer.hashCode(this.toPageIndex)) * 31) + this.toPageIdentifier.hashCode()) * 31) + Integer.hashCode(this.fromPageIndex)) * 31) + this.fromPageIdentifier.hashCode();
        }

        @NotNull
        public String toString() {
            return "PageSwipeData(identifier=" + this.identifier + ", toPageIndex=" + this.toPageIndex + ", toPageIdentifier=" + this.toPageIdentifier + ", fromPageIndex=" + this.fromPageIndex + ", fromPageIdentifier=" + this.fromPageIdentifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PageSwipeData(@NotNull String identifier, int i, @NotNull String toPageIdentifier, int i2, @NotNull String fromPageIdentifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(toPageIdentifier, "toPageIdentifier");
            Intrinsics.checkNotNullParameter(fromPageIdentifier, "fromPageIdentifier");
            this.identifier = identifier;
            this.toPageIndex = i;
            this.toPageIdentifier = toPageIdentifier;
            this.fromPageIndex = i2;
            this.fromPageIdentifier = fromPageIdentifier;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        public final int getToPageIndex() {
            return this.toPageIndex;
        }

        @NotNull
        public final String getToPageIdentifier() {
            return this.toPageIdentifier;
        }

        public final int getFromPageIndex() {
            return this.fromPageIndex;
        }

        @NotNull
        public final String getFromPageIdentifier() {
            return this.fromPageIdentifier;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("pager_identifier", this.identifier), TuplesKt.to("to_page_index", Integer.valueOf(this.toPageIndex)), TuplesKt.to("to_page_identifier", this.toPageIdentifier), TuplesKt.to("from_page_index", Integer.valueOf(this.fromPageIndex)), TuplesKt.to("from_page_identifier", this.fromPageIdentifier)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageActionData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "metadata", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;)V", "getIdentifier", "()Ljava/lang/String;", "getMetadata", "()Lcom/urbanairship/json/JsonSerializable;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageActionData implements JsonSerializable {
        private final String identifier;
        private final JsonSerializable metadata;

        public static /* synthetic */ PageActionData copy$default(PageActionData pageActionData, String str, JsonSerializable jsonSerializable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageActionData.identifier;
            }
            if ((i & 2) != 0) {
                jsonSerializable = pageActionData.metadata;
            }
            return pageActionData.copy(str, jsonSerializable);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonSerializable getMetadata() {
            return this.metadata;
        }

        @NotNull
        public final PageActionData copy(@NotNull String identifier, @Nullable JsonSerializable metadata) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new PageActionData(identifier, metadata);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageActionData)) {
                return false;
            }
            PageActionData pageActionData = (PageActionData) other;
            return Intrinsics.areEqual(this.identifier, pageActionData.identifier) && Intrinsics.areEqual(this.metadata, pageActionData.metadata);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonSerializable jsonSerializable = this.metadata;
            return iHashCode + (jsonSerializable == null ? 0 : jsonSerializable.hashCode());
        }

        @NotNull
        public String toString() {
            return "PageActionData(identifier=" + this.identifier + ", metadata=" + this.metadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PageActionData(@NotNull String identifier, @Nullable JsonSerializable jsonSerializable) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.metadata = jsonSerializable;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final JsonSerializable getMetadata() {
            return this.metadata;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("action_identifier", this.identifier), TuplesKt.to("reporting_metadata", this.metadata)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "viewedPages", "", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData$PageView;", "pageCount", "", "completed", "", "(Ljava/lang/String;Ljava/util/List;IZ)V", "getCompleted", "()Z", "getIdentifier", "()Ljava/lang/String;", "getPageCount", "()I", "getViewedPages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "PageView", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageSummaryData implements JsonSerializable {
        private final boolean completed;
        private final String identifier;
        private final int pageCount;
        private final List viewedPages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageSummaryData copy$default(PageSummaryData pageSummaryData, String str, List list, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = pageSummaryData.identifier;
            }
            if ((i2 & 2) != 0) {
                list = pageSummaryData.viewedPages;
            }
            if ((i2 & 4) != 0) {
                i = pageSummaryData.pageCount;
            }
            if ((i2 & 8) != 0) {
                z = pageSummaryData.completed;
            }
            return pageSummaryData.copy(str, list, i, z);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final List<PageView> component2() {
            return this.viewedPages;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPageCount() {
            return this.pageCount;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCompleted() {
            return this.completed;
        }

        @NotNull
        public final PageSummaryData copy(@NotNull String identifier, @NotNull List<PageView> viewedPages, int pageCount, boolean completed) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(viewedPages, "viewedPages");
            return new PageSummaryData(identifier, viewedPages, pageCount, completed);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageSummaryData)) {
                return false;
            }
            PageSummaryData pageSummaryData = (PageSummaryData) other;
            return Intrinsics.areEqual(this.identifier, pageSummaryData.identifier) && Intrinsics.areEqual(this.viewedPages, pageSummaryData.viewedPages) && this.pageCount == pageSummaryData.pageCount && this.completed == pageSummaryData.completed;
        }

        public int hashCode() {
            return (((((this.identifier.hashCode() * 31) + this.viewedPages.hashCode()) * 31) + Integer.hashCode(this.pageCount)) * 31) + Boolean.hashCode(this.completed);
        }

        @NotNull
        public String toString() {
            return "PageSummaryData(identifier=" + this.identifier + ", viewedPages=" + this.viewedPages + ", pageCount=" + this.pageCount + ", completed=" + this.completed + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PageSummaryData(@NotNull String identifier, @NotNull List<PageView> viewedPages, int i, boolean z) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(viewedPages, "viewedPages");
            this.identifier = identifier;
            this.viewedPages = viewedPages;
            this.pageCount = i;
            this.completed = z;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final List<PageView> getViewedPages() {
            return this.viewedPages;
        }

        public final int getPageCount() {
            return this.pageCount;
        }

        public final boolean getCompleted() {
            return this.completed;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0016\u0010\u0012\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\nJ1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData$PageView;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "index", "", "displayTime", "Lkotlin/time/Duration;", "(Ljava/lang/String;IJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDisplayTime-UwyO8pc", "()J", "J", "getIdentifier", "()Ljava/lang/String;", "getIndex", "()I", "component1", "component2", "component3", "component3-UwyO8pc", "copy", "copy-SxA4cEA", "(Ljava/lang/String;IJ)Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData$PageView;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PageView implements JsonSerializable {
            private final long displayTime;
            private final String identifier;
            private final int index;

            public /* synthetic */ PageView(String str, int i, long j, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i, j);
            }

            /* renamed from: copy-SxA4cEA$default, reason: not valid java name */
            public static /* synthetic */ PageView m2726copySxA4cEA$default(PageView pageView, String str, int i, long j, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = pageView.identifier;
                }
                if ((i2 & 2) != 0) {
                    i = pageView.index;
                }
                if ((i2 & 4) != 0) {
                    j = pageView.displayTime;
                }
                return pageView.m2728copySxA4cEA(str, i, j);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getIdentifier() {
                return this.identifier;
            }

            /* renamed from: component2, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            /* renamed from: component3-UwyO8pc, reason: not valid java name and from getter */
            public final long getDisplayTime() {
                return this.displayTime;
            }

            @NotNull
            /* renamed from: copy-SxA4cEA, reason: not valid java name */
            public final PageView m2728copySxA4cEA(@NotNull String identifier, int index, long displayTime) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new PageView(identifier, index, displayTime, null);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PageView)) {
                    return false;
                }
                PageView pageView = (PageView) other;
                return Intrinsics.areEqual(this.identifier, pageView.identifier) && this.index == pageView.index && Duration.m3472equalsimpl0(this.displayTime, pageView.displayTime);
            }

            public int hashCode() {
                return (((this.identifier.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + Duration.m3494hashCodeimpl(this.displayTime);
            }

            @NotNull
            public String toString() {
                return "PageView(identifier=" + this.identifier + ", index=" + this.index + ", displayTime=" + ((Object) Duration.m3515toStringimpl(this.displayTime)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            private PageView(String identifier, int i, long j) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                this.identifier = identifier;
                this.index = i;
                this.displayTime = j;
            }

            @NotNull
            public final String getIdentifier() {
                return this.identifier;
            }

            public final int getIndex() {
                return this.index;
            }

            /* renamed from: getDisplayTime-UwyO8pc, reason: not valid java name */
            public final long m2729getDisplayTimeUwyO8pc() {
                return this.displayTime;
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() {
                double dM3485getInWholeMillisecondsimpl = Duration.m3485getInWholeMillisecondsimpl(this.displayTime) / 1000.0d;
                Pair pair = TuplesKt.to("page_identifier", this.identifier);
                Pair pair2 = TuplesKt.to("page_index", Integer.valueOf(this.index));
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dM3485getInWholeMillisecondsimpl)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, pair2, TuplesKt.to("display_time", str)).toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("pager_identifier", this.identifier), TuplesKt.to("viewed_pages", this.viewedPages), TuplesKt.to("page_count", Integer.valueOf(this.pageCount)), TuplesKt.to("completed", Boolean.valueOf(this.completed))).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$GestureData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "reportingMetadata", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;)V", "getIdentifier", "()Ljava/lang/String;", "getReportingMetadata", "()Lcom/urbanairship/json/JsonSerializable;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GestureData implements JsonSerializable {
        private final String identifier;
        private final JsonSerializable reportingMetadata;

        public static /* synthetic */ GestureData copy$default(GestureData gestureData, String str, JsonSerializable jsonSerializable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gestureData.identifier;
            }
            if ((i & 2) != 0) {
                jsonSerializable = gestureData.reportingMetadata;
            }
            return gestureData.copy(str, jsonSerializable);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonSerializable getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        public final GestureData copy(@NotNull String identifier, @Nullable JsonSerializable reportingMetadata) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new GestureData(identifier, reportingMetadata);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GestureData)) {
                return false;
            }
            GestureData gestureData = (GestureData) other;
            return Intrinsics.areEqual(this.identifier, gestureData.identifier) && Intrinsics.areEqual(this.reportingMetadata, gestureData.reportingMetadata);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonSerializable jsonSerializable = this.reportingMetadata;
            return iHashCode + (jsonSerializable == null ? 0 : jsonSerializable.hashCode());
        }

        @NotNull
        public String toString() {
            return "GestureData(identifier=" + this.identifier + ", reportingMetadata=" + this.reportingMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public GestureData(@NotNull String identifier, @Nullable JsonSerializable jsonSerializable) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.reportingMetadata = jsonSerializable;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final JsonSerializable getReportingMetadata() {
            return this.reportingMetadata;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("gesture_identifier", this.identifier), TuplesKt.to("reporting_metadata", this.reportingMetadata)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$ButtonTapData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "reportingMetadata", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;)V", "getIdentifier", "()Ljava/lang/String;", "getReportingMetadata", "()Lcom/urbanairship/json/JsonSerializable;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* data */ class ButtonTapData implements JsonSerializable {
        private final String identifier;
        private final JsonSerializable reportingMetadata;

        public static /* synthetic */ ButtonTapData copy$default(ButtonTapData buttonTapData, String str, JsonSerializable jsonSerializable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = buttonTapData.identifier;
            }
            if ((i & 2) != 0) {
                jsonSerializable = buttonTapData.reportingMetadata;
            }
            return buttonTapData.copy(str, jsonSerializable);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonSerializable getReportingMetadata() {
            return this.reportingMetadata;
        }

        @NotNull
        public final ButtonTapData copy(@NotNull String identifier, @Nullable JsonSerializable reportingMetadata) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new ButtonTapData(identifier, reportingMetadata);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ButtonTapData)) {
                return false;
            }
            ButtonTapData buttonTapData = (ButtonTapData) other;
            return Intrinsics.areEqual(this.identifier, buttonTapData.identifier) && Intrinsics.areEqual(this.reportingMetadata, buttonTapData.reportingMetadata);
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            JsonSerializable jsonSerializable = this.reportingMetadata;
            return iHashCode + (jsonSerializable == null ? 0 : jsonSerializable.hashCode());
        }

        @NotNull
        public String toString() {
            return "ButtonTapData(identifier=" + this.identifier + ", reportingMetadata=" + this.reportingMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ButtonTapData(@NotNull String identifier, @Nullable JsonSerializable jsonSerializable) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.reportingMetadata = jsonSerializable;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final JsonSerializable getReportingMetadata() {
            return this.reportingMetadata;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("button_identifier", this.identifier), TuplesKt.to("reporting_metadata", this.reportingMetadata)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$FormDisplayData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "formType", "responseType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFormType", "()Ljava/lang/String;", "getIdentifier", "getResponseType", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FormDisplayData implements JsonSerializable {
        private final String formType;
        private final String identifier;
        private final String responseType;

        public static /* synthetic */ FormDisplayData copy$default(FormDisplayData formDisplayData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formDisplayData.identifier;
            }
            if ((i & 2) != 0) {
                str2 = formDisplayData.formType;
            }
            if ((i & 4) != 0) {
                str3 = formDisplayData.responseType;
            }
            return formDisplayData.copy(str, str2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getFormType() {
            return this.formType;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getResponseType() {
            return this.responseType;
        }

        @NotNull
        public final FormDisplayData copy(@NotNull String identifier, @NotNull String formType, @Nullable String responseType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(formType, "formType");
            return new FormDisplayData(identifier, formType, responseType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormDisplayData)) {
                return false;
            }
            FormDisplayData formDisplayData = (FormDisplayData) other;
            return Intrinsics.areEqual(this.identifier, formDisplayData.identifier) && Intrinsics.areEqual(this.formType, formDisplayData.formType) && Intrinsics.areEqual(this.responseType, formDisplayData.responseType);
        }

        public int hashCode() {
            int iHashCode = ((this.identifier.hashCode() * 31) + this.formType.hashCode()) * 31;
            String str = this.responseType;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "FormDisplayData(identifier=" + this.identifier + ", formType=" + this.formType + ", responseType=" + this.responseType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public FormDisplayData(@NotNull String identifier, @NotNull String formType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(formType, "formType");
            this.identifier = identifier;
            this.formType = formType;
            this.responseType = str;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final String getFormType() {
            return this.formType;
        }

        @Nullable
        public final String getResponseType() {
            return this.responseType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("form_identifier", this.identifier), TuplesKt.to("form_type", this.formType), TuplesKt.to("form_response_type", this.responseType)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/event/ReportingEvent$FormResultData;", "Lcom/urbanairship/json/JsonSerializable;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "forms", "<init>", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;)V", "Lcom/urbanairship/json/JsonValue;", "toJsonValue", "()Lcom/urbanairship/json/JsonValue;", "copy", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;)Lcom/urbanairship/android/layout/event/ReportingEvent$FormResultData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FormResultData implements JsonSerializable {
        private final ThomasFormField.BaseForm forms;

        public static /* synthetic */ FormResultData copy$default(FormResultData formResultData, ThomasFormField.BaseForm baseForm, int i, Object obj) {
            if ((i & 1) != 0) {
                baseForm = formResultData.forms;
            }
            return formResultData.copy(baseForm);
        }

        @NotNull
        public final FormResultData copy(@Nullable ThomasFormField.BaseForm forms) {
            return new FormResultData(forms);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FormResultData) && Intrinsics.areEqual(this.forms, ((FormResultData) other).forms);
        }

        public int hashCode() {
            ThomasFormField.BaseForm baseForm = this.forms;
            if (baseForm == null) {
                return 0;
            }
            return baseForm.hashCode();
        }

        @NotNull
        public String toString() {
            return "FormResultData(forms=" + this.forms + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public FormResultData(@Nullable ThomasFormField.BaseForm baseForm) {
            this.forms = baseForm;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            ThomasFormField.BaseForm baseForm = this.forms;
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("forms", baseForm != null ? baseForm.toJsonValue(false) : null)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
