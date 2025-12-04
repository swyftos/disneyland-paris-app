package org.picocontainer.paranamer;

import java.lang.reflect.AccessibleObject;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public class CachingParanamer implements Paranamer {
    public static final String __PARANAMER_DATA = "v1.0 \ncom.thoughtworks.paranamer.CachingParanamer <init> com.thoughtworks.paranamer.Paranamer delegate \ncom.thoughtworks.paranamer.CachingParanamer lookupParameterNames java.lang.AccessibleObject methodOrConstructor \ncom.thoughtworks.paranamer.CachingParanamer lookupParameterNames java.lang.AccessibleObject, boolean methodOrCtor,throwExceptionIfMissing \n";
    private final Paranamer delegate;
    private final WeakHashMap methodCache;

    public CachingParanamer() {
        this(new DefaultParanamer());
    }

    public CachingParanamer(Paranamer paranamer) {
        this.methodCache = new WeakHashMap();
        this.delegate = paranamer;
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject) {
        return lookupParameterNames(accessibleObject, true);
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject, boolean z) {
        String[] strArr = (String[]) this.methodCache.get(accessibleObject);
        if (strArr != null) {
            return strArr;
        }
        String[] strArrLookupParameterNames = this.delegate.lookupParameterNames(accessibleObject, z);
        this.methodCache.put(accessibleObject, strArrLookupParameterNames);
        return strArrLookupParameterNames;
    }
}
