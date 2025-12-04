package com.urbanairship.android.framework.proxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/framework/proxy/TagOperationAction;", "", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TagOperationAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TagOperationAction[] $VALUES;
    public static final TagOperationAction ADD = new TagOperationAction("ADD", 0);
    public static final TagOperationAction REMOVE = new TagOperationAction("REMOVE", 1);

    private static final /* synthetic */ TagOperationAction[] $values() {
        return new TagOperationAction[]{ADD, REMOVE};
    }

    @NotNull
    public static EnumEntries<TagOperationAction> getEntries() {
        return $ENTRIES;
    }

    public static TagOperationAction valueOf(String str) {
        return (TagOperationAction) Enum.valueOf(TagOperationAction.class, str);
    }

    public static TagOperationAction[] values() {
        return (TagOperationAction[]) $VALUES.clone();
    }

    private TagOperationAction(String str, int i) {
    }

    static {
        TagOperationAction[] tagOperationActionArr$values = $values();
        $VALUES = tagOperationActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tagOperationActionArr$values);
    }
}
