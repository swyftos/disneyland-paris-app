package com.facebook.soloader;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class ExoSoSource extends UnpackingSoSource {
    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public String getName() {
        return "ExoSoSource";
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected MessageDigest getHashingAlgorithm() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-1");
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    protected UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ExoUnpacker(this);
    }

    private final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        private final FileDso[] mDsos;

        /* JADX WARN: Bottom block not found for handler: all -> 0x0107 */
        /* JADX WARN: Code duplicated, block: B:6:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        ExoUnpacker(UnpackingSoSource unpackingSoSource) throws IOException {
            File file;
            File file2;
            File file3 = new File("/data/local/tmp/exopackage/" + ExoSoSource.this.mContext.getPackageName() + "/native-libs/");
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] supportedAbis = SysUtil.getSupportedAbis();
            int length = supportedAbis.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                String str = supportedAbis[i2];
                File file4 = new File(file3, str);
                if (file4.isDirectory()) {
                    linkedHashSet.add(str);
                    File file5 = new File(file4, "metadata.txt");
                    if (file5.isFile()) {
                        FileReader fileReader = new FileReader(file5);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line != null) {
                                    if (line.length() != 0) {
                                        int iIndexOf = line.indexOf(32);
                                        if (iIndexOf == -1) {
                                            throw new RuntimeException("illegal line in exopackage metadata: [" + line + "]");
                                        }
                                        String str2 = line.substring(i, iIndexOf) + ".so";
                                        int size = arrayList.size();
                                        while (true) {
                                            if (i < size) {
                                                file2 = file3;
                                                if (((FileDso) arrayList.get(i)).name.equals(str2)) {
                                                    break;
                                                }
                                                i++;
                                                file3 = file2;
                                            } else {
                                                file2 = file3;
                                                String strSubstring = line.substring(iIndexOf + 1);
                                                arrayList.add(new FileDso(str2, strSubstring.substring(strSubstring.indexOf(45), strSubstring.indexOf(".so")), new File(file4, strSubstring)));
                                                break;
                                            }
                                        }
                                        file3 = file2;
                                        i = 0;
                                    }
                                } else {
                                    file = file3;
                                    bufferedReader.close();
                                    fileReader.close();
                                    break;
                                }
                            } catch (Throwable th) {
                                try {
                                    bufferedReader.close();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    throw th;
                                }
                            }
                            try {
                                fileReader.close();
                                throw th;
                            }
                        }
                    }
                    file = file3;
                } else {
                    file = file3;
                }
                i2++;
                file3 = file;
                i = 0;
            }
            unpackingSoSource.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            this.mDsos = (FileDso[]) arrayList.toArray(new FileDso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.Dso[] getDsos() {
            return this.mDsos;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public void unpack(File file) throws IOException {
            byte[] bArr = new byte[32768];
            for (FileDso fileDso : this.mDsos) {
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    UnpackingSoSource.InputDso inputDso = new UnpackingSoSource.InputDso(fileDso, fileInputStream);
                    fileInputStream = null;
                    try {
                        extractDso(inputDso, bArr, file);
                        inputDso.close();
                    } catch (Throwable th) {
                        try {
                            inputDso.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th3;
                }
            }
        }
    }

    private static final class FileDso extends UnpackingSoSource.Dso {
        final File backingFile;

        FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }
}
