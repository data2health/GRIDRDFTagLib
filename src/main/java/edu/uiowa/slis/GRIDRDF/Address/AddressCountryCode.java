package edu.uiowa.slis.GRIDRDF.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class AddressCountryCode extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static AddressCountryCode currentInstance = null;
	private static final Log log = LogFactory.getLog(AddressCountryCode.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			AddressCountryCodeIterator theAddress = (AddressCountryCodeIterator)findAncestorWithClass(this, AddressCountryCodeIterator.class);
			pageContext.getOut().print(theAddress.getCountryCode());
		} catch (Exception e) {
			log.error("Can't find enclosing Address for countryCode tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for countryCode tag ");
		}
		return SKIP_BODY;
	}
}

