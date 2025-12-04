package com.facebook.soloader.recovery;

import com.facebook.soloader.BackupSoSource;
import com.facebook.soloader.LogUtil;
import com.facebook.soloader.SoLoader;
import com.facebook.soloader.SoLoaderDSONotFoundError;
import com.facebook.soloader.SoLoaderULError;
import com.facebook.soloader.SoSource;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ReunpackBackupSoSources implements RecoveryStrategy {
    private int mRecoveryFlags;

    public ReunpackBackupSoSources() {
        this(0);
    }

    public ReunpackBackupSoSources(int i) {
        this.mRecoveryFlags = i;
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        if (!(unsatisfiedLinkError instanceof SoLoaderULError)) {
            return false;
        }
        SoLoaderULError soLoaderULError = (SoLoaderULError) unsatisfiedLinkError;
        String soName = soLoaderULError.getSoName();
        String message = soLoaderULError.getMessage();
        if (soName == null) {
            LogUtil.e(SoLoader.TAG, "No so name provided in ULE, cannot recover");
            return false;
        }
        if (soLoaderULError instanceof SoLoaderDSONotFoundError) {
            if ((this.mRecoveryFlags & 1) == 0) {
                return false;
            }
            logRecovery(soLoaderULError, soName);
            return recoverDSONotFoundError(soSourceArr, soName, 0);
        }
        if (message == null || !(message.contains("/app/") || message.contains("/mnt/"))) {
            return false;
        }
        logRecovery(soLoaderULError, soName);
        return lazyPrepareBackupSoSource(soSourceArr, soName);
    }

    private boolean recoverDSONotFoundError(SoSource[] soSourceArr, String str, int i) {
        try {
            for (SoSource soSource : soSourceArr) {
                if ((soSource instanceof BackupSoSource) && ((BackupSoSource) soSource).peekAndPrepareSoSource(str, i)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            LogUtil.e(SoLoader.TAG, "Failed to run recovery for backup so source due to: " + e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        if (r1 >= r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r7 = r6[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if ((r7 instanceof com.facebook.soloader.DirectorySoSource) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if ((r7 instanceof com.facebook.soloader.BackupSoSource) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        ((com.facebook.soloader.DirectorySoSource) r7).setExplicitDependencyResolution();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Encountered an exception while reunpacking BackupSoSource " + r3.getName() + " for library " + r7 + ": ", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        r3 = (com.facebook.soloader.BackupSoSource) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Preparing BackupSoSource for the first time " + r3.getName());
        r3.prepare(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        r5 = r6.length;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean lazyPrepareBackupSoSource(com.facebook.soloader.SoSource[] r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r5 = "SoLoader"
            int r0 = r6.length
            r1 = 0
            r2 = r1
        L5:
            if (r2 >= r0) goto L6c
            r3 = r6[r2]
            boolean r4 = r3 instanceof com.facebook.soloader.BackupSoSource
            if (r4 != 0) goto L10
            int r2 = r2 + 1
            goto L5
        L10:
            com.facebook.soloader.BackupSoSource r3 = (com.facebook.soloader.BackupSoSource) r3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L46
            r0.<init>()     // Catch: java.lang.Exception -> L46
            java.lang.String r2 = "Preparing BackupSoSource for the first time "
            r0.append(r2)     // Catch: java.lang.Exception -> L46
            java.lang.String r2 = r3.getName()     // Catch: java.lang.Exception -> L46
            r0.append(r2)     // Catch: java.lang.Exception -> L46
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L46
            com.facebook.soloader.LogUtil.e(r5, r0)     // Catch: java.lang.Exception -> L46
            r3.prepare(r1)     // Catch: java.lang.Exception -> L46
            int r5 = r6.length
        L2e:
            if (r1 >= r5) goto L44
            r7 = r6[r1]
            boolean r0 = r7 instanceof com.facebook.soloader.DirectorySoSource
            if (r0 != 0) goto L37
            goto L41
        L37:
            boolean r0 = r7 instanceof com.facebook.soloader.BackupSoSource
            if (r0 == 0) goto L3c
            goto L41
        L3c:
            com.facebook.soloader.DirectorySoSource r7 = (com.facebook.soloader.DirectorySoSource) r7
            r7.setExplicitDependencyResolution()
        L41:
            int r1 = r1 + 1
            goto L2e
        L44:
            r5 = 1
            return r5
        L46:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Encountered an exception while reunpacking BackupSoSource "
            r0.append(r2)
            java.lang.String r2 = r3.getName()
            r0.append(r2)
            java.lang.String r2 = " for library "
            r0.append(r2)
            r0.append(r7)
            java.lang.String r7 = ": "
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.facebook.soloader.LogUtil.e(r5, r7, r6)
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.recovery.ReunpackBackupSoSources.lazyPrepareBackupSoSource(com.facebook.soloader.SoSource[], java.lang.String):boolean");
    }

    private void logRecovery(Error error, String str) {
        LogUtil.e(SoLoader.TAG, "Reunpacking BackupSoSources due to " + error + ", retrying for specific library " + str);
    }
}
