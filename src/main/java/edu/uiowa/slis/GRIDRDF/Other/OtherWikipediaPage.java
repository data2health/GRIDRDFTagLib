package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			OtherWikipediaPageIterator theOther = (OtherWikipediaPageIterator)findAncestorWithClass(this, OtherWikipediaPageIterator.class);
			pageContext.getOut().print(theOther.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

