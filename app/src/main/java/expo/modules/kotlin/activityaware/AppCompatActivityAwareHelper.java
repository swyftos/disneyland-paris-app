package expo.modules.kotlin.activityaware;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lexpo/modules/kotlin/activityaware/AppCompatActivityAwareHelper;", "Lexpo/modules/kotlin/activityaware/AppCompatActivityAware;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lexpo/modules/kotlin/activityaware/OnActivityAvailableListener;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "activityReference", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/app/AppCompatActivity;", "dispatchOnActivityAvailable", "", "activity", "addOnActivityAvailableListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeOnActivityAvailableListener", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class AppCompatActivityAwareHelper implements AppCompatActivityAware {
    private final CopyOnWriteArrayList listeners = new CopyOnWriteArrayList();
    private WeakReference activityReference = new WeakReference(null);

    @NotNull
    public final CopyOnWriteArrayList<OnActivityAvailableListener> getListeners() {
        return this.listeners;
    }

    public final void dispatchOnActivityAvailable(@NotNull final AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityReference = new WeakReference(activity);
        activity.runOnUiThread(new Runnable() { // from class: expo.modules.kotlin.activityaware.AppCompatActivityAwareHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AppCompatActivityAwareHelper.dispatchOnActivityAvailable$lambda$0(this.f$0, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchOnActivityAvailable$lambda$0(AppCompatActivityAwareHelper appCompatActivityAwareHelper, AppCompatActivity appCompatActivity) {
        Iterator it = appCompatActivityAwareHelper.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((OnActivityAvailableListener) it.next()).onActivityAvailable(appCompatActivity);
        }
    }

    @Override // expo.modules.kotlin.activityaware.AppCompatActivityAware
    public void addOnActivityAvailableListener(@NotNull final OnActivityAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
        final AppCompatActivity appCompatActivity = (AppCompatActivity) this.activityReference.get();
        if (appCompatActivity != null) {
            appCompatActivity.runOnUiThread(new Runnable() { // from class: expo.modules.kotlin.activityaware.AppCompatActivityAwareHelper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    listener.onActivityAvailable(appCompatActivity);
                }
            });
        }
    }

    @Override // expo.modules.kotlin.activityaware.AppCompatActivityAware
    public void removeOnActivityAvailableListener(@NotNull OnActivityAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }
}
