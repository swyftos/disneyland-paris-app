package com.disney.id.android;

import androidx.annotation.Keep;
import ch.qos.logback.core.joran.action.Action;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0001IB¹\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\r\u0010>\u001a\u00020\u0000H\u0000¢\u0006\u0002\b?Jæ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\r\u0010D\u001a\u00020\u0000H\u0000¢\u0006\u0002\bEJ\t\u0010F\u001a\u00020GHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0018R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b!\u0010\u0018R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\"\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b$\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b&\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b(\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001b¨\u0006J"}, d2 = {"Lcom/disney/id/android/Token;", "", OneIDRecoveryContext.ACCESS_TOKEN, "", "refreshToken", "swid", "accessTokenTTL", "", "refreshTokenTTL", "highTrustTTL", "initialGrantInChain", Action.SCOPE_ATTRIBUTE, "idToken", "authenticator", "loginValue", "clickbackType", "sessionTransferKey", "clientId", "iat", "accessExp", "refreshExp", "highTrustExp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getAccessExp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAccessToken", "()Ljava/lang/String;", "getAccessTokenTTL", "getAuthenticator", "getClickbackType", "getClientId", "getHighTrustExp", "getHighTrustTTL", "getIat", "getIdToken", "getInitialGrantInChain", "getLoginValue", "getRefreshExp", "getRefreshToken", "getRefreshTokenTTL", "getScope", "getSessionTransferKey", "getSwid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy$OneID_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/disney/id/android/Token;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "exposedCopy", "exposedCopy$OneID_release", "hashCode", "", "toString", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Token {

    @NotNull
    public static final String ACCESS_TOKEN = "access_token";

    @NotNull
    public static final String SWID = "swid";

    @SerializedName("exp")
    @Nullable
    private final Long accessExp;

    @SerializedName(ACCESS_TOKEN)
    @Nullable
    private final String accessToken;

    @SerializedName(Constants.FirelogAnalytics.PARAM_TTL)
    @Nullable
    private final Long accessTokenTTL;

    @Nullable
    private final String authenticator;

    @Nullable
    private final String clickbackType;

    @SerializedName(OneIDTrackerEvent.EVENT_PARAM_CLIENT_ID)
    @Nullable
    private final String clientId;

    @SerializedName("high_trust_exp")
    @Nullable
    private final Long highTrustExp;

    @SerializedName("high_trust_expires_in")
    @Nullable
    private final Long highTrustTTL;

    @SerializedName("iat")
    @Nullable
    private final Long iat;

    @SerializedName(OneIDTrackerEvent.EVENT_PARAM_ID_TOKEN)
    @Nullable
    private final String idToken;

    @SerializedName("initial_grant_in_chain_time")
    @Nullable
    private final Long initialGrantInChain;

    @Nullable
    private final String loginValue;

    @SerializedName("refresh_exp")
    @Nullable
    private final Long refreshExp;

    @SerializedName("refresh_token")
    @Nullable
    private final String refreshToken;

    @SerializedName("refresh_ttl")
    @Nullable
    private final Long refreshTokenTTL;

    @Nullable
    private final String scope;

    @Nullable
    private final String sessionTransferKey;

    @Nullable
    private final String swid;

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getAuthenticator() {
        return this.authenticator;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getLoginValue() {
        return this.loginValue;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getClickbackType() {
        return this.clickbackType;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getSessionTransferKey() {
        return this.sessionTransferKey;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Long getIat() {
        return this.iat;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Long getAccessExp() {
        return this.accessExp;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Long getRefreshExp() {
        return this.refreshExp;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Long getHighTrustExp() {
        return this.highTrustExp;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSwid() {
        return this.swid;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getAccessTokenTTL() {
        return this.accessTokenTTL;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getRefreshTokenTTL() {
        return this.refreshTokenTTL;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getHighTrustTTL() {
        return this.highTrustTTL;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getInitialGrantInChain() {
        return this.initialGrantInChain;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getIdToken() {
        return this.idToken;
    }

    @NotNull
    public final Token copy(@Nullable String accessToken, @Nullable String refreshToken, @Nullable String swid, @Nullable Long accessTokenTTL, @Nullable Long refreshTokenTTL, @Nullable Long highTrustTTL, @Nullable Long initialGrantInChain, @Nullable String scope, @Nullable String idToken, @Nullable String authenticator, @Nullable String loginValue, @Nullable String clickbackType, @Nullable String sessionTransferKey, @Nullable String clientId, @Nullable Long iat, @Nullable Long accessExp, @Nullable Long refreshExp, @Nullable Long highTrustExp) {
        return new Token(accessToken, refreshToken, swid, accessTokenTTL, refreshTokenTTL, highTrustTTL, initialGrantInChain, scope, idToken, authenticator, loginValue, clickbackType, sessionTransferKey, clientId, iat, accessExp, refreshExp, highTrustExp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Token)) {
            return false;
        }
        Token token = (Token) other;
        return Intrinsics.areEqual(this.accessToken, token.accessToken) && Intrinsics.areEqual(this.refreshToken, token.refreshToken) && Intrinsics.areEqual(this.swid, token.swid) && Intrinsics.areEqual(this.accessTokenTTL, token.accessTokenTTL) && Intrinsics.areEqual(this.refreshTokenTTL, token.refreshTokenTTL) && Intrinsics.areEqual(this.highTrustTTL, token.highTrustTTL) && Intrinsics.areEqual(this.initialGrantInChain, token.initialGrantInChain) && Intrinsics.areEqual(this.scope, token.scope) && Intrinsics.areEqual(this.idToken, token.idToken) && Intrinsics.areEqual(this.authenticator, token.authenticator) && Intrinsics.areEqual(this.loginValue, token.loginValue) && Intrinsics.areEqual(this.clickbackType, token.clickbackType) && Intrinsics.areEqual(this.sessionTransferKey, token.sessionTransferKey) && Intrinsics.areEqual(this.clientId, token.clientId) && Intrinsics.areEqual(this.iat, token.iat) && Intrinsics.areEqual(this.accessExp, token.accessExp) && Intrinsics.areEqual(this.refreshExp, token.refreshExp) && Intrinsics.areEqual(this.highTrustExp, token.highTrustExp);
    }

    public int hashCode() {
        String str = this.accessToken;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.refreshToken;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.swid;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.accessTokenTTL;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.refreshTokenTTL;
        int iHashCode5 = (iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.highTrustTTL;
        int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.initialGrantInChain;
        int iHashCode7 = (iHashCode6 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str4 = this.scope;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.idToken;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.authenticator;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.loginValue;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.clickbackType;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.sessionTransferKey;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.clientId;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Long l5 = this.iat;
        int iHashCode15 = (iHashCode14 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Long l6 = this.accessExp;
        int iHashCode16 = (iHashCode15 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.refreshExp;
        int iHashCode17 = (iHashCode16 + (l7 == null ? 0 : l7.hashCode())) * 31;
        Long l8 = this.highTrustExp;
        return iHashCode17 + (l8 != null ? l8.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Token(accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ", swid=" + this.swid + ", accessTokenTTL=" + this.accessTokenTTL + ", refreshTokenTTL=" + this.refreshTokenTTL + ", highTrustTTL=" + this.highTrustTTL + ", initialGrantInChain=" + this.initialGrantInChain + ", scope=" + this.scope + ", idToken=" + this.idToken + ", authenticator=" + this.authenticator + ", loginValue=" + this.loginValue + ", clickbackType=" + this.clickbackType + ", sessionTransferKey=" + this.sessionTransferKey + ", clientId=" + this.clientId + ", iat=" + this.iat + ", accessExp=" + this.accessExp + ", refreshExp=" + this.refreshExp + ", highTrustExp=" + this.highTrustExp + ")";
    }

    public Token(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Long l5, @Nullable Long l6, @Nullable Long l7, @Nullable Long l8) {
        this.accessToken = str;
        this.refreshToken = str2;
        this.swid = str3;
        this.accessTokenTTL = l;
        this.refreshTokenTTL = l2;
        this.highTrustTTL = l3;
        this.initialGrantInChain = l4;
        this.scope = str4;
        this.idToken = str5;
        this.authenticator = str6;
        this.loginValue = str7;
        this.clickbackType = str8;
        this.sessionTransferKey = str9;
        this.clientId = str10;
        this.iat = l5;
        this.accessExp = l6;
        this.refreshExp = l7;
        this.highTrustExp = l8;
    }

    @Nullable
    public final String getAccessToken() {
        return this.accessToken;
    }

    @Nullable
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @Nullable
    public final String getSwid() {
        return this.swid;
    }

    @Nullable
    public final Long getAccessTokenTTL() {
        return this.accessTokenTTL;
    }

    @Nullable
    public final Long getRefreshTokenTTL() {
        return this.refreshTokenTTL;
    }

    @Nullable
    public final Long getHighTrustTTL() {
        return this.highTrustTTL;
    }

    @Nullable
    public final Long getInitialGrantInChain() {
        return this.initialGrantInChain;
    }

    @Nullable
    public final String getScope() {
        return this.scope;
    }

    @Nullable
    public final String getIdToken() {
        return this.idToken;
    }

    @Nullable
    public final String getAuthenticator() {
        return this.authenticator;
    }

    @Nullable
    public final String getLoginValue() {
        return this.loginValue;
    }

    @Nullable
    public final String getClickbackType() {
        return this.clickbackType;
    }

    @Nullable
    public final String getSessionTransferKey() {
        return this.sessionTransferKey;
    }

    @Nullable
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    public final Long getIat() {
        return this.iat;
    }

    @Nullable
    public final Long getAccessExp() {
        return this.accessExp;
    }

    @Nullable
    public final Long getRefreshExp() {
        return this.refreshExp;
    }

    @Nullable
    public final Long getHighTrustExp() {
        return this.highTrustExp;
    }

    @NotNull
    public final Token copy$OneID_release() {
        return new Token(this.accessToken, this.refreshToken, this.swid, this.accessTokenTTL, this.refreshTokenTTL, this.highTrustTTL, this.initialGrantInChain, this.scope, this.idToken, this.authenticator, this.loginValue, this.clickbackType, this.sessionTransferKey, this.clientId, this.iat, this.accessExp, this.refreshExp, this.highTrustExp);
    }

    @NotNull
    public final Token exposedCopy$OneID_release() {
        return new Token(this.accessToken, null, this.swid, this.accessTokenTTL, this.refreshTokenTTL, this.highTrustTTL, this.initialGrantInChain, this.scope, this.idToken, this.authenticator, this.loginValue, this.clickbackType, this.sessionTransferKey, this.clientId, this.iat, this.accessExp, this.refreshExp, this.highTrustExp);
    }
}
