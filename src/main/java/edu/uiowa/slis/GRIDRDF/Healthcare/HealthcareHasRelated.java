package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareHasRelated extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareHasRelated currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareHasRelated.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			HealthcareHasRelatedIterator theHealthcareHasRelatedIterator = (HealthcareHasRelatedIterator)findAncestorWithClass(this, HealthcareHasRelatedIterator.class);
			pageContext.getOut().print(theHealthcareHasRelatedIterator.getHasRelated());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for hasRelated tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for hasRelated tag ");
		}
		return SKIP_BODY;
	}
}

