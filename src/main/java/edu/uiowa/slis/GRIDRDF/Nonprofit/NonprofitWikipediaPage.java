package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			NonprofitWikipediaPageIterator theNonprofit = (NonprofitWikipediaPageIterator)findAncestorWithClass(this, NonprofitWikipediaPageIterator.class);
			pageContext.getOut().print(theNonprofit.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

