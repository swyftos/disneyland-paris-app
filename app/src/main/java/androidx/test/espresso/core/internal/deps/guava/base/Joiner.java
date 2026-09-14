package androidx.test.espresso.core.internal.deps.guava.base;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class Joiner {
    private final String separator;

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    /* JADX INFO: renamed from: on */
    public static Joiner m384on(String str) {
        return new Joiner(str);
    }

    public <A extends Appendable> A appendTo(A a2, Iterator it) throws IOException {
        Preconditions.checkNotNull(a2);
        if (it.hasNext()) {
            a2.append(toString(it.next()));
            while (it.hasNext()) {
                a2.append(this.separator);
                a2.append(toString(it.next()));
            }
        }
        return a2;
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    CharSequence toString(Object obj) {
        Preconditions.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String join(Iterator<?> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterator<?> it) {
        try {
            appendTo(sb, (Iterator) it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
