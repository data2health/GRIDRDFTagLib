package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitId currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			NonprofitIdIterator theNonprofit = (NonprofitIdIterator)findAncestorWithClass(this, NonprofitIdIterator.class);
			pageContext.getOut().print(theNonprofit.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for id tag ");
		}
		return SKIP_BODY;
	}
}

