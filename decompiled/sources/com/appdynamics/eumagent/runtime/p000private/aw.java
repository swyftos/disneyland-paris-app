package com.appdynamics.eumagent.runtime.p000private;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class aw {
    final List<a> a = new ArrayList();

    static class a implements Comparable<a> {
        private final Long a;
        private final String b;

        /* synthetic */ a(Long l, String str, byte b) {
            this(l, str);
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
            return this.a.compareTo(aVar.a);
        }

        private a(Long l, String str) {
            this.a = l;
            this.b = str;
        }
    }

    static Long a(String str) throws NumberFormatException {
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

    static String b(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
