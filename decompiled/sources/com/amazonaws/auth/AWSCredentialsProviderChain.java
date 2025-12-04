package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class AWSCredentialsProviderChain implements AWSCredentialsProvider {
    private static final Log log = LogFactory.getLog(AWSCredentialsProviderChain.class);
    private AWSCredentialsProvider lastUsedProvider;
    private List credentialsProviders = new LinkedList();
    private boolean reuseLastProvider = true;

    public AWSCredentialsProviderChain(AWSCredentialsProvider... aWSCredentialsProviderArr) {
        if (aWSCredentialsProviderArr == null || aWSCredentialsProviderArr.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        for (AWSCredentialsProvider aWSCredentialsProvider : aWSCredentialsProviderArr) {
            this.credentialsProviders.add(aWSCredentialsProvider);
        }
    }

    public boolean getReuseLastProvider() {
        return this.reuseLastProvider;
    }

    public void setReuseLastProvider(boolean z) {
        this.reuseLastProvider = z;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        AWSCredentials credentials;
        AWSCredentialsProvider aWSCredentialsProvider;
        if (this.reuseLastProvider && (aWSCredentialsProvider = this.lastUsedProvider) != null) {
            return aWSCredentialsProvider.getCredentials();
        }
        for (AWSCredentialsProvider aWSCredentialsProvider2 : this.credentialsProviders) {
            try {
                credentials = aWSCredentialsProvider2.getCredentials();
            } catch (Exception e) {
                log.debug("Unable to load credentials from " + aWSCredentialsProvider2.toString() + ": " + e.getMessage());
            }
            if (credentials.getAWSAccessKeyId() != null && credentials.getAWSSecretKey() != null) {
                log.debug("Loading credentials from " + aWSCredentialsProvider2.toString());
                this.lastUsedProvider = aWSCredentialsProvider2;
                return credentials;
            }
        }
        throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        Iterator it = this.credentialsProviders.iterator();
        while (it.hasNext()) {
            ((AWSCredentialsProvider) it.next()).refresh();
        }
    }
}
