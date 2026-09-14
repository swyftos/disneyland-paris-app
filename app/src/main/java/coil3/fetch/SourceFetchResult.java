package coil3.fetch;

import ch.qos.logback.core.CoreConstants;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1836d2 = {"Lcoil3/fetch/SourceFetchResult;", "Lcoil3/fetch/FetchResult;", "source", "Lcoil3/decode/ImageSource;", "mimeType", "", "dataSource", "Lcoil3/decode/DataSource;", "<init>", "(Lcoil3/decode/ImageSource;Ljava/lang/String;Lcoil3/decode/DataSource;)V", "getSource", "()Lcoil3/decode/ImageSource;", "getMimeType", "()Ljava/lang/String;", "getDataSource", "()Lcoil3/decode/DataSource;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SourceFetchResult implements FetchResult {
    private final DataSource dataSource;
    private final String mimeType;
    private final ImageSource source;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceFetchResult)) {
            return false;
        }
        SourceFetchResult sourceFetchResult = (SourceFetchResult) obj;
        return Intrinsics.areEqual(this.source, sourceFetchResult.source) && Intrinsics.areEqual(this.mimeType, sourceFetchResult.mimeType) && this.dataSource == sourceFetchResult.dataSource;
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.dataSource.hashCode();
    }

    @NotNull
    public String toString() {
        return "SourceFetchResult(source=" + this.source + ", mimeType=" + this.mimeType + ", dataSource=" + this.dataSource + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SourceFetchResult(@NotNull ImageSource imageSource, @Nullable String str, @NotNull DataSource dataSource) {
        this.source = imageSource;
        this.mimeType = str;
        this.dataSource = dataSource;
    }

    @NotNull
    public final ImageSource getSource() {
        return this.source;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @NotNull
    public final DataSource getDataSource() {
        return this.dataSource;
    }
}
