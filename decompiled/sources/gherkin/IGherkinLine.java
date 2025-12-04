package gherkin;

import java.util.List;

/* loaded from: classes5.dex */
public interface IGherkinLine {
    void detach();

    String getLineText(int i);

    String getRestTrimmed(int i);

    List<GherkinLineSpan> getTableCells();

    List<GherkinLineSpan> getTags();

    Integer indent();

    boolean isEmpty();

    boolean startsWith(String str);

    boolean startsWithTitleKeyword(String str);
}
