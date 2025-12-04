package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.rolling.RolloverFailure;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;

/* loaded from: classes2.dex */
public class FileStoreUtil {
    public static boolean areOnSameFileStore(File file, File file2) throws IllegalAccessException, RolloverFailure, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!file.exists()) {
            throw new IllegalArgumentException("File [" + file + "] does not exist.");
        }
        if (!file2.exists()) {
            throw new IllegalArgumentException("File [" + file2 + "] does not exist.");
        }
        try {
            Class<?> cls = Class.forName("java.nio.file.Files");
            Method method = File.class.getMethod("toPath", new Class[0]);
            Method method2 = cls.getMethod("getFileStore", Path.class);
            return method2.invoke(null, method.invoke(file, new Object[0])).equals(method2.invoke(null, method.invoke(file2, new Object[0])));
        } catch (Exception e) {
            throw new RolloverFailure("Failed to check file store equality for [" + file + "] and [" + file2 + "]", e);
        }
    }
}
