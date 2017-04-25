package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyHasChild extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyHasChild currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyHasChild.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			CompanyHasChildIterator theCompanyHasChildIterator = (CompanyHasChildIterator)findAncestorWithClass(this, CompanyHasChildIterator.class);
			pageContext.getOut().print(theCompanyHasChildIterator.getHasChild());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

