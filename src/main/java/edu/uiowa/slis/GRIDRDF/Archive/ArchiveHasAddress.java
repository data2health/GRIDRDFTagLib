package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveHasAddress extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveHasAddress currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveHasAddress.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			ArchiveHasAddressIterator theArchiveHasAddressIterator = (ArchiveHasAddressIterator)findAncestorWithClass(this, ArchiveHasAddressIterator.class);
			pageContext.getOut().print(theArchiveHasAddressIterator.getHasAddress());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

