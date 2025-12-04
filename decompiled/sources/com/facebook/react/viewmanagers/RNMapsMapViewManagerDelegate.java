package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNMapsMapViewManagerInterface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class RNMapsMapViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNMapsMapViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNMapsMapViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        float fFloatValue = BitmapDescriptorFactory.HUE_RED;
        char c = 65535;
        switch (str.hashCode()) {
            case -1829317469:
                if (str.equals("userInterfaceStyle")) {
                    c = 0;
                    break;
                }
                break;
            case -1782863279:
                if (str.equals("zoomTapEnabled")) {
                    c = 1;
                    break;
                }
                break;
            case -1759547385:
                if (str.equals("showsTraffic")) {
                    c = 2;
                    break;
                }
                break;
            case -1566201979:
                if (str.equals("cameraZoomRange")) {
                    c = 3;
                    break;
                }
                break;
            case -1393473402:
                if (str.equals("minDelta")) {
                    c = 4;
                    break;
                }
                break;
            case -1375324191:
                if (str.equals("pitchEnabled")) {
                    c = 5;
                    break;
                }
                break;
            case -1367751899:
                if (str.equals("camera")) {
                    c = 6;
                    break;
                }
                break;
            case -1267568177:
                if (str.equals("userLocationFastestInterval")) {
                    c = 7;
                    break;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    c = '\b';
                    break;
                }
                break;
            case -1127683526:
                if (str.equals("kmlSrc")) {
                    c = '\t';
                    break;
                }
                break;
            case -1040869018:
                if (str.equals("rotateEnabled")) {
                    c = '\n';
                    break;
                }
                break;
            case -993771358:
                if (str.equals("followsUserLocation")) {
                    c = 11;
                    break;
                }
                break;
            case -934795532:
                if (str.equals("region")) {
                    c = '\f';
                    break;
                }
                break;
            case -919980087:
                if (str.equals("showsBuildings")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case -689983723:
                if (str.equals("mapPadding")) {
                    c = 14;
                    break;
                }
                break;
            case -628456567:
                if (str.equals("initialCamera")) {
                    c = 15;
                    break;
                }
                break;
            case -572752893:
                if (str.equals("poiClickEnabled")) {
                    c = 16;
                    break;
                }
                break;
            case -513095866:
                if (str.equals("toolbarEnabled")) {
                    c = 17;
                    break;
                }
                break;
            case -351898402:
                if (str.equals("googleMapId")) {
                    c = 18;
                    break;
                }
                break;
            case -296636969:
                if (str.equals("zoomControlEnabled")) {
                    c = 19;
                    break;
                }
                break;
            case -220452823:
                if (str.equals("handlePanDrag")) {
                    c = 20;
                    break;
                }
                break;
            case -195500200:
                if (str.equals("initialRegion")) {
                    c = 21;
                    break;
                }
                break;
            case -43140580:
                if (str.equals("googleRenderer")) {
                    c = 22;
                    break;
                }
                break;
            case 5371973:
                if (str.equals("compassOffset")) {
                    c = 23;
                    break;
                }
                break;
            case 104515312:
                if (str.equals("loadingIndicatorColor")) {
                    c = 24;
                    break;
                }
                break;
            case 120171641:
                if (str.equals("moveOnMarkerPress")) {
                    c = 25;
                    break;
                }
                break;
            case 258247452:
                if (str.equals("showsCompass")) {
                    c = 26;
                    break;
                }
                break;
            case 382723252:
                if (str.equals("maxDelta")) {
                    c = 27;
                    break;
                }
                break;
            case 397237599:
                if (str.equals("cacheEnabled")) {
                    c = 28;
                    break;
                }
                break;
            case 836737718:
                if (str.equals("mapType")) {
                    c = 29;
                    break;
                }
                break;
            case 844294999:
                if (str.equals("maxZoom")) {
                    c = 30;
                    break;
                }
                break;
            case 1064092997:
                if (str.equals("minZoom")) {
                    c = 31;
                    break;
                }
                break;
            case 1100266704:
                if (str.equals("paddingAdjustmentBehavior")) {
                    c = ' ';
                    break;
                }
                break;
            case 1146474862:
                if (str.equals("userLocationUpdateInterval")) {
                    c = '!';
                    break;
                }
                break;
            case 1174265046:
                if (str.equals("showsUserLocation")) {
                    c = '\"';
                    break;
                }
                break;
            case 1251345034:
                if (str.equals("showsIndoors")) {
                    c = '#';
                    break;
                }
                break;
            case 1300116068:
                if (str.equals("userLocationPriority")) {
                    c = '$';
                    break;
                }
                break;
            case 1316805545:
                if (str.equals("userLocationAnnotationTitle")) {
                    c = CoreConstants.PERCENT_CHAR;
                    break;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case 1360222065:
                if (str.equals("liteMode")) {
                    c = CoreConstants.SINGLE_QUOTE_CHAR;
                    break;
                }
                break;
            case 1381913122:
                if (str.equals("scrollDuringRotateOrZoomEnabled")) {
                    c = CoreConstants.LEFT_PARENTHESIS_CHAR;
                    break;
                }
                break;
            case 1668305364:
                if (str.equals("showsScale")) {
                    c = CoreConstants.RIGHT_PARENTHESIS_CHAR;
                    break;
                }
                break;
            case 1755945966:
                if (str.equals("zoomEnabled")) {
                    c = '*';
                    break;
                }
                break;
            case 1835773433:
                if (str.equals("loadingBackgroundColor")) {
                    c = '+';
                    break;
                }
                break;
            case 1906749073:
                if (str.equals("legalLabelInsets")) {
                    c = ',';
                    break;
                }
                break;
            case 2017177929:
                if (str.equals("showsMyLocationButton")) {
                    c = '-';
                    break;
                }
                break;
            case 2028148329:
                if (str.equals("showsIndoorLevelPicker")) {
                    c = '.';
                    break;
                }
                break;
            case 2059339185:
                if (str.equals("userLocationCalloutEnabled")) {
                    c = '/';
                    break;
                }
                break;
            case 2089349111:
                if (str.equals("customMapStyleString")) {
                    c = '0';
                    break;
                }
                break;
            case 2121180773:
                if (str.equals("loadingEnabled")) {
                    c = '1';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setUserInterfaceStyle(t, (String) obj);
                break;
            case 1:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setZoomTapEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 2:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsTraffic(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setCameraZoomRange(t, (ReadableMap) obj);
                break;
            case 4:
                RNMapsMapViewManagerInterface rNMapsMapViewManagerInterface = (RNMapsMapViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                rNMapsMapViewManagerInterface.setMinDelta(t, dDoubleValue);
                break;
            case 5:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setPitchEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 6:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setCamera((RNMapsMapViewManagerInterface) t, (ReadableMap) obj);
                break;
            case 7:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setUserLocationFastestInterval(t, obj != null ? ((Double) obj).intValue() : 5000);
                break;
            case '\b':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setScrollEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '\t':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setKmlSrc(t, obj != null ? (String) obj : null);
                break;
            case '\n':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setRotateEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 11:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setFollowsUserLocation(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\f':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setRegion(t, (ReadableMap) obj);
                break;
            case '\r':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsBuildings(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 14:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setMapPadding(t, (ReadableMap) obj);
                break;
            case 15:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setInitialCamera(t, (ReadableMap) obj);
                break;
            case 16:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setPoiClickEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setToolbarEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 18:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setGoogleMapId(t, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setZoomControlEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 20:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setHandlePanDrag(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 21:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setInitialRegion(t, (ReadableMap) obj);
                break;
            case 22:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setGoogleRenderer(t, (String) obj);
                break;
            case 23:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setCompassOffset(t, (ReadableMap) obj);
                break;
            case 24:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setLoadingIndicatorColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 25:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setMoveOnMarkerPress(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 26:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsCompass(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 27:
                RNMapsMapViewManagerInterface rNMapsMapViewManagerInterface2 = (RNMapsMapViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    dDoubleValue = ((Double) obj).doubleValue();
                }
                rNMapsMapViewManagerInterface2.setMaxDelta(t, dDoubleValue);
                break;
            case 28:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setCacheEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNMapsMapViewManagerInterface) this.mViewManager).setMapType(t, (String) obj);
                break;
            case 30:
                RNMapsMapViewManagerInterface rNMapsMapViewManagerInterface3 = (RNMapsMapViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNMapsMapViewManagerInterface3.setMaxZoom(t, fFloatValue);
                break;
            case 31:
                RNMapsMapViewManagerInterface rNMapsMapViewManagerInterface4 = (RNMapsMapViewManagerInterface) this.mViewManager;
                if (obj != null) {
                    fFloatValue = ((Double) obj).floatValue();
                }
                rNMapsMapViewManagerInterface4.setMinZoom(t, fFloatValue);
                break;
            case ' ':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setPaddingAdjustmentBehavior(t, (String) obj);
                break;
            case '!':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setUserLocationUpdateInterval(t, obj != null ? ((Double) obj).intValue() : 5000);
                break;
            case '\"':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsUserLocation(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '#':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsIndoors(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '$':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setUserLocationPriority(t, (String) obj);
                break;
            case '%':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setUserLocationAnnotationTitle(t, obj != null ? (String) obj : null);
                break;
            case '&':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case '\'':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setLiteMode(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '(':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setScrollDuringRotateOrZoomEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case ')':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsScale(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '*':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setZoomEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '+':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setLoadingBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case ',':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setLegalLabelInsets(t, (ReadableMap) obj);
                break;
            case '-':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsMyLocationButton(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '.':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setShowsIndoorLevelPicker(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '/':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setUserLocationCalloutEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '0':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setCustomMapStyleString(t, obj != null ? (String) obj : null);
                break;
            case '1':
                ((RNMapsMapViewManagerInterface) this.mViewManager).setLoadingEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
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
            case "fitToSuppliedMarkers":
                ((RNMapsMapViewManagerInterface) this.mViewManager).fitToSuppliedMarkers(t, readableArray.getString(0), readableArray.getString(1), readableArray.getBoolean(2));
                break;
            case "setIndoorActiveLevelIndex":
                ((RNMapsMapViewManagerInterface) this.mViewManager).setIndoorActiveLevelIndex(t, readableArray.getInt(0));
                break;
            case "setCamera":
                ((RNMapsMapViewManagerInterface) this.mViewManager).setCamera((RNMapsMapViewManagerInterface) t, readableArray.getString(0));
                break;
            case "fitToElements":
                ((RNMapsMapViewManagerInterface) this.mViewManager).fitToElements(t, readableArray.getString(0), readableArray.getBoolean(1));
                break;
            case "animateCamera":
                ((RNMapsMapViewManagerInterface) this.mViewManager).animateCamera(t, readableArray.getString(0), readableArray.getInt(1));
                break;
            case "animateToRegion":
                ((RNMapsMapViewManagerInterface) this.mViewManager).animateToRegion(t, readableArray.getString(0), readableArray.getInt(1));
                break;
            case "fitToCoordinates":
                ((RNMapsMapViewManagerInterface) this.mViewManager).fitToCoordinates(t, readableArray.getString(0), readableArray.getString(1), readableArray.getBoolean(2));
                break;
        }
    }
}
