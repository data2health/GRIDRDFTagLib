package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationHasAddress extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationHasAddress currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationHasAddress.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			EducationHasAddressIterator theEducationHasAddressIterator = (EducationHasAddressIterator)findAncestorWithClass(this, EducationHasAddressIterator.class);
			pageContext.getOut().print(theEducationHasAddressIterator.getHasAddress());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for hasAddress tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for hasAddress tag ");
		}
		return SKIP_BODY;
	}
}

