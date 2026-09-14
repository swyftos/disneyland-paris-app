package expo.modules.adapters.react.apploader;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, m1836d2 = {"Lexpo/modules/adapters/react/apploader/HeadlessAppLoaderNotifier;", "", "<init>", "()V", "listeners", "", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/adapters/react/apploader/HeadlessAppLoaderListener;", "getListeners", "()Ljava/util/Set;", "registerListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "notifyAppLoaded", "appScopeKey", "", "notifyAppDestroyed", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nHeadlessAppLoaderNotifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeadlessAppLoaderNotifier.kt\nexpo/modules/adapters/react/apploader/HeadlessAppLoaderNotifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,32:1\n1863#2,2:33\n1863#2,2:35\n*S KotlinDebug\n*F\n+ 1 HeadlessAppLoaderNotifier.kt\nexpo/modules/adapters/react/apploader/HeadlessAppLoaderNotifier\n*L\n22#1:33,2\n28#1:35,2\n*E\n"})
public final class HeadlessAppLoaderNotifier {

    @NotNull
    public static final HeadlessAppLoaderNotifier INSTANCE = new HeadlessAppLoaderNotifier();
    private static final Set listeners = new LinkedHashSet();

    private HeadlessAppLoaderNotifier() {
    }

    @NotNull
    public final Set<WeakReference<HeadlessAppLoaderListener>> getListeners() {
        return listeners;
    }

    public final void registerListener(@NotNull HeadlessAppLoaderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(new WeakReference(listener));
    }

    public final void notifyAppLoaded(@Nullable String appScopeKey) {
        if (appScopeKey != null) {
            Iterator it = listeners.iterator();
            while (it.hasNext()) {
                HeadlessAppLoaderListener headlessAppLoaderListener = (HeadlessAppLoaderListener) ((WeakReference) it.next()).get();
                if (headlessAppLoaderListener != null) {
                    headlessAppLoaderListener.appLoaded(appScopeKey);
                }
            }
        }
    }

    public final void notifyAppDestroyed(@Nullable String appScopeKey) {
        if (appScopeKey != null) {
            Iterator it = listeners.iterator();
            while (it.hasNext()) {
                HeadlessAppLoaderListener headlessAppLoaderListener = (HeadlessAppLoaderListener) ((WeakReference) it.next()).get();
                if (headlessAppLoaderListener != null) {
                    headlessAppLoaderListener.appDestroyed(appScopeKey);
                }
            }
        }
    }
}
