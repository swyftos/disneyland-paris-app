package expo.modules;

import android.app.Application;
import android.content.res.Configuration;
import androidx.media3.common.MimeTypes;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import expo.modules.core.interfaces.Package;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1836d2 = {"Lexpo/modules/ApplicationLifecycleDispatcher;", "", "<init>", "()V", "listeners", "", "Lexpo/modules/core/interfaces/ApplicationLifecycleListener;", "getCachedListeners", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "onApplicationCreate", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "expo_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nApplicationLifecycleDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApplicationLifecycleDispatcher.kt\nexpo/modules/ApplicationLifecycleDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,28:1\n1368#2:29\n1454#2,5:30\n1863#2,2:36\n1863#2,2:38\n1#3:35\n*S KotlinDebug\n*F\n+ 1 ApplicationLifecycleDispatcher.kt\nexpo/modules/ApplicationLifecycleDispatcher\n*L\n14#1:29\n14#1:30,5\n20#1:36,2\n25#1:38,2\n*E\n"})
public final class ApplicationLifecycleDispatcher {

    @NotNull
    public static final ApplicationLifecycleDispatcher INSTANCE = new ApplicationLifecycleDispatcher();
    private static List listeners;

    private ApplicationLifecycleDispatcher() {
    }

    private final List getCachedListeners(Application application) {
        List list = listeners;
        if (list != null) {
            return list;
        }
        List<Package> packageList = ExpoModulesPackage.INSTANCE.getPackageList();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = packageList.iterator();
        while (it.hasNext()) {
            List<? extends ApplicationLifecycleListener> listCreateApplicationLifecycleListeners = ((Package) it.next()).createApplicationLifecycleListeners(application);
            Intrinsics.checkNotNullExpressionValue(listCreateApplicationLifecycleListeners, "createApplicationLifecycleListeners(...)");
            CollectionsKt.addAll(arrayList, listCreateApplicationLifecycleListeners);
        }
        listeners = arrayList;
        return arrayList;
    }

    @JvmStatic
    public static final void onApplicationCreate(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Iterator it = INSTANCE.getCachedListeners(application).iterator();
        while (it.hasNext()) {
            ((ApplicationLifecycleListener) it.next()).onCreate(application);
        }
    }

    @JvmStatic
    public static final void onConfigurationChanged(@NotNull Application application, @NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Iterator it = INSTANCE.getCachedListeners(application).iterator();
        while (it.hasNext()) {
            ((ApplicationLifecycleListener) it.next()).onConfigurationChanged(newConfig);
        }
    }
}
