package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010(\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¨\u0006\u0005"}, m1836d2 = {"Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "", "iterator", "", "kotlin-stdlib"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface Sequence<T> {
    @NotNull
    Iterator<T> iterator();
}
