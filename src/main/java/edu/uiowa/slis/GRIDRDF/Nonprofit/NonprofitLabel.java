package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Nonprofit theNonprofit = (Nonprofit)findAncestorWithClass(this, Nonprofit.class);
			if (!theNonprofit.commitNeeded) {
				pageContext.getOut().print(theNonprofit.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Nonprofit theNonprofit = (Nonprofit)findAncestorWithClass(this, Nonprofit.class);
			return theNonprofit.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Nonprofit for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Nonprofit theNonprofit = (Nonprofit)findAncestorWithClass(this, Nonprofit.class);
			theNonprofit.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for label tag ");
		}
	}
}

