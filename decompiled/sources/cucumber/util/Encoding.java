package cucumber.util;

import cucumber.runtime.io.Resource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class Encoding {
    public static final String DEFAULT_ENCODING = "UTF-8";
    private static final Pattern COMMENT_OR_EMPTY_LINE_PATTERN = Pattern.compile("^\\s*#|^\\s*$");
    private static final Pattern ENCODING_PATTERN = Pattern.compile("^\\s*#\\s*encoding\\s*:\\s*([0-9a-zA-Z\\-]+)", 2);

    public static String readFile(Resource resource) throws IOException, RuntimeException {
        String reader = FixJava.readReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
        if (reader.startsWith("\ufeff")) {
            reader = reader.replaceFirst("\ufeff", "");
        }
        String strEncoding = encoding(reader);
        return !strEncoding.equals("UTF-8") ? FixJava.readReader(new InputStreamReader(resource.getInputStream(), strEncoding)) : reader;
    }

    private static String encoding(String str) {
        String strGroup;
        for (String str2 : str.split("\\n")) {
            if (!COMMENT_OR_EMPTY_LINE_PATTERN.matcher(str2).find()) {
                break;
            }
            Matcher matcher = ENCODING_PATTERN.matcher(str2);
            if (matcher.find()) {
                strGroup = matcher.group(1);
                break;
            }
        }
        strGroup = "UTF-8";
        return strGroup.toUpperCase(Locale.ROOT);
    }
}
