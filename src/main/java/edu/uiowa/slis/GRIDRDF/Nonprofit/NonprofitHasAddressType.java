package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitHasAddressType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitHasAddressType currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitHasAddressType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			NonprofitHasAddressIterator theNonprofitHasAddressIterator = (NonprofitHasAddressIterator)findAncestorWithClass(this, NonprofitHasAddressIterator.class);
			pageContext.getOut().print(theNonprofitHasAddressIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

