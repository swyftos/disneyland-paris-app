package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import expo.modules.kotlin.types.folly.FollyDynamicExtensionConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007J&\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\r"}, m1836d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter;", "", "<init>", "()V", "legacyConvertToJSValue", "value", "containerProvider", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "convertToJSValue", "useExperimentalConverter", "", "ContainerProvider", "DefaultContainerProvider", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class JSTypeConverter {

    @NotNull
    public static final JSTypeConverter INSTANCE = new JSTypeConverter();

    @Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "", "createMap", "Lcom/facebook/react/bridge/WritableMap;", "createArray", "Lcom/facebook/react/bridge/WritableArray;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public interface ContainerProvider {
        @NotNull
        WritableArray createArray();

        @NotNull
        WritableMap createMap();
    }

    private JSTypeConverter() {
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m1836d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$DefaultContainerProvider;", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "<init>", "()V", "createMap", "Lcom/facebook/react/bridge/WritableMap;", "createArray", "Lcom/facebook/react/bridge/WritableArray;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class DefaultContainerProvider implements ContainerProvider {

        @NotNull
        public static final DefaultContainerProvider INSTANCE = new DefaultContainerProvider();

        private DefaultContainerProvider() {
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter.ContainerProvider
        @NotNull
        public WritableMap createMap() {
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            return writableMapCreateMap;
        }

        @Override // expo.modules.kotlin.types.JSTypeConverter.ContainerProvider
        @NotNull
        public WritableArray createArray() {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "createArray(...)");
            return writableArrayCreateArray;
        }
    }

    public static /* synthetic */ Object legacyConvertToJSValue$default(JSTypeConverter jSTypeConverter, Object obj, ContainerProvider containerProvider, int i, Object obj2) {
        if ((i & 2) != 0) {
            containerProvider = DefaultContainerProvider.INSTANCE;
        }
        return jSTypeConverter.legacyConvertToJSValue(obj, containerProvider);
    }

    @Nullable
    public final Object legacyConvertToJSValue(@Nullable Object value, @NotNull ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        if (value == null || (value instanceof Unit)) {
            return null;
        }
        if (value instanceof Bundle) {
            return JSTypeConverterHelperKt.toJSValue((Bundle) value, containerProvider);
        }
        if (value instanceof Object[]) {
            return JSTypeConverterHelperKt.toJSValue((Object[]) value, containerProvider);
        }
        if (value instanceof int[]) {
            return JSTypeConverterHelperKt.toJSValue((int[]) value, containerProvider);
        }
        if (value instanceof long[]) {
            return JSTypeConverterHelperKt.toJSValue((long[]) value, containerProvider);
        }
        if (value instanceof float[]) {
            return JSTypeConverterHelperKt.toJSValue((float[]) value, containerProvider);
        }
        if (value instanceof double[]) {
            return JSTypeConverterHelperKt.toJSValue((double[]) value, containerProvider);
        }
        if (value instanceof boolean[]) {
            return JSTypeConverterHelperKt.toJSValue((boolean[]) value, containerProvider);
        }
        if (value instanceof byte[]) {
            return FollyDynamicExtensionConverter.INSTANCE.put(value);
        }
        if (value instanceof Map) {
            return JSTypeConverterHelperKt.toJSValue((Map) value, containerProvider);
        }
        if (value instanceof Enum) {
            return JSTypeConverterHelperKt.toJSValue((Enum<?>) value);
        }
        if (value instanceof Record) {
            return JSTypeConverterHelperKt.toJSValue((Record) value, containerProvider);
        }
        if (value instanceof URI) {
            return JSTypeConverterHelperKt.toJSValue((URI) value);
        }
        if (value instanceof URL) {
            return JSTypeConverterHelperKt.toJSValue((URL) value);
        }
        if (value instanceof Uri) {
            return JSTypeConverterHelperKt.toJSValue((Uri) value);
        }
        if (value instanceof File) {
            return JSTypeConverterHelperKt.toJSValue((File) value);
        }
        if (value instanceof Pair) {
            return JSTypeConverterHelperKt.toJSValue((Pair<?, ?>) value, containerProvider);
        }
        if (value instanceof Long) {
            return Double.valueOf(((Number) value).longValue());
        }
        if (value instanceof Duration) {
            return Double.valueOf(Duration.m5814toDoubleimpl(((Duration) value).getRawValue(), DurationUnit.SECONDS));
        }
        if (value instanceof RawTypedArrayHolder) {
            return ((RawTypedArrayHolder) value).getRawArray();
        }
        return value instanceof Collection ? JSTypeConverterHelperKt.toJSValue((Collection) value, containerProvider) : value;
    }

    public static /* synthetic */ Object convertToJSValue$default(JSTypeConverter jSTypeConverter, Object obj, ContainerProvider containerProvider, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            containerProvider = DefaultContainerProvider.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return jSTypeConverter.convertToJSValue(obj, containerProvider, z);
    }

    @Nullable
    public final Object convertToJSValue(@Nullable Object value, @NotNull ContainerProvider containerProvider, boolean useExperimentalConverter) {
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        if (value == null || (value instanceof Unit)) {
            return null;
        }
        if (value instanceof Bundle) {
            return JSTypeConverterHelperKt.toJSValue((Bundle) value, containerProvider);
        }
        if (value instanceof Object[]) {
            return JSTypeConverterHelperKt.toJSValue((Object[]) value, containerProvider);
        }
        if ((value instanceof int[]) || (value instanceof float[]) || (value instanceof double[]) || (value instanceof boolean[]) || (value instanceof long[])) {
            return value;
        }
        if (value instanceof byte[]) {
            return FollyDynamicExtensionConverter.INSTANCE.put(value);
        }
        if (value instanceof Map) {
            if (useExperimentalConverter) {
                return JSTypeConverterHelperKt.toJSValueExperimental((Map) value);
            }
            return JSTypeConverterHelperKt.toJSValue((Map) value, containerProvider);
        }
        if (value instanceof Enum) {
            return JSTypeConverterHelperKt.toJSValue((Enum<?>) value);
        }
        if (value instanceof Record) {
            return JSTypeConverterHelperKt.toJSValue((Record) value, containerProvider);
        }
        if (value instanceof URI) {
            return JSTypeConverterHelperKt.toJSValue((URI) value);
        }
        if (value instanceof URL) {
            return JSTypeConverterHelperKt.toJSValue((URL) value);
        }
        if (value instanceof Uri) {
            return JSTypeConverterHelperKt.toJSValue((Uri) value);
        }
        if (value instanceof File) {
            return JSTypeConverterHelperKt.toJSValue((File) value);
        }
        if (value instanceof Pair) {
            return JSTypeConverterHelperKt.toJSValue((Pair<?, ?>) value, containerProvider);
        }
        if (value instanceof Long) {
            return Double.valueOf(((Number) value).longValue());
        }
        if (value instanceof Duration) {
            return Double.valueOf(Duration.m5814toDoubleimpl(((Duration) value).getRawValue(), DurationUnit.SECONDS));
        }
        if (value instanceof RawTypedArrayHolder) {
            return ((RawTypedArrayHolder) value).getRawArray();
        }
        if (!(value instanceof Collection)) {
            return value;
        }
        if (useExperimentalConverter) {
            return JSTypeConverterHelperKt.toJSValueExperimental((Collection) value);
        }
        return JSTypeConverterHelperKt.toJSValue((Collection) value, containerProvider);
    }
}
