package com.allegion.altranslation.interfaces;

import androidx.exifinterface.media.ExifInterface;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\n"}, d2 = {"Lcom/allegion/altranslation/interfaces/IAlJsonUtility;", "", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "jsonBody", "", "object", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJson", "AlTranslation_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlJsonUtility {
    @Nullable
    <T> T fromJson(@NotNull String jsonBody, @NotNull Class<T> object) throws AlTranslationComponentException;

    @NotNull
    String toJson(@NotNull Object object) throws AlTranslationComponentException;
}
