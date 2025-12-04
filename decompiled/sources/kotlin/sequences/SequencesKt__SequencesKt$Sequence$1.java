package kotlin.sequences;

import ch.qos.logback.core.net.SyslogConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = SyslogConstants.LOG_LOCAL6)
/* loaded from: classes6.dex */
public final class SequencesKt__SequencesKt$Sequence$1 implements Sequence<Object> {
    final /* synthetic */ Function0 $iterator;

    public SequencesKt__SequencesKt$Sequence$1(Function0<? extends Iterator<Object>> function0) {
        this.$iterator = function0;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Object> iterator() {
        return (Iterator) this.$iterator.invoke();
    }
}
