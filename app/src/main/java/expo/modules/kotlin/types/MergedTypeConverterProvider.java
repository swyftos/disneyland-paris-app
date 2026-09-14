package expo.modules.kotlin.types;

import expo.modules.kotlin.exception.MissingTypeConverter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lexpo/modules/kotlin/types/MergedTypeConverterProvider;", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "providers", "", "<init>", "(Ljava/util/List;)V", "obtainTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "type", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class MergedTypeConverterProvider implements TypeConverterProvider {
    private final List providers;

    public MergedTypeConverterProvider(@NotNull List<? extends TypeConverterProvider> providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        this.providers = providers;
    }

    @Override // expo.modules.kotlin.types.TypeConverterProvider
    @NotNull
    public TypeConverter<?> obtainTypeConverter(@NotNull KType type) throws MissingTypeConverter {
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator it = this.providers.iterator();
        while (it.hasNext()) {
            try {
                return ((TypeConverterProvider) it.next()).obtainTypeConverter(type);
            } catch (MissingTypeConverter unused) {
            }
        }
        throw new MissingTypeConverter(type);
    }
}
