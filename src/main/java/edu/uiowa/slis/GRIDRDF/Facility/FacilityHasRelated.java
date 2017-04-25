package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityHasRelated extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityHasRelated currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityHasRelated.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			FacilityHasRelatedIterator theFacilityHasRelatedIterator = (FacilityHasRelatedIterator)findAncestorWithClass(this, FacilityHasRelatedIterator.class);
			pageContext.getOut().print(theFacilityHasRelatedIterator.getHasRelated());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

