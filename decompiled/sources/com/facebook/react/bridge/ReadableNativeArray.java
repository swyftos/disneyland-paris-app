package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082 ¢\u0006\u0002\u0010\tJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082 ¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\u0013\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\u0010\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070*H\u0016R#\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010¨\u0006,"}, d2 = {"Lcom/facebook/react/bridge/ReadableNativeArray;", "Lcom/facebook/react/bridge/NativeArray;", "Lcom/facebook/react/bridge/ReadableArray;", "<init>", "()V", "localArray", "", "", "getLocalArray", "()[Ljava/lang/Object;", "localArray$delegate", "Lkotlin/Lazy;", "importArray", "localTypeArray", "Lcom/facebook/react/bridge/ReadableType;", "getLocalTypeArray", "()[Lcom/facebook/react/bridge/ReadableType;", "localTypeArray$delegate", "importTypeArray", TCEventPropertiesNames.TCP_SIZE, "", "isNull", "", "index", "getBoolean", "getDouble", "", "getInt", "getLong", "", "getString", "", "getArray", "getMap", "Lcom/facebook/react/bridge/ReadableNativeMap;", "getType", "getDynamic", "Lcom/facebook/react/bridge/Dynamic;", "hashCode", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "toArrayList", "Ljava/util/ArrayList;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ReadableNativeArray extends NativeArray implements ReadableArray {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private static int jniPassCounter;

    /* renamed from: localArray$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy localArray;

    /* renamed from: localTypeArray$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy localTypeArray;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
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

    @JvmStatic
    @JvmName(name = "getJNIPassCounter")
    public static final int getJNIPassCounter() {
        return Companion.getJNIPassCounter();
    }

    private final native Object[] importArray();

    private final native Object[] importTypeArray();

    protected ReadableNativeArray() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.localArray = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.react.bridge.ReadableNativeArray$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReadableNativeArray.localArray_delegate$lambda$0(this.f$0);
            }
        });
        this.localTypeArray = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.react.bridge.ReadableNativeArray$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReadableNativeArray.localTypeArray_delegate$lambda$1(this.f$0);
            }
        });
    }

    private final Object[] getLocalArray() {
        return (Object[]) this.localArray.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] localArray_delegate$lambda$0(ReadableNativeArray readableNativeArray) {
        jniPassCounter++;
        return readableNativeArray.importArray();
    }

    private final ReadableType[] getLocalTypeArray() {
        Object value = this.localTypeArray.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ReadableType[]) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableType[] localTypeArray_delegate$lambda$1(ReadableNativeArray readableNativeArray) {
        jniPassCounter++;
        Object[] objArrImportTypeArray = readableNativeArray.importTypeArray();
        return (ReadableType[]) Arrays.copyOf(objArrImportTypeArray, objArrImportTypeArray.length, ReadableType[].class);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int size() {
        return getLocalArray().length;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean isNull(int index) {
        return getLocalArray()[index] == null;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean getBoolean(int index) {
        Object obj = getLocalArray()[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public double getDouble(int index) {
        Object obj = getLocalArray()[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) obj).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int getInt(int index) {
        Object obj = getLocalArray()[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
        return (int) ((Double) obj).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public long getLong(int index) {
        Object obj = getLocalArray()[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public String getString(int index) {
        return (String) getLocalArray()[index];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public ReadableNativeArray getArray(int index) {
        return (ReadableNativeArray) getLocalArray()[index];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public ReadableNativeMap getMap(int index) {
        return (ReadableNativeMap) getLocalArray()[index];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public ReadableType getType(int index) {
        return getLocalTypeArray()[index];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public Dynamic getDynamic(int index) {
        DynamicFromArray dynamicFromArrayCreate = DynamicFromArray.create(this, index);
        Intrinsics.checkNotNullExpressionValue(dynamicFromArrayCreate, "create(...)");
        return dynamicFromArrayCreate;
    }

    public int hashCode() {
        return getLocalArray().hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof ReadableNativeArray) {
            return ArraysKt.contentDeepEquals(getLocalArray(), ((ReadableNativeArray) other).getLocalArray());
        }
        return false;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public ArrayList<Object> toArrayList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            switch (WhenMappings.$EnumSwitchMapping$0[getType(i).ordinal()]) {
                case 1:
                    arrayList.add(null);
                    break;
                case 2:
                    arrayList.add(Boolean.valueOf(getBoolean(i)));
                    break;
                case 3:
                    arrayList.add(Double.valueOf(getDouble(i)));
                    break;
                case 4:
                    arrayList.add(getString(i));
                    break;
                case 5:
                    ReadableNativeMap map = getMap(i);
                    arrayList.add(map != null ? map.toHashMap() : null);
                    break;
                case 6:
                    ReadableNativeArray array = getArray(i);
                    arrayList.add(array != null ? array.toArrayList() : null);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/react/bridge/ReadableNativeArray$Companion;", "", "<init>", "()V", "value", "", "jniPassCounter", "getJNIPassCounter", "()I", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @JvmName(name = "getJNIPassCounter")
        public final int getJNIPassCounter() {
            return ReadableNativeArray.jniPassCounter;
        }
    }
}
