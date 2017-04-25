package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyHasParentType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyHasParentType currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyHasParentType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			CompanyHasParentIterator theCompanyHasParentIterator = (CompanyHasParentIterator)findAncestorWithClass(this, CompanyHasParentIterator.class);
			pageContext.getOut().print(theCompanyHasParentIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

