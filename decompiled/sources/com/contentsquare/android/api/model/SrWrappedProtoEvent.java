package com.contentsquare.android.api.model;

import com.contentsquare.android.sdk.AbstractC0707i6;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/api/model/SrWrappedProtoEvent;", "Lcom/contentsquare/android/sdk/i6;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;", "baseEvent", "<init>", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;)V", "toProto", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Event;", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class SrWrappedProtoEvent extends AbstractC0707i6 {

    @NotNull
    private final SessionRecordingV1.Event baseEvent;

    public SrWrappedProtoEvent(@NotNull SessionRecordingV1.Event baseEvent) {
        Intrinsics.checkNotNullParameter(baseEvent, "baseEvent");
        this.baseEvent = baseEvent;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto, reason: from getter */
    public SessionRecordingV1.Event getBaseEvent() {
        return this.baseEvent;
    }
}
