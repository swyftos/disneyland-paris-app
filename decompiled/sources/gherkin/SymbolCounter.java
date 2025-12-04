package gherkin;

/* loaded from: classes5.dex */
public class SymbolCounter {
    public static int countSymbols(String str) {
        return str.codePointCount(0, str.length());
    }
}
