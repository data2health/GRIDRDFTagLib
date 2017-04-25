package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationHasParent extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationHasParent currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationHasParent.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			EducationHasParentIterator theEducationHasParentIterator = (EducationHasParentIterator)findAncestorWithClass(this, EducationHasParentIterator.class);
			pageContext.getOut().print(theEducationHasParentIterator.getHasParent());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

