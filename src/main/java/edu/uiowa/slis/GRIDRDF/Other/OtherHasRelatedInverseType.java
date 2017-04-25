package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherHasRelatedInverseType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherHasRelatedInverseType currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherHasRelatedInverseType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			OtherHasRelatedInverseIterator theOtherHasRelatedInverseIterator = (OtherHasRelatedInverseIterator)findAncestorWithClass(this, OtherHasRelatedInverseIterator.class);
			pageContext.getOut().print(theOtherHasRelatedInverseIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

