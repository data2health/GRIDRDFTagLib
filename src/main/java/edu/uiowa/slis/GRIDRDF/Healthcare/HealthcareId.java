package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareId currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			HealthcareIdIterator theHealthcare = (HealthcareIdIterator)findAncestorWithClass(this, HealthcareIdIterator.class);
			pageContext.getOut().print(theHealthcare.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for id tag ");
		}
		return SKIP_BODY;
	}
}

