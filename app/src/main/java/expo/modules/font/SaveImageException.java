package expo.modules.font;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
final class SaveImageException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveImageException(String uri, Throwable th) {
        super("Could not save image to '" + uri + "'", th);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }
}
