package androidx.test.internal.runner;

import android.app.Instrumentation;
import com.amazonaws.services.s3.model.InstructionFileId;
import dalvik.system.DexFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class ClassPathScanner {
    private final Set classPath;

    public static class AcceptAllFilter implements ClassNameFilter {
        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean accept(String str) {
            return true;
        }
    }

    public interface ClassNameFilter {
        boolean accept(String str);
    }

    public static class ChainedClassNameFilter implements ClassNameFilter {
        private final List filters = new ArrayList();

        public void add(ClassNameFilter classNameFilter) {
            this.filters.add(classNameFilter);
        }

        public void addAll(ClassNameFilter... classNameFilterArr) {
            this.filters.addAll(Arrays.asList(classNameFilterArr));
        }

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean accept(String str) {
            Iterator it = this.filters.iterator();
            while (it.hasNext()) {
                if (!((ClassNameFilter) it.next()).accept(str)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class ExternalClassNameFilter implements ClassNameFilter {
        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean accept(String str) {
            return !str.contains("$");
        }
    }

    public static class InclusivePackageNamesFilter implements ClassNameFilter {
        private final Collection pkgNames;

        InclusivePackageNamesFilter(Collection collection) {
            this.pkgNames = new ArrayList(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!str.endsWith(InstructionFileId.DOT)) {
                    this.pkgNames.add(String.format("%s.", str));
                } else {
                    this.pkgNames.add(str);
                }
            }
        }

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean accept(String str) {
            Iterator it = this.pkgNames.iterator();
            while (it.hasNext()) {
                if (str.startsWith((String) it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class ExcludePackageNameFilter implements ClassNameFilter {
        private final String pkgName;

        ExcludePackageNameFilter(String str) {
            if (!str.endsWith(InstructionFileId.DOT)) {
                this.pkgName = String.format("%s.", str);
            } else {
                this.pkgName = str;
            }
        }

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean accept(String str) {
            return !str.startsWith(this.pkgName);
        }
    }

    static class ExcludeClassNamesFilter implements ClassNameFilter {
        private final Set excludedClassNames;

        public ExcludeClassNamesFilter(Set set) {
            this.excludedClassNames = set;
        }

        @Override // androidx.test.internal.runner.ClassPathScanner.ClassNameFilter
        public boolean accept(String str) {
            return !this.excludedClassNames.contains(str);
        }
    }

    public ClassPathScanner(String... strArr) {
        this(Arrays.asList(strArr));
    }

    public ClassPathScanner(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.classPath = hashSet;
        hashSet.addAll(collection);
    }

    public static Collection<String> getDefaultClasspaths(Instrumentation instrumentation) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(instrumentation.getContext().getPackageCodePath());
        return arrayList;
    }

    private void addEntriesFromPath(Set set, String str, ClassNameFilter classNameFilter) throws IOException {
        DexFile dexFileLoadDex;
        DexFile dexFile = null;
        try {
            try {
                dexFileLoadDex = new DexFile(str);
            } catch (IOException e) {
                if (str.endsWith(".zip")) {
                    dexFileLoadDex = DexFile.loadDex(str, String.valueOf(str.substring(0, str.length() - 3)).concat("dex"), 0);
                } else {
                    throw e;
                }
            }
            Enumeration<String> enumerationEntries = dexFileLoadDex.entries();
            while (enumerationEntries.hasMoreElements()) {
                String strNextElement = enumerationEntries.nextElement();
                if (classNameFilter.accept(strNextElement)) {
                    set.add(strNextElement);
                }
            }
            dexFileLoadDex.close();
        } catch (Throwable th) {
            if (0 != 0) {
                dexFile.close();
            }
            throw th;
        }
    }

    public Set<String> getClassPathEntries(ClassNameFilter classNameFilter) throws IOException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = this.classPath.iterator();
        while (it.hasNext()) {
            addEntriesFromPath(linkedHashSet, (String) it.next(), classNameFilter);
        }
        return linkedHashSet;
    }
}
