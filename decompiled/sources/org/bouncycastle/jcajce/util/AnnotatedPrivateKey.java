package org.bouncycastle.jcajce.util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class AnnotatedPrivateKey implements PrivateKey {
    public static final String LABEL = "label";
    private final Map annotations;
    private final PrivateKey key;

    AnnotatedPrivateKey(PrivateKey privateKey, String str) {
        this.key = privateKey;
        this.annotations = Collections.singletonMap("label", str);
    }

    AnnotatedPrivateKey(PrivateKey privateKey, Map map) {
        this.key = privateKey;
        this.annotations = map;
    }

    public AnnotatedPrivateKey addAnnotation(String str, Object obj) {
        HashMap map = new HashMap(this.annotations);
        map.put(str, obj);
        return new AnnotatedPrivateKey(this.key, Collections.unmodifiableMap(map));
    }

    public boolean equals(Object obj) {
        boolean z = obj instanceof AnnotatedPrivateKey;
        PrivateKey privateKey = this.key;
        return z ? privateKey.equals(((AnnotatedPrivateKey) obj).key) : privateKey.equals(obj);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.key.getAlgorithm();
    }

    public Object getAnnotation(String str) {
        return this.annotations.get(str);
    }

    public Map<String, Object> getAnnotations() {
        return this.annotations;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.key.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.key.getFormat();
    }

    public PrivateKey getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public AnnotatedPrivateKey removeAnnotation(String str) {
        HashMap map = new HashMap(this.annotations);
        map.remove(str);
        return new AnnotatedPrivateKey(this.key, Collections.unmodifiableMap(map));
    }

    public String toString() {
        return (this.annotations.containsKey("label") ? this.annotations.get("label") : this.key).toString();
    }
}
