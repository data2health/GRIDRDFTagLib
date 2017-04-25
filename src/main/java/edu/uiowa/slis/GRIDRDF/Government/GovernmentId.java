package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentId currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			GovernmentIdIterator theGovernment = (GovernmentIdIterator)findAncestorWithClass(this, GovernmentIdIterator.class);
			pageContext.getOut().print(theGovernment.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for id tag ");
		}
		return SKIP_BODY;
	}
}

