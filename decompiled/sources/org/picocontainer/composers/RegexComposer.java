package org.picocontainer.composers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.PicoContainer;
import org.picocontainer.monitors.ComposingMonitor;

/* loaded from: classes6.dex */
public class RegexComposer implements ComposingMonitor.Composer {
    private final String forNamedComponent;
    private final Pattern pattern;

    public RegexComposer(String str, String str2) {
        this.pattern = Pattern.compile(str);
        this.forNamedComponent = str2;
    }

    public RegexComposer() {
        this.pattern = null;
        this.forNamedComponent = null;
    }

    @Override // org.picocontainer.monitors.ComposingMonitor.Composer
    public Object compose(PicoContainer picoContainer, Object obj) {
        Matcher matcher;
        if (!(obj instanceof String)) {
            return null;
        }
        String str = this.forNamedComponent;
        if (str != null && !str.equals(obj)) {
            return null;
        }
        Pattern patternCompile = this.pattern;
        if (patternCompile == null) {
            patternCompile = Pattern.compile((String) obj);
        }
        Collection<ComponentAdapter<?>> componentAdapters = picoContainer.getComponentAdapters();
        ArrayList arrayList = new ArrayList();
        for (ComponentAdapter<?> componentAdapter : componentAdapters) {
            Object componentKey = componentAdapter.getComponentKey();
            if ((componentKey instanceof String) && (matcher = patternCompile.matcher((String) componentKey)) != null && matcher.find()) {
                arrayList.add(componentAdapter.getComponentInstance(picoContainer, ComponentAdapter.NOTHING.class));
            }
        }
        return arrayList;
    }
}
