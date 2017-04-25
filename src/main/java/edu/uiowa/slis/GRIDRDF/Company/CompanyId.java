package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyId currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			CompanyIdIterator theCompany = (CompanyIdIterator)findAncestorWithClass(this, CompanyIdIterator.class);
			pageContext.getOut().print(theCompany.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for id tag ");
		}
		return SKIP_BODY;
	}
}

