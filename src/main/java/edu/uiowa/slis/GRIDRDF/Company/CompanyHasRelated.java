package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyHasRelated extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyHasRelated currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyHasRelated.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			CompanyHasRelatedIterator theCompanyHasRelatedIterator = (CompanyHasRelatedIterator)findAncestorWithClass(this, CompanyHasRelatedIterator.class);
			pageContext.getOut().print(theCompanyHasRelatedIterator.getHasRelated());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

