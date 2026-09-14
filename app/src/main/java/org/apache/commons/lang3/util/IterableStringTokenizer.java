package org.apache.commons.lang3.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes6.dex */
public class IterableStringTokenizer extends StringTokenizer implements Iterable<String> {
    public IterableStringTokenizer(String str) {
        super(str);
    }

    public IterableStringTokenizer(String str, String str2) {
        super(str, str2);
    }

    public IterableStringTokenizer(String str, String str2, boolean z) {
        super(str, str2, z);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return new Iterator() { // from class: org.apache.commons.lang3.util.IterableStringTokenizer.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return IterableStringTokenizer.this.hasMoreElements();
            }

            @Override // java.util.Iterator
            public String next() {
                return Objects.toString(IterableStringTokenizer.this.nextElement(), null);
            }
        };
    }

    public String[] toArray() {
        return (String[]) toList().toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public List<String> toList() {
        final ArrayList arrayList = new ArrayList();
        forEach(new Consumer() { // from class: org.apache.commons.lang3.util.IterableStringTokenizer$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add((String) obj);
            }
        });
        return arrayList;
    }

    public Stream<String> toStream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
