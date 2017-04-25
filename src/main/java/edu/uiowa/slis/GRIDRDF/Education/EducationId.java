package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationId currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			EducationIdIterator theEducation = (EducationIdIterator)findAncestorWithClass(this, EducationIdIterator.class);
			pageContext.getOut().print(theEducation.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for id tag ");
		}
		return SKIP_BODY;
	}
}

