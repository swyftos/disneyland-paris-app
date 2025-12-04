package com.appdynamics.eumagent.runtime.p000private;

import java.io.InputStream;

/* loaded from: classes2.dex */
public final class bl {
    final String a;
    final byte[] b;
    final InputStream c;

    bl(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
        this.c = null;
    }

    bl(String str, InputStream inputStream) {
        this.a = str;
        this.c = inputStream;
        this.b = null;
    }
}
