package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.p000private.o;

/* loaded from: classes2.dex */
public class ad extends o {
    public ad(long j, String str) {
        super(j, str);
    }

    public static class a extends o.a {
        @Override // com.appdynamics.eumagent.runtime.private.o.a
        public final o a(long j, String str) {
            return new ad(j, str);
        }
    }
}
