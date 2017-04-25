package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitHasParent extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitHasParent currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitHasParent.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			NonprofitHasParentIterator theNonprofitHasParentIterator = (NonprofitHasParentIterator)findAncestorWithClass(this, NonprofitHasParentIterator.class);
			pageContext.getOut().print(theNonprofitHasParentIterator.getHasParent());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

