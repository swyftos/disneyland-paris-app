package com.contentsquare.android.sdk;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.U */
/* JADX INFO: loaded from: classes2.dex */
public final class C2635U {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2645V f2166a;

    public C2635U(@NotNull C2645V batchWriterReader) {
        Intrinsics.checkNotNullParameter(batchWriterReader, "batchWriterReader");
        this.f2166a = batchWriterReader;
    }

    /* JADX INFO: renamed from: a */
    public final void m1039a(long j) {
        C2645V c2645v = this.f2166a;
        String str = c2645v.f2189e + File.separator + j;
        c2645v.f2187c.m827d("deleting file on path: " + str);
        if (c2645v.f2185a.deleteFileOrFolder(str)) {
            return;
        }
        c2645v.f2187c.m829e("failed to delete file for, file " + j + " in path " + str);
    }

    /* JADX INFO: renamed from: a */
    public final void m1040a(@NotNull C2596Q batchToStore) {
        Intrinsics.checkNotNullParameter(batchToStore, "batchToStore");
        C2632T6 storedBatch = new C2632T6(batchToStore.f1984b, batchToStore.f1983a);
        C2645V c2645v = this.f2166a;
        c2645v.getClass();
        Intrinsics.checkNotNullParameter(storedBatch, "storedBatch");
        String str = c2645v.f2189e + File.separator + ((((long) c2645v.f2188d.incrementAndGet()) % ((long) 524288)) + (System.currentTimeMillis() << 19));
        c2645v.f2187c.m827d("Storing file to path: " + str);
        c2645v.f2185a.mkdirs(c2645v.f2189e);
        c2645v.f2185a.writeBytesToFile(str, storedBatch.m1035a(), true);
        C2645V c2645v2 = this.f2166a;
        long physicalSize = c2645v2.f2185a.getPhysicalSize(c2645v2.f2189e);
        c2645v2.f2187c.m827d("current size of path " + c2645v2.f2189e + " is " + physicalSize + " bytes");
        if (c2645v2.f2186b < physicalSize) {
            c2645v2.f2187c.m827d("space used on path " + c2645v2.f2189e + " has reached " + physicalSize + " bytes. it will be deleted");
            c2645v2.f2185a.deleteRecursive(new File(c2645v2.f2189e));
        }
    }
}
