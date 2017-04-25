package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			CompanyWikipediaPageIterator theCompany = (CompanyWikipediaPageIterator)findAncestorWithClass(this, CompanyWikipediaPageIterator.class);
			pageContext.getOut().print(theCompany.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Company for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

