package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public abstract class ReturnsCheck implements Check {
    private final String description;
    private final String name;
    private final Function1 type;

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    private ReturnsCheck(String str, Function1 function1) {
        this.name = str;
        this.type = function1;
        this.description = "must return " + str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    public static final class ReturnsBoolean extends ReturnsCheck {

        @NotNull
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.1
                @Override // kotlin.jvm.functions.Function1
                public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                    SimpleType booleanType = kotlinBuiltIns.getBooleanType();
                    Intrinsics.checkNotNullExpressionValue(booleanType, "booleanType");
                    return booleanType;
                }
            }, null);
        }
    }

    public static final class ReturnsInt extends ReturnsCheck {

        @NotNull
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt.1
                @Override // kotlin.jvm.functions.Function1
                public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                    SimpleType intType = kotlinBuiltIns.getIntType();
                    Intrinsics.checkNotNullExpressionValue(intType, "intType");
                    return intType;
                }
            }, null);
        }
    }

    public static final class ReturnsUnit extends ReturnsCheck {

        @NotNull
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit.1
                @Override // kotlin.jvm.functions.Function1
                public final KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    Intrinsics.checkNotNullParameter(kotlinBuiltIns, "$this$null");
                    SimpleType unitType = kotlinBuiltIns.getUnitType();
                    Intrinsics.checkNotNullExpressionValue(unitType, "unitType");
                    return unitType;
                }
            }, null);
        }
    }
}
