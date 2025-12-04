package ch.qos.logback.core.rolling.helper;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class FileFinder {
    private FileProvider fileProvider;

    FileFinder(FileProvider fileProvider) {
        this.fileProvider = fileProvider;
    }

    private void findDirs(List list, List list2, int i, List list3) {
        if (i >= list2.size() - 1) {
            return;
        }
        PathPart pathPart = (PathPart) list2.get(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (this.fileProvider.isDirectory(file) && pathPart.matches(file)) {
                list3.add(file);
                findDirs(Arrays.asList(this.fileProvider.listFiles(file, null)), list2, i + 1, list3);
            }
        }
    }

    private List findFiles(List list, List list2, int i) {
        ArrayList arrayList = new ArrayList();
        PathPart pathPart = (PathPart) list2.get(i);
        if (i >= list2.size() - 1) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (pathPart.matches(file)) {
                    arrayList.add(file);
                }
            }
            return arrayList;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            File file2 = (File) it2.next();
            if (this.fileProvider.isDirectory(file2) && pathPart.matches(file2)) {
                arrayList.addAll(findFiles(Arrays.asList(this.fileProvider.listFiles(file2, null)), list2, i + 1));
            }
        }
        return arrayList;
    }

    static String regexEscapePath(String str) {
        String str2 = File.separator;
        if (!str.contains(str2)) {
            return "(?:\ufffe)?" + str + "(?:\uffff)?";
        }
        String[] strArrSplit = str.split(str2);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].length() > 0) {
                strArrSplit[i] = "(?:\ufffe)?" + strArrSplit[i] + "(?:\uffff)?";
            }
        }
        return TextUtils.join(File.separator, strArrSplit);
    }

    private List toAbsolutePaths(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((File) it.next()).getAbsolutePath());
        }
        return arrayList;
    }

    static String unescapePath(String str) {
        return str.replace("(?:\ufffe)?", "").replace("(?:\uffff)?", "");
    }

    List findDirs(String str) {
        List listSplitPath = splitPath(str);
        PathPart pathPart = (PathPart) listSplitPath.get(0);
        ArrayList arrayList = new ArrayList();
        findDirs(pathPart.listFiles(this.fileProvider), listSplitPath, 1, arrayList);
        return toAbsolutePaths(arrayList);
    }

    List findFiles(String str) {
        List listSplitPath = splitPath(str);
        return toAbsolutePaths(findFiles(((PathPart) listSplitPath.get(0)).listFiles(this.fileProvider), listSplitPath, 1));
    }

    List splitPath(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : str.split(File.separator)) {
            boolean z = str2.contains("(?:\ufffe)?") && str2.contains("(?:\uffff)?");
            String strReplace = str2.replace("(?:\ufffe)?", "").replace("(?:\uffff)?", "");
            if (z) {
                if (!arrayList2.isEmpty()) {
                    arrayList.add(new LiteralPathPart(TextUtils.join(File.separator, arrayList2)));
                    arrayList2.clear();
                }
                arrayList.add(new RegexPathPart(strReplace));
            } else {
                arrayList2.add(strReplace);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(new LiteralPathPart(TextUtils.join(File.separator, arrayList2)));
        }
        return arrayList;
    }
}
