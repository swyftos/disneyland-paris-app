package gherkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* loaded from: classes5.dex */
public class GherkinLine implements IGherkinLine {
    private final String lineText;
    private final String trimmedLineText;

    @Override // gherkin.IGherkinLine
    public void detach() {
    }

    public GherkinLine(String str) {
        this.lineText = str;
        this.trimmedLineText = StringUtils.ltrim(str);
    }

    @Override // gherkin.IGherkinLine
    public Integer indent() {
        return Integer.valueOf(SymbolCounter.countSymbols(this.lineText) - SymbolCounter.countSymbols(this.trimmedLineText));
    }

    @Override // gherkin.IGherkinLine
    public String getLineText(int i) {
        if (i < 0 || i > indent().intValue()) {
            return this.trimmedLineText;
        }
        return this.lineText.substring(i);
    }

    @Override // gherkin.IGherkinLine
    public boolean isEmpty() {
        return this.trimmedLineText.length() == 0;
    }

    @Override // gherkin.IGherkinLine
    public boolean startsWith(String str) {
        return this.trimmedLineText.startsWith(str);
    }

    @Override // gherkin.IGherkinLine
    public String getRestTrimmed(int i) {
        return this.trimmedLineText.substring(i).trim();
    }

    @Override // gherkin.IGherkinLine
    public List<GherkinLineSpan> getTags() {
        return getSpans("\\s+");
    }

    @Override // gherkin.IGherkinLine
    public boolean startsWithTitleKeyword(String str) {
        int length = str.length();
        return this.trimmedLineText.length() > length && this.trimmedLineText.startsWith(str) && this.trimmedLineText.substring(length, length + 1).equals(":");
    }

    @Override // gherkin.IGherkinLine
    public List<GherkinLineSpan> getTableCells() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (i < this.trimmedLineText.length()) {
            char cCharAt = this.trimmedLineText.charAt(i);
            if (cCharAt == '|') {
                if (z) {
                    z = false;
                } else {
                    int i3 = 0;
                    while (i3 < sb.length() && Character.isWhitespace(sb.charAt(i3))) {
                        i3++;
                    }
                    if (i3 == sb.length()) {
                        i3 = 0;
                    }
                    arrayList.add(new GherkinLineSpan(indent().intValue() + i2 + i3 + 2, sb.toString().trim()));
                    i2 = i;
                }
                sb = new StringBuilder();
            } else if (cCharAt == '\\') {
                i++;
                char cCharAt2 = this.trimmedLineText.charAt(i);
                if (cCharAt2 == 'n') {
                    sb.append('\n');
                } else {
                    if (cCharAt2 != '|' && cCharAt2 != '\\') {
                        sb.append('\\');
                    }
                    sb.append(cCharAt2);
                }
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        return arrayList;
    }

    private List getSpans(String str) {
        ArrayList arrayList = new ArrayList();
        Scanner scannerUseDelimiter = new Scanner(this.trimmedLineText).useDelimiter(str);
        while (scannerUseDelimiter.hasNext()) {
            arrayList.add(new GherkinLineSpan(scannerUseDelimiter.match().start() + indent().intValue() + 1, scannerUseDelimiter.next()));
        }
        return arrayList;
    }
}
