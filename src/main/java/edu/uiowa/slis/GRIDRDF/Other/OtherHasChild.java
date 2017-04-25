package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherHasChild extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherHasChild currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherHasChild.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			OtherHasChildIterator theOtherHasChildIterator = (OtherHasChildIterator)findAncestorWithClass(this, OtherHasChildIterator.class);
			pageContext.getOut().print(theOtherHasChildIterator.getHasChild());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

