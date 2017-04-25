package edu.uiowa.slis.GRIDRDF.Healthcare;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class HealthcareSubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static HealthcareSubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(HealthcareSubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Healthcare theHealthcare = (Healthcare)findAncestorWithClass(this, Healthcare.class);
			if (!theHealthcare.commitNeeded) {
				pageContext.getOut().print(theHealthcare.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Healthcare theHealthcare = (Healthcare)findAncestorWithClass(this, Healthcare.class);
			return theHealthcare.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Healthcare for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Healthcare theHealthcare = (Healthcare)findAncestorWithClass(this, Healthcare.class);
			theHealthcare.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Healthcare for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Healthcare for subjectURI tag ");
		}
	}
}

