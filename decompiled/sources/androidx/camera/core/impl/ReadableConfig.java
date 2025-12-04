package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import java.util.Set;

/* loaded from: classes.dex */
public interface ReadableConfig extends Config {
    @NonNull
    Config getConfig();

    @Override // androidx.camera.core.impl.Config
    default boolean containsOption(@NonNull Config.Option<?> option) {
        return getConfig().containsOption(option);
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    default <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option) {
        return (ValueT) getConfig().retrieveOption(option);
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    default <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        return (ValueT) getConfig().retrieveOption(option, valuet);
    }

    @Override // androidx.camera.core.impl.Config
    default void findOptions(@NonNull String str, @NonNull Config.OptionMatcher optionMatcher) {
        getConfig().findOptions(str, optionMatcher);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    default Set<Config.Option<?>> listOptions() {
        return getConfig().listOptions();
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    default <ValueT> ValueT retrieveOptionWithPriority(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority) {
        return (ValueT) getConfig().retrieveOptionWithPriority(option, optionPriority);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    default Config.OptionPriority getOptionPriority(@NonNull Config.Option<?> option) {
        return getConfig().getOptionPriority(option);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    default Set<Config.OptionPriority> getPriorities(@NonNull Config.Option<?> option) {
        return getConfig().getPriorities(option);
    }
}
