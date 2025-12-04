package io.cucumber.cucumberexpressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: classes5.dex */
abstract class PatternCompilerProvider {
    static PatternCompiler service;

    static synchronized PatternCompiler getCompiler() {
        try {
            if (service == null) {
                findPatternCompiler(ServiceLoader.load(PatternCompiler.class).iterator());
            }
        } catch (Throwable th) {
            throw th;
        }
        return service;
    }

    static void findPatternCompiler(Iterator it) {
        if (it.hasNext()) {
            service = (PatternCompiler) it.next();
            if (it.hasNext()) {
                throwMoreThanOneCompilerException(it);
                return;
            }
            return;
        }
        service = new DefaultPatternCompiler();
    }

    private static void throwMoreThanOneCompilerException(Iterator it) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(service.getClass());
        while (it.hasNext()) {
            arrayList.add(((PatternCompiler) it.next()).getClass());
        }
        throw new IllegalStateException("More than one PatternCompiler: " + arrayList);
    }
}
