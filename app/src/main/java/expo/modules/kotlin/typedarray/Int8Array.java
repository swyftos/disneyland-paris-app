package expo.modules.kotlin.typedarray;

import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.actions.ToastAction;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.jni.TypedArrayKind;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J!\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\rH\u0096\u0001J\t\u0010!\u001a\u00020\"H\u0096\u0001J!\u0010#\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0096\u0001J\u0019\u0010$\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0018H\u0096\u0001J\u0019\u0010%\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0096\u0001J\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001bH\u0096\u0001J\u0019\u0010'\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0001J\u0019\u0010(\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001eH\u0096\u0001J\u0019\u0010)\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020 H\u0096\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010*\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u0010,¨\u00065"}, m1836d2 = {"Lexpo/modules/kotlin/typedarray/Int8Array;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "Lexpo/modules/kotlin/typedarray/GenericTypedArray;", "", "Lexpo/modules/kotlin/typedarray/RawTypedArrayHolder;", "rawArray", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "<init>", "(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)V", "getRawArray", "()Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "get", ArrayContainsMatcher.INDEX_KEY, "", "(I)Ljava/lang/Byte;", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "value", "read", "buffer", "", ViewProps.POSITION, TCEventPropertiesNames.TCP_SIZE, "read2Byte", "", "read4Byte", "read8Byte", "", "readByte", "readDouble", "", "readFloat", "", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "write", "write2Byte", "write4Byte", "write8Byte", "writeByte", "writeDouble", "writeFloat", "byteLength", "getByteLength", "()I", "byteOffset", "getByteOffset", "kind", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", ToastAction.LENGTH_KEY, "getLength", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nConcreteTypedArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcreteTypedArrays.kt\nexpo/modules/kotlin/typedarray/Int8Array\n+ 2 ConcreteTypedArrays.kt\nexpo/modules/kotlin/typedarray/ConcreteTypedArraysKt\n*L\n1#1,159:1\n7#2,4:160\n7#2,4:164\n*S KotlinDebug\n*F\n+ 1 ConcreteTypedArrays.kt\nexpo/modules/kotlin/typedarray/Int8Array\n*L\n19#1:160,4\n24#1:164,4\n*E\n"})
public final class Int8Array implements TypedArray, GenericTypedArray<Byte>, RawTypedArrayHolder {
    private final JavaScriptTypedArray rawArray;

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getByteLength() {
        return this.rawArray.getByteLength();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getByteOffset() {
        return this.rawArray.getByteOffset();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    @NotNull
    public TypedArrayKind getKind() {
        return this.rawArray.getKind();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int getLength() {
        return this.rawArray.getLength();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void read(@NotNull byte[] buffer, int position, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.rawArray.read(buffer, position, size);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public short read2Byte(int position) {
        return this.rawArray.read2Byte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public int read4Byte(int position) {
        return this.rawArray.read4Byte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public long read8Byte(int position) {
        return this.rawArray.read8Byte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public byte readByte(int position) {
        return this.rawArray.readByte(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public double readDouble(int position) {
        return this.rawArray.readDouble(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public float readFloat(int position) {
        return this.rawArray.readFloat(position);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    @NotNull
    public ByteBuffer toDirectBuffer() {
        return this.rawArray.toDirectBuffer();
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write(@NotNull byte[] buffer, int position, int size) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.rawArray.write(buffer, position, size);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write2Byte(int position, short value) {
        this.rawArray.write2Byte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write4Byte(int position, int value) {
        this.rawArray.write4Byte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void write8Byte(int position, long value) {
        this.rawArray.write8Byte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void writeByte(int position, byte value) {
        this.rawArray.writeByte(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void writeDouble(int position, double value) {
        this.rawArray.writeDouble(position, value);
    }

    @Override // expo.modules.kotlin.typedarray.TypedArray
    public void writeFloat(int position, float value) {
        this.rawArray.writeFloat(position, value);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    @NotNull
    public Byte get(int index) {
        if (index < 0 || index >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        return Byte.valueOf(readByte(index));
    }

    public void set(int index, byte value) {
        if (index < 0 || index >= getLength()) {
            throw new IndexOutOfBoundsException();
        }
        writeByte(index, value);
    }

    public Int8Array(@NotNull JavaScriptTypedArray rawArray) {
        Intrinsics.checkNotNullParameter(rawArray, "rawArray");
        this.rawArray = rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.RawTypedArrayHolder
    @NotNull
    public JavaScriptTypedArray getRawArray() {
        return this.rawArray;
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray, java.lang.Iterable
    @NotNull
    public Iterator<Byte> iterator() {
        return GenericTypedArray.DefaultImpls.iterator(this);
    }

    @Override // expo.modules.kotlin.typedarray.GenericTypedArray
    public /* bridge */ /* synthetic */ void set(int i, Byte b) {
        set(i, b.byteValue());
    }
}
