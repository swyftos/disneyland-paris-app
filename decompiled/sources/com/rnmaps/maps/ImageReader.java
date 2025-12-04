package com.rnmaps.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes4.dex */
public class ImageReader {
    private final Context context;
    private DataSource dataSource;
    private final ImageReadable imp;
    private final DraweeHolder logoHolder;
    private final ControllerListener mLogoControllerListener = new BaseControllerListener() { // from class: com.rnmaps.maps.ImageReader.1
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) throws Throwable {
            CloseableReference closeableReference;
            Throwable th;
            Bitmap underlyingBitmap;
            try {
                closeableReference = (CloseableReference) ImageReader.this.dataSource.getResult();
                if (closeableReference != null) {
                    try {
                        CloseableImage closeableImage = (CloseableImage) closeableReference.get();
                        if ((closeableImage instanceof CloseableStaticBitmap) && (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) != null) {
                            Bitmap bitmapCopy = underlyingBitmap.copy(Bitmap.Config.ARGB_8888, true);
                            ImageReader.this.imp.setIconBitmap(bitmapCopy);
                            ImageReader.this.imp.setIconBitmapDescriptor(BitmapDescriptorFactory.fromBitmap(bitmapCopy));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        ImageReader.this.dataSource.close();
                        if (closeableReference != null) {
                            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                        }
                        throw th;
                    }
                }
                ImageReader.this.dataSource.close();
                if (closeableReference != null) {
                    CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                }
                ImageReader.this.imp.update();
            } catch (Throwable th3) {
                closeableReference = null;
                th = th3;
            }
        }
    };
    private final Resources resources;

    public ImageReader(Context context, Resources resources, ImageReadable imageReadable) {
        this.context = context;
        this.resources = resources;
        this.imp = imageReadable;
        DraweeHolder draweeHolderCreate = DraweeHolder.create(createDraweeHeirarchy(resources), context);
        this.logoHolder = draweeHolderCreate;
        draweeHolderCreate.onAttach();
    }

    private GenericDraweeHierarchy createDraweeHeirarchy(Resources resources) {
        return new GenericDraweeHierarchyBuilder(resources).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void setImage(String str) throws NumberFormatException {
        if (str == null) {
            this.imp.setIconBitmapDescriptor(null);
            this.imp.update();
            return;
        }
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://") || str.startsWith("asset://") || str.startsWith("data:")) {
            ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build();
            this.dataSource = Fresco.getImagePipeline().fetchDecodedImage(imageRequestBuild, this);
            this.logoHolder.setController(Fresco.newDraweeControllerBuilder().setImageRequest(imageRequestBuild).setControllerListener(this.mLogoControllerListener).setOldController(this.logoHolder.getController()).build());
            return;
        }
        this.imp.setIconBitmapDescriptor(getBitmapDescriptorByName(str));
        this.imp.setIconBitmap(BitmapFactory.decodeResource(this.resources, getDrawableResourceByName(str)));
        this.imp.update();
    }

    private int getDrawableResourceByName(String str) {
        return this.resources.getIdentifier(str, "drawable", this.context.getPackageName());
    }

    private BitmapDescriptor getBitmapDescriptorByName(String str) {
        return BitmapDescriptorFactory.fromResource(getDrawableResourceByName(str));
    }
}
