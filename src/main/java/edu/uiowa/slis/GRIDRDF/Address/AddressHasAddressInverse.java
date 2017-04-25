package edu.uiowa.slis.GRIDRDF.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class AddressHasAddressInverse extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static AddressHasAddressInverse currentInstance = null;
	private static final Log log = LogFactory.getLog(AddressHasAddressInverse.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			AddressHasAddressInverseIterator theAddressHasAddressInverseIterator = (AddressHasAddressInverseIterator)findAncestorWithClass(this, AddressHasAddressInverseIterator.class);
			pageContext.getOut().print(theAddressHasAddressInverseIterator.getHasAddressInverse());
		} catch (Exception e) {
			log.error("Can't find enclosing Address for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

