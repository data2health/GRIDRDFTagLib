package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			OtherEstablishedYearIterator theOther = (OtherEstablishedYearIterator)findAncestorWithClass(this, OtherEstablishedYearIterator.class);
			pageContext.getOut().print(theOther.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Other for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

