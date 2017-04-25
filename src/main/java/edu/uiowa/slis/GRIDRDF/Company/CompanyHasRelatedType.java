package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyHasRelatedType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyHasRelatedType currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyHasRelatedType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			CompanyHasRelatedIterator theCompanyHasRelatedIterator = (CompanyHasRelatedIterator)findAncestorWithClass(this, CompanyHasRelatedIterator.class);
			pageContext.getOut().print(theCompanyHasRelatedIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

