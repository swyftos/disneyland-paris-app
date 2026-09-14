package coil3.svg;

import coil3.Extras;
import coil3.ExtrasKt;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0000\u001a\u0004\u0018\u00010\u0002\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\"\u001d\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\n\"\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1836d2 = {"css", "Lcoil3/request/ImageRequest$Builder;", "", "Lcoil3/request/ImageRequest;", "getCss", "(Lcoil3/request/ImageRequest;)Ljava/lang/String;", "Lcoil3/request/Options;", "(Lcoil3/request/Options;)Ljava/lang/String;", "Lcoil3/Extras$Key;", "Lcoil3/Extras$Key$Companion;", "(Lcoil3/Extras$Key$Companion;)Lcoil3/Extras$Key;", "cssKey", "coil-svg_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ImageRequests_androidKt {
    private static final Extras.Key cssKey = new Extras.Key(null);

    @NotNull
    public static final ImageRequest.Builder css(@NotNull ImageRequest.Builder builder, @Nullable String str) {
        builder.memoryCacheKeyExtra("coil#css", str);
        builder.getExtras().set(cssKey, str);
        return builder;
    }

    @Nullable
    public static final String getCss(@NotNull ImageRequest imageRequest) {
        return (String) ExtrasKt.getExtra(imageRequest, cssKey);
    }

    @Nullable
    public static final String getCss(@NotNull Options options) {
        return (String) ExtrasKt.getExtra(options, cssKey);
    }

    @NotNull
    public static final Extras.Key<String> getCss(@NotNull Extras.Key.Companion companion) {
        return cssKey;
    }
}
