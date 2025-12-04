package com.disney.id.android.services;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001e\u001a\u00020\u0003J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/disney/id/android/services/GCResponseError;", "", "keyCategory", "", "transactionId", "conversationId", "errors", "", "Lcom/disney/id/android/services/GCError;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "getErrors", "()Ljava/util/List;", "setErrors", "(Ljava/util/List;)V", "getKeyCategory", "setKeyCategory", "getTransactionId", "setTransactionId", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "getKeyErrorCode", "getKeyErrorMessage", "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGCResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GCResponse.kt\ncom/disney/id/android/services/GCResponseError\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,78:1\n766#2:79\n857#2,2:80\n766#2:82\n857#2,2:83\n*S KotlinDebug\n*F\n+ 1 GCResponse.kt\ncom/disney/id/android/services/GCResponseError\n*L\n41#1:79\n41#1:80,2\n48#1:82\n48#1:83,2\n*E\n"})
/* loaded from: classes3.dex */
public final /* data */ class GCResponseError {

    @SerializedName("conversationId")
    @Nullable
    private String conversationId;

    @Nullable
    private List<GCError> errors;

    @Nullable
    private String keyCategory;

    @SerializedName("correlationId")
    @Nullable
    private String transactionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GCResponseError copy$default(GCResponseError gCResponseError, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gCResponseError.keyCategory;
        }
        if ((i & 2) != 0) {
            str2 = gCResponseError.transactionId;
        }
        if ((i & 4) != 0) {
            str3 = gCResponseError.conversationId;
        }
        if ((i & 8) != 0) {
            list = gCResponseError.errors;
        }
        return gCResponseError.copy(str, str2, str3, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getKeyCategory() {
        return this.keyCategory;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    @Nullable
    public final List<GCError> component4() {
        return this.errors;
    }

    @NotNull
    public final GCResponseError copy(@Nullable String keyCategory, @Nullable String transactionId, @Nullable String conversationId, @Nullable List<GCError> errors) {
        return new GCResponseError(keyCategory, transactionId, conversationId, errors);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GCResponseError)) {
            return false;
        }
        GCResponseError gCResponseError = (GCResponseError) other;
        return Intrinsics.areEqual(this.keyCategory, gCResponseError.keyCategory) && Intrinsics.areEqual(this.transactionId, gCResponseError.transactionId) && Intrinsics.areEqual(this.conversationId, gCResponseError.conversationId) && Intrinsics.areEqual(this.errors, gCResponseError.errors);
    }

    public int hashCode() {
        String str = this.keyCategory;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.transactionId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.conversationId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<GCError> list = this.errors;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GCResponseError(keyCategory=" + this.keyCategory + ", transactionId=" + this.transactionId + ", conversationId=" + this.conversationId + ", errors=" + this.errors + ")";
    }

    public GCResponseError(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<GCError> list) {
        this.keyCategory = str;
        this.transactionId = str2;
        this.conversationId = str3;
        this.errors = list;
    }

    @Nullable
    public final String getKeyCategory() {
        return this.keyCategory;
    }

    public final void setKeyCategory(@Nullable String str) {
        this.keyCategory = str;
    }

    @Nullable
    public final String getTransactionId() {
        return this.transactionId;
    }

    public final void setTransactionId(@Nullable String str) {
        this.transactionId = str;
    }

    @Nullable
    public final String getConversationId() {
        return this.conversationId;
    }

    public final void setConversationId(@Nullable String str) {
        this.conversationId = str;
    }

    @Nullable
    public final List<GCError> getErrors() {
        return this.errors;
    }

    public final void setErrors(@Nullable List<GCError> list) {
        this.errors = list;
    }

    @NotNull
    public final String getKeyErrorCode() {
        String code;
        List<GCError> list = this.errors;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (Intrinsics.areEqual(((GCError) obj).getCategory(), this.keyCategory)) {
                    arrayList.add(obj);
                }
            }
            GCError gCError = (GCError) arrayList.get(0);
            if (gCError != null && (code = gCError.getCode()) != null) {
                return code;
            }
        }
        return "UNKNOWN_ERROR";
    }

    @Nullable
    public final String getKeyErrorMessage() {
        GCError gCError;
        GCErrorContent content;
        String developerMessage;
        List<GCError> list = this.errors;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (Intrinsics.areEqual(((GCError) obj).getCategory(), this.keyCategory)) {
                    arrayList.add(obj);
                }
            }
            gCError = (GCError) arrayList.get(0);
        } else {
            gCError = null;
        }
        if (gCError != null && (developerMessage = gCError.getDeveloperMessage()) != null) {
            return developerMessage;
        }
        if (gCError == null || (content = gCError.getContent()) == null) {
            return null;
        }
        return content.getText();
    }
}
