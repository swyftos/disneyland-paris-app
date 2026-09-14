package expo.modules.constants;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.InternalModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m1836d2 = {"Lexpo/modules/constants/ConstantsPackage;", "Lexpo/modules/core/BasePackage;", "<init>", "()V", "createInternalModules", "", "Lexpo/modules/core/interfaces/InternalModule;", "context", "Landroid/content/Context;", "expo-constants_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ConstantsPackage extends BasePackage {
    @Override // expo.modules.core.BasePackage, expo.modules.core.interfaces.Package
    @NotNull
    public List<InternalModule> createInternalModules(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new ConstantsService(context));
    }
}
