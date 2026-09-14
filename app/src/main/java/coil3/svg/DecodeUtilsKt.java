package coil3.svg;

import coil3.decode.DecodeUtils;
import coil3.svg.internal.UtilsKt;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m1836d2 = {"SVG_TAG", "Lokio/ByteString;", "LEFT_ANGLE_BRACKET", "isSvg", "", "Lcoil3/decode/DecodeUtils;", "source", "Lokio/BufferedSource;", "coil-svg_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DecodeUtilsKt {
    private static final ByteString LEFT_ANGLE_BRACKET;
    private static final ByteString SVG_TAG;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        SVG_TAG = companion.encodeUtf8("<svg");
        LEFT_ANGLE_BRACKET = companion.encodeUtf8("<");
    }

    public static final boolean isSvg(@NotNull DecodeUtils decodeUtils, @NotNull BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0L, LEFT_ANGLE_BRACKET) && UtilsKt.indexOf(bufferedSource, SVG_TAG, 0L, 1024L) != -1;
    }
}
