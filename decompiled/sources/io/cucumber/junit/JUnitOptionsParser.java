package io.cucumber.junit;

import cucumber.runtime.CucumberException;
import cucumber.util.FixJava;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
final class JUnitOptionsParser {
    private static String optionsText;

    JUnitOptionsParser() {
    }

    JUnitOptionsBuilder parse(List list) {
        ArrayList arrayList = new ArrayList(list);
        JUnitOptionsBuilder jUnitOptionsBuilder = new JUnitOptionsBuilder();
        while (!arrayList.isEmpty()) {
            String strTrim = ((String) arrayList.remove(0)).trim();
            if (strTrim.equals("--help") || strTrim.equals("-h")) {
                printOptions();
                System.exit(0);
            } else if (strTrim.equals("--no-filename-compatible-names") || strTrim.equals("--filename-compatible-names")) {
                jUnitOptionsBuilder.setFilenameCompatibleNames(!strTrim.startsWith("--no-"));
            } else if (strTrim.equals("--no-step-notifications") || strTrim.equals("--step-notifications")) {
                jUnitOptionsBuilder.setStepNotifications(!strTrim.startsWith("--no-"));
            } else {
                printOptions();
                throw new CucumberException("Unknown option: " + strTrim);
            }
        }
        return jUnitOptionsBuilder;
    }

    JUnitOptionsBuilder parse(Class cls) {
        JUnitOptionsBuilder jUnitOptionsBuilder = new JUnitOptionsBuilder();
        while (cls != Object.class) {
            CucumberOptions cucumberOptions = (CucumberOptions) cls.getAnnotation(CucumberOptions.class);
            if (cucumberOptions != null) {
                if (cucumberOptions.stepNotifications()) {
                    jUnitOptionsBuilder.setStepNotifications(true);
                }
                if (cucumberOptions.useFileNameCompatibleName()) {
                    jUnitOptionsBuilder.setFilenameCompatibleNames(true);
                }
            }
            cls = cls.getSuperclass();
        }
        return jUnitOptionsBuilder;
    }

    private void printOptions() {
        loadUsageTextIfNeeded();
        System.out.println(optionsText);
    }

    private static void loadUsageTextIfNeeded() {
        if (optionsText == null) {
            try {
                optionsText = FixJava.readReader(new InputStreamReader(FixJava.class.getResourceAsStream("/io/cucumber/junit/api/OPTIONS.txt"), "UTF-8"));
            } catch (Exception e) {
                optionsText = "Could not load usage text: " + e.toString();
            }
        }
    }
}
