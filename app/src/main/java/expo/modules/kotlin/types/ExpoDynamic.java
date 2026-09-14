package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015J\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0019"}, m1836d2 = {"Lexpo/modules/kotlin/types/ExpoDynamic;", "", "dynamic", "Lcom/facebook/react/bridge/Dynamic;", "<init>", "(Lcom/facebook/react/bridge/Dynamic;)V", "type", "Lexpo/modules/kotlin/types/ExpoDynamic$Type;", "getType", "()Lexpo/modules/kotlin/types/ExpoDynamic$Type;", "isNull", "", "()Z", "asArray", "", "asBoolean", "asDouble", "", "asInt", "", "asMap", "", "", "asString", "Type", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ExpoDynamic {
    private final Dynamic dynamic;

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1836d2 = {"Lexpo/modules/kotlin/types/ExpoDynamic$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Boolean", "Number", "String", "Map", "Array", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public enum Type {
        Boolean,
        Number,
        String,
        Map,
        Array;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }
    }

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ExpoDynamic(@NotNull Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "dynamic");
        this.dynamic = dynamic;
    }

    @NotNull
    public final Type getType() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.dynamic.getType().ordinal()]) {
            case 1:
                throw new IllegalStateException("ExpoDynamic is null");
            case 2:
                return Type.Boolean;
            case 3:
                return Type.Number;
            case 4:
                return Type.String;
            case 5:
                return Type.Map;
            case 6:
                return Type.Array;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isNull() {
        if (this.dynamic.isNull()) {
            throw new IllegalStateException("ExpoDynamic is null");
        }
        return false;
    }

    @NotNull
    public final List<Object> asArray() {
        return this.dynamic.asArray().toArrayList();
    }

    public final boolean asBoolean() {
        return this.dynamic.asBoolean();
    }

    public final double asDouble() {
        return this.dynamic.asDouble();
    }

    public final int asInt() {
        return this.dynamic.asInt();
    }

    @NotNull
    public final Map<String, Object> asMap() {
        return this.dynamic.asMap().toHashMap();
    }

    @NotNull
    public final String asString() {
        return this.dynamic.asString();
    }
}
