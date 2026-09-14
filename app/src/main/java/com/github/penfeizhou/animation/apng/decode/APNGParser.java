package com.github.penfeizhou.animation.apng.decode;

import android.content.Context;
import com.github.penfeizhou.animation.apng.p029io.APNGReader;
import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.p032io.StreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class APNGParser {

    static class FormatException extends IOException {
        FormatException() {
            super("APNG Format error");
        }
    }

    public static boolean isAPNG(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                boolean zIsAPNG = isAPNG(new StreamReader(fileInputStream2));
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return zIsAPNG;
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

    public static boolean isAPNG(Context context, String str) {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            return isAPNG(new StreamReader(inputStreamOpen));
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

    public static boolean isAPNG(Context context, int i) {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            return isAPNG(new StreamReader(inputStreamOpenRawResource));
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

    public static boolean isAPNG(Reader reader) {
        APNGReader aPNGReader = reader instanceof APNGReader ? (APNGReader) reader : new APNGReader(reader);
        try {
            if (!aPNGReader.matchFourCC("\u0089PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
                throw new FormatException();
            }
            while (aPNGReader.available() > 0) {
                if (parseChunk(aPNGReader) instanceof ACTLChunk) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<Chunk> parse(APNGReader aPNGReader) throws IOException {
        if (!aPNGReader.matchFourCC("\u0089PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (aPNGReader.available() > 0) {
            arrayList.add(parseChunk(aPNGReader));
        }
        return arrayList;
    }

    private static Chunk parseChunk(APNGReader aPNGReader) throws IOException {
        Chunk chunk;
        int iPosition = aPNGReader.position();
        int i = aPNGReader.readInt();
        int fourCC = aPNGReader.readFourCC();
        if (fourCC == ACTLChunk.f3432ID) {
            chunk = new ACTLChunk();
        } else if (fourCC == FCTLChunk.f3433ID) {
            chunk = new FCTLChunk();
        } else if (fourCC == FDATChunk.f3434ID) {
            chunk = new FDATChunk();
        } else if (fourCC == IDATChunk.f3435ID) {
            chunk = new IDATChunk();
        } else if (fourCC == IENDChunk.f3436ID) {
            chunk = new IENDChunk();
        } else if (fourCC == IHDRChunk.f3437ID) {
            chunk = new IHDRChunk();
        } else {
            chunk = new Chunk();
        }
        chunk.offset = iPosition;
        chunk.fourcc = fourCC;
        chunk.length = i;
        chunk.parse(aPNGReader);
        chunk.crc = aPNGReader.readInt();
        return chunk;
    }
}
