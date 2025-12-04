package com.contentsquare.android.core.communication.compose;

import android.graphics.Rect;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001:\u0001EB§\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b¢\u0006\u0002\u0010\u0018J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012HÆ\u0003J\t\u00104\u001a\u00020\u0014HÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J«\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000bHÆ\u0001J\u0013\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\rHÖ\u0001J\b\u0010D\u001a\u00020\u0003H\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001a\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010%R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010%\"\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/¨\u0006F"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ViewNode;", "", "id", "", "name", "parent", "bounds", "Landroid/graphics/Rect;", "posZ", "", "isVisible", "", "childOrder", "", "viewAlpha", AppStateModule.APP_STATE_BACKGROUND, "bitmap", "children", "", "nodeType", "Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType;", "isClickable", "isEmptyOverlay", "excludeFromGestureRecognition", "(Ljava/lang/String;Ljava/lang/String;Lcom/contentsquare/android/core/communication/compose/ViewNode;Landroid/graphics/Rect;FZIFLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType;ZZZ)V", "getBackground", "()Ljava/lang/String;", "getBitmap", "setBitmap", "(Ljava/lang/String;)V", "getBounds", "()Landroid/graphics/Rect;", "getChildOrder", "()I", "getChildren", "()Ljava/util/List;", "getExcludeFromGestureRecognition", "()Z", "getId", "setEmptyOverlay", "(Z)V", "getName", "getNodeType", "()Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType;", "getParent", "()Lcom/contentsquare/android/core/communication/compose/ViewNode;", "getPosZ", "()F", "getViewAlpha", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "NodeType", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ViewNode {

    @Nullable
    private final String background;

    @Nullable
    private String bitmap;

    @NotNull
    private final Rect bounds;
    private final int childOrder;

    @NotNull
    private final List<ViewNode> children;
    private final boolean excludeFromGestureRecognition;

    @NotNull
    private final String id;
    private final boolean isClickable;
    private boolean isEmptyOverlay;
    private final boolean isVisible;

    @NotNull
    private final String name;

    @NotNull
    private final NodeType nodeType;

    @Nullable
    private final ViewNode parent;
    private final float posZ;
    private final float viewAlpha;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType;", "", "()V", "Container", "Node", "VerticalLazyContainer", "Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType$Container;", "Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType$Node;", "Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType$VerticalLazyContainer;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class NodeType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType$Container;", "Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Container extends NodeType {

            @NotNull
            public static final Container INSTANCE = new Container();

            private Container() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType$Node;", "Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Node extends NodeType {

            @NotNull
            public static final Node INSTANCE = new Node();

            private Node() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType$VerticalLazyContainer;", "Lcom/contentsquare/android/core/communication/compose/ViewNode$NodeType;", "columnCount", "", "(I)V", "getColumnCount", "()I", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class VerticalLazyContainer extends NodeType {
            private final int columnCount;

            public VerticalLazyContainer(int i) {
                super(null);
                this.columnCount = i;
            }

            public static /* synthetic */ VerticalLazyContainer copy$default(VerticalLazyContainer verticalLazyContainer, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = verticalLazyContainer.columnCount;
                }
                return verticalLazyContainer.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getColumnCount() {
                return this.columnCount;
            }

            @NotNull
            public final VerticalLazyContainer copy(int columnCount) {
                return new VerticalLazyContainer(columnCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof VerticalLazyContainer) && this.columnCount == ((VerticalLazyContainer) other).columnCount;
            }

            public final int getColumnCount() {
                return this.columnCount;
            }

            public int hashCode() {
                return Integer.hashCode(this.columnCount);
            }

            @NotNull
            public String toString() {
                return "VerticalLazyContainer(columnCount=" + this.columnCount + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }
        }

        private NodeType() {
        }

        public /* synthetic */ NodeType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ViewNode() {
        this(null, null, null, null, BitmapDescriptorFactory.HUE_RED, false, 0, BitmapDescriptorFactory.HUE_RED, null, null, null, null, false, false, false, 32767, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getBitmap() {
        return this.bitmap;
    }

    @NotNull
    public final List<ViewNode> component11() {
        return this.children;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final NodeType getNodeType() {
        return this.nodeType;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsClickable() {
        return this.isClickable;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsEmptyOverlay() {
        return this.isEmptyOverlay;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getExcludeFromGestureRecognition() {
        return this.excludeFromGestureRecognition;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final ViewNode getParent() {
        return this.parent;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final Rect getBounds() {
        return this.bounds;
    }

    /* renamed from: component5, reason: from getter */
    public final float getPosZ() {
        return this.posZ;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* renamed from: component7, reason: from getter */
    public final int getChildOrder() {
        return this.childOrder;
    }

    /* renamed from: component8, reason: from getter */
    public final float getViewAlpha() {
        return this.viewAlpha;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getBackground() {
        return this.background;
    }

    @NotNull
    public final ViewNode copy(String id, String name, ViewNode parent, Rect bounds, float posZ, boolean isVisible, int childOrder, float viewAlpha, String background, String bitmap, List<ViewNode> children, NodeType nodeType, boolean isClickable, boolean isEmptyOverlay, boolean excludeFromGestureRecognition) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(nodeType, "nodeType");
        return new ViewNode(id, name, parent, bounds, posZ, isVisible, childOrder, viewAlpha, background, bitmap, children, nodeType, isClickable, isEmptyOverlay, excludeFromGestureRecognition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewNode)) {
            return false;
        }
        ViewNode viewNode = (ViewNode) other;
        return Intrinsics.areEqual(this.id, viewNode.id) && Intrinsics.areEqual(this.name, viewNode.name) && Intrinsics.areEqual(this.parent, viewNode.parent) && Intrinsics.areEqual(this.bounds, viewNode.bounds) && Float.compare(this.posZ, viewNode.posZ) == 0 && this.isVisible == viewNode.isVisible && this.childOrder == viewNode.childOrder && Float.compare(this.viewAlpha, viewNode.viewAlpha) == 0 && Intrinsics.areEqual(this.background, viewNode.background) && Intrinsics.areEqual(this.bitmap, viewNode.bitmap) && Intrinsics.areEqual(this.children, viewNode.children) && Intrinsics.areEqual(this.nodeType, viewNode.nodeType) && this.isClickable == viewNode.isClickable && this.isEmptyOverlay == viewNode.isEmptyOverlay && this.excludeFromGestureRecognition == viewNode.excludeFromGestureRecognition;
    }

    @Nullable
    public final String getBackground() {
        return this.background;
    }

    @Nullable
    public final String getBitmap() {
        return this.bitmap;
    }

    @NotNull
    public final Rect getBounds() {
        return this.bounds;
    }

    public final int getChildOrder() {
        return this.childOrder;
    }

    @NotNull
    public final List<ViewNode> getChildren() {
        return this.children;
    }

    public final boolean getExcludeFromGestureRecognition() {
        return this.excludeFromGestureRecognition;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final NodeType getNodeType() {
        return this.nodeType;
    }

    @Nullable
    public final ViewNode getParent() {
        return this.parent;
    }

    public final float getPosZ() {
        return this.posZ;
    }

    public final float getViewAlpha() {
        return this.viewAlpha;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = (this.name.hashCode() + (this.id.hashCode() * 31)) * 31;
        ViewNode viewNode = this.parent;
        int iHashCode2 = (Float.hashCode(this.posZ) + ((this.bounds.hashCode() + ((iHashCode + (viewNode == null ? 0 : viewNode.hashCode())) * 31)) * 31)) * 31;
        boolean z = this.isVisible;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int iHashCode3 = (Float.hashCode(this.viewAlpha) + ((Integer.hashCode(this.childOrder) + ((iHashCode2 + i) * 31)) * 31)) * 31;
        String str = this.background;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bitmap;
        int iHashCode5 = (this.nodeType.hashCode() + ((this.children.hashCode() + ((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31)) * 31;
        boolean z2 = this.isClickable;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode5 + i2) * 31;
        boolean z3 = this.isEmptyOverlay;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.excludeFromGestureRecognition;
        return i5 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isClickable() {
        return this.isClickable;
    }

    public final boolean isEmptyOverlay() {
        return this.isEmptyOverlay;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setBitmap(String str) {
        this.bitmap = str;
    }

    public final void setEmptyOverlay(boolean z) {
        this.isEmptyOverlay = z;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ViewNode name: ");
        sb.append(this.name);
        sb.append(" parent: ");
        ViewNode viewNode = this.parent;
        sb.append(viewNode != null ? viewNode.name : null);
        sb.append(" nodeType: ");
        sb.append(this.nodeType);
        sb.append(" bounds: ");
        sb.append(this.bounds);
        sb.append(" posZ: ");
        sb.append(this.posZ);
        sb.append(" isVisible: ");
        sb.append(this.isVisible);
        sb.append(" childOrder: ");
        sb.append(this.childOrder);
        sb.append(" viewAlpha: ");
        sb.append(this.viewAlpha);
        sb.append(" background: ");
        sb.append(this.background);
        sb.append(" childrenSize: ");
        sb.append(this.children.size());
        sb.append(" isClickable: ");
        sb.append(this.isClickable);
        sb.append(" isEmptyOverlay: ");
        sb.append(this.isEmptyOverlay);
        sb.append(" excludeFromGestureRecognition: ");
        sb.append(this.excludeFromGestureRecognition);
        sb.append(' ');
        return sb.toString();
    }

    public ViewNode(String id, String name, ViewNode viewNode, Rect bounds, float f, boolean z, int i, float f2, String str, String str2, List<ViewNode> children, NodeType nodeType, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(nodeType, "nodeType");
        this.id = id;
        this.name = name;
        this.parent = viewNode;
        this.bounds = bounds;
        this.posZ = f;
        this.isVisible = z;
        this.childOrder = i;
        this.viewAlpha = f2;
        this.background = str;
        this.bitmap = str2;
        this.children = children;
        this.nodeType = nodeType;
        this.isClickable = z2;
        this.isEmptyOverlay = z3;
        this.excludeFromGestureRecognition = z4;
    }

    public /* synthetic */ ViewNode(String str, String str2, ViewNode viewNode, Rect rect, float f, boolean z, int i, float f2, String str3, String str4, List list, NodeType nodeType, boolean z2, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) == 0 ? str2 : "", (i2 & 4) != 0 ? null : viewNode, (i2 & 8) != 0 ? new Rect() : rect, (i2 & 16) != 0 ? BitmapDescriptorFactory.HUE_RED : f, (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? 1.0f : f2, (i2 & 256) != 0 ? null : str3, (i2 & 512) == 0 ? str4 : null, (i2 & 1024) != 0 ? new ArrayList() : list, (i2 & 2048) != 0 ? NodeType.Node.INSTANCE : nodeType, (i2 & 4096) != 0 ? false : z2, (i2 & 8192) != 0 ? false : z3, (i2 & 16384) == 0 ? z4 : false);
    }
}
