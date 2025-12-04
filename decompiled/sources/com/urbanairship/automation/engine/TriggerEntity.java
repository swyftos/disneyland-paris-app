package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import androidx.room.TypeConverters;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonTypeConverters;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@TypeConverters({JsonTypeConverters.class})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0006\u0010 \u001a\u00020\u0003R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006!"}, d2 = {"Lcom/urbanairship/automation/engine/TriggerEntity;", "", "triggerData", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "(Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;)V", "id", "", "triggerId", "", "scheduleId", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/json/JsonValue;", "(ILjava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getId", "()I", "setId", "(I)V", "getScheduleId", "()Ljava/lang/String;", "getState", "()Lcom/urbanairship/json/JsonValue;", "getTriggerId", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "toTriggerData", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity(tableName = "automation_trigger_data")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class TriggerEntity {
    private int id;
    private final String scheduleId;
    private final JsonValue state;
    private final String triggerId;

    public static /* synthetic */ TriggerEntity copy$default(TriggerEntity triggerEntity, int i, String str, String str2, JsonValue jsonValue, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = triggerEntity.id;
        }
        if ((i2 & 2) != 0) {
            str = triggerEntity.triggerId;
        }
        if ((i2 & 4) != 0) {
            str2 = triggerEntity.scheduleId;
        }
        if ((i2 & 8) != 0) {
            jsonValue = triggerEntity.state;
        }
        return triggerEntity.copy(i, str, str2, jsonValue);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTriggerId() {
        return this.triggerId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final JsonValue getState() {
        return this.state;
    }

    @NotNull
    public final TriggerEntity copy(int id, @NotNull String triggerId, @NotNull String scheduleId, @NotNull JsonValue state) {
        Intrinsics.checkNotNullParameter(triggerId, "triggerId");
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(state, "state");
        return new TriggerEntity(id, triggerId, scheduleId, state);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TriggerEntity)) {
            return false;
        }
        TriggerEntity triggerEntity = (TriggerEntity) other;
        return this.id == triggerEntity.id && Intrinsics.areEqual(this.triggerId, triggerEntity.triggerId) && Intrinsics.areEqual(this.scheduleId, triggerEntity.scheduleId) && Intrinsics.areEqual(this.state, triggerEntity.state);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.triggerId.hashCode()) * 31) + this.scheduleId.hashCode()) * 31) + this.state.hashCode();
    }

    @NotNull
    public String toString() {
        return "TriggerEntity(id=" + this.id + ", triggerId=" + this.triggerId + ", scheduleId=" + this.scheduleId + ", state=" + this.state + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TriggerEntity(int i, @NotNull String triggerId, @NotNull String scheduleId, @NotNull JsonValue state) {
        Intrinsics.checkNotNullParameter(triggerId, "triggerId");
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(state, "state");
        this.id = i;
        this.triggerId = triggerId;
        this.scheduleId = scheduleId;
        this.state = state;
    }

    public /* synthetic */ TriggerEntity(int i, String str, String str2, JsonValue jsonValue, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, str2, jsonValue);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    @NotNull
    public final String getTriggerId() {
        return this.triggerId;
    }

    @NotNull
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @NotNull
    public final JsonValue getState() {
        return this.state;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TriggerEntity(@NotNull TriggerData triggerData) {
        this(0, triggerData.getTriggerId(), triggerData.getScheduleId(), triggerData.getJsonValue(), 1, null);
        Intrinsics.checkNotNullParameter(triggerData, "triggerData");
    }

    @NotNull
    public final TriggerData toTriggerData() throws JsonException {
        return TriggerData.INSTANCE.fromJson(this.state);
    }
}
