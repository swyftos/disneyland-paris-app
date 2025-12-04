package com.urbanairship.http;

import androidx.autofill.HintConstants;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/http/RequestAuth;", "", "()V", "BasicAppAuth", "BasicAuth", "BearerToken", "ChannelTokenAuth", "ContactTokenAuth", "GeneratedAppToken", "GeneratedChannelToken", "Lcom/urbanairship/http/RequestAuth$BasicAppAuth;", "Lcom/urbanairship/http/RequestAuth$BasicAuth;", "Lcom/urbanairship/http/RequestAuth$BearerToken;", "Lcom/urbanairship/http/RequestAuth$ChannelTokenAuth;", "Lcom/urbanairship/http/RequestAuth$ContactTokenAuth;", "Lcom/urbanairship/http/RequestAuth$GeneratedAppToken;", "Lcom/urbanairship/http/RequestAuth$GeneratedChannelToken;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class RequestAuth {
    public /* synthetic */ RequestAuth(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RequestAuth() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/http/RequestAuth$BasicAppAuth;", "Lcom/urbanairship/http/RequestAuth;", "()V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BasicAppAuth extends RequestAuth {

        @NotNull
        public static final BasicAppAuth INSTANCE = new BasicAppAuth();

        private BasicAppAuth() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/http/RequestAuth$BasicAuth;", "Lcom/urbanairship/http/RequestAuth;", TCEventPropertiesNames.TCE_USER, "", HintConstants.AUTOFILL_HINT_PASSWORD, "(Ljava/lang/String;Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "getUser", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class BasicAuth extends RequestAuth {
        private final String password;
        private final String user;

        public static /* synthetic */ BasicAuth copy$default(BasicAuth basicAuth, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = basicAuth.user;
            }
            if ((i & 2) != 0) {
                str2 = basicAuth.password;
            }
            return basicAuth.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUser() {
            return this.user;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        @NotNull
        public final BasicAuth copy(@NotNull String user, @NotNull String password) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(password, "password");
            return new BasicAuth(user, password);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BasicAuth)) {
                return false;
            }
            BasicAuth basicAuth = (BasicAuth) other;
            return Intrinsics.areEqual(this.user, basicAuth.user) && Intrinsics.areEqual(this.password, basicAuth.password);
        }

        public int hashCode() {
            return (this.user.hashCode() * 31) + this.password.hashCode();
        }

        @NotNull
        public String toString() {
            return "BasicAuth(user=" + this.user + ", password=" + this.password + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BasicAuth(@NotNull String user, @NotNull String password) {
            super(null);
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(password, "password");
            this.user = user;
            this.password = password;
        }

        @NotNull
        public final String getPassword() {
            return this.password;
        }

        @NotNull
        public final String getUser() {
            return this.user;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/http/RequestAuth$GeneratedAppToken;", "Lcom/urbanairship/http/RequestAuth;", "()V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GeneratedAppToken extends RequestAuth {

        @NotNull
        public static final GeneratedAppToken INSTANCE = new GeneratedAppToken();

        private GeneratedAppToken() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/http/RequestAuth$GeneratedChannelToken;", "Lcom/urbanairship/http/RequestAuth;", "channelId", "", "(Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GeneratedChannelToken extends RequestAuth {
        private final String channelId;

        public static /* synthetic */ GeneratedChannelToken copy$default(GeneratedChannelToken generatedChannelToken, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = generatedChannelToken.channelId;
            }
            return generatedChannelToken.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final GeneratedChannelToken copy(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new GeneratedChannelToken(channelId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GeneratedChannelToken) && Intrinsics.areEqual(this.channelId, ((GeneratedChannelToken) other).channelId);
        }

        public int hashCode() {
            return this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "GeneratedChannelToken(channelId=" + this.channelId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GeneratedChannelToken(@NotNull String channelId) {
            super(null);
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.channelId = channelId;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/http/RequestAuth$ChannelTokenAuth;", "Lcom/urbanairship/http/RequestAuth;", "channelId", "", "(Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChannelTokenAuth extends RequestAuth {
        private final String channelId;

        public static /* synthetic */ ChannelTokenAuth copy$default(ChannelTokenAuth channelTokenAuth, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelTokenAuth.channelId;
            }
            return channelTokenAuth.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final ChannelTokenAuth copy(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new ChannelTokenAuth(channelId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChannelTokenAuth) && Intrinsics.areEqual(this.channelId, ((ChannelTokenAuth) other).channelId);
        }

        public int hashCode() {
            return this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelTokenAuth(channelId=" + this.channelId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelTokenAuth(@NotNull String channelId) {
            super(null);
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.channelId = channelId;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/http/RequestAuth$ContactTokenAuth;", "Lcom/urbanairship/http/RequestAuth;", "contactId", "", "(Ljava/lang/String;)V", "getContactId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ContactTokenAuth extends RequestAuth {
        private final String contactId;

        public static /* synthetic */ ContactTokenAuth copy$default(ContactTokenAuth contactTokenAuth, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contactTokenAuth.contactId;
            }
            return contactTokenAuth.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getContactId() {
            return this.contactId;
        }

        @NotNull
        public final ContactTokenAuth copy(@NotNull String contactId) {
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            return new ContactTokenAuth(contactId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ContactTokenAuth) && Intrinsics.areEqual(this.contactId, ((ContactTokenAuth) other).contactId);
        }

        public int hashCode() {
            return this.contactId.hashCode();
        }

        @NotNull
        public String toString() {
            return "ContactTokenAuth(contactId=" + this.contactId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactTokenAuth(@NotNull String contactId) {
            super(null);
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            this.contactId = contactId;
        }

        @NotNull
        public final String getContactId() {
            return this.contactId;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/http/RequestAuth$BearerToken;", "Lcom/urbanairship/http/RequestAuth;", "token", "", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class BearerToken extends RequestAuth {
        private final String token;

        public static /* synthetic */ BearerToken copy$default(BearerToken bearerToken, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bearerToken.token;
            }
            return bearerToken.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        @NotNull
        public final BearerToken copy(@NotNull String token) {
            Intrinsics.checkNotNullParameter(token, "token");
            return new BearerToken(token);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BearerToken) && Intrinsics.areEqual(this.token, ((BearerToken) other).token);
        }

        public int hashCode() {
            return this.token.hashCode();
        }

        @NotNull
        public String toString() {
            return "BearerToken(token=" + this.token + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BearerToken(@NotNull String token) {
            super(null);
            Intrinsics.checkNotNullParameter(token, "token");
            this.token = token;
        }

        @NotNull
        public final String getToken() {
            return this.token;
        }
    }
}
