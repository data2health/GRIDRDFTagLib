package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyHasParent extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyHasParent currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyHasParent.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			CompanyHasParentIterator theCompanyHasParentIterator = (CompanyHasParentIterator)findAncestorWithClass(this, CompanyHasParentIterator.class);
			pageContext.getOut().print(theCompanyHasParentIterator.getHasParent());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

