package edu.uiowa.slis.GRIDRDF.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class AddressSubjectURI extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static AddressSubjectURI currentInstance = null;
	private static final Log log = LogFactory.getLog(AddressSubjectURI.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Address theAddress = (Address)findAncestorWithClass(this, Address.class);
			if (!theAddress.commitNeeded) {
				pageContext.getOut().print(theAddress.getSubjectURI());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Address for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for subjectURI tag ");
		}
		return SKIP_BODY;
	}

	public String getSubjectURI() throws JspTagException {
		try {
			Address theAddress = (Address)findAncestorWithClass(this, Address.class);
			return theAddress.getSubjectURI();
		} catch (Exception e) {
			log.error(" Can't find enclosing Address for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for subjectURI tag ");
		}
	}

	public void setSubjectURI(String subjectURI) throws JspTagException {
		try {
			Address theAddress = (Address)findAncestorWithClass(this, Address.class);
			theAddress.setSubjectURI(subjectURI);
		} catch (Exception e) {
			log.error("Can't find enclosing Address for subjectURI tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for subjectURI tag ");
		}
	}
}

