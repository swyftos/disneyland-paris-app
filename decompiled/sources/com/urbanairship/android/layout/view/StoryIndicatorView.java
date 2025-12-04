package com.urbanairship.android.layout.view;

import android.content.Context;
import android.widget.LinearLayout;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.StoryIndicatorModel;
import com.urbanairship.android.layout.property.Direction;
import com.urbanairship.android.layout.property.StoryIndicatorSource;
import com.urbanairship.android.layout.property.StoryIndicatorStyle;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011J.\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/view/StoryIndicatorView;", "Landroid/widget/LinearLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/StoryIndicatorModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/StoryIndicatorModel;)V", "lastProgress", "", "progressIndicators", "", "Landroid/widget/ProgressBar;", "setCount", "", "count", "durations", "", "setProgress", "pageIndex", "progress", "animated", "", "announcePage", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StoryIndicatorView extends LinearLayout implements BaseView {
    private int lastProgress;
    private final StoryIndicatorModel model;
    private List progressIndicators;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StoryIndicatorStyle.LinearProgress.SizingType.values().length];
            try {
                iArr[StoryIndicatorStyle.LinearProgress.SizingType.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StoryIndicatorStyle.LinearProgress.SizingType.PAGE_DURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryIndicatorView(@NotNull Context context, @NotNull StoryIndicatorModel model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        this.progressIndicators = new ArrayList();
        StoryIndicatorStyle style = model.getViewInfo().getStyle();
        if (style instanceof StoryIndicatorStyle.LinearProgress) {
            setOrientation(((StoryIndicatorStyle.LinearProgress) style).getDirection() == Direction.VERTICAL ? 1 : 0);
            setGravity(17);
        }
        if (model.getAnnouncePage()) {
            setFocusable(true);
            setFocusableInTouchMode(true);
            setImportantForAccessibility(1);
        }
        model.setListener$urbanairship_layout_release(new StoryIndicatorModel.Listener() { // from class: com.urbanairship.android.layout.view.StoryIndicatorView.1
            private boolean isInitialized;

            @Override // com.urbanairship.android.layout.model.StoryIndicatorModel.Listener
            public void onUpdate(int size, int pageIndex, int progress, @NotNull List<Integer> durations, boolean announcePage) {
                Intrinsics.checkNotNullParameter(durations, "durations");
                if (!this.isInitialized) {
                    this.isInitialized = true;
                    StoryIndicatorView.this.setCount(size, durations);
                }
                boolean z = progress > StoryIndicatorView.this.lastProgress;
                StoryIndicatorView.this.lastProgress = progress;
                StoryIndicatorView.this.setProgress(size, pageIndex, progress, z, announcePage);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                StoryIndicatorView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                StoryIndicatorView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(StoryIndicatorView.this, old, background);
            }
        });
    }

    public final void setCount(int count, @NotNull List<Integer> durations) {
        Unit unit;
        Intrinsics.checkNotNullParameter(durations, "durations");
        StoryIndicatorStyle style = this.model.getViewInfo().getStyle();
        if (style instanceof StoryIndicatorStyle.LinearProgress) {
            StoryIndicatorStyle.LinearProgress linearProgress = (StoryIndicatorStyle.LinearProgress) style;
            int iDpToPx = (int) ResourceUtils.dpToPx(getContext(), linearProgress.getSpacing() / 2);
            int i = 0;
            while (i < count) {
                LinearProgressIndicator linearProgressIndicator = new LinearProgressIndicator(getContext());
                linearProgressIndicator.setId(this.model.getIndicatorViewId(i));
                linearProgressIndicator.setMax(100);
                linearProgressIndicator.setIndicatorColor(linearProgress.getProgressColor().resolve(linearProgressIndicator.getContext()));
                linearProgressIndicator.setTrackColor(linearProgress.getTrackColor().resolve(linearProgressIndicator.getContext()));
                linearProgressIndicator.setIndicatorDirection(2);
                linearProgressIndicator.setIndeterminate(false);
                linearProgressIndicator.setFocusable(false);
                linearProgressIndicator.setFocusableInTouchMode(false);
                linearProgressIndicator.setImportantForAccessibility(2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.setMarginStart(i == 0 ? 0 : iDpToPx);
                layoutParams.setMarginEnd(i == count + (-1) ? 0 : iDpToPx);
                StoryIndicatorStyle.LinearProgress.SizingType sizing = linearProgress.getSizing();
                int i2 = sizing == null ? -1 : WhenMappings.$EnumSwitchMapping$0[sizing.ordinal()];
                if (i2 == -1 || i2 == 1) {
                    layoutParams.weight = 1.0f;
                } else if (i2 == 2) {
                    if (durations.get(i) != null) {
                        layoutParams.weight = r7.intValue();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        linearProgressIndicator.setVisibility(8);
                    }
                }
                addView(linearProgressIndicator, layoutParams);
                this.progressIndicators.add(linearProgressIndicator);
                i++;
            }
        }
    }

    public final void setProgress(int count, int pageIndex, int progress, boolean animated, boolean announcePage) {
        if (this.progressIndicators.isEmpty() || this.progressIndicators.size() <= pageIndex) {
            return;
        }
        int height = getHeight();
        for (int i = 0; i < count; i++) {
            Object obj = this.progressIndicators.get(i);
            LinearProgressIndicator linearProgressIndicator = obj instanceof LinearProgressIndicator ? (LinearProgressIndicator) obj : null;
            if (linearProgressIndicator != null) {
                if (i == pageIndex) {
                    if (this.model.getViewInfo().getSource() == StoryIndicatorSource.CURRENT_PAGE) {
                        linearProgressIndicator.setVisibility(0);
                    }
                    linearProgressIndicator.setTrackThickness(height);
                    linearProgressIndicator.setProgressCompat(progress, animated);
                } else {
                    if (this.model.getViewInfo().getSource() == StoryIndicatorSource.CURRENT_PAGE) {
                        linearProgressIndicator.setVisibility(8);
                    }
                    if (i > pageIndex) {
                        linearProgressIndicator.setTrackThickness((int) (height * 0.5d));
                        linearProgressIndicator.setProgressCompat(0, false);
                    } else {
                        linearProgressIndicator.setTrackThickness((int) (height * 0.5d));
                        linearProgressIndicator.setProgressCompat(100, false);
                    }
                }
            }
        }
        if (announcePage) {
            StringBuilder sb = new StringBuilder();
            sb.append("Page ");
            int i2 = pageIndex + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(count);
            String strNamedStringResource = UAStringUtil.namedStringResource(getContext(), "ua_pager_progress", sb.toString());
            Intrinsics.checkNotNullExpressionValue(strNamedStringResource, "namedStringResource(...)");
            String str = String.format(strNamedStringResource, Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(count)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            setContentDescription(str);
            announceForAccessibility(str);
        }
    }
}
