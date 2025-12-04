package com.allegion.altranslation;

import androidx.exifinterface.media.ExifInterface;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u00012\u0006\u0010\u0007\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\bJ+\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/allegion/altranslation/AlJson;", "", "()V", "EXCEPTION_JSON_PARSING", "", "parseJson", ExifInterface.GPS_DIRECTION_TRUE, "jsonBody", "(Ljava/lang/String;)Ljava/lang/Object;", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJson", "obj", "AlTranslation_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlJson {

    @NotNull
    public static final String EXCEPTION_JSON_PARSING = "Failed parsing JSON data";
    public static final AlJson INSTANCE = new AlJson();

    private AlJson() {
    }

    @JvmStatic
    @NotNull
    public static final String toJson(@Nullable Object obj) throws AlTranslationComponentException {
        try {
            String strWriteValueAsString = new ObjectMapper().writeValueAsString(obj);
            Intrinsics.checkExpressionValueIsNotNull(strWriteValueAsString, "mapper.writeValueAsString(obj)");
            return strWriteValueAsString;
        } catch (JsonProcessingException e) {
            throw new AlTranslationComponentException(EXCEPTION_JSON_PARSING, e);
        }
    }

    @JvmStatic
    @Nullable
    public static final <T> T parseJson(@NotNull String jsonBody, @NotNull Class<T> type) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(jsonBody, "jsonBody");
        Intrinsics.checkParameterIsNotNull(type, "type");
        try {
            return (T) new ObjectMapper().readValue(jsonBody, type);
        } catch (IOException e) {
            throw new AlTranslationComponentException(EXCEPTION_JSON_PARSING, e);
        }
    }

    @JvmStatic
    @Nullable
    public static final /* synthetic */ <T> T parseJson(@NotNull String jsonBody) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(jsonBody, "jsonBody");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objectMapper.readValue(jsonBody, Object.class);
        } catch (IOException e) {
            throw new AlTranslationComponentException(EXCEPTION_JSON_PARSING, e);
        }
    }
}
