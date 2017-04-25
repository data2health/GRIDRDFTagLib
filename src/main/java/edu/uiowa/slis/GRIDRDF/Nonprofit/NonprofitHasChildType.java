package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitHasChildType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitHasChildType currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitHasChildType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			NonprofitHasChildIterator theNonprofitHasChildIterator = (NonprofitHasChildIterator)findAncestorWithClass(this, NonprofitHasChildIterator.class);
			pageContext.getOut().print(theNonprofitHasChildIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

