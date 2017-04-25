package edu.uiowa.slis.GRIDRDF.Address;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class AddressLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static AddressLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(AddressLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Address theAddress = (Address)findAncestorWithClass(this, Address.class);
			if (!theAddress.commitNeeded) {
				pageContext.getOut().print(theAddress.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Address for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Address theAddress = (Address)findAncestorWithClass(this, Address.class);
			return theAddress.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Address for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Address theAddress = (Address)findAncestorWithClass(this, Address.class);
			theAddress.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Address for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Address for label tag ");
		}
	}
}

