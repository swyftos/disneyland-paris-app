package gherkin.cli;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.events.CucumberEvent;
import gherkin.events.SourceEvent;
import gherkin.stream.GherkinEvents;
import gherkin.stream.SourceEvents;
import gherkin.stream.Stdio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class Main {
    public static void main(String[] strArr) throws IOException {
        String strTrim;
        Gson gsonCreate = new GsonBuilder().create();
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList2 = new ArrayList();
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        while (!arrayList.isEmpty()) {
            strTrim = ((String) arrayList.remove(0)).trim();
            strTrim.hashCode();
            switch (strTrim) {
                case "--no-pickles":
                    z3 = false;
                    break;
                case "--no-source":
                    z = false;
                    break;
                case "--no-ast":
                    z2 = false;
                    break;
                default:
                    arrayList2.add(strTrim);
                    break;
            }
        }
        SourceEvents sourceEvents = new SourceEvents(arrayList2);
        GherkinEvents gherkinEvents = new GherkinEvents(z, z2, z3);
        Iterator<SourceEvent> it = sourceEvents.iterator();
        while (it.hasNext()) {
            for (CucumberEvent cucumberEvent : gherkinEvents.iterable(it.next())) {
                PrintWriter printWriter = Stdio.out;
                printWriter.write(gsonCreate.toJson(cucumberEvent));
                printWriter.write("\n");
                printWriter.flush();
            }
        }
    }
}
