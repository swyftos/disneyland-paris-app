package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.urbanairship.channel.AttributeMutation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkRequestMetricKt {

    @NotNull
    public static final NetworkRequestMetricKt INSTANCE = new NetworkRequestMetricKt();

    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010$\n\u0002\b\u001c\b\u0007\u0018\u0000 \u009f\u00012\u00020\u0001:\u000e\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010Y\u001a\u00020ZH\u0001J\u0006\u0010[\u001a\u00020\\J\u0006\u0010]\u001a\u00020\\J\u0006\u0010^\u001a\u00020\\J\u0006\u0010_\u001a\u00020\\J\u0006\u0010`\u001a\u00020\\J\u0006\u0010a\u001a\u00020\\J\u0006\u0010b\u001a\u00020\\J\u0006\u0010c\u001a\u00020\\J\u0006\u0010d\u001a\u00020\\J\u0006\u0010e\u001a\u00020\\J\u0006\u0010f\u001a\u00020\\J\u0006\u0010g\u001a\u00020\\J\u0006\u0010h\u001a\u00020\\J\u0006\u0010i\u001a\u00020\\J\u0006\u0010j\u001a\u00020\\J\u0006\u0010k\u001a\u00020\\J\u0006\u0010l\u001a\u00020\\J\u0006\u0010m\u001a\u00020nJ\u0006\u0010o\u001a\u00020nJ\u0006\u0010p\u001a\u00020nJ\u0006\u0010q\u001a\u00020nJ\u0006\u0010r\u001a\u00020nJ\u0006\u0010s\u001a\u00020nJ\u0006\u0010t\u001a\u00020nJ\u0006\u0010u\u001a\u00020nJ\u0006\u0010v\u001a\u00020nJ\u0006\u0010w\u001a\u00020nJ\u0006\u0010x\u001a\u00020nJ#\u0010y\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020#0\"H\u0007¢\u0006\u0002\bzJ#\u0010y\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0\"H\u0007¢\u0006\u0002\b{J#\u0010y\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020*0\"H\u0007¢\u0006\u0002\b|J#\u0010y\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020-0\"H\u0007¢\u0006\u0002\b}J#\u0010y\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020H0\"H\u0007¢\u0006\u0002\b~J#\u0010y\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020K0\"H\u0007¢\u0006\u0002\b\u007fJ6\u0010\u0080\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020#0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0082\u0001J6\u0010\u0080\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0083\u0001J6\u0010\u0080\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020*0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0084\u0001J6\u0010\u0080\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020-0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0085\u0001J6\u0010\u0080\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020H0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0086\u0001J6\u0010\u0080\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020K0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0087\u0001J;\u0010\u0088\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020#0\"2\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u008a\u0001H\u0007¢\u0006\u0003\b\u008b\u0001J;\u0010\u0088\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0\"2\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u008a\u0001H\u0007¢\u0006\u0003\b\u008c\u0001J;\u0010\u0088\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020*0\"2\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u008a\u0001H\u0007¢\u0006\u0003\b\u008d\u0001J;\u0010\u0088\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020-0\"2\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u008a\u0001H\u0007¢\u0006\u0003\b\u008e\u0001J;\u0010\u0088\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020H0\"2\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u008a\u0001H\u0007¢\u0006\u0003\b\u008f\u0001J;\u0010\u0088\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020K0\"2\u0014\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u008a\u0001H\u0007¢\u0006\u0003\b\u0090\u0001J.\u0010\u0091\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020#0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0092\u0001J.\u0010\u0091\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0093\u0001J.\u0010\u0091\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020*0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0094\u0001J.\u0010\u0091\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020-0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0095\u0001J.\u0010\u0091\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020H0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0096\u0001J.\u0010\u0091\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020K0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u0018H\u0007¢\u0006\u0003\b\u0097\u0001J7\u0010\u0098\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020#0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0003\b\u0099\u0001J7\u0010\u0098\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0003\b\u009a\u0001J7\u0010\u0098\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020*0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0003\b\u009b\u0001J7\u0010\u0098\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020-0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0003\b\u009c\u0001J7\u0010\u0098\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020H0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0003\b\u009d\u0001J7\u0010\u0098\u0001\u001a\u00020\\*\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020K0\"2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018H\u0087\n¢\u0006\u0003\b\u009e\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR#\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020#0\"8G¢\u0006\u0006\u001a\u0004\b$\u0010%R#\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020'0\"8G¢\u0006\u0006\u001a\u0004\b(\u0010%R#\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020*0\"8G¢\u0006\u0006\u001a\u0004\b+\u0010%R#\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020-0\"8G¢\u0006\u0006\u001a\u0004\b.\u0010%R$\u0010/\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010\u000bR$\u00102\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR$\u00105\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\t\"\u0004\b7\u0010\u000bR$\u00108\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017R$\u0010;\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR$\u0010>\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR$\u0010A\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017R$\u0010D\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010\u001dR#\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020H0\"8G¢\u0006\u0006\u001a\u0004\bI\u0010%R#\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020K0\"8G¢\u0006\u0006\u001a\u0004\bL\u0010%R$\u0010N\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020M8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010S\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\u0015\"\u0004\bU\u0010\u0017R$\u0010V\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\u001b\"\u0004\bX\u0010\u001d¨\u0006¦\u0001"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric$Builder;)V", "value", "Lcom/google/protobuf/ByteString;", "customRequestHeaders", "getCustomRequestHeaders", "()Lcom/google/protobuf/ByteString;", "setCustomRequestHeaders", "(Lcom/google/protobuf/ByteString;)V", "customResponseHeaders", "getCustomResponseHeaders", "setCustomResponseHeaders", "encryptedSymmetricKey", "getEncryptedSymmetricKey", "setEncryptedSymmetricKey", "", "encyptionPublicKeyId", "getEncyptionPublicKeyId", "()J", "setEncyptionPublicKeyId", "(J)V", "", "httpMethod", "getHttpMethod", "()Ljava/lang/String;", "setHttpMethod", "(Ljava/lang/String;)V", "initializationVector", "getInitializationVector", "setInitializationVector", "plainCustomRequestHeaders", "Lcom/google/protobuf/kotlin/DslMap;", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainCustomRequestHeadersProxy;", "getPlainCustomRequestHeadersMap", "()Lcom/google/protobuf/kotlin/DslMap;", "plainCustomResponseHeaders", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainCustomResponseHeadersProxy;", "getPlainCustomResponseHeadersMap", "plainRequestBodyAttributes", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainRequestBodyAttributesProxy;", "getPlainRequestBodyAttributesMap", "plainResponseBodyAttributes", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainResponseBodyAttributesProxy;", "getPlainResponseBodyAttributesMap", "queryParameters", "getQueryParameters", "setQueryParameters", "requestBody", "getRequestBody", "setRequestBody", "requestBodyAttributes", "getRequestBodyAttributes", "setRequestBodyAttributes", "requestTime", "getRequestTime", "setRequestTime", "responseBody", "getResponseBody", "setResponseBody", "responseBodyAttributes", "getResponseBodyAttributes", "setResponseBodyAttributes", "responseTime", "getResponseTime", "setResponseTime", "source", "getSource", "setSource", "standardRequestHeaders", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$StandardRequestHeadersProxy;", "getStandardRequestHeadersMap", "standardResponseHeaders", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$StandardResponseHeadersProxy;", "getStandardResponseHeadersMap", "", "statusCode", "getStatusCode", "()I", "setStatusCode", "(I)V", "unixTimestampMs", "getUnixTimestampMs", "setUnixTimestampMs", "url", "getUrl", "setUrl", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric;", "clearCustomRequestHeaders", "", "clearCustomResponseHeaders", "clearEncryptedSymmetricKey", "clearEncyptionPublicKeyId", "clearHttpMethod", "clearInitializationVector", "clearQueryParameters", "clearRequestBody", "clearRequestBodyAttributes", "clearRequestTime", "clearResponseBody", "clearResponseBodyAttributes", "clearResponseTime", "clearSource", "clearStatusCode", "clearUnixTimestampMs", "clearUrl", "hasCustomRequestHeaders", "", "hasCustomResponseHeaders", "hasEncryptedSymmetricKey", "hasEncyptionPublicKeyId", "hasInitializationVector", "hasQueryParameters", "hasRequestBody", "hasRequestBodyAttributes", "hasResponseBody", "hasResponseBodyAttributes", "hasSource", "clear", "clearPlainCustomRequestHeaders", "clearPlainCustomResponseHeaders", "clearPlainRequestBodyAttributes", "clearPlainResponseBodyAttributes", "clearStandardRequestHeaders", "clearStandardResponseHeaders", "put", "key", "putPlainCustomRequestHeaders", "putPlainCustomResponseHeaders", "putPlainRequestBodyAttributes", "putPlainResponseBodyAttributes", "putStandardRequestHeaders", "putStandardResponseHeaders", "putAll", "map", "", "putAllPlainCustomRequestHeaders", "putAllPlainCustomResponseHeaders", "putAllPlainRequestBodyAttributes", "putAllPlainResponseBodyAttributes", "putAllStandardRequestHeaders", "putAllStandardResponseHeaders", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "removePlainCustomRequestHeaders", "removePlainCustomResponseHeaders", "removePlainRequestBodyAttributes", "removePlainResponseBodyAttributes", "removeStandardRequestHeaders", "removeStandardResponseHeaders", AttributeMutation.ATTRIBUTE_ACTION_SET, "setPlainCustomRequestHeaders", "setPlainCustomResponseHeaders", "setPlainRequestBodyAttributes", "setPlainResponseBodyAttributes", "setStandardRequestHeaders", "setStandardResponseHeaders", "Companion", "PlainCustomRequestHeadersProxy", "PlainCustomResponseHeadersProxy", "PlainRequestBodyAttributesProxy", "PlainResponseBodyAttributesProxy", "StandardRequestHeadersProxy", "StandardResponseHeadersProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.NetworkRequestMetric.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$NetworkRequestMetric$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.NetworkRequestMetric.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainCustomRequestHeadersProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PlainCustomRequestHeadersProxy extends DslProxy {
            private PlainCustomRequestHeadersProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainCustomResponseHeadersProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PlainCustomResponseHeadersProxy extends DslProxy {
            private PlainCustomResponseHeadersProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainRequestBodyAttributesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PlainRequestBodyAttributesProxy extends DslProxy {
            private PlainRequestBodyAttributesProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$PlainResponseBodyAttributesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PlainResponseBodyAttributesProxy extends DslProxy {
            private PlainResponseBodyAttributesProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$StandardRequestHeadersProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class StandardRequestHeadersProxy extends DslProxy {
            private StandardRequestHeadersProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKt$Dsl$StandardResponseHeadersProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class StandardResponseHeadersProxy extends DslProxy {
            private StandardResponseHeadersProxy() {
            }
        }

        private Dsl(SessionRecordingV1.NetworkRequestMetric.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.NetworkRequestMetric _build() {
            SessionRecordingV1.NetworkRequestMetric networkRequestMetricBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(networkRequestMetricBuild, "_builder.build()");
            return networkRequestMetricBuild;
        }

        public final void clearCustomRequestHeaders() {
            this._builder.clearCustomRequestHeaders();
        }

        public final void clearCustomResponseHeaders() {
            this._builder.clearCustomResponseHeaders();
        }

        public final void clearEncryptedSymmetricKey() {
            this._builder.clearEncryptedSymmetricKey();
        }

        public final void clearEncyptionPublicKeyId() {
            this._builder.clearEncyptionPublicKeyId();
        }

        public final void clearHttpMethod() {
            this._builder.clearHttpMethod();
        }

        public final void clearInitializationVector() {
            this._builder.clearInitializationVector();
        }

        @JvmName(name = "clearPlainCustomRequestHeaders")
        public final /* synthetic */ void clearPlainCustomRequestHeaders(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearPlainCustomRequestHeaders();
        }

        @JvmName(name = "clearPlainCustomResponseHeaders")
        public final /* synthetic */ void clearPlainCustomResponseHeaders(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearPlainCustomResponseHeaders();
        }

        @JvmName(name = "clearPlainRequestBodyAttributes")
        public final /* synthetic */ void clearPlainRequestBodyAttributes(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearPlainRequestBodyAttributes();
        }

        @JvmName(name = "clearPlainResponseBodyAttributes")
        public final /* synthetic */ void clearPlainResponseBodyAttributes(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearPlainResponseBodyAttributes();
        }

        public final void clearQueryParameters() {
            this._builder.clearQueryParameters();
        }

        public final void clearRequestBody() {
            this._builder.clearRequestBody();
        }

        public final void clearRequestBodyAttributes() {
            this._builder.clearRequestBodyAttributes();
        }

        public final void clearRequestTime() {
            this._builder.clearRequestTime();
        }

        public final void clearResponseBody() {
            this._builder.clearResponseBody();
        }

        public final void clearResponseBodyAttributes() {
            this._builder.clearResponseBodyAttributes();
        }

        public final void clearResponseTime() {
            this._builder.clearResponseTime();
        }

        public final void clearSource() {
            this._builder.clearSource();
        }

        @JvmName(name = "clearStandardRequestHeaders")
        public final /* synthetic */ void clearStandardRequestHeaders(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearStandardRequestHeaders();
        }

        @JvmName(name = "clearStandardResponseHeaders")
        public final /* synthetic */ void clearStandardResponseHeaders(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearStandardResponseHeaders();
        }

        public final void clearStatusCode() {
            this._builder.clearStatusCode();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        public final void clearUrl() {
            this._builder.clearUrl();
        }

        @JvmName(name = "getCustomRequestHeaders")
        @NotNull
        public final ByteString getCustomRequestHeaders() {
            ByteString customRequestHeaders = this._builder.getCustomRequestHeaders();
            Intrinsics.checkNotNullExpressionValue(customRequestHeaders, "_builder.getCustomRequestHeaders()");
            return customRequestHeaders;
        }

        @JvmName(name = "getCustomResponseHeaders")
        @NotNull
        public final ByteString getCustomResponseHeaders() {
            ByteString customResponseHeaders = this._builder.getCustomResponseHeaders();
            Intrinsics.checkNotNullExpressionValue(customResponseHeaders, "_builder.getCustomResponseHeaders()");
            return customResponseHeaders;
        }

        @JvmName(name = "getEncryptedSymmetricKey")
        @NotNull
        public final ByteString getEncryptedSymmetricKey() {
            ByteString encryptedSymmetricKey = this._builder.getEncryptedSymmetricKey();
            Intrinsics.checkNotNullExpressionValue(encryptedSymmetricKey, "_builder.getEncryptedSymmetricKey()");
            return encryptedSymmetricKey;
        }

        @JvmName(name = "getEncyptionPublicKeyId")
        public final long getEncyptionPublicKeyId() {
            return this._builder.getEncyptionPublicKeyId();
        }

        @JvmName(name = "getHttpMethod")
        @NotNull
        public final String getHttpMethod() {
            String httpMethod = this._builder.getHttpMethod();
            Intrinsics.checkNotNullExpressionValue(httpMethod, "_builder.getHttpMethod()");
            return httpMethod;
        }

        @JvmName(name = "getInitializationVector")
        @NotNull
        public final ByteString getInitializationVector() {
            ByteString initializationVector = this._builder.getInitializationVector();
            Intrinsics.checkNotNullExpressionValue(initializationVector, "_builder.getInitializationVector()");
            return initializationVector;
        }

        @JvmName(name = "getPlainCustomRequestHeadersMap")
        public final /* synthetic */ DslMap getPlainCustomRequestHeadersMap() {
            Map<String, String> plainCustomRequestHeadersMap = this._builder.getPlainCustomRequestHeadersMap();
            Intrinsics.checkNotNullExpressionValue(plainCustomRequestHeadersMap, "_builder.getPlainCustomRequestHeadersMap()");
            return new DslMap(plainCustomRequestHeadersMap);
        }

        @JvmName(name = "getPlainCustomResponseHeadersMap")
        public final /* synthetic */ DslMap getPlainCustomResponseHeadersMap() {
            Map<String, String> plainCustomResponseHeadersMap = this._builder.getPlainCustomResponseHeadersMap();
            Intrinsics.checkNotNullExpressionValue(plainCustomResponseHeadersMap, "_builder.getPlainCustomResponseHeadersMap()");
            return new DslMap(plainCustomResponseHeadersMap);
        }

        @JvmName(name = "getPlainRequestBodyAttributesMap")
        public final /* synthetic */ DslMap getPlainRequestBodyAttributesMap() {
            Map<String, String> plainRequestBodyAttributesMap = this._builder.getPlainRequestBodyAttributesMap();
            Intrinsics.checkNotNullExpressionValue(plainRequestBodyAttributesMap, "_builder.getPlainRequestBodyAttributesMap()");
            return new DslMap(plainRequestBodyAttributesMap);
        }

        @JvmName(name = "getPlainResponseBodyAttributesMap")
        public final /* synthetic */ DslMap getPlainResponseBodyAttributesMap() {
            Map<String, String> plainResponseBodyAttributesMap = this._builder.getPlainResponseBodyAttributesMap();
            Intrinsics.checkNotNullExpressionValue(plainResponseBodyAttributesMap, "_builder.getPlainResponseBodyAttributesMap()");
            return new DslMap(plainResponseBodyAttributesMap);
        }

        @JvmName(name = "getQueryParameters")
        @NotNull
        public final ByteString getQueryParameters() {
            ByteString queryParameters = this._builder.getQueryParameters();
            Intrinsics.checkNotNullExpressionValue(queryParameters, "_builder.getQueryParameters()");
            return queryParameters;
        }

        @JvmName(name = "getRequestBody")
        @NotNull
        public final ByteString getRequestBody() {
            ByteString requestBody = this._builder.getRequestBody();
            Intrinsics.checkNotNullExpressionValue(requestBody, "_builder.getRequestBody()");
            return requestBody;
        }

        @JvmName(name = "getRequestBodyAttributes")
        @NotNull
        public final ByteString getRequestBodyAttributes() {
            ByteString requestBodyAttributes = this._builder.getRequestBodyAttributes();
            Intrinsics.checkNotNullExpressionValue(requestBodyAttributes, "_builder.getRequestBodyAttributes()");
            return requestBodyAttributes;
        }

        @JvmName(name = "getRequestTime")
        public final long getRequestTime() {
            return this._builder.getRequestTime();
        }

        @JvmName(name = "getResponseBody")
        @NotNull
        public final ByteString getResponseBody() {
            ByteString responseBody = this._builder.getResponseBody();
            Intrinsics.checkNotNullExpressionValue(responseBody, "_builder.getResponseBody()");
            return responseBody;
        }

        @JvmName(name = "getResponseBodyAttributes")
        @NotNull
        public final ByteString getResponseBodyAttributes() {
            ByteString responseBodyAttributes = this._builder.getResponseBodyAttributes();
            Intrinsics.checkNotNullExpressionValue(responseBodyAttributes, "_builder.getResponseBodyAttributes()");
            return responseBodyAttributes;
        }

        @JvmName(name = "getResponseTime")
        public final long getResponseTime() {
            return this._builder.getResponseTime();
        }

        @JvmName(name = "getSource")
        @NotNull
        public final String getSource() {
            String source = this._builder.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "_builder.getSource()");
            return source;
        }

        @JvmName(name = "getStandardRequestHeadersMap")
        public final /* synthetic */ DslMap getStandardRequestHeadersMap() {
            Map<String, String> standardRequestHeadersMap = this._builder.getStandardRequestHeadersMap();
            Intrinsics.checkNotNullExpressionValue(standardRequestHeadersMap, "_builder.getStandardRequestHeadersMap()");
            return new DslMap(standardRequestHeadersMap);
        }

        @JvmName(name = "getStandardResponseHeadersMap")
        public final /* synthetic */ DslMap getStandardResponseHeadersMap() {
            Map<String, String> standardResponseHeadersMap = this._builder.getStandardResponseHeadersMap();
            Intrinsics.checkNotNullExpressionValue(standardResponseHeadersMap, "_builder.getStandardResponseHeadersMap()");
            return new DslMap(standardResponseHeadersMap);
        }

        @JvmName(name = "getStatusCode")
        public final int getStatusCode() {
            return this._builder.getStatusCode();
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        @JvmName(name = "getUrl")
        @NotNull
        public final String getUrl() {
            String url = this._builder.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "_builder.getUrl()");
            return url;
        }

        public final boolean hasCustomRequestHeaders() {
            return this._builder.hasCustomRequestHeaders();
        }

        public final boolean hasCustomResponseHeaders() {
            return this._builder.hasCustomResponseHeaders();
        }

        public final boolean hasEncryptedSymmetricKey() {
            return this._builder.hasEncryptedSymmetricKey();
        }

        public final boolean hasEncyptionPublicKeyId() {
            return this._builder.hasEncyptionPublicKeyId();
        }

        public final boolean hasInitializationVector() {
            return this._builder.hasInitializationVector();
        }

        public final boolean hasQueryParameters() {
            return this._builder.hasQueryParameters();
        }

        public final boolean hasRequestBody() {
            return this._builder.hasRequestBody();
        }

        public final boolean hasRequestBodyAttributes() {
            return this._builder.hasRequestBodyAttributes();
        }

        public final boolean hasResponseBody() {
            return this._builder.hasResponseBody();
        }

        public final boolean hasResponseBodyAttributes() {
            return this._builder.hasResponseBodyAttributes();
        }

        public final boolean hasSource() {
            return this._builder.hasSource();
        }

        @JvmName(name = "putAllPlainCustomRequestHeaders")
        public final /* synthetic */ void putAllPlainCustomRequestHeaders(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllPlainCustomRequestHeaders(map);
        }

        @JvmName(name = "putAllPlainCustomResponseHeaders")
        public final /* synthetic */ void putAllPlainCustomResponseHeaders(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllPlainCustomResponseHeaders(map);
        }

        @JvmName(name = "putAllPlainRequestBodyAttributes")
        public final /* synthetic */ void putAllPlainRequestBodyAttributes(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllPlainRequestBodyAttributes(map);
        }

        @JvmName(name = "putAllPlainResponseBodyAttributes")
        public final /* synthetic */ void putAllPlainResponseBodyAttributes(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllPlainResponseBodyAttributes(map);
        }

        @JvmName(name = "putAllStandardRequestHeaders")
        public final /* synthetic */ void putAllStandardRequestHeaders(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllStandardRequestHeaders(map);
        }

        @JvmName(name = "putAllStandardResponseHeaders")
        public final /* synthetic */ void putAllStandardResponseHeaders(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllStandardResponseHeaders(map);
        }

        @JvmName(name = "putPlainCustomRequestHeaders")
        public final void putPlainCustomRequestHeaders(DslMap<String, String, PlainCustomRequestHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putPlainCustomRequestHeaders(key, value);
        }

        @JvmName(name = "putPlainCustomResponseHeaders")
        public final void putPlainCustomResponseHeaders(DslMap<String, String, PlainCustomResponseHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putPlainCustomResponseHeaders(key, value);
        }

        @JvmName(name = "putPlainRequestBodyAttributes")
        public final void putPlainRequestBodyAttributes(DslMap<String, String, PlainRequestBodyAttributesProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putPlainRequestBodyAttributes(key, value);
        }

        @JvmName(name = "putPlainResponseBodyAttributes")
        public final void putPlainResponseBodyAttributes(DslMap<String, String, PlainResponseBodyAttributesProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putPlainResponseBodyAttributes(key, value);
        }

        @JvmName(name = "putStandardRequestHeaders")
        public final void putStandardRequestHeaders(DslMap<String, String, StandardRequestHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putStandardRequestHeaders(key, value);
        }

        @JvmName(name = "putStandardResponseHeaders")
        public final void putStandardResponseHeaders(DslMap<String, String, StandardResponseHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putStandardResponseHeaders(key, value);
        }

        @JvmName(name = "removePlainCustomRequestHeaders")
        public final /* synthetic */ void removePlainCustomRequestHeaders(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removePlainCustomRequestHeaders(key);
        }

        @JvmName(name = "removePlainCustomResponseHeaders")
        public final /* synthetic */ void removePlainCustomResponseHeaders(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removePlainCustomResponseHeaders(key);
        }

        @JvmName(name = "removePlainRequestBodyAttributes")
        public final /* synthetic */ void removePlainRequestBodyAttributes(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removePlainRequestBodyAttributes(key);
        }

        @JvmName(name = "removePlainResponseBodyAttributes")
        public final /* synthetic */ void removePlainResponseBodyAttributes(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removePlainResponseBodyAttributes(key);
        }

        @JvmName(name = "removeStandardRequestHeaders")
        public final /* synthetic */ void removeStandardRequestHeaders(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removeStandardRequestHeaders(key);
        }

        @JvmName(name = "removeStandardResponseHeaders")
        public final /* synthetic */ void removeStandardResponseHeaders(DslMap dslMap, String key) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            this._builder.removeStandardResponseHeaders(key);
        }

        @JvmName(name = "setCustomRequestHeaders")
        public final void setCustomRequestHeaders(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCustomRequestHeaders(value);
        }

        @JvmName(name = "setCustomResponseHeaders")
        public final void setCustomResponseHeaders(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setCustomResponseHeaders(value);
        }

        @JvmName(name = "setEncryptedSymmetricKey")
        public final void setEncryptedSymmetricKey(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEncryptedSymmetricKey(value);
        }

        @JvmName(name = "setEncyptionPublicKeyId")
        public final void setEncyptionPublicKeyId(long j) {
            this._builder.setEncyptionPublicKeyId(j);
        }

        @JvmName(name = "setHttpMethod")
        public final void setHttpMethod(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setHttpMethod(value);
        }

        @JvmName(name = "setInitializationVector")
        public final void setInitializationVector(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setInitializationVector(value);
        }

        @JvmName(name = "setPlainCustomRequestHeaders")
        public final /* synthetic */ void setPlainCustomRequestHeaders(DslMap<String, String, PlainCustomRequestHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putPlainCustomRequestHeaders(dslMap, key, value);
        }

        @JvmName(name = "setPlainCustomResponseHeaders")
        public final /* synthetic */ void setPlainCustomResponseHeaders(DslMap<String, String, PlainCustomResponseHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putPlainCustomResponseHeaders(dslMap, key, value);
        }

        @JvmName(name = "setPlainRequestBodyAttributes")
        public final /* synthetic */ void setPlainRequestBodyAttributes(DslMap<String, String, PlainRequestBodyAttributesProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putPlainRequestBodyAttributes(dslMap, key, value);
        }

        @JvmName(name = "setPlainResponseBodyAttributes")
        public final /* synthetic */ void setPlainResponseBodyAttributes(DslMap<String, String, PlainResponseBodyAttributesProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putPlainResponseBodyAttributes(dslMap, key, value);
        }

        @JvmName(name = "setQueryParameters")
        public final void setQueryParameters(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setQueryParameters(value);
        }

        @JvmName(name = "setRequestBody")
        public final void setRequestBody(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRequestBody(value);
        }

        @JvmName(name = "setRequestBodyAttributes")
        public final void setRequestBodyAttributes(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setRequestBodyAttributes(value);
        }

        @JvmName(name = "setRequestTime")
        public final void setRequestTime(long j) {
            this._builder.setRequestTime(j);
        }

        @JvmName(name = "setResponseBody")
        public final void setResponseBody(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setResponseBody(value);
        }

        @JvmName(name = "setResponseBodyAttributes")
        public final void setResponseBodyAttributes(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setResponseBodyAttributes(value);
        }

        @JvmName(name = "setResponseTime")
        public final void setResponseTime(long j) {
            this._builder.setResponseTime(j);
        }

        @JvmName(name = "setSource")
        public final void setSource(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSource(value);
        }

        @JvmName(name = "setStandardRequestHeaders")
        public final /* synthetic */ void setStandardRequestHeaders(DslMap<String, String, StandardRequestHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putStandardRequestHeaders(dslMap, key, value);
        }

        @JvmName(name = "setStandardResponseHeaders")
        public final /* synthetic */ void setStandardResponseHeaders(DslMap<String, String, StandardResponseHeadersProxy> dslMap, String key, String value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            putStandardResponseHeaders(dslMap, key, value);
        }

        @JvmName(name = "setStatusCode")
        public final void setStatusCode(int i) {
            this._builder.setStatusCode(i);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        @JvmName(name = "setUrl")
        public final void setUrl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setUrl(value);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.NetworkRequestMetric.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private NetworkRequestMetricKt() {
    }
}
