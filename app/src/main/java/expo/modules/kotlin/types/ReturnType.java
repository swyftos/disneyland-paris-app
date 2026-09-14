package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\n\u001a\u00020\u000b\"\u0006\b\u0000\u0010\f\u0018\u0001H\u0080\b¢\u0006\u0002\b\rR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1836d2 = {"Lexpo/modules/kotlin/types/ReturnType;", "", "klass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "converter", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "convertToJS", "value", "inheritFrom", "", ExifInterface.GPS_DIRECTION_TRUE, "inheritFrom$expo_modules_core_release", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nReturnType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReturnType.kt\nexpo/modules/kotlin/types/ReturnType\n*L\n1#1,215:1\n211#1,2:216\n211#1,2:218\n211#1,2:220\n211#1,2:222\n211#1,2:224\n211#1,2:226\n*S KotlinDebug\n*F\n+ 1 ReturnType.kt\nexpo/modules/kotlin/types/ReturnType\n*L\n196#1:216,2\n197#1:218,2\n198#1:220,2\n199#1:222,2\n200#1:224,2\n201#1:226,2\n*E\n"})
public final class ReturnType {
    private final ExperimentalJSTypeConverter converter;
    private final KClass klass;

    public ReturnType(@NotNull KClass<?> klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
        ExperimentalJSTypeConverter passThroughConverter = Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Unit.class)) ? new ExperimentalJSTypeConverter.PassThroughConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Bundle.class)) ? new ExperimentalJSTypeConverter.BundleConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(int[].class)) ? new ExperimentalJSTypeConverter.IntArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(float[].class)) ? new ExperimentalJSTypeConverter.FloatArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(double[].class)) ? new ExperimentalJSTypeConverter.DoubleArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(boolean[].class)) ? new ExperimentalJSTypeConverter.BooleanArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(byte[].class)) ? new ExperimentalJSTypeConverter.ByteArrayConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(URI.class)) ? new ExperimentalJSTypeConverter.URIConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(URL.class)) ? new ExperimentalJSTypeConverter.URLConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Uri.class)) ? new ExperimentalJSTypeConverter.AndroidUriConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(File.class)) ? new ExperimentalJSTypeConverter.FileConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Pair.class)) ? new ExperimentalJSTypeConverter.PairConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Long.TYPE)) ? new ExperimentalJSTypeConverter.LongConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Duration.class)) ? new ExperimentalJSTypeConverter.DurationConverter() : Intrinsics.areEqual(klass, Reflection.getOrCreateKotlinClass(Object.class)) ? new ExperimentalJSTypeConverter.AnyConverter() : null;
        this.converter = passThroughConverter == null ? Map.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new ExperimentalJSTypeConverter.MapConverter() : Enum.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new ExperimentalJSTypeConverter.EnumConverter() : Record.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new ExperimentalJSTypeConverter.RecordConverter() : RawTypedArrayHolder.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new ExperimentalJSTypeConverter.RawTypedArrayHolderConverter() : Object[].class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new ExperimentalJSTypeConverter.ArrayConverter() : Collection.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass)) ? new ExperimentalJSTypeConverter.CollectionConverter() : new ExperimentalJSTypeConverter.PassThroughConverter() : passThroughConverter;
    }

    @Nullable
    public final Object convertToJS(@Nullable Object value) {
        return this.converter.convertToJS(value);
    }

    public final /* synthetic */ <T> boolean inheritFrom$expo_modules_core_release() {
        Class javaClass = JvmClassMappingKt.getJavaClass(this.klass);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(javaClass);
    }
}
