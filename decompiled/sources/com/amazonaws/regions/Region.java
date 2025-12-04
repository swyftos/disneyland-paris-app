package com.amazonaws.regions;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Region {
    private final String domain;
    private final String name;
    private final Map serviceEndpoints = new HashMap();
    private final Map httpSupport = new HashMap();
    private final Map httpsSupport = new HashMap();

    Region(String str, String str2) {
        this.name = str;
        if (str2 == null || str2.isEmpty()) {
            this.domain = "amazonaws.com";
        } else {
            this.domain = str2;
        }
    }

    public static Region getRegion(Regions regions) {
        return RegionUtils.getRegion(regions.getName());
    }

    public static Region getRegion(String str) {
        return RegionUtils.getRegion(str);
    }

    public String getName() {
        return this.name;
    }

    public String getDomain() {
        return this.domain;
    }

    Map getServiceEndpoints() {
        return this.serviceEndpoints;
    }

    Map getHttpSupport() {
        return this.httpSupport;
    }

    Map getHttpsSupport() {
        return this.httpsSupport;
    }

    public String getServiceEndpoint(String str) {
        return (String) this.serviceEndpoints.get(str);
    }

    public boolean isServiceSupported(String str) {
        return this.serviceEndpoints.containsKey(str);
    }

    public boolean hasHttpsEndpoint(String str) {
        return this.httpsSupport.containsKey(str) && ((Boolean) this.httpsSupport.get(str)).booleanValue();
    }

    public boolean hasHttpEndpoint(String str) {
        return this.httpSupport.containsKey(str) && ((Boolean) this.httpSupport.get(str)).booleanValue();
    }

    public <T extends AmazonWebServiceClient> T createClient(Class<T> cls, AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        T tNewInstance;
        try {
            if (aWSCredentialsProvider == null && clientConfiguration == null) {
                tNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } else if (aWSCredentialsProvider == null) {
                tNewInstance = cls.getConstructor(ClientConfiguration.class).newInstance(clientConfiguration);
            } else if (clientConfiguration == null) {
                tNewInstance = cls.getConstructor(AWSCredentialsProvider.class).newInstance(aWSCredentialsProvider);
            } else {
                tNewInstance = cls.getConstructor(AWSCredentialsProvider.class, ClientConfiguration.class).newInstance(aWSCredentialsProvider, clientConfiguration);
            }
            tNewInstance.setRegion(this);
            return tNewInstance;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't instantiate instance of " + cls, e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return getName().equals(((Region) obj).getName());
        }
        return false;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public String toString() {
        return getName();
    }
}
