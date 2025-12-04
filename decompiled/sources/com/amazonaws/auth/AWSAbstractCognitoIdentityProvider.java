package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.GetIdRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class AWSAbstractCognitoIdentityProvider implements AWSCognitoIdentityProvider {
    private final String accountId;
    protected final AmazonCognitoIdentity cib;
    protected String identityId;
    private final String identityPoolId;
    protected List<IdentityChangedListener> listeners;
    protected Map<String, String> loginsMap;
    protected String token;

    public abstract String getProviderName();

    public AWSAbstractCognitoIdentityProvider(String str, String str2, AmazonCognitoIdentity amazonCognitoIdentity) {
        this.accountId = str;
        this.identityPoolId = str2;
        this.loginsMap = new HashMap();
        this.listeners = new ArrayList();
        this.cib = amazonCognitoIdentity;
    }

    @Deprecated
    public AWSAbstractCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration) {
        this(str, str2, new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration));
    }

    public AWSAbstractCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration, Regions regions) throws IllegalArgumentException {
        this(str, str2, new AmazonCognitoIdentityClient(new AnonymousAWSCredentials(), clientConfiguration));
        this.cib.setRegion(Region.getRegion(regions));
    }

    @Deprecated
    public AWSAbstractCognitoIdentityProvider(String str, String str2) {
        this(str, str2, new ClientConfiguration());
    }

    public AWSAbstractCognitoIdentityProvider(String str, String str2, Regions regions) {
        this(str, str2, new ClientConfiguration(), regions);
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public String getIdentityId() throws AmazonClientException {
        if (this.identityId == null) {
            GetIdRequest getIdRequestWithLogins = new GetIdRequest().withAccountId(getAccountId()).withIdentityPoolId(getIdentityPoolId()).withLogins(this.loginsMap);
            appendUserAgent(getIdRequestWithLogins, getUserAgent());
            GetIdResult id = this.cib.getId(getIdRequestWithLogins);
            if (id.getIdentityId() != null) {
                identityChanged(id.getIdentityId());
            }
        }
        return this.identityId;
    }

    protected void setIdentityId(String str) {
        this.identityId = str;
    }

    @Override // com.amazonaws.auth.AWSIdentityProvider
    public String getToken() throws AmazonClientException {
        if (this.token == null) {
            GetOpenIdTokenRequest getOpenIdTokenRequestWithLogins = new GetOpenIdTokenRequest().withIdentityId(getIdentityId()).withLogins(this.loginsMap);
            appendUserAgent(getOpenIdTokenRequestWithLogins, getUserAgent());
            GetOpenIdTokenResult openIdToken = this.cib.getOpenIdToken(getOpenIdTokenRequestWithLogins);
            if (!openIdToken.getIdentityId().equals(getIdentityId())) {
                identityChanged(openIdToken.getIdentityId());
            }
            this.token = openIdToken.getToken();
        }
        return this.token;
    }

    protected void setToken(String str) {
        this.token = str;
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public Map<String, String> getLogins() {
        return this.loginsMap;
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public void setLogins(Map<String, String> map) {
        this.loginsMap = map;
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public boolean isAuthenticated() {
        Map<String, String> map = this.loginsMap;
        return map != null && map.size() > 0;
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public void unregisterIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.listeners.remove(identityChangedListener);
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public void registerIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.listeners.add(identityChangedListener);
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public void identityChanged(String str) {
        String str2 = this.identityId;
        if (str2 == null || !str2.equals(str)) {
            String str3 = this.identityId;
            this.identityId = str;
            Iterator<IdentityChangedListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().identityChanged(str3, this.identityId);
            }
        }
    }

    protected void appendUserAgent(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        amazonWebServiceRequest.getRequestClientOptions().appendUserAgent(str);
    }

    @Override // com.amazonaws.auth.AWSCognitoIdentityProvider
    public void clearListeners() {
        this.listeners.clear();
    }

    protected String getUserAgent() {
        return "";
    }

    protected void update(String str, String str2) {
        String str3 = this.identityId;
        if (str3 == null || !str3.equals(str)) {
            identityChanged(str);
        }
        String str4 = this.token;
        if (str4 == null || !str4.equals(str2)) {
            this.token = str2;
        }
    }

    @Override // com.amazonaws.auth.AWSIdentityProvider
    public String refresh() throws AmazonClientException {
        getIdentityId();
        String token = getToken();
        update(getIdentityId(), token);
        return token;
    }
}
