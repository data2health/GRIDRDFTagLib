package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveId extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveId currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveId.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			ArchiveIdIterator theArchive = (ArchiveIdIterator)findAncestorWithClass(this, ArchiveIdIterator.class);
			pageContext.getOut().print(theArchive.getId());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for id tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for id tag ");
		}
		return SKIP_BODY;
	}
}

