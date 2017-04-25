package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherHasRelated extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherHasRelated currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherHasRelated.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			OtherHasRelatedIterator theOtherHasRelatedIterator = (OtherHasRelatedIterator)findAncestorWithClass(this, OtherHasRelatedIterator.class);
			pageContext.getOut().print(theOtherHasRelatedIterator.getHasRelated());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

