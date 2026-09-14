package kotlin.p163io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
final class FileVisitorImpl extends SimpleFileVisitor {
    private final Function2 onPostVisitDirectory;
    private final Function2 onPreVisitDirectory;
    private final Function2 onVisitFile;
    private final Function2 onVisitFileFailed;

    public FileVisitorImpl(Function2 function2, Function2 function3, Function2 function4, Function2 function5) {
        this.onPreVisitDirectory = function2;
        this.onVisitFile = function3;
        this.onVisitFileFailed = function4;
        this.onPostVisitDirectory = function5;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Function2 function2 = this.onPreVisitDirectory;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(dir, attrs)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Function2 function2 = this.onVisitFile;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(file, attrs)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(exc, "exc");
        Function2 function2 = this.onVisitFileFailed;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(file, exc)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultVisitFileFailed = super.visitFileFailed(file, exc);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFileFailed, "visitFileFailed(...)");
        return fileVisitResultVisitFileFailed;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult postVisitDirectory(Path dir, IOException iOException) throws IOException {
        FileVisitResult fileVisitResult;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Function2 function2 = this.onPostVisitDirectory;
        if (function2 != null && (fileVisitResult = (FileVisitResult) function2.invoke(dir, iOException)) != null) {
            return fileVisitResult;
        }
        FileVisitResult fileVisitResultPostVisitDirectory = super.postVisitDirectory(dir, iOException);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPostVisitDirectory, "postVisitDirectory(...)");
        return fileVisitResultPostVisitDirectory;
    }
}
