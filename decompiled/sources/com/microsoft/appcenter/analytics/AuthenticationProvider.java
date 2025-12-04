package com.microsoft.appcenter.analytics;

import com.facebook.common.callercontext.ContextChain;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HashUtils;
import com.microsoft.appcenter.utils.TicketCache;
import com.urbanairship.audience.AudienceOverridesProvider;
import java.util.Date;

/* loaded from: classes4.dex */
public class AuthenticationProvider {
    private AuthenticationCallback mCallback;
    private Date mExpiryDate;
    private final String mTicketKey;
    private final String mTicketKeyHash;
    private final TokenProvider mTokenProvider;
    private final Type mType;

    public interface AuthenticationCallback {
        void onAuthenticationResult(String str, Date date);
    }

    public interface TokenProvider {
        void acquireToken(String str, AuthenticationCallback authenticationCallback);
    }

    public AuthenticationProvider(Type type, String str, TokenProvider tokenProvider) {
        this.mType = type;
        this.mTicketKey = str;
        this.mTicketKeyHash = str == null ? null : HashUtils.sha256(str);
        this.mTokenProvider = tokenProvider;
    }

    Type getType() {
        return this.mType;
    }

    String getTicketKey() {
        return this.mTicketKey;
    }

    String getTicketKeyHash() {
        return this.mTicketKeyHash;
    }

    TokenProvider getTokenProvider() {
        return this.mTokenProvider;
    }

    synchronized void acquireTokenAsync() {
        if (this.mCallback != null) {
            return;
        }
        AppCenterLog.debug(Analytics.LOG_TAG, "Calling token provider=" + this.mType + " callback.");
        AuthenticationCallback authenticationCallback = new AuthenticationCallback() { // from class: com.microsoft.appcenter.analytics.AuthenticationProvider.1
            @Override // com.microsoft.appcenter.analytics.AuthenticationProvider.AuthenticationCallback
            public void onAuthenticationResult(String str, Date date) {
                AuthenticationProvider.this.handleTokenUpdate(str, date, this);
            }
        };
        this.mCallback = authenticationCallback;
        this.mTokenProvider.acquireToken(this.mTicketKey, authenticationCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleTokenUpdate(String str, Date date, AuthenticationCallback authenticationCallback) {
        if (this.mCallback != authenticationCallback) {
            AppCenterLog.debug(Analytics.LOG_TAG, "Ignore duplicate authentication callback calls, provider=" + this.mType);
            return;
        }
        this.mCallback = null;
        AppCenterLog.debug(Analytics.LOG_TAG, "Got result back from token provider=" + this.mType);
        if (str == null) {
            AppCenterLog.error(Analytics.LOG_TAG, "Authentication failed for ticketKey=" + this.mTicketKey);
            return;
        }
        if (date == null) {
            AppCenterLog.error(Analytics.LOG_TAG, "No expiry date provided for ticketKey=" + this.mTicketKey);
            return;
        }
        TicketCache.putTicket(this.mTicketKeyHash, this.mType.mTokenPrefix + str);
        this.mExpiryDate = date;
    }

    synchronized void checkTokenExpiry() {
        Date date = this.mExpiryDate;
        if (date != null && date.getTime() <= System.currentTimeMillis() + AudienceOverridesProvider.EXPIRY_MS) {
            acquireTokenAsync();
        }
    }

    public enum Type {
        MSA_COMPACT(ContextChain.TAG_PRODUCT),
        MSA_DELEGATE("d");

        private final String mTokenPrefix;

        Type(String str) {
            this.mTokenPrefix = str + ":";
        }
    }
}
