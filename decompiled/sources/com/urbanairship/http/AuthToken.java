package com.urbanairship.http;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/http/AuthToken;", "", "identifier", "", "token", "expirationDateMillis", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getExpirationDateMillis", "()J", "getIdentifier", "()Ljava/lang/String;", "getToken", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class AuthToken {
    private final long expirationDateMillis;
    private final String identifier;
    private final String token;

    public static /* synthetic */ AuthToken copy$default(AuthToken authToken, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authToken.identifier;
        }
        if ((i & 2) != 0) {
            str2 = authToken.token;
        }
        if ((i & 4) != 0) {
            j = authToken.expirationDateMillis;
        }
        return authToken.copy(str, str2, j);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component3, reason: from getter */
    public final long getExpirationDateMillis() {
        return this.expirationDateMillis;
    }

    @NotNull
    public final AuthToken copy(@NotNull String identifier, @NotNull String token, long expirationDateMillis) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(token, "token");
        return new AuthToken(identifier, token, expirationDateMillis);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthToken)) {
            return false;
        }
        AuthToken authToken = (AuthToken) other;
        return Intrinsics.areEqual(this.identifier, authToken.identifier) && Intrinsics.areEqual(this.token, authToken.token) && this.expirationDateMillis == authToken.expirationDateMillis;
    }

    public int hashCode() {
        return (((this.identifier.hashCode() * 31) + this.token.hashCode()) * 31) + Long.hashCode(this.expirationDateMillis);
    }

    @NotNull
    public String toString() {
        return "AuthToken(identifier=" + this.identifier + ", token=" + this.token + ", expirationDateMillis=" + this.expirationDateMillis + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AuthToken(@NotNull String identifier, @NotNull String token, long j) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(token, "token");
        this.identifier = identifier;
        this.token = token;
        this.expirationDateMillis = j;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public final long getExpirationDateMillis() {
        return this.expirationDateMillis;
    }
}
