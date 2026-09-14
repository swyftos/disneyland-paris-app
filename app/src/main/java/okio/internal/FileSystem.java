package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000¨\u0006\u001c"}, m1836d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", TypedValues.AttributesType.S_TARGET, "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
@JvmName(name = "-FileSystem")
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n52#2,4:156\n52#2,22:160\n60#2,10:182\n56#2,3:192\n71#2,3:195\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n*L\n65#1:156,4\n66#1:160,22\n65#1:182,10\n65#1:192,3\n65#1:195,3\n*E\n"})
public final class FileSystem {

    /* JADX INFO: renamed from: okio.internal.-FileSystem$collectRecursively$1 */
    static final class C75151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C75151(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(@NotNull okio.FileSystem fileSystem, @NotNull Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path pathParent = dir; pathParent != null && !fileSystem.exists(pathParent); pathParent = pathParent.parent()) {
            arrayDeque.addFirst(pathParent);
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonCopy(@NotNull okio.FileSystem fileSystem, @NotNull Path source, @NotNull Path target) throws IOException {
        Throwable th;
        Throwable th2;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Source source2 = fileSystem.source(source);
        try {
            BufferedSink bufferedSinkBuffer = Okio.buffer(fileSystem.sink(target));
            th = null;
            try {
                lValueOf = Long.valueOf(bufferedSinkBuffer.writeAll(source2));
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                }
                th2 = null;
            } catch (Throwable th4) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th5) {
                        ExceptionsKt.addSuppressed(th4, th5);
                    }
                }
                th2 = th4;
                lValueOf = null;
            }
            if (th2 != null) {
                throw th2;
            }
            lValueOf.longValue();
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (th != null) {
                throw th;
            }
        } catch (Throwable th7) {
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th8) {
                    ExceptionsKt.addSuppressed(th7, th8);
                }
            }
            th = th7;
        }
    }

    public static final void commonDeleteRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path fileOrDirectory, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Iterator it = SequencesKt.sequence(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    /* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1 */
    static final class C75161 extends RestrictedSuspendLambda implements Function2 {
        final /* synthetic */ Path $dir;
        final /* synthetic */ boolean $followSymlinks;
        final /* synthetic */ okio.FileSystem $this_commonListRecursively;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C75161(Path path, okio.FileSystem fileSystem, boolean z, Continuation continuation) {
            super(2, continuation);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C75161 c75161 = new C75161(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
            c75161.L$0 = obj;
            return c75161;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
            return ((C75161) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceScope sequenceScope;
            ArrayDeque arrayDeque;
            Iterator<Path> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
                ArrayDeque arrayDeque2 = new ArrayDeque();
                arrayDeque2.addLast(this.$dir);
                sequenceScope = sequenceScope2;
                arrayDeque = arrayDeque2;
                it = this.$this_commonListRecursively.list(this.$dir).iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                ArrayDeque arrayDeque3 = (ArrayDeque) this.L$1;
                SequenceScope sequenceScope3 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                arrayDeque = arrayDeque3;
                sequenceScope = sequenceScope3;
            }
            while (it.hasNext()) {
                Path next = it.next();
                okio.FileSystem fileSystem = this.$this_commonListRecursively;
                boolean z = this.$followSymlinks;
                this.L$0 = sequenceScope;
                this.L$1 = arrayDeque;
                this.L$2 = it;
                this.label = 1;
                if (FileSystem.collectRecursively(sequenceScope, fileSystem, arrayDeque, next, z, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull okio.FileSystem fileSystem, @NotNull Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new C75161(dir, fileSystem, z, null));
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f3 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:17:0x0058, B:48:0x00ed, B:50:0x00f3), top: B:69:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x012f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0142 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0146  */
    /* JADX WARN: Code duplicated, block: B:72:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[LOOP:0: B:48:0x00ed->B:74:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.Object, kotlin.sequences.SequenceScope, kotlin.sequences.SequenceScope<? super okio.Path>] */
    /* JADX WARN: Type inference failed for: r15v1, types: [kotlin.sequences.SequenceScope] */
    @Nullable
    public static final Object collectRecursively(@NotNull SequenceScope<? super Path> sequenceScope, @NotNull okio.FileSystem fileSystem, @NotNull ArrayDeque<Path> arrayDeque, @NotNull Path path, boolean z, boolean z2, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        C75151 c75151;
        okio.FileSystem fileSystem2;
        ArrayDeque<Path> arrayDeque2;
        boolean z3;
        okio.FileSystem fileSystem3;
        ?? r11;
        boolean z4;
        ArrayDeque<Path> arrayDeque3;
        Path path2;
        boolean z5;
        boolean z6;
        Iterator<Path> it;
        Path next;
        Path path3 = path;
        boolean z7 = z2;
        if (continuation instanceof C75151) {
            c75151 = (C75151) continuation;
            int i = c75151.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c75151.label = i - Integer.MIN_VALUE;
            } else {
                c75151 = new C75151(continuation);
            }
        } else {
            c75151 = new C75151(continuation);
        }
        Object obj = c75151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c75151.label;
        int i3 = 0;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (z7) {
                fileSystem2 = fileSystem;
                arrayDeque2 = arrayDeque;
                z3 = z;
            } else {
                c75151.L$0 = sequenceScope;
                fileSystem2 = fileSystem;
                c75151.L$1 = fileSystem2;
                arrayDeque2 = arrayDeque;
                c75151.L$2 = arrayDeque2;
                c75151.L$3 = path3;
                z3 = z;
                c75151.Z$0 = z3;
                c75151.Z$1 = z7;
                c75151.label = 1;
                if (sequenceScope.yield(path3, c75151) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            fileSystem3 = fileSystem2;
            boolean z8 = z3;
            r11 = sequenceScope;
            z4 = z8;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    z6 = c75151.Z$1;
                    z5 = c75151.Z$0;
                    it = (Iterator) c75151.L$4;
                    path2 = (Path) c75151.L$3;
                    arrayDeque3 = (ArrayDeque) c75151.L$2;
                    fileSystem3 = (okio.FileSystem) c75151.L$1;
                    SequenceScope sequenceScope2 = (SequenceScope) c75151.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        r11 = sequenceScope2;
                        while (it.hasNext()) {
                            next = it.next();
                            c75151.L$0 = r11;
                            c75151.L$1 = fileSystem3;
                            c75151.L$2 = arrayDeque3;
                            c75151.L$3 = path2;
                            c75151.L$4 = it;
                            c75151.Z$0 = z5;
                            c75151.Z$1 = z6;
                            c75151.label = 2;
                            if (collectRecursively(r11, fileSystem3, arrayDeque3, next, z5, z6, c75151) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        arrayDeque3.removeLast();
                        z7 = z6;
                        path3 = path2;
                        if (z7) {
                            return Unit.INSTANCE;
                        }
                        c75151.L$0 = null;
                        c75151.L$1 = null;
                        c75151.L$2 = null;
                        c75151.L$3 = null;
                        c75151.L$4 = null;
                        c75151.label = 3;
                        if (r11.yield(path3, c75151) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        th = th;
                        arrayDeque3.removeLast();
                        throw th;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            boolean z9 = c75151.Z$1;
            boolean z10 = c75151.Z$0;
            Path path4 = (Path) c75151.L$3;
            arrayDeque2 = (ArrayDeque) c75151.L$2;
            fileSystem3 = (okio.FileSystem) c75151.L$1;
            SequenceScope sequenceScope3 = (SequenceScope) c75151.L$0;
            ResultKt.throwOnFailure(obj);
            z7 = z9;
            z4 = z10;
            path3 = path4;
            r11 = sequenceScope3;
        }
        List<Path> listListOrNull = fileSystem3.listOrNull(path3);
        if (listListOrNull == null) {
            listListOrNull = CollectionsKt.emptyList();
        }
        if (!listListOrNull.isEmpty()) {
            Path path5 = path3;
            while (true) {
                if (z4 && arrayDeque2.contains(path5)) {
                    throw new IOException("symlink cycle at " + path3);
                }
                Path pathSymlinkTarget = symlinkTarget(fileSystem3, path5);
                if (pathSymlinkTarget != null) {
                    i3++;
                    path5 = pathSymlinkTarget;
                } else if (z4 || i3 == 0) {
                    arrayDeque2.addLast(path5);
                    try {
                        arrayDeque3 = arrayDeque2;
                        path2 = path3;
                        z5 = z4;
                        z6 = z7;
                        it = listListOrNull.iterator();
                        r11 = r11;
                        while (it.hasNext()) {
                            next = it.next();
                            c75151.L$0 = r11;
                            c75151.L$1 = fileSystem3;
                            c75151.L$2 = arrayDeque3;
                            c75151.L$3 = path2;
                            c75151.L$4 = it;
                            c75151.Z$0 = z5;
                            c75151.Z$1 = z6;
                            c75151.label = 2;
                            if (collectRecursively(r11, fileSystem3, arrayDeque3, next, z5, z6, c75151) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        arrayDeque3.removeLast();
                        z7 = z6;
                        path3 = path2;
                    } catch (Throwable th2) {
                        th = th2;
                        arrayDeque3 = arrayDeque2;
                        arrayDeque3.removeLast();
                        throw th;
                    }
                }
            }
        }
        if (z7) {
            return Unit.INSTANCE;
        }
        c75151.L$0 = null;
        c75151.L$1 = null;
        c75151.L$2 = null;
        c75151.L$3 = null;
        c75151.L$4 = null;
        c75151.label = 3;
        if (r11.yield(path3, c75151) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull okio.FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path pathParent = path.parent();
        Intrinsics.checkNotNull(pathParent);
        return pathParent.resolve(symlinkTarget);
    }
}
