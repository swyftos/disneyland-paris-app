package expo.modules.kotlin.typedarray;

import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.actions.ToastAction;
import expo.modules.kotlin.jni.TypedArrayKind;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0007H&J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0018H&J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001aH&J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H&J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001dH&J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001fH&J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010#\u001a\u00020!H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006)"}, m1836d2 = {"Lexpo/modules/kotlin/typedarray/TypedArray;", "", "kind", "Lexpo/modules/kotlin/jni/TypedArrayKind;", "getKind", "()Lexpo/modules/kotlin/jni/TypedArrayKind;", ToastAction.LENGTH_KEY, "", "getLength", "()I", "byteLength", "getByteLength", "byteOffset", "getByteOffset", "toDirectBuffer", "Ljava/nio/ByteBuffer;", "read", "", "buffer", "", ViewProps.POSITION, TCEventPropertiesNames.TCP_SIZE, "write", "readByte", "", "read2Byte", "", "read4Byte", "read8Byte", "", "readFloat", "", "readDouble", "", "writeByte", "value", "write2Byte", "write4Byte", "write8Byte", "writeFloat", "writeDouble", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface TypedArray {
    int getByteLength();

    int getByteOffset();

    @NotNull
    TypedArrayKind getKind();

    int getLength();

    void read(@NotNull byte[] buffer, int position, int size);

    short read2Byte(int position);

    int read4Byte(int position);

    long read8Byte(int position);

    byte readByte(int position);

    double readDouble(int position);

    float readFloat(int position);

    @NotNull
    ByteBuffer toDirectBuffer();

    void write(@NotNull byte[] buffer, int position, int size);

    void write2Byte(int position, short value);

    void write4Byte(int position, int value);

    void write8Byte(int position, long value);

    void writeByte(int position, byte value);

    void writeDouble(int position, double value);

    void writeFloat(int position, float value);
}
