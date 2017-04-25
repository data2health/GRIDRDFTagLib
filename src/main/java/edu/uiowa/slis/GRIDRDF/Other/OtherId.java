package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherId currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			OtherIdIterator theOther = (OtherIdIterator)findAncestorWithClass(this, OtherIdIterator.class);
			pageContext.getOut().print(theOther.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for id tag ");
		}
		return SKIP_BODY;
	}
}

