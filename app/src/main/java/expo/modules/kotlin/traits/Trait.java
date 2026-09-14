package expo.modules.kotlin.traits;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m1836d2 = {"Lexpo/modules/kotlin/traits/Trait;", "InputType", "", "export", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "appContext", "Lexpo/modules/kotlin/AppContext;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface Trait<InputType> {
    @NotNull
    ObjectDefinitionData export(@NotNull AppContext appContext);
}
