package wox.serial;

/**
 * This class provides methods to encode and decode byte arrays to
 * and from base64 encoding.
 * @author Carlos Roberto Jaimez Gonzalez
 * Created: 10th January 2005
 * @version 1.0
 * Acknowledgements: some of the code was taken from the web site
 *                  "http://iharder.sourceforge.net/base64/". The code was
 *                  modified, adapted and fully commented by Carlos Jaimez
 */
public class EncodeBase64 {

    //Maximum line length for Base64 (according to specification)
    private final static int MAX_LINE_LENGTH = 76;

    //The equals character used as padding character
    private final static byte EQUALS_CHAR = (byte) '=';

    //The new line character used to break lines
    private final static byte NEW_LINE_CHAR = (byte) '\n';

    //The array with the 64 values for Base64 encoding. The values are
    //ordered according to their corresponding value in the table Base64.
    //Example: 'A' corresponds to 0, 'B' corresponds to 1, and so on.
    private final static byte[] TABLE64 = { (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F', (byte) 'G', (byte) 'H', (byte) 'I', (byte) 'J', (byte) 'K', (byte) 'L', (byte) 'M', (byte) 'N', (byte) 'O', (byte) 'P', (byte) 'Q', (byte) 'R', (byte) 'S', (byte) 'T', (byte) 'U', (byte) 'V', (byte) 'W', (byte) 'X', (byte) 'Y', (byte) 'Z', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f', (byte) 'g', (byte) 'h', (byte) 'i', (byte) 'j', (byte) 'k', (byte) 'l', (byte) 'm', (byte) 'n', (byte) 'o', (byte) 'p', (byte) 'q', (byte) 'r', (byte) 's', (byte) 't', (byte) 'u', (byte) 'v', (byte) 'w', (byte) 'x', (byte) 'y', (byte) 'z', (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7', (byte) '8', (byte) '9', (byte) '+', (byte) '/' };

    //The array to be used for translating a Base64 value to its corresponding
    //value in the Base64 table, or a negative number indicating a White space
    //(-5) or the Equals character (-1). Example: The character 'A' corresponds
    //to the 65th position in this array (ASCII 65), and the array contains the
    //value '0' in that position, which is the corresponding value for the
    //character 'A' according to the Base64 specification
    private final static byte[] DECODE_TABLE64 = { // Decimal  0 -  8
    // Decimal  0 -  8
    -9, // Decimal  0 -  8
    -9, // Decimal  0 -  8
    -9, // Decimal  0 -  8
    -9, // Decimal  0 -  8
    -9, // Decimal  0 -  8
    -9, // Decimal  0 -  8
    -9, // Decimal  0 -  8
    -9, // Whitespace: Tab and Linefeed
    -9, // Whitespace: Tab and Linefeed
    -5, // Decimal 11 - 12
    -5, // Decimal 11 - 12
    -9, // Whitespace: Carriage Return
    -9, // Decimal 14 - 26
    -5, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 14 - 26
    -9, // Decimal 27 - 31
    -9, // Decimal 27 - 31
    -9, // Decimal 27 - 31
    -9, // Decimal 27 - 31
    -9, // Decimal 27 - 31
    -9, // Whitespace: Space
    -9, // Decimal 33 - 42
    -5, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Decimal 33 - 42
    -9, // Plus sign at decimal 43
    -9, // Decimal 44 - 46
    62, // Decimal 44 - 46
    -9, // Decimal 44 - 46
    -9, // Slash "/" at decimal 47
    -9, // Numbers zero through nine
    63, // Numbers zero through nine
    52, // Numbers zero through nine
    53, // Numbers zero through nine
    54, // Numbers zero through nine
    55, // Numbers zero through nine
    56, // Numbers zero through nine
    57, // Numbers zero through nine
    58, // Numbers zero through nine
    59, // Numbers zero through nine
    60, // Decimal 58 - 60
    61, // Decimal 58 - 60
    -9, // Decimal 58 - 60
    -9, // Equals sign "=" at decimal 61
    -9, // Decimal 62 - 64
    -1, // Decimal 62 - 64
    -9, // Decimal 62 - 64
    -9, // Letters 'A' through 'N'
    -9, // Letters 'A' through 'N'
    0, // Letters 'A' through 'N'
    1, // Letters 'A' through 'N'
    2, // Letters 'A' through 'N'
    3, // Letters 'A' through 'N'
    4, // Letters 'A' through 'N'
    5, // Letters 'A' through 'N'
    6, // Letters 'A' through 'N'
    7, // Letters 'A' through 'N'
    8, // Letters 'A' through 'N'
    9, // Letters 'A' through 'N'
    10, // Letters 'A' through 'N'
    11, // Letters 'A' through 'N'
    12, // Letters 'O' through 'Z'
    13, // Letters 'O' through 'Z'
    14, // Letters 'O' through 'Z'
    15, // Letters 'O' through 'Z'
    16, // Letters 'O' through 'Z'
    17, // Letters 'O' through 'Z'
    18, // Letters 'O' through 'Z'
    19, // Letters 'O' through 'Z'
    20, // Letters 'O' through 'Z'
    21, // Letters 'O' through 'Z'
    22, // Letters 'O' through 'Z'
    23, // Letters 'O' through 'Z'
    24, // Decimal 91 - 96
    25, // Decimal 91 - 96
    -9, // Decimal 91 - 96
    -9, // Decimal 91 - 96
    -9, // Decimal 91 - 96
    -9, // Decimal 91 - 96
    -9, // Letters 'a' through 'm'
    -9, // Letters 'a' through 'm'
    26, // Letters 'a' through 'm'
    27, // Letters 'a' through 'm'
    28, // Letters 'a' through 'm'
    29, // Letters 'a' through 'm'
    30, // Letters 'a' through 'm'
    31, // Letters 'a' through 'm'
    32, // Letters 'a' through 'm'
    33, // Letters 'a' through 'm'
    34, // Letters 'a' through 'm'
    35, // Letters 'a' through 'm'
    36, // Letters 'a' through 'm'
    37, // Letters 'n' through 'z'
    38, // Letters 'n' through 'z'
    39, // Letters 'n' through 'z'
    40, // Letters 'n' through 'z'
    41, // Letters 'n' through 'z'
    42, // Letters 'n' through 'z'
    43, // Letters 'n' through 'z'
    44, // Letters 'n' through 'z'
    45, // Letters 'n' through 'z'
    46, // Letters 'n' through 'z'
    47, // Letters 'n' through 'z'
    48, // Letters 'n' through 'z'
    49, // Letters 'n' through 'z'
    50, // Decimal 123 - 126
    51, // Decimal 123 - 126
    -9, // Decimal 123 - 126
    -9, // Decimal 123 - 126
    -9, -9 };

    // Indicates white space in encoding
    private final static byte WHITE_SPACE_ENC = -5;

    // Indicates equals sign in encoding
    private final static byte EQUALS_SIGN_ENC = -1;

    public EncodeBase64() {
    }

    //Constructor
    //--------------------------------------------------------------------------------------------
    //Public encode method
    /**
     * This method encodes an array of bytes to Base64.
     * @param source: byte[] the original array of bytes to be converted
     * @return byte[] the encoded array of bytes
     * Author: Carlos Roberto Jaimez Gonzalez
     * Email: crjaim@essex.ac.uk
     * Created: 10th January 2005
     */
    public static byte[] encode(byte[] source) {
        //the length of the original array
        int len = source.length;
        //the offset. Where conversion should start
        int off = 0;
        //specified options
        int options = 0;
        //determine the length for the target array
        int newLen = len * 4 / 3;
        //System.out.println("newLen: " + newLen);
        //determine if the length of the original array is module 3
        int padding = 0;
        if ((len % 3) == 1) {
            //System.out.println("len % 3 is 1");
            padding = 3;
        }
        if ((len % 3) == 2) {
            //System.out.println("len % 3 is 2");
            padding = 2;
        }
        //System.out.println("padding: " + padding);
        //determine the number of break lines to be added
        int breaks = newLen / 76;
        //System.out.println("breaks: " + breaks);
        //determine the real size for the encoded array
        int finalSize = newLen + padding + breaks;
        //System.out.println("finalSize: " + finalSize);
        //the encoded array
        byte[] encodedArray = new byte[finalSize];
        //to keep track of the position in the original array of bytes
        int i = 0;
        //to keep track of the position in the new array of bytes (encoded array)
        int j = 0;
        //this variable is to avoid going out of the limits of the array when
        //the number of bytes is not module of 3
        //this is taken care in the "if" statement after the "for" statement
        int len2 = len - 2;
        int lineLength = 0;
        //increments d by 3 (because the algorithm takes 3 bytes to be coneverted), and
        //increments e by 4 (because the 3 bytes are represented using 4 bytes in base64)
        //the "for" loop goes through the original array taking 3 bytes at a time, and
        //converting them into 4 bytes into the encoded array. It takes care of the break lines
        for (i = 0; i < len2; i += 3, j += 4) {
            //encode from the "source" array, starting in the position "i" the next "3" bytes,
            //and write the encoded bytes to the "encodedArray" starting in the position "j"
            encode3Bytes(source, i, 3, encodedArray, j);
            //increments by 4 because we have added 4 bytes
            lineLength += 4;
            //if the line has reached the 76 characters, then add '\n'
            if (lineLength == MAX_LINE_LENGTH) {
                encodedArray[j + 4] = NEW_LINE_CHAR;
                //increments e by 1 because of the new line character, and reset lineLength
                j++;
                lineLength = 0;
            }
            // end if: lineLength = 76
        }
        // end for
        //If the array has more elements, it will be necessary to add
        //some padding characters (it can have 1 or 2 more elements)
        if (i < len) {
            //encode from the "source" array, starting in the position "i" the next "len-i" bytes,
            //and write the encoded bytes to the "encodedArray" starting in the position "j"
            //As this is he last sentence, the number of bytes to be encoded can be 1 or 2
            encode3Bytes(source, i, len - i, encodedArray, j);
            j += 4;
        }
        // end if
        return encodedArray;
    }

    //encode
    //--------------------------------------------------------------------------------------------
    //Private encode method (used by the public encode method)
    /**
     * This method encodes 3 bytes from the source array to 4 bytes into the
     * target array. The bytes taken from the source array start in the position
     * specified by sourceOff; and the 4 bytes to be written to the target array
     * start in the position specified by targetOff. The method also receives a
     * numBytes integer specifying the number of bytes to be taken from the
     * source array (this number can be 3,2 or 1). numBytes can be 1 or 2 only
     * in situations when the total number of bytes is not divisible by 3.
     * @param source byte[] - the array of bytes to be encoded
     * @param sourceOff int - the position in the source array
     * @param numBytes int - the number of bytes to be taken from the source array
     * @param target byte[] - the array of bytes to be written
     * @param targetOff int - the position in the target array
     * Author: Carlos Roberto Jaimez Gonzalez
     * Email: crjaim@essex.ac.uk
     * Created: 10th January 2005
     */
    private static void encode3Bytes(byte[] source, int sourceOff, int numBytes, byte[] target, int targetOff) {
        //We have to shift left 24 all the bytes in order to throw away the 1's
        //that appear when Java considers a value as negative (it happens when
        //the value is cast from byte to int).
        //Then we shift rigth 8, 16 and 24 the 3 bytes to do an OR operation, in
        //order to have the 3 bytes as only one number, and to be able to
        //exctract the 4 bytes of 6 bits later.
        //Example: imagine that the bytes are 'a'(97), 'b'(98), and 'c'(99)
        //     'a'(97)   00000000 00000000 00000000 01100001
        //     'b'(98)   00000000 00000000 00000000 01100010
        //     'c'(99)   00000000 00000000 00000000 01100011
        //Now, shifting left 24 all of them, we would have:
        //     'a'(97)   01100001 00000000 00000000 00000000
        //     'b'(98)   01100010 00000000 00000000 00000000
        //     'c'(99)   01100011 00000000 00000000 00000000
        //Now, shifting rigth 8, 16, and 24 respectively, we would have:
        //     'a'(97)   00000000 01100001 00000000 00000000   (>>>8)
        //     'b'(98)   00000000 00000000 01100010 00000000   (>>>16)
        //     'c'(99)   00000000 00000000 00000000 01100011   (>>>24)
        //Applying the OR operation, we would have
        //     result =  00000000 01100001 01100010 01100011
        //which is the number that contains the 3 bytes one behind the other
        int result = (numBytes > 0 ? ((source[sourceOff] << 24) >>> 8) : 0) | (numBytes > 1 ? ((source[sourceOff + 1] << 24) >>> 16) : 0) | (numBytes > 2 ? ((source[sourceOff + 2] << 24) >>> 24) : 0);
        //It is determined if the target array needs padding characters, according
        //to the number of bytes taken from the source array. If it is 1 byte, then
        //it needs 2 "="; if they are 2 bytes, then it needs 1 "="; and if they are
        //3, then there is no need of padding characters. Then the 4 bytes are written
        //to the target array.
        //Following the example above, the first byte to be written to the target array
        //would be obtained by shifting right 18 the number obtained above:
        //     result    00000000 01100001 01100010 01100011
        //     >>> 18    00000000 00000000 00000000 0001100001 01100010 01100011
        //which means that we are taking only the first 6 bits of the original number
        //The second byte would be obtained by shifting right 12 and doing the
        //AND operation against 0x3f, just to leave the last 6 bits
        //     result    00000000 01100001 01100010 01100011
        //     >>> 12    00000000 00000000 00000110 000101100010 01100011
        //     0x3f      00000000 00000000 00000000 00111111
        //which means that we are taking the last 6 bits of the resulting number
        //the last 2 bytes to be written to the encoded array are obtained in a
        //similar way to the one described here. They are obtained by shifting
        //right 6 and 0; and by doing the AND operation against 0x3f.
        switch(numBytes) {
            //it does not need padding characters.
            case 3:
                target[targetOff] = TABLE64[(result >>> 18)];
                target[targetOff + 1] = TABLE64[(result >>> 12) & 0x3f];
                target[targetOff + 2] = TABLE64[(result >>> 6) & 0x3f];
                target[targetOff + 3] = TABLE64[(result) & 0x3f];
                break;
            //it needs 1 padding character
            case 2:
                target[targetOff] = TABLE64[(result >>> 18)];
                target[targetOff + 1] = TABLE64[(result >>> 12) & 0x3f];
                target[targetOff + 2] = TABLE64[(result >>> 6) & 0x3f];
                target[targetOff + 3] = EQUALS_CHAR;
                break;
            //it needs 2 padding characters
            case 1:
                target[targetOff] = TABLE64[(result >>> 18)];
                target[targetOff + 1] = TABLE64[(result >>> 12) & 0x3f];
                target[targetOff + 2] = EQUALS_CHAR;
                target[targetOff + 3] = EQUALS_CHAR;
                break;
        }
        //switch
    }

    //encode3Bytes
    //--------------------------------------------------------------------------------------------
    //Public decode method
    /**
     * Very low-level access to decoding ASCII characters in
     * the form of a byte array. Does not support automatically
     * gunzipping or any other "fancy" features.
     *
     * @param source The Base64 encoded data
     * @return decoded data
     * @since 1.3
     */
    public static byte[] decode(byte[] source) {
        //the length of the original array
        int len = source.length;
        //determine the length of the target array
        int len34 = len * 3 / 4;
        //this is the target array and its index
        //maximum size
        byte[] targetArray = new byte[len34];
        int targetIndex = 0;
        //auxuiliar array to group 4 bytes to be decoded and its index
        byte[] aux = new byte[4];
        int auxPos = 0;
        //index for the "for" loop
        int i = 0;
        //variables to manage the bytes
        byte sbiCrop = 0;
        byte sbiDecode = 0;
        //The "for" loop will go trough all the bytes. Inside it will be
        //creating an array of 4 bytes to be decoded to 3 bytes.
        for (i = 0; i < len; i++) {
            //we take only the lowest 7 bits, because they represent the possible
            //characters we expect (from 0 to 127)
            sbiCrop = (byte) (source[i] & 0x7f);
            //get the corresponding value for this ASCII value. For example:
            //'A' (ASCII 65) is represented in the base64 table as the value 0,
            //'B' (ASCII 66) is represented in the base64 table as the value 1, and so on
            sbiDecode = DECODE_TABLE64[sbiCrop];
            //it means that it can be a white space (-5), equals character (-1) or
            //one of the characters from the base64 table (A-Z,a-z,0-9,+,/)
            if (sbiDecode >= WHITE_SPACE_ENC) {
                if (sbiDecode >= EQUALS_SIGN_ENC) {
                    //store this byte in the auxiliar array
                    aux[auxPos++] = sbiCrop;
                    //if we have already 4 bytes, then it is time to decode them...
                    if (auxPos > 3) {
                        //decode the 4 bytes from the array "b4", starting in the position "0",
                        //into the "targetArray", starting in the position "targetIndex".
                        //targetIndex is incremented by the number of bytes written to targetArray
                        //it will be normally incremented by 3
                        targetIndex += decode4Bytes(aux, 0, targetArray, targetIndex);
                        //reset it to be able to group the next 4 bytes
                        auxPos = 0;
                        //If the byte was "=", then break out of the "for" loop, because there
                        //are no more bytes to be decoded
                        if (sbiCrop == EQUALS_CHAR)
                            break;
                    }
                    //if we have 4 bytes
                }
                //if it is "=" or other base64 valid character
            } else //if it was white space, "=" or other base64 valid character
            {
                System.err.println("Bad Base64 input character at " + i + ": " + source[i] + "(decimal)");
                return null;
            }
            //else
        }
        //for each byte
        //create a new array with the real size (without considering spaces)
        byte[] out = new byte[targetIndex];
        //copy the target array to the new array (only the first targetIndex elements)
        System.arraycopy(targetArray, 0, out, 0, targetIndex);
        return out;
    }

    //decode
    //--------------------------------------------------------------------------------------------
    //Private decode method (used by the public decode method)
    /**
     * This method decodes 4 bytes from the source array to 3 bytes into the
     * target array. The bytes taken from the source array start in the position
     * specified by sourceOff; and the 3 bytes to be written to the target array
     * start in the position specified by targetOff. The method also returns the
     * number of bytes written (decoded) in the target array (they can be 1, 2 or 3).
     * @param source byte[] - the array of bytes to be decoded
     * @param sourceOff int - the position in the source array
     * @param target byte[] - the array of bytes to be written
     * @param targetOff int - the position in the target array
     * @return int - the number of decoded bytes written in the target array
     * Author: Carlos Roberto Jaimez Gonzalez
     * Email: crjaim@essex.ac.uk
     * Created: 11th January 2005
     */
    private static int decode4Bytes(byte[] source, int sourceOff, byte[] target, int targetOff) {
        //Case when we have for example: YW==
        //The first "=" character appears in the third position.
        //In this case we will take only the first 2 bytes
        if (source[sourceOff + 2] == EQUALS_CHAR) {
            //We take only the first 2 bytes and do the OR operation on them.
            //For a full explanation refer to the "else" clause below
            int result = ((DECODE_TABLE64[source[sourceOff]] & 0xFF) << 18) | ((DECODE_TABLE64[source[sourceOff + 1]] & 0xFF) << 12);
            //write 1 byte to the target array.
            target[targetOff] = (byte) (result >>> 16);
            //return the number of bytes that were added to the target array
            return 1;
        } else //Case when we have for example: YWJ=
        //The only "=" character appears in the fourth position.
        //In this case we will take only the first 3 bytes
        if (source[sourceOff + 3] == EQUALS_CHAR) {
            //We take only the first 3 bytes and do the OR operation on them.
            //For a full explanation refer to the "else" clause below
            int result = ((DECODE_TABLE64[source[sourceOff]] & 0xFF) << 18) | ((DECODE_TABLE64[source[sourceOff + 1]] & 0xFF) << 12) | ((DECODE_TABLE64[source[sourceOff + 2]] & 0xFF) << 6);
            //write 2 bytes to the target array
            target[targetOff] = (byte) (result >>> 16);
            target[targetOff + 1] = (byte) (result >>> 8);
            //return the number of bytes that were added to the target array
            return 2;
        } else //Case when we have for example: YWJj
        //There is no "=" character. In this case we will take the 4 bytes.
        {
            try {
                //We take the 4 bytes and do the OR operation on them.
                //Following the example, imagine that we have YWJj. We will look for
                //those bytes in the DECODE_TABLE64 to get their corresponding value
                //according to the Base64 table. Thus, 'Y' corresponds to the value 24,
                //'W' is 22, 'J' is 9, and 'j' is 35 (they are taken from the table).
                //We should put those 4 bytes one behind the other, in order to extract
                //the 3 bytes that we need.
                // 'Y' (24)    00000000 00000000 00000000 00011000  (should be shifted left 18)
                // 'W' (22)    00000000 00000000 00000000 00010110  (should be shifted left 12)
                // 'J' ( 9)    00000000 00000000 00000000 00001001  (should be shifted left 6)
                // 'j' (35)    00000000 00000000 00000000 00100011  (it remains in that position)
                //the result of shifting those 4 bytes is:
                //             00000000 01100001 01100010 01100011
                //which is one byte behind the other
                int result = ((DECODE_TABLE64[source[sourceOff]] & 0xFF) << 18) | ((DECODE_TABLE64[source[sourceOff + 1]] & 0xFF) << 12) | ((DECODE_TABLE64[source[sourceOff + 2]] & 0xFF) << 6) | ((DECODE_TABLE64[source[sourceOff + 3]] & 0xFF));
                //Now, with the result above, we should take the 3 bytes we need.
                //To be able to separate those 3 bytes, we need to shift right 16 and 8, and
                //then we will have the three bytes we need.
                // 00000000 00000000 00000000 01100001 (which represents 97 = 'a')
                // 00000000 00000000 00000000 01100010 (which represents 98 = 'b')
                // 00000000 00000000 00000000 01100011 (which represents 99 = 'c')
                //Then the bytes 'YWJj' base64 are represented as 'abc'
                //They are written to the target array
                target[targetOff] = (byte) (result >> 16);
                target[targetOff + 1] = (byte) (result >> 8);
                target[targetOff + 2] = (byte) (result);
                //return the number of bytes that were added to the target array
                return 3;
            } catch (Exception e) {
                System.out.println("" + source[sourceOff] + ": " + (DECODE_TABLE64[source[sourceOff]]));
                System.out.println("" + source[sourceOff + 1] + ": " + (DECODE_TABLE64[source[sourceOff + 1]]));
                System.out.println("" + source[sourceOff + 2] + ": " + (DECODE_TABLE64[source[sourceOff + 2]]));
                System.out.println("" + source[sourceOff + 3] + ": " + (DECODE_TABLE64[source[sourceOff + 3]]));
                return -1;
            }
            //catch
        }
    }

    //decode4Bytes
    /**
     * Test method
     * @param args
     */
    public static void main(@javax.annotation.Nullable String[] args) {
        System.out.println("\nTesting Base64...");
        byte[] source = new byte[] { (byte) 'a', (byte) 'h', (byte) ',', (byte) 'q', (byte) 'Q', (byte) 'Y', (byte) ')', (byte) '[', (byte) 'd', (byte) '7', (byte) ',', (byte) 'w', (byte) 'F', (byte) '7', (byte) '0', (byte) ']', (byte) '5', (byte) '/', (byte) 'n', (byte) 'e', (byte) 'H', (byte) '0', (byte) '{', (byte) '*', (byte) 't', (byte) '/', (byte) 'b', (byte) 'r', (byte) '3', (byte) '1', (byte) '+', (byte) 'u', (byte) 'g', (byte) 'q', (byte) 'v', (byte) 'g', (byte) '@', (byte) '!', (byte) '+', (byte) 'y', (byte) 'h', (byte) '#', (byte) 'c', (byte) 'u', (byte) 'j', (byte) '"', (byte) 'p', (byte) 't', (byte) '8', (byte) 'e', (byte) 'd', (byte) 'i', (byte) '.', (byte) '$', (byte) 'l', (byte) 'f', (byte) 'i', (byte) 'g', (byte) 't', (byte) 'o', (byte) ' ', (byte) '%', (byte) 'o', (byte) '8', (byte) '?', (byte) '6', (byte) '6', (byte) '=', (byte) ' ', (byte) '&', (byte) 'o', (byte) '0', (byte) 'o', (byte) '8', (byte) '7', (byte) '?', (byte) ')', (byte) '(', (byte) 'j', (byte) ' ', (byte) 'a', (byte) 'h', (byte) ',', (byte) 'q', (byte) 'Q', (byte) 'Y', (byte) ')', (byte) '[', (byte) 'd', (byte) '7', (byte) ',', (byte) 'w', (byte) 'F', (byte) '7', (byte) '0', (byte) ']', (byte) '5', (byte) '/', (byte) 'n', (byte) 'e', (byte) 'H', (byte) '0', (byte) '{', (byte) '*', (byte) 't', (byte) '/', (byte) 'b', (byte) 'r', (byte) '3', (byte) '1', (byte) '+', (byte) 'u', (byte) 'g', (byte) 'q', (byte) 'v', (byte) 'g', (byte) '@', (byte) '!', (byte) '+', (byte) 'y', (byte) 'h', (byte) '#', (byte) 'c', (byte) 'u', (byte) 'j', (byte) '"', (byte) 'p', (byte) 't', (byte) '8', (byte) 'e', (byte) 'd', (byte) 'i', (byte) '.', (byte) '$', (byte) 'l', (byte) 'f', (byte) 'i', (byte) 'g', (byte) 't', (byte) 'o', (byte) ' ', (byte) '%', (byte) 'o', (byte) '8', (byte) '?', (byte) '6', (byte) '6', (byte) '=', (byte) ' ', (byte) '&', (byte) 'o', (byte) '0', (byte) 'o', (byte) '8', (byte) '7', (byte) '?', (byte) ')', (byte) '(', (byte) 'j', (byte) ' ', (byte) 'm' };
        //original = new byte[]{(byte)'a',(byte)'b',(byte)'c'};
        //Convert the source array of bytes to string
        String strSource = new String(source);
        System.out.println("\nThe source array size is: " + source.length + ", and it is:\n" + strSource);
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\nEncoding...");
        //encoding the source array
        byte[] target = EncodeBase64.encode(source);
        //Convert the target array of bytes to string
        String strTarget = new String(target);
        System.out.println("The encoded array size is: " + target.length + ", and it is:\n" + strTarget);
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\nDecoding...");
        //decoding the target array
        byte[] decodedArray = EncodeBase64.decode(target);
        //System.out.println("size of array: " + originalAgainMine.length);
        String strDecodedArray = new String(decodedArray);
        System.out.println("The decoded array is: " + decodedArray.length + ", and it \n" + strDecodedArray);
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
    //main
}
//class
