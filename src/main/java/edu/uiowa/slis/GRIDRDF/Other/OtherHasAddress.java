package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherHasAddress extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherHasAddress currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherHasAddress.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			OtherHasAddressIterator theOtherHasAddressIterator = (OtherHasAddressIterator)findAncestorWithClass(this, OtherHasAddressIterator.class);
			pageContext.getOut().print(theOtherHasAddressIterator.getHasAddress());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

