package com.urbanairship.analytics.data;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class BatchedQueryHelper {
    public static <T> void runBatched(@NonNull List<T> list, @NonNull Consumer<List<T>> consumer) {
        runBatched(999, list, consumer);
    }

    static void runBatched(int i, List list, Consumer consumer) {
        if (i == 0) {
            throw new IllegalArgumentException("Failed to run batched! 'batchSize' must be greater than zero.");
        }
        int iCeil = (int) Math.ceil(list.size() / i);
        for (int i2 = 0; i2 < iCeil; i2++) {
            int i3 = i2 * i;
            consumer.accept(list.subList(i3, Math.min(list.size() - i3, i) + i3));
        }
    }
}
