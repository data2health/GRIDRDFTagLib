package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityHasChildType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityHasChildType currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityHasChildType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			FacilityHasChildIterator theFacilityHasChildIterator = (FacilityHasChildIterator)findAncestorWithClass(this, FacilityHasChildIterator.class);
			pageContext.getOut().print(theFacilityHasChildIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

