package androidx.test.internal.runner.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class RunnerFileIO implements RunnerIO {
    @Override // androidx.test.internal.runner.storage.RunnerIO
    public InputStream openInputStream(String str) throws FileNotFoundException {
        return new FileInputStream(str);
    }

    @Override // androidx.test.internal.runner.storage.RunnerIO
    public OutputStream openOutputStream(String str) throws FileNotFoundException {
        return new FileOutputStream(str);
    }
}
