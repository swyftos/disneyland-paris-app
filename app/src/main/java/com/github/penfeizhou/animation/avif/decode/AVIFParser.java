package com.github.penfeizhou.animation.avif.decode;

import android.content.Context;
import com.github.penfeizhou.animation.avif.p030io.AVIFReader;
import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.p032io.StreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.aomedia.avif.android.AvifDecoder;

/* JADX INFO: loaded from: classes3.dex */
public class AVIFParser {
    public static boolean isAVIF(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                boolean zIsAVIF = isAVIF(new StreamReader(fileInputStream2));
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return zIsAVIF;
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return false;
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isAVIF(Context context, String str) {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            return isAVIF(new StreamReader(inputStreamOpen));
        } catch (Exception unused) {
            if (inputStreamOpen == null) {
                return false;
            }
            try {
                return false;
            } catch (IOException e) {
                return false;
            }
        } finally {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static boolean isAVIF(Context context, int i) {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            return isAVIF(new StreamReader(inputStreamOpenRawResource));
        } catch (Exception unused) {
            if (inputStreamOpenRawResource == null) {
                return false;
            }
            try {
                return false;
            } catch (IOException e) {
                return false;
            }
        } finally {
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static boolean isAVIF(Reader reader) {
        try {
            return AvifDecoder.isAvifImage((reader instanceof AVIFReader ? (AVIFReader) reader : new AVIFReader(reader)).toDirectByteBuffer());
        } catch (IOException unused) {
            return false;
        }
    }
}
