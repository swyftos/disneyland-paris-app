package com.appdynamics.eumagent.runtime.p000private;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class n {
    public String a;
    public String b;

    public n(String str, String str2) {
        if (str == null || str2 == null) {
            this.a = null;
            this.b = null;
        } else if (Arrays.asList("React Native", "Cordova", "Xamarin", "Flutter").contains(str)) {
            this.a = str;
            this.b = str2;
        } else {
            this.a = null;
            this.b = null;
        }
    }
}
