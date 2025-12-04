package com.tagcommander.lib.core;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class TCConfigurationFileFactory {
    private static volatile TCConfigurationFileFactory INSTANCE;
    Context appContext;
    HashMap configurations = new HashMap();
    int fileID;
    int siteID;

    private TCConfigurationFileFactory() {
    }

    public static TCConfigurationFileFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (TCConfigurationFileFactory.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new TCConfigurationFileFactory();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public void initWith(int i, int i2, Context context) {
        this.siteID = i;
        this.fileID = i2;
        this.appContext = context.getApplicationContext();
    }

    public void addConfigurationFile(String str) {
        this.configurations.put(str, new TCConfigurationFile(this.siteID, this.fileID, str, this.appContext));
    }

    public void addConfigurationFile(String str, TCConfigurationFile tCConfigurationFile) {
        this.configurations.put(str, tCConfigurationFile);
    }

    public void addConfigurationFile(String str, String str2) {
        this.configurations.put(str, new TCConfigurationFile(this.siteID, this.fileID, str, str2, this.appContext));
    }

    public void addConfigurationFile(String str, String str2, String str3) {
        this.configurations.put(str, new TCConfigurationFile(str, str2, str3, this.appContext));
    }

    public TCConfigurationFile getConfigurationFile(String str) {
        return (TCConfigurationFile) this.configurations.get(str);
    }
}
