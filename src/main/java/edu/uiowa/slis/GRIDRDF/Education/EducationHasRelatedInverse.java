package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationHasRelatedInverse extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationHasRelatedInverse currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationHasRelatedInverse.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			EducationHasRelatedInverseIterator theEducationHasRelatedInverseIterator = (EducationHasRelatedInverseIterator)findAncestorWithClass(this, EducationHasRelatedInverseIterator.class);
			pageContext.getOut().print(theEducationHasRelatedInverseIterator.getHasRelatedInverse());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

