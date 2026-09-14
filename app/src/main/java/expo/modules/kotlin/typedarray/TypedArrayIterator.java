package expo.modules.kotlin.typedarray;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"Lexpo/modules/kotlin/typedarray/TypedArrayIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "typedArray", "Lexpo/modules/kotlin/typedarray/GenericTypedArray;", "<init>", "(Lexpo/modules/kotlin/typedarray/GenericTypedArray;)V", "current", "", "hasNext", "", "next", "()Ljava/lang/Object;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class TypedArrayIterator<T> implements Iterator<T>, KMappedMarker {
    private int current;
    private final GenericTypedArray typedArray;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public TypedArrayIterator(@NotNull GenericTypedArray<T> typedArray) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        this.typedArray = typedArray;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.current < this.typedArray.getLength();
    }

    @Override // java.util.Iterator
    public T next() {
        GenericTypedArray genericTypedArray = this.typedArray;
        int i = this.current;
        this.current = i + 1;
        return (T) genericTypedArray.get(i);
    }
}
