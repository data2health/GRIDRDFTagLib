package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitHasAddress extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitHasAddress currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitHasAddress.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			NonprofitHasAddressIterator theNonprofitHasAddressIterator = (NonprofitHasAddressIterator)findAncestorWithClass(this, NonprofitHasAddressIterator.class);
			pageContext.getOut().print(theNonprofitHasAddressIterator.getHasAddress());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

