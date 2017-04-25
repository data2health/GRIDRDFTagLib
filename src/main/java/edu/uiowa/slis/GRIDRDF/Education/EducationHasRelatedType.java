package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationHasRelatedType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationHasRelatedType currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationHasRelatedType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			EducationHasRelatedIterator theEducationHasRelatedIterator = (EducationHasRelatedIterator)findAncestorWithClass(this, EducationHasRelatedIterator.class);
			pageContext.getOut().print(theEducationHasRelatedIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

