package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.AgentConfiguration;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.az */
/* JADX INFO: loaded from: classes2.dex */
public final class C2076az implements InterfaceC2064an {

    /* JADX INFO: renamed from: a */
    private ArrayList<Pattern> f610a;

    /* JADX INFO: renamed from: b */
    private ArrayList<String> f611b = new ArrayList<>(Arrays.asList("http://10.0.2.2:9001", "http://efmockserver:9001"));

    public C2076az(AgentConfiguration agentConfiguration) {
        Set<String> set = agentConfiguration.excludedUrlPatterns;
        this.f610a = new ArrayList<>();
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                this.f610a.add(Pattern.compile(it.next()));
            }
        }
        m581a(agentConfiguration);
    }

    @Override // com.appdynamics.eumagent.runtime.p192private.InterfaceC2064an
    /* JADX INFO: renamed from: a */
    public final boolean mo563a(Object obj) {
        URL url;
        ArrayList<Pattern> arrayList = this.f610a;
        if (arrayList == null || arrayList.isEmpty() || !(obj instanceof C2080bc) || (url = ((C2080bc) obj).f632i) == null) {
            return false;
        }
        String string = url.toString();
        Iterator<Pattern> it = this.f610a.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(string).matches()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m581a(AgentConfiguration agentConfiguration) {
        boolean z = true;
        boolean z2 = true;
        for (String str : this.f611b) {
            if (agentConfiguration.collectorURL.equals(str)) {
                z = false;
            }
            if (agentConfiguration.screenshotURL.equals(str)) {
                z2 = false;
            }
        }
        if (z) {
            this.f610a.add(Pattern.compile(".*" + agentConfiguration.collectorURL + ".*"));
        }
        if (z2) {
            this.f610a.add(Pattern.compile(".*" + agentConfiguration.screenshotURL + ".*"));
        }
    }
}
