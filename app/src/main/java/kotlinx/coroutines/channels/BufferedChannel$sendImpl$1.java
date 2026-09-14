package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class BufferedChannel$sendImpl$1 implements Function4 {
    public static final BufferedChannel$sendImpl$1 INSTANCE = new BufferedChannel$sendImpl$1();

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((ChannelSegment<Object>) obj, ((Number) obj2).intValue(), obj3, ((Number) obj4).longValue());
    }

    public final Void invoke(ChannelSegment<Object> channelSegment, int i, Object obj, long j) {
        throw new IllegalStateException("unexpected");
    }
}
