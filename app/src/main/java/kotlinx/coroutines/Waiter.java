package kotlinx.coroutines;

import com.urbanairship.json.matchers.ArrayContainsMatcher;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m1836d2 = {"Lkotlinx/coroutines/Waiter;", "", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", ArrayContainsMatcher.INDEX_KEY, "", "kotlinx-coroutines-core"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface Waiter {
    void invokeOnCancellation(@NotNull Segment<?> segment, int index);
}
