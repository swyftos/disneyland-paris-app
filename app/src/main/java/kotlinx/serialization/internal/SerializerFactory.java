package kotlinx.serialization.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(level = DeprecationLevel.HIDDEN, message = "Inserted into generated code and should not be used directly")
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u001a\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0005\"\u0006\u0012\u0002\b\u00030\u0003H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1836d2 = {"Lkotlinx/serialization/internal/SerializerFactory;", "", "serializer", "Lkotlinx/serialization/KSerializer;", "typeParamsSerializers", "", "([Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public interface SerializerFactory {
    @NotNull
    KSerializer<?> serializer(@NotNull KSerializer<?>... typeParamsSerializers);
}
