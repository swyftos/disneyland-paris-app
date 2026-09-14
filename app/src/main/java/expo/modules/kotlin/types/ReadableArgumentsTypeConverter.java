package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.core.arguments.MapArguments;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016¨\u0006\u0011"}, m1836d2 = {"Lexpo/modules/kotlin/types/ReadableArgumentsTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Lexpo/modules/core/arguments/ReadableArguments;", "isOptional", "", "<init>", "(Z)V", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", "context", "Lexpo/modules/kotlin/AppContext;", "convertFromAny", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ReadableArgumentsTypeConverter extends DynamicAwareTypeConverters<ReadableArguments> {
    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public ReadableArgumentsTypeConverter(boolean z) {
        super(z);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    @NotNull
    public ReadableArguments convertFromDynamic(@NotNull Dynamic value, @Nullable AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new MapArguments(value.asMap().toHashMap());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    @NotNull
    public ReadableArguments convertFromAny(@NotNull Object value, @Nullable AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new MapArguments(((ReadableMap) value).toHashMap());
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    @NotNull
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.READABLE_MAP);
    }
}
