package com.disney.id.android.localdata;

import com.urbanairship.channel.AttributeMutation;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0006H&J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/disney/id/android/localdata/LocalStorage;", "", "get", "", "key", "getAll", "", "put", "", "value", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LocalStorage {
    @Nullable
    String get(@NotNull String key);

    @NotNull
    Map<String, ?> getAll();

    void put(@NotNull String key, @Nullable String value);

    void remove(@NotNull String key);
}
