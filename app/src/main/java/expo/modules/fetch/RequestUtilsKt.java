package expo.modules.fetch;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0000¨\u0006\u0005"}, m1836d2 = {"toHeaders", "Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "expo_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RequestUtilsKt {
    @NotNull
    public static final Headers toHeaders(@NotNull List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Pair<String, String> pair : list) {
            builder.add(pair.getFirst(), pair.getSecond());
        }
        return builder.build();
    }
}
