package expo.modules.kotlin.devtools.cdp;

import androidx.media3.common.MimeTypes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/ResourceType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGE", "MEDIA", "FONT", "SCRIPT", "FETCH", "OTHER", "Companion", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum ResourceType {
    IMAGE("Image"),
    MEDIA("Media"),
    FONT("Font"),
    SCRIPT("Script"),
    FETCH("Fetch"),
    OTHER("Other");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<ResourceType> getEntries() {
        return $ENTRIES;
    }

    ResourceType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/ResourceType$Companion;", "", "<init>", "()V", "fromMimeType", "Lexpo/modules/kotlin/devtools/cdp/ResourceType;", "mimeType", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ResourceType fromMimeType(@NotNull String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            if (StringsKt.startsWith$default(mimeType, "image/", false, 2, (Object) null)) {
                return ResourceType.IMAGE;
            }
            if (StringsKt.startsWith$default(mimeType, MimeTypes.BASE_TYPE_AUDIO, false, 2, (Object) null) || StringsKt.startsWith$default(mimeType, MimeTypes.BASE_TYPE_VIDEO, false, 2, (Object) null)) {
                return ResourceType.MEDIA;
            }
            return StringsKt.startsWith$default(mimeType, "font", false, 2, (Object) null) ? ResourceType.FONT : ResourceType.OTHER;
        }
    }
}
