package url;

import io.netty.util.HashingStrategy;
import io.netty.util.internal.MathUtil;
import org.jetbrains.annotations.Contract;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class AsciiString implements CharSequence, Comparable<CharSequence> {

    public static final AsciiString EMPTY_STRING = cached("");
    private static final char MAX_CHAR_VALUE = 'ÿ';
    public static final int INDEX_NOT_FOUND = -1;
    private final byte[] value;
    private final int offset;
    private final int length;
    private int hash;
    private String string;
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() {
        public int hashCode (CharSequence o) {
            return AsciiString.hashCode(o);
        }

        public boolean equals (CharSequence LHS, CharSequence RHS) {
            return AsciiString.contentEqualsIgnoreCase(LHS, RHS);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() {
        public int hashCode (CharSequence o) {
            return AsciiString.hashCode(o);
        }

        public boolean equals (CharSequence LHS, CharSequence RHS) {
            return AsciiString.contentEquals(LHS,RHS);
        }
    };

    public AsciiString(byte[] value){
        this(value, true);
    }

    public AsciiString(byte[] value, boolean copy){
        this((byte[])value, 0, value.length, copy);
    }

    public AsciiString(byte[] value, int start, int length, boolean copy){
        if (copy) {
            this.value = Arrays.copyOfRange(value, start, start + length);
            this.offset = 0x0;
        } else {
            if (MathUtil.isOutOfBounds(start, length, value.length)){
                throw new IndexOutOfBoundsException("expected: 0 <= start(" + start + ") <= start + length(" + length + ") <= value" +
                        ".length(" + value.length + ')');
            }
            this.value = value;
            this.offset = offset;
        }
        this.length = length;
    }

    public AsciiString(ByteBuffer value) {
        this (value, true);
    }

    public AsciiString(ByteBuffer value, boolean copy) {
        this(value, value.position(), value.remaining(), copy);
    }

    public static int indexOf(CharSequence cs, char searchCar, int start);

    private static boolean equalsIgnoreCase(byte lhs, byte rhs) {
        return lhs == rhs || toLowerCase(lhs) == toLowerCase(rhs);
    }
    private static boolean equalsIgnoreCase(char lhs, char rhs) {
        return lhs == rhs || toLowerCase(lhs) == toLowerCase(rhs);
    }

    private static byte toLowerCase(byte b){
        return isUpperCase(b) ? (byte)(b + 0x20) : b;
    }

    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c + 0x20) : c;
    }

    private static byte toUpperCase(byte b) {
        return isLowerCase(b) ? (byte)(b- 0x20) : b;
    }

    private static boolean isLowerCase(byte value){
        return value >= 97 && value <= 122;
    }

    private static boolean isLowerCase(char value){
        return value >= 'a' && value <= 'z';
    }

    public static boolean isUpperCase(byte value) {
        return value >= 65 && value <= 90;
    }

    public static boolean isUpperCase(char value) {
        return value >= 'A' && value <= 'Z';
    }

    public static byte c2b(char c) {
        return (byte)(c > 0xff ? 0x3f : c);
    }

    private static byte c2b0(char c){
        return (byte)c;
    }

    public static char b2c(byte b) {
        return (char) (b & 0xff);
    }

    private static final class GeneralCaseInsenstiveCharEqualityComparator implements CharEqualityComparator {
        static final GeneralCaseInsenstiveCharEqualityComparator INSTANCE =
                new GeneralCaseInsenstiveCharEqualityComparator();

        private GeneralCaseInsenstiveCharEqualityComparator() {}

        public boolean equals(char lhs, char rhs) {
            return Character.toUpperCase(lhs) == Character.toUpperCase(rhs);
        }
    }

    private static final class AsciiCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE =
                new AsciiCaseInsensitiveCharEqualityComparator();

        private AsciiCaseInsensitiveCharEqualityComparator(){}

        public boolean equals(char lhs, char rhs) {
            return AsciiString.equalsIgnoreCase(lhs, rhs);
        }
    }

    private static final class DefaultCharEqualityComparator implements CharEqualityComparator {

        static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();
        private DefaultCharEqualityComparator(){}
        public boolean equals(char LHS, char RHS) {
            return LHS == RHS;
        }
    }

    private interface CharEqualityComparator {
        boolean equals(char vLHS, char vRHS);
    }
}
