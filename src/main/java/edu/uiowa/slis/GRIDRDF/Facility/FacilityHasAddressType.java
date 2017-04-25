package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityHasAddressType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityHasAddressType currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityHasAddressType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			FacilityHasAddressIterator theFacilityHasAddressIterator = (FacilityHasAddressIterator)findAncestorWithClass(this, FacilityHasAddressIterator.class);
			pageContext.getOut().print(theFacilityHasAddressIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

