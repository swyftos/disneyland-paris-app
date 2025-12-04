package com.disney.id.android.localdata;

import com.urbanairship.channel.AttributeMutation;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&J#\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/disney/id/android/localdata/ExposedStorage;", "", "contains", "", "key", "", "getAll", "", "getBoolean", "defValue", "getLong", "", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getOptionalBoolean", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getString", "putBoolean", "", "value", "putLong", "putString", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ExposedStorage {
    boolean contains(@NotNull String key);

    @NotNull
    Map<String, ?> getAll();

    boolean getBoolean(@NotNull String key, boolean defValue);

    @Nullable
    Long getLong(@NotNull String key, @Nullable Long defValue);

    @Nullable
    Boolean getOptionalBoolean(@NotNull String key, @Nullable Boolean defValue);

    @Nullable
    String getString(@NotNull String key, @Nullable String defValue);

    void putBoolean(@NotNull String key, boolean value);

    void putLong(@NotNull String key, long value);

    void putString(@NotNull String key, @NotNull String value);

    void remove(@NotNull String key);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ String getString$default(ExposedStorage exposedStorage, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return exposedStorage.getString(str, str2);
        }

        public static /* synthetic */ Long getLong$default(ExposedStorage exposedStorage, String str, Long l, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLong");
            }
            if ((i & 2) != 0) {
                l = null;
            }
            return exposedStorage.getLong(str, l);
        }
    }
}
