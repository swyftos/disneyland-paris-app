package coil3.svg.internal;

import coil3.content.DecoderServiceLoaderTarget;
import coil3.svg.SvgDecoder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m1836d2 = {"Lcoil3/svg/internal/SvgDecoderServiceLoaderTarget;", "Lcoil3/util/DecoderServiceLoaderTarget;", "<init>", "()V", "factory", "Lcoil3/svg/SvgDecoder$Factory;", "coil-svg_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SvgDecoderServiceLoaderTarget implements DecoderServiceLoaderTarget {
    @Override // coil3.content.DecoderServiceLoaderTarget
    @NotNull
    public SvgDecoder.Factory factory() {
        return new SvgDecoder.Factory(false, false, false, 7, null);
    }
}
