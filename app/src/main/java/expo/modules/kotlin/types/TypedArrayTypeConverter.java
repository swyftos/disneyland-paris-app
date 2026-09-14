package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, m1836d2 = {"Lexpo/modules/kotlin/types/TypedArrayTypeConverter;", "Lexpo/modules/kotlin/types/BaseTypeArrayConverter;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "isOptional", "", "<init>", "(Z)V", "wrapJavaScriptTypedArray", "value", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "isTrivial", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class TypedArrayTypeConverter extends BaseTypeArrayConverter<TypedArray> {
    @Override // expo.modules.kotlin.types.BaseTypeArrayConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return true;
    }

    @Override // expo.modules.kotlin.types.BaseTypeArrayConverter
    @NotNull
    public TypedArray wrapJavaScriptTypedArray(@NotNull JavaScriptTypedArray value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    public TypedArrayTypeConverter(boolean z) {
        super(z);
    }
}
