package com.urbanairship.iam.legacy;

import com.urbanairship.analytics.EventType;
import com.urbanairship.iam.analytics.events.InAppEvent;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes5.dex */
final class LegacyResolutionEvent implements InAppEvent {
    public static final Companion Companion = new Companion(null);
    private final JsonSerializable data;
    private final EventType eventType = EventType.IN_APP_RESOLUTION;

    public LegacyResolutionEvent(JsonSerializable jsonSerializable) {
        this.data = jsonSerializable;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    public EventType getEventType() {
        return this.eventType;
    }

    @Override // com.urbanairship.iam.analytics.events.InAppEvent
    public JsonSerializable getData() {
        return this.data;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyResolutionEvent$Companion;", "", "()V", "DIRECT_OPEN", "", "REPLACED", "REPLACEMENT_ID", "RESOLUTION_TYPE", "directOpen", "Lcom/urbanairship/iam/legacy/LegacyResolutionEvent;", "replaced", "replacementID", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final LegacyResolutionEvent replaced(@NotNull String replacementID) {
            Intrinsics.checkNotNullParameter(replacementID, "replacementID");
            return new LegacyResolutionEvent(JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "replaced"), TuplesKt.to("replacement_id", replacementID)));
        }

        @NotNull
        public final LegacyResolutionEvent directOpen() {
            return new LegacyResolutionEvent(JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "direct_open")));
        }
    }
}
