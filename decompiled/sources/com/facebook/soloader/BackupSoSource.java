package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import com.facebook.soloader.ExtractFromZipSoSource;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BackupSoSource extends UnpackingSoSource implements RecoverableSoSource {
    protected boolean mInitialized;
    private final ArrayList mZipSources;

    public BackupSoSource(Context context, String str, boolean z) {
        super(context, str, z);
        ArrayList arrayList = new ArrayList();
        this.mZipSources = arrayList;
        this.mInitialized = false;
        arrayList.add(new ExtractFromZipSoSource(context, str, new File(context.getApplicationInfo().sourceDir), "^lib/([^/]+)/([^/]+\\.so)$"));
        addBackupsFromSplitApks(context, str);
    }

    public BackupSoSource(Context context, String str) {
        this(context, str, true);
    }

    private void addBackupsFromSplitApks(Context context, String str) {
        if (context.getApplicationInfo().splitSourceDirs == null) {
            return;
        }
        try {
            for (String str2 : context.getApplicationInfo().splitSourceDirs) {
                ExtractFromZipSoSource extractFromZipSoSource = new ExtractFromZipSoSource(context, str, new File(str2), "^lib/([^/]+)/([^/]+\\.so)$");
                if (extractFromZipSoSource.hasZippedLibs()) {
                    LogUtil.w("BackupSoSource", "adding backup source from split: " + extractFromZipSoSource.toString());
                    this.mZipSources.add(extractFromZipSoSource);
                }
            }
        } catch (IOException e) {
            LogUtil.w("BackupSoSource", "failed to read split apks", e);
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public String getName() {
        return "BackupSoSource";
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ApkUnpacker();
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (this.mInitialized) {
            return super.loadLibrary(str, i, threadPolicy);
        }
        return 0;
    }

    @Override // com.facebook.soloader.UnpackingSoSource, com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        if ((i & 8) != 0) {
            return;
        }
        super.prepare(i);
        this.mInitialized = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoLoader.TAG, "Found " + r9 + " in " + getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean peekAndPrepareSoSource(java.lang.String r9, int r10) throws java.io.IOException {
        /*
            r8 = this;
            com.facebook.soloader.UnpackingSoSource$Unpacker r0 = r8.makeUnpacker()
            com.facebook.soloader.UnpackingSoSource$Dso[] r1 = r0.getDsos()     // Catch: java.lang.Throwable -> L3c
            int r2 = r1.length     // Catch: java.lang.Throwable -> L3c
            r3 = 0
            r4 = r3
        Lb:
            java.lang.String r5 = "SoLoader"
            r6 = 1
            if (r4 >= r2) goto L41
            r7 = r1[r4]     // Catch: java.lang.Throwable -> L3c
            java.lang.String r7 = r7.name     // Catch: java.lang.Throwable -> L3c
            boolean r7 = r7.equals(r9)     // Catch: java.lang.Throwable -> L3c
            if (r7 == 0) goto L3e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r1.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "Found "
            r1.append(r2)     // Catch: java.lang.Throwable -> L3c
            r1.append(r9)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r9 = " in "
            r1.append(r9)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r9 = r8.getName()     // Catch: java.lang.Throwable -> L3c
            r1.append(r9)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r9 = r1.toString()     // Catch: java.lang.Throwable -> L3c
            com.facebook.soloader.LogUtil.e(r5, r9)     // Catch: java.lang.Throwable -> L3c
            r9 = r6
            goto L42
        L3c:
            r8 = move-exception
            goto L64
        L3e:
            int r4 = r4 + 1
            goto Lb
        L41:
            r9 = r3
        L42:
            r0.close()
            if (r9 != 0) goto L48
            return r3
        L48:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Preparing "
            r9.append(r0)
            java.lang.String r0 = r8.getName()
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.facebook.soloader.LogUtil.e(r5, r9)
            r8.prepare(r10)
            return r6
        L64:
            if (r0 == 0) goto L6e
            r0.close()     // Catch: java.lang.Throwable -> L6a
            goto L6e
        L6a:
            r9 = move-exception
            r8.addSuppressed(r9)
        L6e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.BackupSoSource.peekAndPrepareSoSource(java.lang.String, int):boolean");
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Dso[] getDsosBaseApk() throws IOException {
        UnpackingSoSource.Unpacker unpackerMakeUnpacker = ((ExtractFromZipSoSource) this.mZipSources.get(0)).makeUnpacker();
        try {
            UnpackingSoSource.Dso[] dsos = unpackerMakeUnpacker.getDsos();
            unpackerMakeUnpacker.close();
            return dsos;
        } catch (Throwable th) {
            if (unpackerMakeUnpacker != null) {
                try {
                    unpackerMakeUnpacker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    protected class ApkUnpacker extends UnpackingSoSource.Unpacker {
        protected ApkUnpacker() {
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.Dso[] getDsos() throws IOException {
            ArrayList arrayList = new ArrayList();
            Iterator it = BackupSoSource.this.mZipSources.iterator();
            while (it.hasNext()) {
                UnpackingSoSource.Unpacker unpackerMakeUnpacker = ((ExtractFromZipSoSource) it.next()).makeUnpacker();
                try {
                    arrayList.addAll(Arrays.asList(unpackerMakeUnpacker.getDsos()));
                    unpackerMakeUnpacker.close();
                } catch (Throwable th) {
                    if (unpackerMakeUnpacker != null) {
                        try {
                            unpackerMakeUnpacker.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            return (UnpackingSoSource.Dso[]) arrayList.toArray(new UnpackingSoSource.Dso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public void unpack(File file) throws IOException {
            Iterator it = BackupSoSource.this.mZipSources.iterator();
            while (it.hasNext()) {
                ExtractFromZipSoSource.ZipUnpacker zipUnpacker = (ExtractFromZipSoSource.ZipUnpacker) ((ExtractFromZipSoSource) it.next()).makeUnpacker();
                try {
                    zipUnpacker.unpack(file);
                    zipUnpacker.close();
                } catch (Throwable th) {
                    if (zipUnpacker != null) {
                        try {
                            zipUnpacker.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected byte[] getDepsBlock() throws IOException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 3);
            parcelObtain.writeInt(SysUtil.getAppVersionCode(this.mContext));
            parcelObtain.writeInt(this.mZipSources.size());
            Iterator it = this.mZipSources.iterator();
            while (it.hasNext()) {
                parcelObtain.writeByteArray(((ExtractFromZipSoSource) it.next()).getDepsBlock());
            }
            String str = this.mContext.getApplicationInfo().sourceDir;
            if (str == null) {
                parcelObtain.writeByte((byte) 1);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                return bArrMarshall;
            }
            File canonicalFile = new File(str).getCanonicalFile();
            if (!canonicalFile.exists()) {
                parcelObtain.writeByte((byte) 1);
                byte[] bArrMarshall2 = parcelObtain.marshall();
                parcelObtain.recycle();
                return bArrMarshall2;
            }
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            byte[] bArrMarshall3 = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall3;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public SoSource recover(Context context) {
        BackupSoSource backupSoSource = new BackupSoSource(context, this.soDirectory.getName());
        try {
            backupSoSource.prepare(0);
            return backupSoSource;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            name = this.soDirectory.getName();
        }
        return getName() + "[root = " + name + " flags = " + this.flags + " apks = " + this.mZipSources.toString() + "]";
    }
}
