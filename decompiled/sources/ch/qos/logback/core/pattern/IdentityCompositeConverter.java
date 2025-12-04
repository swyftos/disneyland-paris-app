package ch.qos.logback.core.pattern;

/* loaded from: classes2.dex */
public class IdentityCompositeConverter<E> extends CompositeConverter<E> {
    @Override // ch.qos.logback.core.pattern.CompositeConverter
    protected String transform(E e, String str) {
        return str;
    }
}
