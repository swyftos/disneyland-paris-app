package io.cucumber.core.model;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes5.dex */
public class FeaturePath {
    public static URI parse(String str) {
        Objects.requireNonNull(str, "featureIdentifier may not be null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("featureIdentifier may not be empty");
        }
        if ("classpath:".equals(str)) {
            return rootPackage();
        }
        if (nonStandardPathSeparatorInUse(str)) {
            return parseAssumeFileScheme(replaceNonStandardPathSeparator(str));
        }
        if (isWindowsOS() && pathContainsWindowsDrivePattern(str)) {
            return parseAssumeFileScheme(str);
        }
        if (probablyURI(str)) {
            return parseProbableURI(str);
        }
        return parseAssumeFileScheme(str);
    }

    private static URI rootPackage() {
        try {
            return new URI(Classpath.CLASSPATH_SCHEME, "/", null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static URI parseProbableURI(String str) {
        return URI.create(str);
    }

    private static boolean isWindowsOS() {
        return normalize(System.getProperty("os.name")).contains("windows");
    }

    private static boolean pathContainsWindowsDrivePattern(String str) {
        return str.matches("^[a-zA-Z]:.*$");
    }

    private static boolean probablyURI(String str) {
        return str.matches("^[a-zA-Z+.\\-]+:.*$");
    }

    private static String replaceNonStandardPathSeparator(String str) {
        return str.replace(File.separatorChar, '/');
    }

    private static boolean nonStandardPathSeparatorInUse(String str) {
        return File.separatorChar != '/' && str.contains(File.separator);
    }

    private static URI parseAssumeFileScheme(String str) {
        File file = new File(str);
        if (file.isAbsolute()) {
            return file.toURI();
        }
        try {
            URI uriRelativize = new File("").toURI().relativize(file.toURI());
            return new URI("file", uriRelativize.getSchemeSpecificPart(), uriRelativize.getFragment());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    private static String normalize(String str) {
        return str == null ? "" : str.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }
}
