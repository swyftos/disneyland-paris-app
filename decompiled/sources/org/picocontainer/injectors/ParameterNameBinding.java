package org.picocontainer.injectors;

import java.lang.reflect.AccessibleObject;
import org.picocontainer.NameBinding;
import org.picocontainer.paranamer.Paranamer;

/* loaded from: classes6.dex */
public class ParameterNameBinding implements NameBinding {
    private final int index;
    private final AccessibleObject member;
    private String name;
    private final Paranamer paranamer;

    public ParameterNameBinding(Paranamer paranamer, AccessibleObject accessibleObject, int i) {
        this.member = accessibleObject;
        this.paranamer = paranamer;
        this.index = i;
    }

    @Override // org.picocontainer.NameBinding
    public String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        String[] strArrLookupParameterNames = this.paranamer.lookupParameterNames(this.member, false);
        String str2 = strArrLookupParameterNames.length == 0 ? "" : strArrLookupParameterNames[this.index];
        this.name = str2;
        return str2;
    }
}
