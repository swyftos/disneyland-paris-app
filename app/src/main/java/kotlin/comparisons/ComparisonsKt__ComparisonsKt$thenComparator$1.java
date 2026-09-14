package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import ch.qos.logback.core.net.SyslogConstants;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class ComparisonsKt__ComparisonsKt$thenComparator$1<T> implements Comparator {
    final /* synthetic */ Function2 $comparison;
    final /* synthetic */ Comparator $this_thenComparator;

    public ComparisonsKt__ComparisonsKt$thenComparator$1(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
        this.$this_thenComparator = comparator;
        this.$comparison = function2;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int iCompare = this.$this_thenComparator.compare(t, t2);
        return iCompare != 0 ? iCompare : ((Number) this.$comparison.invoke(t, t2)).intValue();
    }
}
