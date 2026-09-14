package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.urbanairship.channel.AttributeMutation;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0017"}, m1836d2 = {"Lexpo/modules/kotlin/views/AnyViewProp;", "", "name", "", "type", "Lexpo/modules/kotlin/types/AnyType;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;)V", "getName", "()Ljava/lang/String;", "getType$expo_modules_core_release", "()Lexpo/modules/kotlin/types/AnyType;", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "prop", "Lcom/facebook/react/bridge/Dynamic;", "onView", "Landroid/view/View;", "appContext", "Lexpo/modules/kotlin/AppContext;", "isNullable", "", "()Z", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public abstract class AnyViewProp {
    private final String name;
    private final AnyType type;

    public abstract boolean isNullable();

    public abstract void set(@NotNull Dynamic prop, @NotNull View onView, @Nullable AppContext appContext);

    public AnyViewProp(@NotNull String name, @NotNull AnyType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: getType$expo_modules_core_release, reason: from getter */
    public final AnyType getType() {
        return this.type;
    }

    public static /* synthetic */ void set$default(AnyViewProp anyViewProp, Dynamic dynamic, View view, AppContext appContext, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: set");
        }
        if ((i & 4) != 0) {
            appContext = null;
        }
        anyViewProp.set(dynamic, view, appContext);
    }
}
