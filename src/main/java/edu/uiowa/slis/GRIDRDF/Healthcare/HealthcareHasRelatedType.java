package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareHasRelatedType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareHasRelatedType currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareHasRelatedType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			HealthcareHasRelatedIterator theHealthcareHasRelatedIterator = (HealthcareHasRelatedIterator)findAncestorWithClass(this, HealthcareHasRelatedIterator.class);
			pageContext.getOut().print(theHealthcareHasRelatedIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

