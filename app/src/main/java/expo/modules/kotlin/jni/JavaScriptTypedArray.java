package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.actions.ToastAction;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.typedarray.TypedArray;
import java.nio.ByteBuffer;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0018\u001a\u00020\u000eH\u0082 J\t\u0010\u0019\u001a\u00020\u001aH\u0096 J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0096 J!\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0096 J\u0011\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u000eH\u0096 J\u0011\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u000eH\u0096 J\u0011\u0010&\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0096 J\u0011\u0010'\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\u000eH\u0096 J\u0011\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u000eH\u0096 J\u0011\u0010+\u001a\u00020,2\u0006\u0010\u001f\u001a\u00020\u000eH\u0096 J\u0019\u0010-\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020#H\u0096 J\u0019\u0010/\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020%H\u0096 J\u0019\u00100\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000eH\u0096 J\u0019\u00101\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020(H\u0096 J\u0019\u00102\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020*H\u0096 J\u0019\u00103\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020,H\u0096 R\u001b\u0010\u0007\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\u0010¨\u00064"}, m1836d2 = {"Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "kind", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", "kind$delegate", "Lkotlin/Lazy;", ToastAction.LENGTH_KEY, "", "getLength", "()I", "length$delegate", "byteLength", "getByteLength", "byteLength$delegate", "byteOffset", "getByteOffset", "byteOffset$delegate", "getRawKind", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "read", "", "buffer", "", ViewProps.POSITION, TCEventPropertiesNames.TCP_SIZE, "write", "readByte", "", "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "writeByte", "value", "write2Byte", "write4Byte", "write8Byte", "writeFloat", "writeDouble", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
@SourceDebugExtension({"SMAP\nJavaScriptTypedArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaScriptTypedArray.kt\nexpo/modules/kotlin/jni/JavaScriptTypedArray\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n1137#2,2:71\n*S KotlinDebug\n*F\n+ 1 JavaScriptTypedArray.kt\nexpo/modules/kotlin/jni/JavaScriptTypedArray\n*L\n33#1:71,2\n*E\n"})
public final class JavaScriptTypedArray extends JavaScriptObject implements TypedArray {

    /* JADX INFO: renamed from: byteLength$delegate, reason: from kotlin metadata */
    private final Lazy byteLength;

    /* JADX INFO: renamed from: byteOffset$delegate, reason: from kotlin metadata */
    private final Lazy byteOffset;

    /* JADX INFO: renamed from: kind$delegate, reason: from kotlin metadata */
    private final Lazy kind;

    /* JADX INFO: renamed from: length$delegate, reason: from kotlin metadata */
    private final Lazy length;

    private final native int getRawKind();

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void read(@NotNull byte[] buffer, int position, int size);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native short read2Byte(int position);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native int read4Byte(int position);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native long read8Byte(int position);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native byte readByte(int position);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native double readDouble(int position);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native float readFloat(int position);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    @NotNull
    public native ByteBuffer toDirectBuffer();

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void write(@NotNull byte[] buffer, int position, int size);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void write2Byte(int position, short value);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void write4Byte(int position, int value);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void write8Byte(int position, long value);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void writeByte(int position, byte value);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void writeDouble(int position, double value);

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public native void writeFloat(int position, float value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @DoNotStrip
    public JavaScriptTypedArray(@NotNull HybridData hybridData) {
        super(hybridData);
        Intrinsics.checkNotNullParameter(hybridData, "hybridData");
        this.kind = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JavaScriptTypedArray.kind_delegate$lambda$1(this.f$0);
            }
        });
        this.length = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(JavaScriptTypedArray.length_delegate$lambda$2(this.f$0));
            }
        });
        this.byteLength = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(JavaScriptTypedArray.byteLength_delegate$lambda$3(this.f$0));
            }
        });
        this.byteOffset = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.jni.JavaScriptTypedArray$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(JavaScriptTypedArray.byteOffset_delegate$lambda$4(this.f$0));
            }
        });
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    @NotNull
    public TypedArrayKind getKind() {
        return (TypedArrayKind) this.kind.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypedArrayKind kind_delegate$lambda$1(JavaScriptTypedArray javaScriptTypedArray) {
        int rawKind = javaScriptTypedArray.getRawKind();
        for (TypedArrayKind typedArrayKind : TypedArrayKind.values()) {
            if (typedArrayKind.getValue() == rawKind) {
                return typedArrayKind;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getLength() {
        return ((Number) this.length.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int length_delegate$lambda$2(JavaScriptTypedArray javaScriptTypedArray) {
        return (int) javaScriptTypedArray.getProperty(ToastAction.LENGTH_KEY).getDouble();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getByteLength() {
        return ((Number) this.byteLength.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int byteLength_delegate$lambda$3(JavaScriptTypedArray javaScriptTypedArray) {
        return (int) javaScriptTypedArray.getProperty("byteLength").getDouble();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getByteOffset() {
        return ((Number) this.byteOffset.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int byteOffset_delegate$lambda$4(JavaScriptTypedArray javaScriptTypedArray) {
        return (int) javaScriptTypedArray.getProperty("byteOffset").getDouble();
    }
}
