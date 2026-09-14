package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class BufferedChannel$receiveImpl$1 implements Function3 {
    public static final BufferedChannel$receiveImpl$1 INSTANCE = new BufferedChannel$receiveImpl$1();

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((ChannelSegment<Object>) obj, ((Number) obj2).intValue(), ((Number) obj3).longValue());
    }

    public final Void invoke(ChannelSegment<Object> channelSegment, int i, long j) {
        throw new IllegalStateException("unexpected");
    }
}
