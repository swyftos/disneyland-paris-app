package org.apache.commons.lang3;

import com.amazonaws.services.p017s3.model.InstructionFileId;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class ClassPathUtils {
    public static String packageToPath(String str) {
        Objects.requireNonNull(str, "path");
        return str.replace('.', '/');
    }

    public static String pathToPackage(String str) {
        Objects.requireNonNull(str, "path");
        return str.replace('/', '.');
    }

    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Objects.requireNonNull(cls, "context");
        Objects.requireNonNull(str, "resourceName");
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package r1, String str) {
        Objects.requireNonNull(r1, "context");
        Objects.requireNonNull(str, "resourceName");
        return r1.getName() + InstructionFileId.DOT + str;
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Objects.requireNonNull(cls, "context");
        Objects.requireNonNull(str, "resourceName");
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Package r1, String str) {
        Objects.requireNonNull(r1, "context");
        Objects.requireNonNull(str, "resourceName");
        return packageToPath(r1.getName()) + "/" + str;
    }

    @Deprecated
    public ClassPathUtils() {
    }
}
