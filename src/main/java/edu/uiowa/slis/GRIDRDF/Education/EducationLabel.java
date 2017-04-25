package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Education theEducation = (Education)findAncestorWithClass(this, Education.class);
			if (!theEducation.commitNeeded) {
				pageContext.getOut().print(theEducation.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Education for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Education theEducation = (Education)findAncestorWithClass(this, Education.class);
			return theEducation.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Education for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Education theEducation = (Education)findAncestorWithClass(this, Education.class);
			theEducation.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Education for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for label tag ");
		}
	}
}

