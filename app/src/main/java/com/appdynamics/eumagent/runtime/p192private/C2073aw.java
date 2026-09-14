package com.appdynamics.eumagent.runtime.p192private;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aw */
/* JADX INFO: loaded from: classes2.dex */
public final class C2073aw {

    /* JADX INFO: renamed from: a */
    final List<a> f603a = new ArrayList();

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aw$a */
    static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a */
        private final Long f604a;

        /* JADX INFO: renamed from: b */
        private final String f605b;

        /* synthetic */ a(Long l, String str, byte b) {
            this(l, str);
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
            return this.f604a.compareTo(aVar.f604a);
        }

        private a(Long l, String str) {
            this.f604a = l;
            this.f605b = str;
        }
    }

    /* JADX INFO: renamed from: a */
    static Long m566a(String str) {
        try {
            Long lValueOf = Long.valueOf(str);
            if (lValueOf.longValue() >= 0) {
                return lValueOf;
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    static String m567b(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
