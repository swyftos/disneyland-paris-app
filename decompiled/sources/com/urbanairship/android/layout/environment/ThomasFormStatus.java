package com.urbanairship.android.layout.environment;

import com.facebook.hermes.intl.Constants;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/environment/ThomasFormStatus;", "", "Lcom/urbanairship/json/JsonSerializable;", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "isError", "", "()Z", "isSubmitted", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "VALID", "INVALID", "ERROR", "VALIDATING", "PENDING_VALIDATION", "SUBMITTED", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThomasFormStatus implements JsonSerializable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ThomasFormStatus[] $VALUES;
    private final String type;
    public static final ThomasFormStatus VALID = new ThomasFormStatus("VALID", 0, "valid");
    public static final ThomasFormStatus INVALID = new ThomasFormStatus("INVALID", 1, Constants.COLLATION_INVALID);
    public static final ThomasFormStatus ERROR = new ThomasFormStatus("ERROR", 2, com.google.firebase.messaging.Constants.IPC_BUNDLE_KEY_SEND_ERROR);
    public static final ThomasFormStatus VALIDATING = new ThomasFormStatus("VALIDATING", 3, "validating");
    public static final ThomasFormStatus PENDING_VALIDATION = new ThomasFormStatus("PENDING_VALIDATION", 4, "pending_validation");
    public static final ThomasFormStatus SUBMITTED = new ThomasFormStatus("SUBMITTED", 5, "submitted");

    private static final /* synthetic */ ThomasFormStatus[] $values() {
        return new ThomasFormStatus[]{VALID, INVALID, ERROR, VALIDATING, PENDING_VALIDATION, SUBMITTED};
    }

    @NotNull
    public static EnumEntries<ThomasFormStatus> getEntries() {
        return $ENTRIES;
    }

    public static ThomasFormStatus valueOf(String str) {
        return (ThomasFormStatus) Enum.valueOf(ThomasFormStatus.class, str);
    }

    public static ThomasFormStatus[] values() {
        return (ThomasFormStatus[]) $VALUES.clone();
    }

    private ThomasFormStatus(String str, int i, String str2) {
        this.type = str2;
    }

    static {
        ThomasFormStatus[] thomasFormStatusArr$values = $values();
        $VALUES = thomasFormStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(thomasFormStatusArr$values);
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
