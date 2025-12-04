package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.SphericalUtil;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.io.ByteArrayOutputStream;
import java.util.List;

/* loaded from: classes4.dex */
public class MapGradientPolyline extends MapFeature {
    private int[] colors;
    protected final Context context;
    private GoogleMap map;
    private List points;
    private TileOverlay tileOverlay;
    private float width;
    private float zIndex;

    public MapGradientPolyline(Context context) {
        super(context);
        this.context = context;
    }

    public void setCoordinates(List<LatLng> list) {
        this.points = list;
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.remove();
        }
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            this.tileOverlay = googleMap.addTileOverlay(createTileOverlayOptions());
        }
    }

    public void setStrokeColors(int[] iArr) {
        this.colors = iArr;
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.remove();
        }
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            this.tileOverlay = googleMap.addTileOverlay(createTileOverlayOptions());
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.setZIndex(f);
        }
    }

    public void setWidth(float f) {
        this.width = f;
        TileOverlay tileOverlay = this.tileOverlay;
        if (tileOverlay != null) {
            tileOverlay.remove();
        }
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            this.tileOverlay = googleMap.addTileOverlay(createTileOverlayOptions());
        }
    }

    private TileOverlayOptions createTileOverlayOptions() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.zIndex);
        tileOverlayOptions.tileProvider(new AirMapGradientPolylineProvider(this.context, this.points, this.colors, this.width));
        return tileOverlayOptions;
    }

    public static int interpolateColor(int[] iArr, float f) {
        float length = f * (iArr.length - 1);
        int iRed = 0;
        int iGreen = 0;
        int iBlue = 0;
        for (int i = 0; i < iArr.length; i++) {
            float fMax = Math.max(1.0f - Math.abs(length - i), BitmapDescriptorFactory.HUE_RED);
            iRed += (int) (Color.red(iArr[i]) * fMax);
            iGreen += (int) (Color.green(iArr[i]) * fMax);
            iBlue += (int) (Color.blue(iArr[i]) * fMax);
        }
        return Color.rgb(iRed, iGreen, iBlue);
    }

    public class AirMapGradientPolylineProvider implements TileProvider {
        public static final int BASE_TILE_SIZE = 256;
        protected final int[] colors;
        protected final float density;
        protected final List<LatLng> points;
        protected Point[] projectedPtMids;
        protected Point[] projectedPts;
        protected final SphericalMercatorProjection projection;
        protected final int tileDimension;
        protected LatLng[] trailLatLngs;
        protected final float width;

        public AirMapGradientPolylineProvider(Context context, List<LatLng> list, int[] iArr, float f) {
            this.points = list;
            this.colors = iArr;
            this.width = f;
            float f2 = context.getResources().getDisplayMetrics().density;
            this.density = f2;
            this.tileDimension = (int) (f2 * 256.0f);
            this.projection = new SphericalMercatorProjection(256.0d);
            calculatePoints();
        }

        public void calculatePoints() {
            this.trailLatLngs = new LatLng[this.points.size()];
            this.projectedPts = new Point[this.points.size()];
            this.projectedPtMids = new Point[Math.max(this.points.size() - 1, 0)];
            for (int i = 0; i < this.points.size(); i++) {
                LatLng latLng = this.points.get(i);
                this.trailLatLngs[i] = latLng;
                this.projectedPts[i] = this.projection.toPoint(latLng);
                if (i > 0) {
                    int i2 = i - 1;
                    this.projectedPtMids[i2] = this.projection.toPoint(SphericalUtil.interpolate(this.points.get(i2), latLng, 0.5d));
                }
            }
        }

        @Override // com.google.android.gms.maps.model.TileProvider
        public Tile getTile(int i, int i2, int i3) {
            int i4 = this.tileDimension;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Matrix matrix = new Matrix();
            Paint paint = new Paint();
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            paint.setStrokeWidth(this.width);
            Paint.Cap cap = Paint.Cap.BUTT;
            paint.setStrokeCap(cap);
            Paint.Join join = Paint.Join.ROUND;
            paint.setStrokeJoin(join);
            paint.setFlags(1);
            paint.setShader(new LinearGradient(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, this.colors, (float[]) null, Shader.TileMode.CLAMP));
            paint.getShader().setLocalMatrix(matrix);
            Paint paint2 = new Paint();
            paint2.setStyle(style);
            paint2.setStrokeWidth(this.width);
            paint2.setStrokeCap(cap);
            paint2.setStrokeJoin(join);
            paint2.setFlags(1);
            renderTrail(canvas, matrix, paint, paint2, (float) (Math.pow(2.0d, i3) * this.density), i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            int i5 = this.tileDimension;
            return new Tile(i5, i5, byteArrayOutputStream.toByteArray());
        }

        public void renderTrail(Canvas canvas, Matrix matrix, Paint paint, Paint paint2, float f, int i, int i2) {
            Canvas canvas2 = canvas;
            MutPoint mutPoint = new MutPoint();
            MutPoint mutPoint2 = new MutPoint();
            MutPoint mutPoint3 = new MutPoint();
            MutPoint mutPoint4 = new MutPoint();
            MutPoint mutPoint5 = new MutPoint();
            float f2 = 1.0f;
            boolean z = true;
            if (this.points.size() == 1) {
                mutPoint.set(this.projectedPts[0], f, i, i2, this.tileDimension);
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(MapGradientPolyline.interpolateColor(this.colors, 1.0f));
                canvas2.drawCircle((float) mutPoint.x, (float) mutPoint.y, paint2.getStrokeWidth() / 2.0f, paint2);
                paint2.setStyle(Paint.Style.STROKE);
                return;
            }
            if (this.points.size() == 2) {
                mutPoint.set(this.projectedPts[0], f, i, i2, this.tileDimension);
                mutPoint2.set(this.projectedPts[1], f, i, i2, this.tileDimension);
                drawLine(canvas, paint2, mutPoint, mutPoint2, BitmapDescriptorFactory.HUE_RED);
                return;
            }
            int i3 = 2;
            while (i3 < this.points.size()) {
                int i4 = i3 - 2;
                mutPoint.set(this.projectedPts[i4], f, i, i2, this.tileDimension);
                int i5 = i3 - 1;
                mutPoint2.set(this.projectedPts[i5], f, i, i2, this.tileDimension);
                mutPoint3.set(this.projectedPts[i3], f, i, i2, this.tileDimension);
                mutPoint4.set(this.projectedPtMids[i4], f, i, i2, this.tileDimension);
                mutPoint5.set(this.projectedPtMids[i5], f, i, i2, this.tileDimension);
                float f3 = i3;
                float size = (f3 - 2.0f) / this.points.size();
                float size2 = (f3 - f2) / this.points.size();
                float f4 = (size + size2) / 2.0f;
                Log.d("AirMapGradientPolyline", String.valueOf(f4));
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(MapGradientPolyline.interpolateColor(this.colors, f4));
                canvas2.drawCircle((float) mutPoint2.x, (float) mutPoint2.y, paint2.getStrokeWidth() / 2.0f, paint2);
                paint2.setStyle(Paint.Style.STROKE);
                MutPoint mutPoint6 = i4 == 0 ? mutPoint : mutPoint4;
                int i6 = i3;
                boolean z2 = z;
                float f5 = f2;
                drawLine(canvas, matrix, paint, paint2, mutPoint6, mutPoint2, size, f4);
                drawLine(canvas, matrix, paint, paint2, mutPoint2, i6 == this.points.size() + (-1) ? mutPoint3 : mutPoint5, f4, size2);
                i3 = i6 + 1;
                canvas2 = canvas;
                z = z2;
                f2 = f5;
            }
        }

        public void drawLine(Canvas canvas, Matrix matrix, Paint paint, Paint paint2, MutPoint mutPoint, MutPoint mutPoint2, float f, float f2) {
            if (f == f2) {
                drawLine(canvas, paint2, mutPoint, mutPoint2, f);
                return;
            }
            matrix.reset();
            matrix.preRotate((float) Math.toDegrees(Math.atan2(mutPoint2.y - mutPoint.y, mutPoint2.x - mutPoint.x)), (float) mutPoint.x, (float) mutPoint.y);
            matrix.preTranslate((float) mutPoint.x, (float) mutPoint.y);
            float fSqrt = (float) Math.sqrt(Math.pow(mutPoint2.x - mutPoint.x, 2.0d) + Math.pow(mutPoint2.y - mutPoint.y, 2.0d));
            matrix.preScale(fSqrt, fSqrt);
            float f3 = 1.0f / (f2 - f);
            matrix.preScale(f3, f3);
            matrix.preTranslate(-f, BitmapDescriptorFactory.HUE_RED);
            paint.getShader().setLocalMatrix(matrix);
            canvas.drawLine((float) mutPoint.x, (float) mutPoint.y, (float) mutPoint2.x, (float) mutPoint2.y, paint);
        }

        public void drawLine(Canvas canvas, Paint paint, MutPoint mutPoint, MutPoint mutPoint2, float f) {
            paint.setColor(MapGradientPolyline.interpolateColor(this.colors, f));
            canvas.drawLine((float) mutPoint.x, (float) mutPoint.y, (float) mutPoint2.x, (float) mutPoint2.y, paint);
        }
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.tileOverlay;
    }

    @Override // com.rnmaps.maps.MapFeature
    public void addToMap(Object obj) {
        GoogleMap googleMap = (GoogleMap) obj;
        this.map = googleMap;
        this.tileOverlay = googleMap.addTileOverlay(createTileOverlayOptions());
    }

    @Override // com.rnmaps.maps.MapFeature
    public void removeFromMap(Object obj) {
        this.tileOverlay.remove();
    }

    public static class MutPoint {
        public double x;
        public double y;

        public MutPoint set(Point point, float f, int i, int i2, int i3) {
            double d = f;
            this.x = (point.x * d) - (i * i3);
            this.y = (point.y * d) - (i2 * i3);
            return this;
        }
    }
}
