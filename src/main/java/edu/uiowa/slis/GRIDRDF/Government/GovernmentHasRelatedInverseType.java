package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentHasRelatedInverseType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentHasRelatedInverseType currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentHasRelatedInverseType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			GovernmentHasRelatedInverseIterator theGovernmentHasRelatedInverseIterator = (GovernmentHasRelatedInverseIterator)findAncestorWithClass(this, GovernmentHasRelatedInverseIterator.class);
			pageContext.getOut().print(theGovernmentHasRelatedInverseIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

