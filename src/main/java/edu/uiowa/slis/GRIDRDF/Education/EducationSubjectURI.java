package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationSubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationSubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationSubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Education theEducation = (Education)findAncestorWithClass(this, Education.class);
			if (!theEducation.commitNeeded) {
				pageContext.getOut().print(theEducation.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Education for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Education theEducation = (Education)findAncestorWithClass(this, Education.class);
			return theEducation.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Education for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Education theEducation = (Education)findAncestorWithClass(this, Education.class);
			theEducation.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Education for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for subjectURI tag ");
		}
	}
}

