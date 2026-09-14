package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.NullArgumentException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\u0004\u0018\u00018\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1836d2 = {"Lexpo/modules/kotlin/types/NullAwareTypeConverter;", "Type", "", "Lexpo/modules/kotlin/types/TypeConverter;", "isOptional", "", "<init>", "(Z)V", "convert", "value", "context", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "convertNonOptional", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public abstract class NullAwareTypeConverter<Type> extends TypeConverter<Type> {
    private final boolean isOptional;

    @NotNull
    public abstract Type convertNonOptional(@NotNull Object value, @Nullable AppContext context);

    public NullAwareTypeConverter(boolean z) {
        this.isOptional = z;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    @Nullable
    public Type convert(@Nullable Object value, @Nullable AppContext context) throws NullArgumentException {
        if (value == null || ((value instanceof Dynamic) && ((Dynamic) value).isNull())) {
            if (this.isOptional) {
                return null;
            }
            throw new NullArgumentException();
        }
        return convertNonOptional(value, context);
    }
}
