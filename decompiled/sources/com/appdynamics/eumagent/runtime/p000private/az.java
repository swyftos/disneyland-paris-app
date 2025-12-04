package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.AgentConfiguration;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class az implements an {
    private ArrayList<Pattern> a;
    private ArrayList<String> b = new ArrayList<>(Arrays.asList("http://10.0.2.2:9001", "http://efmockserver:9001"));

    public az(AgentConfiguration agentConfiguration) {
        Set<String> set = agentConfiguration.excludedUrlPatterns;
        this.a = new ArrayList<>();
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                this.a.add(Pattern.compile(it.next()));
            }
        }
        a(agentConfiguration);
    }

    @Override // com.appdynamics.eumagent.runtime.p000private.an
    public final boolean a(Object obj) {
        URL url;
        ArrayList<Pattern> arrayList = this.a;
        if (arrayList == null || arrayList.isEmpty() || !(obj instanceof bc) || (url = ((bc) obj).i) == null) {
            return false;
        }
        String string = url.toString();
        Iterator<Pattern> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(string).matches()) {
                return true;
            }
        }
        return false;
    }

    private void a(AgentConfiguration agentConfiguration) {
        Iterator<String> it = this.b.iterator();
        boolean z = true;
        boolean z2 = true;
        while (it.hasNext()) {
            String next = it.next();
            if (agentConfiguration.collectorURL.equals(next)) {
                z = false;
            }
            if (agentConfiguration.screenshotURL.equals(next)) {
                z2 = false;
            }
        }
        if (z) {
            this.a.add(Pattern.compile(".*" + agentConfiguration.collectorURL + ".*"));
        }
        if (z2) {
            this.a.add(Pattern.compile(".*" + agentConfiguration.screenshotURL + ".*"));
        }
    }
}
