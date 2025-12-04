package com.urbanairship.iam.adapter;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/iam/adapter/DisplayResult;", "", "(Ljava/lang/String;I)V", "CANCEL", "FINISHED", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class DisplayResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayResult[] $VALUES;
    public static final DisplayResult CANCEL = new DisplayResult("CANCEL", 0);
    public static final DisplayResult FINISHED = new DisplayResult("FINISHED", 1);

    private static final /* synthetic */ DisplayResult[] $values() {
        return new DisplayResult[]{CANCEL, FINISHED};
    }

    @NotNull
    public static EnumEntries<DisplayResult> getEntries() {
        return $ENTRIES;
    }

    public static DisplayResult valueOf(String str) {
        return (DisplayResult) Enum.valueOf(DisplayResult.class, str);
    }

    public static DisplayResult[] values() {
        return (DisplayResult[]) $VALUES.clone();
    }

    private DisplayResult(String str, int i) {
    }

    static {
        DisplayResult[] displayResultArr$values = $values();
        $VALUES = displayResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(displayResultArr$values);
    }
}
