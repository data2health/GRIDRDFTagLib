package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveWikipediaPage extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveWikipediaPage currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveWikipediaPage.class);

	// non-functional property

	public int doStartTag() throws JspException {
		try {
			ArchiveWikipediaPageIterator theArchive = (ArchiveWikipediaPageIterator)findAncestorWithClass(this, ArchiveWikipediaPageIterator.class);
			pageContext.getOut().print(theArchive.getWikipediaPage());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for wikipediaPage tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for wikipediaPage tag ");
		}
		return SKIP_BODY;
	}
}

