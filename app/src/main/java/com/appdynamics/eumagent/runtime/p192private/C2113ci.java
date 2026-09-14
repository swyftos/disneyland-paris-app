package com.appdynamics.eumagent.runtime.p192private;

import android.util.Pair;
import android.view.View;
import com.appdynamics.eumagent.runtime.CollectorChannel;
import com.appdynamics.eumagent.runtime.CollectorChannelFactory;
import java.lang.reflect.Field;
import java.net.URL;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.ci */
/* JADX INFO: loaded from: classes2.dex */
public final class C2113ci {

    /* JADX INFO: renamed from: a */
    public C2127f f799a;

    /* JADX INFO: renamed from: b */
    public final URL f800b;

    /* JADX INFO: renamed from: c */
    public final URL f801c;

    /* JADX INFO: renamed from: d */
    public CollectorChannelFactory f802d;

    /* JADX INFO: renamed from: e */
    private URL f803e;

    /* JADX INFO: renamed from: f */
    private Pair<String, URL> f804f = null;

    /* JADX INFO: renamed from: a */
    static Object m648a(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
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

    public C2113ci(URL url, URL url2, URL url3, C2127f c2127f, CollectorChannelFactory collectorChannelFactory) {
        this.f800b = url;
        this.f803e = url3;
        this.f801c = url2;
        this.f802d = collectorChannelFactory;
        this.f799a = c2127f;
    }

    /* JADX INFO: renamed from: a */
    public final CollectorChannel m649a() {
        Pair<String, URL> pair = this.f804f;
        String str = this.f799a.f845b;
        if (pair == null || !((String) pair.first).equals(str)) {
            pair = new Pair<>(str, new URL(this.f803e, String.format("%s/tiles", str)));
            this.f804f = pair;
        }
        CollectorChannel collectorChannelNewCollectorChannel = this.f802d.newCollectorChannel();
        collectorChannelNewCollectorChannel.setURL((URL) pair.second);
        collectorChannelNewCollectorChannel.setRequestMethod("PUT");
        collectorChannelNewCollectorChannel.setConnectTimeout(30000);
        collectorChannelNewCollectorChannel.setReadTimeout(30000);
        this.f799a.m689a(collectorChannelNewCollectorChannel);
        return collectorChannelNewCollectorChannel;
    }
}
