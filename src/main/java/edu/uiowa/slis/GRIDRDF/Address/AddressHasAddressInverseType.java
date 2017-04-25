package edu.uiowa.slis.GRIDRDF.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class AddressHasAddressInverseType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static AddressHasAddressInverseType currentInstance = null;
	private static final Log log = LogFactory.getLog(AddressHasAddressInverseType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			AddressHasAddressInverseIterator theAddressHasAddressInverseIterator = (AddressHasAddressInverseIterator)findAncestorWithClass(this, AddressHasAddressInverseIterator.class);
			pageContext.getOut().print(theAddressHasAddressInverseIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Address for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

