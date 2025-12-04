package cucumber.runtime;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class MethodFormat {
    private final MessageFormat format;
    private static final Pattern METHOD_PATTERN = Pattern.compile("((?:static\\s|public\\s)+)([^\\s]*)\\s\\.?(.*)\\.([^\\(]*)\\(([^\\)]*)\\)(?: throws )?(.*)");
    private static final Pattern PACKAGE_PATTERN = Pattern.compile("[^,]*\\.");
    public static final MethodFormat SHORT = new MethodFormat("%c.%m(%a)");
    public static final MethodFormat FULL = new MethodFormat("%qc.%m(%a) in %s");

    private MethodFormat(String str) {
        this.format = new MessageFormat(str.replaceAll("%M", "{0}").replaceAll("%r", "{1}").replaceAll("%qc", "{2}").replaceAll("%m", "{3}").replaceAll("%qa", "{4}").replaceAll("%qe", "{5}").replaceAll("%c", "{6}").replaceAll("%a", "{7}").replaceAll("%e", "{8}").replaceAll("%s", "{9}"));
    }

    public String format(Method method) {
        String genericString = method.toGenericString();
        Matcher matcher = METHOD_PATTERN.matcher(genericString);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            String strGroup3 = matcher.group(3);
            String strGroup4 = matcher.group(4);
            String strGroup5 = matcher.group(5);
            String strGroup6 = matcher.group(6);
            return this.format.format(new Object[]{strGroup, strGroup2, strGroup3, strGroup4, strGroup5, strGroup6, removePackage(strGroup3), removePackage(strGroup5), removePackage(strGroup6), getCodeSource(method)});
        }
        throw new CucumberException("Cucumber bug: Couldn't format " + genericString);
    }

    private static String removePackage(String str) {
        return PACKAGE_PATTERN.matcher(str).replaceAll("");
    }

    private String getCodeSource(Method method) {
        try {
            return method.getDeclaringClass().getProtectionDomain().getCodeSource().getLocation().toExternalForm();
        } catch (Exception unused) {
            return method.getDeclaringClass().getName();
        }
    }
}
