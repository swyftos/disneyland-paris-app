package expo.modules.kotlin;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\t\u0010\u000f\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/kotlin/ReadableArrayIterator;", "", "Lcom/facebook/react/bridge/Dynamic;", "array", "Lcom/facebook/react/bridge/ReadableArray;", "<init>", "(Lcom/facebook/react/bridge/ReadableArray;)V", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ReadableArrayIterator implements Iterator<Dynamic>, KMappedMarker {
    private final ReadableArray array;
    private int current;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ReadableArrayIterator(@NotNull ReadableArray array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.current < this.array.size();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @NotNull
    public Dynamic next() {
        ReadableArray readableArray = this.array;
        int i = this.current;
        this.current = i + 1;
        return readableArray.getDynamic(i);
    }
}
