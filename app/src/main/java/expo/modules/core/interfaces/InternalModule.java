package expo.modules.core.interfaces;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface InternalModule extends RegistryLifecycleListener {
    List<? extends Class> getExportedInterfaces();
}
