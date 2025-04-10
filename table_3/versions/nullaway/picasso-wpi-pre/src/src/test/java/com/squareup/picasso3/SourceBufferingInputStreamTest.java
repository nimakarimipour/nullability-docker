package com.squareup.picasso3;

import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public final class SourceBufferingInputStreamTest {

    @org.checkerframework.dataflow.qual.Impure
    public void replay() throws IOException {
        Buffer data = new Buffer().writeUtf8("Hello, world!");
        BufferedSource source = Okio.buffer(new OneByteSource(data));
        InputStream stream = new SourceBufferingInputStream(source);
        // Read a 5 byte header from the wrapping input stream.
        byte[] out = new byte[5];
        assertEquals(5, stream.read(out));
        assertEquals("Hello", new String(out, "UTF-8"));
        // Ensure we've only requested what we needed from the upstream.
        assertEquals(5, source.buffer().size());
        // Ensure we can read the entirety of the contents from the original source.
        assertEquals("Hello, world!", source.readUtf8());
    }

    @org.checkerframework.dataflow.qual.Impure
    public void available() throws IOException {
        Buffer data = new Buffer().writeUtf8("Hello, world!");
        BufferedSource source = Okio.buffer((Source) data);
        InputStream stream = new SourceBufferingInputStream(source);
        assertEquals(0, stream.available());
        stream.read();
        // Assume the segment size is >=13 bytes.
        assertEquals(12, stream.available());
        Buffer buffer = new Buffer().writeUtf8("Hello, world!");
        stream = new SourceBufferingInputStream(buffer);
        assertEquals(13, stream.available());
    }

    @org.checkerframework.dataflow.qual.Impure
    public void read() throws IOException {
        Buffer data = new Buffer().writeUtf8("Hello, world!");
        BufferedSource source = Okio.buffer((Source) data);
        InputStream stream = new SourceBufferingInputStream(source);
        byte[] bytes = new byte[5];
        int len = stream.read(bytes);
        assertEquals(5, len);
        assertArrayEquals(new byte[] { 'H', 'e', 'l', 'l', 'o' }, bytes);
        len = stream.read(bytes);
        assertEquals(5, len);
        assertArrayEquals(new byte[] { ',', ' ', 'w', 'o', 'r' }, bytes);
        len = stream.read(bytes);
        assertEquals(3, len);
        // Last two bytes are out of range so untouched from previous run.
        assertArrayEquals(new byte[] { 'l', 'd', '!', 'o', 'r' }, bytes);
        len = stream.read(bytes);
        assertEquals(-1, len);
    }

    @org.checkerframework.dataflow.qual.Impure
    public void markReset() throws IOException {
        Buffer data = new Buffer().writeUtf8("Hello, world!");
        BufferedSource source = Okio.buffer((Source) data);
        InputStream stream = new SourceBufferingInputStream(source);
        stream.mark(2);
        byte[] bytes = new byte[4];
        int len = stream.read(bytes, 0, 2);
        assertEquals(2, len);
        assertArrayEquals(new byte[] { 'H', 'e', 0, 0 }, bytes);
        len = stream.read(bytes);
        assertEquals(len, 4);
        assertArrayEquals(new byte[] { 'l', 'l', 'o', ',' }, bytes);
        try {
            stream.reset();
            fail("expected IOException on reset");
        } catch (IOException expected) {
        }
        stream.mark(2);
        len = stream.read(bytes, 0, 2);
        assertEquals(2, len);
        assertArrayEquals(new byte[] { ' ', 'w', 'o', ',' }, bytes);
        stream.reset();
        len = stream.read(bytes);
        assertEquals(4, len);
        assertArrayEquals(new byte[] { ' ', 'w', 'o', 'r' }, bytes);
    }

    /**
     * Prevents a consumer from reading large chunks and exercises edge cases.
     */
    private static final class OneByteSource implements Source {

        private final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Source upstream;

        @org.checkerframework.dataflow.qual.SideEffectFree
        OneByteSource(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Source upstream) {
            this.upstream = upstream;
        }

        @org.checkerframework.dataflow.qual.Impure
        public  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long read(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull OneByteSource this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Buffer sink,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull long byteCount) throws IOException {
            if (byteCount > 0) {
                return upstream.read(sink, 1);
            }
            return 0;
        }

        @org.checkerframework.dataflow.qual.Impure
        public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Timeout timeout(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull OneByteSource this) {
            return upstream.timeout();
        }

        @org.checkerframework.dataflow.qual.Impure
        public void close(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull OneByteSource this) throws IOException {
            upstream.close();
        }
    }
}
