package io.cucumber.datatable.dependency.difflib;

import io.cucumber.datatable.dependency.difflib.DiffRow;
import io.cucumber.datatable.dependency.difflib.myers.Equalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes5.dex */
public class DiffRowGenerator {
    private final String InlineNewCssClass;
    private final String InlineNewTag;
    private final String InlineOldCssClass;
    private final String InlineOldTag;
    private final int columnWidth;
    private final Equalizer equalizer;
    private final boolean ignoreBlankLines;
    private final boolean ignoreWhiteSpaces;
    private final boolean showInlineDiffs;

    public static class Builder {
        private boolean showInlineDiffs = false;
        private boolean ignoreWhiteSpaces = false;
        private boolean ignoreBlankLines = false;
        private String InlineOldTag = "span";
        private String InlineNewTag = "span";
        private String InlineOldCssClass = "editOldInline";
        private String InlineNewCssClass = "editNewInline";
        private int columnWidth = 80;

        public Builder showInlineDiffs(boolean z) {
            this.showInlineDiffs = z;
            return this;
        }

        public Builder ignoreWhiteSpaces(boolean z) {
            this.ignoreWhiteSpaces = z;
            return this;
        }

        public Builder ignoreBlankLines(boolean z) {
            this.ignoreBlankLines = z;
            return this;
        }

        public Builder InlineOldTag(String str) {
            this.InlineOldTag = str;
            return this;
        }

        public Builder InlineNewTag(String str) {
            this.InlineNewTag = str;
            return this;
        }

        public Builder InlineOldCssClass(String str) {
            this.InlineOldCssClass = str;
            return this;
        }

        public Builder InlineNewCssClass(String str) {
            this.InlineNewCssClass = str;
            return this;
        }

        public Builder columnWidth(int i) {
            if (i > 0) {
                this.columnWidth = i;
            }
            return this;
        }

        public DiffRowGenerator build() {
            return new DiffRowGenerator(this);
        }
    }

    private DiffRowGenerator(Builder builder) {
        this.showInlineDiffs = builder.showInlineDiffs;
        this.ignoreWhiteSpaces = builder.ignoreWhiteSpaces;
        this.ignoreBlankLines = builder.ignoreBlankLines;
        this.InlineOldTag = builder.InlineOldTag;
        this.InlineNewTag = builder.InlineNewTag;
        this.InlineOldCssClass = builder.InlineOldCssClass;
        this.InlineNewCssClass = builder.InlineNewCssClass;
        this.columnWidth = builder.columnWidth;
        this.equalizer = new Equalizer() { // from class: io.cucumber.datatable.dependency.difflib.DiffRowGenerator.1
            @Override // io.cucumber.datatable.dependency.difflib.myers.Equalizer
            public boolean equals(String str, String str2) {
                if (DiffRowGenerator.this.ignoreWhiteSpaces) {
                    String strReplaceAll = str.trim().replaceAll("\\s+", " ");
                    str2 = str2.trim().replaceAll("\\s+", " ");
                    str = strReplaceAll;
                }
                return str.equals(str2);
            }
        };
    }

    public List<DiffRow> generateDiffRows(List<String> list, List<String> list2) {
        return generateDiffRows(list, list2, DiffUtils.diff(list, list2, this.equalizer));
    }

    public List<DiffRow> generateDiffRows(List<String> list, List<String> list2, Patch<String> patch) {
        List<String> listNormalize = StringUtills.normalize(list);
        List<String> listNormalize2 = StringUtills.normalize(list2);
        List<String> listWrapText = StringUtills.wrapText(listNormalize, this.columnWidth);
        StringUtills.wrapText(listNormalize2, this.columnWidth);
        ArrayList arrayList = new ArrayList();
        List<Delta<String>> deltas = patch.getDeltas();
        int iLast = 0;
        for (int i = 0; i < deltas.size(); i++) {
            Delta<String> delta = deltas.get(i);
            Chunk<String> original = delta.getOriginal();
            Chunk<String> revised = delta.getRevised();
            original.setLines(StringUtills.normalize(original.getLines()));
            revised.setLines(StringUtills.normalize(revised.getLines()));
            original.setLines(StringUtills.wrapText(original.getLines(), this.columnWidth));
            revised.setLines(StringUtills.wrapText(revised.getLines(), this.columnWidth));
            for (String str : listWrapText.subList(iLast, original.getPosition())) {
                arrayList.add(new DiffRow(DiffRow.Tag.EQUAL, str, str));
            }
            if (delta.getClass().equals(InsertDelta.class)) {
                iLast = original.last() + 1;
                Iterator<String> it = revised.getLines().iterator();
                while (it.hasNext()) {
                    arrayList.add(new DiffRow(DiffRow.Tag.INSERT, "", it.next()));
                }
            } else if (delta.getClass().equals(DeleteDelta.class)) {
                iLast = original.last() + 1;
                Iterator<String> it2 = original.getLines().iterator();
                while (it2.hasNext()) {
                    arrayList.add(new DiffRow(DiffRow.Tag.DELETE, it2.next(), ""));
                }
            } else {
                if (this.showInlineDiffs) {
                    addInlineDiffs(delta);
                }
                if (original.size() == revised.size()) {
                    for (int i2 = 0; i2 < original.size(); i2++) {
                        arrayList.add(new DiffRow(DiffRow.Tag.CHANGE, original.getLines().get(i2), revised.getLines().get(i2)));
                    }
                } else if (original.size() > revised.size()) {
                    int i3 = 0;
                    while (i3 < original.size()) {
                        arrayList.add(new DiffRow(DiffRow.Tag.CHANGE, original.getLines().get(i3), revised.getLines().size() > i3 ? revised.getLines().get(i3) : ""));
                        i3++;
                    }
                } else {
                    int i4 = 0;
                    while (i4 < revised.size()) {
                        arrayList.add(new DiffRow(DiffRow.Tag.CHANGE, original.getLines().size() > i4 ? original.getLines().get(i4) : "", revised.getLines().get(i4)));
                        i4++;
                    }
                }
                iLast = original.last() + 1;
            }
        }
        for (String str2 : listWrapText.subList(iLast, listWrapText.size())) {
            arrayList.add(new DiffRow(DiffRow.Tag.EQUAL, str2, str2));
        }
        return arrayList;
    }

    private void addInlineDiffs(Delta delta) {
        List lines = delta.getOriginal().getLines();
        List lines2 = delta.getRevised().getLines();
        LinkedList<String> linkedList = new LinkedList<>();
        for (char c : join(lines, "\n").toCharArray()) {
            linkedList.add(Character.valueOf(c).toString());
        }
        LinkedList<String> linkedList2 = new LinkedList<>();
        for (char c2 : join(lines2, "\n").toCharArray()) {
            linkedList2.add(Character.valueOf(c2).toString());
        }
        List<Delta> deltas = DiffUtils.diff(linkedList, linkedList2).getDeltas();
        if (deltas.size() < 3) {
            Collections.reverse(deltas);
            for (Delta delta2 : deltas) {
                Chunk original = delta2.getOriginal();
                Chunk revised = delta2.getRevised();
                if (delta2.getClass().equals(DeleteDelta.class)) {
                    linkedList = wrapInTag(linkedList, original.getPosition(), original.getPosition() + original.size() + 1, this.InlineOldTag, this.InlineOldCssClass);
                } else if (delta2.getClass().equals(InsertDelta.class)) {
                    linkedList2 = wrapInTag(linkedList2, revised.getPosition(), revised.getPosition() + revised.size() + 1, this.InlineNewTag, this.InlineNewCssClass);
                } else if (delta2.getClass().equals(ChangeDelta.class)) {
                    linkedList = wrapInTag(linkedList, original.getPosition(), original.getPosition() + original.size() + 1, this.InlineOldTag, this.InlineOldCssClass);
                    linkedList2 = wrapInTag(linkedList2, revised.getPosition(), revised.getPosition() + revised.size() + 1, this.InlineNewTag, this.InlineNewCssClass);
                }
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            Iterator<String> it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next());
            }
            delta.getOriginal().setLines(Arrays.asList(sb.toString().split("\n")));
            delta.getRevised().setLines(Arrays.asList(sb2.toString().split("\n")));
        }
    }

    public static LinkedList<String> wrapInTag(LinkedList<String> linkedList, int i, int i2, String str, String str2) {
        LinkedList<String> linkedList2 = (LinkedList) linkedList.clone();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        if (str2 != null) {
            sb.append(" class=\"");
            sb.append(str2);
            sb.append("\"");
        }
        sb.append(">");
        String string = sb.toString();
        sb.delete(0, sb.length());
        sb.append("</");
        sb.append(str);
        sb.append(">");
        String string2 = sb.toString();
        linkedList2.add(i, string);
        linkedList2.add(i2, string2);
        return linkedList2;
    }

    public static String wrapInTag(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str2);
        if (str3 != null) {
            sb.append(" class=\"");
            sb.append(str3);
            sb.append("\"");
        }
        sb.append(">");
        String string = sb.toString();
        sb.delete(0, sb.length());
        sb.append("</");
        sb.append(str2);
        sb.append(">");
        return string + str + sb.toString();
    }

    private static String join(Iterable iterable, String str) {
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(it.next()));
        while (it.hasNext()) {
            stringBuffer.append(str);
            stringBuffer.append(String.valueOf(it.next()));
        }
        return stringBuffer.toString();
    }
}
