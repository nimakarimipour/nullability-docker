package wox.serial;

import org.jdom.Element;

public interface ObjectWriter extends Serial {

    public Element write(@javax.annotation.Nullable Object o);
}
