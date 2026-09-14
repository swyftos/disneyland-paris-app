package coil3.disk;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import coil3.content.Coroutines_nonJsCommonKt;
import coil3.content.FileSystems_androidKt;
import coil3.content.FileSystems_nonJsCommonKt;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.reactnative.ReactMessageView;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/disk/DiskCache;", "", TCEventPropertiesNames.TCP_SIZE, "", "getSize", "()J", "maxSize", "getMaxSize", "directory", "Lokio/Path;", "getDirectory", "()Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "openSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "key", "", "openEditor", "Lcoil3/disk/DiskCache$Editor;", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "", "clear", "", "shutdown", "Snapshot", "Editor", "Builder", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface DiskCache {

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/disk/DiskCache$Editor;", "", "metadata", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "commit", "", "commitAndOpenSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "abort", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public interface Editor {
        void abort();

        void commit();

        @Nullable
        Snapshot commitAndOpenSnapshot();

        @NotNull
        Path getData();

        @NotNull
        Path getMetadata();
    }

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/disk/DiskCache$Snapshot;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "metadata", "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", ReactMessageView.EVENT_CLOSE, "", "closeAndOpenEditor", "Lcoil3/disk/DiskCache$Editor;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public interface Snapshot extends AutoCloseable {
        @Override // java.lang.AutoCloseable
        void close();

        @Nullable
        Editor closeAndOpenEditor();

        @NotNull
        Path getData();

        @NotNull
        Path getMetadata();
    }

    void clear();

    @NotNull
    Path getDirectory();

    @NotNull
    FileSystem getFileSystem();

    long getMaxSize();

    long getSize();

    @Nullable
    Editor openEditor(@NotNull String key);

    @Nullable
    Snapshot openSnapshot(@NotNull String key);

    boolean remove(@NotNull String key);

    void shutdown();

    @Metadata(m1835d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1836d2 = {"Lcoil3/disk/DiskCache$Builder;", "", "<init>", "()V", "directory", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "maxSizePercent", "", "minimumMaxSizeBytes", "", "maximumMaxSizeBytes", "maxSizeBytes", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "percent", TCEventPropertiesNames.TCP_SIZE, "dispatcher", "build", "Lcoil3/disk/DiskCache;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nDiskCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskCache.kt\ncoil3/disk/DiskCache$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,204:1\n1#2:205\n*E\n"})
    public static final class Builder {
        private Path directory;
        private long maxSizeBytes;
        private FileSystem fileSystem = FileSystems_nonJsCommonKt.defaultFileSystem();
        private double maxSizePercent = 0.02d;
        private long minimumMaxSizeBytes = SizeBasedTriggeringPolicy.DEFAULT_MAX_FILE_SIZE;
        private long maximumMaxSizeBytes = 262144000;
        private CoroutineDispatcher cleanupDispatcher = Coroutines_nonJsCommonKt.ioCoroutineDispatcher();

        @NotNull
        public final Builder directory(@NotNull Path directory) {
            this.directory = directory;
            return this;
        }

        @NotNull
        public final Builder fileSystem(@NotNull FileSystem fileSystem) {
            this.fileSystem = fileSystem;
            return this;
        }

        @NotNull
        public final Builder maxSizePercent(double percent) {
            if (AudioStats.AUDIO_AMPLITUDE_NONE > percent || percent > 1.0d) {
                throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].");
            }
            this.maxSizeBytes = 0L;
            this.maxSizePercent = percent;
            return this;
        }

        @NotNull
        public final Builder minimumMaxSizeBytes(long size) {
            if (size <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.minimumMaxSizeBytes = size;
            return this;
        }

        @NotNull
        public final Builder maximumMaxSizeBytes(long size) {
            if (size <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.maximumMaxSizeBytes = size;
            return this;
        }

        @NotNull
        public final Builder maxSizeBytes(long size) {
            if (size <= 0) {
                throw new IllegalArgumentException("size must be > 0.");
            }
            this.maxSizePercent = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.maxSizeBytes = size;
            return this;
        }

        @NotNull
        public final Builder cleanupDispatcher(@NotNull CoroutineDispatcher dispatcher) {
            this.cleanupDispatcher = dispatcher;
            return this;
        }

        @NotNull
        public final DiskCache build() {
            long jCoerceIn;
            Path path = this.directory;
            if (path == null) {
                throw new IllegalStateException("directory == null");
            }
            double d = this.maxSizePercent;
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                try {
                    jCoerceIn = RangesKt.coerceIn((long) (d * FileSystems_androidKt.remainingFreeSpaceBytes(this.fileSystem, path)), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);
                } catch (Exception unused) {
                    jCoerceIn = this.minimumMaxSizeBytes;
                }
            } else {
                jCoerceIn = this.maxSizeBytes;
            }
            return new RealDiskCache(jCoerceIn, path, this.fileSystem, this.cleanupDispatcher);
        }
    }
}
