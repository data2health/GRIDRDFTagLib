package edu.uiowa.slis.GRIDRDF.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class AddressCountryName extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static AddressCountryName currentInstance = null;
	private static final Log log = LogFactory.getLog(AddressCountryName.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			AddressCountryNameIterator theAddress = (AddressCountryNameIterator)findAncestorWithClass(this, AddressCountryNameIterator.class);
			pageContext.getOut().print(theAddress.getCountryName());
		} catch (Exception e) {
			log.error("Can't find enclosing Address for countryName tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for countryName tag ");
		}
		return SKIP_BODY;
	}
}

