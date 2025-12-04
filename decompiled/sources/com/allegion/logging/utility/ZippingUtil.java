package com.allegion.logging.utility;

import com.allegion.logging.AlLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/allegion/logging/utility/ZippingUtil;", "", "()V", "addFileToZip", "", "zos", "Ljava/util/zip/ZipOutputStream;", "file", "Ljava/io/File;", "getZippedFile", "inputFolderPath", "", "zipOutputPath", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ZippingUtil {
    public static final ZippingUtil INSTANCE = new ZippingUtil();

    private ZippingUtil() {
    }

    @NotNull
    public final File getZippedFile(@NotNull String inputFolderPath, @NotNull String zipOutputPath) {
        Intrinsics.checkParameterIsNotNull(inputFolderPath, "inputFolderPath");
        Intrinsics.checkParameterIsNotNull(zipOutputPath, "zipOutputPath");
        Objects.requireNonNull(inputFolderPath);
        Objects.requireNonNull(zipOutputPath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipOutputPath);
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                try {
                    for (File file : new File(inputFolderPath).listFiles()) {
                        ZippingUtil zippingUtil = INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(file, "file");
                        zippingUtil.addFileToZip(zipOutputStream, file);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(zipOutputStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            AlLog.e(e);
        }
        return new File(zipOutputPath);
    }

    private final void addFileToZip(ZipOutputStream zos, File file) {
        AlLog.i("Adding file %s to zip.", file.getName());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                zos.putNextEntry(new ZipEntry(file.getName()));
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int i = fileInputStream.read(bArr);
                    intRef.element = i;
                    if (i > 0) {
                        zos.write(bArr, 0, i);
                    } else {
                        zos.closeEntry();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, null);
                        return;
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            AlLog.e(e);
        }
    }
}
