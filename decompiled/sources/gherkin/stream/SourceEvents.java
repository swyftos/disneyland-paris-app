package gherkin.stream;

import gherkin.events.SourceEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class SourceEvents implements Iterable<SourceEvent> {
    private final List paths;

    public SourceEvents(List<String> list) {
        this.paths = list;
    }

    @Override // java.lang.Iterable
    public Iterator<SourceEvent> iterator() {
        final Iterator it = this.paths.iterator();
        return new Iterator() { // from class: gherkin.stream.SourceEvents.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public SourceEvent next() {
                try {
                    String str = (String) it.next();
                    return new SourceEvent(str, SourceEvents.read(new InputStreamReader(new FileInputStream(str), "UTF-8")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String read(Reader reader) throws IOException {
        int i;
        char[] cArr = new char[65536];
        StringBuilder sb = new StringBuilder();
        do {
            i = reader.read(cArr, 0, 65536);
            if (i > 0) {
                sb.append(cArr, 0, i);
            }
        } while (i >= 0);
        return sb.toString();
    }
}
