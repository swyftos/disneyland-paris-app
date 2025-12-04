package com.allegion.alsecurity.interfaces;

import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "", "contains", "", "key", "", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "", "retrieve", "store", "data", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlSecureStorage {
    boolean contains(@NotNull String key);

    void remove(@NotNull String key);

    @NotNull
    String retrieve(@NotNull String key) throws AlSecurityException;

    void store(@NotNull String key, @NotNull String data) throws AlSecurityException;
}
