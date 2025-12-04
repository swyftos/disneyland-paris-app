package javax.xml.bind;

import java.io.Serializable;
import javax.xml.namespace.QName;

/* loaded from: classes5.dex */
public class JAXBElement<T> implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<T> declaredType;
    protected final QName name;
    protected boolean nil;
    protected final Class scope;
    protected T value;

    public static final class GlobalScope {
    }

    public JAXBElement(QName qName, Class<T> cls, Class cls2, T t) {
        this.nil = false;
        if (cls == null || qName == null) {
            throw new IllegalArgumentException();
        }
        this.declaredType = cls;
        this.scope = cls2 == null ? GlobalScope.class : cls2;
        this.name = qName;
        setValue(t);
    }

    public JAXBElement(QName qName, Class<T> cls, T t) {
        this(qName, cls, GlobalScope.class, t);
    }

    public Class<T> getDeclaredType() {
        return this.declaredType;
    }

    public QName getName() {
        return this.name;
    }

    public void setValue(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public Class getScope() {
        return this.scope;
    }

    public boolean isNil() {
        return this.value == null || this.nil;
    }

    public void setNil(boolean z) {
        this.nil = z;
    }

    public boolean isGlobalScope() {
        return this.scope == GlobalScope.class;
    }

    public boolean isTypeSubstituted() {
        T t = this.value;
        return (t == null || t.getClass() == this.declaredType) ? false : true;
    }
}
