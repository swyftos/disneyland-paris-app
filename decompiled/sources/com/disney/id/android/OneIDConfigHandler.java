package com.disney.id.android;

import com.disney.id.android.dagger.OneIDDagger;
import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/disney/id/android/OneIDConfigHandler;", "Lcom/disney/id/android/ConfigHandler;", "()V", "config", "Lcom/disney/id/android/Config;", "get", "hasConfig", "", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDConfigHandler implements ConfigHandler {
    private Config config;

    public OneIDConfigHandler() {
        OneIDDagger.getComponent().inject(this);
    }

    @Override // com.disney.id.android.ConfigHandler
    @NotNull
    public Config get() throws NotInitialized {
        Config config = this.config;
        if (config != null) {
            return config;
        }
        throw new NotInitialized("OneID has not been initialized yet. No Config");
    }

    @Override // com.disney.id.android.ConfigHandler
    public void set(@NotNull Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // com.disney.id.android.ConfigHandler
    public boolean hasConfig() {
        return this.config != null;
    }
}
