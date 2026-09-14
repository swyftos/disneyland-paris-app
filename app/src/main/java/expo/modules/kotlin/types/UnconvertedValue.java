package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\r\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1836d2 = {"Lexpo/modules/kotlin/types/UnconvertedValue;", "Lexpo/modules/kotlin/types/DeferredValue;", "unconvertedValue", "", "typeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "context", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/TypeConverter;Lexpo/modules/kotlin/AppContext;)V", "contextHolder", "Ljava/lang/ref/WeakReference;", "convertedValue", "getConvertedValue", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class UnconvertedValue extends DeferredValue {
    private final WeakReference contextHolder;
    private Object convertedValue;
    private final TypeConverter typeConverter;
    private final Object unconvertedValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnconvertedValue(@NotNull Object unconvertedValue, @NotNull TypeConverter<?> typeConverter, @Nullable AppContext appContext) {
        super(null);
        Intrinsics.checkNotNullParameter(unconvertedValue, "unconvertedValue");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        this.unconvertedValue = unconvertedValue;
        this.typeConverter = typeConverter;
        this.contextHolder = new WeakReference(appContext);
    }

    @NotNull
    public final Object getConvertedValue() {
        if (this.convertedValue == null) {
            this.convertedValue = this.typeConverter.convert(this.unconvertedValue, (AppContext) this.contextHolder.get());
        }
        Object obj = this.convertedValue;
        Intrinsics.checkNotNull(obj);
        return obj;
    }
}
