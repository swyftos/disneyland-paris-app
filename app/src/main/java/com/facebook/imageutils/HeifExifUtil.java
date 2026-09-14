package com.facebook.imageutils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1836d2 = {"Lcom/facebook/imageutils/HeifExifUtil;", "", "<init>", "()V", "Ljava/io/InputStream;", "inputStream", "", "getOrientation", "(Ljava/io/InputStream;)I", "imagepipeline-base_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class HeifExifUtil {

    @NotNull
    public static final HeifExifUtil INSTANCE = new HeifExifUtil();

    private HeifExifUtil() {
    }

    @JvmStatic
    public static final int getOrientation(@Nullable InputStream inputStream) {
        if (inputStream == null) {
            FLog.m1279d("HeifExifUtil", "Trying to read Heif Exif from null inputStream -> ignoring");
            return 0;
        }
        try {
            return new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e) {
            FLog.m1284d("HeifExifUtil", "Failed reading Heif Exif orientation -> ignoring", (Throwable) e);
            return 0;
        }
    }
}
