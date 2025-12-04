package com.allegion.altranslation.interfaces;

import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H&¨\u0006\f"}, d2 = {"Lcom/allegion/altranslation/interfaces/IAlCborUtility;", "", "fromCbor", "cborData", "", "object", "Ljava/lang/Class;", "getCborGenerator", "Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "stream", "Ljava/io/ByteArrayOutputStream;", "toCbor", "AlTranslation_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlCborUtility {
    @Nullable
    Object fromCbor(@NotNull byte[] cborData, @NotNull Class<?> object) throws AlTranslationComponentException;

    @NotNull
    CBORGenerator getCborGenerator(@NotNull ByteArrayOutputStream stream) throws AlTranslationComponentException;

    @NotNull
    byte[] toCbor(@NotNull Object object) throws AlTranslationComponentException;
}
