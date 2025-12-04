package io.cucumber.junit;

import com.amazonaws.services.s3.model.InstructionFileId;
import cucumber.runtime.ClassFinder;
import dalvik.system.DexFile;
import io.cucumber.core.model.Classpath;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
final class DexClassFinder implements ClassFinder {
    private static final ClassLoader CLASS_LOADER = DexClassFinder.class.getClassLoader();
    private static final Pattern PATH_SEPARATOR_PATTERN = Pattern.compile("/", 16);
    private final DexFile dexFile;

    DexClassFinder(DexFile dexFile) {
        this.dexFile = dexFile;
    }

    @Override // cucumber.runtime.ClassFinder
    public Collection getDescendants(Class cls, URI uri) {
        ArrayList arrayList = new ArrayList();
        String strReplaceAll = PATH_SEPARATOR_PATTERN.matcher(Classpath.resourceName(uri)).replaceAll(Matcher.quoteReplacement(InstructionFileId.DOT));
        Enumeration<String> enumerationEntries = this.dexFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            String strNextElement = enumerationEntries.nextElement();
            if (isInPackage(strNextElement, strReplaceAll) && !isGenerated(strNextElement)) {
                try {
                    Class<?> clsLoadClass = loadClass(strNextElement);
                    if (!cls.equals(clsLoadClass) && cls.isAssignableFrom(clsLoadClass) && canGetMethods(clsLoadClass)) {
                        arrayList.add(clsLoadClass.asSubclass(cls));
                    }
                } catch (ClassNotFoundException | NoClassDefFoundError unused) {
                }
            }
        }
        return arrayList;
    }

    @Override // cucumber.runtime.ClassFinder
    public Class loadClass(String str) {
        return Class.forName(str, false, CLASS_LOADER);
    }

    private boolean isInPackage(String str, String str2) {
        int iLastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        return (iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf)).startsWith(str2);
    }

    private static boolean isGenerated(String str) {
        return isAndroidGenerated(str) || isKotlinGenerated(str);
    }

    private static boolean isAndroidGenerated(String str) {
        int iLastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        if (iLastIndexOf != -1) {
            str = str.substring(iLastIndexOf + 1);
        }
        return str.equals("Manifest") || str.equals("R") || str.startsWith("R$");
    }

    private static boolean isKotlinGenerated(String str) {
        return str.contains("$$inlined$");
    }

    private static boolean canGetMethods(Class cls) throws SecurityException {
        try {
            cls.getMethods();
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }
}
