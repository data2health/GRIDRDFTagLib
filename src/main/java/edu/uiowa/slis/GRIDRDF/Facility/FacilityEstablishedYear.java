package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			FacilityEstablishedYearIterator theFacility = (FacilityEstablishedYearIterator)findAncestorWithClass(this, FacilityEstablishedYearIterator.class);
			pageContext.getOut().print(theFacility.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

