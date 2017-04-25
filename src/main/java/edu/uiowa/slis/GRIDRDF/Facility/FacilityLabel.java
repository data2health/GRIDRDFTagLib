package edu.uiowa.slis.GRIDRDF.Facility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class FacilityLabel extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static FacilityLabel currentInstance = null;
	private static final Log log = LogFactory.getLog(FacilityLabel.class);

	// functional property

	public int doStartTag() throws JspException {
		try {
			Facility theFacility = (Facility)findAncestorWithClass(this, Facility.class);
			if (!theFacility.commitNeeded) {
				pageContext.getOut().print(theFacility.getLabel());
			}
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for label tag ");
		}
		return SKIP_BODY;
	}

	public String getLabel() throws JspTagException {
		try {
			Facility theFacility = (Facility)findAncestorWithClass(this, Facility.class);
			return theFacility.getLabel();
		} catch (Exception e) {
			log.error(" Can't find enclosing Facility for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for label tag ");
		}
	}

	public void setLabel(String label) throws JspTagException {
		try {
			Facility theFacility = (Facility)findAncestorWithClass(this, Facility.class);
			theFacility.setLabel(label);
		} catch (Exception e) {
			log.error("Can't find enclosing Facility for label tag ", e);
			throw new JspTagException("Error: Can't find enclosing Facility for label tag ");
		}
	}
}

