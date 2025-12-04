package com.urbanairship.contacts;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/contacts/ContactConflictListener;", "", "onConflict", "", "event", "Lcom/urbanairship/contacts/ConflictEvent;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ContactConflictListener {
    void onConflict(@NotNull ConflictEvent event);
}
