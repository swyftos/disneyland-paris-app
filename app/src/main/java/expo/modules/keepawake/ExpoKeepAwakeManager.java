package expo.modules.keepawake;

import android.app.Activity;
import com.urbanairship.actions.FetchDeviceInfoAction;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00190\u0018H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1836d2 = {"Lexpo/modules/keepawake/ExpoKeepAwakeManager;", "Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "Lexpo/modules/core/interfaces/InternalModule;", "<init>", "()V", FetchDeviceInfoAction.TAGS_KEY, "", "", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "onCreate", "", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "activate", "tag", "done", "Ljava/lang/Runnable;", "deactivate", "isActivated", "", "getExportedInterfaces", "", "Ljava/lang/Class;", "expo-keep-awake_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ExpoKeepAwakeManager implements KeepAwakeManager, InternalModule {
    private ModuleRegistry moduleRegistry;
    private final Set tags = new HashSet();

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public void onCreate(@NotNull ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.moduleRegistry = moduleRegistry;
    }

    private final Activity getCurrentActivity() throws CurrentActivityNotFoundException {
        ModuleRegistry moduleRegistry = this.moduleRegistry;
        if (moduleRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moduleRegistry");
            moduleRegistry = null;
        }
        ActivityProvider activityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
        if (activityProvider == null) {
            throw new CurrentActivityNotFoundException();
        }
        if (activityProvider.getCurrentActivity() != null) {
            Activity currentActivity = activityProvider.getCurrentActivity();
            Intrinsics.checkNotNull(currentActivity);
            return currentActivity;
        }
        throw new CurrentActivityNotFoundException();
    }

    @Override // expo.modules.core.interfaces.services.KeepAwakeManager
    public void activate(@NotNull String tag, @NotNull Runnable done) throws CurrentActivityNotFoundException {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(done, "done");
        final Activity currentActivity = getCurrentActivity();
        if (!isActivated()) {
            currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.keepawake.ExpoKeepAwakeManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoKeepAwakeManager.activate$lambda$0(currentActivity);
                }
            });
        }
        this.tags.add(tag);
        done.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activate$lambda$0(Activity activity) {
        activity.getWindow().addFlags(128);
    }

    @Override // expo.modules.core.interfaces.services.KeepAwakeManager
    public void deactivate(@NotNull String tag, @NotNull Runnable done) throws CurrentActivityNotFoundException {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(done, "done");
        final Activity currentActivity = getCurrentActivity();
        if (this.tags.size() == 1 && this.tags.contains(tag)) {
            currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.keepawake.ExpoKeepAwakeManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoKeepAwakeManager.deactivate$lambda$1(currentActivity);
                }
            });
        }
        this.tags.remove(tag);
        done.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deactivate$lambda$1(Activity activity) {
        activity.getWindow().clearFlags(128);
    }

    @Override // expo.modules.core.interfaces.services.KeepAwakeManager
    public boolean isActivated() {
        return !this.tags.isEmpty();
    }

    @Override // expo.modules.core.interfaces.InternalModule
    @NotNull
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(KeepAwakeManager.class);
    }
}
