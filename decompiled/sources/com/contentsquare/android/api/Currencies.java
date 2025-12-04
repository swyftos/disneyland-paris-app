package com.contentsquare.android.api;

import com.contentsquare.android.sdk.R0;
import com.contentsquare.android.sdk.S0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0003\b¶\u0001\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006Ä\u0001Å\u0001Æ\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010¿\u0001\u001a\u0010\u0012\u0005\u0012\u00030¼\u0001\u0012\u0004\u0012\u00020\u00040»\u0001H\u0002J\u0010\u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040¾\u0001H\u0002J\u0010\u0010Á\u0001\u001a\u00020\u00042\u0007\u0010Â\u0001\u001a\u00020\u0004J\u0011\u0010Ã\u0001\u001a\u00020\u00042\b\u0010Â\u0001\u001a\u00030¼\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010«\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¬\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010±\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010²\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010³\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010´\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010µ\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010·\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¸\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¹\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010º\u0001\u001a\u0010\u0012\u0005\u0012\u00030¼\u0001\u0012\u0004\u0012\u00020\u00040»\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010½\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040¾\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ç\u0001"}, d2 = {"Lcom/contentsquare/android/api/Currencies;", "", "()V", AlphabeticCode.AED_STR, "", AlphabeticCode.AFN_STR, "ALL", AlphabeticCode.AMD_STR, AlphabeticCode.ANG_STR, AlphabeticCode.AOA_STR, AlphabeticCode.ARS_STR, AlphabeticCode.AUD_STR, AlphabeticCode.AWG_STR, AlphabeticCode.AZN_STR, AlphabeticCode.BAM_STR, AlphabeticCode.BBD_STR, AlphabeticCode.BDT_STR, AlphabeticCode.BGN_STR, AlphabeticCode.BHD_STR, AlphabeticCode.BIF_STR, AlphabeticCode.BMD_STR, AlphabeticCode.BND_STR, AlphabeticCode.BOB_STR, AlphabeticCode.BOV_STR, AlphabeticCode.BRL_STR, AlphabeticCode.BSD_STR, AlphabeticCode.BTN_STR, AlphabeticCode.BWP_STR, AlphabeticCode.BYN_STR, AlphabeticCode.BZD_STR, AlphabeticCode.CAD_STR, AlphabeticCode.CDF_STR, AlphabeticCode.CHE_STR, AlphabeticCode.CHF_STR, AlphabeticCode.CHW_STR, AlphabeticCode.CLF_STR, AlphabeticCode.CLP_STR, AlphabeticCode.CNY_STR, AlphabeticCode.COP_STR, AlphabeticCode.COU_STR, AlphabeticCode.CRC_STR, AlphabeticCode.CUC_STR, AlphabeticCode.CUP_STR, AlphabeticCode.CVE_STR, AlphabeticCode.CZK_STR, AlphabeticCode.DJF_STR, AlphabeticCode.DKK_STR, AlphabeticCode.DOP_STR, AlphabeticCode.DZD_STR, AlphabeticCode.EGP_STR, AlphabeticCode.ERN_STR, AlphabeticCode.ETB_STR, AlphabeticCode.EUR_STR, AlphabeticCode.FJD_STR, AlphabeticCode.FKP_STR, AlphabeticCode.GBP_STR, AlphabeticCode.GEL_STR, AlphabeticCode.GHS_STR, AlphabeticCode.GIP_STR, AlphabeticCode.GMD_STR, AlphabeticCode.GNF_STR, AlphabeticCode.GTQ_STR, AlphabeticCode.GYD_STR, AlphabeticCode.HKD_STR, AlphabeticCode.HNL_STR, AlphabeticCode.HRK_STR, AlphabeticCode.HTG_STR, AlphabeticCode.HUF_STR, AlphabeticCode.IDR_STR, AlphabeticCode.ILS_STR, AlphabeticCode.INR_STR, AlphabeticCode.IQD_STR, AlphabeticCode.IRR_STR, AlphabeticCode.ISK_STR, AlphabeticCode.JMD_STR, AlphabeticCode.JOD_STR, AlphabeticCode.JPY_STR, AlphabeticCode.KES_STR, AlphabeticCode.KGS_STR, AlphabeticCode.KHR_STR, AlphabeticCode.KMF_STR, AlphabeticCode.KPW_STR, AlphabeticCode.KRW_STR, AlphabeticCode.KWD_STR, AlphabeticCode.KYD_STR, AlphabeticCode.KZT_STR, AlphabeticCode.LAK_STR, AlphabeticCode.LBP_STR, AlphabeticCode.LKR_STR, AlphabeticCode.LRD_STR, AlphabeticCode.LSL_STR, AlphabeticCode.LYD_STR, AlphabeticCode.MAD_STR, AlphabeticCode.MDL_STR, AlphabeticCode.MGA_STR, AlphabeticCode.MKD_STR, AlphabeticCode.MMK_STR, AlphabeticCode.MNT_STR, AlphabeticCode.MOP_STR, AlphabeticCode.MRU_STR, AlphabeticCode.MUR_STR, AlphabeticCode.MVR_STR, AlphabeticCode.MWK_STR, AlphabeticCode.MXN_STR, AlphabeticCode.MXV_STR, AlphabeticCode.MYR_STR, AlphabeticCode.MZN_STR, AlphabeticCode.NAD_STR, AlphabeticCode.NGN_STR, AlphabeticCode.NIO_STR, AlphabeticCode.NOK_STR, AlphabeticCode.NPR_STR, AlphabeticCode.NZD_STR, AlphabeticCode.OMR_STR, AlphabeticCode.PAB_STR, AlphabeticCode.PEN_STR, AlphabeticCode.PGK_STR, AlphabeticCode.PHP_STR, AlphabeticCode.PKR_STR, AlphabeticCode.PLN_STR, AlphabeticCode.PYG_STR, AlphabeticCode.QAR_STR, AlphabeticCode.RON_STR, AlphabeticCode.RSD_STR, AlphabeticCode.RUB_STR, AlphabeticCode.RWF_STR, AlphabeticCode.SAR_STR, AlphabeticCode.SBD_STR, AlphabeticCode.SCR_STR, AlphabeticCode.SDG_STR, AlphabeticCode.SEK_STR, AlphabeticCode.SGD_STR, AlphabeticCode.SHP_STR, AlphabeticCode.SLE_STR, AlphabeticCode.SLL_STR, AlphabeticCode.SOS_STR, AlphabeticCode.SRD_STR, AlphabeticCode.SSP_STR, AlphabeticCode.STN_STR, AlphabeticCode.SVC_STR, AlphabeticCode.SYP_STR, AlphabeticCode.SZL_STR, AlphabeticCode.THB_STR, AlphabeticCode.TJS_STR, AlphabeticCode.TMT_STR, AlphabeticCode.TND_STR, AlphabeticCode.TOP_STR, AlphabeticCode.TRY_STR, AlphabeticCode.TTD_STR, AlphabeticCode.TWD_STR, AlphabeticCode.TZS_STR, AlphabeticCode.UAH_STR, AlphabeticCode.UGX_STR, "UNKNOWN", AlphabeticCode.USD_STR, AlphabeticCode.USN_STR, AlphabeticCode.UYI_STR, AlphabeticCode.UYU_STR, AlphabeticCode.UYW_STR, AlphabeticCode.UZS_STR, AlphabeticCode.VED_STR, AlphabeticCode.VES_STR, AlphabeticCode.VND_STR, AlphabeticCode.VUV_STR, AlphabeticCode.WST_STR, AlphabeticCode.XAF_STR, AlphabeticCode.XAG_STR, AlphabeticCode.XAU_STR, AlphabeticCode.XBA_STR, AlphabeticCode.XBB_STR, AlphabeticCode.XBC_STR, AlphabeticCode.XBD_STR, AlphabeticCode.XCD_STR, AlphabeticCode.XDR_STR, AlphabeticCode.XOF_STR, AlphabeticCode.XPD_STR, AlphabeticCode.XPF_STR, AlphabeticCode.XPT_STR, AlphabeticCode.XSU_STR, AlphabeticCode.XTS_STR, AlphabeticCode.XUA_STR, AlphabeticCode.XXX_STR, AlphabeticCode.YER_STR, AlphabeticCode.ZAR_STR, AlphabeticCode.ZMW_STR, AlphabeticCode.ZWL_STR, "currencyMap", "", "", "currencySet", "", "buildCurrencyMap", "buildCurrencySet", "fromInteger", "currency", "fromString", "AlphabeticCode", "Currency", "CurrencyStr", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Currencies {
    public static final int AED = 784;
    public static final int AFN = 971;
    public static final int ALL = 8;
    public static final int AMD = 51;
    public static final int ANG = 532;
    public static final int AOA = 973;
    public static final int ARS = 32;
    public static final int AUD = 36;
    public static final int AWG = 533;
    public static final int AZN = 944;
    public static final int BAM = 977;
    public static final int BBD = 52;
    public static final int BDT = 50;
    public static final int BGN = 975;
    public static final int BHD = 48;
    public static final int BIF = 108;
    public static final int BMD = 60;
    public static final int BND = 96;
    public static final int BOB = 68;
    public static final int BOV = 984;
    public static final int BRL = 986;
    public static final int BSD = 44;
    public static final int BTN = 64;
    public static final int BWP = 72;
    public static final int BYN = 933;
    public static final int BZD = 84;
    public static final int CAD = 124;
    public static final int CDF = 976;
    public static final int CHE = 947;
    public static final int CHF = 756;
    public static final int CHW = 948;
    public static final int CLF = 990;
    public static final int CLP = 152;
    public static final int CNY = 156;
    public static final int COP = 170;
    public static final int COU = 970;
    public static final int CRC = 188;
    public static final int CUC = 931;
    public static final int CUP = 192;
    public static final int CVE = 132;
    public static final int CZK = 203;
    public static final int DJF = 262;
    public static final int DKK = 208;
    public static final int DOP = 214;
    public static final int DZD = 12;
    public static final int EGP = 818;
    public static final int ERN = 232;
    public static final int ETB = 230;
    public static final int EUR = 978;
    public static final int FJD = 242;
    public static final int FKP = 238;
    public static final int GBP = 826;
    public static final int GEL = 981;
    public static final int GHS = 936;
    public static final int GIP = 292;
    public static final int GMD = 270;
    public static final int GNF = 324;
    public static final int GTQ = 320;
    public static final int GYD = 328;
    public static final int HKD = 344;
    public static final int HNL = 340;
    public static final int HRK = 191;
    public static final int HTG = 332;
    public static final int HUF = 348;
    public static final int IDR = 360;
    public static final int ILS = 376;
    public static final int INR = 356;

    @NotNull
    public static final Currencies INSTANCE;
    public static final int IQD = 368;
    public static final int IRR = 364;
    public static final int ISK = 352;
    public static final int JMD = 388;
    public static final int JOD = 400;
    public static final int JPY = 392;
    public static final int KES = 404;
    public static final int KGS = 417;
    public static final int KHR = 116;
    public static final int KMF = 174;
    public static final int KPW = 408;
    public static final int KRW = 410;
    public static final int KWD = 414;
    public static final int KYD = 136;
    public static final int KZT = 398;
    public static final int LAK = 418;
    public static final int LBP = 422;
    public static final int LKR = 144;
    public static final int LRD = 430;
    public static final int LSL = 426;
    public static final int LYD = 434;
    public static final int MAD = 504;
    public static final int MDL = 498;
    public static final int MGA = 969;
    public static final int MKD = 807;
    public static final int MMK = 104;
    public static final int MNT = 496;
    public static final int MOP = 446;
    public static final int MRU = 929;
    public static final int MUR = 480;
    public static final int MVR = 462;
    public static final int MWK = 454;
    public static final int MXN = 484;
    public static final int MXV = 979;
    public static final int MYR = 458;
    public static final int MZN = 943;
    public static final int NAD = 516;
    public static final int NGN = 566;
    public static final int NIO = 558;
    public static final int NOK = 578;
    public static final int NPR = 524;
    public static final int NZD = 554;
    public static final int OMR = 512;
    public static final int PAB = 590;
    public static final int PEN = 604;
    public static final int PGK = 598;
    public static final int PHP = 608;
    public static final int PKR = 586;
    public static final int PLN = 985;
    public static final int PYG = 600;
    public static final int QAR = 634;
    public static final int RON = 946;
    public static final int RSD = 941;
    public static final int RUB = 643;
    public static final int RWF = 646;
    public static final int SAR = 682;
    public static final int SBD = 90;
    public static final int SCR = 690;
    public static final int SDG = 938;
    public static final int SEK = 752;
    public static final int SGD = 702;
    public static final int SHP = 654;
    public static final int SLE = 925;
    public static final int SLL = 694;
    public static final int SOS = 706;
    public static final int SRD = 968;
    public static final int SSP = 728;
    public static final int STN = 930;
    public static final int SVC = 222;
    public static final int SYP = 760;
    public static final int SZL = 748;
    public static final int THB = 764;
    public static final int TJS = 972;
    public static final int TMT = 934;
    public static final int TND = 788;
    public static final int TOP = 776;
    public static final int TRY = 949;
    public static final int TTD = 780;
    public static final int TWD = 901;
    public static final int TZS = 834;
    public static final int UAH = 980;
    public static final int UGX = 800;
    public static final int UNKNOWN = -1;
    public static final int USD = 840;
    public static final int USN = 997;
    public static final int UYI = 940;
    public static final int UYU = 858;
    public static final int UYW = 927;
    public static final int UZS = 860;
    public static final int VED = 926;
    public static final int VES = 928;
    public static final int VND = 704;
    public static final int VUV = 548;
    public static final int WST = 882;
    public static final int XAF = 950;
    public static final int XAG = 961;
    public static final int XAU = 959;
    public static final int XBA = 955;
    public static final int XBB = 956;
    public static final int XBC = 957;
    public static final int XBD = 958;
    public static final int XCD = 951;
    public static final int XDR = 960;
    public static final int XOF = 952;
    public static final int XPD = 964;
    public static final int XPF = 953;
    public static final int XPT = 962;
    public static final int XSU = 994;
    public static final int XTS = 963;
    public static final int XUA = 965;
    public static final int XXX = 999;
    public static final int YER = 886;
    public static final int ZAR = 710;
    public static final int ZMW = 967;
    public static final int ZWL = 932;

    @NotNull
    private static final Map<String, Integer> currencyMap;

    @NotNull
    private static final Set<Integer> currencySet;

    @Metadata(d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0003\bµ\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010«\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¬\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010°\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010±\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010²\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010³\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010´\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010µ\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010·\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010¸\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/contentsquare/android/api/Currencies$AlphabeticCode;", "", "()V", "AED_STR", "", "AFN_STR", "ALL_STR", "AMD_STR", "ANG_STR", "AOA_STR", "ARS_STR", "AUD_STR", "AWG_STR", "AZN_STR", "BAM_STR", "BBD_STR", "BDT_STR", "BGN_STR", "BHD_STR", "BIF_STR", "BMD_STR", "BND_STR", "BOB_STR", "BOV_STR", "BRL_STR", "BSD_STR", "BTN_STR", "BWP_STR", "BYN_STR", "BZD_STR", "CAD_STR", "CDF_STR", "CHE_STR", "CHF_STR", "CHW_STR", "CLF_STR", "CLP_STR", "CNY_STR", "COP_STR", "COU_STR", "CRC_STR", "CUC_STR", "CUP_STR", "CVE_STR", "CZK_STR", "DJF_STR", "DKK_STR", "DOP_STR", "DZD_STR", "EGP_STR", "ERN_STR", "ETB_STR", "EUR_STR", "FJD_STR", "FKP_STR", "GBP_STR", "GEL_STR", "GHS_STR", "GIP_STR", "GMD_STR", "GNF_STR", "GTQ_STR", "GYD_STR", "HKD_STR", "HNL_STR", "HRK_STR", "HTG_STR", "HUF_STR", "IDR_STR", "ILS_STR", "INR_STR", "IQD_STR", "IRR_STR", "ISK_STR", "JMD_STR", "JOD_STR", "JPY_STR", "KES_STR", "KGS_STR", "KHR_STR", "KMF_STR", "KPW_STR", "KRW_STR", "KWD_STR", "KYD_STR", "KZT_STR", "LAK_STR", "LBP_STR", "LKR_STR", "LRD_STR", "LSL_STR", "LYD_STR", "MAD_STR", "MDL_STR", "MGA_STR", "MKD_STR", "MMK_STR", "MNT_STR", "MOP_STR", "MRU_STR", "MUR_STR", "MVR_STR", "MWK_STR", "MXN_STR", "MXV_STR", "MYR_STR", "MZN_STR", "NAD_STR", "NGN_STR", "NIO_STR", "NOK_STR", "NPR_STR", "NZD_STR", "OMR_STR", "PAB_STR", "PEN_STR", "PGK_STR", "PHP_STR", "PKR_STR", "PLN_STR", "PYG_STR", "QAR_STR", "RON_STR", "RSD_STR", "RUB_STR", "RWF_STR", "SAR_STR", "SBD_STR", "SCR_STR", "SDG_STR", "SEK_STR", "SGD_STR", "SHP_STR", "SLE_STR", "SLL_STR", "SOS_STR", "SRD_STR", "SSP_STR", "STN_STR", "SVC_STR", "SYP_STR", "SZL_STR", "THB_STR", "TJS_STR", "TMT_STR", "TND_STR", "TOP_STR", "TRY_STR", "TTD_STR", "TWD_STR", "TZS_STR", "UAH_STR", "UGX_STR", "USD_STR", "USN_STR", "UYI_STR", "UYU_STR", "UYW_STR", "UZS_STR", "VED_STR", "VES_STR", "VND_STR", "VUV_STR", "WST_STR", "XAF_STR", "XAG_STR", "XAU_STR", "XBA_STR", "XBB_STR", "XBC_STR", "XBD_STR", "XCD_STR", "XDR_STR", "XOF_STR", "XPD_STR", "XPF_STR", "XPT_STR", "XSU_STR", "XTS_STR", "XUA_STR", "XXX_STR", "YER_STR", "ZAR_STR", "ZMW_STR", "ZWL_STR", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AlphabeticCode {

        @NotNull
        public static final String AED_STR = "AED";

        @NotNull
        public static final String AFN_STR = "AFN";

        @NotNull
        public static final String ALL_STR = "ALL";

        @NotNull
        public static final String AMD_STR = "AMD";

        @NotNull
        public static final String ANG_STR = "ANG";

        @NotNull
        public static final String AOA_STR = "AOA";

        @NotNull
        public static final String ARS_STR = "ARS";

        @NotNull
        public static final String AUD_STR = "AUD";

        @NotNull
        public static final String AWG_STR = "AWG";

        @NotNull
        public static final String AZN_STR = "AZN";

        @NotNull
        public static final String BAM_STR = "BAM";

        @NotNull
        public static final String BBD_STR = "BBD";

        @NotNull
        public static final String BDT_STR = "BDT";

        @NotNull
        public static final String BGN_STR = "BGN";

        @NotNull
        public static final String BHD_STR = "BHD";

        @NotNull
        public static final String BIF_STR = "BIF";

        @NotNull
        public static final String BMD_STR = "BMD";

        @NotNull
        public static final String BND_STR = "BND";

        @NotNull
        public static final String BOB_STR = "BOB";

        @NotNull
        public static final String BOV_STR = "BOV";

        @NotNull
        public static final String BRL_STR = "BRL";

        @NotNull
        public static final String BSD_STR = "BSD";

        @NotNull
        public static final String BTN_STR = "BTN";

        @NotNull
        public static final String BWP_STR = "BWP";

        @NotNull
        public static final String BYN_STR = "BYN";

        @NotNull
        public static final String BZD_STR = "BZD";

        @NotNull
        public static final String CAD_STR = "CAD";

        @NotNull
        public static final String CDF_STR = "CDF";

        @NotNull
        public static final String CHE_STR = "CHE";

        @NotNull
        public static final String CHF_STR = "CHF";

        @NotNull
        public static final String CHW_STR = "CHW";

        @NotNull
        public static final String CLF_STR = "CLF";

        @NotNull
        public static final String CLP_STR = "CLP";

        @NotNull
        public static final String CNY_STR = "CNY";

        @NotNull
        public static final String COP_STR = "COP";

        @NotNull
        public static final String COU_STR = "COU";

        @NotNull
        public static final String CRC_STR = "CRC";

        @NotNull
        public static final String CUC_STR = "CUC";

        @NotNull
        public static final String CUP_STR = "CUP";

        @NotNull
        public static final String CVE_STR = "CVE";

        @NotNull
        public static final String CZK_STR = "CZK";

        @NotNull
        public static final String DJF_STR = "DJF";

        @NotNull
        public static final String DKK_STR = "DKK";

        @NotNull
        public static final String DOP_STR = "DOP";

        @NotNull
        public static final String DZD_STR = "DZD";

        @NotNull
        public static final String EGP_STR = "EGP";

        @NotNull
        public static final String ERN_STR = "ERN";

        @NotNull
        public static final String ETB_STR = "ETB";

        @NotNull
        public static final String EUR_STR = "EUR";

        @NotNull
        public static final String FJD_STR = "FJD";

        @NotNull
        public static final String FKP_STR = "FKP";

        @NotNull
        public static final String GBP_STR = "GBP";

        @NotNull
        public static final String GEL_STR = "GEL";

        @NotNull
        public static final String GHS_STR = "GHS";

        @NotNull
        public static final String GIP_STR = "GIP";

        @NotNull
        public static final String GMD_STR = "GMD";

        @NotNull
        public static final String GNF_STR = "GNF";

        @NotNull
        public static final String GTQ_STR = "GTQ";

        @NotNull
        public static final String GYD_STR = "GYD";

        @NotNull
        public static final String HKD_STR = "HKD";

        @NotNull
        public static final String HNL_STR = "HNL";

        @NotNull
        public static final String HRK_STR = "HRK";

        @NotNull
        public static final String HTG_STR = "HTG";

        @NotNull
        public static final String HUF_STR = "HUF";

        @NotNull
        public static final String IDR_STR = "IDR";

        @NotNull
        public static final String ILS_STR = "ILS";

        @NotNull
        public static final String INR_STR = "INR";

        @NotNull
        public static final AlphabeticCode INSTANCE = new AlphabeticCode();

        @NotNull
        public static final String IQD_STR = "IQD";

        @NotNull
        public static final String IRR_STR = "IRR";

        @NotNull
        public static final String ISK_STR = "ISK";

        @NotNull
        public static final String JMD_STR = "JMD";

        @NotNull
        public static final String JOD_STR = "JOD";

        @NotNull
        public static final String JPY_STR = "JPY";

        @NotNull
        public static final String KES_STR = "KES";

        @NotNull
        public static final String KGS_STR = "KGS";

        @NotNull
        public static final String KHR_STR = "KHR";

        @NotNull
        public static final String KMF_STR = "KMF";

        @NotNull
        public static final String KPW_STR = "KPW";

        @NotNull
        public static final String KRW_STR = "KRW";

        @NotNull
        public static final String KWD_STR = "KWD";

        @NotNull
        public static final String KYD_STR = "KYD";

        @NotNull
        public static final String KZT_STR = "KZT";

        @NotNull
        public static final String LAK_STR = "LAK";

        @NotNull
        public static final String LBP_STR = "LBP";

        @NotNull
        public static final String LKR_STR = "LKR";

        @NotNull
        public static final String LRD_STR = "LRD";

        @NotNull
        public static final String LSL_STR = "LSL";

        @NotNull
        public static final String LYD_STR = "LYD";

        @NotNull
        public static final String MAD_STR = "MAD";

        @NotNull
        public static final String MDL_STR = "MDL";

        @NotNull
        public static final String MGA_STR = "MGA";

        @NotNull
        public static final String MKD_STR = "MKD";

        @NotNull
        public static final String MMK_STR = "MMK";

        @NotNull
        public static final String MNT_STR = "MNT";

        @NotNull
        public static final String MOP_STR = "MOP";

        @NotNull
        public static final String MRU_STR = "MRU";

        @NotNull
        public static final String MUR_STR = "MUR";

        @NotNull
        public static final String MVR_STR = "MVR";

        @NotNull
        public static final String MWK_STR = "MWK";

        @NotNull
        public static final String MXN_STR = "MXN";

        @NotNull
        public static final String MXV_STR = "MXV";

        @NotNull
        public static final String MYR_STR = "MYR";

        @NotNull
        public static final String MZN_STR = "MZN";

        @NotNull
        public static final String NAD_STR = "NAD";

        @NotNull
        public static final String NGN_STR = "NGN";

        @NotNull
        public static final String NIO_STR = "NIO";

        @NotNull
        public static final String NOK_STR = "NOK";

        @NotNull
        public static final String NPR_STR = "NPR";

        @NotNull
        public static final String NZD_STR = "NZD";

        @NotNull
        public static final String OMR_STR = "OMR";

        @NotNull
        public static final String PAB_STR = "PAB";

        @NotNull
        public static final String PEN_STR = "PEN";

        @NotNull
        public static final String PGK_STR = "PGK";

        @NotNull
        public static final String PHP_STR = "PHP";

        @NotNull
        public static final String PKR_STR = "PKR";

        @NotNull
        public static final String PLN_STR = "PLN";

        @NotNull
        public static final String PYG_STR = "PYG";

        @NotNull
        public static final String QAR_STR = "QAR";

        @NotNull
        public static final String RON_STR = "RON";

        @NotNull
        public static final String RSD_STR = "RSD";

        @NotNull
        public static final String RUB_STR = "RUB";

        @NotNull
        public static final String RWF_STR = "RWF";

        @NotNull
        public static final String SAR_STR = "SAR";

        @NotNull
        public static final String SBD_STR = "SBD";

        @NotNull
        public static final String SCR_STR = "SCR";

        @NotNull
        public static final String SDG_STR = "SDG";

        @NotNull
        public static final String SEK_STR = "SEK";

        @NotNull
        public static final String SGD_STR = "SGD";

        @NotNull
        public static final String SHP_STR = "SHP";

        @NotNull
        public static final String SLE_STR = "SLE";

        @NotNull
        public static final String SLL_STR = "SLL";

        @NotNull
        public static final String SOS_STR = "SOS";

        @NotNull
        public static final String SRD_STR = "SRD";

        @NotNull
        public static final String SSP_STR = "SSP";

        @NotNull
        public static final String STN_STR = "STN";

        @NotNull
        public static final String SVC_STR = "SVC";

        @NotNull
        public static final String SYP_STR = "SYP";

        @NotNull
        public static final String SZL_STR = "SZL";

        @NotNull
        public static final String THB_STR = "THB";

        @NotNull
        public static final String TJS_STR = "TJS";

        @NotNull
        public static final String TMT_STR = "TMT";

        @NotNull
        public static final String TND_STR = "TND";

        @NotNull
        public static final String TOP_STR = "TOP";

        @NotNull
        public static final String TRY_STR = "TRY";

        @NotNull
        public static final String TTD_STR = "TTD";

        @NotNull
        public static final String TWD_STR = "TWD";

        @NotNull
        public static final String TZS_STR = "TZS";

        @NotNull
        public static final String UAH_STR = "UAH";

        @NotNull
        public static final String UGX_STR = "UGX";

        @NotNull
        public static final String USD_STR = "USD";

        @NotNull
        public static final String USN_STR = "USN";

        @NotNull
        public static final String UYI_STR = "UYI";

        @NotNull
        public static final String UYU_STR = "UYU";

        @NotNull
        public static final String UYW_STR = "UYW";

        @NotNull
        public static final String UZS_STR = "UZS";

        @NotNull
        public static final String VED_STR = "VED";

        @NotNull
        public static final String VES_STR = "VES";

        @NotNull
        public static final String VND_STR = "VND";

        @NotNull
        public static final String VUV_STR = "VUV";

        @NotNull
        public static final String WST_STR = "WST";

        @NotNull
        public static final String XAF_STR = "XAF";

        @NotNull
        public static final String XAG_STR = "XAG";

        @NotNull
        public static final String XAU_STR = "XAU";

        @NotNull
        public static final String XBA_STR = "XBA";

        @NotNull
        public static final String XBB_STR = "XBB";

        @NotNull
        public static final String XBC_STR = "XBC";

        @NotNull
        public static final String XBD_STR = "XBD";

        @NotNull
        public static final String XCD_STR = "XCD";

        @NotNull
        public static final String XDR_STR = "XDR";

        @NotNull
        public static final String XOF_STR = "XOF";

        @NotNull
        public static final String XPD_STR = "XPD";

        @NotNull
        public static final String XPF_STR = "XPF";

        @NotNull
        public static final String XPT_STR = "XPT";

        @NotNull
        public static final String XSU_STR = "XSU";

        @NotNull
        public static final String XTS_STR = "XTS";

        @NotNull
        public static final String XUA_STR = "XUA";

        @NotNull
        public static final String XXX_STR = "XXX";

        @NotNull
        public static final String YER_STR = "YER";

        @NotNull
        public static final String ZAR_STR = "ZAR";

        @NotNull
        public static final String ZMW_STR = "ZMW";

        @NotNull
        public static final String ZWL_STR = "ZWL";

        private AlphabeticCode() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/contentsquare/android/api/Currencies$Currency;", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Currency {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/contentsquare/android/api/Currencies$CurrencyStr;", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CurrencyStr {
    }

    static {
        Currencies currencies = new Currencies();
        INSTANCE = currencies;
        currencyMap = currencies.buildCurrencyMap();
        currencySet = currencies.buildCurrencySet();
    }

    private Currencies() {
    }

    private final Map<String, Integer> buildCurrencyMap() {
        HashMap map = new HashMap();
        R0.a(AFN, map, AlphabeticCode.AFN_STR, EUR, AlphabeticCode.EUR_STR);
        R0.a(8, map, "ALL", 12, AlphabeticCode.DZD_STR);
        R0.a(USD, map, AlphabeticCode.USD_STR, AOA, AlphabeticCode.AOA_STR);
        R0.a(XCD, map, AlphabeticCode.XCD_STR, 32, AlphabeticCode.ARS_STR);
        R0.a(51, map, AlphabeticCode.AMD_STR, AWG, AlphabeticCode.AWG_STR);
        R0.a(36, map, AlphabeticCode.AUD_STR, AZN, AlphabeticCode.AZN_STR);
        R0.a(44, map, AlphabeticCode.BSD_STR, 48, AlphabeticCode.BHD_STR);
        R0.a(50, map, AlphabeticCode.BDT_STR, 52, AlphabeticCode.BBD_STR);
        R0.a(BYN, map, AlphabeticCode.BYN_STR, 84, AlphabeticCode.BZD_STR);
        R0.a(XOF, map, AlphabeticCode.XOF_STR, 60, AlphabeticCode.BMD_STR);
        R0.a(INR, map, AlphabeticCode.INR_STR, 64, AlphabeticCode.BTN_STR);
        R0.a(68, map, AlphabeticCode.BOB_STR, BOV, AlphabeticCode.BOV_STR);
        R0.a(BAM, map, AlphabeticCode.BAM_STR, 72, AlphabeticCode.BWP_STR);
        R0.a(NOK, map, AlphabeticCode.NOK_STR, BRL, AlphabeticCode.BRL_STR);
        R0.a(96, map, AlphabeticCode.BND_STR, BGN, AlphabeticCode.BGN_STR);
        R0.a(108, map, AlphabeticCode.BIF_STR, CVE, AlphabeticCode.CVE_STR);
        R0.a(116, map, AlphabeticCode.KHR_STR, XAF, AlphabeticCode.XAF_STR);
        R0.a(CAD, map, AlphabeticCode.CAD_STR, 136, AlphabeticCode.KYD_STR);
        R0.a(152, map, AlphabeticCode.CLP_STR, CLF, AlphabeticCode.CLF_STR);
        R0.a(CNY, map, AlphabeticCode.CNY_STR, COP, AlphabeticCode.COP_STR);
        R0.a(COU, map, AlphabeticCode.COU_STR, KMF, AlphabeticCode.KMF_STR);
        R0.a(CDF, map, AlphabeticCode.CDF_STR, NZD, AlphabeticCode.NZD_STR);
        R0.a(188, map, AlphabeticCode.CRC_STR, HRK, AlphabeticCode.HRK_STR);
        R0.a(192, map, AlphabeticCode.CUP_STR, CUC, AlphabeticCode.CUC_STR);
        R0.a(ANG, map, AlphabeticCode.ANG_STR, 203, AlphabeticCode.CZK_STR);
        R0.a(208, map, AlphabeticCode.DKK_STR, DJF, AlphabeticCode.DJF_STR);
        R0.a(DOP, map, AlphabeticCode.DOP_STR, EGP, AlphabeticCode.EGP_STR);
        R0.a(SVC, map, AlphabeticCode.SVC_STR, ERN, AlphabeticCode.ERN_STR);
        R0.a(SZL, map, AlphabeticCode.SZL_STR, ETB, AlphabeticCode.ETB_STR);
        R0.a(FKP, map, AlphabeticCode.FKP_STR, FJD, AlphabeticCode.FJD_STR);
        R0.a(XPF, map, AlphabeticCode.XPF_STR, 270, AlphabeticCode.GMD_STR);
        R0.a(GEL, map, AlphabeticCode.GEL_STR, GHS, AlphabeticCode.GHS_STR);
        R0.a(GIP, map, AlphabeticCode.GIP_STR, GTQ, AlphabeticCode.GTQ_STR);
        R0.a(GBP, map, AlphabeticCode.GBP_STR, GNF, AlphabeticCode.GNF_STR);
        R0.a(GYD, map, AlphabeticCode.GYD_STR, HTG, AlphabeticCode.HTG_STR);
        R0.a(HNL, map, AlphabeticCode.HNL_STR, HKD, AlphabeticCode.HKD_STR);
        R0.a(HUF, map, AlphabeticCode.HUF_STR, ISK, AlphabeticCode.ISK_STR);
        R0.a(IDR, map, AlphabeticCode.IDR_STR, XDR, AlphabeticCode.XDR_STR);
        R0.a(IRR, map, AlphabeticCode.IRR_STR, IQD, AlphabeticCode.IQD_STR);
        R0.a(ILS, map, AlphabeticCode.ILS_STR, JMD, AlphabeticCode.JMD_STR);
        R0.a(JPY, map, AlphabeticCode.JPY_STR, 400, AlphabeticCode.JOD_STR);
        R0.a(KZT, map, AlphabeticCode.KZT_STR, 404, AlphabeticCode.KES_STR);
        R0.a(KPW, map, AlphabeticCode.KPW_STR, KRW, AlphabeticCode.KRW_STR);
        R0.a(KWD, map, AlphabeticCode.KWD_STR, KGS, AlphabeticCode.KGS_STR);
        R0.a(LAK, map, AlphabeticCode.LAK_STR, 422, AlphabeticCode.LBP_STR);
        R0.a(LSL, map, AlphabeticCode.LSL_STR, ZAR, AlphabeticCode.ZAR_STR);
        R0.a(LRD, map, AlphabeticCode.LRD_STR, LYD, AlphabeticCode.LYD_STR);
        R0.a(CHF, map, AlphabeticCode.CHF_STR, MOP, AlphabeticCode.MOP_STR);
        R0.a(MKD, map, AlphabeticCode.MKD_STR, MGA, AlphabeticCode.MGA_STR);
        R0.a(MWK, map, AlphabeticCode.MWK_STR, MYR, AlphabeticCode.MYR_STR);
        R0.a(MVR, map, AlphabeticCode.MVR_STR, MRU, AlphabeticCode.MRU_STR);
        R0.a(MUR, map, AlphabeticCode.MUR_STR, XUA, AlphabeticCode.XUA_STR);
        R0.a(MXN, map, AlphabeticCode.MXN_STR, MXV, AlphabeticCode.MXV_STR);
        R0.a(MDL, map, AlphabeticCode.MDL_STR, MNT, AlphabeticCode.MNT_STR);
        R0.a(504, map, AlphabeticCode.MAD_STR, MZN, AlphabeticCode.MZN_STR);
        R0.a(104, map, AlphabeticCode.MMK_STR, NAD, AlphabeticCode.NAD_STR);
        R0.a(NPR, map, AlphabeticCode.NPR_STR, NIO, AlphabeticCode.NIO_STR);
        R0.a(NGN, map, AlphabeticCode.NGN_STR, 512, AlphabeticCode.OMR_STR);
        R0.a(PKR, map, AlphabeticCode.PKR_STR, PAB, AlphabeticCode.PAB_STR);
        R0.a(PGK, map, AlphabeticCode.PGK_STR, 600, AlphabeticCode.PYG_STR);
        R0.a(604, map, AlphabeticCode.PEN_STR, 608, AlphabeticCode.PHP_STR);
        R0.a(PLN, map, AlphabeticCode.PLN_STR, QAR, AlphabeticCode.QAR_STR);
        R0.a(RON, map, AlphabeticCode.RON_STR, RUB, AlphabeticCode.RUB_STR);
        R0.a(RWF, map, AlphabeticCode.RWF_STR, SHP, AlphabeticCode.SHP_STR);
        R0.a(WST, map, AlphabeticCode.WST_STR, STN, AlphabeticCode.STN_STR);
        R0.a(SAR, map, AlphabeticCode.SAR_STR, RSD, AlphabeticCode.RSD_STR);
        R0.a(SCR, map, AlphabeticCode.SCR_STR, SLL, AlphabeticCode.SLL_STR);
        R0.a(SLE, map, AlphabeticCode.SLE_STR, 702, AlphabeticCode.SGD_STR);
        R0.a(XSU, map, AlphabeticCode.XSU_STR, 90, AlphabeticCode.SBD_STR);
        R0.a(706, map, AlphabeticCode.SOS_STR, SSP, AlphabeticCode.SSP_STR);
        R0.a(144, map, AlphabeticCode.LKR_STR, SDG, AlphabeticCode.SDG_STR);
        R0.a(SRD, map, AlphabeticCode.SRD_STR, SEK, AlphabeticCode.SEK_STR);
        R0.a(CHE, map, AlphabeticCode.CHE_STR, CHW, AlphabeticCode.CHW_STR);
        R0.a(SYP, map, AlphabeticCode.SYP_STR, 901, AlphabeticCode.TWD_STR);
        R0.a(TJS, map, AlphabeticCode.TJS_STR, TZS, AlphabeticCode.TZS_STR);
        R0.a(THB, map, AlphabeticCode.THB_STR, TOP, AlphabeticCode.TOP_STR);
        R0.a(TTD, map, AlphabeticCode.TTD_STR, TND, AlphabeticCode.TND_STR);
        R0.a(TRY, map, AlphabeticCode.TRY_STR, TMT, AlphabeticCode.TMT_STR);
        R0.a(UGX, map, AlphabeticCode.UGX_STR, UAH, AlphabeticCode.UAH_STR);
        R0.a(AED, map, AlphabeticCode.AED_STR, USN, AlphabeticCode.USN_STR);
        R0.a(UYU, map, AlphabeticCode.UYU_STR, UYI, AlphabeticCode.UYI_STR);
        R0.a(UYW, map, AlphabeticCode.UYW_STR, UZS, AlphabeticCode.UZS_STR);
        R0.a(VUV, map, AlphabeticCode.VUV_STR, VES, AlphabeticCode.VES_STR);
        R0.a(VED, map, AlphabeticCode.VED_STR, 704, AlphabeticCode.VND_STR);
        R0.a(YER, map, AlphabeticCode.YER_STR, ZMW, AlphabeticCode.ZMW_STR);
        R0.a(ZWL, map, AlphabeticCode.ZWL_STR, XBA, AlphabeticCode.XBA_STR);
        R0.a(XBB, map, AlphabeticCode.XBB_STR, XBC, AlphabeticCode.XBC_STR);
        R0.a(XBD, map, AlphabeticCode.XBD_STR, XTS, AlphabeticCode.XTS_STR);
        R0.a(999, map, AlphabeticCode.XXX_STR, XAU, AlphabeticCode.XAU_STR);
        R0.a(XPD, map, AlphabeticCode.XPD_STR, XPT, AlphabeticCode.XPT_STR);
        map.put(AlphabeticCode.XAG_STR, Integer.valueOf(XAG));
        return map;
    }

    private final Set<Integer> buildCurrencySet() {
        HashSet hashSet = new HashSet();
        S0.a(AFN, hashSet, EUR, 8, 12);
        S0.a(USD, hashSet, AOA, XCD, 32);
        S0.a(51, hashSet, AWG, 36, AZN);
        S0.a(44, hashSet, 48, 50, 52);
        S0.a(BYN, hashSet, 84, XOF, 60);
        S0.a(INR, hashSet, 64, 68, BOV);
        S0.a(BAM, hashSet, 72, NOK, BRL);
        S0.a(96, hashSet, BGN, 108, CVE);
        S0.a(116, hashSet, XAF, CAD, 136);
        S0.a(152, hashSet, CLF, CNY, COP);
        S0.a(COU, hashSet, KMF, CDF, NZD);
        S0.a(188, hashSet, HRK, 192, CUC);
        S0.a(ANG, hashSet, 203, 208, DJF);
        S0.a(DOP, hashSet, EGP, SVC, ERN);
        S0.a(SZL, hashSet, ETB, FKP, FJD);
        S0.a(XPF, hashSet, 270, GEL, GHS);
        S0.a(GIP, hashSet, GTQ, GBP, GNF);
        S0.a(GYD, hashSet, HTG, HNL, HKD);
        S0.a(HUF, hashSet, ISK, IDR, XDR);
        S0.a(IRR, hashSet, IQD, ILS, JMD);
        S0.a(JPY, hashSet, 400, KZT, 404);
        S0.a(KPW, hashSet, KRW, KWD, KGS);
        S0.a(LAK, hashSet, 422, LSL, ZAR);
        S0.a(LRD, hashSet, LYD, CHF, MOP);
        S0.a(MKD, hashSet, MGA, MWK, MYR);
        S0.a(MVR, hashSet, MRU, MUR, XUA);
        S0.a(MXN, hashSet, MXV, MDL, MNT);
        S0.a(504, hashSet, MZN, 104, NAD);
        S0.a(NPR, hashSet, NIO, NGN, 512);
        S0.a(PKR, hashSet, PAB, PGK, 600);
        S0.a(604, hashSet, 608, PLN, QAR);
        S0.a(RON, hashSet, RUB, RWF, SHP);
        S0.a(WST, hashSet, STN, SAR, RSD);
        S0.a(SCR, hashSet, SLL, SLE, 702);
        S0.a(XSU, hashSet, 90, 706, SSP);
        S0.a(144, hashSet, SDG, SRD, SEK);
        S0.a(CHE, hashSet, CHW, SYP, 901);
        S0.a(TJS, hashSet, TZS, THB, TOP);
        S0.a(TTD, hashSet, TND, TRY, TMT);
        S0.a(UGX, hashSet, UAH, AED, USN);
        S0.a(UYU, hashSet, UYI, UYW, UZS);
        S0.a(VUV, hashSet, VES, VED, 704);
        S0.a(YER, hashSet, ZMW, ZWL, XBA);
        S0.a(XBB, hashSet, XBC, XBD, XTS);
        S0.a(999, hashSet, XAU, XPD, XPT);
        hashSet.add(Integer.valueOf(XAG));
        return hashSet;
    }

    public final int fromInteger(int currency) {
        if (currencySet.contains(Integer.valueOf(currency))) {
            return currency;
        }
        return -1;
    }

    public final int fromString(@NotNull String currency) {
        Intrinsics.checkNotNullParameter(currency, "currency");
        Integer num = currencyMap.get(currency);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
