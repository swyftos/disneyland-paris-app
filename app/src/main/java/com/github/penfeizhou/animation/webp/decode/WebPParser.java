package com.github.penfeizhou.animation.webp.decode;

import android.content.Context;
import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.p032io.StreamReader;
import com.github.penfeizhou.animation.webp.p033io.WebPReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WebPParser {

    static class FormatException extends IOException {
        FormatException() {
            super("WebP Format error");
        }
    }

    public static boolean isAWebP(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                boolean zIsAWebP = isAWebP(new StreamReader(fileInputStream2));
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return zIsAWebP;
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

    public static boolean isAWebP(Context context, String str) {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            return isAWebP(new StreamReader(inputStreamOpen));
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

    public static boolean isAWebP(Context context, int i) {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            return isAWebP(new StreamReader(inputStreamOpenRawResource));
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

    public static boolean isAWebP(Reader reader) {
        WebPReader webPReader = reader instanceof WebPReader ? (WebPReader) reader : new WebPReader(reader);
        try {
            if (!webPReader.matchFourCC("RIFF")) {
                return false;
            }
            webPReader.skip(4L);
            if (!webPReader.matchFourCC("WEBP")) {
                return false;
            }
            while (webPReader.available() > 0) {
                BaseChunk chunk = parseChunk(webPReader);
                if (chunk instanceof VP8XChunk) {
                    return ((VP8XChunk) chunk).animation();
                }
            }
        } catch (IOException e) {
            if (!(e instanceof FormatException)) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static List<BaseChunk> parse(WebPReader webPReader) throws IOException {
        if (!webPReader.matchFourCC("RIFF")) {
            throw new FormatException();
        }
        webPReader.skip(4L);
        if (!webPReader.matchFourCC("WEBP")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (webPReader.available() > 0) {
            arrayList.add(parseChunk(webPReader));
        }
        return arrayList;
    }

    static BaseChunk parseChunk(WebPReader webPReader) {
        BaseChunk baseChunk;
        int iPosition = webPReader.position();
        int fourCC = webPReader.getFourCC();
        int uInt32 = webPReader.getUInt32();
        if (VP8XChunk.f3446ID == fourCC) {
            baseChunk = new VP8XChunk();
        } else if (ANIMChunk.f3440ID == fourCC) {
            baseChunk = new ANIMChunk();
        } else if (ANMFChunk.f3441ID == fourCC) {
            baseChunk = new ANMFChunk();
        } else if (ALPHChunk.f3439ID == fourCC) {
            baseChunk = new ALPHChunk();
        } else if (VP8Chunk.f3444ID == fourCC) {
            baseChunk = new VP8Chunk();
        } else if (VP8LChunk.f3445ID == fourCC) {
            baseChunk = new VP8LChunk();
        } else if (ICCPChunk.f3443ID == fourCC) {
            baseChunk = new ICCPChunk();
        } else if (XMPChunk.f3447ID == fourCC) {
            baseChunk = new XMPChunk();
        } else if (EXIFChunk.f3442ID == fourCC) {
            baseChunk = new EXIFChunk();
        } else {
            baseChunk = new BaseChunk();
        }
        baseChunk.chunkFourCC = fourCC;
        baseChunk.payloadSize = uInt32;
        baseChunk.offset = iPosition;
        baseChunk.parse(webPReader);
        return baseChunk;
    }
}
