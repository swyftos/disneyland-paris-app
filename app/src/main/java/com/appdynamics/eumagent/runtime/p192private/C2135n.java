package com.appdynamics.eumagent.runtime.p192private;

import java.util.Arrays;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.n */
/* JADX INFO: loaded from: classes2.dex */
public class C2135n {

    /* JADX INFO: renamed from: a */
    public String f898a;

    /* JADX INFO: renamed from: b */
    public String f899b;

    public C2135n(String str, String str2) {
        if (str == null || str2 == null) {
            this.f898a = null;
            this.f899b = null;
        } else if (Arrays.asList("React Native", "Cordova", "Xamarin", "Flutter").contains(str)) {
            this.f898a = str;
            this.f899b = str2;
        } else {
            this.f898a = null;
            this.f899b = null;
        }
    }
}
