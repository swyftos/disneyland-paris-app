package expo.modules.font;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
final class FileNotFoundException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileNotFoundException(String uri) {
        super("File '" + uri + "' doesn't exist", null, 2, null);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }
}
