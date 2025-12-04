package com.urbanairship.iam.adapter.modal;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.ActionRunnerKt;
import com.urbanairship.automation.R;
import com.urbanairship.iam.InAppMessageActivity;
import com.urbanairship.iam.adapter.InAppMessageDisplayListener;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.iam.content.Modal;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.info.InAppMessageTextInfo;
import com.urbanairship.iam.view.BackgroundDrawableBuilder;
import com.urbanairship.iam.view.BoundedLinearLayout;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/iam/adapter/modal/ModalActivity;", "Lcom/urbanairship/iam/InAppMessageActivity;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$ModalContent;", "Lcom/urbanairship/iam/view/InAppButtonLayout$ButtonClickListener;", "()V", "mediaView", "Lcom/urbanairship/iam/view/MediaView;", "getTemplate", "", "template", "Lcom/urbanairship/iam/content/Modal$Template;", "normalizeHorizontalPadding", "", "view", "Landroid/widget/TextView;", "normalizeTemplate", "modal", "Lcom/urbanairship/iam/content/Modal;", "onButtonClicked", "Landroid/view/View;", "buttonInfo", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "onCreateMessage", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModalActivity extends InAppMessageActivity<InAppMessageDisplayContent.ModalContent> implements InAppButtonLayout.ButtonClickListener {
    private MediaView mediaView;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Modal.Template.values().length];
            try {
                iArr[Modal.Template.HEADER_BODY_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Modal.Template.HEADER_MEDIA_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Modal.Template.MEDIA_HEADER_BODY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.urbanairship.iam.InAppMessageActivity
    protected void onCreateMessage(@Nullable Bundle savedInstanceState) throws Resources.NotFoundException {
        float borderRadius;
        InAppMessageDisplayContent.ModalContent displayContent = getDisplayContent();
        final Modal modal = displayContent != null ? displayContent.getModal() : null;
        if (modal == null) {
            finish();
            return;
        }
        boolean allowFullscreenDisplay = modal.getAllowFullscreenDisplay();
        if (getResources().getBoolean(R.bool.ua_iam_modal_allow_fullscreen_display) && allowFullscreenDisplay) {
            setTheme(R.style.UrbanAirship_InAppModal_Activity_Fullscreen);
            setContentView(R.layout.ua_iam_modal_fullscreen);
            borderRadius = 0.0f;
        } else {
            setContentView(R.layout.ua_iam_modal);
            borderRadius = modal.getBorderRadius();
        }
        Modal.Template templateNormalizeTemplate = normalizeTemplate(modal);
        ViewStub viewStub = (ViewStub) findViewById(R.id.modal_content);
        if (viewStub == null) {
            finish();
            return;
        }
        viewStub.setLayoutResource(getTemplate(templateNormalizeTemplate));
        viewStub.inflate();
        BoundedLinearLayout boundedLinearLayout = (BoundedLinearLayout) findViewById(R.id.modal);
        TextView textView = (TextView) findViewById(R.id.heading);
        TextView textView2 = (TextView) findViewById(R.id.body);
        InAppButtonLayout inAppButtonLayout = (InAppButtonLayout) findViewById(R.id.buttons);
        Button button = (Button) findViewById(R.id.footer);
        ImageButton imageButton = (ImageButton) findViewById(R.id.dismiss);
        this.mediaView = (MediaView) findViewById(R.id.media);
        if (modal.getHeading() != null) {
            InAppViewUtils inAppViewUtils = InAppViewUtils.INSTANCE;
            Intrinsics.checkNotNull(textView);
            inAppViewUtils.applyTextInfo(textView, modal.getHeading());
            if (modal.getHeading().getAlignment() == InAppMessageTextInfo.Alignment.CENTER) {
                normalizeHorizontalPadding(textView);
            }
        } else {
            textView.setVisibility(8);
        }
        if (modal.getBody() != null) {
            InAppViewUtils inAppViewUtils2 = InAppViewUtils.INSTANCE;
            Intrinsics.checkNotNull(textView2);
            inAppViewUtils2.applyTextInfo(textView2, modal.getBody());
        } else {
            textView2.setVisibility(8);
        }
        if (modal.getMedia() != null) {
            MediaView mediaView = this.mediaView;
            if (mediaView != null) {
                mediaView.setChromeClient(new AirshipWebChromeClient(this));
                InAppViewUtils.INSTANCE.loadMediaInfo(mediaView, modal.getMedia(), getAssets());
            }
        } else {
            MediaView mediaView2 = this.mediaView;
            if (mediaView2 != null) {
                mediaView2.setVisibility(8);
            }
        }
        if (!modal.getButtons().isEmpty()) {
            inAppButtonLayout.setButtons(modal.getButtonLayoutType(), modal.getButtons());
            inAppButtonLayout.setButtonClickListener(this);
        } else {
            inAppButtonLayout.setVisibility(8);
        }
        if (modal.getFooter() != null) {
            InAppViewUtils inAppViewUtils3 = InAppViewUtils.INSTANCE;
            Intrinsics.checkNotNull(button);
            inAppViewUtils3.applyButtonInfo(button, modal.getFooter(), 0);
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.urbanairship.iam.adapter.modal.ModalActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ModalActivity.onCreateMessage$lambda$1(this.f$0, modal, view);
                }
            });
        } else {
            button.setVisibility(8);
        }
        ViewCompat.setBackground(boundedLinearLayout, BackgroundDrawableBuilder.INSTANCE.newBuilder(this).setBackgroundColor(modal.getBackgroundColor().getColor()).setBorderRadius(borderRadius, 15).build());
        if (borderRadius > BitmapDescriptorFactory.HUE_RED) {
            boundedLinearLayout.setClipPathBorderRadius(borderRadius);
        }
        Drawable drawableMutate = DrawableCompat.wrap(imageButton.getDrawable()).mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        DrawableCompat.setTint(drawableMutate, modal.getDismissButtonColor().getColor());
        imageButton.setImageDrawable(drawableMutate);
        InstrumentationCallbacks.setOnClickListenerCalled(imageButton, new View.OnClickListener() { // from class: com.urbanairship.iam.adapter.modal.ModalActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModalActivity.onCreateMessage$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateMessage$lambda$1(ModalActivity this$0, Modal modal, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(view);
        this$0.onButtonClicked(view, modal.getFooter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateMessage$lambda$2(ModalActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InAppMessageDisplayListener displayListener = this$0.getDisplayListener();
        if (displayListener != null) {
            displayListener.onUserDismissed();
        }
        this$0.finish();
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

    private final int getTemplate(Modal.Template template) {
        int i = WhenMappings.$EnumSwitchMapping$0[template.ordinal()];
        if (i == 1) {
            return R.layout.ua_iam_modal_header_body_media;
        }
        if (i == 2) {
            return R.layout.ua_iam_modal_header_media_body;
        }
        if (i == 3) {
            return R.layout.ua_iam_modal_media_header_body;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Modal.Template normalizeTemplate(Modal modal) {
        if (modal.getMedia() == null) {
            return Modal.Template.HEADER_BODY_MEDIA;
        }
        if (modal.getTemplate() == Modal.Template.HEADER_MEDIA_BODY && modal.getHeading() == null) {
            return Modal.Template.MEDIA_HEADER_BODY;
        }
        return modal.getTemplate();
    }

    private final void normalizeHorizontalPadding(TextView view) {
        int iMax = Math.max(ViewCompat.getPaddingEnd(view), ViewCompat.getPaddingStart(view));
        view.setPadding(iMax, view.getPaddingTop(), iMax, view.getPaddingBottom());
        view.requestLayout();
    }
}
