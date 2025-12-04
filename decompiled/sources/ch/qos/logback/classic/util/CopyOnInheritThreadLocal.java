package ch.qos.logback.classic.util;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class CopyOnInheritThreadLocal extends InheritableThreadLocal<HashMap<String, String>> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.InheritableThreadLocal
    public HashMap<String, String> childValue(HashMap<String, String> map) {
        if (map == null) {
            return null;
        }
        return new HashMap<>(map);
    }
}
