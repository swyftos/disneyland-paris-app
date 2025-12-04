package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nplatformUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 platformUtil.kt\norg/jetbrains/kotlin/platform/PlatformUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,43:1\n10#1:55\n800#2,11:44\n800#2,11:56\n*S KotlinDebug\n*F\n+ 1 platformUtil.kt\norg/jetbrains/kotlin/platform/PlatformUtilKt\n*L\n13#1:55\n10#1:44,11\n13#1:56,11\n*E\n"})
/* loaded from: classes6.dex */
public final class PlatformUtilKt {
    @NotNull
    public static final String getPresentableDescription(@NotNull TargetPlatform targetPlatform) {
        Intrinsics.checkNotNullParameter(targetPlatform, "<this>");
        return CollectionsKt.joinToString$default(targetPlatform.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
    }
}
