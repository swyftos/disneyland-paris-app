package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\b¨\u0006\u0003"}, m1836d2 = {"toReturnType", "Lexpo/modules/kotlin/types/ReturnType;", ExifInterface.GPS_DIRECTION_TRUE, "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nReturnType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReturnType.kt\nexpo/modules/kotlin/types/ReturnTypeKt\n+ 2 ReturnType.kt\nexpo/modules/kotlin/types/ReturnTypeProvider\n*L\n1#1,215:1\n13#2,3:216\n*S KotlinDebug\n*F\n+ 1 ReturnType.kt\nexpo/modules/kotlin/types/ReturnTypeKt\n*L\n20#1:216,3\n*E\n"})
public final class ReturnTypeKt {
    public static final /* synthetic */ <T> ReturnType toReturnType() {
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType != null) {
            return returnType;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
        Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType2);
        return returnType2;
    }
}
