package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareHasChild extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareHasChild currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareHasChild.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			HealthcareHasChildIterator theHealthcareHasChildIterator = (HealthcareHasChildIterator)findAncestorWithClass(this, HealthcareHasChildIterator.class);
			pageContext.getOut().print(theHealthcareHasChildIterator.getHasChild());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

