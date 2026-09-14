package coil3.content;

import coil3.annotation.InternalCoilApi;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, m1836d2 = {"Lcoil3/util/MimeTypeMap;", "", "<init>", "()V", "getMimeTypeFromUrl", "", "url", "getMimeTypeFromExtension", "extension", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@InternalCoilApi
public final class MimeTypeMap {

    @NotNull
    public static final MimeTypeMap INSTANCE = new MimeTypeMap();

    private MimeTypeMap() {
    }

    @Nullable
    public final String getMimeTypeFromUrl(@NotNull String url) {
        if (StringsKt.isBlank(url)) {
            return null;
        }
        return getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(url, '#', (String) null, 2, (Object) null), '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null), '.', ""));
    }

    @Nullable
    public final String getMimeTypeFromExtension(@NotNull String extension) {
        if (StringsKt.isBlank(extension)) {
            return null;
        }
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = (String) MimeTypesKt.mimeTypeData.get(lowerCase);
        return str == null ? MimeTypes_androidKt.extensionFromMimeTypeMap(lowerCase) : str;
    }
}
