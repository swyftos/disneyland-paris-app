package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.ExperimentalSerializationApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H'¨\u0006\n"}, d2 = {"Lkotlinx/serialization/encoding/ChunkedDecoder;", "", "decodeStringChunked", "", "consumeChunk", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "chunk", "kotlinx-serialization-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalSerializationApi
/* loaded from: classes6.dex */
public interface ChunkedDecoder {
    @ExperimentalSerializationApi
    void decodeStringChunked(@NotNull Function1<? super String, Unit> consumeChunk);
}
