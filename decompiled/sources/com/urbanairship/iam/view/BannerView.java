package com.urbanairship.iam.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.dlp.BluetoothManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.util.Timer;
import com.urbanairship.automation.R;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.content.Banner;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.info.InAppMessageButtonLayoutType;
import com.urbanairship.iam.view.BackgroundDrawableBuilder;
import com.urbanairship.iam.view.BannerDismissLayout;
import com.urbanairship.iam.view.BannerView;
import com.urbanairship.iam.view.InAppButtonLayout;
import com.urbanairship.json.JsonMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0010\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002?@B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0015\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0010H\u0001¢\u0006\u0002\b&J\b\u0010'\u001a\u00020 H\u0014J\u0018\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0005J\u0010\u00101\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0018\u00102\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\rH\u0016J\r\u00104\u001a\u00020 H\u0001¢\u0006\u0002\b5J\r\u00106\u001a\u00020 H\u0001¢\u0006\u0002\b7J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\rH\u0014J\b\u0010:\u001a\u00020 H\u0003J\u001a\u0010;\u001a\u00020 2\b\b\u0001\u0010<\u001a\u00020\r2\b\b\u0001\u0010=\u001a\u00020\rJ\u0010\u0010>\u001a\u00020 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0012\u0010\f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\r8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\r8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006A"}, d2 = {"Lcom/urbanairship/iam/view/BannerView;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/iam/view/InAppButtonLayout$ButtonClickListener;", "Landroid/view/View$OnClickListener;", "Lcom/urbanairship/iam/view/BannerDismissLayout$Listener;", "context", "Landroid/content/Context;", "displayContent", "Lcom/urbanairship/iam/content/Banner;", "assets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "(Landroid/content/Context;Lcom/urbanairship/iam/content/Banner;Lcom/urbanairship/iam/assets/AirshipCachedAssets;)V", "animationIn", "", "animationOut", "applyLegacyWindowInsetFix", "", "contentLayout", "getContentLayout", "()I", "isDismissed", "isResumed", "layout", "getLayout", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/iam/view/BannerView$Listener;", "subView", "Landroid/view/View;", "timer", "Lcom/urbanairship/android/layout/util/Timer;", "getTimer$urbanairship_automation_release", "()Lcom/urbanairship/android/layout/util/Timer;", "", "view", "createBannerBackground", "Landroid/graphics/drawable/Drawable;", "dismiss", "animate", "dismiss$urbanairship_automation_release", "onAttachedToWindow", "onButtonClicked", "buttonInfo", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", ViewProps.ON_CLICK, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismissed", "onDragStateChanged", BluetoothManager.BLE_STATUS_PARAM, "onPause", "onPause$urbanairship_automation_release", "onResume", "onResume$urbanairship_automation_release", "onWindowVisibilityChanged", "visibility", "removeSelf", "setAnimations", "inAnimation", "outAnimation", "setListener", "Companion", "Listener", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BannerView extends FrameLayout implements InAppButtonLayout.ButtonClickListener, View.OnClickListener, BannerDismissLayout.Listener {
    private int animationIn;
    private int animationOut;
    private boolean applyLegacyWindowInsetFix;
    private final AirshipCachedAssets assets;
    private final Banner displayContent;
    private boolean isDismissed;
    private boolean isResumed;
    private Listener listener;
    private View subView;
    private final Timer timer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/view/BannerView$Listener;", "", "onBannerClicked", "", "view", "Lcom/urbanairship/iam/view/BannerView;", "onButtonClicked", "buttonInfo", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "onTimedOut", "onUserDismissed", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        @MainThread
        void onBannerClicked(@NotNull BannerView view);

        @MainThread
        void onButtonClicked(@NotNull BannerView view, @NotNull InAppMessageButtonInfo buttonInfo);

        @MainThread
        void onTimedOut(@NotNull BannerView view);

        @MainThread
        void onUserDismissed(@NotNull BannerView view);
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Banner.Placement.values().length];
            try {
                iArr[Banner.Placement.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Banner.Placement.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Banner.Template.values().length];
            try {
                iArr2[Banner.Template.MEDIA_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Banner.Template.MEDIA_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerView(@NotNull Context context, @NotNull Banner displayContent, @Nullable AirshipCachedAssets airshipCachedAssets) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
        this.displayContent = displayContent;
        this.assets = airshipCachedAssets;
        final long durationMs = displayContent.getDurationMs();
        this.timer = new Timer(durationMs) { // from class: com.urbanairship.iam.view.BannerView$timer$1
            @Override // com.urbanairship.android.layout.util.Timer
            protected void onFinish() throws Resources.NotFoundException {
                this.this$0.dismiss$urbanairship_automation_release(true);
                BannerView.Listener listener = this.this$0.listener;
                if (listener != null) {
                    listener.onTimedOut(this.this$0);
                }
            }
        };
    }

    @NotNull
    /* renamed from: getTimer$urbanairship_automation_release, reason: from getter */
    public final Timer getTimer() {
        return this.timer;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.requestApplyInsets(this);
    }

    @MainThread
    @NotNull
    protected final View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        View viewInflate = inflater.inflate(getLayout(), container, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.urbanairship.iam.view.BannerDismissLayout");
        BannerDismissLayout bannerDismissLayout = (BannerDismissLayout) viewInflate;
        bannerDismissLayout.setPlacement(this.displayContent.getPlacement());
        bannerDismissLayout.setListener(this);
        ViewStub viewStub = (ViewStub) bannerDismissLayout.findViewById(R.id.banner_content);
        viewStub.setLayoutResource(getContentLayout());
        viewStub.inflate();
        final LinearLayout linearLayout = (LinearLayout) bannerDismissLayout.findViewById(R.id.banner);
        ViewCompat.setBackground(linearLayout, createBannerBackground());
        if (this.displayContent.getBorderRadius() > BitmapDescriptorFactory.HUE_RED) {
            BorderRadius borderRadius = BorderRadius.INSTANCE;
            Intrinsics.checkNotNull(linearLayout);
            borderRadius.applyBorderRadiusPadding(linearLayout, this.displayContent.getBorderRadius(), BannerViewKt.toBorderRadius(this.displayContent.getPlacement()));
        }
        linearLayout.postDelayed(new Runnable() { // from class: com.urbanairship.iam.view.BannerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                linearLayout.performAccessibilityAction(64, null);
            }
        }, 300L);
        JsonMap actions = this.displayContent.getActions();
        if (actions != null && actions.isNotEmpty()) {
            linearLayout.setClickable(true);
            InstrumentationCallbacks.setOnClickListenerCalled(linearLayout, this);
        }
        TextView textView = (TextView) bannerDismissLayout.findViewById(R.id.heading);
        if (this.displayContent.getHeading() != null) {
            InAppViewUtils inAppViewUtils = InAppViewUtils.INSTANCE;
            Intrinsics.checkNotNull(textView);
            inAppViewUtils.applyTextInfo(textView, this.displayContent.getHeading());
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) bannerDismissLayout.findViewById(R.id.body);
        if (this.displayContent.getBody() != null) {
            InAppViewUtils inAppViewUtils2 = InAppViewUtils.INSTANCE;
            Intrinsics.checkNotNull(textView2);
            inAppViewUtils2.applyTextInfo(textView2, this.displayContent.getBody());
        } else {
            textView2.setVisibility(8);
        }
        MediaView mediaView = (MediaView) bannerDismissLayout.findViewById(R.id.media);
        if (this.displayContent.getMedia() != null) {
            InAppViewUtils inAppViewUtils3 = InAppViewUtils.INSTANCE;
            Intrinsics.checkNotNull(mediaView);
            inAppViewUtils3.loadMediaInfo(mediaView, this.displayContent.getMedia(), this.assets);
        } else {
            mediaView.setVisibility(8);
        }
        InAppButtonLayout inAppButtonLayout = (InAppButtonLayout) bannerDismissLayout.findViewById(R.id.buttons);
        if (this.displayContent.getButtons() != null && (!r0.isEmpty())) {
            InAppMessageButtonLayoutType buttonLayoutType = this.displayContent.getButtonLayoutType();
            List<InAppMessageButtonInfo> buttons = this.displayContent.getButtons();
            if (buttons == null) {
                buttons = CollectionsKt.emptyList();
            }
            inAppButtonLayout.setButtons(buttonLayoutType, buttons);
            inAppButtonLayout.setButtonClickListener(this);
        } else {
            inAppButtonLayout.setVisibility(8);
        }
        View viewFindViewById = bannerDismissLayout.findViewById(R.id.banner_pull);
        Drawable drawableMutate = DrawableCompat.wrap(viewFindViewById.getBackground()).mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        DrawableCompat.setTint(drawableMutate, this.displayContent.getDismissButtonColor().getColor());
        ViewCompat.setBackground(viewFindViewById, drawableMutate);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.iam.view.BannerView$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return BannerView.onCreateView$lambda$1(this.f$0, view, windowInsetsCompat);
            }
        });
        return bannerDismissLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreateView$lambda$1(BannerView this$0, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int childCount = this$0.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.dispatchApplyWindowInsets(this$0.getChildAt(i), new WindowInsetsCompat(insets));
        }
        return insets;
    }

    @CallSuper
    @MainThread
    public final void onResume$urbanairship_automation_release() {
        this.isResumed = true;
        if (this.isDismissed) {
            return;
        }
        this.timer.start();
    }

    @CallSuper
    @MainThread
    public final void onPause$urbanairship_automation_release() {
        this.isResumed = false;
        this.timer.stop();
    }

    @MainThread
    public final void dismiss$urbanairship_automation_release(boolean animate) throws Resources.NotFoundException {
        this.isDismissed = true;
        this.timer.stop();
        if (animate && this.subView != null && this.animationOut != 0) {
            clearAnimation();
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), this.animationOut);
            animatorLoadAnimator.setTarget(this.subView);
            animatorLoadAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.urbanairship.iam.view.BannerView$dismiss$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.removeSelf();
                }
            });
            animatorLoadAnimator.start();
            return;
        }
        removeSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSelf() {
        announceForAccessibility(getContext().getString(com.urbanairship.R.string.ua_in_app_dismiss_accessibility_announce));
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(this);
        this.subView = null;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) throws Resources.NotFoundException {
        if (this.subView == null && visibility == 0 && !this.isDismissed) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
            Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(...)");
            View viewOnCreateView = onCreateView(layoutInflaterFrom, this);
            announceForAccessibility(getContext().getString(com.urbanairship.R.string.ua_in_app_display_accessibility_announce));
            if (this.applyLegacyWindowInsetFix) {
                applyLegacyWindowInsetFix(viewOnCreateView);
            }
            addView(viewOnCreateView);
            if (this.animationIn != 0) {
                Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), this.animationIn);
                animatorLoadAnimator.setTarget(viewOnCreateView);
                animatorLoadAnimator.start();
            }
            this.subView = viewOnCreateView;
            onResume$urbanairship_automation_release();
        }
    }

    public final void setAnimations(@AnimatorRes int inAnimation, @AnimatorRes int outAnimation) {
        this.animationIn = inAnimation;
        this.animationOut = outAnimation;
    }

    @Override // com.urbanairship.iam.view.InAppButtonLayout.ButtonClickListener
    public void onButtonClicked(@NotNull View view, @NotNull InAppMessageButtonInfo buttonInfo) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        Listener listener = this.listener;
        if (listener != null) {
            listener.onButtonClicked(this, buttonInfo);
        }
        dismiss$urbanairship_automation_release(true);
    }

    @Override // com.urbanairship.iam.view.BannerDismissLayout.Listener
    public void onDismissed(@NotNull View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        Listener listener = this.listener;
        if (listener != null) {
            listener.onUserDismissed(this);
        }
        dismiss$urbanairship_automation_release(false);
    }

    @Override // com.urbanairship.iam.view.BannerDismissLayout.Listener
    public void onDragStateChanged(@NotNull View view, int state) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (state != 0) {
            if (state != 1) {
                return;
            }
            this.timer.stop();
        } else if (this.isResumed) {
            this.timer.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        Listener listener = this.listener;
        if (listener != null) {
            listener.onBannerClicked(this);
        }
        dismiss$urbanairship_automation_release(true);
    }

    @LayoutRes
    private final int getLayout() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.displayContent.getPlacement().ordinal()];
        if (i == 1) {
            return R.layout.ua_iam_banner_top;
        }
        if (i == 2) {
            return R.layout.ua_iam_banner_bottom;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Drawable createBannerBackground() {
        int alphaComponent = ColorUtils.setAlphaComponent(this.displayContent.getDismissButtonColor().getColor(), MathKt.roundToInt(Color.alpha(this.displayContent.getDismissButtonColor().getColor()) * 0.2f));
        BackgroundDrawableBuilder.Companion companion = BackgroundDrawableBuilder.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return companion.newBuilder(context).setBackgroundColor(this.displayContent.getBackgroundColor().getColor()).setPressedColor(alphaComponent).setBorderRadius(this.displayContent.getBorderRadius(), BannerViewKt.toBorderRadius(this.displayContent.getPlacement())).build();
    }

    @LayoutRes
    private final int getContentLayout() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.displayContent.getTemplate().ordinal()];
        if (i == 1) {
            return R.layout.ua_iam_banner_content_right_media;
        }
        if (i == 2) {
            return R.layout.ua_iam_banner_content_left_media;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void applyLegacyWindowInsetFix(View view) {
        int identifier;
        int identifier2;
        view.setFitsSystemWindows(false);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowTranslucentNavigation, android.R.attr.windowTranslucentStatus});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setPaddingRelative(view, 0, (!z2 || (identifier2 = getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) ? 0 : getResources().getDimensionPixelSize(identifier2), 0, (!z || (identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) ? 0 : getResources().getDimensionPixelSize(identifier));
    }
}
