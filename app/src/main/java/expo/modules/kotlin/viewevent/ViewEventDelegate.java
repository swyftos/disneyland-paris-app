package expo.modules.kotlin.viewevent;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B@\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012/\u0010\u0005\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0013\u001a\u00020\u00042\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0086\u0002R7\u0010\u0005\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1836d2 = {"Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "", "view", "Landroid/view/View;", "coalescingKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "viewHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getValue", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ViewEventDelegate<T> {
    private final Function1 coalescingKey;
    private final WeakReference viewHolder;

    public ViewEventDelegate(@NotNull View view, @Nullable Function1<? super T, Short> function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.coalescingKey = function1;
        this.viewHolder = new WeakReference(view);
    }

    @NotNull
    public final ViewEventCallback<T> getValue(@NotNull View thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        View view = (View) this.viewHolder.get();
        if (view == null) {
            throw new IllegalStateException("Can't send the '" + property.getName() + "' event from the view that is deallocated");
        }
        return new ViewEvent(property.getName(), view, this.coalescingKey);
    }
}
