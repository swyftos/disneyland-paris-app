package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0007\u001a\u00020\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m1836d2 = {"Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public interface JsonDecoder extends Decoder, CompositeDecoder {
    @NotNull
    JsonElement decodeJsonElement();

    @NotNull
    Json getJson();

    @Metadata(m1837k = 3, m1838mv = {1, 8, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        public static int decodeCollectionSize(@NotNull JsonDecoder jsonDecoder, @NotNull SerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return CompositeDecoder.DefaultImpls.decodeCollectionSize(jsonDecoder, descriptor);
        }

        @ExperimentalSerializationApi
        @Nullable
        public static <T> T decodeNullableSerializableValue(@NotNull JsonDecoder jsonDecoder, @NotNull DeserializationStrategy<? extends T> deserializer) {
            Intrinsics.checkNotNullParameter(deserializer, "deserializer");
            return (T) Decoder.DefaultImpls.decodeNullableSerializableValue(jsonDecoder, deserializer);
        }

        @ExperimentalSerializationApi
        public static boolean decodeSequentially(@NotNull JsonDecoder jsonDecoder) {
            return CompositeDecoder.DefaultImpls.decodeSequentially(jsonDecoder);
        }

        public static <T> T decodeSerializableValue(@NotNull JsonDecoder jsonDecoder, @NotNull DeserializationStrategy<? extends T> deserializer) {
            Intrinsics.checkNotNullParameter(deserializer, "deserializer");
            return (T) Decoder.DefaultImpls.decodeSerializableValue(jsonDecoder, deserializer);
        }
    }
}
