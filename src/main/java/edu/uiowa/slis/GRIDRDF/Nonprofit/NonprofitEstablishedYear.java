package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			NonprofitEstablishedYearIterator theNonprofit = (NonprofitEstablishedYearIterator)findAncestorWithClass(this, NonprofitEstablishedYearIterator.class);
			pageContext.getOut().print(theNonprofit.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

