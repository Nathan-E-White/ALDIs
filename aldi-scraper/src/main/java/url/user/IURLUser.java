package url.user;

import io.netty.util.AsciiString;

import java.util.Iterator;
import java.util.Vector;

public interface IURLUser {
    String user = "";
    Byte[] encoded = new Byte[0];

    AsciiString

    /**
     * @see <a href="https://url.spec.whatwg.org/">W3 Standard</a>
     * @param inp
     * @return Byte[] encoded array
     */
    Byte[] PercentEncodeByteSequence(Byte[] inp);
    Byte[] PercentDecodeByteSequence(Byte[] inp);
}
