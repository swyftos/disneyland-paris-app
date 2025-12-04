package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNMapsMarkerManagerInterface;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class RNMapsMarkerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsMarkerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsMarkerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1832195190:
                if (str.equals("useLegacyPinView")) {
                    c = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c = 1;
                    break;
                }
                break;
            case -1618432855:
                if (str.equals("identifier")) {
                    c = 2;
                    break;
                }
                break;
            case -1413299531:
                if (str.equals("anchor")) {
                    c = 3;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    c = 4;
                    break;
                }
                break;
            case -612807350:
                if (str.equals("subtitleVisibility")) {
                    c = 5;
                    break;
                }
                break;
            case -460635442:
                if (str.equals("pinColor")) {
                    c = 6;
                    break;
                }
                break;
            case -304480883:
                if (str.equals("draggable")) {
                    c = 7;
                    break;
                }
                break;
            case 100313435:
                if (str.equals(MimeTypes.BASE_TYPE_IMAGE)) {
                    c = '\b';
                    break;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    c = '\t';
                    break;
                }
                break;
            case 198931832:
                if (str.equals("coordinate")) {
                    c = '\n';
                    break;
                }
                break;
            case 931298053:
                if (str.equals("calloutAnchor")) {
                    c = 11;
                    break;
                }
                break;
            case 1324817635:
                if (str.equals("calloutOffset")) {
                    c = '\f';
                    break;
                }
                break;
            case 1450660746:
                if (str.equals("titleVisibility")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 1589440180:
                if (str.equals("isPreselected")) {
                    c = 14;
                    break;
                }
                break;
            case 1934365830:
                if (str.equals("displayPriority")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setUseLegacyPinView(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setDescription(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setIdentifier(t, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setAnchor(t, (ReadableMap) obj);
                break;
            case 4:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setOpacity(t, obj == null ? 1.0d : ((Double) obj).doubleValue());
                break;
            case 5:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setSubtitleVisibility(t, (String) obj);
                break;
            case 6:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setPinColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 7:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setDraggable(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\b':
                ((RNMapsMarkerManagerInterface) this.mViewManager).setImage(t, (ReadableMap) obj);
                break;
            case '\t':
                ((RNMapsMarkerManagerInterface) this.mViewManager).setTitle(t, obj != null ? (String) obj : null);
                break;
            case '\n':
                ((RNMapsMarkerManagerInterface) this.mViewManager).setCoordinate(t, (ReadableMap) obj);
                break;
            case 11:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setCalloutAnchor(t, (ReadableMap) obj);
                break;
            case '\f':
                ((RNMapsMarkerManagerInterface) this.mViewManager).setCalloutOffset(t, (ReadableMap) obj);
                break;
            case '\r':
                ((RNMapsMarkerManagerInterface) this.mViewManager).setTitleVisibility(t, (String) obj);
                break;
            case 14:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setIsPreselected(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 15:
                ((RNMapsMarkerManagerInterface) this.mViewManager).setDisplayPriority(t, (String) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(T t, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "redraw":
                ((RNMapsMarkerManagerInterface) this.mViewManager).redraw(t);
                break;
            case "animateToCoordinates":
                ((RNMapsMarkerManagerInterface) this.mViewManager).animateToCoordinates(t, readableArray.getDouble(0), readableArray.getDouble(1), readableArray.getInt(2));
                break;
            case "setCoordinates":
                ((RNMapsMarkerManagerInterface) this.mViewManager).setCoordinates(t, readableArray.getDouble(0), readableArray.getDouble(1));
                break;
            case "hideCallout":
                ((RNMapsMarkerManagerInterface) this.mViewManager).hideCallout(t);
                break;
            case "redrawCallout":
                ((RNMapsMarkerManagerInterface) this.mViewManager).redrawCallout(t);
                break;
            case "showCallout":
                ((RNMapsMarkerManagerInterface) this.mViewManager).showCallout(t);
                break;
        }
    }
}
