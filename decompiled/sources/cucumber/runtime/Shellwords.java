package cucumber.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class Shellwords {
    private static final Pattern SHELLWORDS_PATTERN = Pattern.compile("[^\\s'\"]+|[']([^']*)[']|[\"]([^\"]*)[\"]");

    public static List<String> parse(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = SHELLWORDS_PATTERN.matcher(str);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                arrayList.add(matcher.group(1));
            } else {
                String strGroup = matcher.group();
                if (strGroup.startsWith("\"") && strGroup.endsWith("\"") && strGroup.length() > 2) {
                    strGroup = strGroup.substring(1, strGroup.length() - 1);
                }
                arrayList.add(strGroup);
            }
        }
        return arrayList;
    }
}
