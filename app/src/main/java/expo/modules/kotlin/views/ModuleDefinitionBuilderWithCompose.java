package expo.modules.kotlin.views;

import expo.modules.kotlin.modules.InternalModuleDefinitionBuilder;
import expo.modules.kotlin.modules.Module;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/kotlin/views/ModuleDefinitionBuilderWithCompose;", "Lexpo/modules/kotlin/modules/InternalModuleDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "<init>", "(Lexpo/modules/kotlin/modules/Module;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public class ModuleDefinitionBuilderWithCompose extends InternalModuleDefinitionBuilder {
    public ModuleDefinitionBuilderWithCompose() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ModuleDefinitionBuilderWithCompose(Module module, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : module);
    }

    public ModuleDefinitionBuilderWithCompose(@Nullable Module module) {
        super(module, null, 2, 0 == true ? 1 : 0);
    }
}
