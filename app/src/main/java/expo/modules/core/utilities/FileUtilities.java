package expo.modules.core.utilities;

import com.amazonaws.services.p017s3.model.InstructionFileId;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class FileUtilities {
    public static File ensureDirExists(File file) throws IOException {
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Couldn't create directory '" + file + "'");
    }

    public static String generateOutputPath(File file, String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String str3 = File.separator;
        sb.append(str3);
        sb.append(str);
        File file2 = new File(sb.toString());
        ensureDirExists(file2);
        String string = UUID.randomUUID().toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file2);
        sb2.append(str3);
        sb2.append(string);
        if (!str2.startsWith(InstructionFileId.DOT)) {
            str2 = InstructionFileId.DOT + str2;
        }
        sb2.append(str2);
        return sb2.toString();
    }
}
