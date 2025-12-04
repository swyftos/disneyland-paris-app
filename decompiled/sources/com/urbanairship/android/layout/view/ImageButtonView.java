package com.urbanairship.android.layout.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UAirship;
import com.urbanairship.android.layout.R;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.ImageButtonInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.ButtonModel;
import com.urbanairship.android.layout.model.ImageButtonModel;
import com.urbanairship.android.layout.model.ItemProperties;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.property.MediaFit;
import com.urbanairship.android.layout.property.TapEffect;
import com.urbanairship.android.layout.util.CachedImage;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.util.ThomasImageSizeResolver;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.view.BaseView;
import com.urbanairship.android.layout.widget.CropImageButton;
import com.urbanairship.android.layout.widget.TappableView;
import com.urbanairship.images.ImageLoader;
import com.urbanairship.images.ImageRequestOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160%H\u0016R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/urbanairship/android/layout/view/ImageButtonView;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/ImageButtonModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/ImageButtonModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;Lcom/urbanairship/android/layout/model/ItemProperties;)V", "button", "Lcom/urbanairship/android/layout/widget/CropImageButton;", "getButton", "()Lcom/urbanairship/android/layout/widget/CropImageButton;", "button$delegate", "Lkotlin/Lazy;", "visibilityChangeListener", "Lcom/urbanairship/android/layout/view/BaseView$VisibilityChangeListener;", "applyIconRippleEffect", "", "view", "Landroid/widget/ImageButton;", "tapEffect", "Lcom/urbanairship/android/layout/property/TapEffect;", "applyImageRippleEffect", "radii", "", "makeImageButton", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "taps", "Lkotlinx/coroutines/flow/Flow;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageButtonView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageButtonView.kt\ncom/urbanairship/android/layout/view/ImageButtonView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,170:1\n93#2,13:171\n*S KotlinDebug\n*F\n+ 1 ImageButtonView.kt\ncom/urbanairship/android/layout/view/ImageButtonView\n*L\n51#1:171,13\n*E\n"})
/* loaded from: classes5.dex */
public final class ImageButtonView extends FrameLayout implements BaseView, TappableView {

    /* renamed from: button$delegate, reason: from kotlin metadata */
    private final Lazy button;
    private final ItemProperties itemProperties;
    private BaseView.VisibilityChangeListener visibilityChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageButtonView(@NotNull final Context context, @NotNull final ImageButtonModel model, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        CachedImage cachedImage;
        String url;
        ImageView.ScaleType scaleType;
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.itemProperties = itemProperties;
        this.button = LazyKt.lazy(new Function0() { // from class: com.urbanairship.android.layout.view.ImageButtonView$button$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CropImageButton invoke() {
                return this.this$0.makeImageButton(model);
            }
        });
        final Image image = ((ImageButtonInfo) model.getViewInfo()).getImage();
        if (image instanceof Image.Url) {
            ImageCache imageCache = viewEnvironment.imageCache();
            if (imageCache != null) {
                String url2 = ((Image.Url) image).getUrl();
                Intrinsics.checkNotNullExpressionValue(url2, "getUrl(...)");
                cachedImage = imageCache.get(url2);
            } else {
                cachedImage = null;
            }
            if (cachedImage == null || (url = cachedImage.getPath()) == null) {
                url = ((Image.Url) image).getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            }
            final String str = url;
            if (isAttachedToWindow()) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Image.Url url3 = (Image.Url) image;
                if (url3.getMediaFit() == MediaFit.FIT_CROP) {
                    getButton().setParentLayoutParams(layoutParams);
                    getButton().setImagePosition(url3.getPosition());
                } else {
                    CropImageButton button = getButton();
                    MediaFit mediaFit = url3.getMediaFit();
                    button.setScaleType((mediaFit == null || (scaleType = mediaFit.getScaleType()) == null) ? ImageView.ScaleType.FIT_CENTER : scaleType);
                }
                CropImageButton button2 = getButton();
                TapEffect tapEffect = ((ImageButtonInfo) model.getViewInfo()).getTapEffect();
                Border border = ((ImageButtonInfo) model.getViewInfo()).getBorder();
                applyImageRippleEffect(button2, tapEffect, border != null ? border.radii(new ImageButtonView$1$1(context)) : null);
                addView(getButton());
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                lambda$0$loadImage(context, this, cachedImage, booleanRef, str);
                this.visibilityChangeListener = new ImageButtonView$1$2(booleanRef, str, context, this, cachedImage);
            } else {
                final CachedImage cachedImage2 = cachedImage;
                addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.urbanairship.android.layout.view.ImageButtonView$special$$inlined$doOnAttach$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(@NotNull View view) {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NotNull View view) {
                        ImageView.ScaleType scaleType2;
                        this.removeOnAttachStateChangeListener(this);
                        ViewGroup.LayoutParams layoutParams2 = this.getLayoutParams();
                        if (((Image.Url) image).getMediaFit() == MediaFit.FIT_CROP) {
                            this.getButton().setParentLayoutParams(layoutParams2);
                            this.getButton().setImagePosition(((Image.Url) image).getPosition());
                        } else {
                            CropImageButton button3 = this.getButton();
                            MediaFit mediaFit2 = ((Image.Url) image).getMediaFit();
                            if (mediaFit2 == null || (scaleType2 = mediaFit2.getScaleType()) == null) {
                                scaleType2 = ImageView.ScaleType.FIT_CENTER;
                            }
                            button3.setScaleType(scaleType2);
                        }
                        ImageButtonView imageButtonView = this;
                        CropImageButton button4 = imageButtonView.getButton();
                        TapEffect tapEffect2 = ((ImageButtonInfo) model.getViewInfo()).getTapEffect();
                        Border border2 = ((ImageButtonInfo) model.getViewInfo()).getBorder();
                        imageButtonView.applyImageRippleEffect(button4, tapEffect2, border2 != null ? border2.radii(new ImageButtonView$1$1(context)) : null);
                        ImageButtonView imageButtonView2 = this;
                        imageButtonView2.addView(imageButtonView2.getButton());
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        ImageButtonView.lambda$0$loadImage(context, this, cachedImage2, booleanRef2, str);
                        ImageButtonView imageButtonView3 = this;
                        imageButtonView3.visibilityChangeListener = new ImageButtonView$1$2(booleanRef2, str, context, imageButtonView3, cachedImage2);
                    }
                });
            }
        } else if (image instanceof Image.Icon) {
            CropImageButton button3 = getButton();
            button3.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Image.Icon icon = (Image.Icon) image;
            button3.setImageDrawable(icon.getDrawable(context, button3.isEnabled()));
            button3.setImageTintList(LayoutUtils.pressedColorStateList(icon.getTint().resolve(context)));
            applyIconRippleEffect(getButton(), ((ImageButtonInfo) model.getViewInfo()).getTapEffect());
            addView(getButton());
        }
        final Drawable background = getBackground();
        model.setListener$urbanairship_layout_release(new ButtonModel.Listener() { // from class: com.urbanairship.android.layout.view.ImageButtonView.3
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                ImageButtonView.this.getButton().setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                ImageButtonView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.ButtonModel.Listener
            public void dismissSoftKeyboard() {
                LayoutUtils.dismissSoftKeyboard(ImageButtonView.this);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background2) {
                Intrinsics.checkNotNullParameter(background2, "new");
                LayoutUtils.updateBackground(ImageButtonView.this, background, old, background2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CropImageButton getButton() {
        return (CropImageButton) this.button.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$0$loadImage(Context context, ImageButtonView imageButtonView, CachedImage cachedImage, final Ref.BooleanRef booleanRef, String str) {
        ImageLoader imageLoader = UAirship.shared().getImageLoader();
        CropImageButton button = imageButtonView.getButton();
        ImageRequestOptions.Builder builderNewBuilder = ImageRequestOptions.newBuilder(str);
        ItemProperties itemProperties = imageButtonView.itemProperties;
        imageLoader.load(context, button, builderNewBuilder.setImageSizeResolver(new ThomasImageSizeResolver(itemProperties != null ? itemProperties.getSize() : null, cachedImage != null ? cachedImage.getSize() : null)).setImageLoadedCallback(new ImageLoader.ImageLoadedCallback() { // from class: com.urbanairship.android.layout.view.ImageButtonView$1$loadImage$1
            @Override // com.urbanairship.images.ImageLoader.ImageLoadedCallback
            public final void onImageLoaded(boolean z) {
                if (z) {
                    booleanRef.element = true;
                }
            }
        }).build());
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        return ViewExtensionsKt.debouncedClicks$default(getButton(), 0L, 1, null);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        BaseView.VisibilityChangeListener visibilityChangeListener = this.visibilityChangeListener;
        if (visibilityChangeListener != null) {
            visibilityChangeListener.onVisibilityChanged(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CropImageButton makeImageButton(ImageButtonModel model) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final CropImageButton cropImageButton = new CropImageButton(context, null, 0, 6, null);
        cropImageButton.setId(model.getButtonViewId());
        cropImageButton.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        cropImageButton.setAdjustViewBounds(true);
        cropImageButton.setPadding(0, 0, 0, 0);
        Context context2 = cropImageButton.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        String strContentDescription = model.contentDescription(context2);
        if (strContentDescription != null) {
            StringExtensionsKt.ifNotEmpty(strContentDescription, new Function1() { // from class: com.urbanairship.android.layout.view.ImageButtonView$makeImageButton$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cropImageButton.setContentDescription(it);
                }
            });
        }
        return cropImageButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyImageRippleEffect(ImageButton view, TapEffect tapEffect, float[] radii) {
        if (tapEffect instanceof TapEffect.Default) {
            LayoutUtils.applyImageButtonRippleAndTint(view, radii);
        } else if (tapEffect instanceof TapEffect.None) {
            view.setBackground(null);
        }
    }

    private final void applyIconRippleEffect(ImageButton view, TapEffect tapEffect) {
        Drawable drawable;
        if (tapEffect instanceof TapEffect.Default) {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.ua_layout_imagebutton_ripple);
        } else {
            if (!(tapEffect instanceof TapEffect.None)) {
                throw new NoWhenBranchMatchedException();
            }
            drawable = null;
        }
        view.setBackground(drawable);
    }
}
