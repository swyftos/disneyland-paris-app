package com.facebook.react.animated;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.view.ColorUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/facebook/react/animated/ColorAnimatedNode;", "Lcom/facebook/react/animated/AnimatedNode;", "Lcom/facebook/react/animated/AnimatedNodeWithUpdateableConfig;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "nativeAnimatedNodesManager", "Lcom/facebook/react/animated/NativeAnimatedNodesManager;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;Lcom/facebook/react/bridge/ReactApplicationContext;)V", "rNodeId", "", "gNodeId", "bNodeId", "aNodeId", "nativeColor", "nativeColorApplied", "", "color", "getColor", "()I", "onUpdateConfig", "", "prettyPrint", "", "tryApplyNativeColor", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ColorAnimatedNode extends AnimatedNode implements AnimatedNodeWithUpdateableConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int aNodeId;
    private int bNodeId;
    private int gNodeId;

    @NotNull
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;

    @Nullable
    private ReadableMap nativeColor;
    private boolean nativeColorApplied;
    private int rNodeId;

    @NotNull
    private final ReactApplicationContext reactApplicationContext;

    public ColorAnimatedNode(@NotNull ReadableMap config, @NotNull NativeAnimatedNodesManager nativeAnimatedNodesManager, @NotNull ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.reactApplicationContext = reactApplicationContext;
        onUpdateConfig(config);
    }

    public final int getColor() {
        tryApplyNativeColor();
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.rNodeId);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.gNodeId);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.bNodeId);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.aNodeId);
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d2 = valueAnimatedNode != null ? valueAnimatedNode.nodeValue : 0.0d;
        double d3 = valueAnimatedNode2 != null ? valueAnimatedNode2.nodeValue : 0.0d;
        double d4 = valueAnimatedNode3 != null ? valueAnimatedNode3.nodeValue : 0.0d;
        if (valueAnimatedNode4 != null) {
            d = valueAnimatedNode4.nodeValue;
        }
        return ColorUtil.normalize(d2, d3, d4, d);
    }

    @Override // com.facebook.react.animated.AnimatedNodeWithUpdateableConfig
    public void onUpdateConfig(@Nullable ReadableMap config) {
        if (config != null) {
            this.rNodeId = config.getInt("r");
            this.gNodeId = config.getInt("g");
            this.bNodeId = config.getInt("b");
            this.aNodeId = config.getInt(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY);
            this.nativeColor = config.getMap("nativeColor");
            this.nativeColorApplied = false;
            tryApplyNativeColor();
            return;
        }
        this.rNodeId = 0;
        this.gNodeId = 0;
        this.bNodeId = 0;
        this.aNodeId = 0;
        this.nativeColor = null;
        this.nativeColorApplied = false;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    @NotNull
    public String prettyPrint() {
        return "ColorAnimatedNode[" + this.tag + "]: r: " + this.rNodeId + "  g: " + this.gNodeId + " b: " + this.bNodeId + " a: " + this.aNodeId;
    }

    private final void tryApplyNativeColor() {
        Context context;
        if (this.nativeColor == null || this.nativeColorApplied || (context = getContext()) == null) {
            return;
        }
        Integer color = ColorPropConverter.getColor(this.nativeColor, context);
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.rNodeId);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.gNodeId);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.bNodeId);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.aNodeId);
        if (valueAnimatedNode != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode.nodeValue = Color.red(color.intValue());
        }
        if (valueAnimatedNode2 != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode2.nodeValue = Color.green(color.intValue());
        }
        if (valueAnimatedNode3 != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode3.nodeValue = Color.blue(color.intValue());
        }
        if (valueAnimatedNode4 != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode4.nodeValue = Color.alpha(color.intValue()) / 255.0d;
        }
        this.nativeColorApplied = true;
    }

    private final Context getContext() {
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        return currentActivity != null ? currentActivity : INSTANCE.getContextHelper(this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/facebook/react/animated/ColorAnimatedNode$Companion;", "", "<init>", "()V", "getContextHelper", "Landroid/content/Context;", "node", "Lcom/facebook/react/animated/AnimatedNode;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context getContextHelper(AnimatedNode node) {
            List<AnimatedNode> list = node.children;
            if (list == null) {
                return null;
            }
            Iterator<AnimatedNode> it = list.iterator();
            if (!it.hasNext()) {
                return null;
            }
            AnimatedNode next = it.next();
            if (next instanceof PropsAnimatedNode) {
                View connectedView = ((PropsAnimatedNode) next).getConnectedView();
                if (connectedView != null) {
                    return connectedView.getContext();
                }
                return null;
            }
            return ColorAnimatedNode.INSTANCE.getContextHelper(next);
        }
    }
}
