package org.picocontainer.paranamer;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes6.dex */
public class AdaptiveParanamer implements Paranamer {
    public static final String __PARANAMER_DATA = "v1.0 \ncom.thoughtworks.paranamer.AdaptiveParanamer AdaptiveParanamer com.thoughtworks.paranamer.Paranamer,com.thoughtworks.paranamer.Paranamer delegate,fallback\ncom.thoughtworks.paranamer.AdaptiveParanamer AdaptiveParanamer com.thoughtworks.paranamer.Paranamer,com.thoughtworks.paranamer.Paranamer,com.thoughtworks.paranamer.Paranamer delegate,fallback,reserve\ncom.thoughtworks.paranamer.AdaptiveParanamer AdaptiveParanamer com.thoughtworks.paranamer.Paranamer[] paranamers\ncom.thoughtworks.paranamer.AdaptiveParanamer lookupParameterNames java.lang.AccessibleObject methodOrConstructor \ncom.thoughtworks.paranamer.AdaptiveParanamer lookupParameterNames java.lang.AccessibleObject,boolean methodOrCtor,throwExceptionIfMissing \n";
    private final Paranamer[] paranamers;

    public AdaptiveParanamer() {
        this(new DefaultParanamer(), new BytecodeReadingParanamer());
    }

    public AdaptiveParanamer(Paranamer... paranamerArr) {
        this.paranamers = paranamerArr;
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject) {
        return lookupParameterNames(accessibleObject, true);
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject, boolean z) {
        String[] strArrLookupParameterNames;
        int i = 0;
        do {
            Paranamer[] paranamerArr = this.paranamers;
            if (i < paranamerArr.length) {
                Paranamer paranamer = paranamerArr[i];
                i++;
                strArrLookupParameterNames = paranamer.lookupParameterNames(accessibleObject, i < paranamerArr.length ? false : z);
            } else {
                return Paranamer.EMPTY_NAMES;
            }
        } while (strArrLookupParameterNames == Paranamer.EMPTY_NAMES);
        return strArrLookupParameterNames;
    }
}
