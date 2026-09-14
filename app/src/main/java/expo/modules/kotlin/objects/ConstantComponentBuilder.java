package expo.modules.kotlin.objects;

import com.urbanairship.actions.RateAppAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u000e\u001a\u00020\u0000\"\u0006\b\u0000\u0010\u000f\u0018\u00012\u000e\b\u0004\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\tH\u0086\bø\u0001\u0000J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, m1836d2 = {"Lexpo/modules/kotlin/objects/ConstantComponentBuilder;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getter", "Lkotlin/Function0;", "getGetter", "()Lkotlin/jvm/functions/Function0;", "setGetter", "(Lkotlin/jvm/functions/Function0;)V", "get", "R", RateAppAction.BODY_KEY, "build", "Lexpo/modules/kotlin/objects/ConstantComponent;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nConstantComponentBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConstantComponentBuilder.kt\nexpo/modules/kotlin/objects/ConstantComponentBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,19:1\n1#2:20\n*E\n"})
public class ConstantComponentBuilder {
    private Function0 getter;
    private final String name;

    public ConstantComponentBuilder(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Function0<Object> getGetter() {
        return this.getter;
    }

    public final void setGetter(@Nullable Function0<? extends Object> function0) {
        this.getter = function0;
    }

    public final /* synthetic */ <R> ConstantComponentBuilder get(final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        setGetter(new Function0<R>() { // from class: expo.modules.kotlin.objects.ConstantComponentBuilder$get$1$1
            @Override // kotlin.jvm.functions.Function0
            public final R invoke() {
                return (R) body.invoke();
            }
        });
        return this;
    }

    @NotNull
    public final ConstantComponent build() {
        String str = this.name;
        Function0 function0 = this.getter;
        if (function0 != null) {
            return new ConstantComponent(str, function0);
        }
        throw new IllegalArgumentException(("The constant '" + str + "' doesn't have getter.").toString());
    }
}
