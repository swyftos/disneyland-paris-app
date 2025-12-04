package com.urbanairship.android.layout.util;

import android.content.Context;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.property.HorizontalPosition;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.property.Position;
import com.urbanairship.android.layout.property.Size;
import com.urbanairship.android.layout.property.VerticalPosition;

/* loaded from: classes5.dex */
public final class ConstraintSetBuilder {

    @NonNull
    public final ConstraintSet constraints;
    private final Context context;

    private ConstraintSetBuilder(Context context) {
        this(context, null);
    }

    private ConstraintSetBuilder(Context context, ConstraintSet constraintSet) {
        this.context = context;
        ConstraintSet constraintSet2 = new ConstraintSet();
        this.constraints = constraintSet2;
        if (constraintSet != null) {
            constraintSet2.clone(constraintSet);
        }
    }

    @NonNull
    public static ConstraintSetBuilder newBuilder(@NonNull Context context) {
        return new ConstraintSetBuilder(context);
    }

    @NonNull
    public ConstraintSetBuilder constrainWithinParent(int i) {
        return constrainWithinParent(i, null);
    }

    @NonNull
    public ConstraintSetBuilder constrainWithinParent(int i, @Nullable Margin margin) {
        if (margin == null) {
            this.constraints.addToHorizontalChain(i, 0, 0);
            this.constraints.addToVerticalChain(i, 0, 0);
        } else {
            addToHorizontalChain(i, 0, 0, margin.getStart(), margin.getEnd());
            addToVerticalChain(i, 0, 0, margin.getTop(), margin.getBottom());
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder addToVerticalChain(int i, int i2, int i3, int i4, int i5) {
        this.constraints.connect(i, 3, i2, i2 == 0 ? 3 : 4, (int) ResourceUtils.dpToPx(this.context, i4));
        this.constraints.connect(i, 4, i3, i3 == 0 ? 4 : 3, (int) ResourceUtils.dpToPx(this.context, i5));
        if (i2 != 0) {
            this.constraints.connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            this.constraints.connect(i3, 3, i, 4, 0);
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder addToHorizontalChain(int i, int i2, int i3, int i4, int i5) {
        this.constraints.connect(i, 1, i2, i2 == 0 ? 1 : 2, (int) ResourceUtils.dpToPx(this.context, i4));
        this.constraints.connect(i, 2, i3, i3 == 0 ? 2 : 1, (int) ResourceUtils.dpToPx(this.context, i5));
        if (i2 != 0) {
            this.constraints.connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            this.constraints.connect(i3, 1, i, 2, 0);
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder setHorizontalChainStyle(@NonNull int[] iArr, int i) {
        for (int i2 : iArr) {
            this.constraints.setHorizontalChainStyle(i2, i);
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder createHorizontalChainInParent(int[] iArr, int i, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i3 == 0) {
                addToHorizontalChain(i4, 0, iArr[i3 + 1], 0, i2);
            } else if (i3 == iArr.length - 1) {
                addToHorizontalChain(i4, iArr[i3 - 1], 0, i2, 0);
            } else {
                addToHorizontalChain(i4, iArr[i3 - 1], iArr[i3 + 1], i2, i2);
            }
            addToVerticalChain(i4, 0, 0, i, i);
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder squareAspectRatio(int i) {
        this.constraints.setDimensionRatio(i, "1:1");
        return this;
    }

    @NonNull
    public ConstraintSetBuilder minWidth(int i, int i2) {
        this.constraints.constrainMinWidth(i, (int) ResourceUtils.dpToPx(this.context, i2));
        return this;
    }

    @NonNull
    public ConstraintSetBuilder maxWidth(int i, int i2) {
        this.constraints.constrainMaxWidth(i, (int) ResourceUtils.dpToPx(this.context, i2));
        return this;
    }

    @NonNull
    public ConstraintSetBuilder minHeight(int i, int i2) {
        this.constraints.constrainMinHeight(i, (int) ResourceUtils.dpToPx(this.context, i2));
        return this;
    }

    @NonNull
    public ConstraintSetBuilder maxHeight(int i, int i2) {
        this.constraints.constrainMaxHeight(i, (int) ResourceUtils.dpToPx(this.context, i2));
        return this;
    }

    @NonNull
    public ConstraintSetBuilder size(@Nullable Size size, @IdRes int i) {
        return size(size, false, i);
    }

    @NonNull
    public ConstraintSetBuilder size(@Nullable Size size, boolean z, @IdRes int i) {
        return size(size, z, i, -2);
    }

    @NonNull
    public ConstraintSetBuilder size(@Nullable Size size, boolean z, @IdRes int i, int i2) {
        width(size, z, i, i2);
        height(size, z, i, i2);
        return this;
    }

    @NonNull
    public ConstraintSetBuilder width(@Nullable Size size, @IdRes int i) {
        return width(size, false, i);
    }

    @NonNull
    public ConstraintSetBuilder width(@Nullable Size size, boolean z, @IdRes int i) {
        return width(size, z, i, -2);
    }

    @NonNull
    public ConstraintSetBuilder width(@Nullable Size size, boolean z, @IdRes int i, int i2) {
        if (size != null) {
            if (size instanceof ConstrainedSize) {
                ConstrainedSize constrainedSize = (ConstrainedSize) size;
                ConstrainedSize.ConstrainedDimension minWidth = constrainedSize.getMinWidth();
                if (minWidth != null) {
                    int i3 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[minWidth.getType().ordinal()];
                    if (i3 == 1) {
                        this.constraints.constrainMinWidth(i, (int) (minWidth.getFloat() * ResourceUtils.getWindowWidthPixels(this.context, z)));
                    } else if (i3 == 2) {
                        this.constraints.constrainMinWidth(i, (int) ResourceUtils.dpToPx(this.context, minWidth.getInt()));
                    }
                }
                ConstrainedSize.ConstrainedDimension maxWidth = constrainedSize.getMaxWidth();
                if (maxWidth != null) {
                    int i4 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[maxWidth.getType().ordinal()];
                    if (i4 == 1) {
                        this.constraints.constrainMaxWidth(i, (int) (maxWidth.getFloat() * ResourceUtils.getWindowWidthPixels(this.context, z)));
                    } else if (i4 == 2) {
                        this.constraints.constrainMaxWidth(i, (int) ResourceUtils.dpToPx(this.context, maxWidth.getInt()));
                    }
                }
            }
            Size.Dimension width = size.getWidth();
            int i5 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$Size$DimensionType[width.getType().ordinal()];
            if (i5 == 1) {
                this.constraints.constrainWidth(i, i2);
            } else if (i5 != 2) {
                if (i5 == 3) {
                    this.constraints.constrainWidth(i, (int) ResourceUtils.dpToPx(this.context, width.getInt()));
                }
            } else if (width.getFloat() == 1.0f) {
                this.constraints.constrainWidth(i, 0);
            } else {
                this.constraints.constrainPercentWidth(i, width.getFloat());
            }
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder height(@Nullable Size size, @IdRes int i) {
        return height(size, false, i);
    }

    @NonNull
    public ConstraintSetBuilder height(@Nullable Size size, boolean z, @IdRes int i) {
        return height(size, z, i, -2);
    }

    @NonNull
    public ConstraintSetBuilder height(@Nullable Size size, boolean z, @IdRes int i, int i2) {
        if (size != null) {
            if (size instanceof ConstrainedSize) {
                ConstrainedSize constrainedSize = (ConstrainedSize) size;
                ConstrainedSize.ConstrainedDimension minHeight = constrainedSize.getMinHeight();
                if (minHeight != null) {
                    int i3 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[minHeight.getType().ordinal()];
                    if (i3 == 1) {
                        this.constraints.constrainMinHeight(i, (int) (minHeight.getFloat() * ResourceUtils.getWindowHeightPixels(this.context, z)));
                    } else if (i3 == 2) {
                        this.constraints.constrainMinHeight(i, (int) ResourceUtils.dpToPx(this.context, minHeight.getInt()));
                    }
                }
                ConstrainedSize.ConstrainedDimension maxHeight = constrainedSize.getMaxHeight();
                if (maxHeight != null) {
                    int i4 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[maxHeight.getType().ordinal()];
                    if (i4 == 1) {
                        this.constraints.constrainMaxHeight(i, (int) (maxHeight.getFloat() * ResourceUtils.getWindowHeightPixels(this.context, z)));
                    } else if (i4 == 2) {
                        this.constraints.constrainMaxHeight(i, (int) ResourceUtils.dpToPx(this.context, maxHeight.getInt()));
                    }
                }
            }
            Size.Dimension height = size.getHeight();
            int i5 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$Size$DimensionType[height.getType().ordinal()];
            if (i5 == 1) {
                this.constraints.constrainHeight(i, i2);
            } else if (i5 != 2) {
                if (i5 == 3) {
                    this.constraints.constrainHeight(i, (int) ResourceUtils.dpToPx(this.context, height.getInt()));
                }
            } else if (height.getFloat() == 1.0f) {
                this.constraints.constrainHeight(i, 0);
            } else {
                this.constraints.constrainPercentHeight(i, height.getFloat());
            }
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder matchConstraintWidth(int i) {
        this.constraints.constrainWidth(i, 0);
        return this;
    }

    @NonNull
    public ConstraintSetBuilder matchConstraintHeight(int i) {
        this.constraints.constrainHeight(i, 0);
        return this;
    }

    @NonNull
    public ConstraintSetBuilder position(@Nullable Position position, @IdRes int i) {
        if (position != null) {
            constrainWithinParent(i);
            int i2 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition[position.getHorizontal().ordinal()];
            if (i2 == 1) {
                this.constraints.setHorizontalBias(i, BitmapDescriptorFactory.HUE_RED);
            } else if (i2 == 2) {
                this.constraints.setHorizontalBias(i, 1.0f);
            } else if (i2 == 3) {
                this.constraints.setHorizontalBias(i, 0.5f);
            }
            int i3 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$VerticalPosition[position.getVertical().ordinal()];
            if (i3 == 1) {
                this.constraints.setVerticalBias(i, BitmapDescriptorFactory.HUE_RED);
            } else if (i3 == 2) {
                this.constraints.setVerticalBias(i, 1.0f);
            } else if (i3 == 3) {
                this.constraints.setVerticalBias(i, 0.5f);
            }
        }
        return this;
    }

    /* renamed from: com.urbanairship.android.layout.util.ConstraintSetBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType;
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition;
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$Size$DimensionType;
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$VerticalPosition;

        static {
            int[] iArr = new int[VerticalPosition.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$VerticalPosition = iArr;
            try {
                iArr[VerticalPosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$VerticalPosition[VerticalPosition.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$VerticalPosition[VerticalPosition.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[HorizontalPosition.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition = iArr2;
            try {
                iArr2[HorizontalPosition.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition[HorizontalPosition.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition[HorizontalPosition.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[Size.DimensionType.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$Size$DimensionType = iArr3;
            try {
                iArr3[Size.DimensionType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$Size$DimensionType[Size.DimensionType.PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$Size$DimensionType[Size.DimensionType.ABSOLUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[ConstrainedSize.ConstrainedDimensionType.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType = iArr4;
            try {
                iArr4[ConstrainedSize.ConstrainedDimensionType.PERCENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$ConstrainedSize$ConstrainedDimensionType[ConstrainedSize.ConstrainedDimensionType.ABSOLUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @NonNull
    public ConstraintSetBuilder margin(@Nullable Margin margin, @IdRes int i) {
        if (margin != null) {
            this.constraints.setMargin(i, 3, (int) ResourceUtils.dpToPx(this.context, margin.getTop()));
            this.constraints.setMargin(i, 4, (int) ResourceUtils.dpToPx(this.context, margin.getBottom()));
            this.constraints.setMargin(i, 6, (int) ResourceUtils.dpToPx(this.context, margin.getStart()));
            this.constraints.setMargin(i, 7, (int) ResourceUtils.dpToPx(this.context, margin.getEnd()));
        }
        return this;
    }

    @NonNull
    public ConstraintSetBuilder margin(@Nullable Margin margin, @NonNull Insets insets, @IdRes int i) {
        if (margin == null) {
            margin = new Margin(0, 0, 0, 0);
        }
        this.constraints.setMargin(i, 3, ((int) ResourceUtils.dpToPx(this.context, margin.getTop())) + insets.top);
        this.constraints.setMargin(i, 4, ((int) ResourceUtils.dpToPx(this.context, margin.getBottom())) + insets.bottom);
        this.constraints.setMargin(i, 6, ((int) ResourceUtils.dpToPx(this.context, margin.getStart())) + insets.left);
        this.constraints.setMargin(i, 7, ((int) ResourceUtils.dpToPx(this.context, margin.getEnd())) + insets.right);
        return this;
    }

    @NonNull
    public ConstraintSet build() {
        return this.constraints;
    }
}
