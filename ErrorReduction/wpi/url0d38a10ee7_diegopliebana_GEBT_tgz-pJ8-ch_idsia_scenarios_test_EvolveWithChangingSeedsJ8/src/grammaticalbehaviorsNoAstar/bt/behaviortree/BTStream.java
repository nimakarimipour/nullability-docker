/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grammaticalbehaviorsNoAstar.bt.behaviortree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author Diego
 */
@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class BTStream {

    //Stream objects
    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull ByteArrayOutputStream m_stream;

    private @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable InputStream m_reader;

    //Line separator
    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull char LINE_SEPARATOR = '\n';

    @org.checkerframework.dataflow.qual.SideEffectFree
    public BTStream() {
        m_stream = new ByteArrayOutputStream();
        m_reader = null;
    }

    @org.checkerframework.dataflow.qual.Impure
    public void writeLine(String a_line) {
        try {
            //Write the content...
            m_stream.write(a_line.getBytes());
            //And the line separator
            m_stream.write(LINE_SEPARATOR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    public @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String readLine() {
        StringBuffer sb;
        int n = -1;
        char c = ' ';
        try {
            if (m_reader == null) {
                //Initialize reader if we haven't started the process.
                m_reader = new ByteArrayInputStream(m_stream.toByteArray());
            }
            sb = new StringBuffer("");
            n = m_reader.read();
            if (n != -1)
                c = (char) n;
            while (n != -1 && c != LINE_SEPARATOR) {
                sb.append(c);
                n = m_reader.read();
                if (n != -1)
                    c = (char) n;
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
