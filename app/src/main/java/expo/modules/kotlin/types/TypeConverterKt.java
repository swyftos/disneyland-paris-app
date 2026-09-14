package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.UnsupportedClass;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0006\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\tH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1836d2 = {"createTrivialTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "isOptional", "", "cppRequireType", "Lexpo/modules/kotlin/jni/ExpectedType;", "dynamicFallback", "Lkotlin/Function1;", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class TypeConverterKt {
    public static /* synthetic */ TypeConverter createTrivialTypeConverter$default(boolean z, ExpectedType cppRequireType, Function1 dynamicFallback, int i, Object obj) {
        if ((i & 4) != 0) {
            Intrinsics.needClassReification();
            dynamicFallback = new Function1() { // from class: expo.modules.kotlin.types.TypeConverterKt.createTrivialTypeConverter.1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Dynamic it) throws UnsupportedClass {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                    throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
                }
            };
        }
        Intrinsics.checkNotNullParameter(cppRequireType, "cppRequireType");
        Intrinsics.checkNotNullParameter(dynamicFallback, "dynamicFallback");
        Intrinsics.needClassReification();
        return new C64312(z, dynamicFallback, cppRequireType);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: expo.modules.kotlin.types.TypeConverterKt$createTrivialTypeConverter$2 */
    @Metadata(m1835d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m1836d2 = {"expo/modules/kotlin/types/TypeConverterKt$createTrivialTypeConverter$2", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", "context", "Lexpo/modules/kotlin/AppContext;", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "convertFromAny", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
    public static final class C64312<T> extends DynamicAwareTypeConverters<T> {
        final /* synthetic */ ExpectedType $cppRequireType;
        final /* synthetic */ Function1 $dynamicFallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64312(boolean z, Function1<? super Dynamic, ? extends T> function1, ExpectedType expectedType) {
            super(z);
            this.$dynamicFallback = function1;
            this.$cppRequireType = expectedType;
        }

        @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
        public T convertFromDynamic(Dynamic value, AppContext context) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (T) this.$dynamicFallback.invoke(value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
        public T convertFromAny(Object value, AppContext context) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return value;
        }

        @Override // expo.modules.kotlin.types.TypeConverter
        /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
        public ExpectedType get$cppRequireType() {
            return this.$cppRequireType;
        }
    }

    public static final /* synthetic */ <T> TypeConverter<T> createTrivialTypeConverter(boolean z, ExpectedType cppRequireType, Function1<? super Dynamic, ? extends T> dynamicFallback) {
        Intrinsics.checkNotNullParameter(cppRequireType, "cppRequireType");
        Intrinsics.checkNotNullParameter(dynamicFallback, "dynamicFallback");
        Intrinsics.needClassReification();
        return new C64312(z, dynamicFallback, cppRequireType);
    }
}
