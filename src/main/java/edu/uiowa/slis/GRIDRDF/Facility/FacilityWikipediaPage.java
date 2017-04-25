package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			FacilityWikipediaPageIterator theFacility = (FacilityWikipediaPageIterator)findAncestorWithClass(this, FacilityWikipediaPageIterator.class);
			pageContext.getOut().print(theFacility.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

