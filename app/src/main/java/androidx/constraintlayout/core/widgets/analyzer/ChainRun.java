package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.widgets = new ArrayList();
        this.orientation = i;
        build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.widgets) {
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!((WidgetRun) this.widgets.get(i)).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long wrapDimension = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = (WidgetRun) this.widgets.get(i);
            wrapDimension = wrapDimension + ((long) widgetRun.start.margin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.margin);
        }
        return wrapDimension;
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : this.widgets) {
            int i = this.orientation;
            if (i == 0) {
                widgetRun.widget.horizontalChainRun = this;
            } else if (i == 1) {
                widgetRun.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl() && this.widgets.size() > 1) {
            ArrayList arrayList = this.widgets;
            this.widget = ((WidgetRun) arrayList.get(arrayList.size() - 1)).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator it = this.widgets.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:293:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x0153  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f2;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i15 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i16 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i16 >= size) {
                    i16 = -1;
                    break;
                } else if (((WidgetRun) this.widgets.get(i16)).widget.getVisibility() != 8) {
                    break;
                } else {
                    i16++;
                }
            }
            int i17 = size - 1;
            for (int i18 = i17; i18 >= 0; i18--) {
                if (((WidgetRun) this.widgets.get(i18)).widget.getVisibility() != 8) {
                    i = i18;
                    break;
                }
            }
            int i19 = 0;
            while (true) {
                if (i19 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = BitmapDescriptorFactory.HUE_RED;
                    break;
                }
                int i20 = 0;
                i4 = 0;
                i5 = 0;
                int i21 = 0;
                f = BitmapDescriptorFactory.HUE_RED;
                while (i20 < size) {
                    WidgetRun widgetRun = (WidgetRun) this.widgets.get(i20);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i21++;
                        if (i20 > 0 && i20 >= i16) {
                            i4 += widgetRun.start.margin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.dimension;
                        int i22 = dimensionDependency.value;
                        boolean z2 = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z2) {
                            int i23 = this.orientation;
                            if (i23 == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (i23 == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            } else {
                                i13 = i22;
                            }
                        } else {
                            i13 = i22;
                            if (widgetRun.matchConstraintsType == 1 && i19 == 0) {
                                i14 = dimensionDependency.wrapValue;
                                i5++;
                            } else {
                                if (dimensionDependency.resolved) {
                                    i14 = i13;
                                }
                                if (z2) {
                                    i4 += i14;
                                } else {
                                    i5++;
                                    f2 = widgetRun.widget.mWeight[this.orientation];
                                    if (f2 >= BitmapDescriptorFactory.HUE_RED) {
                                        f += f2;
                                    }
                                }
                                if (i20 >= i17 && i20 < i) {
                                    i4 += -widgetRun.end.margin;
                                }
                            }
                            z2 = true;
                            if (z2) {
                                i5++;
                                f2 = widgetRun.widget.mWeight[this.orientation];
                                if (f2 >= BitmapDescriptorFactory.HUE_RED) {
                                    f += f2;
                                }
                            } else {
                                i4 += i14;
                            }
                            if (i20 >= i17) {
                            }
                        }
                        i14 = i13;
                        if (z2) {
                            i5++;
                            f2 = widgetRun.widget.mWeight[this.orientation];
                            if (f2 >= BitmapDescriptorFactory.HUE_RED) {
                                f += f2;
                            }
                        } else {
                            i4 += i14;
                        }
                        if (i20 >= i17) {
                        }
                    }
                    i20++;
                    i2 = 8;
                }
                if (i4 < i15 || i5 == 0) {
                    i3 = i21;
                    break;
                } else {
                    i19++;
                    i2 = 8;
                }
            }
            int i24 = this.start.value;
            if (zIsRtl) {
                i24 = this.end.value;
            }
            if (i4 > i15) {
                i24 = zIsRtl ? i24 + ((int) (((i4 - i15) / 2.0f) + 0.5f)) : i24 - ((int) (((i4 - i15) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f3 = i15 - i4;
                int i25 = (int) ((f3 / i5) + 0.5f);
                int i26 = 0;
                int i27 = 0;
                while (i26 < size) {
                    WidgetRun widgetRun2 = (WidgetRun) this.widgets.get(i26);
                    int i28 = i25;
                    int i29 = i4;
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        if (dimensionDependency2.resolved) {
                            zIsRtl = zIsRtl;
                            i24 = i24;
                            f3 = f3;
                        } else {
                            int i30 = f > BitmapDescriptorFactory.HUE_RED ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f3) / f) + 0.5f) : i28;
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.widget;
                                i12 = constraintWidget.mMatchConstraintMaxWidth;
                                i11 = constraintWidget.mMatchConstraintMinWidth;
                            } else {
                                ConstraintWidget constraintWidget2 = widgetRun2.widget;
                                int i31 = constraintWidget2.mMatchConstraintMaxHeight;
                                i11 = constraintWidget2.mMatchConstraintMinHeight;
                                i12 = i31;
                            }
                            int iMax = Math.max(i11, widgetRun2.matchConstraintsType == 1 ? Math.min(i30, dimensionDependency2.wrapValue) : i30);
                            if (i12 > 0) {
                                iMax = Math.min(i12, iMax);
                            }
                            if (iMax != i30) {
                                i27++;
                                i30 = iMax;
                            }
                            widgetRun2.dimension.resolve(i30);
                        }
                    } else {
                        zIsRtl = zIsRtl;
                        i24 = i24;
                        f3 = f3;
                    }
                    i26++;
                    i25 = i28;
                    i4 = i29;
                    i24 = i24;
                    f3 = f3;
                    zIsRtl = zIsRtl;
                    i3 = i3;
                }
                z = zIsRtl;
                i6 = i3;
                i7 = i24;
                int i32 = i4;
                if (i27 > 0) {
                    i5 -= i27;
                    i4 = 0;
                    for (int i33 = 0; i33 < size; i33++) {
                        WidgetRun widgetRun3 = (WidgetRun) this.widgets.get(i33);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i33 > 0 && i33 >= i16) {
                                i4 += widgetRun3.start.margin;
                            }
                            i4 += widgetRun3.dimension.value;
                            if (i33 < i17 && i33 < i) {
                                i4 += -widgetRun3.end.margin;
                            }
                        }
                    }
                } else {
                    i4 = i32;
                }
                i9 = 2;
                if (this.chainStyle == 2 && i27 == 0) {
                    i8 = 0;
                    this.chainStyle = 0;
                } else {
                    i8 = 0;
                }
            } else {
                z = zIsRtl;
                i6 = i3;
                i7 = i24;
                i8 = 0;
                i9 = 2;
            }
            if (i4 > i15) {
                this.chainStyle = i9;
            }
            if (i6 > 0 && i5 == 0 && i16 == i) {
                this.chainStyle = i9;
            }
            int i34 = this.chainStyle;
            if (i34 == 1) {
                int i35 = i6;
                if (i35 > 1) {
                    i10 = (i15 - i4) / (i35 - 1);
                } else {
                    i10 = i35 == 1 ? (i15 - i4) / 2 : i8;
                }
                if (i5 > 0) {
                    i10 = i8;
                }
                int i36 = i7;
                for (int i37 = i8; i37 < size; i37++) {
                    WidgetRun widgetRun4 = (WidgetRun) this.widgets.get(z ? size - (i37 + 1) : i37);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i36);
                        widgetRun4.end.resolve(i36);
                    } else {
                        if (i37 > 0) {
                            i36 = z ? i36 - i10 : i36 + i10;
                        }
                        if (i37 > 0 && i37 >= i16) {
                            if (z) {
                                i36 -= widgetRun4.start.margin;
                            } else {
                                i36 += widgetRun4.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun4.end.resolve(i36);
                        } else {
                            widgetRun4.start.resolve(i36);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                        int i38 = dimensionDependency3.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i38 = dimensionDependency3.wrapValue;
                        }
                        i36 = z ? i36 - i38 : i36 + i38;
                        if (z) {
                            widgetRun4.start.resolve(i36);
                        } else {
                            widgetRun4.end.resolve(i36);
                        }
                        widgetRun4.resolved = true;
                        if (i37 < i17 && i37 < i) {
                            if (z) {
                                i36 -= -widgetRun4.end.margin;
                            } else {
                                i36 += -widgetRun4.end.margin;
                            }
                        }
                    }
                }
                return;
            }
            int i39 = i6;
            if (i34 == 0) {
                int i40 = (i15 - i4) / (i39 + 1);
                if (i5 > 0) {
                    i40 = i8;
                }
                int i41 = i7;
                for (int i42 = i8; i42 < size; i42++) {
                    WidgetRun widgetRun5 = (WidgetRun) this.widgets.get(z ? size - (i42 + 1) : i42);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i41);
                        widgetRun5.end.resolve(i41);
                    } else {
                        int i43 = z ? i41 - i40 : i41 + i40;
                        if (i42 > 0 && i42 >= i16) {
                            if (z) {
                                i43 -= widgetRun5.start.margin;
                            } else {
                                i43 += widgetRun5.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun5.end.resolve(i43);
                        } else {
                            widgetRun5.start.resolve(i43);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                        int iMin = dimensionDependency4.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, dimensionDependency4.wrapValue);
                        }
                        i41 = z ? i43 - iMin : i43 + iMin;
                        if (z) {
                            widgetRun5.start.resolve(i41);
                        } else {
                            widgetRun5.end.resolve(i41);
                        }
                        if (i42 < i17 && i42 < i) {
                            if (z) {
                                i41 -= -widgetRun5.end.margin;
                            } else {
                                i41 += -widgetRun5.end.margin;
                            }
                        }
                    }
                }
                return;
            }
            if (i34 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (z) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i44 = (int) (((i15 - i4) * horizontalBiasPercent) + 0.5f);
                if (i44 < 0 || i5 > 0) {
                    i44 = i8;
                }
                int i45 = z ? i7 - i44 : i7 + i44;
                for (int i46 = i8; i46 < size; i46++) {
                    WidgetRun widgetRun6 = (WidgetRun) this.widgets.get(z ? size - (i46 + 1) : i46);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i45);
                        widgetRun6.end.resolve(i45);
                    } else {
                        if (i46 > 0 && i46 >= i16) {
                            if (z) {
                                i45 -= widgetRun6.start.margin;
                            } else {
                                i45 += widgetRun6.start.margin;
                            }
                        }
                        if (z) {
                            widgetRun6.end.resolve(i45);
                        } else {
                            widgetRun6.start.resolve(i45);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                        int i47 = dimensionDependency5.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i47 = dimensionDependency5.wrapValue;
                        }
                        i45 = z ? i45 - i47 : i45 + i47;
                        if (z) {
                            widgetRun6.start.resolve(i45);
                        } else {
                            widgetRun6.end.resolve(i45);
                        }
                        if (i46 < i17 && i46 < i) {
                            if (z) {
                                i45 -= -widgetRun6.end.margin;
                            } else {
                                i45 += -widgetRun6.end.margin;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            ((WidgetRun) this.widgets.get(i)).applyToWidget();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = (WidgetRun) this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = (WidgetRun) this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Iterator it = this.widgets.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = ((WidgetRun) this.widgets.get(0)).widget;
        ConstraintWidget constraintWidget2 = ((WidgetRun) this.widgets.get(size - 1)).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }
}
