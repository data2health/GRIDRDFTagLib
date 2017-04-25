package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentHasRelatedType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentHasRelatedType currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentHasRelatedType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			GovernmentHasRelatedIterator theGovernmentHasRelatedIterator = (GovernmentHasRelatedIterator)findAncestorWithClass(this, GovernmentHasRelatedIterator.class);
			pageContext.getOut().print(theGovernmentHasRelatedIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

