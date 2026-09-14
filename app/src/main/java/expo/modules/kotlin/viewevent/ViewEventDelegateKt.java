package expo.modules.kotlin.viewevent;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aQ\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\b\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\t21\b\n\u0010\n\u001a+\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\n\u0012\u0004\u0012\u0002H\u0001\u0018\u0001`\u000bH\u0086\bø\u0001\u0000\u001an\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\b*\u00020\t2I\b\u0002\u0010\n\u001aC\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u0001`\u000bH\u0007¢\u0006\u0002\b\u000f*F\u0010\u0000\u001a\u0004\b\u0000\u0010\u0001\"\u001d\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00022\u001d\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, m1836d2 = {"CoalescingKey", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "event", "", "EventDispatcher", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "Landroid/view/View;", "coalescingKey", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "", "", "", "MapEventDispatcher", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ViewEventDelegateKt {
    public static /* synthetic */ ViewEventDelegate EventDispatcher$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new ViewEventDelegate(view, function1);
    }

    public static final /* synthetic */ <T> ViewEventDelegate<T> EventDispatcher(View view, Function1<? super T, Short> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new ViewEventDelegate<>(view, function1);
    }

    public static /* synthetic */ ViewEventDelegate MapEventDispatcher$default(View view, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return MapEventDispatcher(view, function1);
    }

    @JvmName(name = "MapEventDispatcher")
    @NotNull
    public static final ViewEventDelegate<Map<String, Object>> MapEventDispatcher(@NotNull View view, @Nullable Function1<? super Map<String, ? extends Object>, Short> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return new ViewEventDelegate<>(view, function1);
    }
}
