package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u0019\"\u0006\b\u0000\u0010\u001a\u0018\u0001H\u0080\b¢\u0006\u0002\b\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, m1836d2 = {"Lexpo/modules/kotlin/types/AnyType;", "", "kType", "Lkotlin/reflect/KType;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "(Lkotlin/reflect/KType;Lexpo/modules/kotlin/types/TypeConverterProvider;)V", "getKType", "()Lkotlin/reflect/KType;", "getConverterProvider", "()Lexpo/modules/kotlin/types/TypeConverterProvider;", "converter", "Lexpo/modules/kotlin/types/TypeConverter;", "getConverter", "()Lexpo/modules/kotlin/types/TypeConverter;", "converter$delegate", "Lkotlin/Lazy;", "convert", "value", "appContext", "Lexpo/modules/kotlin/AppContext;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "inheritFrom", "", ExifInterface.GPS_DIRECTION_TRUE, "inheritFrom$expo_modules_core_release", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class AnyType {

    /* JADX INFO: renamed from: converter$delegate, reason: from kotlin metadata */
    private final Lazy converter;
    private final TypeConverterProvider converterProvider;
    private final KType kType;

    public AnyType(@NotNull KType kType, @Nullable TypeConverterProvider typeConverterProvider) {
        Intrinsics.checkNotNullParameter(kType, "kType");
        this.kType = kType;
        this.converterProvider = typeConverterProvider;
        this.converter = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.types.AnyType$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AnyType.converter_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ AnyType(KType kType, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kType, (i & 2) != 0 ? null : typeConverterProvider);
    }

    @NotNull
    public final KType getKType() {
        return this.kType;
    }

    @Nullable
    public final TypeConverterProvider getConverterProvider() {
        return this.converterProvider;
    }

    private final TypeConverter getConverter() {
        return (TypeConverter) this.converter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeConverter converter_delegate$lambda$0(AnyType anyType) {
        TypeConverterProvider typeConverterProvider = anyType.converterProvider;
        if (typeConverterProvider != null) {
            return typeConverterProvider.obtainTypeConverter(anyType.kType);
        }
        return TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(anyType.kType);
    }

    public static /* synthetic */ Object convert$default(AnyType anyType, Object obj, AppContext appContext, int i, Object obj2) {
        if ((i & 2) != 0) {
            appContext = null;
        }
        return anyType.convert(obj, appContext);
    }

    @Nullable
    public final Object convert(@Nullable Object value, @Nullable AppContext appContext) {
        return getConverter().convert(value, appContext);
    }

    @NotNull
    public final ExpectedType getCppRequiredTypes() {
        return getConverter().getCppRequiredTypes();
    }

    public final /* synthetic */ <T> boolean inheritFrom$expo_modules_core_release() {
        KClassifier classifier = getKType().getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            return false;
        }
        Class javaClass = JvmClassMappingKt.getJavaClass(kClass);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(javaClass);
    }
}
