package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.OptionHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public abstract class AbstractIncludeAction extends Action {
    private String attributeInUse;
    private boolean optional;

    private URL attributeToURL(String str) throws IOException {
        StringBuilder sb;
        String str2;
        try {
            URL url = new URL(str);
            url.openStream().close();
            return url;
        } catch (MalformedURLException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("URL [");
            sb.append(str);
            str2 = "] is not well formed.";
            sb.append(str2);
            optionalWarning(sb.toString(), e);
            return null;
        } catch (IOException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("URL [");
            sb.append(str);
            str2 = "] cannot be opened.";
            sb.append(str2);
            optionalWarning(sb.toString(), e);
            return null;
        }
    }

    private boolean checkAttributes(Attributes attributes) {
        String str;
        String value = attributes.getValue("file");
        String value2 = attributes.getValue("url");
        String value3 = attributes.getValue("resource");
        int i = !OptionHelper.isEmpty(value) ? 1 : 0;
        if (!OptionHelper.isEmpty(value2)) {
            i++;
        }
        if (!OptionHelper.isEmpty(value3)) {
            i++;
        }
        if (i == 0) {
            str = String.format("One of \"%1$s\", \"%2$s\" or \"%3$s\" attributes must be set.", "file", "resource", "url");
        } else {
            if (i <= 1) {
                if (i == 1) {
                    return true;
                }
                throw new IllegalStateException("Count value [" + i + "] is not expected");
            }
            str = String.format("Only one of \"%1$s\", \"%2$s\" or \"%3$s\" attributes should be set.", "file", "resource", "url");
        }
        optionalWarning(str, null);
        return false;
    }

    private URL filePathAsURL(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                return file.toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
        }
        optionalWarning("File does not exist [" + str + "]", new FileNotFoundException(str));
        return null;
    }

    private URL getInputURL(InterpretationContext interpretationContext, Attributes attributes) {
        String value = attributes.getValue("file");
        String value2 = attributes.getValue("url");
        String value3 = attributes.getValue("resource");
        if (!OptionHelper.isEmpty(value)) {
            String strSubst = interpretationContext.subst(value);
            this.attributeInUse = strSubst;
            return filePathAsURL(strSubst);
        }
        if (!OptionHelper.isEmpty(value2)) {
            String strSubst2 = interpretationContext.subst(value2);
            this.attributeInUse = strSubst2;
            return attributeToURL(strSubst2);
        }
        if (OptionHelper.isEmpty(value3)) {
            throw new IllegalStateException("A URL stream should have been returned");
        }
        String strSubst3 = interpretationContext.subst(value3);
        this.attributeInUse = strSubst3;
        return resourceAsURL(strSubst3);
    }

    private URL resourceAsURL(String str) {
        URL resourceBySelfClassLoader = Loader.getResourceBySelfClassLoader(str);
        if (resourceBySelfClassLoader != null) {
            return resourceBySelfClassLoader;
        }
        optionalWarning("Could not find resource corresponding to [" + str + "]", null);
        return null;
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        this.attributeInUse = null;
        this.optional = OptionHelper.toBoolean(attributes.getValue("optional"), false);
        if (checkAttributes(attributes)) {
            try {
                URL inputURL = getInputURL(interpretationContext, attributes);
                if (inputURL != null) {
                    processInclude(interpretationContext, inputURL);
                }
            } catch (JoranException e) {
                optionalWarning("Error while parsing " + this.attributeInUse, e);
            }
        }
    }

    protected void close(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws ActionException {
    }

    protected String getAttributeInUse() {
        return this.attributeInUse;
    }

    protected void handleError(String str, Exception exc) {
        if (exc == null || !((exc instanceof FileNotFoundException) || (exc instanceof UnknownHostException))) {
            addError(str, exc);
        } else {
            addWarn(str, exc);
        }
    }

    protected boolean isOptional() {
        return this.optional;
    }

    protected void optionalWarning(String str, Exception exc) {
        if (isOptional()) {
            return;
        }
        handleError(str, exc);
    }

    protected abstract void processInclude(InterpretationContext interpretationContext, URL url) throws JoranException;
}
