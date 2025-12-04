package androidx.test.internal.runner.storage;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface RunnerIO {
    InputStream openInputStream(String str) throws FileNotFoundException;

    OutputStream openOutputStream(String str) throws FileNotFoundException;
}
