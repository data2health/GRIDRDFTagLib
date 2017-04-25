package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Government theGovernment = (Government)findAncestorWithClass(this, Government.class);
			if (!theGovernment.commitNeeded) {
				pageContext.getOut().print(theGovernment.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Government for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Government theGovernment = (Government)findAncestorWithClass(this, Government.class);
			return theGovernment.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Government for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Government theGovernment = (Government)findAncestorWithClass(this, Government.class);
			theGovernment.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Government for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for label tag ");
		}
	}
}

