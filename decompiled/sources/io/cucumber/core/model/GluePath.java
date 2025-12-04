package io.cucumber.core.model;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/* loaded from: classes5.dex */
public class GluePath {
    public static URI parse(String str) {
        Objects.requireNonNull(str, "gluePath may not be null");
        if (str.isEmpty()) {
            return rootPackage();
        }
        if ("classpath:".equals(str)) {
            return rootPackage();
        }
        if (nonStandardPathSeparatorInUse(str)) {
            return parseAssumeClasspathScheme(replaceNonStandardPathSeparator(str));
        }
        if (isProbablyPackage(str)) {
            return parseAssumeClasspathScheme(replacePackageSeparator(str));
        }
        return parseAssumeClasspathScheme(str);
    }

    private static URI rootPackage() {
        try {
            return new URI(Classpath.CLASSPATH_SCHEME, "/", null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static boolean isProbablyPackage(String str) {
        return str.contains(InstructionFileId.DOT) && !str.contains("/");
    }

    private static String replacePackageSeparator(String str) {
        return str.replace('.', '/');
    }

    private static String replaceNonStandardPathSeparator(String str) {
        return str.replace(File.separatorChar, '/');
    }

    private static boolean nonStandardPathSeparatorInUse(String str) {
        return File.separatorChar != '/' && str.contains(File.separator);
    }

    private static URI parseAssumeClasspathScheme(String str) {
        URI uriCreate = URI.create(str);
        if (!isValidIdentifier(uriCreate.getSchemeSpecificPart())) {
            throw new IllegalArgumentException("The glue path contained invalid identifiers " + uriCreate);
        }
        if (uriCreate.getScheme() == null) {
            try {
                return new URI(Classpath.CLASSPATH_SCHEME, uriCreate.getSchemeSpecificPart(), uriCreate.getFragment());
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }
        if (Classpath.CLASSPATH_SCHEME.equals(uriCreate.getScheme())) {
            return uriCreate;
        }
        throw new IllegalArgumentException("The glue path must have a classpath scheme " + uriCreate);
    }

    private static boolean isValidIdentifier(String str) {
        for (String str2 : str.split("/")) {
            for (int i = 0; i < str2.length(); i++) {
                if ((i == 0 && !Character.isJavaIdentifierStart(str2.charAt(i))) || (i != 0 && !Character.isJavaIdentifierPart(str2.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
