package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			GovernmentEstablishedYearIterator theGovernment = (GovernmentEstablishedYearIterator)findAncestorWithClass(this, GovernmentEstablishedYearIterator.class);
			pageContext.getOut().print(theGovernment.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Government for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

