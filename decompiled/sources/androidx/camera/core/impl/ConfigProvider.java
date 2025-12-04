package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public interface ConfigProvider<C extends Config> {
    @NonNull
    C getConfig();
}
