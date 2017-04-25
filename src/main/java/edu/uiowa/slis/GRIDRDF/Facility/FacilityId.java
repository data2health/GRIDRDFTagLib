package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityId currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			FacilityIdIterator theFacility = (FacilityIdIterator)findAncestorWithClass(this, FacilityIdIterator.class);
			pageContext.getOut().print(theFacility.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for id tag ");
		}
		return SKIP_BODY;
	}
}

