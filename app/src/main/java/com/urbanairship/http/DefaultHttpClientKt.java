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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p163io.CloseableKt;
import kotlin.p163io.TextStreamsKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, m1836d2 = {"readFully", "", "Ljava/io/InputStream;", "write", "", "Ljava/io/OutputStream;", "content", "gzip", "", "urbanairship-core_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nDefaultHttpClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultHttpClient.kt\ncom/urbanairship/http/DefaultHttpClientKt\n+ 2 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,122:1\n52#2:123\n1#3:124\n1#3:128\n1284#4,3:125\n*S KotlinDebug\n*F\n+ 1 DefaultHttpClient.kt\ncom/urbanairship/http/DefaultHttpClientKt\n*L\n104#1:123\n104#1:124\n105#1:125,3\n*E\n"})
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
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void write(OutputStream outputStream, String str, boolean z) {
        if (z) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, Charsets.UTF_8);
                try {
                    outputStreamWriter.write(str);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStreamWriter, null);
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(outputStreamWriter, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(gZIPOutputStream, th3);
                    throw th4;
                }
            }
        }
        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(outputStream, Charsets.UTF_8);
        try {
            outputStreamWriter2.write(str);
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter2, null);
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(outputStreamWriter2, th5);
                throw th6;
            }
        }
    }
}
