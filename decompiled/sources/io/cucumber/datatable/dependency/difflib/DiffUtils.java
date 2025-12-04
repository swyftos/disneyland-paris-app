package io.cucumber.datatable.dependency.difflib;

import io.cucumber.datatable.dependency.difflib.myers.Equalizer;
import io.cucumber.datatable.dependency.difflib.myers.MyersDiff;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public class DiffUtils {
    private static Pattern unifiedDiffChunkRe = Pattern.compile("^@@\\s+-(?:(\\d+)(?:,(\\d+))?)\\s+\\+(?:(\\d+)(?:,(\\d+))?)\\s+@@$");

    public static <T> Patch<T> diff(List<T> list, List<T> list2) {
        return diff(list, list2, new MyersDiff());
    }

    public static <T> Patch<T> diff(List<T> list, List<T> list2, Equalizer<T> equalizer) {
        if (equalizer != null) {
            return diff(list, list2, new MyersDiff(equalizer));
        }
        return diff(list, list2, new MyersDiff());
    }

    public static <T> Patch<T> diff(List<T> list, List<T> list2, DiffAlgorithm<T> diffAlgorithm) {
        if (list == null) {
            throw new IllegalArgumentException("original must not be null");
        }
        if (list2 == null) {
            throw new IllegalArgumentException("revised must not be null");
        }
        if (diffAlgorithm == null) {
            throw new IllegalArgumentException("algorithm must not be null");
        }
        return diffAlgorithm.diff(list, list2);
    }

    public static <T> List<T> patch(List<T> list, Patch<T> patch) throws PatchFailedException {
        return patch.applyTo(list);
    }

    public static <T> List<T> unpatch(List<T> list, Patch<T> patch) {
        return patch.restore(list);
    }

    public static Patch<String> parseUnifiedDiff(List<String> list) {
        Iterator<String> it;
        ArrayList<String[]> arrayList = new ArrayList();
        Patch<String> patch = new Patch<>();
        Iterator<String> it2 = list.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            if (z) {
                if (next.startsWith("+++")) {
                    z = false;
                }
            } else {
                Matcher matcher = unifiedDiffChunkRe.matcher(next);
                if (matcher.find()) {
                    if (arrayList.size() != 0) {
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        for (String[] strArr : arrayList) {
                            Iterator<String> it3 = it2;
                            String str = strArr[0];
                            String str2 = strArr[1];
                            if (str.equals(" ") || str.equals("-")) {
                                arrayList2.add(str2);
                            }
                            if (str.equals(" ") || str.equals(Marker.ANY_NON_NULL_MARKER)) {
                                arrayList3.add(str2);
                            }
                            it2 = it3;
                        }
                        it = it2;
                        patch.addDelta(new ChangeDelta(new Chunk(i - 1, arrayList2), new Chunk(i2 - 1, arrayList3)));
                        arrayList.clear();
                    } else {
                        it = it2;
                    }
                    int i3 = matcher.group(1) == null ? 1 : Integer.parseInt(matcher.group(1));
                    int i4 = matcher.group(3) == null ? 1 : Integer.parseInt(matcher.group(3));
                    if (i3 == 0) {
                        i3++;
                    }
                    if (i4 == 0) {
                        i4++;
                    }
                    i2 = i4;
                    i = i3;
                } else {
                    it = it2;
                    if (next.length() > 0) {
                        String strSubstring = next.substring(0, 1);
                        String strSubstring2 = next.substring(1);
                        if (strSubstring.equals(" ") || strSubstring.equals(Marker.ANY_NON_NULL_MARKER) || strSubstring.equals("-")) {
                            arrayList.add(new String[]{strSubstring, strSubstring2});
                        }
                    } else {
                        arrayList.add(new String[]{" ", ""});
                    }
                }
                it2 = it;
            }
        }
        if (arrayList.size() != 0) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (String[] strArr2 : arrayList) {
                String str3 = strArr2[0];
                String str4 = strArr2[1];
                if (str3.equals(" ") || str3.equals("-")) {
                    arrayList4.add(str4);
                }
                if (str3.equals(" ") || str3.equals(Marker.ANY_NON_NULL_MARKER)) {
                    arrayList5.add(str4);
                }
            }
            patch.addDelta(new ChangeDelta(new Chunk(i - 1, arrayList4), new Chunk(i2 - 1, arrayList5)));
            arrayList.clear();
        }
        return patch;
    }

    public static List<String> generateUnifiedDiff(String str, String str2, List<String> list, Patch<String> patch, int i) {
        if (!patch.getDeltas().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("--- " + str);
            arrayList.add("+++ " + str2);
            ArrayList arrayList2 = new ArrayList(patch.getDeltas());
            ArrayList arrayList3 = new ArrayList();
            Delta delta = (Delta) arrayList2.get(0);
            arrayList3.add(delta);
            int i2 = 1;
            if (arrayList2.size() > 1) {
                while (i2 < arrayList2.size()) {
                    int position = delta.getOriginal().getPosition();
                    Delta delta2 = (Delta) arrayList2.get(i2);
                    if (position + delta.getOriginal().size() + i >= delta2.getOriginal().getPosition() - i) {
                        arrayList3.add(delta2);
                    } else {
                        arrayList.addAll(processDeltas(list, arrayList3, i));
                        arrayList3.clear();
                        arrayList3.add(delta2);
                    }
                    i2++;
                    delta = delta2;
                }
            }
            arrayList.addAll(processDeltas(list, arrayList3, i));
            return arrayList;
        }
        return new ArrayList();
    }

    private static List processDeltas(List list, List list2, int i) {
        ArrayList arrayList = new ArrayList();
        Delta delta = (Delta) list2.get(0);
        int i2 = 1;
        int position = (delta.getOriginal().getPosition() + 1) - i;
        if (position < 1) {
            position = 1;
        }
        int position2 = (delta.getRevised().getPosition() + 1) - i;
        if (position2 < 1) {
            position2 = 1;
        }
        int position3 = delta.getOriginal().getPosition() - i;
        if (position3 < 0) {
            position3 = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (position3 < delta.getOriginal().getPosition()) {
            arrayList.add(" " + ((String) list.get(position3)));
            i3++;
            i4++;
            position3++;
        }
        arrayList.addAll(getDeltaText(delta));
        int size = i3 + delta.getOriginal().getLines().size();
        int size2 = i4 + delta.getRevised().getLines().size();
        while (i2 < list2.size()) {
            Delta delta2 = (Delta) list2.get(i2);
            for (int position4 = delta.getOriginal().getPosition() + delta.getOriginal().getLines().size(); position4 < delta2.getOriginal().getPosition(); position4++) {
                arrayList.add(" " + ((String) list.get(position4)));
                size++;
                size2++;
            }
            arrayList.addAll(getDeltaText(delta2));
            size += delta2.getOriginal().getLines().size();
            size2 += delta2.getRevised().getLines().size();
            i2++;
            delta = delta2;
        }
        int position5 = delta.getOriginal().getPosition() + delta.getOriginal().getLines().size();
        for (int i5 = position5; i5 < position5 + i && i5 < list.size(); i5++) {
            arrayList.add(" " + ((String) list.get(i5)));
            size++;
            size2++;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@@ -");
        stringBuffer.append(position);
        stringBuffer.append(",");
        stringBuffer.append(size);
        stringBuffer.append(" +");
        stringBuffer.append(position2);
        stringBuffer.append(",");
        stringBuffer.append(size2);
        stringBuffer.append(" @@");
        arrayList.add(0, stringBuffer.toString());
        return arrayList;
    }

    private static List getDeltaText(Delta delta) {
        ArrayList arrayList = new ArrayList();
        Iterator it = delta.getOriginal().getLines().iterator();
        while (it.hasNext()) {
            arrayList.add("-" + ((String) it.next()));
        }
        Iterator it2 = delta.getRevised().getLines().iterator();
        while (it2.hasNext()) {
            arrayList.add(Marker.ANY_NON_NULL_MARKER + ((String) it2.next()));
        }
        return arrayList;
    }
}
