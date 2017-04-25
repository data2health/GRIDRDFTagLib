package edu.uiowa.slis.GRIDRDF.Education;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class EducationEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static EducationEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(EducationEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			EducationEstablishedYearIterator theEducation = (EducationEstablishedYearIterator)findAncestorWithClass(this, EducationEstablishedYearIterator.class);
			pageContext.getOut().print(theEducation.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Education for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Education for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

