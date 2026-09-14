package timber.log;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes7.dex */
public final class Timber {
    private static final Tree[] TREE_ARRAY_EMPTY;
    static volatile Tree[] forestAsArray;
    private static final List FOREST = new ArrayList();
    private static final Tree TREE_OF_SOULS = new Tree() { // from class: timber.log.Timber.1
        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: v */
        public void mo468v(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo468v(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: v */
        public void mo470v(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo470v(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: v */
        public void mo469v(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo469v(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: d */
        public void mo459d(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo459d(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: d */
        public void mo461d(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo461d(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: d */
        public void mo460d(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo460d(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: i */
        public void mo465i(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo465i(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: i */
        public void mo467i(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo467i(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: i */
        public void mo466i(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo466i(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: w */
        public void mo471w(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo471w(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: w */
        public void mo473w(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo473w(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: w */
        public void mo472w(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo472w(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: e */
        public void mo462e(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo462e(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: e */
        public void mo464e(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo464e(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* JADX INFO: renamed from: e */
        public void mo463e(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo463e(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, th);
            }
        }

        @Override // timber.log.Timber.Tree
        protected void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    };

    /* JADX INFO: renamed from: v */
    public static void m2158v(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo468v(str, objArr);
    }

    /* JADX INFO: renamed from: v */
    public static void m2160v(Throwable th, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo470v(th, str, objArr);
    }

    /* JADX INFO: renamed from: v */
    public static void m2159v(Throwable th) {
        TREE_OF_SOULS.mo469v(th);
    }

    /* JADX INFO: renamed from: d */
    public static void m2149d(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo459d(str, objArr);
    }

    /* JADX INFO: renamed from: d */
    public static void m2151d(Throwable th, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo461d(th, str, objArr);
    }

    /* JADX INFO: renamed from: d */
    public static void m2150d(Throwable th) {
        TREE_OF_SOULS.mo460d(th);
    }

    /* JADX INFO: renamed from: i */
    public static void m2155i(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo465i(str, objArr);
    }

    /* JADX INFO: renamed from: i */
    public static void m2157i(Throwable th, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo467i(th, str, objArr);
    }

    /* JADX INFO: renamed from: i */
    public static void m2156i(Throwable th) {
        TREE_OF_SOULS.mo466i(th);
    }

    /* JADX INFO: renamed from: w */
    public static void m2161w(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo471w(str, objArr);
    }

    /* JADX INFO: renamed from: w */
    public static void m2163w(Throwable th, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo473w(th, str, objArr);
    }

    /* JADX INFO: renamed from: w */
    public static void m2162w(Throwable th) {
        TREE_OF_SOULS.mo472w(th);
    }

    /* JADX INFO: renamed from: e */
    public static void m2152e(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo462e(str, objArr);
    }

    /* JADX INFO: renamed from: e */
    public static void m2154e(Throwable th, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.mo464e(th, str, objArr);
    }

    /* JADX INFO: renamed from: e */
    public static void m2153e(Throwable th) {
        TREE_OF_SOULS.mo463e(th);
    }

    public static void wtf(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.wtf(str, objArr);
    }

    public static void wtf(Throwable th, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.wtf(th, str, objArr);
    }

    public static void wtf(Throwable th) {
        TREE_OF_SOULS.wtf(th);
    }

    public static void log(int i, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.log(i, str, objArr);
    }

    public static void log(int i, Throwable th, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.log(i, th, str, objArr);
    }

    public static void log(int i, Throwable th) {
        TREE_OF_SOULS.log(i, th);
    }

    @NotNull
    public static Tree asTree() {
        return TREE_OF_SOULS;
    }

    @NotNull
    public static Tree tag(String str) {
        for (Tree tree : forestAsArray) {
            tree.explicitTag.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static void plant(@NotNull Tree tree) {
        if (tree == null) {
            throw new NullPointerException("tree == null");
        }
        if (tree == TREE_OF_SOULS) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        List list = FOREST;
        synchronized (list) {
            list.add(tree);
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void plant(@NotNull Tree... treeArr) {
        if (treeArr == null) {
            throw new NullPointerException("trees == null");
        }
        for (Tree tree : treeArr) {
            if (tree == null) {
                throw new NullPointerException("trees contains null");
            }
            if (tree == TREE_OF_SOULS) {
                throw new IllegalArgumentException("Cannot plant Timber into itself.");
            }
        }
        List list = FOREST;
        synchronized (list) {
            Collections.addAll(list, treeArr);
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void uproot(@NotNull Tree tree) {
        List list = FOREST;
        synchronized (list) {
            try {
                if (!list.remove(tree)) {
                    throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
                }
                forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void uprootAll() {
        List list = FOREST;
        synchronized (list) {
            list.clear();
            forestAsArray = TREE_ARRAY_EMPTY;
        }
    }

    @NotNull
    public static List<Tree> forest() {
        List<Tree> listUnmodifiableList;
        List list = FOREST;
        synchronized (list) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return listUnmodifiableList;
    }

    public static int treeCount() {
        int size;
        List list = FOREST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    static {
        Tree[] treeArr = new Tree[0];
        TREE_ARRAY_EMPTY = treeArr;
        forestAsArray = treeArr;
    }

    public static abstract class Tree {
        final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        @Deprecated
        protected boolean isLoggable(int i) {
            return true;
        }

        protected abstract void log(int i, @Nullable String str, @NotNull String str2, @Nullable Throwable th);

        String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        /* JADX INFO: renamed from: v */
        public void mo468v(String str, Object... objArr) {
            prepareLog(2, null, str, objArr);
        }

        /* JADX INFO: renamed from: v */
        public void mo470v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        /* JADX INFO: renamed from: v */
        public void mo469v(Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: d */
        public void mo459d(String str, Object... objArr) {
            prepareLog(3, null, str, objArr);
        }

        /* JADX INFO: renamed from: d */
        public void mo461d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        /* JADX INFO: renamed from: d */
        public void mo460d(Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: i */
        public void mo465i(String str, Object... objArr) {
            prepareLog(4, null, str, objArr);
        }

        /* JADX INFO: renamed from: i */
        public void mo467i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        /* JADX INFO: renamed from: i */
        public void mo466i(Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: w */
        public void mo471w(String str, Object... objArr) {
            prepareLog(5, null, str, objArr);
        }

        /* JADX INFO: renamed from: w */
        public void mo473w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        /* JADX INFO: renamed from: w */
        public void mo472w(Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        /* JADX INFO: renamed from: e */
        public void mo462e(String str, Object... objArr) {
            prepareLog(6, null, str, objArr);
        }

        /* JADX INFO: renamed from: e */
        public void mo464e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        /* JADX INFO: renamed from: e */
        public void mo463e(Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, null, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, null, str, objArr);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, null, new Object[0]);
        }

        protected boolean isLoggable(@Nullable String str, int i) {
            return isLoggable(i);
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + getStackTraceString(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = getStackTraceString(th);
                }
                log(i, tag, str, th);
            }
        }

        protected String formatMessage(@NotNull String str, @NotNull Object[] objArr) {
            return String.format(str, objArr);
        }

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }

    public static class DebugTree extends Tree {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

        @Nullable
        protected String createStackElementTag(@NotNull StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String strSubstring = className.substring(className.lastIndexOf(46) + 1);
            strSubstring.length();
            return strSubstring;
        }

        @Override // timber.log.Timber.Tree
        final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length <= 5) {
                throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
            }
            return createStackElementTag(stackTrace[5]);
        }

        @Override // timber.log.Timber.Tree
        protected void log(int i, String str, @NotNull String str2, Throwable th) {
            int iMin;
            if (str2.length() < 4000) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int iIndexOf = str2.indexOf(10, i2);
                if (iIndexOf == -1) {
                    iIndexOf = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf, i2 + 4000);
                    String strSubstring = str2.substring(i2, iMin);
                    if (i == 7) {
                        Log.wtf(str, strSubstring);
                    } else {
                        Log.println(i, str, strSubstring);
                    }
                    if (iMin >= iIndexOf) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }
}
