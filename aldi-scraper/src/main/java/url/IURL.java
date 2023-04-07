package url;

import url.domain.IURLDomain;
import url.fragment.IURLFragment;
import url.path.IURLPath;
import url.port.IURLPort;
import url.query.IURLQuery;
import url.scheme.IURLScheme;
import url.user.IURLUser;

import java.util.concurrent.atomic.AtomicReference;

public interface IURL {

    IURLDomain domain = null;
    IURLFragment fragment = null;
    IURLPath path = null;
    IURLPort port = null;
    IURLQuery query = null;
    IURLScheme scheme = null;
    IURLUser user = null;
}
