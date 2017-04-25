package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			EducationWikipediaPageIterator theEducation = (EducationWikipediaPageIterator)findAncestorWithClass(this, EducationWikipediaPageIterator.class);
			pageContext.getOut().print(theEducation.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

