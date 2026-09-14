package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.urbanairship.channel.AttributeMutation;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PropSetException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004BO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00126\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016RD\u0010\t\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000b\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001b"}, m1836d2 = {"Lexpo/modules/kotlin/views/ConcreteViewProp;", "ViewType", "Landroid/view/View;", "PropType", "Lexpo/modules/kotlin/views/AnyViewProp;", "name", "", "propType", "Lexpo/modules/kotlin/types/AnyType;", "setter", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "view", "prop", "", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function2;)V", "getSetter", "()Lkotlin/jvm/functions/Function2;", AttributeMutation.ATTRIBUTE_ACTION_SET, "Lcom/facebook/react/bridge/Dynamic;", "onView", "appContext", "Lexpo/modules/kotlin/AppContext;", "isNullable", "", "()Z", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nConcreteViewProp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcreteViewProp.kt\nexpo/modules/kotlin/views/ConcreteViewProp\n+ 2 ExceptionDecorator.kt\nexpo/modules/kotlin/exception/ExceptionDecoratorKt\n+ 3 CodedException.kt\nexpo/modules/kotlin/exception/CodedExceptionKt\n*L\n1#1,42:1\n5#2,4:43\n11#3,6:47\n*S KotlinDebug\n*F\n+ 1 ConcreteViewProp.kt\nexpo/modules/kotlin/views/ConcreteViewProp\n*L\n17#1:43,4\n17#1:47,6\n*E\n"})
public class ConcreteViewProp<ViewType extends View, PropType> extends AnyViewProp {
    private final boolean isNullable;
    private final Function2 setter;

    @NotNull
    protected final Function2<ViewType, PropType, Unit> getSetter() {
        return this.setter;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcreteViewProp(@NotNull String name, @NotNull AnyType propType, @NotNull Function2<? super ViewType, ? super PropType, Unit> setter) {
        super(name, propType);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(propType, "propType");
        Intrinsics.checkNotNullParameter(setter, "setter");
        this.setter = setter;
        this.isNullable = propType.getKType().getIsMarkedNullable();
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    public void set(@NotNull Dynamic prop, @NotNull View onView, @Nullable AppContext appContext) throws PropSetException {
        CodedException unexpectedException;
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(onView, "onView");
        try {
            this.setter.invoke(onView, getType().convert(prop, appContext));
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                String code = codedException.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new PropSetException(getName(), Reflection.getOrCreateKotlinClass(onView.getClass()), unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    /* JADX INFO: renamed from: isNullable, reason: from getter */
    public boolean getIsNullable() {
        return this.isNullable;
    }
}
