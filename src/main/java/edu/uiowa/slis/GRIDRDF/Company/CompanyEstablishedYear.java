package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			CompanyEstablishedYearIterator theCompany = (CompanyEstablishedYearIterator)findAncestorWithClass(this, CompanyEstablishedYearIterator.class);
			pageContext.getOut().print(theCompany.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

