package com.amazonaws.transform;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes2.dex */
public class SimpleTypeStaxUnmarshallers {
    private static Log log = LogFactory.getLog(SimpleTypeStaxUnmarshallers.class);

    public static class StringStaxUnmarshaller implements Unmarshaller<String, StaxUnmarshallerContext> {
        private static StringStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public String unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return staxUnmarshallerContext.readText();
        }

        public static StringStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class BigDecimalStaxUnmarshaller implements Unmarshaller<BigDecimal, StaxUnmarshallerContext> {
        private static BigDecimalStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public BigDecimal unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return new BigDecimal(text);
        }

        public static BigDecimalStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigDecimalStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class BigIntegerStaxUnmarshaller implements Unmarshaller<BigInteger, StaxUnmarshallerContext> {
        private static BigIntegerStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public BigInteger unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return new BigInteger(text);
        }

        public static BigIntegerStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigIntegerStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class DoubleStaxUnmarshaller implements Unmarshaller<Double, StaxUnmarshallerContext> {
        private static DoubleStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Double unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(text));
        }

        public static DoubleStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class IntegerStaxUnmarshaller implements Unmarshaller<Integer, StaxUnmarshallerContext> {
        private static IntegerStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Integer unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(text));
        }

        public static IntegerStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class BooleanStaxUnmarshaller implements Unmarshaller<Boolean, StaxUnmarshallerContext> {
        private static BooleanStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Boolean unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(text));
        }

        public static BooleanStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class FloatStaxUnmarshaller implements Unmarshaller<Float, StaxUnmarshallerContext> {
        private static FloatStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Float unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return Float.valueOf(text);
        }

        public static FloatStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class LongStaxUnmarshaller implements Unmarshaller<Long, StaxUnmarshallerContext> {
        private static LongStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Long unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(text));
        }

        public static LongStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class ByteStaxUnmarshaller implements Unmarshaller<Byte, StaxUnmarshallerContext> {
        private static ByteStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Byte unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            return Byte.valueOf(text);
        }

        public static ByteStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class DateStaxUnmarshaller implements Unmarshaller<Date, StaxUnmarshallerContext> {
        private static DateStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public Date unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String text = staxUnmarshallerContext.readText();
            if (text == null) {
                return null;
            }
            try {
                return DateUtils.parseISO8601Date(text);
            } catch (Exception e) {
                SimpleTypeStaxUnmarshallers.log.warn("Unable to parse date '" + text + "':  " + e.getMessage(), e);
                return null;
            }
        }

        public static DateStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class ByteBufferStaxUnmarshaller implements Unmarshaller<ByteBuffer, StaxUnmarshallerContext> {
        private static ByteBufferStaxUnmarshaller instance;

        @Override // com.amazonaws.transform.Unmarshaller
        public ByteBuffer unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(staxUnmarshallerContext.readText()));
        }

        public static ByteBufferStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferStaxUnmarshaller();
            }
            return instance;
        }
    }
}
