package org.apache.commons.lang3.text;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.builder.Builder;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class StrBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    private static final long serialVersionUID = 7628716375283629643L;
    protected char[] buffer;
    private String newLine;
    private String nullText;
    protected int size;

    final class StrBuilderReader extends Reader {
        private int mark;
        private int pos;

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return true;
        }

        StrBuilderReader() {
        }

        @Override // java.io.Reader
        public void mark(int i) {
            this.mark = this.pos;
        }

        @Override // java.io.Reader
        public int read() {
            if (!ready()) {
                return -1;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i = this.pos;
            this.pos = i + 1;
            return strBuilder.charAt(i);
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            int i3;
            if (i < 0 || i2 < 0 || i > cArr.length || (i3 = i + i2) > cArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.pos >= StrBuilder.this.size()) {
                return -1;
            }
            if (this.pos + i2 > StrBuilder.this.size()) {
                i2 = StrBuilder.this.size() - this.pos;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i4 = this.pos;
            strBuilder.getChars(i4, i4 + i2, cArr, i);
            this.pos += i2;
            return i2;
        }

        @Override // java.io.Reader
        public boolean ready() {
            return this.pos < StrBuilder.this.size();
        }

        @Override // java.io.Reader
        public void reset() {
            this.pos = this.mark;
        }

        @Override // java.io.Reader
        public long skip(long j) {
            if (((long) this.pos) + j > StrBuilder.this.size()) {
                j = StrBuilder.this.size() - this.pos;
            }
            if (j < 0) {
                return 0L;
            }
            this.pos = Math.addExact(this.pos, Math.toIntExact(j));
            return j;
        }
    }

    final class StrBuilderTokenizer extends StrTokenizer {
        StrBuilderTokenizer() {
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        public String getContent() {
            String content = super.getContent();
            return content == null ? StrBuilder.this.toString() : content;
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        protected List tokenize(char[] cArr, int i, int i2) {
            if (cArr == null) {
                StrBuilder strBuilder = StrBuilder.this;
                return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
            }
            return super.tokenize(cArr, i, i2);
        }
    }

    final class StrBuilderWriter extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        StrBuilderWriter() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            StrBuilder.this.append(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            StrBuilder.this.append(cArr, i, i2);
        }

        @Override // java.io.Writer
        public void write(int i) {
            StrBuilder.this.append((char) i);
        }

        @Override // java.io.Writer
        public void write(String str) {
            StrBuilder.this.append(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
            StrBuilder.this.append(str, i, i2);
        }
    }

    public StrBuilder() {
        this(32);
    }

    public StrBuilder(int i) {
        this.buffer = new char[i <= 0 ? 32 : i];
    }

    public StrBuilder(String str) {
        if (str == null) {
            this.buffer = new char[32];
        } else {
            this.buffer = new char[str.length() + 32];
            append(str);
        }
    }

    public StrBuilder append(boolean z) {
        if (z) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            int i = this.size;
            int i2 = i + 1;
            this.size = i2;
            cArr[i] = 't';
            int i3 = i + 2;
            this.size = i3;
            cArr[i2] = 'r';
            this.size = i + 3;
            cArr[i3] = 'u';
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr2 = this.buffer;
            int i4 = this.size;
            int i5 = i4 + 1;
            this.size = i5;
            cArr2[i4] = 'f';
            int i6 = i4 + 2;
            this.size = i6;
            cArr2[i5] = 'a';
            int i7 = i4 + 3;
            this.size = i7;
            cArr2[i6] = 'l';
            this.size = i4 + 4;
            cArr2[i7] = 's';
        }
        char[] cArr3 = this.buffer;
        int i8 = this.size;
        this.size = i8 + 1;
        cArr3[i8] = 'e';
        return this;
    }

    @Override // java.lang.Appendable
    public StrBuilder append(char c) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
        return this;
    }

    public StrBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return appendNull();
        }
        if (i < 0 || i > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid startIndex: " + i2);
        }
        if (i2 < 0 || i + i2 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i2);
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            System.arraycopy(cArr, i, this.buffer, length, i2);
            this.size += i2;
        }
        return this;
    }

    public StrBuilder append(CharBuffer charBuffer) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int iRemaining = charBuffer.remaining();
            int length = length();
            ensureCapacity(length + iRemaining);
            System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position(), this.buffer, length, iRemaining);
            this.size += iRemaining;
        } else {
            append(charBuffer.toString());
        }
        return this;
    }

    public StrBuilder append(CharBuffer charBuffer, int i, int i2) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int iRemaining = charBuffer.remaining();
            if (i < 0 || i > iRemaining) {
                throw new StringIndexOutOfBoundsException("startIndex must be valid");
            }
            if (i2 < 0 || i + i2 > iRemaining) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            int length = length();
            ensureCapacity(length + i2);
            System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i, this.buffer, length, i2);
            this.size += i2;
        } else {
            append(charBuffer.toString(), i, i2);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            return appendNull();
        }
        if (charSequence instanceof StrBuilder) {
            return append((StrBuilder) charSequence);
        }
        if (charSequence instanceof StringBuilder) {
            return append((StringBuilder) charSequence);
        }
        if (charSequence instanceof StringBuffer) {
            return append((StringBuffer) charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return append((CharBuffer) charSequence);
        }
        return append(charSequence.toString());
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return appendNull();
        }
        return append(charSequence.toString(), i, i2);
    }

    public StrBuilder append(double d) {
        return append(String.valueOf(d));
    }

    public StrBuilder append(float f) {
        return append(String.valueOf(f));
    }

    public StrBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public StrBuilder append(long j) {
        return append(String.valueOf(j));
    }

    public StrBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        if (obj instanceof CharSequence) {
            return append((CharSequence) obj);
        }
        return append(obj.toString());
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return appendNull();
        }
        int length = strBuilder.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(strBuilder.buffer, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int i, int i2) {
        int i3;
        if (strBuilder == null) {
            return appendNull();
        }
        if (i < 0 || i > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > strBuilder.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            strBuilder.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public StrBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int length = str.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            str.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(String str, int i, int i2) {
        int i3;
        if (str == null) {
            return appendNull();
        }
        if (i < 0 || i > str.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > str.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            str.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public StrBuilder append(String str, Object... objArr) {
        return append(String.format(str, objArr));
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return appendNull();
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            stringBuffer.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StringBuffer stringBuffer, int i, int i2) {
        int i3;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i < 0 || i > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            stringBuffer.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public StrBuilder append(StringBuilder sb) {
        if (sb == null) {
            return appendNull();
        }
        int length = sb.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            sb.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StringBuilder sb, int i, int i2) {
        int i3;
        if (sb == null) {
            return appendNull();
        }
        if (i < 0 || i > sb.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > sb.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            sb.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public StrBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            iterable.forEach(new StrBuilder$$ExternalSyntheticLambda3(this));
        }
        return this;
    }

    public StrBuilder appendAll(Iterator<?> it) {
        if (it != null) {
            it.forEachRemaining(new StrBuilder$$ExternalSyntheticLambda3(this));
        }
        return this;
    }

    public <T> StrBuilder appendAll(T... tArr) {
        if (ArrayUtils.isNotEmpty(tArr)) {
            for (T t : tArr) {
                append(t);
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(int i, int i2, char c) {
        return appendFixedWidthPadLeft(String.valueOf(i), i2, c);
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i, char c) {
        if (i > 0) {
            ensureCapacity(this.size + i);
            String string = ObjectUtils.toString(obj, new StrBuilder$$ExternalSyntheticLambda2(this));
            if (string == null) {
                string = "";
            }
            int length = string.length();
            if (length >= i) {
                string.getChars(length - i, length, this.buffer, this.size);
            } else {
                int i2 = this.size;
                int i3 = (i - length) + i2;
                Arrays.fill(this.buffer, i2, i3, c);
                string.getChars(0, length, this.buffer, i3);
            }
            this.size += i;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(int i, int i2, char c) {
        return appendFixedWidthPadRight(String.valueOf(i), i2, c);
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i, char c) {
        if (i > 0) {
            ensureCapacity(this.size + i);
            String string = ObjectUtils.toString(obj, new StrBuilder$$ExternalSyntheticLambda2(this));
            if (string == null) {
                string = "";
            }
            int length = string.length();
            if (length >= i) {
                string.getChars(0, i, this.buffer, this.size);
            } else {
                string.getChars(0, length, this.buffer, this.size);
                int i2 = this.size + length;
                Arrays.fill(this.buffer, i2, (i2 + i) - length, c);
            }
            this.size += i;
        }
        return this;
    }

    public StrBuilder appendln(boolean z) {
        return append(z).appendNewLine();
    }

    public StrBuilder appendln(char c) {
        return append(c).appendNewLine();
    }

    public StrBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public StrBuilder appendln(char[] cArr, int i, int i2) {
        return append(cArr, i, i2).appendNewLine();
    }

    public StrBuilder appendln(double d) {
        return append(d).appendNewLine();
    }

    public StrBuilder appendln(float f) {
        return append(f).appendNewLine();
    }

    public StrBuilder appendln(int i) {
        return append(i).appendNewLine();
    }

    public StrBuilder appendln(long j) {
        return append(j).appendNewLine();
    }

    public StrBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return append(strBuilder).appendNewLine();
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i, int i2) {
        return append(strBuilder, i, i2).appendNewLine();
    }

    public StrBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    public StrBuilder appendln(String str, int i, int i2) {
        return append(str, i, i2).appendNewLine();
    }

    public StrBuilder appendln(String str, Object... objArr) {
        return append(str, objArr).appendNewLine();
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i, int i2) {
        return append(stringBuffer, i, i2).appendNewLine();
    }

    public StrBuilder appendln(StringBuilder sb) {
        return append(sb).appendNewLine();
    }

    public StrBuilder appendln(StringBuilder sb, int i, int i2) {
        return append(sb, i, i2).appendNewLine();
    }

    public StrBuilder appendNewLine() {
        String str = this.newLine;
        if (str == null) {
            append(System.lineSeparator());
            return this;
        }
        return append(str);
    }

    public StrBuilder appendNull() {
        String str = this.nullText;
        return str == null ? this : append(str);
    }

    public StrBuilder appendPadding(int i, char c) {
        if (i >= 0) {
            ensureCapacity(this.size + i);
            for (int i2 = 0; i2 < i; i2++) {
                char[] cArr = this.buffer;
                int i3 = this.size;
                this.size = i3 + 1;
                cArr[i3] = c;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c) {
        if (isNotEmpty()) {
            append(c);
        }
        return this;
    }

    public StrBuilder appendSeparator(char c, char c2) {
        if (isNotEmpty()) {
            append(c);
        } else {
            append(c2);
        }
        return this;
    }

    public StrBuilder appendSeparator(char c, int i) {
        if (i > 0) {
            append(c);
        }
        return this;
    }

    public StrBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public StrBuilder appendSeparator(String str, int i) {
        if (str != null && i > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public void appendTo(Appendable appendable) throws IOException {
        if (appendable instanceof Writer) {
            ((Writer) appendable).write(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuilder) {
            ((StringBuilder) appendable).append(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuffer) {
            ((StringBuffer) appendable).append(this.buffer, 0, this.size);
        } else if (appendable instanceof CharBuffer) {
            ((CharBuffer) appendable).put(this.buffer, 0, this.size);
        } else {
            appendable.append(this);
        }
    }

    public StrBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        if (iterable != null) {
            String string = Objects.toString(str, "");
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(string);
                }
            }
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Iterator<?> it, String str) {
        if (it != null) {
            String string = Objects.toString(str, "");
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(string);
                }
            }
        }
        return this;
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            String string = Objects.toString(str, "");
            append(objArr[0]);
            for (int i = 1; i < objArr.length; i++) {
                append(string);
                append(objArr[i]);
            }
        }
        return this;
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    @Override // org.apache.commons.lang3.builder.Builder
    public String build() {
        return toString();
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i < 0 || i >= length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return this.buffer[i];
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c) {
        char[] cArr = this.buffer;
        for (int i = 0; i < this.size; i++) {
            if (cArr[i] == c) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public boolean contains(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0) >= 0;
    }

    public StrBuilder delete(int i, int i2) {
        int iValidateRange = validateRange(i, i2);
        int i3 = iValidateRange - i;
        if (i3 > 0) {
            deleteImpl(i, iValidateRange, i3);
        }
        return this;
    }

    public StrBuilder deleteAll(char c) {
        int i = 0;
        while (i < this.size) {
            if (this.buffer[i] == c) {
                int i2 = i;
                do {
                    i2++;
                    if (i2 >= this.size) {
                        break;
                    }
                } while (this.buffer[i2] == c);
                int i3 = i2 - i;
                deleteImpl(i, i2, i3);
                i = i2 - i3;
            }
            i++;
        }
        return this;
    }

    public StrBuilder deleteAll(String str) {
        int length = StringUtils.length(str);
        if (length > 0) {
            int iIndexOf = indexOf(str, 0);
            while (iIndexOf >= 0) {
                deleteImpl(iIndexOf, iIndexOf + length, length);
                iIndexOf = indexOf(str, iIndexOf);
            }
        }
        return this;
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, -1);
    }

    public StrBuilder deleteCharAt(int i) {
        if (i < 0 || i >= this.size) {
            throw new StringIndexOutOfBoundsException(i);
        }
        deleteImpl(i, i + 1, 1);
        return this;
    }

    public StrBuilder deleteFirst(char c) {
        for (int i = 0; i < this.size; i++) {
            if (this.buffer[i] == c) {
                deleteImpl(i, i + 1, 1);
                break;
            }
        }
        return this;
    }

    public StrBuilder deleteFirst(String str) {
        int iIndexOf;
        int length = StringUtils.length(str);
        if (length > 0 && (iIndexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(iIndexOf, iIndexOf + length, length);
        }
        return this;
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, 1);
    }

    private void deleteImpl(int i, int i2, int i3) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i, this.size - i2);
        this.size -= i3;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i = this.size;
        if (length > i) {
            return false;
        }
        int i2 = i - length;
        int i3 = 0;
        while (i3 < length) {
            if (this.buffer[i2] != str.charAt(i3)) {
                return false;
            }
            i3++;
            i2++;
        }
        return true;
    }

    public StrBuilder ensureCapacity(final int i) {
        char[] cArr = this.buffer;
        if (i > cArr.length) {
            this.buffer = (char[]) ArrayUtils.arraycopy(cArr, 0, 0, this.size, (Supplier<char[]>) new Supplier() { // from class: org.apache.commons.lang3.text.StrBuilder$$ExternalSyntheticLambda4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return StrBuilder.lambda$ensureCapacity$0(i);
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ char[] lambda$ensureCapacity$0(int i) {
        return new char[i * 2];
    }

    public boolean equals(Object obj) {
        return (obj instanceof StrBuilder) && equals((StrBuilder) obj);
    }

    public boolean equals(StrBuilder strBuilder) {
        int i;
        if (this == strBuilder) {
            return true;
        }
        if (strBuilder == null || (i = this.size) != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (cArr[i2] != cArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i = this.size;
        if (i != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            char c = cArr[i2];
            char c2 = cArr2[i2];
            if (c != c2 && Character.toUpperCase(c) != Character.toUpperCase(c2)) {
                return false;
            }
        }
        return true;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        return (char[]) ArrayUtils.arraycopy(this.buffer, 0, cArr, 0, length);
    }

    public void getChars(int i, int i2, char[] cArr, int i3) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 < 0 || i2 > length()) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("end < start");
        }
        System.arraycopy(this.buffer, i, cArr, i3, i2 - i);
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i = 0;
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            i = (i * 31) + cArr[i2];
        }
        return i;
    }

    public int indexOf(char c) {
        return indexOf(c, 0);
    }

    public int indexOf(char c, int i) {
        int iMax = Math.max(i, 0);
        if (iMax >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (iMax < this.size) {
            if (cArr[iMax] == c) {
                return iMax;
            }
            iMax++;
        }
        return -1;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public int indexOf(String str, int i) {
        return Strings.f3987CS.indexOf(this, str, i);
    }

    public int indexOf(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0);
    }

    public int indexOf(StrMatcher strMatcher, int i) {
        int i2;
        int iMax = Math.max(i, 0);
        if (strMatcher != null && iMax < (i2 = this.size)) {
            char[] cArr = this.buffer;
            for (int i3 = iMax; i3 < i2; i3++) {
                if (strMatcher.isMatch(cArr, i3, iMax, i2) > 0) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public StrBuilder insert(int i, boolean z) {
        validateIndex(i);
        if (z) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i + 4, this.size - i);
            char[] cArr2 = this.buffer;
            cArr2[i] = 't';
            cArr2[i + 1] = 'r';
            cArr2[i + 2] = 'u';
            cArr2[i + 3] = 'e';
            this.size += 4;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr3 = this.buffer;
            System.arraycopy(cArr3, i, cArr3, i + 5, this.size - i);
            char[] cArr4 = this.buffer;
            cArr4[i] = 'f';
            cArr4[i + 1] = 'a';
            cArr4[i + 2] = 'l';
            cArr4[i + 3] = 's';
            cArr4[i + 4] = 'e';
            this.size += 5;
        }
        return this;
    }

    public StrBuilder insert(int i, char c) {
        validateIndex(i);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i, cArr, i + 1, this.size - i);
        this.buffer[i] = c;
        this.size++;
        return this;
    }

    public StrBuilder insert(int i, char[] cArr) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i, cArr2, i + length, this.size - i);
            System.arraycopy(cArr, 0, this.buffer, i, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder insert(int i, char[] cArr, int i2, int i3) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        if (i2 < 0 || i2 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid offset: " + i2);
        }
        if (i3 < 0 || i2 + i3 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i3);
        }
        if (i3 > 0) {
            ensureCapacity(this.size + i3);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i, cArr2, i + i3, this.size - i);
            System.arraycopy(cArr, i2, this.buffer, i, i3);
            this.size += i3;
        }
        return this;
    }

    public StrBuilder insert(int i, double d) {
        return insert(i, String.valueOf(d));
    }

    public StrBuilder insert(int i, float f) {
        return insert(i, String.valueOf(f));
    }

    public StrBuilder insert(int i, int i2) {
        return insert(i, String.valueOf(i2));
    }

    public StrBuilder insert(int i, long j) {
        return insert(i, String.valueOf(j));
    }

    public StrBuilder insert(int i, Object obj) {
        if (obj == null) {
            return insert(i, this.nullText);
        }
        return insert(i, obj.toString());
    }

    public StrBuilder insert(int i, String str) {
        int length;
        validateIndex(i);
        if (str == null) {
            str = this.nullText;
        }
        if (str != null && (length = str.length()) > 0) {
            int i2 = this.size + length;
            ensureCapacity(i2);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i + length, this.size - i);
            this.size = i2;
            str.getChars(0, length, this.buffer, i);
        }
        return this;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isNotEmpty() {
        return this.size > 0;
    }

    public int lastIndexOf(char c) {
        return lastIndexOf(c, this.size - 1);
    }

    public int lastIndexOf(char c, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (i < 0) {
            return -1;
        }
        while (i >= 0) {
            if (this.buffer[i] == c) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public int lastIndexOf(String str, int i) {
        return Strings.f3987CS.lastIndexOf(this, str, i);
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return lastIndexOf(strMatcher, this.size);
    }

    public int lastIndexOf(StrMatcher strMatcher, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (strMatcher != null && i >= 0) {
            char[] cArr = this.buffer;
            int i3 = i + 1;
            while (i >= 0) {
                if (strMatcher.isMatch(cArr, i, 0, i3) > 0) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public String leftString(int i) {
        if (i <= 0) {
            return "";
        }
        int i2 = this.size;
        if (i >= i2) {
            return new String(this.buffer, 0, i2);
        }
        return new String(this.buffer, 0, i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.size;
    }

    public String midString(int i, int i2) {
        int i3;
        if (i < 0) {
            i = 0;
        }
        if (i2 <= 0 || i >= (i3 = this.size)) {
            return "";
        }
        if (i3 <= i + i2) {
            return new String(this.buffer, i, i3 - i);
        }
        return new String(this.buffer, i, i2);
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > length()) {
            this.buffer = (char[]) ArrayUtils.arraycopy(this.buffer, 0, 0, this.size, (Supplier<char[]>) new Supplier() { // from class: org.apache.commons.lang3.text.StrBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.lambda$minimizeCapacity$0();
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ char[] lambda$minimizeCapacity$0() {
        return new char[length()];
    }

    public int readFrom(Readable readable) throws IOException {
        int i = this.size;
        if (readable instanceof Reader) {
            Reader reader = (Reader) readable;
            ensureCapacity(i + 1);
            while (true) {
                char[] cArr = this.buffer;
                int i2 = this.size;
                int i3 = reader.read(cArr, i2, cArr.length - i2);
                if (i3 == -1) {
                    break;
                }
                int i4 = this.size + i3;
                this.size = i4;
                ensureCapacity(i4 + 1);
            }
        } else if (readable instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) readable;
            int iRemaining = charBuffer.remaining();
            ensureCapacity(this.size + iRemaining);
            charBuffer.get(this.buffer, this.size, iRemaining);
            this.size += iRemaining;
        } else {
            while (true) {
                ensureCapacity(this.size + 1);
                char[] cArr2 = this.buffer;
                int i5 = this.size;
                int i6 = readable.read(CharBuffer.wrap(cArr2, i5, cArr2.length - i5));
                if (i6 == -1) {
                    break;
                }
                this.size += i6;
            }
        }
        return this.size - i;
    }

    public StrBuilder replace(int i, int i2, String str) {
        int iValidateRange = validateRange(i, i2);
        replaceImpl(i, iValidateRange, iValidateRange - i, str, StringUtils.length(str));
        return this;
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i, int i2, int i3) {
        return replaceImpl(strMatcher, str, i, validateRange(i, i2), i3);
    }

    public StrBuilder replaceAll(char c, char c2) {
        if (c != c2) {
            for (int i = 0; i < this.size; i++) {
                char[] cArr = this.buffer;
                if (cArr[i] == c) {
                    cArr[i] = c2;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceAll(String str, String str2) {
        int length = StringUtils.length(str);
        if (length > 0) {
            int length2 = StringUtils.length(str2);
            int iIndexOf = indexOf(str, 0);
            while (iIndexOf >= 0) {
                replaceImpl(iIndexOf, iIndexOf + length, length, str2, length2);
                iIndexOf = indexOf(str, iIndexOf + length2);
            }
        }
        return this;
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, -1);
    }

    public StrBuilder replaceFirst(char c, char c2) {
        if (c != c2) {
            for (int i = 0; i < this.size; i++) {
                char[] cArr = this.buffer;
                if (cArr[i] == c) {
                    cArr[i] = c2;
                    break;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        int iIndexOf;
        int length = StringUtils.length(str);
        if (length > 0 && (iIndexOf = indexOf(str, 0)) >= 0) {
            replaceImpl(iIndexOf, iIndexOf + length, length, str2, StringUtils.length(str2));
        }
        return this;
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, 1);
    }

    private void replaceImpl(int i, int i2, int i3, String str, int i4) {
        int i5 = (this.size - i3) + i4;
        if (i4 != i3) {
            ensureCapacity(i5);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i2, cArr, i + i4, this.size - i2);
            this.size = i5;
        }
        if (i4 > 0) {
            str.getChars(0, i4, this.buffer, i);
        }
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i, int i2, int i3) {
        if (strMatcher != null && this.size != 0) {
            int length = StringUtils.length(str);
            int i4 = i;
            while (i4 < i2 && i3 != 0) {
                int iIsMatch = strMatcher.isMatch(this.buffer, i4, i, i2);
                if (iIsMatch > 0) {
                    replaceImpl(i4, i4 + iIsMatch, iIsMatch, str, length);
                    i2 = (i2 - iIsMatch) + length;
                    i4 = (i4 + length) - 1;
                    if (i3 > 0) {
                        i3--;
                    }
                }
                i4++;
            }
        }
        return this;
    }

    public StrBuilder reverse() {
        int i = this.size;
        if (i == 0) {
            return this;
        }
        int i2 = i / 2;
        char[] cArr = this.buffer;
        int i3 = i - 1;
        int i4 = 0;
        while (i4 < i2) {
            char c = cArr[i4];
            cArr[i4] = cArr[i3];
            cArr[i3] = c;
            i4++;
            i3--;
        }
        return this;
    }

    public String rightString(int i) {
        if (i <= 0) {
            return "";
        }
        int i2 = this.size;
        if (i >= i2) {
            return new String(this.buffer, 0, i2);
        }
        return new String(this.buffer, i2 - i, i);
    }

    public StrBuilder setCharAt(int i, char c) {
        if (i < 0 || i >= length()) {
            throw new StringIndexOutOfBoundsException(i);
        }
        this.buffer[i] = c;
        return this;
    }

    public StrBuilder setLength(int i) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i2 = this.size;
        if (i < i2) {
            this.size = i;
        } else if (i > i2) {
            ensureCapacity(i);
            Arrays.fill(this.buffer, this.size, i, (char) 0);
            this.size = i;
        }
        return this;
    }

    public StrBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public StrBuilder setNullText(String str) {
        if (StringUtils.isEmpty(str)) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 > this.size) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException(i2 - i);
        }
        return substring(i, i2);
    }

    public String substring(int i) {
        return substring(i, this.size);
    }

    public String substring(int i, int i2) {
        return new String(this.buffer, i, validateRange(i, i2) - i);
    }

    public char[] toCharArray() {
        int i = this.size;
        if (i == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        return (char[]) ArrayUtils.arraycopy(this.buffer, 0, 0, i, (Function<Integer, char[]>) new Function() { // from class: org.apache.commons.lang3.text.StrBuilder$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return StrBuilder.lambda$toCharArray$0((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ char[] lambda$toCharArray$0(Integer num) {
        return new char[num.intValue()];
    }

    public char[] toCharArray(int i, int i2) {
        int iValidateRange = validateRange(i, i2) - i;
        if (iValidateRange == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        return (char[]) ArrayUtils.arraycopy(this.buffer, i, 0, iValidateRange, (Function<Integer, char[]>) new Function() { // from class: org.apache.commons.lang3.text.StrBuilder$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return StrBuilder.lambda$toCharArray$1((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ char[] lambda$toCharArray$1(Integer num) {
        return new char[num.intValue()];
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(this.size);
        sb.append(this.buffer, 0, this.size);
        return sb;
    }

    public StrBuilder trim() {
        int i = this.size;
        if (i == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i2 = 0;
        while (i2 < i && cArr[i2] <= ' ') {
            i2++;
        }
        while (i2 < i && cArr[i - 1] <= ' ') {
            i--;
        }
        int i3 = this.size;
        if (i < i3) {
            delete(i, i3);
        }
        if (i2 > 0) {
            delete(0, i2);
        }
        return this;
    }

    protected void validateIndex(int i) {
        if (i < 0 || i > this.size) {
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    protected int validateRange(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i3 = this.size;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i <= i2) {
            return i2;
        }
        throw new StringIndexOutOfBoundsException("end < start");
    }
}
