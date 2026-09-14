package coil3.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m1836d2 = {"Lcoil3/network/NetworkRequestBody;", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface NetworkRequestBody {
    @Nullable
    Object writeTo(@NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation);
}
