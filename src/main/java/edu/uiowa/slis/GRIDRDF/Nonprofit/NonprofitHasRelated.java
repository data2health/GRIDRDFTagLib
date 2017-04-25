package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitHasRelated extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitHasRelated currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitHasRelated.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			NonprofitHasRelatedIterator theNonprofitHasRelatedIterator = (NonprofitHasRelatedIterator)findAncestorWithClass(this, NonprofitHasRelatedIterator.class);
			pageContext.getOut().print(theNonprofitHasRelatedIterator.getHasRelated());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

