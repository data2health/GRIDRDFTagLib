package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentHasAddress extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentHasAddress currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentHasAddress.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			GovernmentHasAddressIterator theGovernmentHasAddressIterator = (GovernmentHasAddressIterator)findAncestorWithClass(this, GovernmentHasAddressIterator.class);
			pageContext.getOut().print(theGovernmentHasAddressIterator.getHasAddress());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

