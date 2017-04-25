package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			HealthcareWikipediaPageIterator theHealthcare = (HealthcareWikipediaPageIterator)findAncestorWithClass(this, HealthcareWikipediaPageIterator.class);
			pageContext.getOut().print(theHealthcare.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

