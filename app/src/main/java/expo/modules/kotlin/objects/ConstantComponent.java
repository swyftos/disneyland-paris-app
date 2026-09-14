package expo.modules.kotlin.objects;

import expo.modules.kotlin.jni.JNINoArgsFunctionBody;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.JSTypeConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/kotlin/objects/ConstantComponent;", "", "name", "", "getter", "Lkotlin/Function0;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getName", "()Ljava/lang/String;", "getGetter", "()Lkotlin/jvm/functions/Function0;", "attachToJSObject", "", "jsObject", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ConstantComponent {
    private final Function0 getter;
    private final String name;

    public ConstantComponent(@NotNull String name, @NotNull Function0<? extends Object> getter) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(getter, "getter");
        this.name = name;
        this.getter = getter;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Function0<Object> getGetter() {
        return this.getter;
    }

    public final void attachToJSObject(@NotNull JSDecoratorsBridgingObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        jsObject.registerConstant(this.name, new JNINoArgsFunctionBody() { // from class: expo.modules.kotlin.objects.ConstantComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNINoArgsFunctionBody
            public final Object invoke() {
                return ConstantComponent.attachToJSObject$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object attachToJSObject$lambda$0(ConstantComponent constantComponent) {
        return JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, constantComponent.getter.invoke(), null, false, 6, null);
    }
}
