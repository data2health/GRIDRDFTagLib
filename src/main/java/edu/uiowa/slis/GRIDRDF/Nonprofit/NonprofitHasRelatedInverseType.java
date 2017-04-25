package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitHasRelatedInverseType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitHasRelatedInverseType currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitHasRelatedInverseType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			NonprofitHasRelatedInverseIterator theNonprofitHasRelatedInverseIterator = (NonprofitHasRelatedInverseIterator)findAncestorWithClass(this, NonprofitHasRelatedInverseIterator.class);
			pageContext.getOut().print(theNonprofitHasRelatedInverseIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

