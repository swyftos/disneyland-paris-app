package com.facebook.react.uimanager;

import androidx.camera.video.AudioStats;
import com.contentsquare.android.api.Currencies;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0003\b \u0001\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010«\u0001\u001a\u00030¬\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u00012\u0007\u0010¯\u0001\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0012\u0010¥\u0001\u001a\u00030¦\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010§\u0001\u001a\u00030¦\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R!\u0010¨\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050©\u0001j\t\u0012\u0004\u0012\u00020\u0005`ª\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006°\u0001"}, d2 = {"Lcom/facebook/react/uimanager/ViewProps;", "", "<init>", "()V", "VIEW_CLASS_NAME", "", "ALIGN_ITEMS", "ALIGN_SELF", "ALIGN_CONTENT", "DISPLAY", "BOTTOM", "COLLAPSABLE", "COLLAPSABLE_CHILDREN", "FLEX", "FLEX_GROW", "FLEX_SHRINK", "FLEX_BASIS", "FLEX_DIRECTION", "FLEX_WRAP", "ROW_GAP", "COLUMN_GAP", "GAP", "HEIGHT", "JUSTIFY_CONTENT", "LEFT", "MARGIN", "MARGIN_VERTICAL", "MARGIN_HORIZONTAL", "MARGIN_LEFT", "MARGIN_RIGHT", "MARGIN_TOP", "MARGIN_BOTTOM", "MARGIN_START", "MARGIN_END", "PADDING", "PADDING_VERTICAL", "PADDING_HORIZONTAL", "PADDING_LEFT", "PADDING_RIGHT", "PADDING_TOP", "PADDING_BOTTOM", "PADDING_START", "PADDING_END", "POSITION", "RIGHT", Currencies.AlphabeticCode.TOP_STR, "WIDTH", "START", "END", "AUTO", "NONE", "BOX_NONE", "MIN_WIDTH", "MAX_WIDTH", "MIN_HEIGHT", "MAX_HEIGHT", "ASPECT_RATIO", "POINTER_EVENTS", "ENABLED", "BACKGROUND_COLOR", "BACKGROUND_IMAGE", "FOREGROUND_COLOR", "COLOR", "FONT_SIZE", "FONT_WEIGHT", "FONT_STYLE", "FONT_VARIANT", "FONT_FAMILY", "LINE_HEIGHT", "LETTER_SPACING", "NEEDS_OFFSCREEN_ALPHA_COMPOSITING", "NUMBER_OF_LINES", "ELLIPSIZE_MODE", "ADJUSTS_FONT_SIZE_TO_FIT", "MINIMUM_FONT_SCALE", "ON", "RESIZE_MODE", "RESIZE_METHOD", "LAYOUT_DIRECTION", "TEXT_ALIGN", "TEXT_ALIGN_VERTICAL", "TEXT_DECORATION_LINE", "TEXT_BREAK_STRATEGY", "OPACITY", "OVERFLOW", "HIDDEN", "SCROLL", "VISIBLE", "ALLOW_FONT_SCALING", "MAX_FONT_SIZE_MULTIPLIER", "INCLUDE_FONT_PADDING", "BORDER_WIDTH", "BORDER_LEFT_WIDTH", "BORDER_START_WIDTH", "BORDER_END_WIDTH", "BORDER_TOP_WIDTH", "BORDER_RIGHT_WIDTH", "BORDER_BOTTOM_WIDTH", "BORDER_RADIUS", "BORDER_TOP_LEFT_RADIUS", "BORDER_TOP_RIGHT_RADIUS", "BORDER_BOTTOM_LEFT_RADIUS", "BORDER_BOTTOM_RIGHT_RADIUS", "BORDER_COLOR", "BORDER_LEFT_COLOR", "BORDER_RIGHT_COLOR", "BORDER_TOP_COLOR", "BORDER_BOTTOM_COLOR", "BORDER_BLOCK_COLOR", "BORDER_BLOCK_END_COLOR", "BORDER_BLOCK_START_COLOR", "BORDER_TOP_START_RADIUS", "BORDER_TOP_END_RADIUS", "BORDER_BOTTOM_START_RADIUS", "BORDER_BOTTOM_END_RADIUS", "BORDER_END_END_RADIUS", "BORDER_END_START_RADIUS", "BORDER_START_END_RADIUS", "BORDER_START_START_RADIUS", "BORDER_START_COLOR", "BORDER_END_COLOR", "BOX_SHADOW", "FILTER", "MIX_BLEND_MODE", "OUTLINE_COLOR", "OUTLINE_OFFSET", "OUTLINE_STYLE", "OUTLINE_WIDTH", "TRANSFORM", "TRANSFORM_ORIGIN", "ELEVATION", "SHADOW_COLOR", "Z_INDEX", "RENDER_TO_HARDWARE_TEXTURE", "ACCESSIBILITY_LABEL", "ACCESSIBILITY_COLLECTION", "ACCESSIBILITY_COLLECTION_ITEM", "ACCESSIBILITY_HINT", "ACCESSIBILITY_LIVE_REGION", "ACCESSIBILITY_ROLE", "ACCESSIBILITY_STATE", "ACCESSIBILITY_ACTIONS", "ACCESSIBILITY_VALUE", "ACCESSIBILITY_LABELLED_BY", "IMPORTANT_FOR_ACCESSIBILITY", "ROLE", "ROTATION", "SCALE_X", "SCALE_Y", "TRANSLATE_X", "TRANSLATE_Y", "TEST_ID", "NATIVE_ID", "ON_POINTER_ENTER", "ON_POINTER_ENTER_CAPTURE", "ON_POINTER_OVER", "ON_POINTER_OVER_CAPTURE", "ON_POINTER_OUT", "ON_POINTER_OUT_CAPTURE", "ON_POINTER_LEAVE", "ON_POINTER_LEAVE_CAPTURE", "ON_POINTER_MOVE", "ON_POINTER_MOVE_CAPTURE", "ON_CLICK", "ON_CLICK_CAPTURE", "BORDER_SPACING_TYPES", "", "PADDING_MARGIN_SPACING_TYPES", "LAYOUT_ONLY_PROPS", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "isLayoutOnly", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", "prop", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewProps {

    @NotNull
    public static final String ACCESSIBILITY_ACTIONS = "accessibilityActions";

    @NotNull
    public static final String ACCESSIBILITY_COLLECTION = "accessibilityCollection";

    @NotNull
    public static final String ACCESSIBILITY_COLLECTION_ITEM = "accessibilityCollectionItem";

    @NotNull
    public static final String ACCESSIBILITY_HINT = "accessibilityHint";

    @NotNull
    public static final String ACCESSIBILITY_LABEL = "accessibilityLabel";

    @NotNull
    public static final String ACCESSIBILITY_LABELLED_BY = "accessibilityLabelledBy";

    @NotNull
    public static final String ACCESSIBILITY_LIVE_REGION = "accessibilityLiveRegion";

    @NotNull
    public static final String ACCESSIBILITY_ROLE = "accessibilityRole";

    @NotNull
    public static final String ACCESSIBILITY_STATE = "accessibilityState";

    @NotNull
    public static final String ACCESSIBILITY_VALUE = "accessibilityValue";

    @NotNull
    public static final String ADJUSTS_FONT_SIZE_TO_FIT = "adjustsFontSizeToFit";

    @NotNull
    public static final String ALLOW_FONT_SCALING = "allowFontScaling";

    @NotNull
    public static final String ASPECT_RATIO = "aspectRatio";

    @NotNull
    public static final String AUTO = "auto";

    @NotNull
    public static final String BACKGROUND_COLOR = "backgroundColor";

    @NotNull
    public static final String BACKGROUND_IMAGE = "experimental_backgroundImage";

    @NotNull
    public static final String BORDER_BLOCK_COLOR = "borderBlockColor";

    @NotNull
    public static final String BORDER_BLOCK_END_COLOR = "borderBlockEndColor";

    @NotNull
    public static final String BORDER_BLOCK_START_COLOR = "borderBlockStartColor";

    @NotNull
    public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";

    @NotNull
    public static final String BORDER_BOTTOM_END_RADIUS = "borderBottomEndRadius";

    @NotNull
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";

    @NotNull
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";

    @NotNull
    public static final String BORDER_BOTTOM_START_RADIUS = "borderBottomStartRadius";

    @NotNull
    public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";

    @NotNull
    public static final String BORDER_COLOR = "borderColor";

    @NotNull
    public static final String BORDER_END_COLOR = "borderEndColor";

    @NotNull
    public static final String BORDER_END_END_RADIUS = "borderEndEndRadius";

    @NotNull
    public static final String BORDER_END_START_RADIUS = "borderEndStartRadius";

    @NotNull
    public static final String BORDER_END_WIDTH = "borderEndWidth";

    @NotNull
    public static final String BORDER_LEFT_COLOR = "borderLeftColor";

    @NotNull
    public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";

    @NotNull
    public static final String BORDER_RADIUS = "borderRadius";

    @NotNull
    public static final String BORDER_RIGHT_COLOR = "borderRightColor";

    @NotNull
    public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";

    @NotNull
    public static final String BORDER_START_COLOR = "borderStartColor";

    @NotNull
    public static final String BORDER_START_END_RADIUS = "borderStartEndRadius";

    @NotNull
    public static final String BORDER_START_START_RADIUS = "borderStartStartRadius";

    @NotNull
    public static final String BORDER_START_WIDTH = "borderStartWidth";

    @NotNull
    public static final String BORDER_TOP_COLOR = "borderTopColor";

    @NotNull
    public static final String BORDER_TOP_END_RADIUS = "borderTopEndRadius";

    @NotNull
    public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";

    @NotNull
    public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";

    @NotNull
    public static final String BORDER_TOP_START_RADIUS = "borderTopStartRadius";

    @NotNull
    public static final String BORDER_TOP_WIDTH = "borderTopWidth";

    @NotNull
    public static final String BORDER_WIDTH = "borderWidth";

    @NotNull
    public static final String BOX_NONE = "box-none";

    @NotNull
    public static final String BOX_SHADOW = "boxShadow";

    @NotNull
    public static final String COLLAPSABLE_CHILDREN = "collapsableChildren";

    @NotNull
    public static final String COLOR = "color";

    @NotNull
    public static final String DISPLAY = "display";

    @NotNull
    public static final String ELEVATION = "elevation";

    @NotNull
    public static final String ELLIPSIZE_MODE = "ellipsizeMode";

    @NotNull
    public static final String ENABLED = "enabled";

    @NotNull
    public static final String FILTER = "filter";

    @NotNull
    public static final String FONT_FAMILY = "fontFamily";

    @NotNull
    public static final String FONT_SIZE = "fontSize";

    @NotNull
    public static final String FONT_STYLE = "fontStyle";

    @NotNull
    public static final String FONT_VARIANT = "fontVariant";

    @NotNull
    public static final String FONT_WEIGHT = "fontWeight";

    @NotNull
    public static final String FOREGROUND_COLOR = "foregroundColor";

    @NotNull
    public static final String HEIGHT = "height";

    @NotNull
    public static final String HIDDEN = "hidden";

    @NotNull
    public static final String IMPORTANT_FOR_ACCESSIBILITY = "importantForAccessibility";

    @NotNull
    public static final String INCLUDE_FONT_PADDING = "includeFontPadding";

    @NotNull
    public static final String LAYOUT_DIRECTION = "layoutDirection";

    @NotNull
    public static final String LETTER_SPACING = "letterSpacing";

    @NotNull
    public static final String LINE_HEIGHT = "lineHeight";

    @NotNull
    public static final String MAX_FONT_SIZE_MULTIPLIER = "maxFontSizeMultiplier";

    @NotNull
    public static final String MINIMUM_FONT_SCALE = "minimumFontScale";

    @NotNull
    public static final String MIX_BLEND_MODE = "mixBlendMode";

    @NotNull
    public static final String NATIVE_ID = "nativeID";

    @NotNull
    public static final String NEEDS_OFFSCREEN_ALPHA_COMPOSITING = "needsOffscreenAlphaCompositing";

    @NotNull
    public static final String NONE = "none";

    @NotNull
    public static final String NUMBER_OF_LINES = "numberOfLines";

    @NotNull
    public static final String ON = "on";

    @NotNull
    public static final String ON_CLICK = "onClick";

    @NotNull
    public static final String ON_CLICK_CAPTURE = "onClickCapture";

    @NotNull
    public static final String ON_POINTER_ENTER = "onPointerEnter";

    @NotNull
    public static final String ON_POINTER_ENTER_CAPTURE = "onPointerEnterCapture";

    @NotNull
    public static final String ON_POINTER_LEAVE = "onPointerLeave";

    @NotNull
    public static final String ON_POINTER_LEAVE_CAPTURE = "onPointerLeaveCapture";

    @NotNull
    public static final String ON_POINTER_MOVE = "onPointerMove";

    @NotNull
    public static final String ON_POINTER_MOVE_CAPTURE = "onPointerMoveCapture";

    @NotNull
    public static final String ON_POINTER_OUT = "onPointerOut";

    @NotNull
    public static final String ON_POINTER_OUT_CAPTURE = "onPointerOutCapture";

    @NotNull
    public static final String ON_POINTER_OVER = "onPointerOver";

    @NotNull
    public static final String ON_POINTER_OVER_CAPTURE = "onPointerOverCapture";

    @NotNull
    public static final String OPACITY = "opacity";

    @NotNull
    public static final String OUTLINE_COLOR = "outlineColor";

    @NotNull
    public static final String OUTLINE_OFFSET = "outlineOffset";

    @NotNull
    public static final String OUTLINE_STYLE = "outlineStyle";

    @NotNull
    public static final String OUTLINE_WIDTH = "outlineWidth";

    @NotNull
    public static final String OVERFLOW = "overflow";

    @NotNull
    public static final String POINTER_EVENTS = "pointerEvents";

    @NotNull
    public static final String RENDER_TO_HARDWARE_TEXTURE = "renderToHardwareTextureAndroid";

    @NotNull
    public static final String RESIZE_METHOD = "resizeMethod";

    @NotNull
    public static final String RESIZE_MODE = "resizeMode";

    @NotNull
    public static final String ROLE = "role";

    @NotNull
    public static final String ROTATION = "rotation";

    @NotNull
    public static final String SCALE_X = "scaleX";

    @NotNull
    public static final String SCALE_Y = "scaleY";

    @NotNull
    public static final String SCROLL = "scroll";

    @NotNull
    public static final String SHADOW_COLOR = "shadowColor";

    @NotNull
    public static final String TEST_ID = "testID";

    @NotNull
    public static final String TEXT_ALIGN = "textAlign";

    @NotNull
    public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";

    @NotNull
    public static final String TEXT_BREAK_STRATEGY = "textBreakStrategy";

    @NotNull
    public static final String TEXT_DECORATION_LINE = "textDecorationLine";

    @NotNull
    public static final String TRANSFORM = "transform";

    @NotNull
    public static final String TRANSFORM_ORIGIN = "transformOrigin";

    @NotNull
    public static final String TRANSLATE_X = "translateX";

    @NotNull
    public static final String TRANSLATE_Y = "translateY";

    @NotNull
    public static final String VIEW_CLASS_NAME = "RCTView";

    @NotNull
    public static final String VISIBLE = "visible";

    @NotNull
    public static final String WIDTH = "width";

    @NotNull
    public static final String Z_INDEX = "zIndex";

    @NotNull
    public static final ViewProps INSTANCE = new ViewProps();

    @JvmField
    @NotNull
    public static final int[] BORDER_SPACING_TYPES = {8, 4, 5, 1, 3, 0, 2};

    @JvmField
    @NotNull
    public static final int[] PADDING_MARGIN_SPACING_TYPES = {8, 7, 6, 4, 5, 1, 3, 0, 2};

    @NotNull
    public static final String ALIGN_SELF = "alignSelf";

    @NotNull
    public static final String ALIGN_ITEMS = "alignItems";

    @NotNull
    public static final String COLLAPSABLE = "collapsable";

    @NotNull
    public static final String FLEX = "flex";

    @NotNull
    public static final String FLEX_BASIS = "flexBasis";

    @NotNull
    public static final String FLEX_DIRECTION = "flexDirection";

    @NotNull
    public static final String FLEX_GROW = "flexGrow";

    @NotNull
    public static final String ROW_GAP = "rowGap";

    @NotNull
    public static final String COLUMN_GAP = "columnGap";

    @NotNull
    public static final String GAP = "gap";

    @NotNull
    public static final String FLEX_SHRINK = "flexShrink";

    @NotNull
    public static final String FLEX_WRAP = "flexWrap";

    @NotNull
    public static final String JUSTIFY_CONTENT = "justifyContent";

    @NotNull
    public static final String ALIGN_CONTENT = "alignContent";

    @NotNull
    public static final String POSITION = "position";

    @NotNull
    public static final String RIGHT = "right";

    @NotNull
    public static final String TOP = "top";

    @NotNull
    public static final String BOTTOM = "bottom";

    @NotNull
    public static final String LEFT = "left";

    @NotNull
    public static final String START = "start";

    @NotNull
    public static final String END = "end";

    @NotNull
    public static final String MIN_WIDTH = "minWidth";

    @NotNull
    public static final String MAX_WIDTH = "maxWidth";

    @NotNull
    public static final String MIN_HEIGHT = "minHeight";

    @NotNull
    public static final String MAX_HEIGHT = "maxHeight";

    @NotNull
    public static final String MARGIN = "margin";

    @NotNull
    public static final String MARGIN_VERTICAL = "marginVertical";

    @NotNull
    public static final String MARGIN_HORIZONTAL = "marginHorizontal";

    @NotNull
    public static final String MARGIN_LEFT = "marginLeft";

    @NotNull
    public static final String MARGIN_RIGHT = "marginRight";

    @NotNull
    public static final String MARGIN_TOP = "marginTop";

    @NotNull
    public static final String MARGIN_BOTTOM = "marginBottom";

    @NotNull
    public static final String MARGIN_START = "marginStart";

    @NotNull
    public static final String MARGIN_END = "marginEnd";

    @NotNull
    public static final String PADDING = "padding";

    @NotNull
    public static final String PADDING_VERTICAL = "paddingVertical";

    @NotNull
    public static final String PADDING_HORIZONTAL = "paddingHorizontal";

    @NotNull
    public static final String PADDING_LEFT = "paddingLeft";

    @NotNull
    public static final String PADDING_RIGHT = "paddingRight";

    @NotNull
    public static final String PADDING_TOP = "paddingTop";

    @NotNull
    public static final String PADDING_BOTTOM = "paddingBottom";

    @NotNull
    public static final String PADDING_START = "paddingStart";

    @NotNull
    public static final String PADDING_END = "paddingEnd";

    @NotNull
    private static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet<>(Arrays.asList(ALIGN_SELF, ALIGN_ITEMS, COLLAPSABLE, FLEX, FLEX_BASIS, FLEX_DIRECTION, FLEX_GROW, ROW_GAP, COLUMN_GAP, GAP, FLEX_SHRINK, FLEX_WRAP, JUSTIFY_CONTENT, ALIGN_CONTENT, "display", POSITION, RIGHT, TOP, BOTTOM, LEFT, START, END, "width", "height", MIN_WIDTH, MAX_WIDTH, MIN_HEIGHT, MAX_HEIGHT, MARGIN, MARGIN_VERTICAL, MARGIN_HORIZONTAL, MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM, MARGIN_START, MARGIN_END, PADDING, PADDING_VERTICAL, PADDING_HORIZONTAL, PADDING_LEFT, PADDING_RIGHT, PADDING_TOP, PADDING_BOTTOM, PADDING_START, PADDING_END));

    private ViewProps() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    public static final boolean isLayoutOnly(@NotNull ReadableMap map, @NotNull String prop) {
        ReadableType type;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(prop, "prop");
        if (LAYOUT_ONLY_PROPS.contains(prop)) {
            return true;
        }
        if (Intrinsics.areEqual(POINTER_EVENTS, prop)) {
            String string = map.getString(prop);
            return Intrinsics.areEqual("auto", string) || Intrinsics.areEqual(BOX_NONE, string);
        }
        switch (prop.hashCode()) {
            case -1989576717:
                if (prop.equals(BORDER_RIGHT_COLOR) && map.getType(BORDER_RIGHT_COLOR) == ReadableType.Number && map.getInt(BORDER_RIGHT_COLOR) == 0) {
                    return true;
                }
                break;
            case -1971292586:
                if (prop.equals(BORDER_RIGHT_WIDTH) && (map.isNull(BORDER_RIGHT_WIDTH) || map.getDouble(BORDER_RIGHT_WIDTH) == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                    return true;
                }
                break;
            case -1470826662:
                if (prop.equals(BORDER_TOP_COLOR) && map.getType(BORDER_TOP_COLOR) == ReadableType.Number && map.getInt(BORDER_TOP_COLOR) == 0) {
                    return true;
                }
                break;
            case -1452542531:
                if (prop.equals(BORDER_TOP_WIDTH) && (map.isNull(BORDER_TOP_WIDTH) || map.getDouble(BORDER_TOP_WIDTH) == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                    return true;
                }
                break;
            case -1308858324:
                if (prop.equals(BORDER_BOTTOM_COLOR) && map.getType(BORDER_BOTTOM_COLOR) == ReadableType.Number && map.getInt(BORDER_BOTTOM_COLOR) == 0) {
                    return true;
                }
                break;
            case -1290574193:
                if (prop.equals(BORDER_BOTTOM_WIDTH) && (map.isNull(BORDER_BOTTOM_WIDTH) || map.getDouble(BORDER_BOTTOM_WIDTH) == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                    return true;
                }
                break;
            case -1267206133:
                if (prop.equals(OPACITY) && (map.isNull(OPACITY) || map.getDouble(OPACITY) == 1.0d)) {
                    return true;
                }
                break;
            case -242276144:
                if (prop.equals(BORDER_LEFT_COLOR) && map.getType(BORDER_LEFT_COLOR) == ReadableType.Number && map.getInt(BORDER_LEFT_COLOR) == 0) {
                    return true;
                }
                break;
            case -223992013:
                if (prop.equals(BORDER_LEFT_WIDTH) && (map.isNull(BORDER_LEFT_WIDTH) || map.getDouble(BORDER_LEFT_WIDTH) == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                    return true;
                }
                break;
            case 306963138:
                if (prop.equals(BORDER_BLOCK_START_COLOR) && map.getType(BORDER_BLOCK_START_COLOR) == ReadableType.Number && map.getInt(BORDER_BLOCK_START_COLOR) == 0) {
                    return true;
                }
                break;
            case 529642498:
                if (prop.equals(OVERFLOW) && (map.isNull(OVERFLOW) || Intrinsics.areEqual(VISIBLE, map.getString(OVERFLOW)))) {
                    return true;
                }
                break;
            case 684610594:
                if (prop.equals(BORDER_BLOCK_COLOR) && map.getType(BORDER_BLOCK_COLOR) == ReadableType.Number && map.getInt(BORDER_BLOCK_COLOR) == 0) {
                    return true;
                }
                break;
            case 741115130:
                if (prop.equals(BORDER_WIDTH) && (map.isNull(BORDER_WIDTH) || map.getDouble(BORDER_WIDTH) == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                    return true;
                }
                break;
            case 762983977:
                if (prop.equals(BORDER_BLOCK_END_COLOR) && map.getType(BORDER_BLOCK_END_COLOR) == ReadableType.Number && map.getInt(BORDER_BLOCK_END_COLOR) == 0) {
                    return true;
                }
                break;
            case 1349188574:
                if (prop.equals("borderRadius")) {
                    if (!map.hasKey(BACKGROUND_COLOR) || (((type = map.getType(BACKGROUND_COLOR)) != ReadableType.Number || map.getInt(BACKGROUND_COLOR) == 0) && type == ReadableType.Null)) {
                        return !map.hasKey(BORDER_WIDTH) || map.isNull(BORDER_WIDTH) || map.getDouble(BORDER_WIDTH) == AudioStats.AUDIO_AMPLITUDE_NONE;
                    }
                    return false;
                }
                break;
        }
        return false;
    }
}
