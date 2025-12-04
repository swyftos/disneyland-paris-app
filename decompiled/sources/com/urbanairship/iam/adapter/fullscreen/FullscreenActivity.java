package com.urbanairship.iam.adapter.fullscreen;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.reactcommunity.rndatetimepicker.RNConstants;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.ActionRunnerKt;
import com.urbanairship.automation.R;
import com.urbanairship.iam.InAppMessageActivity;
import com.urbanairship.iam.adapter.InAppMessageDisplayListener;
import com.urbanairship.iam.content.Fullscreen;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.info.InAppMessageTextInfo;
import com.urbanairship.iam.view.InAppButtonLayout;
import com.urbanairship.iam.view.InAppViewUtils;
import com.urbanairship.iam.view.MediaView;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.webkit.AirshipWebChromeClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\rH\u0014J\b\u0010\u001b\u001a\u00020\rH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/iam/adapter/fullscreen/FullscreenActivity;", "Lcom/urbanairship/iam/InAppMessageActivity;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$FullscreenContent;", "Lcom/urbanairship/iam/view/InAppButtonLayout$ButtonClickListener;", "()V", "mediaView", "Lcom/urbanairship/iam/view/MediaView;", "getTemplate", "", "template", "Lcom/urbanairship/iam/content/Fullscreen$Template;", "getTemplate$urbanairship_automation_release", "normalizeHorizontalPadding", "", "view", "Landroid/widget/TextView;", "normalizeTemplate", RNConstants.ARG_FULLSCREEN, "Lcom/urbanairship/iam/content/Fullscreen;", "onButtonClicked", "Landroid/view/View;", "buttonInfo", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "onCreateMessage", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FullscreenActivity extends InAppMessageActivity<InAppMessageDisplayContent.FullscreenContent> implements InAppButtonLayout.ButtonClickListener {
    private MediaView mediaView;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Fullscreen.Template.values().length];
            try {
                iArr[Fullscreen.Template.HEADER_BODY_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Fullscreen.Template.HEADER_MEDIA_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Fullscreen.Template.MEDIA_HEADER_BODY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.urbanairship.iam.InAppMessageActivity
    protected void onCreateMessage(@Nullable Bundle savedInstanceState) throws Resources.NotFoundException {
        InAppMessageDisplayContent.FullscreenContent displayContent = getDisplayContent();
        final Fullscreen fullscreen = displayContent != null ? displayContent.getFullscreen() : null;
        if (fullscreen == null) {
            finish();
            return;
        }
        setContentView(getTemplate$urbanairship_automation_release(normalizeTemplate(fullscreen)));
        hideActionBar();
        View viewFindViewById = findViewById(R.id.heading);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.body);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        TextView textView2 = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.buttons);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        InAppButtonLayout inAppButtonLayout = (InAppButtonLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.footer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        Button button = (Button) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.dismiss);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ImageButton imageButton = (ImageButton) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.content_holder);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.mediaView = (MediaView) findViewById(R.id.media);
        if (fullscreen.getHeading() != null) {
            InAppViewUtils.INSTANCE.applyTextInfo(textView, fullscreen.getHeading());
            if (fullscreen.getHeading().getAlignment() == InAppMessageTextInfo.Alignment.CENTER) {
                normalizeHorizontalPadding(textView);
            }
        } else {
            textView.setVisibility(8);
        }
        if (fullscreen.getBody() != null) {
            InAppViewUtils.INSTANCE.applyTextInfo(textView2, fullscreen.getBody());
        } else {
            textView2.setVisibility(8);
        }
        MediaView mediaView = this.mediaView;
        if (mediaView != null) {
            if (fullscreen.getMedia() != null) {
                mediaView.setChromeClient(new AirshipWebChromeClient(this));
                InAppViewUtils.INSTANCE.loadMediaInfo(mediaView, fullscreen.getMedia(), getAssets());
            } else {
                mediaView.setVisibility(8);
            }
        }
        if (!fullscreen.getButtons().isEmpty()) {
            inAppButtonLayout.setButtons(fullscreen.getButtonLayoutType(), fullscreen.getButtons());
            inAppButtonLayout.setButtonClickListener(this);
        } else {
            inAppButtonLayout.setVisibility(8);
        }
        if (fullscreen.getFooter() != null) {
            InAppViewUtils.INSTANCE.applyButtonInfo(button, fullscreen.getFooter(), 0);
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.urbanairship.iam.adapter.fullscreen.FullscreenActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FullscreenActivity.onCreateMessage$lambda$1(this.f$0, fullscreen, view);
                }
            });
        } else {
            button.setVisibility(8);
        }
        Drawable drawableMutate = DrawableCompat.wrap(imageButton.getDrawable()).mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        DrawableCompat.setTint(drawableMutate, fullscreen.getDismissButtonColor().getColor());
        imageButton.setImageDrawable(drawableMutate);
        InstrumentationCallbacks.setOnClickListenerCalled(imageButton, new View.OnClickListener() { // from class: com.urbanairship.iam.adapter.fullscreen.FullscreenActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullscreenActivity.onCreateMessage$lambda$2(this.f$0, view);
            }
        });
        getWindow().getDecorView().setBackgroundColor(fullscreen.getBackgroundColor().getColor());
        if (ViewCompat.getFitsSystemWindows(viewFindViewById6)) {
            ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById6, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.iam.adapter.fullscreen.FullscreenActivity$$ExternalSyntheticLambda2
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return FullscreenActivity.onCreateMessage$lambda$3(view, windowInsetsCompat);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateMessage$lambda$1(FullscreenActivity this$0, Fullscreen fullscreen, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view);
        this$0.onButtonClicked(view, fullscreen.getFooter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateMessage$lambda$2(FullscreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InAppMessageDisplayListener displayListener = this$0.getDisplayListener();
        if (displayListener != null) {
            displayListener.onUserDismissed();
        }
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreateMessage$lambda$3(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        ViewCompat.onApplyWindowInsets(v, insets);
        return insets;
    }

    @Override // com.urbanairship.iam.view.InAppButtonLayout.ButtonClickListener
    public void onButtonClicked(@NotNull View view, @NotNull InAppMessageButtonInfo buttonInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        JsonMap actions = buttonInfo.getActions();
        if (actions != null) {
            ActionRunner actionRunner = getArgs().getActionRunner();
            Map<String, JsonValue> map = actions.getMap();
            Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
            ActionRunnerKt.run$default(actionRunner, map, null, null, 6, null);
        }
        InAppMessageDisplayListener displayListener = getDisplayListener();
        if (displayListener != null) {
            displayListener.onButtonDismissed(buttonInfo);
        }
        finish();
    }

    @Override // com.urbanairship.iam.InAppMessageActivity, com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MediaView mediaView = this.mediaView;
        if (mediaView != null) {
            mediaView.onResume();
        }
    }

    @Override // com.urbanairship.iam.InAppMessageActivity, com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MediaView mediaView = this.mediaView;
        if (mediaView != null) {
            mediaView.onPause();
        }
    }

    @LayoutRes
    public final int getTemplate$urbanairship_automation_release(@NotNull Fullscreen.Template template) {
        Intrinsics.checkNotNullParameter(template, "template");
        int i = WhenMappings.$EnumSwitchMapping$0[template.ordinal()];
        if (i == 1) {
            return R.layout.ua_iam_fullscreen_header_body_media;
        }
        if (i == 2) {
            return R.layout.ua_iam_fullscreen_header_media_body;
        }
        if (i == 3) {
            return R.layout.ua_iam_fullscreen_media_header_body;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Fullscreen.Template normalizeTemplate(Fullscreen fullscreen) {
        if (fullscreen.getMedia() == null) {
            return Fullscreen.Template.HEADER_BODY_MEDIA;
        }
        if (WhenMappings.$EnumSwitchMapping$0[fullscreen.getTemplate().ordinal()] == 2) {
            if (fullscreen.getHeading() == null) {
                return Fullscreen.Template.MEDIA_HEADER_BODY;
            }
            return fullscreen.getTemplate();
        }
        return fullscreen.getTemplate();
    }

    private final void normalizeHorizontalPadding(TextView view) {
        int iMax = Math.max(ViewCompat.getPaddingEnd(view), ViewCompat.getPaddingStart(view));
        view.setPadding(iMax, view.getPaddingTop(), iMax, view.getPaddingBottom());
        view.requestLayout();
    }
}
