package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanySubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanySubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanySubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Company theCompany = (Company)findAncestorWithClass(this, Company.class);
			if (!theCompany.commitNeeded) {
				pageContext.getOut().print(theCompany.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Company for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Company theCompany = (Company)findAncestorWithClass(this, Company.class);
			return theCompany.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Company for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Company theCompany = (Company)findAncestorWithClass(this, Company.class);
			theCompany.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Company for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for subjectURI tag ");
		}
	}
}

