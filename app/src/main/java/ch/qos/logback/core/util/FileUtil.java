package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.rolling.RolloverFailure;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil extends ContextAwareBase {
    public FileUtil(Context context) {
        setContext(context);
    }

    public static boolean createMissingParentDirectories(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return true;
        }
        parentFile.mkdirs();
        return parentFile.exists();
    }

    public static URL fileToURL(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unexpected exception on file [" + file + "]", e);
        }
    }

    public static String prefixRelativePath(String str, String str2) {
        if (str == null || OptionHelper.isEmpty(str.trim()) || new File(str2).isAbsolute()) {
            return str2;
        }
        return str + "/" + str2;
    }

    public void copy(String str, String str2) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        IOException e;
        BufferedInputStream bufferedInputStream;
        IOException iOException;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    try {
                        byte[] bArr = new byte[32768];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i != -1) {
                                bufferedOutputStream.write(bArr, 0, i);
                            } else {
                                bufferedInputStream.close();
                                try {
                                    bufferedOutputStream.close();
                                    return;
                                } catch (IOException e2) {
                                    iOException = e2;
                                    bufferedInputStream = null;
                                    e = iOException;
                                    String str3 = "Failed to copy [" + str + "] to [" + str2 + "]";
                                    addError(str3, e);
                                    throw new RolloverFailure(str3);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            }
                            th = th;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (bufferedOutputStream == null) {
                                throw th;
                            }
                            try {
                                bufferedOutputStream.close();
                                throw th;
                            } catch (IOException unused2) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                    }
                } catch (IOException e3) {
                    e = e3;
                    String str4 = "Failed to copy [" + str + "] to [" + str2 + "]";
                    addError(str4, e);
                    throw new RolloverFailure(str4);
                }
            } catch (IOException e4) {
                iOException = e4;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (IOException e5) {
            bufferedOutputStream = null;
            e = e5;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }
}
