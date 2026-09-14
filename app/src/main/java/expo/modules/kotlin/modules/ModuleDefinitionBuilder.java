package expo.modules.kotlin.modules;

import expo.modules.kotlin.views.ModuleDefinitionBuilderWithCompose;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "Lexpo/modules/kotlin/views/ModuleDefinitionBuilderWithCompose;", "module", "Lexpo/modules/kotlin/modules/Module;", "<init>", "(Lexpo/modules/kotlin/modules/Module;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ModuleDefinitionBuilder extends ModuleDefinitionBuilderWithCompose {
    public ModuleDefinitionBuilder() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ModuleDefinitionBuilder(Module module, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : module);
    }

    public ModuleDefinitionBuilder(@Nullable Module module) {
        super(module);
    }
}
