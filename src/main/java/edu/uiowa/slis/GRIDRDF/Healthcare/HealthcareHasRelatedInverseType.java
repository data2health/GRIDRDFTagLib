package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareHasRelatedInverseType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareHasRelatedInverseType currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareHasRelatedInverseType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			HealthcareHasRelatedInverseIterator theHealthcareHasRelatedInverseIterator = (HealthcareHasRelatedInverseIterator)findAncestorWithClass(this, HealthcareHasRelatedInverseIterator.class);
			pageContext.getOut().print(theHealthcareHasRelatedInverseIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

