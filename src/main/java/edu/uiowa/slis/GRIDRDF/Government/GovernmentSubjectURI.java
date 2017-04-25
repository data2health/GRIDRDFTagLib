package edu.uiowa.slis.GRIDRDF.Government;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class GovernmentSubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static GovernmentSubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(GovernmentSubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Government theGovernment = (Government)findAncestorWithClass(this, Government.class);
			if (!theGovernment.commitNeeded) {
				pageContext.getOut().print(theGovernment.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Government for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Government theGovernment = (Government)findAncestorWithClass(this, Government.class);
			return theGovernment.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Government for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Government theGovernment = (Government)findAncestorWithClass(this, Government.class);
			theGovernment.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Government for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Government for subjectURI tag ");
		}
	}
}

