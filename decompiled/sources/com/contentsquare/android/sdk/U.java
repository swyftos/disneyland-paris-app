package com.contentsquare.android.sdk;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class U {

    @NotNull
    public final V a;

    public U(@NotNull V batchWriterReader) {
        Intrinsics.checkNotNullParameter(batchWriterReader, "batchWriterReader");
        this.a = batchWriterReader;
    }

    public final void a(long j) {
        V v = this.a;
        String str = v.e + File.separator + j;
        v.c.d("deleting file on path: " + str);
        if (v.a.deleteFileOrFolder(str)) {
            return;
        }
        v.c.e("failed to delete file for, file " + j + " in path " + str);
    }

    public final void a(@NotNull Q batchToStore) {
        Intrinsics.checkNotNullParameter(batchToStore, "batchToStore");
        T6 storedBatch = new T6(batchToStore.b, batchToStore.a);
        V v = this.a;
        v.getClass();
        Intrinsics.checkNotNullParameter(storedBatch, "storedBatch");
        String str = v.e + File.separator + ((v.d.incrementAndGet() % 524288) + (System.currentTimeMillis() << 19));
        v.c.d("Storing file to path: " + str);
        v.a.mkdirs(v.e);
        v.a.writeBytesToFile(str, storedBatch.a(), true);
        V v2 = this.a;
        long physicalSize = v2.a.getPhysicalSize(v2.e);
        v2.c.d("current size of path " + v2.e + " is " + physicalSize + " bytes");
        if (v2.b < physicalSize) {
            v2.c.d("space used on path " + v2.e + " has reached " + physicalSize + " bytes. it will be deleted");
            v2.a.deleteRecursive(new File(v2.e));
        }
    }
}
