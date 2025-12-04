package com.urbanairship.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"readFully", "", "Ljava/io/InputStream;", "write", "", "Ljava/io/OutputStream;", "content", "gzip", "", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultHttpClient.kt\ncom/urbanairship/http/DefaultHttpClientKt\n+ 2 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,122:1\n52#2:123\n1#3:124\n1#3:128\n1284#4,3:125\n*S KotlinDebug\n*F\n+ 1 DefaultHttpClient.kt\ncom/urbanairship/http/DefaultHttpClientKt\n*L\n104#1:123\n104#1:124\n105#1:125,3\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultHttpClientKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String readFully(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
        try {
            Sequence<String> sequenceLineSequence = TextStreamsKt.lineSequence(bufferedReader);
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = sequenceLineSequence.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
            String string = sb.toString();
            CloseableKt.closeFinally(bufferedReader, null);
            Intrinsics.checkNotNullExpressionValue(string, "useLines(...)");
            return string;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void write(OutputStream outputStream, String str, boolean z) {
        OutputStreamWriter outputStreamWriter;
        if (z) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, Charsets.UTF_8);
                try {
                    outputStreamWriter.write(str);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStreamWriter, null);
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(gZIPOutputStream, th);
                    throw th2;
                }
            }
        } else {
            outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.UTF_8);
            try {
                outputStreamWriter.write(str);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStreamWriter, null);
            } catch (Throwable th3) {
                try {
                    throw th3;
                } finally {
                }
            }
        }
    }
}
