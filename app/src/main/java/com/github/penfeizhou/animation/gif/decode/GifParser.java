package com.github.penfeizhou.animation.gif.decode;

import android.content.Context;
import com.github.penfeizhou.animation.gif.p031io.GifReader;
import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.p032io.StreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GifParser {

    static class FormatException extends IOException {
        FormatException() {
            super("Gif Format error");
        }
    }

    public static boolean isGif(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                boolean zIsGif = isGif(new StreamReader(fileInputStream2));
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return zIsGif;
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

    public static boolean isGif(Context context, String str) {
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            return isGif(new StreamReader(inputStreamOpen));
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

    public static boolean isGif(Context context, int i) {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            return isGif(new StreamReader(inputStreamOpenRawResource));
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

    public static boolean isGif(Reader reader) {
        try {
            checkHeader(reader instanceof GifReader ? (GifReader) reader : new GifReader(reader));
            return true;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List<Block> parse(GifReader gifReader) throws IOException {
        Block blockRetrieve;
        checkHeader(gifReader);
        ArrayList arrayList = new ArrayList();
        LogicalScreenDescriptor logicalScreenDescriptor = new LogicalScreenDescriptor();
        logicalScreenDescriptor.receive(gifReader);
        arrayList.add(logicalScreenDescriptor);
        if (logicalScreenDescriptor.gColorTableFlag()) {
            ColorTable colorTable = new ColorTable(logicalScreenDescriptor.gColorTableSize());
            colorTable.receive(gifReader);
            arrayList.add(colorTable);
        }
        while (true) {
            try {
                byte bPeek = gifReader.peek();
                if (bPeek != 59) {
                    if (bPeek == 33) {
                        blockRetrieve = ExtensionBlock.retrieve(gifReader);
                    } else {
                        blockRetrieve = bPeek != 44 ? null : new ImageDescriptor();
                    }
                    if (blockRetrieve != null) {
                        blockRetrieve.receive(gifReader);
                        arrayList.add(blockRetrieve);
                    } else {
                        throw new FormatException();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }
    }

    private static void checkHeader(GifReader gifReader) throws FormatException {
        byte bPeek;
        if (gifReader.peek() != 71 || gifReader.peek() != 73 || gifReader.peek() != 70 || gifReader.peek() != 56 || (((bPeek = gifReader.peek()) != 55 && bPeek != 57) || gifReader.peek() != 97)) {
            throw new FormatException();
        }
    }
}
