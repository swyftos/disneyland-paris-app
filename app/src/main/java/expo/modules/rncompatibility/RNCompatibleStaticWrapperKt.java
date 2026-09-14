package expo.modules.rncompatibility;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BoxShadow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1836d2 = {"parseBoxShadow", "Lcom/facebook/react/uimanager/style/BoxShadow;", ViewProps.BOX_SHADOW, "Lcom/facebook/react/bridge/ReadableMap;", "context", "Landroid/content/Context;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RNCompatibleStaticWrapperKt {
    @Nullable
    public static final BoxShadow parseBoxShadow(@Nullable ReadableMap readableMap, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BoxShadow.INSTANCE.parse(readableMap, context);
    }
}
