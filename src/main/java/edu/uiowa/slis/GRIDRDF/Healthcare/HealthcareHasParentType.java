package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareHasParentType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareHasParentType currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareHasParentType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			HealthcareHasParentIterator theHealthcareHasParentIterator = (HealthcareHasParentIterator)findAncestorWithClass(this, HealthcareHasParentIterator.class);
			pageContext.getOut().print(theHealthcareHasParentIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

