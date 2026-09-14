package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\n\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u000b\u0018\u0001H\u0086\bR!\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, m1836d2 = {"Lexpo/modules/kotlin/types/ReturnTypeProvider;", "", "<init>", "()V", "types", "", "Lkotlin/reflect/KClass;", "Lexpo/modules/kotlin/types/ReturnType;", "getTypes", "()Ljava/util/Map;", "get", ExifInterface.GPS_DIRECTION_TRUE, "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ReturnTypeProvider {

    @NotNull
    public static final ReturnTypeProvider INSTANCE = new ReturnTypeProvider();
    private static final Map types = new LinkedHashMap();

    private ReturnTypeProvider() {
    }

    @NotNull
    public final Map<KClass<?>, ReturnType> getTypes() {
        return types;
    }

    public final /* synthetic */ <T> ReturnType get() {
        Map<KClass<?>, ReturnType> types2 = getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType = types2.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType != null) {
            return returnType;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
        Map<KClass<?>, ReturnType> types3 = INSTANCE.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        types3.put(Reflection.getOrCreateKotlinClass(Object.class), returnType2);
        return returnType2;
    }
}
