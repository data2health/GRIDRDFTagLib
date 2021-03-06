package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyHasRelatedInverse extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyHasRelatedInverse currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyHasRelatedInverse.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			CompanyHasRelatedInverseIterator theCompanyHasRelatedInverseIterator = (CompanyHasRelatedInverseIterator)findAncestorWithClass(this, CompanyHasRelatedInverseIterator.class);
			pageContext.getOut().print(theCompanyHasRelatedInverseIterator.getHasRelatedInverse());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

