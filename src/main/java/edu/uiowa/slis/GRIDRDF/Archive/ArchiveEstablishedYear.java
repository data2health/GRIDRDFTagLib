package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveEstablishedYear extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveEstablishedYear currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveEstablishedYear.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			ArchiveEstablishedYearIterator theArchive = (ArchiveEstablishedYearIterator)findAncestorWithClass(this, ArchiveEstablishedYearIterator.class);
			pageContext.getOut().print(theArchive.getEstablishedYear());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for establishedYear tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for establishedYear tag ");
		}
		return SKIP_BODY;
	}
}

