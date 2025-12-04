package com.urbanairship.android.layout.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.ItemProperties;
import com.urbanairship.android.layout.model.MediaModel;
import com.urbanairship.android.layout.property.HorizontalPosition;
import com.urbanairship.android.layout.property.MediaFit;
import com.urbanairship.android.layout.property.MediaType;
import com.urbanairship.android.layout.property.VerticalPosition;
import com.urbanairship.android.layout.property.Video;
import com.urbanairship.android.layout.util.CachedImage;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.util.ThomasImageSizeResolver;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.view.BaseView;
import com.urbanairship.android.layout.widget.CropImageView;
import com.urbanairship.android.layout.widget.ShrinkableView;
import com.urbanairship.android.layout.widget.TappableView;
import com.urbanairship.android.layout.widget.TouchAwareWebView;
import com.urbanairship.app.FilteredActivityListener;
import com.urbanairship.app.SimpleActivityListener;
import com.urbanairship.images.ImageLoader;
import com.urbanairship.images.ImageRequestOptions;
import com.urbanairship.util.ManifestUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000f\b\u0000\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004+,-.B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\bH\u0003J\b\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0014J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020 0*H\u0016R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\u00020\u001c*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/urbanairship/android/layout/view/MediaView;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "Lcom/urbanairship/android/layout/widget/ShrinkableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/MediaModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/MediaModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;Lcom/urbanairship/android/layout/model/ItemProperties;)V", "activityListener", "com/urbanairship/android/layout/view/MediaView$activityListener$1", "Lcom/urbanairship/android/layout/view/MediaView$activityListener$1;", "filteredActivityListener", "Lcom/urbanairship/app/FilteredActivityListener;", "imageView", "Lcom/urbanairship/android/layout/widget/CropImageView;", "newBackground", "Lcom/urbanairship/android/layout/model/Background;", "visibilityChangeListener", "Lcom/urbanairship/android/layout/view/BaseView$VisibilityChangeListener;", "webView", "Lcom/urbanairship/android/layout/widget/TouchAwareWebView;", "videoStyle", "", "getVideoStyle", "(Lcom/urbanairship/android/layout/model/MediaModel;)Ljava/lang/String;", "configureImageView", "", "configureWebView", "isShrinkable", "", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "taps", "Lkotlinx/coroutines/flow/Flow;", "Companion", "FixedAspectRatioFrameLayout", "MediaWebViewClient", "WebViewListener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMediaView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaView.kt\ncom/urbanairship/android/layout/view/MediaView\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,674:1\n17#2:675\n19#2:679\n49#2,3:680\n46#3:676\n51#3:678\n105#4:677\n93#5,13:683\n93#5,13:696\n*S KotlinDebug\n*F\n+ 1 MediaView.kt\ncom/urbanairship/android/layout/view/MediaView\n*L\n157#1:675\n157#1:679\n157#1:680,3\n157#1:676\n157#1:678\n157#1:677\n186#1:683,13\n276#1:696,13\n*E\n"})
/* loaded from: classes5.dex */
public final class MediaView extends FrameLayout implements BaseView, TappableView, ShrinkableView {
    private final MediaView$activityListener$1 activityListener;
    private final FilteredActivityListener filteredActivityListener;
    private CropImageView imageView;
    private final ItemProperties itemProperties;
    private Background newBackground;
    private final ViewEnvironment viewEnvironment;
    private BaseView.VisibilityChangeListener visibilityChangeListener;
    private TouchAwareWebView webView;
    private static final String VIDEO_HTML_FORMAT = "<body style=\"margin:0\">\n    <video id=\"video\" playsinline %s %s %s %s height=\"100%%\" width=\"100%%\" src=\"%s\" style=\"%s\"></video>\n    <script>\n        let videoElement = document.getElementById(\"video\");\n\n        document.addEventListener(\"visibilitychange\", () => {\n          if (document.visibilityState === \"visible\") {\n            // Autoplaying code placeholder\n            %s\n          } else {\n            videoElement.pause();\n          }\n        });\n\n        videoElement.addEventListener(\"canplay\", (event) => {\n          VideoListenerInterface.onVideoReady();\n        });\n    </script>\n</body>";
    private static final String VIDEO_AUTO_PLAYING_JS_CODE = "videoElement.currentTime = 0;\nvideoElement.load();";
    private static final String IMAGE_HTML_FORMAT = "<body style=\"margin:0\">\n    <img height=\"100%%\" width=\"100%%\" src=\"%s\"/>\n</body>";
    private static final String YOUTUBE_HTML_FORMAT = "<body style=\"margin:0\">\n    <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->\n    <div id=\"player\"></div>\n\n    <script>\n      // 2. This code loads the IFrame Player API code asynchronously.\n      var tag = document.createElement('script');\n\n      tag.src = \"https://www.youtube.com/iframe_api\";\n      var firstScriptTag = document.getElementsByTagName('script')[0];\n      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\n\n      // 3. This function creates an <iframe> (and YouTube player)\n      //    after the API code downloads.\n      var player;\n      function onYouTubeIframeAPIReady() {\n        player = new YT.Player('player', {\n          height: '100%%',\n          width: '100%%',\n          videoId: '%s',\n          playerVars: {\n            'playsinline': 1,\n            'modestbranding': 1,\n            'controls': %s,\n            'autoplay': %s,\n            'mute': %s,\n            'loop': %s\n          },\n          events: {\n            'onReady': onPlayerReady\n          }\n        });\n      }\n\n      // 4. The API will call this function when the video player is ready.\n      function onPlayerReady(event) {\n        VideoListenerInterface.onVideoReady();\n        // Autoplaying code placeholder\n        %s\n      }\n    </script>\n</body>";
    private static final String YOUTUBE_AUTO_PLAYING_JS_CODE = "event.target.playVideo();\n\ndocument.addEventListener(\"visibilitychange\", () => {\n  if (document.visibilityState === \"visible\") {\n    event.target.seekTo(0, false);\n    event.target.playVideo();\n  } else {\n    event.target.pauseVideo();\n  }\n});";
    private static final Regex YOUTUBE_ID_RE = new Regex("embed/([a-zA-Z0-9_-]+).*");
    private static final String VIMEO_HTML_FORMAT = "<body style=\"margin:0\">\n\n  <iframe id=\"vimeoIframe\" src=\"%s&playsinline=1\"\n    width=\"100%%\" height=\"100%%\" frameborder=\"0\"\n    webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>\n\n  <script src=\"https://player.vimeo.com/api/player.js\"></script>\n  <script>\n    const vimeoIframe = document.querySelector('%%23vimeoIframe');\n    const vimeoPlayer = new Vimeo.Player(vimeoIframe);\n\n    vimeoPlayer.ready().then(function() {\n        VideoListenerInterface.onVideoReady();\n\n        // Autoplaying code placeholder\n        %s\n    });\n  </script>\n</body>";
    private static final String VIMEO_AUTO_PLAYING_JS_CODE = "vimeoPlayer.play();\n\ndocument.addEventListener(\"visibilitychange\", () => {\n  if (document.visibilityState === \"visible\") {\n    vimeoPlayer.setCurrentTime(0);\n    vimeoPlayer.play();\n  } else {\n    vimeoPlayer.pause();\n  }\n});";

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.VIMEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaType.YOUTUBE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HorizontalPosition.values().length];
            try {
                iArr2[HorizontalPosition.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[HorizontalPosition.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[HorizontalPosition.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[VerticalPosition.values().length];
            try {
                iArr3[VerticalPosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[VerticalPosition.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[VerticalPosition.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[MediaFit.values().length];
            try {
                iArr4[MediaFit.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[MediaFit.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr4[MediaFit.CENTER_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr4[MediaFit.FIT_CROP.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    @Override // com.urbanairship.android.layout.widget.ShrinkableView
    public boolean isShrinkable() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.urbanairship.android.layout.view.MediaView$activityListener$1, com.urbanairship.app.ActivityListener] */
    public MediaView(@NotNull Context context, @NotNull final MediaModel model, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.viewEnvironment = viewEnvironment;
        this.itemProperties = itemProperties;
        ?? r2 = new SimpleActivityListener() { // from class: com.urbanairship.android.layout.view.MediaView$activityListener$1
            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                TouchAwareWebView touchAwareWebView = this.this$0.webView;
                if (touchAwareWebView != null) {
                    touchAwareWebView.onPause();
                }
            }

            @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                TouchAwareWebView touchAwareWebView = this.this$0.webView;
                if (touchAwareWebView != null) {
                    touchAwareWebView.onResume();
                }
            }
        };
        this.activityListener = r2;
        this.filteredActivityListener = new FilteredActivityListener(r2, viewEnvironment.hostingActivityPredicate());
        setId(model.getViewId());
        setClipToOutline(true);
        int i = WhenMappings.$EnumSwitchMapping$0[model.getViewInfo().getMediaType().ordinal()];
        if (i == 1) {
            configureImageView(model);
        } else if (i == 2 || i == 3 || i == 4) {
            SharedState<State.Pager> pagerState = model.getPagerState();
            if (pagerState != null) {
                pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.view.MediaView.1
                    @Override // kotlin.jvm.functions.Function1
                    public final State.Pager invoke(State.Pager state) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        return state.copyWithMediaPaused(true);
                    }
                });
            }
            configureWebView(model);
        }
        model.setListener$urbanairship_layout_release(new MediaModel.Listener() { // from class: com.urbanairship.android.layout.view.MediaView.2

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.urbanairship.android.layout.view.MediaView$2$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MediaType.values().length];
                    try {
                        iArr[MediaType.VIDEO.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MediaType.YOUTUBE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MediaType.VIMEO.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.urbanairship.android.layout.model.MediaModel.Listener
            public void onPause() {
                String str;
                TouchAwareWebView touchAwareWebView;
                int i2 = WhenMappings.$EnumSwitchMapping$0[model.getViewInfo().getMediaType().ordinal()];
                if (i2 == 1) {
                    str = "videoElement.pause();";
                } else if (i2 == 2) {
                    str = "player.pauseVideo();";
                } else {
                    str = i2 != 3 ? null : "vimeoPlayer.pause();";
                }
                if (str == null || (touchAwareWebView = this.webView) == null) {
                    return;
                }
                touchAwareWebView.evaluateJavascript(str, null);
            }

            @Override // com.urbanairship.android.layout.model.MediaModel.Listener
            public void onResume() {
                String str;
                TouchAwareWebView touchAwareWebView;
                Video video = model.getViewInfo().getVideo();
                if (video == null || !video.getAutoplay()) {
                    return;
                }
                int i2 = WhenMappings.$EnumSwitchMapping$0[model.getViewInfo().getMediaType().ordinal()];
                if (i2 == 1) {
                    str = "videoElement.play();";
                } else if (i2 == 2) {
                    str = "player.playVideo();";
                } else {
                    str = i2 != 3 ? null : "vimeoPlayer.play();";
                }
                if (str == null || (touchAwareWebView = this.webView) == null) {
                    return;
                }
                touchAwareWebView.evaluateJavascript(str, null);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Unit unit;
                Intrinsics.checkNotNullParameter(background, "new");
                TouchAwareWebView touchAwareWebView = this.webView;
                if (touchAwareWebView == null) {
                    CropImageView cropImageView = this.imageView;
                    if (cropImageView != null) {
                        LayoutUtils.applyMediaImageBorderAndBackground(cropImageView, cropImageView.getBackground(), background.getBorder(), background.getColor());
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                } else {
                    LayoutUtils.applyMediaVideoBorderAndBackground(this, touchAwareWebView.getBackground(), background.getBorder(), background.getColor());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    this.newBackground = background;
                }
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/view/MediaView$WebViewListener;", "", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/MediaModel;", "(Lcom/urbanairship/android/layout/model/MediaModel;)V", "onVideoReady", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WebViewListener {
        private final MediaModel model;

        public WebViewListener(@NotNull MediaModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            this.model = model;
        }

        public final void onVideoReady() {
            SharedState<State.Pager> pagerState = this.model.getPagerState();
            if (pagerState != null) {
                pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.view.MediaView$WebViewListener$onVideoReady$1
                    @Override // kotlin.jvm.functions.Function1
                    public final State.Pager invoke(State.Pager state) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        return state.copyWithMediaPaused(false);
                    }
                });
            }
        }
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        final Flow<MotionEvent> flow;
        TouchAwareWebView touchAwareWebView = this.webView;
        if (touchAwareWebView != null && (flow = touchAwareWebView.touchEvents()) != null) {
            final Flow<MotionEvent> flow2 = new Flow<MotionEvent>() { // from class: com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 MediaView.kt\ncom/urbanairship/android/layout/view/MediaView\n*L\n1#1,218:1\n18#2:219\n19#2:221\n157#3:220\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1$2", f = "MediaView.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1$2$1 r0 = (com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1$2$1 r0 = new com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L48
                        L29:
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            r4.<init>(r5)
                            throw r4
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                            r6 = r5
                            android.view.MotionEvent r6 = (android.view.MotionEvent) r6
                            boolean r6 = com.urbanairship.android.layout.util.ViewExtensionsKt.isActionUp(r6)
                            if (r6 == 0) goto L48
                            r0.label = r3
                            java.lang.Object r4 = r4.emit(r5, r0)
                            if (r4 != r1) goto L48
                            return r1
                        L48:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.view.MediaView$taps$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super MotionEvent> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
            return new Flow<Unit>() { // from class: com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 MediaView.kt\ncom/urbanairship/android/layout/view/MediaView\n*L\n1#1,218:1\n50#2:219\n157#3:220\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1$2", f = "MediaView.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1$2$1 r0 = (com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1$2$1 r0 = new com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L43
                        L29:
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            r4.<init>(r5)
                            throw r4
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                            android.view.MotionEvent r5 = (android.view.MotionEvent) r5
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            r0.label = r3
                            java.lang.Object r4 = r4.emit(r5, r0)
                            if (r4 != r1) goto L43
                            return r1
                        L43:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.view.MediaView$taps$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super Unit> flowCollector, @NotNull Continuation continuation) {
                    Object objCollect = flow2.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            };
        }
        CropImageView cropImageView = this.imageView;
        if (cropImageView != null) {
            return ViewExtensionsKt.debouncedClicks$default(cropImageView, 0L, 1, null);
        }
        Flow<Unit> flowEmptyFlow = FlowKt.emptyFlow();
        UALog.d("MediaView.clicks() was collected before child views were ready!", new Object[0]);
        return flowEmptyFlow;
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

    private final void configureImageView(final MediaModel model) {
        String url;
        ImageCache imageCache = this.viewEnvironment.getImageCache();
        final CachedImage cachedImage = imageCache != null ? imageCache.get(model.getViewInfo().getUrl()) : null;
        if (cachedImage == null || (url = cachedImage.getPath()) == null) {
            url = model.getViewInfo().getUrl();
        }
        final String str = url;
        if (!StringsKt.endsWith$default(str, ".svg", false, 2, (Object) null)) {
            if (!isAttachedToWindow()) {
                addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.urbanairship.android.layout.view.MediaView$configureImageView$$inlined$doOnAttach$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(@NotNull View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NotNull View view) {
                        this.removeOnAttachStateChangeListener(this);
                        ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
                        Context context = this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        CropImageView cropImageView = new CropImageView(context, null, 0, 6, null);
                        cropImageView.setId(model.getMediaViewId());
                        cropImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        cropImageView.setAdjustViewBounds(true);
                        cropImageView.setClipToOutline(true);
                        if (this.newBackground != null) {
                            LayoutUtils.applyMediaImageBorderAndBackground(cropImageView, cropImageView.getBackground(), model.getViewInfo().getBorder(), model.getViewInfo().getBackgroundColor());
                        }
                        if (model.getViewInfo().getMediaFit() == MediaFit.FIT_CROP) {
                            cropImageView.setParentLayoutParams(layoutParams);
                            cropImageView.setImagePosition(model.getViewInfo().getPosition());
                        } else {
                            cropImageView.setScaleType(model.getViewInfo().getMediaFit().getScaleType());
                        }
                        cropImageView.setImportantForAccessibility(2);
                        MediaModel mediaModel = model;
                        Context context2 = cropImageView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        StringExtensionsKt.ifNotEmpty(mediaModel.contentDescription(context2), new MediaView$configureImageView$1$iv$1$2(cropImageView, model));
                        this.imageView = cropImageView;
                        this.addView(cropImageView);
                        MediaView.configureImageView$lambda$5$loadImage(this, cachedImage, cropImageView, new Ref.BooleanRef(), str);
                    }
                });
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            CropImageView cropImageView = new CropImageView(context, null, 0, 6, null);
            cropImageView.setId(model.getMediaViewId());
            cropImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            cropImageView.setAdjustViewBounds(true);
            cropImageView.setClipToOutline(true);
            if (this.newBackground != null) {
                LayoutUtils.applyMediaImageBorderAndBackground(cropImageView, cropImageView.getBackground(), model.getViewInfo().getBorder(), model.getViewInfo().getBackgroundColor());
            }
            if (model.getViewInfo().getMediaFit() == MediaFit.FIT_CROP) {
                cropImageView.setParentLayoutParams(layoutParams);
                cropImageView.setImagePosition(model.getViewInfo().getPosition());
            } else {
                cropImageView.setScaleType(model.getViewInfo().getMediaFit().getScaleType());
            }
            cropImageView.setImportantForAccessibility(2);
            Context context2 = cropImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            StringExtensionsKt.ifNotEmpty(model.contentDescription(context2), new MediaView$configureImageView$1$iv$1$2(cropImageView, model));
            this.imageView = cropImageView;
            addView(cropImageView);
            configureImageView$lambda$5$loadImage(this, cachedImage, cropImageView, new Ref.BooleanRef(), str);
            return;
        }
        configureWebView(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureImageView$lambda$5$loadImage(final MediaView mediaView, final CachedImage cachedImage, final CropImageView cropImageView, final Ref.BooleanRef booleanRef, final String str) {
        ImageRequestOptions.Builder builderNewBuilder = ImageRequestOptions.newBuilder(str);
        ItemProperties itemProperties = mediaView.itemProperties;
        ImageRequestOptions imageRequestOptionsBuild = builderNewBuilder.setImageSizeResolver(new ThomasImageSizeResolver(itemProperties != null ? itemProperties.getSize() : null, cachedImage != null ? cachedImage.getSize() : null)).setImageLoadedCallback(new ImageLoader.ImageLoadedCallback() { // from class: com.urbanairship.android.layout.view.MediaView$configureImageView$1$loadImage$options$1
            @Override // com.urbanairship.images.ImageLoader.ImageLoadedCallback
            public final void onImageLoaded(boolean z) {
                if (z) {
                    booleanRef.element = true;
                    return;
                }
                final MediaView mediaView2 = mediaView;
                final Ref.BooleanRef booleanRef2 = booleanRef;
                final String str2 = str;
                final CachedImage cachedImage2 = cachedImage;
                final CropImageView cropImageView2 = cropImageView;
                mediaView2.visibilityChangeListener = new BaseView.VisibilityChangeListener() { // from class: com.urbanairship.android.layout.view.MediaView$configureImageView$1$loadImage$options$1.1
                    @Override // com.urbanairship.android.layout.view.BaseView.VisibilityChangeListener
                    public void onVisibilityChanged(int visibility) {
                        if (visibility == 0) {
                            Ref.BooleanRef booleanRef3 = booleanRef2;
                            if (booleanRef3.element) {
                                return;
                            }
                            MediaView.configureImageView$lambda$5$loadImage(mediaView2, cachedImage2, cropImageView2, booleanRef3, str2);
                        }
                    }
                };
            }
        }).build();
        Intrinsics.checkNotNullExpressionValue(imageRequestOptionsBuild, "build(...)");
        UAirship.shared().getImageLoader().load(mediaView.getContext(), cropImageView, imageRequestOptionsBuild);
    }

    private final void configureWebView(final MediaModel model) {
        ViewGroup viewGroup;
        Video video;
        this.viewEnvironment.getActivityMonitor().addActivityListener(this.filteredActivityListener);
        WebViewListener webViewListener = new WebViewListener(model);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final TouchAwareWebView touchAwareWebView = new TouchAwareWebView(context, webViewListener);
        touchAwareWebView.setId(model.getMediaViewId());
        this.webView = touchAwareWebView;
        touchAwareWebView.setWebChromeClient(this.viewEnvironment.webChromeClientFactory().create());
        touchAwareWebView.addJavascriptInterface(touchAwareWebView.getJavascriptInterface(), "VideoListenerInterface");
        int i = WhenMappings.$EnumSwitchMapping$0[model.getViewInfo().getMediaType().ordinal()];
        if (i == 1) {
            ViewGroup frameLayout = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.setLayoutParams(layoutParams);
            viewGroup = frameLayout;
        } else if (i == 2) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            final FixedAspectRatioFrameLayout fixedAspectRatioFrameLayout = new FixedAspectRatioFrameLayout(context2);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            fixedAspectRatioFrameLayout.setLayoutParams(layoutParams2);
            if (!fixedAspectRatioFrameLayout.isAttachedToWindow()) {
                fixedAspectRatioFrameLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.urbanairship.android.layout.view.MediaView$configureWebView$lambda$10$$inlined$doOnAttach$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(@NotNull View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(@NotNull View view) {
                        Double aspectRatio;
                        fixedAspectRatioFrameLayout.removeOnAttachStateChangeListener(this);
                        ViewGroup.LayoutParams layoutParams3 = this.getLayoutParams();
                        boolean z = layoutParams3.width == -2;
                        boolean z2 = layoutParams3.height == -2;
                        if (z || z2) {
                            Video video2 = model.getViewInfo().getVideo();
                            if (video2 == null || (aspectRatio = video2.getAspectRatio()) == null) {
                                return;
                            }
                            fixedAspectRatioFrameLayout.setAspectRatio(Float.valueOf((float) aspectRatio.doubleValue()));
                            return;
                        }
                        fixedAspectRatioFrameLayout.setAspectRatio(null);
                    }
                });
                viewGroup = fixedAspectRatioFrameLayout;
            } else {
                ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
                boolean z = layoutParams3.width == -2;
                boolean z2 = layoutParams3.height == -2;
                if (z || z2) {
                    Video video2 = model.getViewInfo().getVideo();
                    viewGroup = fixedAspectRatioFrameLayout;
                    if (video2 != null) {
                        Double aspectRatio = video2.getAspectRatio();
                        viewGroup = fixedAspectRatioFrameLayout;
                        if (aspectRatio != null) {
                            fixedAspectRatioFrameLayout.setAspectRatio(Float.valueOf((float) aspectRatio.doubleValue()));
                            viewGroup = fixedAspectRatioFrameLayout;
                        }
                    }
                } else {
                    fixedAspectRatioFrameLayout.setAspectRatio(null);
                    viewGroup = fixedAspectRatioFrameLayout;
                }
            }
        } else if (i == 3 || i == 4) {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            FixedAspectRatioFrameLayout fixedAspectRatioFrameLayout2 = new FixedAspectRatioFrameLayout(context3);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams4.gravity = 17;
            fixedAspectRatioFrameLayout2.setLayoutParams(layoutParams4);
            Video video3 = model.getViewInfo().getVideo();
            viewGroup = fixedAspectRatioFrameLayout2;
            if (video3 != null) {
                Double aspectRatio2 = video3.getAspectRatio();
                viewGroup = fixedAspectRatioFrameLayout2;
                if (aspectRatio2 != null) {
                    fixedAspectRatioFrameLayout2.setAspectRatio(Float.valueOf((float) aspectRatio2.doubleValue()));
                    viewGroup = fixedAspectRatioFrameLayout2;
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams5.gravity = 17;
        viewGroup.addView(this.webView, layoutParams5);
        final ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.setId(R.id.progress);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 17;
        viewGroup.addView(progressBar, layoutParams6);
        touchAwareWebView.setBackgroundColor(0);
        WebSettings settings = touchAwareWebView.getSettings();
        if (model.getViewInfo().getMediaType() == MediaType.VIDEO && (video = model.getViewInfo().getVideo()) != null && video.getAutoplay()) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        settings.setJavaScriptEnabled(true);
        if (ManifestUtils.shouldEnableLocalStorage()) {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
        }
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        final WeakReference weakReference = new WeakReference(touchAwareWebView);
        Runnable runnable = new Runnable() { // from class: com.urbanairship.android.layout.view.MediaView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaView.configureWebView$lambda$23(weakReference, model, this);
            }
        };
        setImportantForAccessibility(2);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        StringExtensionsKt.ifNotEmpty(model.contentDescription(context4), new Function1() { // from class: com.urbanairship.android.layout.view.MediaView.configureWebView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                touchAwareWebView.setContentDescription(it);
                if (Intrinsics.areEqual(model.getViewInfo().getAccessibilityHidden(), Boolean.TRUE)) {
                    return;
                }
                touchAwareWebView.setImportantForAccessibility(1);
            }
        });
        touchAwareWebView.setVisibility(4);
        touchAwareWebView.setWebViewClient(new MediaWebViewClient(runnable) { // from class: com.urbanairship.android.layout.view.MediaView.configureWebView.3
            @Override // com.urbanairship.android.layout.view.MediaView.MediaWebViewClient
            protected void onPageFinished(@NotNull WebView webView) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                webView.setVisibility(0);
                progressBar.setVisibility(8);
            }
        });
        addView(viewGroup);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureWebView$lambda$23(WeakReference webViewWeakReference, MediaModel model, MediaView this$0) {
        String str;
        List<String> groupValues;
        Intrinsics.checkNotNullParameter(webViewWeakReference, "$webViewWeakReference");
        Intrinsics.checkNotNullParameter(model, "$model");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TouchAwareWebView touchAwareWebView = (TouchAwareWebView) webViewWeakReference.get();
        if (touchAwareWebView != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[model.getViewInfo().getMediaType().ordinal()];
            if (i == 1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = String.format(IMAGE_HTML_FORMAT, Arrays.copyOf(new Object[]{model.getViewInfo().getUrl()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                touchAwareWebView.loadData(str2, Mimetypes.MIMETYPE_HTML, "UTF-8");
                return;
            }
            if (i == 2) {
                Video video = model.getViewInfo().getVideo();
                if (video == null) {
                    video = Video.INSTANCE.defaultVideo();
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str3 = String.format(VIDEO_HTML_FORMAT, Arrays.copyOf(new Object[]{video.getShowControls() ? "controls" : "", video.getAutoplay() ? "autoplay" : "", video.getMuted() ? "muted" : "", video.getLoop() ? "loop" : "", model.getViewInfo().getUrl(), this$0.getVideoStyle(model), video.getAutoplay() ? VIDEO_AUTO_PLAYING_JS_CODE : ""}, 7));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                touchAwareWebView.loadData(str3, Mimetypes.MIMETYPE_HTML, "UTF-8");
                return;
            }
            if (i == 3) {
                Video video2 = model.getViewInfo().getVideo();
                if (video2 == null) {
                    video2 = Video.INSTANCE.defaultVideo();
                }
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String str4 = String.format(VIMEO_HTML_FORMAT, Arrays.copyOf(new Object[]{model.getViewInfo().getUrl(), video2.getAutoplay() ? VIMEO_AUTO_PLAYING_JS_CODE : ""}, 2));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                touchAwareWebView.loadData(str4, Mimetypes.MIMETYPE_HTML, "UTF-8");
                return;
            }
            if (i != 4) {
                return;
            }
            Video video3 = model.getViewInfo().getVideo();
            if (video3 == null) {
                video3 = Video.INSTANCE.defaultVideo();
            }
            Unit unit = null;
            MatchResult matchResultFind$default = Regex.find$default(YOUTUBE_ID_RE, model.getViewInfo().getUrl(), 0, 2, null);
            String str5 = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : groupValues.get(1);
            if (str5 != null) {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String str6 = YOUTUBE_HTML_FORMAT;
                String str7 = video3.getShowControls() ? "1" : "0";
                String str8 = video3.getAutoplay() ? "1" : "0";
                String str9 = video3.getMuted() ? "1" : "0";
                if (video3.getLoop()) {
                    str = "1, 'playlist': '" + str5 + CoreConstants.SINGLE_QUOTE_CHAR;
                } else {
                    str = "0";
                }
                String str10 = String.format(str6, Arrays.copyOf(new Object[]{str5, str7, str8, str9, str, video3.getAutoplay() ? YOUTUBE_AUTO_PLAYING_JS_CODE : ""}, 6));
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                touchAwareWebView.loadData(str10, Mimetypes.MIMETYPE_HTML, "UTF-8");
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                String url = model.getViewInfo().getUrl();
                InstrumentationCallbacks.loadUrlCalled(touchAwareWebView);
                touchAwareWebView.loadUrl(url);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String getVideoStyle(com.urbanairship.android.layout.model.MediaModel r8) {
        /*
            r7 = this;
            com.urbanairship.android.layout.info.View r0 = r8.getViewInfo()
            com.urbanairship.android.layout.info.MediaInfo r0 = (com.urbanairship.android.layout.info.MediaInfo) r0
            com.urbanairship.android.layout.property.MediaFit r0 = r0.getMediaFit()
            int[] r1 = com.urbanairship.android.layout.view.MediaView.WhenMappings.$EnumSwitchMapping$3
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto Laa
            r2 = 2
            if (r0 == r2) goto La7
            r3 = 3
            if (r0 == r3) goto La4
            r4 = 4
            if (r0 != r4) goto L9e
            int r7 = r7.getLayoutDirection()
            if (r1 != r7) goto L26
            r7 = r1
            goto L27
        L26:
            r7 = 0
        L27:
            com.urbanairship.android.layout.info.View r0 = r8.getViewInfo()
            com.urbanairship.android.layout.info.MediaInfo r0 = (com.urbanairship.android.layout.info.MediaInfo) r0
            com.urbanairship.android.layout.property.Position r0 = r0.getPosition()
            com.urbanairship.android.layout.property.HorizontalPosition r0 = r0.getHorizontal()
            int[] r4 = com.urbanairship.android.layout.view.MediaView.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r4[r0]
            java.lang.String r4 = "right"
            java.lang.String r5 = "left"
            java.lang.String r6 = "center"
            if (r0 == r1) goto L55
            if (r0 == r2) goto L51
            if (r0 != r3) goto L4b
            r4 = r6
            goto L57
        L4b:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L51:
            if (r7 == 0) goto L57
        L53:
            r4 = r5
            goto L57
        L55:
            if (r7 == 0) goto L53
        L57:
            com.urbanairship.android.layout.info.View r7 = r8.getViewInfo()
            com.urbanairship.android.layout.info.MediaInfo r7 = (com.urbanairship.android.layout.info.MediaInfo) r7
            com.urbanairship.android.layout.property.Position r7 = r7.getPosition()
            com.urbanairship.android.layout.property.VerticalPosition r7 = r7.getVertical()
            int[] r8 = com.urbanairship.android.layout.view.MediaView.WhenMappings.$EnumSwitchMapping$2
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r1) goto L7d
            if (r7 == r2) goto L7a
            if (r7 != r3) goto L74
            goto L7f
        L74:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L7a:
            java.lang.String r6 = "bottom"
            goto L7f
        L7d:
            java.lang.String r6 = "top"
        L7f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "object-fit: cover; object-position: "
            r7.append(r8)
            r7.append(r4)
            r8 = 32
            r7.append(r8)
            r7.append(r6)
            r8 = 59
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto Lac
        L9e:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        La4:
            java.lang.String r7 = "object-fit: cover;"
            goto Lac
        La7:
            java.lang.String r7 = "object-fit: contain;"
            goto Lac
        Laa:
            java.lang.String r7 = "object-fit: none;"
        Lac:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.view.MediaView.getVideoStyle(com.urbanairship.android.layout.model.MediaModel):java.lang.String");
    }

    private static abstract class MediaWebViewClient extends WebViewClient {

        @NotNull
        public static final Companion Companion = new Companion(null);
        private boolean error;
        private final Runnable onRetry;
        private long retryDelay;

        protected abstract void onPageFinished(WebView webView);

        public MediaWebViewClient(Runnable onRetry) {
            Intrinsics.checkNotNullParameter(onRetry, "onRetry");
            this.onRetry = onRetry;
            this.retryDelay = 1000L;
        }

        public final boolean getError() {
            return this.error;
        }

        public final void setError(boolean z) {
            this.error = z;
        }

        public final long getRetryDelay() {
            return this.retryDelay;
        }

        public final void setRetryDelay(long j) {
            this.retryDelay = j;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView view, @NotNull String url) {
            InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            if (this.error) {
                view.postDelayed(this.onRetry, this.retryDelay);
                this.retryDelay *= 2;
            } else {
                onPageFinished(view);
            }
            this.error = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@NotNull WebView view, @NotNull WebResourceRequest request, @NotNull WebResourceError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(error, "error");
            super.onReceivedError(view, request, error);
            this.error = true;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/layout/view/MediaView$MediaWebViewClient$Companion;", "", "()V", "START_RETRY_DELAY", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/view/MediaView$FixedAspectRatioFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", ViewProps.ASPECT_RATIO, "", "getAspectRatio", "()Ljava/lang/Float;", "setAspectRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FixedAspectRatioFrameLayout extends FrameLayout {
        private Float aspectRatio;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedAspectRatioFrameLayout(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.aspectRatio = Float.valueOf(1.77f);
        }

        @Nullable
        public final Float getAspectRatio() {
            return this.aspectRatio;
        }

        public final void setAspectRatio(@Nullable Float f) {
            this.aspectRatio = f;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            Unit unit;
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            boolean z = false;
            if (mode2 == 1073741824) {
                if (mode != 1073741824 || size == 0) {
                    z = true;
                }
            } else if (mode != 1073741824) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            }
            Float f = this.aspectRatio;
            if (f != null) {
                float fFloatValue = f.floatValue();
                if (z) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (size2 * fFloatValue), 1073741824);
                    iMakeMeasureSpec = heightMeasureSpec;
                } else {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (size / fFloatValue), 1073741824);
                    iMakeMeasureSpec2 = widthMeasureSpec;
                }
                super.onMeasure(iMakeMeasureSpec2, iMakeMeasureSpec);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
    }
}
