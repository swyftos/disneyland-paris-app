package org.picocontainer.paranamer;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes6.dex */
public interface Paranamer {
    public static final String[] EMPTY_NAMES = new String[0];
    public static final String __PARANAMER_DATA = "lookupParameterNames java.lang.reflect.AccessibleObject methodOrConstructor \nlookupParameterNames java.lang.reflect.AccessibleObject,boolean methodOrConstructor,throwExceptionIfMissing \n";

    String[] lookupParameterNames(AccessibleObject accessibleObject);

    String[] lookupParameterNames(AccessibleObject accessibleObject, boolean z);
}
