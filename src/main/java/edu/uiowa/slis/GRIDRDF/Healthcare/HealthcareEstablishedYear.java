package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			HealthcareEstablishedYearIterator theHealthcare = (HealthcareEstablishedYearIterator)findAncestorWithClass(this, HealthcareEstablishedYearIterator.class);
			pageContext.getOut().print(theHealthcare.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

