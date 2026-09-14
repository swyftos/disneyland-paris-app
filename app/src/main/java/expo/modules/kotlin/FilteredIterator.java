package expo.modules.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u000e\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000f"}, m1836d2 = {"Lexpo/modules/kotlin/FilteredIterator;", ExifInterface.LONGITUDE_EAST, "", "iterator", ViewProps.FILTER, "Lexpo/modules/kotlin/Filter;", "<init>", "(Ljava/util/Iterator;Lexpo/modules/kotlin/Filter;)V", "next", "Ljava/lang/Object;", "hasNext", "", "()Ljava/lang/Object;", "findNext", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FilteredIterator<E> implements Iterator<E>, KMappedMarker {
    private final Filter filter;
    private final Iterator iterator;
    private Object next;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public FilteredIterator(@NotNull Iterator<? extends E> iterator, @NotNull Filter<E> filter) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.iterator = iterator;
        this.filter = filter;
        findNext();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public E next() {
        E e = (E) this.next;
        Intrinsics.checkNotNull(e);
        findNext();
        return e;
    }

    private final void findNext() {
        while (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            this.next = next;
            if (this.filter.apply(next)) {
                return;
            }
        }
        this.next = null;
    }
}
