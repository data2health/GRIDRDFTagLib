package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Other theOther = (Other)findAncestorWithClass(this, Other.class);
			if (!theOther.commitNeeded) {
				pageContext.getOut().print(theOther.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Other for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Other theOther = (Other)findAncestorWithClass(this, Other.class);
			return theOther.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Other for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Other theOther = (Other)findAncestorWithClass(this, Other.class);
			theOther.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Other for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for label tag ");
		}
	}
}

