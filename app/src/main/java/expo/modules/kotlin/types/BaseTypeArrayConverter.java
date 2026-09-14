package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0012H&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, m1836d2 = {"Lexpo/modules/kotlin/types/BaseTypeArrayConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/typedarray/TypedArray;", "Lexpo/modules/kotlin/types/NullAwareTypeConverter;", "isOptional", "", "<init>", "(Z)V", "convertNonOptional", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Lexpo/modules/kotlin/typedarray/TypedArray;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "wrapJavaScriptTypedArray", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)Lexpo/modules/kotlin/typedarray/TypedArray;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public abstract class BaseTypeArrayConverter<T extends TypedArray> extends NullAwareTypeConverter<T> {
    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @NotNull
    public abstract T wrapJavaScriptTypedArray(@NotNull JavaScriptTypedArray value);

    public BaseTypeArrayConverter(boolean z) {
        super(z);
    }

    @Override // expo.modules.kotlin.types.NullAwareTypeConverter
    @NotNull
    public T convertNonOptional(@NotNull Object value, @Nullable AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (T) wrapJavaScriptTypedArray((JavaScriptTypedArray) value);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    @NotNull
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.TYPED_ARRAY);
    }
}
