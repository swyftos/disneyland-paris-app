package ch.qos.logback.core.rolling.helper;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class RegexPathPart extends PathPart {
    private Pattern pattern;

    RegexPathPart(String str) {
        super(str);
        this.pattern = Pattern.compile(str);
    }

    @Override // ch.qos.logback.core.rolling.helper.PathPart
    List listFiles(FileProvider fileProvider) {
        return listFiles(fileProvider, InstructionFileId.DOT);
    }

    @Override // ch.qos.logback.core.rolling.helper.PathPart
    boolean matches(File file) {
        return this.pattern.matcher(file.getName()).find();
    }
}
