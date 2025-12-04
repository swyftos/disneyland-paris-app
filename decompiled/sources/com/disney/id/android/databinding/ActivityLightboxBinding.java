package com.disney.id.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.disney.id.android.R;

/* loaded from: classes3.dex */
public final class ActivityLightboxBinding implements ViewBinding {

    @NonNull
    public final TextView forceVersionMessage;

    @NonNull
    public final FrameLayout oneidLightbox;

    @NonNull
    public final ImageView oneidLightboxBackground;

    @NonNull
    public final FrameLayout oneidLoaderView;
    private final FrameLayout rootView;

    private ActivityLightboxBinding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, ImageView imageView, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.forceVersionMessage = textView;
        this.oneidLightbox = frameLayout2;
        this.oneidLightboxBackground = imageView;
        this.oneidLoaderView = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ActivityLightboxBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityLightboxBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_lightbox, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public static ActivityLightboxBinding bind(@NonNull View view) {
        int i = R.id.force_version_message;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i = R.id.oneid_lightbox_background;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.oneid_loader_view;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    return new ActivityLightboxBinding(frameLayout, textView, frameLayout, imageView, frameLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
