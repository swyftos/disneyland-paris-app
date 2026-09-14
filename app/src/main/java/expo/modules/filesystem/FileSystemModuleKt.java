package expo.modules.filesystem;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00000\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1836d2 = {"", "path", "slashifyFilePath", "(Ljava/lang/String;)Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "expo-file-system_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FileSystemModuleKt {
    private static final String TAG = FileSystemModule.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    public static final String slashifyFilePath(String str) {
        if (str == null) {
            return null;
        }
        return StringsKt.startsWith$default(str, "file:///", false, 2, (Object) null) ? str : Pattern.compile("^file:/*").matcher(str).replaceAll("file:///");
    }
}
