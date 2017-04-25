package edu.uiowa.slis.GRIDRDF.Company;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class CompanyLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static CompanyLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(CompanyLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Company theCompany = (Company)findAncestorWithClass(this, Company.class);
			if (!theCompany.commitNeeded) {
				pageContext.getOut().print(theCompany.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Company for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Company theCompany = (Company)findAncestorWithClass(this, Company.class);
			return theCompany.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Company for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Company theCompany = (Company)findAncestorWithClass(this, Company.class);
			theCompany.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Company for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Company for label tag ");
		}
	}
}

