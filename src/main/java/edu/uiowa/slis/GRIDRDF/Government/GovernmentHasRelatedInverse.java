package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentHasRelatedInverse extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentHasRelatedInverse currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentHasRelatedInverse.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			GovernmentHasRelatedInverseIterator theGovernmentHasRelatedInverseIterator = (GovernmentHasRelatedInverseIterator)findAncestorWithClass(this, GovernmentHasRelatedInverseIterator.class);
			pageContext.getOut().print(theGovernmentHasRelatedInverseIterator.getHasRelatedInverse());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

