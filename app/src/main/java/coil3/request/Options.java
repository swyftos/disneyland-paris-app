package coil3.request;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import coil3.Extras;
import coil3.content.FileSystems_nonJsCommonKt;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.Size;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001Bo\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016Ju\u0010*\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010+R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006,"}, m1836d2 = {"Lcoil3/request/Options;", "", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", TCEventPropertiesNames.TCP_SIZE, "Lcoil3/size/Size;", "scale", "Lcoil3/size/Scale;", "precision", "Lcoil3/size/Precision;", "diskCacheKey", "", "fileSystem", "Lokio/FileSystem;", "memoryCachePolicy", "Lcoil3/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "extras", "Lcoil3/Extras;", "<init>", "(Landroid/content/Context;Lcoil3/size/Size;Lcoil3/size/Scale;Lcoil3/size/Precision;Ljava/lang/String;Lokio/FileSystem;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/Extras;)V", "getContext", "()Landroid/content/Context;", "Landroid/content/Context;", "getSize", "()Lcoil3/size/Size;", "getScale", "()Lcoil3/size/Scale;", "getPrecision", "()Lcoil3/size/Precision;", "getDiskCacheKey", "()Ljava/lang/String;", "getFileSystem", "()Lokio/FileSystem;", "getMemoryCachePolicy", "()Lcoil3/request/CachePolicy;", "getDiskCachePolicy", "getNetworkCachePolicy", "getExtras", "()Lcoil3/Extras;", "copy", "(Landroid/content/Context;Lcoil3/size/Size;Lcoil3/size/Scale;Lcoil3/size/Precision;Ljava/lang/String;Lokio/FileSystem;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/request/CachePolicy;Lcoil3/Extras;)Lcoil3/request/Options;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class Options {
    private final Context context;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Extras extras;
    private final FileSystem fileSystem;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Precision precision;
    private final Scale scale;
    private final Size size;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Options)) {
            return false;
        }
        Options options = (Options) obj;
        return Intrinsics.areEqual(this.context, options.context) && Intrinsics.areEqual(this.size, options.size) && this.scale == options.scale && this.precision == options.precision && Intrinsics.areEqual(this.diskCacheKey, options.diskCacheKey) && Intrinsics.areEqual(this.fileSystem, options.fileSystem) && this.memoryCachePolicy == options.memoryCachePolicy && this.diskCachePolicy == options.diskCachePolicy && this.networkCachePolicy == options.networkCachePolicy && Intrinsics.areEqual(this.extras, options.extras);
    }

    public int hashCode() {
        int iHashCode = ((((((this.context.hashCode() * 31) + this.size.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.precision.hashCode()) * 31;
        String str = this.diskCacheKey;
        return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.fileSystem.hashCode()) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.extras.hashCode();
    }

    @NotNull
    public String toString() {
        return "Options(context=" + this.context + ", size=" + this.size + ", scale=" + this.scale + ", precision=" + this.precision + ", diskCacheKey=" + this.diskCacheKey + ", fileSystem=" + this.fileSystem + ", memoryCachePolicy=" + this.memoryCachePolicy + ", diskCachePolicy=" + this.diskCachePolicy + ", networkCachePolicy=" + this.networkCachePolicy + ", extras=" + this.extras + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Options(@NotNull Context context, @NotNull Size size, @NotNull Scale scale, @NotNull Precision precision, @Nullable String str, @NotNull FileSystem fileSystem, @NotNull CachePolicy cachePolicy, @NotNull CachePolicy cachePolicy2, @NotNull CachePolicy cachePolicy3, @NotNull Extras extras) {
        this.context = context;
        this.size = size;
        this.scale = scale;
        this.precision = precision;
        this.diskCacheKey = str;
        this.fileSystem = fileSystem;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.extras = extras;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public /* synthetic */ Options(Context context, Size size, Scale scale, Precision precision, String str, FileSystem fileSystem, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Extras extras, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? Size.ORIGINAL : size, (i & 4) != 0 ? Scale.FIT : scale, (i & 8) != 0 ? Precision.EXACT : precision, (i & 16) != 0 ? null : str, (i & 32) != 0 ? FileSystems_nonJsCommonKt.defaultFileSystem() : fileSystem, (i & 64) != 0 ? CachePolicy.ENABLED : cachePolicy, (i & 128) != 0 ? CachePolicy.ENABLED : cachePolicy2, (i & 256) != 0 ? CachePolicy.ENABLED : cachePolicy3, (i & 512) != 0 ? Extras.EMPTY : extras);
    }

    @NotNull
    public final Size getSize() {
        return this.size;
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    @NotNull
    public final Precision getPrecision() {
        return this.precision;
    }

    @Nullable
    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    @NotNull
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @NotNull
    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    @NotNull
    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    @NotNull
    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    @NotNull
    public final Extras getExtras() {
        return this.extras;
    }

    @NotNull
    public final Options copy(@NotNull Context context, @NotNull Size size, @NotNull Scale scale, @NotNull Precision precision, @Nullable String diskCacheKey, @NotNull FileSystem fileSystem, @NotNull CachePolicy memoryCachePolicy, @NotNull CachePolicy diskCachePolicy, @NotNull CachePolicy networkCachePolicy, @NotNull Extras extras) {
        return new Options(context, size, scale, precision, diskCacheKey, fileSystem, memoryCachePolicy, diskCachePolicy, networkCachePolicy, extras);
    }
}
