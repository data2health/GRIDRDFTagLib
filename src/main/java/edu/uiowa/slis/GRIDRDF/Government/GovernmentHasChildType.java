package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentHasChildType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentHasChildType currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentHasChildType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			GovernmentHasChildIterator theGovernmentHasChildIterator = (GovernmentHasChildIterator)findAncestorWithClass(this, GovernmentHasChildIterator.class);
			pageContext.getOut().print(theGovernmentHasChildIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

