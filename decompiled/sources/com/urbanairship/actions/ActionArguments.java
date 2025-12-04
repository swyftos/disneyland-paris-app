package com.urbanairship.actions;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public final class ActionArguments {

    @NonNull
    public static final String ACTION_SCHEDULE_ID_METADATA = "com.urbanairship.ACTION_SCHEDULE_ID";

    @NonNull
    public static final String PUSH_MESSAGE_METADATA = "com.urbanairship.PUSH_MESSAGE";

    @NonNull
    public static final String REGISTRY_ACTION_NAME_METADATA = "com.urbanairship.REGISTRY_ACTION_NAME";

    @NonNull
    public static final String REMOTE_INPUT_METADATA = "com.urbanairship.REMOTE_INPUT";

    @NonNull
    public static final String RICH_PUSH_ID_METADATA = "com.urbanairship.RICH_PUSH_ID_METADATA";
    private final Bundle metadata;
    private final int situation;
    private final ActionValue value;

    public ActionArguments(int i, @Nullable ActionValue actionValue, @Nullable Bundle bundle) {
        this.situation = i;
        this.value = actionValue == null ? new ActionValue() : actionValue;
        this.metadata = bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @NonNull
    public ActionValue getValue() {
        return this.value;
    }

    public int getSituation() {
        return this.situation;
    }

    @NonNull
    public Bundle getMetadata() {
        return this.metadata;
    }

    @NonNull
    public String toString() {
        return "ActionArguments { situation: " + this.situation + ", value: " + this.value + ", metadata: " + this.metadata + " }";
    }
}
