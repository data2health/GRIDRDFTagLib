package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherHasParent extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherHasParent currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherHasParent.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			OtherHasParentIterator theOtherHasParentIterator = (OtherHasParentIterator)findAncestorWithClass(this, OtherHasParentIterator.class);
			pageContext.getOut().print(theOtherHasParentIterator.getHasParent());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

