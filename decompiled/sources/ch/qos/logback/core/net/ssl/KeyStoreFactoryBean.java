package ch.qos.logback.core.net.ssl;

import ch.qos.logback.core.util.LocationUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* loaded from: classes2.dex */
public class KeyStoreFactoryBean {
    private String location;
    private String password;
    private String provider;
    private String type;

    private KeyStore newKeyStore() {
        return getProvider() != null ? KeyStore.getInstance(getType(), getProvider()) : KeyStore.getInstance(getType());
    }

    public KeyStore createKeyStore() throws NoSuchAlgorithmException, IOException, KeyStoreException, NoSuchProviderException {
        if (getLocation() == null) {
            throw new IllegalArgumentException("location is required");
        }
        InputStream inputStreamOpenStream = null;
        try {
            try {
                try {
                    inputStreamOpenStream = LocationUtil.urlForResource(getLocation()).openStream();
                    KeyStore keyStoreNewKeyStore = newKeyStore();
                    keyStoreNewKeyStore.load(inputStreamOpenStream, getPassword().toCharArray());
                    return keyStoreNewKeyStore;
                } catch (NoSuchAlgorithmException unused) {
                    throw new NoSuchAlgorithmException("no such keystore type: " + getType());
                } catch (Exception e) {
                    throw new KeyStoreException(getLocation() + ": " + e.getMessage(), e);
                }
            } catch (FileNotFoundException unused2) {
                throw new KeyStoreException(getLocation() + ": file not found");
            } catch (NoSuchProviderException unused3) {
                throw new NoSuchProviderException("no such keystore provider: " + getProvider());
            }
        } finally {
            if (inputStreamOpenStream != null) {
                try {
                    inputStreamOpenStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace(System.err);
                }
            }
        }
    }

    public String getLocation() {
        return this.location;
    }

    public String getPassword() {
        String str = this.password;
        return str == null ? SSL.DEFAULT_KEYSTORE_PASSWORD : str;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getType() {
        String str = this.type;
        return str == null ? SSL.DEFAULT_KEYSTORE_TYPE : str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
