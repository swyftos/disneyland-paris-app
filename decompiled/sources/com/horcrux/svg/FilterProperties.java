package com.horcrux.svg;

import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* loaded from: classes4.dex */
class FilterProperties {
    FilterProperties() {
    }

    enum Units {
        OBJECT_BOUNDING_BOX("objectBoundingBox"),
        USER_SPACE_ON_USE("userSpaceOnUse");

        private static final Map<String, Units> unitsToEnum = new HashMap();
        private final String units;

        static {
            for (Units units : values()) {
                unitsToEnum.put(units.units, units);
            }
        }

        Units(String str) {
            this.units = str;
        }

        static Units getEnum(String str) {
            Map<String, Units> map = unitsToEnum;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException("Unknown 'Unit' Value: " + str);
            }
            return map.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.units;
        }
    }

    enum EdgeMode {
        UNKNOWN("unknown"),
        DUPLICATE("duplicate"),
        WRAP("wrap"),
        NONE("none");

        private static final Map<String, EdgeMode> edgeModeToEnum = new HashMap();
        private final String edgeMode;

        static {
            for (EdgeMode edgeMode : values()) {
                edgeModeToEnum.put(edgeMode.edgeMode, edgeMode);
            }
        }

        EdgeMode(String str) {
            this.edgeMode = str;
        }

        static EdgeMode getEnum(String str) {
            Map<String, EdgeMode> map = edgeModeToEnum;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException("Unknown 'edgeMode' Value: " + str);
            }
            return map.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.edgeMode;
        }
    }

    enum FeBlendMode {
        UNKNOWN("unknown"),
        NORMAL("normal"),
        MULTIPLY("multiply"),
        SCREEN(TCEventPropertiesNames.TCD_SCREEN),
        DARKEN("darken"),
        LIGHTEN("lighten");

        private static final Map<String, FeBlendMode> typeToEnum = new HashMap();
        private final String mode;

        static {
            for (FeBlendMode feBlendMode : values()) {
                typeToEnum.put(feBlendMode.mode, feBlendMode);
            }
        }

        FeBlendMode(String str) {
            this.mode = str;
        }

        static FeBlendMode getEnum(String str) {
            Map<String, FeBlendMode> map = typeToEnum;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException("Unknown String Value: " + str);
            }
            return map.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.mode;
        }
    }

    enum FeColorMatrixType {
        MATRIX("matrix"),
        SATURATE("saturate"),
        HUE_ROTATE("hueRotate"),
        LUMINANCE_TO_ALPHA("luminanceToAlpha");

        private static final Map<String, FeColorMatrixType> typeToEnum = new HashMap();
        private final String type;

        static {
            for (FeColorMatrixType feColorMatrixType : values()) {
                typeToEnum.put(feColorMatrixType.type, feColorMatrixType);
            }
        }

        FeColorMatrixType(String str) {
            this.type = str;
        }

        static FeColorMatrixType getEnum(String str) {
            Map<String, FeColorMatrixType> map = typeToEnum;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException("Unknown String Value: " + str);
            }
            return map.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.type;
        }
    }

    enum FeCompositeOperator {
        OVER("over"),
        IN("in"),
        OUT("out"),
        ATOP("atop"),
        XOR("xor"),
        ARITHMETIC("arithmetic");

        private static final Map<String, FeCompositeOperator> typeToEnum = new HashMap();
        private final String type;

        static {
            for (FeCompositeOperator feCompositeOperator : values()) {
                typeToEnum.put(feCompositeOperator.type, feCompositeOperator);
            }
        }

        FeCompositeOperator(String str) {
            this.type = str;
        }

        static FeCompositeOperator getEnum(String str) {
            Map<String, FeCompositeOperator> map = typeToEnum;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException("Unknown String Value: " + str);
            }
            return map.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.type;
        }
    }
}
