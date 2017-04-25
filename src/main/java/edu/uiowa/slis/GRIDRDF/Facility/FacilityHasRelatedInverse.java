package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityHasRelatedInverse extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityHasRelatedInverse currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityHasRelatedInverse.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			FacilityHasRelatedInverseIterator theFacilityHasRelatedInverseIterator = (FacilityHasRelatedInverseIterator)findAncestorWithClass(this, FacilityHasRelatedInverseIterator.class);
			pageContext.getOut().print(theFacilityHasRelatedInverseIterator.getHasRelatedInverse());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

