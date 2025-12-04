package com.allegion.altranslation;

import androidx.exifinterface.media.ExifInterface;
import com.allegion.altranslation.interfaces.IAlJsonUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/allegion/altranslation/AlJsonUtility;", "Lcom/allegion/altranslation/interfaces/IAlJsonUtility;", "()V", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "fromJson", ExifInterface.GPS_DIRECTION_TRUE, "jsonBody", "", "object", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJson", "", "Companion", "AlTranslation_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlJsonUtility implements IAlJsonUtility {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FAILURE_JSON_PARSE = AlJson.EXCEPTION_JSON_PARSING;

    @NotNull
    private static final String FAILURE_NULL_OBJECT = "Null object provided";
    private final ObjectMapper mapper = new ObjectMapper();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/allegion/altranslation/AlJsonUtility$Companion;", "", "()V", "FAILURE_JSON_PARSE", "", "getFAILURE_JSON_PARSE$AlTranslation_release", "()Ljava/lang/String;", "FAILURE_NULL_OBJECT", "getFAILURE_NULL_OBJECT$AlTranslation_release", "AlTranslation_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getFAILURE_JSON_PARSE$AlTranslation_release() {
            return AlJsonUtility.FAILURE_JSON_PARSE;
        }

        @NotNull
        public final String getFAILURE_NULL_OBJECT$AlTranslation_release() {
            return AlJsonUtility.FAILURE_NULL_OBJECT;
        }
    }

    @Override // com.allegion.altranslation.interfaces.IAlJsonUtility
    @NotNull
    public String toJson(@NotNull Object object) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(object, "object");
        try {
            String strWriteValueAsString = this.mapper.writeValueAsString(object);
            Intrinsics.checkExpressionValueIsNotNull(strWriteValueAsString, "this.mapper.writeValueAsString(`object`)");
            return strWriteValueAsString;
        } catch (JsonProcessingException e) {
            throw new AlTranslationComponentException(FAILURE_JSON_PARSE, e);
        }
    }

    @Override // com.allegion.altranslation.interfaces.IAlJsonUtility
    @Nullable
    public <T> T fromJson(@NotNull String jsonBody, @NotNull Class<T> object) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(jsonBody, "jsonBody");
        Intrinsics.checkParameterIsNotNull(object, "object");
        try {
            return (T) this.mapper.readValue(jsonBody, object);
        } catch (IOException e) {
            throw new AlTranslationComponentException(FAILURE_JSON_PARSE, e);
        }
    }
}
