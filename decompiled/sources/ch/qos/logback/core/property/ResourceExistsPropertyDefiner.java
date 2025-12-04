package ch.qos.logback.core.property;

import ch.qos.logback.core.PropertyDefinerBase;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.OptionHelper;

/* loaded from: classes2.dex */
public class ResourceExistsPropertyDefiner extends PropertyDefinerBase {
    String resourceStr;

    @Override // ch.qos.logback.core.spi.PropertyDefiner
    public String getPropertyValue() {
        if (!OptionHelper.isEmpty(this.resourceStr)) {
            return PropertyDefinerBase.booleanAsStr(Loader.getResourceBySelfClassLoader(this.resourceStr) != null);
        }
        addError("The \"resource\" property must be set.");
        return null;
    }

    public String getResource() {
        return this.resourceStr;
    }

    public void setResource(String str) {
        this.resourceStr = str;
    }
}
