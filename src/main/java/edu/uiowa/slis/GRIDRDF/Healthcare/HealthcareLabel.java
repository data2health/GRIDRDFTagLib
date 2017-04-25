package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Healthcare theHealthcare = (Healthcare)findAncestorWithClass(this, Healthcare.class);
			if (!theHealthcare.commitNeeded) {
				pageContext.getOut().print(theHealthcare.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Healthcare theHealthcare = (Healthcare)findAncestorWithClass(this, Healthcare.class);
			return theHealthcare.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Healthcare for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Healthcare theHealthcare = (Healthcare)findAncestorWithClass(this, Healthcare.class);
			theHealthcare.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for label tag ");
		}
	}
}

