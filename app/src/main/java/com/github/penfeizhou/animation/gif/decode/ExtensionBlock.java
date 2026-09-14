package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.p031io.GifReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExtensionBlock implements Block {
    public static ExtensionBlock retrieve(GifReader gifReader) throws IOException {
        byte bPeek = gifReader.peek();
        if (bPeek == -7) {
            return new GraphicControlExtension();
        }
        if (bPeek == 1) {
            return new PlaintTextExtension();
        }
        if (bPeek == -2) {
            return new CommentExtension();
        }
        if (bPeek == -1) {
            return new ApplicationExtension();
        }
        throw new GifParser.FormatException();
    }
}
