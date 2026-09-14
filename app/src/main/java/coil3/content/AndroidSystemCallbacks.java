package coil3.content;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import androidx.media3.common.MimeTypes;
import coil3.RealImageLoader;
import coil3.memory.MemoryCache;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\tR/\u0010\u0004\u001a\u0014\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00030\u00030\u0014j\u0002`\u00168\u0006¢\u0006\u0012\n\u0004\b\u0004\u0010\u0017\u0012\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010\n\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b\n\u0010\u001f\u0012\u0004\b$\u0010\t\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, m1836d2 = {"Lcoil3/util/AndroidSystemCallbacks;", "Lcoil3/util/SystemCallbacks;", "Landroid/content/ComponentCallbacks2;", "Lcoil3/RealImageLoader;", "imageLoader", "<init>", "(Lcoil3/RealImageLoader;)V", "", "registerMemoryPressureCallbacks", "()V", "shutdown", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "", "level", "onTrimMemory", "(I)V", "onLowMemory", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Lcoil3/util/WeakReference;", "Ljava/lang/ref/WeakReference;", "getImageLoader", "()Ljava/lang/ref/WeakReference;", "getImageLoader$annotations", "Landroid/content/Context;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "", "Z", "getShutdown", "()Z", "setShutdown", "(Z)V", "getShutdown$annotations", "Companion", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSystemCallbacks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemCallbacks.kt\ncoil3/util/AndroidSystemCallbacks\n+ 2 logging.kt\ncoil3/util/LoggingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n70#1,2:78\n70#1,2:80\n70#1:82\n71#1:88\n68#2,4:83\n1#3:87\n*S KotlinDebug\n*F\n+ 1 SystemCallbacks.kt\ncoil3/util/AndroidSystemCallbacks\n*L\n32#1:78,2\n50#1:80,2\n53#1:82\n53#1:88\n54#1:83,4\n*E\n"})
public final class AndroidSystemCallbacks implements SystemCallbacks, ComponentCallbacks2 {
    private static final Companion Companion = new Companion(null);
    private Context application;
    private final WeakReference imageLoader;
    private boolean shutdown;

    public static /* synthetic */ void getImageLoader$annotations() {
    }

    public static /* synthetic */ void getShutdown$annotations() {
    }

    public AndroidSystemCallbacks(@NotNull RealImageLoader realImageLoader) {
        this.imageLoader = new WeakReference(realImageLoader);
    }

    @NotNull
    public final WeakReference<RealImageLoader> getImageLoader() {
        return this.imageLoader;
    }

    public final boolean getShutdown() {
        return this.shutdown;
    }

    public final void setShutdown(boolean z) {
        this.shutdown = z;
    }

    @Override // coil3.content.SystemCallbacks
    public synchronized void shutdown() {
        try {
            if (this.shutdown) {
                return;
            }
            this.shutdown = true;
            Context context = this.application;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            this.imageLoader.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onConfigurationChanged(@NotNull Configuration newConfig) {
        if (((RealImageLoader) this.imageLoader.get()) == null) {
            shutdown();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public synchronized void onTrimMemory(int level) {
        MemoryCache memoryCache;
        try {
            RealImageLoader realImageLoader = (RealImageLoader) this.imageLoader.get();
            if (realImageLoader != null) {
                Logger logger = realImageLoader.getOptions().getLogger();
                if (logger != null) {
                    Logger.Level level2 = Logger.Level.Verbose;
                    if (logger.getMinLevel().compareTo(level2) <= 0) {
                        logger.log("AndroidSystemCallbacks", level2, "trimMemory, level=" + level, null);
                    }
                }
                if (level >= 40) {
                    MemoryCache memoryCache2 = realImageLoader.getMemoryCache();
                    if (memoryCache2 != null) {
                        memoryCache2.clear();
                    }
                } else if (level >= 10 && (memoryCache = realImageLoader.getMemoryCache()) != null) {
                    memoryCache.trimToSize(memoryCache.getSize() / ((long) 2));
                }
            } else {
                shutdown();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil3.content.SystemCallbacks
    public synchronized void registerMemoryPressureCallbacks() {
        try {
            RealImageLoader realImageLoader = (RealImageLoader) this.imageLoader.get();
            if (realImageLoader != null) {
                if (this.application == null) {
                    Context application = realImageLoader.getOptions().getApplication();
                    this.application = application;
                    application.registerComponentCallbacks(this);
                }
            } else {
                shutdown();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
