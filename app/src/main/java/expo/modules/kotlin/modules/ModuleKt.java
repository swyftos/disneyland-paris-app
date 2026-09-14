package expo.modules.kotlin.modules;

import androidx.tracing.Trace;
import expo.modules.kotlin.types.TypeConverterProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0019\b\u0004\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a+\u0010\b\u001a\u00020\t*\u00020\u00022\u0019\b\u0004\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1836d2 = {"ModuleDefinition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Lexpo/modules/kotlin/modules/Module;", "block", "Lkotlin/Function1;", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "", "Lkotlin/ExtensionFunctionType;", "ModuleConverters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "Lexpo/modules/kotlin/modules/ModuleConvertersBuilder;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Module.kt\nexpo/modules/kotlin/modules/ModuleKt\n+ 2 ExpoTrace.kt\nexpo/modules/kotlin/tracing/ExpoTraceKt\n+ 3 Trace.kt\nandroidx/tracing/TraceKt\n*L\n1#1,68:1\n14#2:69\n25#2:70\n14#2:76\n25#2:77\n27#3,5:71\n27#3,5:78\n*S KotlinDebug\n*F\n+ 1 Module.kt\nexpo/modules/kotlin/modules/ModuleKt\n*L\n61#1:69\n61#1:70\n66#1:76\n66#1:77\n61#1:71,5\n66#1:78,5\n*E\n"})
public final class ModuleKt {
    @NotNull
    public static final ModuleDefinitionData ModuleDefinition(@NotNull Module module, @NotNull Function1<? super ModuleDefinitionBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            block.invoke(moduleDefinitionBuilder);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            InlineMarker.finallyStart(1);
            Trace.endSection();
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final TypeConverterProvider ModuleConverters(@NotNull Module module, @NotNull Function1<? super ModuleConvertersBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".TypeConverters"));
        try {
            ModuleConvertersBuilder moduleConvertersBuilder = new ModuleConvertersBuilder();
            block.invoke(moduleConvertersBuilder);
            return moduleConvertersBuilder.buildTypeConverterProvider();
        } finally {
            InlineMarker.finallyStart(1);
            Trace.endSection();
            InlineMarker.finallyEnd(1);
        }
    }
}
