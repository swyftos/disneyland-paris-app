package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.android.core.utils.UriBuilder;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.facebook.react.uimanager.ViewProps;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.urbanairship.channel.AttributeMutation;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/EventPayloadKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EventPayloadKt {

    @NotNull
    public static final EventPayloadKt INSTANCE = new EventPayloadKt();

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020$J%\u0010%\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b&J+\u0010'\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)H\u0007¢\u0006\u0002\b*J\u001d\u0010+\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b,J&\u0010-\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b.J,\u0010-\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)H\u0087\n¢\u0006\u0002\b/J.\u00100\u001a\u00020!*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u00101\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b2R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/EventPayloadKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventPayload$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventPayload$Builder;)V", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;", "Lcom/contentsquare/proto/sessionreplay/v1/EventPayloadKt$Dsl$EventsProxy;", "getEvents", "()Lcom/google/protobuf/kotlin/DslList;", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventPayload$Position;", ViewProps.POSITION, "getPosition", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventPayload$Position;", "setPosition", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventPayload$Position;)V", "", "positionValue", "getPositionValue", "()I", "setPositionValue", "(I)V", "", "schemaVersion", "getSchemaVersion", "()Ljava/lang/String;", "setSchemaVersion", "(Ljava/lang/String;)V", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventPayload;", "clearPosition", "", "clearSchemaVersion", "hasPosition", "", "add", "addEvents", "addAll", "values", "", "addAllEvents", "clear", "clearEvents", "plusAssign", "plusAssignEvents", "plusAssignAllEvents", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setEvents", "Companion", "EventsProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.EventPayload.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/EventPayloadKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/EventPayloadKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$EventPayload$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.EventPayload.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/EventPayloadKt$Dsl$EventsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class EventsProxy extends DslProxy {
            private EventsProxy() {
            }
        }

        private Dsl(SessionRecordingV1.EventPayload.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.EventPayload _build() {
            SessionRecordingV1.EventPayload eventPayloadBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(eventPayloadBuild, "_builder.build()");
            return eventPayloadBuild;
        }

        @JvmName(name = "addAllEvents")
        public final /* synthetic */ void addAllEvents(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllEvents(values);
        }

        @JvmName(name = "addEvents")
        public final /* synthetic */ void addEvents(DslList dslList, SessionRecordingV1.Event value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addEvents(value);
        }

        @JvmName(name = "clearEvents")
        public final /* synthetic */ void clearEvents(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearEvents();
        }

        public final void clearPosition() {
            this._builder.clearPosition();
        }

        public final void clearSchemaVersion() {
            this._builder.clearSchemaVersion();
        }

        public final /* synthetic */ DslList getEvents() {
            List<SessionRecordingV1.Event> eventsList = this._builder.getEventsList();
            Intrinsics.checkNotNullExpressionValue(eventsList, "_builder.getEventsList()");
            return new DslList(eventsList);
        }

        @JvmName(name = "getPosition")
        @NotNull
        public final SessionRecordingV1.EventPayload.Position getPosition() {
            SessionRecordingV1.EventPayload.Position position = this._builder.getPosition();
            Intrinsics.checkNotNullExpressionValue(position, "_builder.getPosition()");
            return position;
        }

        @JvmName(name = "getPositionValue")
        public final int getPositionValue() {
            return this._builder.getPositionValue();
        }

        @JvmName(name = "getSchemaVersion")
        @NotNull
        public final String getSchemaVersion() {
            String schemaVersion = this._builder.getSchemaVersion();
            Intrinsics.checkNotNullExpressionValue(schemaVersion, "_builder.getSchemaVersion()");
            return schemaVersion;
        }

        public final boolean hasPosition() {
            return this._builder.hasPosition();
        }

        @JvmName(name = "plusAssignAllEvents")
        public final /* synthetic */ void plusAssignAllEvents(DslList<SessionRecordingV1.Event, EventsProxy> dslList, Iterable<SessionRecordingV1.Event> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllEvents(dslList, values);
        }

        @JvmName(name = "plusAssignEvents")
        public final /* synthetic */ void plusAssignEvents(DslList<SessionRecordingV1.Event, EventsProxy> dslList, SessionRecordingV1.Event value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addEvents(dslList, value);
        }

        @JvmName(name = "setEvents")
        public final /* synthetic */ void setEvents(DslList dslList, int i, SessionRecordingV1.Event value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEvents(i, value);
        }

        @JvmName(name = "setPosition")
        public final void setPosition(SessionRecordingV1.EventPayload.Position value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPosition(value);
        }

        @JvmName(name = "setPositionValue")
        public final void setPositionValue(int i) {
            this._builder.setPositionValue(i);
        }

        @JvmName(name = "setSchemaVersion")
        public final void setSchemaVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSchemaVersion(value);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.EventPayload.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private EventPayloadKt() {
    }
}
