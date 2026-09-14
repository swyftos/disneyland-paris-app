package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.urbanairship.channel.AttributeMutation;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.PropSetException;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004BW\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00126\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0006\u0010\u000f\u001a\u00028\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u000f\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0018"}, m1836d2 = {"Lexpo/modules/kotlin/views/ConcreteViewPropWithDefault;", "ViewType", "Landroid/view/View;", "PropType", "Lexpo/modules/kotlin/views/ConcreteViewProp;", "name", "", "propType", "Lexpo/modules/kotlin/types/AnyType;", "setter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "view", "prop", "", "defaultValue", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function2;Ljava/lang/Object;)V", "Ljava/lang/Object;", AttributeMutation.ATTRIBUTE_ACTION_SET, "Lcom/facebook/react/bridge/Dynamic;", "onView", "appContext", "Lexpo/modules/kotlin/AppContext;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ConcreteViewPropWithDefault<ViewType extends View, PropType> extends ConcreteViewProp<ViewType, PropType> {
    private final Object defaultValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcreteViewPropWithDefault(@NotNull String name, @NotNull AnyType propType, @NotNull Function2<? super ViewType, ? super PropType, Unit> setter, PropType proptype) {
        super(name, propType, setter);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(propType, "propType");
        Intrinsics.checkNotNullParameter(setter, "setter");
        this.defaultValue = proptype;
    }

    @Override // expo.modules.kotlin.views.ConcreteViewProp, expo.modules.kotlin.views.AnyViewProp
    public void set(@NotNull Dynamic prop, @NotNull View onView, @Nullable AppContext appContext) throws PropSetException {
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(onView, "onView");
        if (prop.isNull()) {
            getSetter().invoke(onView, this.defaultValue);
        } else {
            super.set(prop, onView, appContext);
        }
    }
}
