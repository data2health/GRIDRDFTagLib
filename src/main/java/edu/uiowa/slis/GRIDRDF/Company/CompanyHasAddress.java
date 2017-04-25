package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyHasAddress extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyHasAddress currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyHasAddress.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			CompanyHasAddressIterator theCompanyHasAddressIterator = (CompanyHasAddressIterator)findAncestorWithClass(this, CompanyHasAddressIterator.class);
			pageContext.getOut().print(theCompanyHasAddressIterator.getHasAddress());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

