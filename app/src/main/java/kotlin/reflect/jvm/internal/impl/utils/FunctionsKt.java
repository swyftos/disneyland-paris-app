package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class FunctionsKt {
    private static final Function1 IDENTITY = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$3
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return FunctionsKt.IDENTITY$lambda$0(obj);
        }
    };
    private static final Function1 ALWAYS_TRUE = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$4
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return Boolean.valueOf(FunctionsKt.ALWAYS_TRUE$lambda$1(obj));
        }
    };
    private static final Function1 ALWAYS_NULL = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_NULL$1
        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(Object obj) {
            return null;
        }
    };
    private static final Function1 DO_NOTHING = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$5
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return FunctionsKt.DO_NOTHING$lambda$2(obj);
        }
    };
    private static final Function2 DO_NOTHING_2 = new Function2() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$6
        @Override // kotlin.jvm.functions.Function2
        public Object invoke(Object obj, Object obj2) {
            return FunctionsKt.DO_NOTHING_2$lambda$3(obj, obj2);
        }
    };
    private static final Function3 DO_NOTHING_3 = new Function3() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$$Lambda$7
        @Override // kotlin.jvm.functions.Function3
        public Object invoke(Object obj, Object obj2, Object obj3) {
            return FunctionsKt.DO_NOTHING_3$lambda$4(obj, obj2, obj3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ALWAYS_TRUE$lambda$1(Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object IDENTITY$lambda$0(Object obj) {
        return obj;
    }

    @NotNull
    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return ALWAYS_TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DO_NOTHING$lambda$2(Object obj) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DO_NOTHING_2$lambda$3(Object obj, Object obj2) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DO_NOTHING_3$lambda$4(Object obj, Object obj2, Object obj3) {
        return Unit.INSTANCE;
    }

    @NotNull
    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}
