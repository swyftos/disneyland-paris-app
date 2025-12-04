package org.picocontainer.classname;

import java.io.Serializable;
import java.net.URL;
import java.security.Permission;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class ClassPathElement implements Serializable {
    private Permissions permissionCollection;
    private final List permissions = new ArrayList();
    private final URL url;

    public ClassPathElement(URL url) {
        this.url = url;
    }

    public Permission grantPermission(Permission permission) {
        permission.getClass();
        this.permissions.add(permission);
        return permission;
    }

    public URL getUrl() {
        return this.url;
    }

    public Permissions getPermissionCollection() {
        if (this.permissionCollection == null) {
            this.permissionCollection = new Permissions();
            Iterator it = this.permissions.iterator();
            while (it.hasNext()) {
                this.permissionCollection.add((Permission) it.next());
            }
        }
        return this.permissionCollection;
    }

    public String toString() {
        return "[" + System.identityHashCode(this) + " " + this.url + " " + this.permissions.size() + "]";
    }
}
