package com.appdynamics.eumagent.runtime.p192private;

import java.io.InputStream;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bl */
/* JADX INFO: loaded from: classes2.dex */
public final class C2089bl {

    /* JADX INFO: renamed from: a */
    final String f678a;

    /* JADX INFO: renamed from: b */
    final byte[] f679b;

    /* JADX INFO: renamed from: c */
    final InputStream f680c;

    C2089bl(String str, byte[] bArr) {
        this.f678a = str;
        this.f679b = bArr;
        this.f680c = null;
    }

    C2089bl(String str, InputStream inputStream) {
        this.f678a = str;
        this.f680c = inputStream;
        this.f679b = null;
    }
}
