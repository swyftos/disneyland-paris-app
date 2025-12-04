package com.appdynamics.eumagent.runtime.p000private;

import android.util.Pair;
import android.view.View;
import com.appdynamics.eumagent.runtime.CollectorChannel;
import com.appdynamics.eumagent.runtime.CollectorChannelFactory;
import java.lang.reflect.Field;
import java.net.URL;

/* loaded from: classes2.dex */
public final class ci {
    public f a;
    public final URL b;
    public final URL c;
    public CollectorChannelFactory d;
    private URL e;
    private Pair<String, URL> f = null;

    static Object a(Object obj, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField;
        if (obj == null) {
            return null;
        }
        try {
            declaredField = View.class.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            declaredField = null;
        }
        if (declaredField == null) {
            Field declaredField2 = View.class.getDeclaredField("mListenerInfo");
            declaredField2.setAccessible(true);
            obj = declaredField2.get(obj);
            if (obj != null) {
                declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField(str);
            }
        }
        if (obj == null || declaredField == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public ci(URL url, URL url2, URL url3, f fVar, CollectorChannelFactory collectorChannelFactory) {
        this.b = url;
        this.e = url3;
        this.c = url2;
        this.d = collectorChannelFactory;
        this.a = fVar;
    }

    public final CollectorChannel a() {
        Pair<String, URL> pair = this.f;
        String str = this.a.b;
        if (pair == null || !((String) pair.first).equals(str)) {
            pair = new Pair<>(str, new URL(this.e, String.format("%s/tiles", str)));
            this.f = pair;
        }
        CollectorChannel collectorChannelNewCollectorChannel = this.d.newCollectorChannel();
        collectorChannelNewCollectorChannel.setURL((URL) pair.second);
        collectorChannelNewCollectorChannel.setRequestMethod("PUT");
        collectorChannelNewCollectorChannel.setConnectTimeout(30000);
        collectorChannelNewCollectorChannel.setReadTimeout(30000);
        this.a.a(collectorChannelNewCollectorChannel);
        return collectorChannelNewCollectorChannel;
    }
}
