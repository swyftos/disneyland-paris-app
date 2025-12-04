package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.action.ActionUtil;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.OptionHelper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class PropertyAction extends Action {
    static String INVALID_ATTRIBUTES = "In <property> element, either the \"file\" attribute alone, or the \"resource\" element alone, or both the \"name\" and \"value\" attributes must be set.";

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        String string;
        String strSubst;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3;
        if ("substitutionProperty".equals(str)) {
            addWarn("[substitutionProperty] element has been deprecated. Please use the [property] element instead.");
        }
        String value = attributes.getValue("name");
        String value2 = attributes.getValue("value");
        ActionUtil.Scope scopeStringToScope = ActionUtil.stringToScope(attributes.getValue(Action.SCOPE_ATTRIBUTE));
        if (checkFileAttributeSanity(attributes)) {
            strSubst = interpretationContext.subst(attributes.getValue("file"));
            try {
                loadAndSetProperties(interpretationContext, new FileInputStream(strSubst), scopeStringToScope);
                return;
            } catch (FileNotFoundException unused) {
                sb2 = new StringBuilder();
                str3 = "Could not find properties file [";
            } catch (IOException e) {
                e = e;
                sb = new StringBuilder();
                str2 = "Could not read properties file [";
                sb.append(str2);
                sb.append(strSubst);
                sb.append("].");
                addError(sb.toString(), e);
                return;
            }
        } else if (checkResourceAttributeSanity(attributes)) {
            strSubst = interpretationContext.subst(attributes.getValue("resource"));
            URL resourceBySelfClassLoader = Loader.getResourceBySelfClassLoader(strSubst);
            if (resourceBySelfClassLoader != null) {
                try {
                    loadAndSetProperties(interpretationContext, resourceBySelfClassLoader.openStream(), scopeStringToScope);
                    return;
                } catch (IOException e2) {
                    e = e2;
                    sb = new StringBuilder();
                    str2 = "Could not read resource file [";
                    sb.append(str2);
                    sb.append(strSubst);
                    sb.append("].");
                    addError(sb.toString(), e);
                    return;
                }
            }
            sb2 = new StringBuilder();
            str3 = "Could not find resource [";
            sb2.append(str3);
            sb2.append(strSubst);
            sb2.append("].");
            string = sb2.toString();
        } else {
            if (checkValueNameAttributesSanity(attributes)) {
                ActionUtil.setProperty(interpretationContext, value, interpretationContext.subst(RegularEscapeUtil.basicEscape(value2).trim()), scopeStringToScope);
                return;
            }
            string = INVALID_ATTRIBUTES;
        }
        addError(string);
    }

    boolean checkFileAttributeSanity(Attributes attributes) {
        return !OptionHelper.isEmpty(attributes.getValue("file")) && OptionHelper.isEmpty(attributes.getValue("name")) && OptionHelper.isEmpty(attributes.getValue("value")) && OptionHelper.isEmpty(attributes.getValue("resource"));
    }

    boolean checkResourceAttributeSanity(Attributes attributes) {
        return !OptionHelper.isEmpty(attributes.getValue("resource")) && OptionHelper.isEmpty(attributes.getValue("name")) && OptionHelper.isEmpty(attributes.getValue("value")) && OptionHelper.isEmpty(attributes.getValue("file"));
    }

    boolean checkValueNameAttributesSanity(Attributes attributes) {
        return !OptionHelper.isEmpty(attributes.getValue("name")) && !OptionHelper.isEmpty(attributes.getValue("value")) && OptionHelper.isEmpty(attributes.getValue("file")) && OptionHelper.isEmpty(attributes.getValue("resource"));
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) {
    }

    public void finish(InterpretationContext interpretationContext) {
    }

    void loadAndSetProperties(InterpretationContext interpretationContext, InputStream inputStream, ActionUtil.Scope scope) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        ActionUtil.setProperties(interpretationContext, properties, scope);
    }
}
