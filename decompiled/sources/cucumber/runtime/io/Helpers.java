package cucumber.runtime.io;

import cucumber.runtime.CucumberException;
import java.net.URI;

/* loaded from: classes5.dex */
abstract class Helpers {
    static boolean hasSuffix(String str, String str2) {
        return str == null || str2.endsWith(str);
    }

    static URI jarFilePath(URI uri) {
        String rawSchemeSpecificPart = uri.getRawSchemeSpecificPart();
        int iIndexOf = rawSchemeSpecificPart.indexOf("!/");
        if (iIndexOf == -1) {
            throw new CucumberException("Expected a jar URL: " + uri);
        }
        return URI.create(rawSchemeSpecificPart.substring(0, iIndexOf));
    }
}
