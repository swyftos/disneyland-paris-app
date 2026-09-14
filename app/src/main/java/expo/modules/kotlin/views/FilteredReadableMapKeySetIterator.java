package expo.modules.kotlin.views;

import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.Filter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1836d2 = {"Lexpo/modules/kotlin/views/FilteredReadableMapKeySetIterator;", "Lcom/facebook/react/bridge/ReadableMapKeySetIterator;", "iterator", ViewProps.FILTER, "Lexpo/modules/kotlin/Filter;", "", "<init>", "(Lcom/facebook/react/bridge/ReadableMapKeySetIterator;Lexpo/modules/kotlin/Filter;)V", "next", "hasNextKey", "", "nextKey", "findNext", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FilteredReadableMapKeySetIterator implements ReadableMapKeySetIterator {
    private final Filter filter;
    private final ReadableMapKeySetIterator iterator;
    private String next;

    public FilteredReadableMapKeySetIterator(@NotNull ReadableMapKeySetIterator iterator, @NotNull Filter<String> filter) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.iterator = iterator;
        this.filter = filter;
        findNext();
    }

    @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
    public boolean hasNextKey() {
        return this.next != null;
    }

    @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
    @NotNull
    public String nextKey() {
        String str = this.next;
        Intrinsics.checkNotNull(str);
        findNext();
        return str;
    }

    private final void findNext() {
        while (this.iterator.hasNextKey()) {
            String strNextKey = this.iterator.nextKey();
            this.next = strNextKey;
            if (this.filter.apply(strNextKey)) {
                return;
            }
        }
        this.next = null;
    }
}
