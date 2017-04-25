package edu.uiowa.slis.GRIDRDF.Other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class OtherSubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static OtherSubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(OtherSubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Other theOther = (Other)findAncestorWithClass(this, Other.class);
			if (!theOther.commitNeeded) {
				pageContext.getOut().print(theOther.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Other for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Other theOther = (Other)findAncestorWithClass(this, Other.class);
			return theOther.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Other for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Other theOther = (Other)findAncestorWithClass(this, Other.class);
			theOther.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Other for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Other for subjectURI tag ");
		}
	}
}

