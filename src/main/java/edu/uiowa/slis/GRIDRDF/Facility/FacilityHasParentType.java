package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityHasParentType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityHasParentType currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityHasParentType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			FacilityHasParentIterator theFacilityHasParentIterator = (FacilityHasParentIterator)findAncestorWithClass(this, FacilityHasParentIterator.class);
			pageContext.getOut().print(theFacilityHasParentIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

