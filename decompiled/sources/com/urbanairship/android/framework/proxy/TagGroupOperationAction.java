package com.urbanairship.android.framework.proxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/framework/proxy/TagGroupOperationAction;", "", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "SET", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TagGroupOperationAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TagGroupOperationAction[] $VALUES;
    public static final TagGroupOperationAction ADD = new TagGroupOperationAction("ADD", 0);
    public static final TagGroupOperationAction REMOVE = new TagGroupOperationAction("REMOVE", 1);
    public static final TagGroupOperationAction SET = new TagGroupOperationAction("SET", 2);

    private static final /* synthetic */ TagGroupOperationAction[] $values() {
        return new TagGroupOperationAction[]{ADD, REMOVE, SET};
    }

    @NotNull
    public static EnumEntries<TagGroupOperationAction> getEntries() {
        return $ENTRIES;
    }

    public static TagGroupOperationAction valueOf(String str) {
        return (TagGroupOperationAction) Enum.valueOf(TagGroupOperationAction.class, str);
    }

    public static TagGroupOperationAction[] values() {
        return (TagGroupOperationAction[]) $VALUES.clone();
    }

    private TagGroupOperationAction(String str, int i) {
    }

    static {
        TagGroupOperationAction[] tagGroupOperationActionArr$values = $values();
        $VALUES = tagGroupOperationActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tagGroupOperationActionArr$values);
    }
}
