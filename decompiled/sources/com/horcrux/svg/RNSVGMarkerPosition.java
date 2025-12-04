package com.horcrux.svg;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
class RNSVGMarkerPosition {
    private static boolean auto_start_reverse_;
    private static int element_index_;
    private static Point in_slope_;
    private static Point origin_;
    private static Point out_slope_;
    private static ArrayList<RNSVGMarkerPosition> positions_;
    private static Point subpath_start_;
    double angle;
    Point origin;
    RNSVGMarkerType type;

    private static double rad2deg(double d) {
        return d * 57.29577951308232d;
    }

    private RNSVGMarkerPosition(RNSVGMarkerType rNSVGMarkerType, Point point, double d) {
        this.type = rNSVGMarkerType;
        this.origin = point;
        this.angle = d;
    }

    static ArrayList<RNSVGMarkerPosition> fromPath(ArrayList<PathElement> arrayList) {
        positions_ = new ArrayList<>();
        element_index_ = 0;
        origin_ = new Point(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        subpath_start_ = new Point(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        Iterator<PathElement> it = arrayList.iterator();
        while (it.hasNext()) {
            UpdateFromPathElement(it.next());
        }
        PathIsDone();
        return positions_;
    }

    private static void PathIsDone() {
        RNSVGMarkerType rNSVGMarkerType = RNSVGMarkerType.kEndMarker;
        positions_.add(new RNSVGMarkerPosition(rNSVGMarkerType, origin_, CurrentAngle(rNSVGMarkerType)));
    }

    private static double BisectingAngle(double d, double d2) {
        if (Math.abs(d - d2) > 180.0d) {
            d += 360.0d;
        }
        return (d + d2) / 2.0d;
    }

    private static double SlopeAngleRadians(Point point) {
        return Math.atan2(point.y, point.x);
    }

    private static double CurrentAngle(RNSVGMarkerType rNSVGMarkerType) {
        double dRad2deg = rad2deg(SlopeAngleRadians(in_slope_));
        double dRad2deg2 = rad2deg(SlopeAngleRadians(out_slope_));
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$RNSVGMarkerType[rNSVGMarkerType.ordinal()];
        if (i == 1) {
            return auto_start_reverse_ ? dRad2deg2 + 180.0d : dRad2deg2;
        }
        if (i != 2) {
            return i != 3 ? AudioStats.AUDIO_AMPLITUDE_NONE : dRad2deg;
        }
        return BisectingAngle(dRad2deg, dRad2deg2);
    }

    private static Point subtract(Point point, Point point2) {
        return new Point(point2.x - point.x, point2.y - point.y);
    }

    private static boolean isZero(Point point) {
        return point.x == AudioStats.AUDIO_AMPLITUDE_NONE && point.y == AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private static void ComputeQuadTangents(SegmentData segmentData, Point point, Point point2, Point point3) {
        segmentData.start_tangent = subtract(point2, point);
        segmentData.end_tangent = subtract(point3, point2);
        if (isZero(segmentData.start_tangent)) {
            segmentData.start_tangent = segmentData.end_tangent;
        } else if (isZero(segmentData.end_tangent)) {
            segmentData.end_tangent = segmentData.start_tangent;
        }
    }

    private static SegmentData ExtractPathElementFeatures(PathElement pathElement) {
        SegmentData segmentData = new SegmentData();
        Point[] pointArr = pathElement.points;
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$ElementType[pathElement.type.ordinal()];
        if (i == 1) {
            segmentData.position = pointArr[2];
            segmentData.start_tangent = subtract(pointArr[0], origin_);
            segmentData.end_tangent = subtract(pointArr[2], pointArr[1]);
            if (isZero(segmentData.start_tangent)) {
                ComputeQuadTangents(segmentData, pointArr[0], pointArr[1], pointArr[2]);
            } else if (isZero(segmentData.end_tangent)) {
                ComputeQuadTangents(segmentData, origin_, pointArr[0], pointArr[1]);
            }
        } else if (i == 2) {
            Point point = pointArr[1];
            segmentData.position = point;
            ComputeQuadTangents(segmentData, origin_, pointArr[0], point);
        } else if (i == 3 || i == 4) {
            Point point2 = pointArr[0];
            segmentData.position = point2;
            segmentData.start_tangent = subtract(point2, origin_);
            segmentData.end_tangent = subtract(segmentData.position, origin_);
        } else if (i == 5) {
            Point point3 = subpath_start_;
            segmentData.position = point3;
            segmentData.start_tangent = subtract(point3, origin_);
            segmentData.end_tangent = subtract(segmentData.position, origin_);
        }
        return segmentData;
    }

    /* renamed from: com.horcrux.svg.RNSVGMarkerPosition$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$ElementType;
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$RNSVGMarkerType;

        static {
            int[] iArr = new int[ElementType.values().length];
            $SwitchMap$com$horcrux$svg$ElementType = iArr;
            try {
                iArr[ElementType.kCGPathElementAddCurveToPoint.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$ElementType[ElementType.kCGPathElementAddQuadCurveToPoint.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$ElementType[ElementType.kCGPathElementMoveToPoint.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$ElementType[ElementType.kCGPathElementAddLineToPoint.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$horcrux$svg$ElementType[ElementType.kCGPathElementCloseSubpath.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[RNSVGMarkerType.values().length];
            $SwitchMap$com$horcrux$svg$RNSVGMarkerType = iArr2;
            try {
                iArr2[RNSVGMarkerType.kStartMarker.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$horcrux$svg$RNSVGMarkerType[RNSVGMarkerType.kMidMarker.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$horcrux$svg$RNSVGMarkerType[RNSVGMarkerType.kEndMarker.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static void UpdateFromPathElement(PathElement pathElement) {
        SegmentData segmentDataExtractPathElementFeatures = ExtractPathElementFeatures(pathElement);
        out_slope_ = segmentDataExtractPathElementFeatures.start_tangent;
        int i = element_index_;
        if (i > 0) {
            RNSVGMarkerType rNSVGMarkerType = i == 1 ? RNSVGMarkerType.kStartMarker : RNSVGMarkerType.kMidMarker;
            positions_.add(new RNSVGMarkerPosition(rNSVGMarkerType, origin_, CurrentAngle(rNSVGMarkerType)));
        }
        in_slope_ = segmentDataExtractPathElementFeatures.end_tangent;
        origin_ = segmentDataExtractPathElementFeatures.position;
        ElementType elementType = pathElement.type;
        if (elementType == ElementType.kCGPathElementMoveToPoint) {
            subpath_start_ = pathElement.points[0];
        } else if (elementType == ElementType.kCGPathElementCloseSubpath) {
            subpath_start_ = new Point(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        element_index_++;
    }
}
