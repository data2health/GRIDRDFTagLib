package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityHasChild extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityHasChild currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityHasChild.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			FacilityHasChildIterator theFacilityHasChildIterator = (FacilityHasChildIterator)findAncestorWithClass(this, FacilityHasChildIterator.class);
			pageContext.getOut().print(theFacilityHasChildIterator.getHasChild());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

