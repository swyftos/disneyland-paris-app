package com.amazonaws.auth;

import android.content.Context;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.NotAuthorizedException;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.util.VersionInfoUtils;
import java.util.Date;
import java.util.Map;

/* loaded from: classes2.dex */
public class CognitoCachingCredentialsProvider extends CognitoCredentialsProvider {
    AWSKeyValueStore awsKeyValueStore;
    private String identityId;
    private boolean isPersistenceEnabled;
    private final IdentityChangedListener listener;
    volatile boolean needIdentityRefresh;
    private String userAgentOverride;
    private static final String USER_AGENT = CognitoCachingCredentialsProvider.class.getName() + "/" + VersionInfoUtils.getVersion();
    private static final Log LOG = LogFactory.getLog(CognitoCachingCredentialsProvider.class);
    private static final String AWS_KEY_VALUE_STORE_NAMESPACE_IDENTIFIER = "com.amazonaws.android.auth";
    private static final String ID_KEY = "identityId";
    private static final String AK_KEY = "accessKey";
    private static final String SK_KEY = "secretKey";
    private static final String ST_KEY = "sessionToken";
    private static final String EXP_KEY = "expirationDate";

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, Regions regions) {
        super(str, str2, str3, str4, regions);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, Regions regions, ClientConfiguration clientConfiguration) {
        super(str, str2, str3, str4, regions, clientConfiguration);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, Regions regions) {
        super(str, regions);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSConfiguration aWSConfiguration) {
        super(aWSConfiguration);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, Regions regions, ClientConfiguration clientConfiguration) {
        super(str, regions, clientConfiguration);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, String str, String str2, String str3, String str4, AmazonCognitoIdentityClient amazonCognitoIdentityClient, AWSSecurityTokenService aWSSecurityTokenService) {
        super(str, str2, str3, str4, amazonCognitoIdentityClient, aWSSecurityTokenService);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2) {
        super(aWSCognitoIdentityProvider, str, str2);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, String str, String str2, AWSSecurityTokenService aWSSecurityTokenService) {
        super(aWSCognitoIdentityProvider, str, str2, aWSSecurityTokenService);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions) {
        super(aWSCognitoIdentityProvider, regions);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    public CognitoCachingCredentialsProvider(Context context, AWSCognitoIdentityProvider aWSCognitoIdentityProvider, Regions regions, ClientConfiguration clientConfiguration) {
        super(aWSCognitoIdentityProvider, regions, clientConfiguration);
        this.needIdentityRefresh = false;
        this.listener = new IdentityChangedListener() { // from class: com.amazonaws.auth.CognitoCachingCredentialsProvider.1
            @Override // com.amazonaws.auth.IdentityChangedListener
            public void identityChanged(String str5, String str6) {
                CognitoCachingCredentialsProvider.LOG.debug("Identity id is changed");
                CognitoCachingCredentialsProvider.this.saveIdentityId(str6);
                CognitoCachingCredentialsProvider.this.clearCredentials();
            }
        };
        this.isPersistenceEnabled = true;
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        initialize(context);
    }

    private void initialize(Context context) {
        this.awsKeyValueStore = new AWSKeyValueStore(context, AWS_KEY_VALUE_STORE_NAMESPACE_IDENTIFIER, this.isPersistenceEnabled);
        checkUpgrade();
        this.identityId = getCachedIdentityId();
        loadCachedCredentials();
        registerIdentityChangedListener(this.listener);
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public String getIdentityId() {
        if (this.needIdentityRefresh) {
            this.needIdentityRefresh = false;
            refresh();
            String identityId = super.getIdentityId();
            this.identityId = identityId;
            saveIdentityId(identityId);
        }
        String cachedIdentityId = getCachedIdentityId();
        this.identityId = cachedIdentityId;
        if (cachedIdentityId == null) {
            String identityId2 = super.getIdentityId();
            this.identityId = identityId2;
            saveIdentityId(identityId2);
        }
        return this.identityId;
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider, com.amazonaws.auth.AWSCredentialsProvider
    public AWSSessionCredentials getCredentials() {
        AWSSessionCredentials aWSSessionCredentials;
        this.credentialsLock.writeLock().lock();
        try {
            try {
                if (this.sessionCredentials == null) {
                    loadCachedCredentials();
                }
                if (this.sessionCredentialsExpiration != null && !needsNewSession()) {
                    aWSSessionCredentials = this.sessionCredentials;
                } else {
                    LOG.debug("Making a network call to fetch credentials.");
                    super.getCredentials();
                    Date date = this.sessionCredentialsExpiration;
                    if (date != null) {
                        saveCredentials(this.sessionCredentials, date.getTime());
                    }
                    aWSSessionCredentials = this.sessionCredentials;
                }
            } catch (NotAuthorizedException e) {
                LOG.error("Failure to get credentials", e);
                if (getLogins() != null) {
                    super.setIdentityId(null);
                    super.getCredentials();
                    aWSSessionCredentials = this.sessionCredentials;
                } else {
                    throw e;
                }
            }
            this.credentialsLock.writeLock().unlock();
            return aWSSessionCredentials;
        } catch (Throwable th) {
            this.credentialsLock.writeLock().unlock();
            throw th;
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider, com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        this.credentialsLock.writeLock().lock();
        try {
            super.refresh();
            Date date = this.sessionCredentialsExpiration;
            if (date != null) {
                saveCredentials(this.sessionCredentials, date.getTime());
            }
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void setLogins(Map<String, String> map) {
        this.credentialsLock.writeLock().lock();
        try {
            super.setLogins(map);
            this.needIdentityRefresh = true;
            clearCredentials();
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void clear() {
        super.clear();
        AWSKeyValueStore aWSKeyValueStore = this.awsKeyValueStore;
        if (aWSKeyValueStore != null) {
            aWSKeyValueStore.clear();
        }
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    public void clearCredentials() {
        this.credentialsLock.writeLock().lock();
        try {
            super.clearCredentials();
            LOG.debug("Clearing credentials from SharedPreferences");
            this.awsKeyValueStore.remove(namespace(AK_KEY));
            this.awsKeyValueStore.remove(namespace(SK_KEY));
            this.awsKeyValueStore.remove(namespace(ST_KEY));
            this.awsKeyValueStore.remove(namespace(EXP_KEY));
        } finally {
            this.credentialsLock.writeLock().unlock();
        }
    }

    public String getCachedIdentityId() {
        String str = this.awsKeyValueStore.get(namespace(ID_KEY));
        if (str != null && this.identityId == null) {
            super.setIdentityId(str);
        }
        return str;
    }

    private void loadCachedCredentials() {
        Log log = LOG;
        log.debug("Loading credentials from SharedPreferences");
        String str = this.awsKeyValueStore.get(namespace(EXP_KEY));
        if (str != null) {
            try {
                this.sessionCredentialsExpiration = new Date(Long.parseLong(str));
                if (!hasCredentials()) {
                    this.sessionCredentialsExpiration = null;
                    return;
                }
                String str2 = this.awsKeyValueStore.get(namespace(AK_KEY));
                String str3 = this.awsKeyValueStore.get(namespace(SK_KEY));
                String str4 = this.awsKeyValueStore.get(namespace(ST_KEY));
                if (str2 == null || str3 == null || str4 == null) {
                    log.debug("No valid credentials found in SharedPreferences");
                    this.sessionCredentialsExpiration = null;
                    return;
                } else {
                    this.sessionCredentials = new BasicSessionCredentials(str2, str3, str4);
                    return;
                }
            } catch (NumberFormatException unused) {
                this.sessionCredentialsExpiration = null;
                return;
            }
        }
        this.sessionCredentialsExpiration = null;
    }

    private boolean hasCredentials() {
        boolean zContains = this.awsKeyValueStore.contains(namespace(AK_KEY));
        boolean zContains2 = this.awsKeyValueStore.contains(namespace(SK_KEY));
        boolean zContains3 = this.awsKeyValueStore.contains(namespace(ST_KEY));
        if (!zContains && !zContains2 && !zContains3) {
            return false;
        }
        LOG.debug("No valid credentials found in SharedPreferences");
        return true;
    }

    private void saveCredentials(AWSSessionCredentials aWSSessionCredentials, long j) {
        LOG.debug("Saving credentials to SharedPreferences");
        if (aWSSessionCredentials != null) {
            this.awsKeyValueStore.put(namespace(AK_KEY), aWSSessionCredentials.getAWSAccessKeyId());
            this.awsKeyValueStore.put(namespace(SK_KEY), aWSSessionCredentials.getAWSSecretKey());
            this.awsKeyValueStore.put(namespace(ST_KEY), aWSSessionCredentials.getSessionToken());
            this.awsKeyValueStore.put(namespace(EXP_KEY), String.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveIdentityId(String str) {
        LOG.debug("Saving identity id to SharedPreferences");
        this.identityId = str;
        this.awsKeyValueStore.put(namespace(ID_KEY), str);
    }

    @Override // com.amazonaws.auth.CognitoCredentialsProvider
    protected String getUserAgent() {
        String str = this.userAgentOverride;
        return str != null ? str : USER_AGENT;
    }

    private void checkUpgrade() {
        AWSKeyValueStore aWSKeyValueStore = this.awsKeyValueStore;
        String str = ID_KEY;
        if (aWSKeyValueStore.contains(str)) {
            LOG.info("Identity id without namespace is detected. It will be saved under new namespace.");
            String str2 = this.awsKeyValueStore.get(str);
            this.awsKeyValueStore.clear();
            this.awsKeyValueStore.put(namespace(str), str2);
        }
    }

    private String namespace(String str) {
        return getIdentityPoolId() + InstructionFileId.DOT + str;
    }

    public void setPersistenceEnabled(boolean z) {
        this.isPersistenceEnabled = z;
        this.awsKeyValueStore.setPersistenceEnabled(z);
    }

    public void setUserAgentOverride(String str) {
        this.userAgentOverride = str;
    }
}
