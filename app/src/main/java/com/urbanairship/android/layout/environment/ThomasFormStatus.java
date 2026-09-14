package com.urbanairship.android.layout.environment;

import com.facebook.hermes.intl.Constants;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/android/layout/environment/ThomasFormStatus;", "", "Lcom/urbanairship/json/JsonSerializable;", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "isError", "", "()Z", "isSubmitted", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "VALID", "INVALID", "ERROR", "VALIDATING", "PENDING_VALIDATION", "SUBMITTED", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum ThomasFormStatus implements JsonSerializable {
    VALID("valid"),
    INVALID(Constants.COLLATION_INVALID),
    ERROR(com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR),
    VALIDATING("validating"),
    PENDING_VALIDATION("pending_validation"),
    SUBMITTED("submitted");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String type;

    @NotNull
    public static EnumEntries<ThomasFormStatus> getEntries() {
        return $ENTRIES;
    }

    ThomasFormStatus(String str) {
        this.type = str;
    }

    public final boolean isSubmitted() {
        return this == SUBMITTED;
    }

    public final boolean isError() {
        return this == ERROR;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValueWrap = JsonValue.wrap(this.type);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
        return jsonValueWrap;
    }
}
