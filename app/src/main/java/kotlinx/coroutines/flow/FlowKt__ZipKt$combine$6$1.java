package kotlinx.coroutines.flow;

import ch.qos.logback.core.net.SyslogConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class FlowKt__ZipKt$combine$6$1 implements Function0<Object[]> {
    final /* synthetic */ Flow[] $flowArray;

    public FlowKt__ZipKt$combine$6$1(Flow<Object>[] flowArr) {
        this.$flowArray = flowArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object[] invoke() {
        int length = this.$flowArray.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[length];
    }
}
