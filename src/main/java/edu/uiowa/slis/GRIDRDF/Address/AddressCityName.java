package edu.uiowa.slis.GRIDRDF.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class AddressCityName extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static AddressCityName currentInstance = null;
	private static final Log log = LogFactory.getLog(AddressCityName.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			AddressCityNameIterator theAddress = (AddressCityNameIterator)findAncestorWithClass(this, AddressCityNameIterator.class);
			pageContext.getOut().print(theAddress.getCityName());
		} catch (Exception e) {
			log.error("Can't find enclosing Address for cityName tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for cityName tag ");
		}
		return SKIP_BODY;
	}
}

