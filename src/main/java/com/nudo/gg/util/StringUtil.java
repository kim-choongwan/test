package com.nudo.gg.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
    /**
     * <p>
     * 에러나 이벤트와 관련된 각종 메시지를 로깅하기 위한 Log 오브젝트
     * </p>
     */

    private static Log log = LogFactory.getLog(StringUtil.class);

    private final static char WHITE_SPACE = ' ';

    /**
     * @param str
     * @return
     */
    public static boolean isNull(String str) {

        if (str != null) {
            str = str.trim();
        }

        return (str == null || "".equals(str));
    }

    /**
     * @param str
     * @return
     */
    public static boolean isAlpha(String str) {

        if (str == null) {
            return false;
        }

        int size = str.length();

        if (size == 0)
            return false;

        for (int i = 0; i < size; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param str
     * @return
     */
    public static boolean isAlphaNumeric(String str) {

        if (str == null) {
            return false;
        }

        int size = str.length();

        if (size == 0)
            return false;

        for (int i = 0; i < size; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param integer
     * @return
     */
    public static String integer2string(int integer) {
        return ("" + integer);
    }
    
    /**
     * @param data
     * @return
     */
    public static String long2string(long longdata) {
        return String.valueOf(longdata);
    }
    
    public static String float2string(float floatdata) {
        return String.valueOf(floatdata);
    }
    
    public static String double2string(double doubledata) {
        return String.valueOf(doubledata);
    }
    
    /**
     * @param str
     * @return
     */
    public static String null2void(String str) {

        if (isNull(str)) {
            str = "";
        }

        return str;
    }
    
    /**
     * 입력된 문자열의 소숫점 자리에 .00 처럼 모두 0인경우에 대한 처리 추가
     * 
     * @author ParkJungSik
     * @param str
     * @return
     */
    public static int string2integer(String str) {
        if (isNull(str)) {
            return 0;
        }
        boolean isInteger = true;
        if(str.indexOf(".") > 0) {
            String substring = str.substring(str.indexOf(".")+1, str.length());
            for(int i = 0; i < substring.length(); i++) {
                char charAt = substring.charAt(i);
                if((charAt != '0')) {
                    isInteger = false;
                }
            }
            if(isInteger) {
                str = str.substring(0, str.indexOf("."));
            }
        }

        return Integer.parseInt(str);
    }
    
    /**
     * @param str
     * @return
     */
    public static float string2float(String str) {
        
        if (isNull(str)) {
            return 0.0F;
        }

        return Float.parseFloat(str);
    }
    
    /**
     * @param str
     * @return
     */
    public static double string2double(String str) {

        if (isNull(str)) {
            return 0.0D;
        }

        return Double.parseDouble(str);
    }
    
    /**
     * @param str
     * @return
     */
    public static long string2long(String str) {

        if (isNull(str)) {
            return 0L;
        }

        return Long.parseLong(str);
    }
    
    /**
     * @param str
     * @param defaultValue
     * @return
     */
    public static String null2string(String str, String defaultValue) {

        if (isNull(str)) {
            return defaultValue;
        }

        return str;
    }
    
    /**
     * @param str
     * @param defaultValue
     * @return
     */
    public static String empty2string(String str, String defaultValue) {

        if ("".equals(isNullToString(str))) {
            return defaultValue;
        }

        return str;
    }
    
    /**
     * @param str
     * @param defaultValue
     * @return
     */
    public static int string2integer(String str, int defaultValue) {

        if (isNull(str)) {
            return defaultValue;
        }

        return Integer.parseInt(str);
    }

    /**
     * @param str
     * @param defaultValue
     * @return
     */
    public static float string2float(String str, float defaultValue) {
        
        if (isNull(str)) {
            return defaultValue;
        }

        return Float.parseFloat(str);
    }
    
    /**
     * @param str
     * @param defaultValue
     * @return
     */
    public static double string2double(String str, double defaultValue) {

        if (isNull(str)) {
            return defaultValue;
        }

        return Double.parseDouble(str);
    }
    
    /**
     * @param str
     * @param defaultValue
     * @return
     */
    public static long string2long(String str, long defaultValue) {

        if (isNull(str)) {
            return defaultValue;
        }

        return Long.parseLong(str);
    }
    
    
    /**
     * @param source
     * @param target
     * @return
     */
    public static boolean equals(String source, String target) {

        return null2void(source).equals(null2void(target));

    }
    
    /**
     * @param str
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static String toSubString(String str, int beginIndex, int endIndex) {

        if (equals(str, "")) {
            return str;
        } else if (str.length() < beginIndex) {
            return "";
        } else if (str.length() < endIndex) {
            return str.substring(beginIndex);
        } else {
            return str.substring(beginIndex, endIndex);
        }

    }
    
    /**
     * @param source
     * @param beginIndex
     * @return
     */
    public static String toSubString(String source, int beginIndex) {

        if (equals(source, "")) {
            return source;
        } else if (source.length() < beginIndex) {
            return "";
        } else {
            return source.substring(beginIndex);
        }

    }

    /**
     * @param source
     * @param target
     * @return
     */
    public static int search(String source, String target) {
        int result = 0;
        String strCheck = new String(source);
        for (int i = 0; i < source.length();) {
            int loc = strCheck.indexOf(target);
            if (loc == -1) {
                break;
            } else {
                result++;
                i = loc + target.length();
                strCheck = strCheck.substring(i);
            }
        }
        return result;
    }


    /**
     * @param str
     * @return
     */
    public static String trim(String str) {
        if(str == null)
            return "";
        else
            return str.trim();
    }

    /**
     * @param str
     * @return
     */
    public static String ltrim(String str) {

        int index = 0;

        while (' ' == str.charAt(index++));

        if (index > 0)
            str = str.substring(index - 1);

        return str;
    }

    public static String rtrim(String str) {

        int index = str.length();

        while (' ' == str.charAt(--index));

        if (index < str.length())
            str = str.substring(0, index + 1);

        return str;
    }

    public static String concat(String str1, String str2) {

        StringBuffer sb = new StringBuffer(str1);
        sb.append(str2);

        return sb.toString();
    }
    
    public static String lPad(String str, int len, char pad) {
        return lPad(str, len, pad, false);
    }

    public static String lPad(String str, int len, char pad, boolean isTrim) {

        if (isNull(str)) {
            return null;
        }

        if (isTrim) {
            str = str.trim();
        }

        for (int i = str.length(); i < len; i++) {
            str = pad + str;
        }

        return str;
    }
    
    public static String lPadSpace(int len) {
        String str = "";
        
        for (int k=0; k < len; k++) {
            str += ' ';
        }
        return str;
    }
    
    public static String lPadZero(int len) {
        String str = "";
        
        for (int k=0; k < len; k++) {
            str += '0';
        }
        return str;
    }
    
    public static String rPad(String str, int len, char pad) {
        return rPad(str, len, pad, false);
    }
    
    public static String rPad(String str, int len, char pad, boolean isTrim) {

        if (isNull(str)) {
            return null;
        }

        if (isTrim) {
            str = str.trim();
        }

        for (int i = str.length(); i < len; i++) {
            str = str + pad;
        }

        return str;
    }
    
    public static String alignLeft(String str, int length) {
        return alignLeft(str, length, false);
    }
    
    /**
     * @param str
     * @param length
     * @param isEllipsis
     * @return
     */
    public static String alignLeft(String str, int length, boolean isEllipsis) {

        if (str.length() <= length) {

            StringBuffer temp = new StringBuffer(str);
            for (int i = 0; i < (length - str.length()); i++) {
                temp.append(WHITE_SPACE);
            }
            return temp.toString();
        } else {
            if (isEllipsis) {

                StringBuffer temp = new StringBuffer(length);
                temp.append(str.substring(0, length - 3));
                temp.append("...");

                return temp.toString();
            } else {
                return str.substring(0, length);
            }
        }
    }
    
    public static String alignRight(String str, int length) {

        return alignRight(str, length, false);
    }
    
    public static String alignRight(String str, int length, boolean isEllipsis) {

        if (str.length() <= length) {

            StringBuffer temp = new StringBuffer(length);
            for (int i = 0; i < (length - str.length()); i++) {
                temp.append(WHITE_SPACE);
            }
            temp.append(str);
            return temp.toString();
        } else {
            if (isEllipsis) {

                StringBuffer temp = new StringBuffer(length);
                temp.append(str.substring(0, length - 3));
                temp.append("...");
                return temp.toString();
            } else {
                return str.substring(0, length);
            }
        }
    }
    
    public static String alignCenter(String str, int length) {
        return alignCenter(str, length, false);
    }
    
    public static String alignCenter(String str, int length, boolean isEllipsis) {
        if (str.length() <= length) {

            StringBuffer temp = new StringBuffer(length);
            int leftMargin = (length - str.length()) / 2;

            int rightMargin;
            if ((leftMargin * 2) == (length - str.length())) {
                rightMargin = leftMargin;
            } else {
                rightMargin = leftMargin + 1;
            }

            for (int i = 0; i < leftMargin; i++) {
                temp.append(WHITE_SPACE);
            }

            temp.append(str);

            for (int i = 0; i < rightMargin; i++) {
                temp.append(WHITE_SPACE);
            }

            return temp.toString();
        } else {
            if (isEllipsis) {

                StringBuffer temp = new StringBuffer(length);
                temp.append(str.substring(0, length - 3));
                temp.append("...");
                return temp.toString();
            } else {
                return str.substring(0, length);
            }
        }

    }

    public static String capitalize(String str) {
        return !isNull(str) ? str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase() : str;
    }
    
    /**
     * @param str
     * @param pattern
     * @return
     * @throws Exception
     */
    public static boolean isPatternMatch(String str, String pattern) throws Exception {
        Matcher matcher = Pattern.compile(pattern).matcher(str);
        log.debug("" + matcher);

        return matcher.matches();
    }

    public static String toEng (String kor) throws UnsupportedEncodingException  {
        
        if (isNull(kor)) {
            return null;
        }

        return new String(kor.getBytes("KSC5601"),"8859_1");

    }

    public static String toKor (String en) throws UnsupportedEncodingException {

        if (isNull(en)) {
            return null;
        }

        return new String (en.getBytes("8859_1"), "euc-kr");
    }
    
    public static int countOf(String str, String charToFind) {
        int findLength = charToFind.length();
        int count = 0;

        for (int idx = str.indexOf(charToFind); idx >=0; idx = str.indexOf(charToFind, idx + findLength)) {
            count++;
        }

        return count;
    }
/*
 * StringUtil in Anyframe
 */

    /**
     * Encode a string using algorithm specified in web.xml and return the
     * resulting encrypted password. If exception, the plain credentials string
     * is returned
     * 
     * @param password
     *            Password or other credentials to use in authenticating this
     *            username
     * @param algorithm
     *            Algorithm used to do the digest
     * @return encypted password based on the algorithm.
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();

        MessageDigest md = null;

        try {
            // first create an instance, given the provider
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            log.error("Exception: " + e);

            return password;
        }

        md.reset();

        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);

        // now calculate the hash
        byte[] encodedPassword = md.digest();

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < encodedPassword.length; i++) {
            if ((encodedPassword[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
        }

        return buf.toString();
    }

    /**
     * Encode a string using Base64 encoding. Used when storing passwords as
     * cookies. This is weak encoding in that anyone can use the decodeString
     * routine to reverse the encoding.
     * 
     * @param str
     *            String to be encoded
     * @return String encoding result
     */
    @SuppressWarnings("restriction")
    public static String encodeString(String str) {
//      sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        Base64 encoder = new Base64();
        return new String(encoder.encode(str.getBytes())).trim();
    }

    /**
     * Decode a string using Base64 encoding.
     * 
     * @param str
     *            String to be decoded
     * @return String decoding String
     */
    @SuppressWarnings("restriction")
    public static String decodeString(String str) throws IOException {
//        sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
      Base64 dec = new Base64();
        return new String(dec.decode(str));
    }

    /**
     * convert first letter to a big letter or a small letter.<br>
     * 
     * <pre>
     * StringUtil.trim('Password') = 'password'
     * StringUtil.trim('password') = 'Password'
     * </pre>
     * 
     * @param str
     *            String to be swapped
     * @return String converting result
     */
    public static String swapFirstLetterCase(String str) {
        StringBuffer sbuf = new StringBuffer(str);
        sbuf.deleteCharAt(0);
        if (Character.isLowerCase(str.substring(0, 1).toCharArray()[0])) {
            sbuf.insert(0, str.substring(0, 1).toUpperCase());
        } else {
            sbuf.insert(0, str.substring(0, 1).toLowerCase());
        }
        return sbuf.toString();
    }

    /**
     * If original String has a specific String, remove specific Strings from
     * original String.
     * 
     * <pre>
     * StringUtil.trim('pass*word', '*') = 'password'
     * </pre>
     * 
     * @param origString
     *            original String
     * @param trimString
     *            String to be trimmed
     * @return converting result
     */
    public static String trim(String origString, String trimString) {
        int startPosit = origString.indexOf(trimString);
        if (startPosit != -1) {
            int endPosit = trimString.length() + startPosit;
            return origString.substring(0, startPosit)
                    + origString.substring(endPosit);
        }
        return origString;
    }

    /**
     * Break a string into specific tokens and return a String of last location.
     * 
     * <pre>
     * StringUtil.getLastString('password*password*a*b*c', '*') = 'c'
     * </pre>
     * 
     * @param origStr
     *            original String
     * @param strToken
     *            specific tokens
     * @return String of last location
     */
    public static String getLastString(String origStr, String strToken) {
        StringTokenizer str = new StringTokenizer(origStr, strToken);
        String lastStr = "";
        while (str.hasMoreTokens()) {
            lastStr = str.nextToken();
        }
        return lastStr;
    }

    /**
     * If original String has token, Break a string into specific tokens and
     * change String Array. If not, return a String Array which has original
     * String as it is.
     * 
     * <pre>
     * StringUtil.getStringArray('passwordabcpassword', 'abc')      = String[]{'password','password'}
     * StringUtil.getStringArray('pasword*password', 'abc')         = String[]{'pasword*password'}
     * </pre>
     * 
     * @param str
     *            original String
     * @param strToken
     *            specific String token
     * @return String[]
     */
    public static String[] getStringArray(String str, String strToken) {
        if (str.indexOf(strToken) != -1) {
            StringTokenizer st = new StringTokenizer(str, strToken);
            String[] stringArray = new String[st.countTokens()];
            for (int i = 0; st.hasMoreTokens(); i++) {
                stringArray[i] = st.nextToken();
            }
            return stringArray;
        }
        return new String[] { str };
    }

    /**
     * If string is null or empty string, return false. <br>
     * If not, return true.
     * 
     * <pre>
     * StringUtil.isNotEmpty('')        = false
     * StringUtil.isNotEmpty(null)      = false
     * StringUtil.isNotEmpty('abc')     = true
     * </pre>
     * 
     * @param str
     *            original String
     * @return which empty string or not.
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    

    /**
     * If string is null or empty string, return true. <br>
     * If not, return false.
     * 
     * <pre>
     * StringUtil.isEmpty('')       = true
     * StringUtil.isEmpty(null)     = true
     * StringUtil.isEmpty('abc')    = false
     * </pre>
     * 
     * @param str
     *            original String
     * @return which empty string or not.
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    /**
     * If object is null or empty string, return true. <br>
     * If not, return false.
     * <pre>
     * StringUtil.isEmptyOrNull('')         = true
     * StringUtil.isEmptyOrNull(null)       = true
     * StringUtil.isEmptyOrNull('abc')  = false
     * </pre>
     * 객체가 null인지 확인 후 null인 경우 "" 로 바꾸고, "" 이면 true
     * @param object 원본 객체
     * @return resultVal 문자열
     */
    public static Boolean isEmptyOrNull(Object object) {
        
        String string = "";
        if (object != null) {
            string = object.toString().trim();
        }
        
        if(string.equals("")){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * If object is null or empty string, return true. <br>
     * If not, return false.
     * <pre>
     * StringUtil.isEmptyOrNull('')         = false
     * StringUtil.isEmptyOrNull(null)       = false
     * StringUtil.isEmptyOrNull('abc')  = true
     * </pre>
     * 객체가 null인지 확인 후 null인 경우 "" 로 바꾸고, "" 이면 false
     * @param object 원본 객체
     * @return resultVal 문자열
     */
    public static Boolean isNotEmptyOrNull(Object object) {
        
        String string = "";
        if (object != null) {
            string = object.toString().trim();
        }
        
        if(string.equals("")){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * replace replaced string to specific string from original string. <br>
     * 
     * <pre>
     * StringUtil.replace('work$id', '$', '.')  = 'work.id'
     * </pre>
     * 
     * @param str
     *            original String
     * @param replacedStr
     *            to be replaced String
     * @param replaceStr
     *            replace String
     * @return converting result
     */
    public static String replace(String str, String replacedStr,
            String replaceStr) {
        String newStr = "";
        if (str.indexOf(replacedStr) != -1) {
            String s1 = str.substring(0, str.indexOf(replacedStr));
            String s2 = str.substring(str.indexOf(replacedStr) + 1);
            newStr = s1 + replaceStr + s2;
        }
        return newStr;
    }

    /**
     * It converts the string representation of a number to integer type (eg.
     * '27' -> 27)
     * 
     * <pre>
     * StringUtil.string2integer('14')  = 14
     * </pre>
     * 
     * @param str
     *            string representation of a number
     * @return integer integer type of string
     *
    public static int string2integer(String str) {
        int ret = Integer.parseInt(str.trim());

        return ret;
    }

    /**
     * It converts integer type to String ( 27 -> '27')
     * 
     * <pre>
     * StringUtil.integer2string(14)    = '14'
     * </pre>
     * 
     * @param integer
     *            integer type
     * @return String string representation of a number
     *
    public static String integer2string(int integer) {
        return ("" + integer);
    }

    /**
     * It returns true if str matches the pattern string. It performs regular
     * expression pattern matching.
     * 
     * <pre>
     * StringUtil.isPatternMatching('abc-def', '*-*')   = true
     * StringUtil.isPatternMatching('abc', '*-*')   = false
     * </pre>
     * 
     * @param str
     *            original String
     * @param pattern
     *            pattern String
     * @return boolean which matches the pattern string or not.
     * @throws Exception
     *             fail to check pattern matched
     */
    public static boolean isPatternMatching(String str, String pattern)
            throws Exception {
        // if url has wild key, i.e. "*", convert it to ".*" so that we can
        // perform regex matching
        if (pattern.indexOf('*') >= 0) {
            pattern = pattern.replaceAll("\\*", ".*");
        }

        pattern = "^" + pattern + "$";

        return Pattern.matches(pattern, str);
    }

    /**
     * It returns true if string contains a sequence of the same character.
     * 
     * <pre>
     * StringUtil.containsMaxSequence('password', '2')  = true
     * StringUtil.containsMaxSequence('my000', '3')     = true
     * StringUtil.containsMaxSequence('abbbbc', '5')    = false
     * </pre>
     * 
     * @param str
     *            original String
     * @param maxSeqNumber
     *            a sequence of the same character
     * @return which contains a sequence of the same character
     */
    public static boolean containsMaxSequence(String str, String maxSeqNumber) {
        int occurence = 1;
        int max = string2integer(maxSeqNumber);
        if (str == null) {
            return false;
        }

        int sz = str.length();
        for (int i = 0; i < (sz - 1); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                occurence++;

                if (occurence == max)
                    return true;
            } else {
                occurence = 1;
            }
        }
        return false;
    }

    /**
     * <p>
     * Checks that the String contains certain characters.
     * </p>
     * <p>
     * A <code>null</code> String will return <code>false</code>. A
     * <code>null</code> invalid character array will return
     * <code>false</code>. An empty String ("") always returns false.
     * </p>
     * 
     * <pre>
     * StringUtil.containsInvalidChars(null, *)                 = false
     * StringUtil.containsInvalidChars(*, null)                 = false
     * StringUtil.containsInvalidChars(&quot;&quot;, *)         = false
     * StringUtil.containsInvalidChars(&quot;ab&quot;, '')      = false
     * StringUtil.containsInvalidChars(&quot;abab&quot;, 'xyz') = false
     * StringUtil.containsInvalidChars(&quot;ab1&quot;, 'xyz')  = false
     * StringUtil.containsInvalidChars(&quot;xbz&quot;, 'xyz')  = true
     * </pre>
     * 
     * @param str
     *            the String to check, may be null
     * @param invalidChars
     *            an array of invalid chars, may be null
     * @return false if it contains none of the invalid chars, or is null
     */

    public static boolean containsInvalidChars(String str, char[] invalidChars) {
        if (str == null || invalidChars == null) {
            return false;
        }
        int strSize = str.length();
        int validSize = invalidChars.length;
        for (int i = 0; i < strSize; i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < validSize; j++) {
                if (invalidChars[j] == ch) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>
     * Checks that the String contains certain characters.
     * </p>
     * <p>
     * A <code>null</code> String will return <code>false</code>. A
     * <code>null</code> invalid character array will return
     * <code>false</code>. An empty String ("") always returns false.
     * </p>
     * 
     * <pre>
     * StringUtil.containsInvalidChars(null, *)                 = false
     * StringUtil.containsInvalidChars(*, null)                 = false
     * StringUtil.containsInvalidChars(&quot;&quot;, *)         = false
     * StringUtil.containsInvalidChars(&quot;ab&quot;, '')      = false
     * StringUtil.containsInvalidChars(&quot;abab&quot;, 'xyz') = false
     * StringUtil.containsInvalidChars(&quot;ab1&quot;, 'xyz')  = false
     * StringUtil.containsInvalidChars(&quot;xbz&quot;, 'xyz')  = true
     * </pre>
     * 
     * @param str
     *            the String to check, may be null
     * @param invalidChars
     *            a String of invalid chars, may be null
     * @return false if it contains none of the invalid chars, or is null
     */
    public static boolean containsInvalidChars(String str, String invalidChars) {
        if (str == null || invalidChars == null) {
            return true;
        }
        return containsInvalidChars(str, invalidChars.toCharArray());
    }

    /**
     * <p>
     * Checks if the String contains only unicode letters or digits.
     * </p>
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String
     * ("") will return <code>false</code>.
     * </p>
     * 
     * <pre>
     * StringUtil.isAlphaNumeric(null)               = false
     * StringUtil.isAlphaNumeric(&quot;&quot;)     = false
     * StringUtil.isAlphaNumeric(&quot;  &quot;)   = false
     * StringUtil.isAlphaNumeric(&quot;abc&quot;)  = true
     * StringUtil.isAlphaNumeric(&quot;ab c&quot;) = false
     * StringUtil.isAlphaNumeric(&quot;ab2c&quot;) = true
     * StringUtil.isAlphaNumeric(&quot;ab-c&quot;) = false
     * </pre>
     * 
     * @param str
     *            the String to check, may be null
     * @return <code>true</code> if only contains letters or digits, and is
     *         non-null
     *
    public static boolean isAlphaNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        if (sz == 0)
            return false;
        for (int i = 0; i < sz; i++) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Checks if the String contains only unicode letters.
     * </p>
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String
     * ("") will return <code>false</code>.
     * </p>
     * 
     * <pre>
     * StringUtil.isAlpha(null)             = false
     * StringUtil.isAlpha(&quot;&quot;)     = false
     * StringUtil.isAlpha(&quot;  &quot;)   = false
     * StringUtil.isAlpha(&quot;abc&quot;)  = true
     * StringUtil.isAlpha(&quot;ab2c&quot;) = false
     * StringUtil.isAlpha(&quot;ab-c&quot;) = false
     * </pre>
     * 
     * @param str
     *            the String to check, may be null
     * @return <code>true</code> if only contains letters, and is non-null
     *
    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        if (sz == 0)
            return false;
        for (int i = 0; i < sz; i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Checks if the String contains only unicode digits. A decimal point is not
     * a unicode digit and returns false.
     * </p>
     * <p>
     * <code>null</code> will return <code>false</code>. An empty String
     * ("") will return <code>false</code>.
     * </p>
     * 
     * <pre>
     * StringUtil.isNumeric(null)              = false
     * StringUtil.isNumeric(&quot;&quot;)     = false
     * StringUtil.isNumeric(&quot;  &quot;)   = false
     * StringUtil.isNumeric(&quot;123&quot;)  = true
     * StringUtil.isNumeric(&quot;12 3&quot;) = false
     * StringUtil.isNumeric(&quot;ab2c&quot;) = false
     * StringUtil.isNumeric(&quot;12-3&quot;) = false
     * StringUtil.isNumeric(&quot;12.3&quot;) = false
     * </pre>
     * 
     * @param str
     *            the String to check, may be null
     * @return <code>true</code> if only contains digits, and is non-null
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        if (sz == 0)
            return false;
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Reverses a String as per {@link StringBuffer#reverse()}.
     * </p>
     * <p>
     * <A code>null</code> String returns <code>null</code>.
     * </p>
     * 
     * <pre>
     * StringUtil.reverse(null)            = null
     * StringUtil.reverse(&quot;&quot;)    = &quot;&quot;
     * StringUtil.reverse(&quot;bat&quot;) = &quot;tab&quot;
     * </pre>
     * 
     * @param str
     *            the String to reverse, may be null
     * @return the reversed String, <code>null</code> if null String input
     */

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * Make a new String that filled original to a special char as cipers
     * 
     * @param originalStr
     *            original String
     * @param ch
     *            a special char
     * @param cipers
     *            cipers
     * @return filled String
     */
    public static String fillString(String originalStr, char ch, int cipers) {
        int originalStrLength = originalStr.length();

        if (cipers < originalStrLength)
            return null;

        int difference = cipers - originalStrLength;

        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < difference; i++)
            strBuf.append(ch);

        strBuf.append(originalStr);
        return strBuf.toString();
    }

    /**
     * Determine whether a (trimmed) string is empty
     * 
     * @param foo
     *            The text to check.
     * @return Whether empty.
     */
    public static final boolean isEmptyTrimmed(String foo) {
        return (foo == null || foo.trim().length() == 0);
    }

    /**
     * Return token list
     * 
     * @param lst
     * @param separator
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List getTokens(String lst, String separator) {
        List tokens = new ArrayList();

        if (lst != null) {
            StringTokenizer st = new StringTokenizer(lst, separator);
            while (st.hasMoreTokens()) {
                try {
                    String en = st.nextToken().trim();
                    tokens.add(en);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return tokens;
    }

    /**
     * Return token list which is separated by ","
     * 
     * @param lst
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List getTokens(String lst) {
        return getTokens(lst, ",");
    }

    /**
     * This method convert "string_util" to "stringUtil"
     * 
     * @param String
     *            targetString
     * 
     * @param char
     *            posChar
     * 
     * @return String result
     */
    public static String convertToCamelCase(String targetString, char posChar) {
        StringBuffer result = new StringBuffer();
        boolean nextUpper = false;
        String allLower = targetString.toLowerCase();
        
        for (int i = 0; i < allLower.length(); i++) {
            char currentChar = allLower.charAt(i);
            if (currentChar == posChar) {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    currentChar = Character.toUpperCase(currentChar);
                    nextUpper = false;
                }
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    /**
     * Convert a string that may contain underscores to camel case.
     * 
     * @param underScore
     *            Underscore name.
     * @return Camel case representation of the underscore string.
     */
    public static String convertToCamelCase(String underScore) {
        return convertToCamelCase(underScore, '_');
    }

    /**
     * Convert a camel case string to underscore representation.
     * 
     * @param camelCase
     *            Camel case name.
     * @return Underscore representation of the camel case string.
     */
    public static String convertToUnderScore(String camelCase) {
        String result = "";
        for (int i = 0; i < camelCase.length(); i++) {
            char currentChar = camelCase.charAt(i);
            // This is starting at 1 so the result does not end up with an
            // underscore at the begin of the value
            if (i > 0 && Character.isUpperCase(currentChar)) {
                result = result.concat("_");
            }
            result = result.concat(Character.toString(currentChar)
                    .toLowerCase());
        }
        return result;
    }
    
     /**
     * 객체가 null인지 확인하고 null인 경우 "" 로 바꾸는 메서드
     * @param object 원본 객체
     * @return resultVal 문자열
     */
    public static String isNullToString(Object object) {
        String string = "";
        
        if (object != null) {
            string = object.toString().trim();
        }
        
        return string;
    }
  
    public static String isNullToString(Object object,String defaultvalue) {
        String string = "";
        
        if (object != null) {
            string = object.toString().trim();
        } else {
            string = defaultvalue;
        }
        return string;
    }
  
    
    /**
     * 길이 만큼 문자열을 랜덤으로 만들어 줍니다.
     * 
     * @param length
     * @return
     */
    public static String getRandomString(int length) {         
        StringBuffer buffer = new StringBuffer();         
        Random random = new Random();                   
        String chars[] = "1,2,3,4,5,6,7,8,9,0".split(",");                   
        for ( int i=0 ; i<length ; i++ ) {             
            buffer.append(chars[random.nextInt(chars.length)]);         
        }         
        
        return buffer.toString();     
    }
    
    /**
     * 문자열의 길이를 return 합니다.
     * 
     * @param string
     * @return
     */
    public static int getStringLength(String str) {         
        int len = 0;
        
        len = str.length();
        
        return len;     
    }
    
    /**
     * Stirng ReplaceAll
     * 
     * @param original
     * @param patten
     * @param replace
     * @return
     */
    public static String replaceAll(String original, String patten, String replace) {
        return original.replaceAll(patten, replace);
    }
    
    /**
     * 배열에 공백 및 NULL 제거
     * @param str
     * @return
     * @author 강윤철
     */
    public static String[] trimString(String[] str) {
            
        //초기화할 배열 갯수 구함
        int m = 0;
        for(int k = 0; k < str.length; k++) {
            if(!str[k].equals("") && str[k] != null) {
                m++;
            }
        }
        
        //배열 초기화
        String[] result = new String[m];
        
        //공백제거후 배열 담기
        int n = 0;
        for(int k = 0; k < str.length; k++) {
            if(!str[k].equals("") && str[k] != null) {
                result[n] = str[k];
                n++;
            }
        }
        
        //결과값 리턴
        return result;
    }
    
    /**
     * 3자리에 마다 콤마 찍기
     * 
     * @param str
     * @return
     */
    public static String comma(String str) {
        return new java.text.DecimalFormat("#,###").format(string2double(str));
    }
    
    /**
     * Split후 원하는 위치의 문자열을 리턴해 줍니다.
     * 
     * @param str 원본문자열
     * @param splitChar Split 기준 문자열
     * @param index 원하는 위치 (1부터시작)
     * @return
     */
    public static String splitToString(String str, String splitChar, int index) {
        if (StringUtil.isNullToString(str).length()==0) {
            return "";
        } else {
            String[] strSplit = str.split(splitChar);
            
            if (strSplit.length < index) {
                return "";
            } else {
                return strSplit[index-1];
            }
        }
    }
    
    /**
     * TEXT스트링을 HTML형식으로 변경해 줍니다.
     * 
     * @param str
     * @return
     */
    public static String textToHTML(String str) {
        if (StringUtil.isNullToString(str).length()==0) {
            return str;
        } else {
            str = str.replaceAll("&", "&amp;");
            str = str.replaceAll("<", "&lt;");
            str = str.replaceAll(">", "&gt;");
            str = str.replaceAll("\t", "&nbsp; &nbsp; &nbsp; &nbsp;");
            str = str.replaceAll("  ", "&nbsp;");
            str = str.replaceAll("\n", "<br/>");
            
            return str;
        }
    }
    
    /**
     * TEXT스트링을 대문자 형식으로 변경해 줍니다.
     * @param str
     * @return
     */
    public static String textToUpperCase(String str) {
        return str.toUpperCase();
    }
    
    /**
     * idx 이상 문자를 원하는 문자로 원래 문자 자릿수만큼 채워줌
     * ex) imjehoon -> imje****  
     *     ognStr : imjehoon
     *     replaceStr : *
     *     idx : 4
     * @param ognStr : 기존 문자
     * @param replaceStr : 변환할 문자
     * @param idx : 자리수
     * @return
     */
    public static String textToReplace(String ognStr, String replaceStr, int idx) {
        if(ognStr == null || "".equals(ognStr) || idx < 0) return ognStr;
        if( idx == 0 || ognStr.length() < idx) {
            return ognStr;
        }
        
        String rtnStr = ognStr.substring(0,idx);
        int replaceLength = ognStr.length() - rtnStr.length();
        
        StringBuffer sb = new StringBuffer(rtnStr);
        for(int i = 0; i < replaceLength; i++) {
            sb.append(replaceStr);
        }
        
        return sb.toString();
    }
    
    public static String printStackTraceToString(Throwable t){
        if(t == null) return "";
        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            t.printStackTrace(new PrintStream(bout));
            bout.flush();
            String error = new String(bout.toByteArray());

            return error;
        }catch(Exception ex){
            return "";
        }
    }
    
    /**
     * XSS방지
     * @param value
     * @return
     */
    public static String cleanXSS(String value) {
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        value = value.replaceAll("&", "&amp;");
        value = value.replaceAll("\t", "&nbsp; &nbsp; &nbsp; &nbsp;");
        value = value.replaceAll("  ", "&nbsp;");
        value = value.replaceAll("\n", "<br/>");
        return value;
    }
    
    /**
     * If string is null or empty string, return default value <br>
     * If not, return first parameter string.
     * 
     * <pre>
     * StringUtil.isEmptySetDefault('','example')       = 'example'
     * StringUtil.isEmptySetDefault(null,'example')     = 'example'
     * StringUtil.isEmptySetDefault('abc','example')    = 'abc'
     * </pre>
     * 
     * @param str
     *            original String
     * @param defaultValue
     *            default String          
     * @return which empty string or not.
     */
    public static String isEmptySetDefault(String str,String defaultValue){
        if(isEmpty(str)){
            str = defaultValue;
        }
        return str;
    }
    
    /**
     * 바이트를 체크한다. 기준보다 크면 false, 작거나 같으면 true
     * 
     * SMS 문자 발송시 체크
     * @param txt 체크할 text
     * @param standardByte 기준 바이트 수
     * @return 
     */
    public static boolean byteCheck(String txt, int standardByte) {
        if("".equals(isNullToString(txt))) { return true; }
 
        // 바이트 체크 (영문 1, 한글 2, 특문 1)
        int en = 0;
        int ko = 0;
        int etc = 0;
 
        char[] txtChar = txt.toCharArray();
        for (int j = 0; j < txtChar.length; j++) {
            if (txtChar[j] >= 'A' && txtChar[j] <= 'z') {
                en++;
            // \uAC00(가) ~ \uD7A3(힣) 사이
            } else if (txtChar[j] >= '\uAC00' && txtChar[j] <= '\uD7A3') {
                ko++;
                ko++;
            } else { 
                etc++;
            }
        }
 
        int txtByte = en + ko + etc;
        
        if (txtByte > standardByte) {
            return false;
        } else {
            return true;
        }
    }
}
