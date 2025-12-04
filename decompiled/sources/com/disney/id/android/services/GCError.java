package com.disney.id.android.services;

import androidx.annotation.Keep;
import com.google.gson.JsonElement;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003Jg\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00066"}, d2 = {"Lcom/disney/id/android/services/GCError;", "", "code", "", "category", "inputName", "errorId", "timestamp", "Ljava/util/Date;", "data", "Lcom/google/gson/JsonElement;", "developerMessage", "content", "Lcom/disney/id/android/services/GCErrorContent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/google/gson/JsonElement;Ljava/lang/String;Lcom/disney/id/android/services/GCErrorContent;)V", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "getCode", "setCode", "getContent", "()Lcom/disney/id/android/services/GCErrorContent;", "setContent", "(Lcom/disney/id/android/services/GCErrorContent;)V", "getData", "()Lcom/google/gson/JsonElement;", "setData", "(Lcom/google/gson/JsonElement;)V", "getDeveloperMessage", "setDeveloperMessage", "getErrorId", "setErrorId", "getInputName", "setInputName", "getTimestamp", "()Ljava/util/Date;", "setTimestamp", "(Ljava/util/Date;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GCError {

    @Nullable
    private String category;

    @Nullable
    private String code;

    @NotNull
    private GCErrorContent content;

    @Nullable
    private JsonElement data;

    @Nullable
    private String developerMessage;

    @Nullable
    private String errorId;

    @Nullable
    private String inputName;

    @Nullable
    private Date timestamp;

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getInputName() {
        return this.inputName;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getErrorId() {
        return this.errorId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Date getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final JsonElement getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getDeveloperMessage() {
        return this.developerMessage;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final GCErrorContent getContent() {
        return this.content;
    }

    @NotNull
    public final GCError copy(@Nullable String code, @Nullable String category, @Nullable String inputName, @Nullable String errorId, @Nullable Date timestamp, @Nullable JsonElement data, @Nullable String developerMessage, @NotNull GCErrorContent content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new GCError(code, category, inputName, errorId, timestamp, data, developerMessage, content);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GCError)) {
            return false;
        }
        GCError gCError = (GCError) other;
        return Intrinsics.areEqual(this.code, gCError.code) && Intrinsics.areEqual(this.category, gCError.category) && Intrinsics.areEqual(this.inputName, gCError.inputName) && Intrinsics.areEqual(this.errorId, gCError.errorId) && Intrinsics.areEqual(this.timestamp, gCError.timestamp) && Intrinsics.areEqual(this.data, gCError.data) && Intrinsics.areEqual(this.developerMessage, gCError.developerMessage) && Intrinsics.areEqual(this.content, gCError.content);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.category;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.inputName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.errorId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Date date = this.timestamp;
        int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        JsonElement jsonElement = this.data;
        int iHashCode6 = (iHashCode5 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        String str5 = this.developerMessage;
        return ((iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "GCError(code=" + this.code + ", category=" + this.category + ", inputName=" + this.inputName + ", errorId=" + this.errorId + ", timestamp=" + this.timestamp + ", data=" + this.data + ", developerMessage=" + this.developerMessage + ", content=" + this.content + ")";
    }

    public GCError(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Date date, @Nullable JsonElement jsonElement, @Nullable String str5, @NotNull GCErrorContent content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.code = str;
        this.category = str2;
        this.inputName = str3;
        this.errorId = str4;
        this.timestamp = date;
        this.data = jsonElement;
        this.developerMessage = str5;
        this.content = content;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(@Nullable String str) {
        this.category = str;
    }

    @Nullable
    public final String getInputName() {
        return this.inputName;
    }

    public final void setInputName(@Nullable String str) {
        this.inputName = str;
    }

    @Nullable
    public final String getErrorId() {
        return this.errorId;
    }

    public final void setErrorId(@Nullable String str) {
        this.errorId = str;
    }

    @Nullable
    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(@Nullable Date date) {
        this.timestamp = date;
    }

    @Nullable
    public final JsonElement getData() {
        return this.data;
    }

    public final void setData(@Nullable JsonElement jsonElement) {
        this.data = jsonElement;
    }

    @Nullable
    public final String getDeveloperMessage() {
        return this.developerMessage;
    }

    public final void setDeveloperMessage(@Nullable String str) {
        this.developerMessage = str;
    }

    @NotNull
    public final GCErrorContent getContent() {
        return this.content;
    }

    public final void setContent(@NotNull GCErrorContent gCErrorContent) {
        Intrinsics.checkNotNullParameter(gCErrorContent, "<set-?>");
        this.content = gCErrorContent;
    }
}
