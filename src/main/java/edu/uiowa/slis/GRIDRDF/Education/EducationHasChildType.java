package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationHasChildType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationHasChildType currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationHasChildType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			EducationHasChildIterator theEducationHasChildIterator = (EducationHasChildIterator)findAncestorWithClass(this, EducationHasChildIterator.class);
			pageContext.getOut().print(theEducationHasChildIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

