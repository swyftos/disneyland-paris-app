package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
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
                    LogUtil.m1411w("BackupSoSource", "adding backup source from split: " + extractFromZipSoSource.toString());
                    this.mZipSources.add(extractFromZipSoSource);
                }
            }
        } catch (IOException e) {
            LogUtil.m1412w("BackupSoSource", "failed to read split apks", e);
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

    public boolean peekAndPrepareSoSource(String str, int i) throws IOException {
        boolean z;
        UnpackingSoSource.Unpacker unpackerMakeUnpacker = makeUnpacker();
        try {
            UnpackingSoSource.Dso[] dsos = unpackerMakeUnpacker.getDsos();
            int length = dsos.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                if (dsos[i2].name.equals(str)) {
                    LogUtil.m1405e(SoLoader.TAG, "Found " + str + " in " + getName());
                    z = true;
                    break;
                }
                i2++;
            }
            unpackerMakeUnpacker.close();
            if (!z) {
                return false;
            }
            LogUtil.m1405e(SoLoader.TAG, "Preparing " + getName());
            prepare(i);
            return true;
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
                return parcelObtain.marshall();
            }
            File canonicalFile = new File(str).getCanonicalFile();
            if (!canonicalFile.exists()) {
                parcelObtain.writeByte((byte) 1);
                return parcelObtain.marshall();
            }
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
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
