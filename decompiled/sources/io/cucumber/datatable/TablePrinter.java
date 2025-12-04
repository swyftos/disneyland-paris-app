package io.cucumber.datatable;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class TablePrinter {
    private int[][] cellLengths;
    private int[] maxLengths;

    TablePrinter() {
    }

    void printTable(List list, StringBuilder sb) {
        try {
            printTable(list, (Appendable) sb);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    void printTable(List list, Appendable appendable) throws IOException {
        calculateColumnAndMaxLengths(list);
        for (int i = 0; i < list.size(); i++) {
            printRow((List) list.get(i), i, appendable);
            appendable.append("\n");
        }
    }

    protected void printStartIndent(Appendable appendable, int i) throws IOException {
        appendable.append("      ");
    }

    private void calculateColumnAndMaxLengths(List list) {
        Iterator it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            List list2 = (List) it.next();
            if (size < list2.size()) {
                size = list2.size();
            }
        }
        this.cellLengths = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, list.size(), size);
        this.maxLengths = new int[size];
        for (int i = 0; i < list.size(); i++) {
            List list3 = (List) list.get(i);
            for (int i2 = 0; i2 < size; i2++) {
                int length = escapeCell(getCellSafely(list3, i2)).length();
                this.cellLengths[i][i2] = length;
                int[] iArr = this.maxLengths;
                iArr[i2] = Math.max(iArr[i2], length);
            }
        }
    }

    private String getCellSafely(List list, int i) {
        return i < list.size() ? (String) list.get(i) : "";
    }

    private void printRow(List list, int i, Appendable appendable) throws IOException {
        printStartIndent(appendable, i);
        appendable.append("| ");
        for (int i2 = 0; i2 < this.maxLengths.length; i2++) {
            appendable.append(escapeCell(getCellSafely(list, i2)));
            padSpace(appendable, this.maxLengths[i2] - this.cellLengths[i][i2]);
            if (i2 < this.maxLengths.length - 1) {
                appendable.append(" | ");
            } else {
                appendable.append(" |");
            }
        }
    }

    private String escapeCell(String str) {
        return str.replaceAll("\\\\(?!\\|)", "\\\\\\\\").replaceAll("\\n", "\\\\n").replaceAll("\\|", "\\\\|");
    }

    private void padSpace(Appendable appendable, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            appendable.append(" ");
        }
    }
}
