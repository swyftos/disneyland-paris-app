package com.amazonaws.auth;

import com.amazonaws.ClientConfiguration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SessionCredentialsProviderFactory {
    private static final Map cache = new HashMap();

    private static final class Key {
        private final String awsAccessKeyId;
        private final String serviceEndpoint;

        public Key(String str, String str2) {
            this.awsAccessKeyId = str;
            this.serviceEndpoint = str2;
        }

        public int hashCode() {
            String str = this.awsAccessKeyId;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.serviceEndpoint;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Key.class != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            String str = this.awsAccessKeyId;
            if (str == null) {
                if (key.awsAccessKeyId != null) {
                    return false;
                }
            } else if (!str.equals(key.awsAccessKeyId)) {
                return false;
            }
            String str2 = this.serviceEndpoint;
            if (str2 == null) {
                if (key.serviceEndpoint != null) {
                    return false;
                }
            } else if (!str2.equals(key.serviceEndpoint)) {
                return false;
            }
            return true;
        }
    }

    public static synchronized STSSessionCredentialsProvider getSessionCredentialsProvider(AWSCredentials aWSCredentials, String str, ClientConfiguration clientConfiguration) {
        Key key;
        Map map;
        try {
            key = new Key(aWSCredentials.getAWSAccessKeyId(), str);
            map = cache;
            if (!map.containsKey(key)) {
                map.put(key, new STSSessionCredentialsProvider(aWSCredentials, clientConfiguration));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (STSSessionCredentialsProvider) map.get(key);
    }
}
