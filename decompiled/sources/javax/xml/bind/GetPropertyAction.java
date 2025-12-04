package javax.xml.bind;

import java.security.PrivilegedAction;

/* loaded from: classes5.dex */
final class GetPropertyAction implements PrivilegedAction {
    private final String propertyName;

    public GetPropertyAction(String str) {
        this.propertyName = str;
    }

    @Override // java.security.PrivilegedAction
    public String run() {
        return System.getProperty(this.propertyName);
    }
}
