package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.RotationOptions;
import com.urbanairship.actions.ToastAction;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1836d2 = {"Lcom/facebook/imageutils/TiffUtil;", "", "<init>", "()V", "TAG", "Ljava/lang/Class;", "TIFF_BYTE_ORDER_BIG_END", "", "TIFF_BYTE_ORDER_LITTLE_END", "TIFF_TAG_ORIENTATION", "TIFF_TYPE_SHORT", "getAutoRotateAngleFromOrientation", "orientation", "readOrientationFromTIFF", "stream", "Ljava/io/InputStream;", ToastAction.LENGTH_KEY, "readTiffHeader", "tiffHeader", "Lcom/facebook/imageutils/TiffUtil$TiffHeader;", "moveToTiffEntryWithTag", "isLittleEndian", "", "tagToFind", "getOrientationFromTiffEntry", "TiffHeader", "imagepipeline-base_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class TiffUtil {

    @NotNull
    public static final TiffUtil INSTANCE = new TiffUtil();
    private static final Class TAG = TiffUtil.class;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    @JvmStatic
    public static final int getAutoRotateAngleFromOrientation(int orientation) {
        if (orientation == 0 || orientation == 1) {
            return 0;
        }
        if (orientation == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (orientation != 6) {
            return orientation != 8 ? 0 : 270;
        }
        return 90;
    }

    private TiffUtil() {
    }

    @JvmStatic
    public static final int readOrientationFromTIFF(@NotNull InputStream stream, int length) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        TiffHeader tiffHeader = new TiffHeader();
        TiffUtil tiffUtil = INSTANCE;
        int tiffHeader2 = tiffUtil.readTiffHeader(stream, length, tiffHeader);
        int firstIfdOffset = tiffHeader.getFirstIfdOffset() - 8;
        if (tiffHeader2 == 0 || firstIfdOffset > tiffHeader2) {
            return 0;
        }
        stream.skip(firstIfdOffset);
        return tiffUtil.getOrientationFromTiffEntry(stream, tiffUtil.moveToTiffEntryWithTag(stream, tiffHeader2 - firstIfdOffset, tiffHeader.isLittleEndian(), TIFF_TAG_ORIENTATION), tiffHeader.isLittleEndian());
    }

    private final int readTiffHeader(InputStream stream, int length, TiffHeader tiffHeader) {
        if (length <= 8) {
            return 0;
        }
        tiffHeader.setByteOrder(StreamProcessor.readPackedInt(stream, 4, false));
        if (tiffHeader.getByteOrder() != 1229531648 && tiffHeader.getByteOrder() != 1296891946) {
            FLog.m1287e((Class<?>) TAG, "Invalid TIFF header");
            return 0;
        }
        tiffHeader.setLittleEndian(tiffHeader.getByteOrder() == 1229531648);
        tiffHeader.setFirstIfdOffset(StreamProcessor.readPackedInt(stream, 4, tiffHeader.isLittleEndian()));
        int i = length - 8;
        if (tiffHeader.getFirstIfdOffset() >= 8 && tiffHeader.getFirstIfdOffset() - 8 <= i) {
            return i;
        }
        FLog.m1287e((Class<?>) TAG, "Invalid offset");
        return 0;
    }

    private final int moveToTiffEntryWithTag(InputStream stream, int length, boolean isLittleEndian, int tagToFind) throws IOException {
        if (length < 14) {
            return 0;
        }
        int packedInt = StreamProcessor.readPackedInt(stream, 2, isLittleEndian);
        int i = length - 2;
        while (true) {
            int i2 = packedInt - 1;
            if (packedInt <= 0 || i < 12) {
                break;
            }
            int i3 = i - 2;
            if (StreamProcessor.readPackedInt(stream, 2, isLittleEndian) == tagToFind) {
                return i3;
            }
            stream.skip(10L);
            i -= 12;
            packedInt = i2;
        }
        return 0;
    }

    private final int getOrientationFromTiffEntry(InputStream stream, int length, boolean isLittleEndian) {
        if (length >= 10 && StreamProcessor.readPackedInt(stream, 2, isLittleEndian) == 3 && StreamProcessor.readPackedInt(stream, 4, isLittleEndian) == 1) {
            return StreamProcessor.readPackedInt(stream, 2, isLittleEndian);
        }
        return 0;
    }

    private static final class TiffHeader {
        private int byteOrder;
        private int firstIfdOffset;
        private boolean isLittleEndian;

        public final boolean isLittleEndian() {
            return this.isLittleEndian;
        }

        public final void setLittleEndian(boolean z) {
            this.isLittleEndian = z;
        }

        public final int getByteOrder() {
            return this.byteOrder;
        }

        public final void setByteOrder(int i) {
            this.byteOrder = i;
        }

        public final int getFirstIfdOffset() {
            return this.firstIfdOffset;
        }

        public final void setFirstIfdOffset(int i) {
            this.firstIfdOffset = i;
        }
    }
}
