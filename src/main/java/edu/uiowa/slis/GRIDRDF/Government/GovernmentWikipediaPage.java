package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			GovernmentWikipediaPageIterator theGovernment = (GovernmentWikipediaPageIterator)findAncestorWithClass(this, GovernmentWikipediaPageIterator.class);
			pageContext.getOut().print(theGovernment.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

