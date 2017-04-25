package edu.uiowa.slis.GRIDRDF.Nonprofit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class NonprofitSubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static NonprofitSubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(NonprofitSubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Nonprofit theNonprofit = (Nonprofit)findAncestorWithClass(this, Nonprofit.class);
			if (!theNonprofit.commitNeeded) {
				pageContext.getOut().print(theNonprofit.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Nonprofit theNonprofit = (Nonprofit)findAncestorWithClass(this, Nonprofit.class);
			return theNonprofit.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Nonprofit for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Nonprofit theNonprofit = (Nonprofit)findAncestorWithClass(this, Nonprofit.class);
			theNonprofit.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Nonprofit for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Nonprofit for subjectURI tag ");
		}
	}
}

